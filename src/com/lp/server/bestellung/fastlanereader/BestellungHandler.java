/*******************************************************************************
 * HELIUM V, Open Source ERP software for sustained success
 * at small and medium-sized enterprises.
 * Copyright (C) 2004 - 2014 HELIUM V IT-Solutions GmbH
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published 
 * by the Free Software Foundation, either version 3 of theLicense, or 
 * (at your option) any later version.
 * 
 * According to sec. 7 of the GNU Affero General Public License, version 3, 
 * the terms of the AGPL are supplemented with the following terms:
 * 
 * "HELIUM V" and "HELIUM 5" are registered trademarks of 
 * HELIUM V IT-Solutions GmbH. The licensing of the program under the 
 * AGPL does not imply a trademark license. Therefore any rights, title and
 * interest in our trademarks remain entirely with us. If you want to propagate
 * modified versions of the Program under the name "HELIUM V" or "HELIUM 5",
 * you may only do so if you have a written permission by HELIUM V IT-Solutions 
 * GmbH (to acquire a permission please contact HELIUM V IT-Solutions
 * at trademark@heliumv.com).
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contact: developers@heliumv.com
 ******************************************************************************/
package com.lp.server.bestellung.fastlanereader;

import java.awt.Color;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.Icon;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lp.server.artikel.service.ArtikelFac;
import com.lp.server.benutzer.service.RechteFac;
import com.lp.server.bestellung.fastlanereader.generated.FLRBestellung;
import com.lp.server.bestellung.service.BestellungDto;
import com.lp.server.bestellung.service.BestellungFac;
import com.lp.server.partner.service.KundeFac;
import com.lp.server.partner.service.LieferantDto;
import com.lp.server.partner.service.LieferantFac;
import com.lp.server.partner.service.PartnerFac;
import com.lp.server.system.fastlanereader.generated.FLRLandplzort;
import com.lp.server.system.jcr.service.PrintInfoDto;
import com.lp.server.system.jcr.service.docnode.DocNodeBestellung;
import com.lp.server.system.jcr.service.docnode.DocPath;
import com.lp.server.system.service.ParameterFac;
import com.lp.server.system.service.ParametermandantDto;
import com.lp.server.system.service.SystemFac;
import com.lp.server.util.Facade;
import com.lp.server.util.fastlanereader.FLRSessionFactory;
import com.lp.server.util.fastlanereader.UseCaseHandler;
import com.lp.server.util.fastlanereader.service.query.FilterBlock;
import com.lp.server.util.fastlanereader.service.query.FilterKriterium;
import com.lp.server.util.fastlanereader.service.query.QueryParameters;
import com.lp.server.util.fastlanereader.service.query.QueryResult;
import com.lp.server.util.fastlanereader.service.query.SortierKriterium;
import com.lp.server.util.fastlanereader.service.query.TableInfo;
import com.lp.util.EJBExceptionLP;

/**
 * 
 * <p>
 * Diese Klasse kuemmert sich um den Bestellungs-FLR.
 * </p>
 * 
 * <p>
 * Copyright Logistik Pur Software GmbH (c) 2004-2007
 * </p>
 * 
 * <p>
 * Erstellung: Josef Erlinger; dd.mm.05
 * </p>
 * 
 * <p>
 * 
 * @author $Author: robert $
 *         </p>
 * 
 * @version not attributable Date $Date: 2013/01/19 11:47:31 $
 */
public class BestellungHandler extends UseCaseHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer iAnlegerStattVertreterAnzeigen = 0;
	int bLosnummerAuftragsbezogen = 0;
	boolean bProjektStattOrt = false;

	/**
	 * gets the data page for the specified row using the current query. The row
	 * at rowIndex will be located in the middle of the page.
	 * 
	 * @see UseCaseHandler#getPageAt(java.lang.Integer)
	 * @param rowIndex
	 *            Integer
	 * @throws EJBExceptionLP
	 * @return QueryResult
	 */
	public QueryResult getPageAt(Integer rowIndex) throws EJBExceptionLP {

		QueryResult result = null;
		SessionFactory factory = FLRSessionFactory.getFactory();
		Session session = null;
		try {
			int colCount = getTableInfo().getColumnClasses().length;
			int pageSize = PAGE_SIZE;
			int startIndex = Math.max(rowIndex.intValue() - (pageSize / 2), 0);
			int endIndex = startIndex + pageSize - 1;

			session = factory.openSession();
			String queryString = "SELECT distinct bestellung ,bestellung.flrlieferant.flrpartner.c_name1nachnamefirmazeile1,bestellung.flrpersonal.c_kurzzeichen, bestellung.flrlieferant.flrpartner.flrlandplzort.flrland.c_lkz, bestellung.flrlieferant.flrpartner.flrlandplzort.c_plz "
					+ this.getFromClause()
					+ this.buildWhereClause()
					+ this.buildOrderByClause();

			Query query = session.createQuery(queryString);
			query.setFirstResult(startIndex);
			query.setMaxResults(pageSize);
			List<?> resultList = query.list();
			Iterator<?> resultListIterator = resultList.iterator();
			Object[][] rows = new Object[resultList.size()][colCount];

			// darf Preise sehen.
			final boolean bDarfPreiseSehen = getTheJudgeFac().hatRecht(
					RechteFac.RECHT_LP_DARF_PREISE_SEHEN_EINKAUF, theClientDto);

			int row = 0;
			int col = 0;
			while (resultListIterator.hasNext()) {
				// da kommt jetzt ein Array zurueck, das an index 0 brauch ich

				Object[] o = (Object[]) resultListIterator.next();

				FLRBestellung bestellung = (FLRBestellung) o[0];
				// 1
				rows[row][col++] = bestellung.getI_id();

				String bestellungart = null;
				if (bestellung.getBestellungart_c_nr().equals(
						BestellungFac.BESTELLUNGART_ABRUFBESTELLUNG_C_NR)) {
					bestellungart = BestellungFac.BESTELLUNGART_ABRUFBESTELLUNG_C_NR_KURZ;
				} else if (bestellung.getBestellungart_c_nr().equals(
						BestellungFac.BESTELLUNGART_RAHMENBESTELLUNG_C_NR)) {
					bestellungart = BestellungFac.BESTELLUNGART_RAHMENBESTELLUNG_C_NR_KURZ;
				} else if (bestellung.getBestellungart_c_nr().equals(
						BestellungFac.BESTELLUNGART_LEIHBESTELLUNG_C_NR)) {
					bestellungart = BestellungFac.BESTELLUNGART_LEIHBESTELLUNG_C_NR_KURZ;
				}
				// 2
				rows[row][col++] = bestellungart;
				// 3
				rows[row][col++] = bestellung.getC_nr();
				// 4
				rows[row][col++] = bestellung.getFlrlieferant() == null ? null
						: bestellung.getFlrlieferant().getFlrpartner()
								.getC_name1nachnamefirmazeile1();

				// wenn vorhanden, dann im Format A-5020 Salzburg, Bahnhoftrasse
				// 1
				if (bProjektStattOrt) {
					rows[row][col++] = bestellung.getC_bezprojektbezeichnung();
				} else {

					FLRLandplzort anschrift = bestellung.getFlrlieferant()
							.getFlrpartner().getFlrlandplzort();
					if (anschrift != null) {
						rows[row][col++] = anschrift.getFlrland().getC_lkz()
								+ "-" + anschrift.getC_plz() + " "
								+ anschrift.getFlrort().getC_name();
					} else {
						rows[row][col++] = "";
					}
				}
				rows[row][col++] = bestellung.getT_liefertermin() == null ? null
						: bestellung.getT_liefertermin();
				rows[row][col++] = bestellung.getT_belegdatum() == null ? null
						: bestellung.getT_belegdatum();

				if (iAnlegerStattVertreterAnzeigen == 1) {
					rows[row][col++] = bestellung.getFlrpersonalanleger() == null ? null
							: bestellung.getFlrpersonalanleger()
									.getC_kurzzeichen();
				} else if (iAnlegerStattVertreterAnzeigen == 2) {
					rows[row][col++] = bestellung.getFlrpersonalaenderer() == null ? null
							: bestellung.getFlrpersonalaenderer()
									.getC_kurzzeichen();
				} else {
					rows[row][col++] = bestellung.getFlrpersonal() == null ? null
							: bestellung.getFlrpersonal().getC_kurzzeichen();
				}

				BigDecimal nGesamtwertBestellungInBestellwaehrung = new BigDecimal(
						0);

				if (bestellung.getN_bestellwert() != null
						&& !bestellung.getBestellungstatus_c_nr().equals(
								BestellungFac.BESTELLSTATUS_STORNIERT)) {
					nGesamtwertBestellungInBestellwaehrung = bestellung
							.getN_bestellwert();
				}
				// status: uebersetzung reinschreiben
				String sStatus = bestellung.getBestellungstatus_c_nr();
				rows[row][col++] = getStatusMitUebersetzung(sStatus,
						bestellung.getT_versandzeitpunkt(),
						bestellung.getC_versandtype());

				if (bDarfPreiseSehen) {
					rows[row][col++] = nGesamtwertBestellungInBestellwaehrung;
				} else {
					rows[row][col++] = null;
				}

				rows[row][col++] = bestellung
						.getWaehrung_c_nr_bestellwaehrung() == null ? null
						: bestellung.getWaehrung_c_nr_bestellwaehrung();
				rows[row][col++] = bestellung.getMahnstufe_i_id() == null ? null
						: bestellung.getMahnstufe_i_id();

				if (bestellung.getB_poenale().equals(new Short((short) 1))) {
					rows[row][col++] = Color.RED;
				} else {
					rows[row][col++] = null;
				}

				row++;
				col = 0;
			}
			result = new QueryResult(rows, this.getRowCount(), startIndex,
					endIndex, 0);
		} catch (Exception e) {
			throw new EJBExceptionLP(EJBExceptionLP.FEHLER_FLR, e);
		} finally {
			closeSession(session);
		}
		return result;
	}

	/**
	 * gets the total number of rows represented by the current query.
	 * 
	 * @see UseCaseHandler#getRowCountFromDataBase()
	 * @return int
	 */
	protected long getRowCountFromDataBase() {
		long rowCount = 0;
		SessionFactory factory = FLRSessionFactory.getFactory();
		Session session = null;
		try {
			ParametermandantDto parameter = getParameterFac()
					.getMandantparameter(
							theClientDto.getMandant(),
							ParameterFac.KATEGORIE_ALLGEMEIN,
							ParameterFac.PARAMETER_ANZEIGE_ANLEGER_STATT_VERTRETER);
			iAnlegerStattVertreterAnzeigen = (Integer) parameter
					.getCWertAsObject();

		} catch (RemoteException ex) {
			throw new EJBExceptionLP(EJBExceptionLP.FEHLER, ex);
		}
		try {
			session = factory.openSession();
			String queryString = "select count(distinct bestellung) "
					+ this.getFromClause() + this.buildWhereClause();

			Query query = session.createQuery(queryString);
			List<?> rowCountResult = query.list();
			if (rowCountResult != null && rowCountResult.size() > 0) {
				rowCount = ((Long) rowCountResult.get(0)).longValue();
			}
		} catch (Exception e) {
			throw new EJBExceptionLP(EJBExceptionLP.FEHLER, e);
		} finally {
			closeSession(session);
		}
		return rowCount;
	}

	/**
	 * builds the where clause of the HQL (Hibernate Query Language) statement
	 * using the current query.
	 * 
	 * @return the HQL where clause.
	 */
	private String buildWhereClause() {
		StringBuffer where = new StringBuffer("");

		if (this.getQuery() != null && this.getQuery().getFilterBlock() != null
				&& this.getQuery().getFilterBlock().filterKrit != null) {

			FilterBlock filterBlock = this.getQuery().getFilterBlock();
			FilterKriterium[] filterKriterien = this.getQuery()
					.getFilterBlock().filterKrit;
			String booleanOperator = filterBlock.boolOperator;
			boolean filterAdded = false;

			for (int i = 0; i < filterKriterien.length; i++) {
				if (filterKriterien[i].isKrit) {
					if (filterAdded) {
						where.append(" " + booleanOperator);
					}
					filterAdded = true;

					// wenn nach der c_nr gefilter wird, wird das kriterium
					// veraendert
					if (filterKriterien[i].kritName.equals("c_nr")) {
						try {
							String sValue = super.buildWhereBelegnummer(
									filterKriterien[i], false);
							// Belegnummernsuche auch in "altem" Jahr, wenn im
							// neuen noch keines vorhanden ist
							if (!istBelegnummernInJahr("FLRBestellung", sValue)) {
								sValue = super.buildWhereBelegnummer(
										filterKriterien[i], true);
							}
							where.append(" bestellung."
									+ filterKriterien[i].kritName);
							where.append(" " + filterKriterien[i].operator);
							where.append(" " + sValue);
						} catch (Throwable ex) {
							throw new EJBExceptionLP(EJBExceptionLP.FEHLER_FLR,
									new Exception(ex));
						}
					} else if (filterKriterien[i].kritName
							.equals("bestpos.flrlossollmaterial.flrlos.c_nr")) {

						try {
							String sValue = super.buildWhereBelegnummer(
									filterKriterien[i], false);

							if (bLosnummerAuftragsbezogen >= 1) {
								if (sValue != null) {
									if (sValue != null && sValue.length() > 11) {
										sValue = sValue.replaceFirst("00", "");
									}
									sValue = sValue.substring(0,
											sValue.length() - 1);
									sValue = sValue + "%'";
								}
							}

							// Belegnummernsuche auch in "altem" Jahr, wenn im
							// neuen noch keines vorhanden ist
							if (!istBelegnummernInJahr("FLRLos", sValue)) {
								sValue = super.buildWhereBelegnummer(
										filterKriterien[i], true);

								if (bLosnummerAuftragsbezogen >= 1) {
									if (sValue != null) {
										if (sValue != null
												&& sValue.length() > 11) {
											sValue = sValue.replaceFirst("00",
													"");
										}
										sValue = sValue.substring(0,
												sValue.length() - 1);
										sValue = sValue + "%'";
									}
								}

							}
							where.append(" " + filterKriterien[i].kritName);
							where.append(" " + filterKriterien[i].operator);
							where.append(" " + sValue);
						} catch (Throwable ex) {
							throw new EJBExceptionLP(EJBExceptionLP.FEHLER_FLR,
									new Exception(ex));
						}
					} else if (filterKriterien[i].kritName.equals("c_suche")) {

						if (filterKriterien[i].isBIgnoreCase()) {
							where.append(" lower(" + "bestellung."
									+ "flrbestellungtextsuche."
									+ filterKriterien[i].kritName + ")");
						} else {
							where.append(" " + "bestellung."
									+ "flrbestellungtextsuche."
									+ filterKriterien[i].kritName);
						}

						where.append(" " + filterKriterien[i].operator);

						if (filterKriterien[i].isBIgnoreCase()) {
							where.append(" "
									+ filterKriterien[i].value.toLowerCase());
						} else {
							where.append(" " + filterKriterien[i].value);
						}

					} else if (filterKriterien[i].kritName
							.equals(ArtikelFac.FLR_ARTIKELLIEFERANT_FLRLIEFERANT
									+ "."
									+ KundeFac.FLR_PARTNER_NAME1NACHNAMEFIRMAZEILE1)) {
						ParametermandantDto parameter = null;
						try {
							parameter = getParameterFac()
									.getMandantparameter(
											theClientDto.getMandant(),
											ParameterFac.KATEGORIE_ALLGEMEIN,
											ParameterFac.PARAMETER_SUCHEN_INKLUSIVE_KBEZ);
						} catch (RemoteException ex) {
							throwEJBExceptionLPRespectOld(ex);
						}
						Boolean bSuchenInklusiveKbez = (java.lang.Boolean) parameter
								.getCWertAsObject();
						if (bSuchenInklusiveKbez) {
							if (filterKriterien[i].isBIgnoreCase()) {
								where.append(" (lower(bestellung."
										+ filterKriterien[i].kritName + ")");
								where.append(" " + filterKriterien[i].operator);
								where.append(" "
										+ filterKriterien[i].value
												.toLowerCase());
								where.append(" OR lower(bestellung.flrlieferant.flrpartner.c_kbez)");
								where.append(" " + filterKriterien[i].operator);
								where.append(" "
										+ filterKriterien[i].value
												.toLowerCase() + ")");
							} else {
								where.append(" bestellung."
										+ filterKriterien[i].kritName);
								where.append(" " + filterKriterien[i].operator);
								where.append(" " + filterKriterien[i].value);
								where.append(" OR flrlieferant.flrpartner.c_kbez)");
								where.append(" " + filterKriterien[i].operator);
								where.append(" " + filterKriterien[i].value);
							}
						} else {
							if (filterKriterien[i].isBIgnoreCase()) {
								where.append(" lower(bestellung."
										+ filterKriterien[i].kritName + ")");
							} else {
								where.append(" bestellung."
										+ filterKriterien[i].kritName);
							}

							where.append(" " + filterKriterien[i].operator);

							if (filterKriterien[i].isBIgnoreCase()) {
								where.append(" "
										+ filterKriterien[i].value
												.toLowerCase());
							} else {
								where.append(" " + filterKriterien[i].value);
							}
						}
					} else {
						if (filterKriterien[i].isBIgnoreCase()) {
							where.append(" lower(bestellung."
									+ filterKriterien[i].kritName + ")");
						} else {
							where.append(" bestellung."
									+ filterKriterien[i].kritName);
						}

						where.append(" " + filterKriterien[i].operator);

						if (filterKriterien[i].isBIgnoreCase()) {
							where.append(" "
									+ filterKriterien[i].value.toLowerCase());
						} else {
							where.append(" " + filterKriterien[i].value);
						}
					}
				}
			}
			if (filterAdded) {
				where.insert(0, " WHERE");
			}
		}

		return where.toString();
	}

	/**
	 * builds the HQL (Hibernate Query Language) order by clause using the sort
	 * criterias contained in the current query.
	 * 
	 * @return the HQL order by clause.
	 */
	private String buildOrderByClause() {
		StringBuffer orderBy = new StringBuffer("");
		if (this.getQuery() != null) {
			SortierKriterium[] kriterien = this.getQuery().getSortKrit();
			boolean sortAdded = false;
			if (kriterien != null && kriterien.length > 0) {
				for (int i = 0; i < kriterien.length; i++) {
					if (!kriterien[i].kritName
							.endsWith(Facade.NICHT_SORTIERBAR)) {
						if (kriterien[i].isKrit) {
							if (sortAdded) {
								orderBy.append(", ");
							}
							sortAdded = true;
							orderBy.append("bestellung."
									+ kriterien[i].kritName);
							orderBy.append(" ");
							orderBy.append(kriterien[i].value);
						}
					}
				}
			} else {
				// no sort criteria found, add default sort
				if (sortAdded) {
					orderBy.append(", ");
				}
				orderBy.append("bestellung.").append("c_nr").append(" DESC ");
				sortAdded = true;
			}
			if (orderBy.indexOf("bestellung." + "i_id") < 0) {
				// unique sort required because otherwise rowNumber of
				// selectedId
				// within sort() method may be different from the position of
				// selectedId
				// as returned in the page of getPageAt().
				if (sortAdded) {
					orderBy.append(", ");
				}
				orderBy.append("bestellung.").append("i_id").append(" ")
						.append(" DESC");
				sortAdded = true;
			}
			if (sortAdded) {
				orderBy.insert(0, " ORDER BY ");
			}
		}
		return orderBy.toString();
	}

	/**
	 * get the basic from clause for the HQL statement.
	 * 
	 * @return the from clause.
	 */
	private String getFromClause() {
		String from = "from FLRBestellung as bestellung "
				+ " left join bestellung.flrlieferant.flrpartner.flrlandplzort as flrlandplzort "
				+ " left join bestellung.flrlieferant.flrpartner.flrlandplzort.flrort as flrort "
				+ " left join bestellung.flrlieferant.flrpartner.flrlandplzort.flrland as flrland "
				+ " left join bestellung.flrpersonal as flrpersonal ";

		// PJ17978
		FilterKriterium[] filterKriterien = this.getQuery().getFilterBlock().filterKrit;
		for (int i = 0; i < filterKriterien.length; i++) {
			if (filterKriterien[i].isKrit) {
				if (filterKriterien[i].kritName
						.equals("bestpos.flrlossollmaterial.flrlos.c_nr")) {
					from += " LEFT JOIN bestellung.bestellpositionen AS bestpos ";
				}
			}
		}

		return from;

	}

	/**
	 * sorts the data described by the current query using the specified sort
	 * criterias. The current query is also updated with the new sort criterias.
	 * 
	 * @see UseCaseHandler#sort(SortierKriterium[], Object)
	 * @throws EJBExceptionLP
	 * @param sortierKriterien
	 *            SortierKriterium[]
	 * @param selectedId
	 *            Object
	 * @return QueryResult
	 */
	public QueryResult sort(SortierKriterium[] sortierKriterien,
			Object selectedId) throws EJBExceptionLP {

		this.getQuery().setSortKrit(sortierKriterien);

		QueryResult result = null;
		int rowNumber = 0;

		if (selectedId != null && ((Integer) selectedId).intValue() >= 0) {
			SessionFactory factory = FLRSessionFactory.getFactory();
			Session session = null;

			try {
				session = factory.openSession();
				String queryString = "select distinct bestellung.i_id, bestellung.flrlieferant.flrpartner.c_name1nachnamefirmazeile1, bestellung.flrlieferant.flrpartner.flrlandplzort.flrland.c_lkz, bestellung.flrlieferant.flrpartner.flrlandplzort.c_plz, bestellung.flrpersonal.c_kurzzeichen, bestellung.waehrung_c_nr_bestellwaehrung, bestellung.bestellungstatus_c_nr, bestellung.n_bestellwert, "
						+ " bestellung.c_nr, bestellung.mahnstufe_i_id, bestellung.c_bezprojektbezeichnung, bestellung.t_liefertermin, bestellung.t_belegdatum "
						+ getFromClause()
						+ this.buildWhereClause()
						+ this.buildOrderByClause();

				Query query = session.createQuery(queryString);
				ScrollableResults scrollableResult = query.scroll();
				if (scrollableResult != null) {
					scrollableResult.beforeFirst();
					while (scrollableResult.next()) {
						Integer id = (Integer) scrollableResult.getInteger(0);
						if (selectedId.equals(id)) {
							rowNumber = scrollableResult.getRowNumber();
							break;
						}
					}
				}

			} catch (Exception e) {
				throw new EJBExceptionLP(EJBExceptionLP.FEHLER, e);
			} finally {
				closeSession(session);
			}
		}

		if (rowNumber < 0 || rowNumber >= this.getRowCount()) {
			rowNumber = 0;
		}

		result = this.getPageAt(new Integer(rowNumber));
		result.setIndexOfSelectedRow(rowNumber);

		return result;
	}

	/**
	 * gets information about the Bestellungstable.
	 * 
	 * @return TableInfo
	 */
	public TableInfo getTableInfo() {
		if (super.getTableInfo() == null) {

			try {
				ParametermandantDto parameter = getParameterFac()
						.getMandantparameter(
								theClientDto.getMandant(),
								ParameterFac.KATEGORIE_FERTIGUNG,
								ParameterFac.PARAMETER_LOSNUMMER_AUFTRAGSBEZOGEN);
				bLosnummerAuftragsbezogen = (Integer) parameter
						.getCWertAsObject();
				parameter = getParameterFac()
						.getMandantparameter(
								theClientDto.getMandant(),
								ParameterFac.KATEGORIE_BESTELLUNG,
								ParameterFac.PARAMETER_PROJEKT_STATT_ORT_IN_AUSWAHLLISTE);
				bProjektStattOrt = (Boolean) parameter.getCWertAsObject();

			} catch (RemoteException ex) {
				throw new EJBExceptionLP(EJBExceptionLP.FEHLER, ex);
			}

			setTableInfo(new TableInfo(
					new Class[] { Integer.class, String.class, String.class,
							String.class, String.class, Date.class, Date.class,
							String.class, Icon.class, BigDecimal.class,
							String.class, Integer.class, Color.class },
					new String[] {
							"i_id",
							"",
							getTextRespectUISpr("bes.bestnr",
									theClientDto.getMandant(),
									theClientDto.getLocUi()),
							getTextRespectUISpr("bes.lieferant",
									theClientDto.getMandant(),
									theClientDto.getLocUi()),
							bProjektStattOrt ? getTextRespectUISpr(
									"lp.projekt", theClientDto.getMandant(),
									theClientDto.getLocUi())
									: getTextRespectUISpr("lp.ort",
											theClientDto.getMandant(),
											theClientDto.getLocUi()),
							getTextRespectUISpr("bes.liefertermin",
									theClientDto.getMandant(),
									theClientDto.getLocUi()),
							getTextRespectUISpr("bes.belegdatum",
									theClientDto.getMandant(),
									theClientDto.getLocUi()),
							getTextRespectUISpr("bes.anforderer",
									theClientDto.getMandant(),
									theClientDto.getLocUi()),
							getTextRespectUISpr("lp.status",
									theClientDto.getMandant(),
									theClientDto.getLocUi()),
							getTextRespectUISpr("bes.bestellwert",
									theClientDto.getMandant(),
									theClientDto.getLocUi()),
							" ", // Waehrung
							getTextRespectUISpr("lp.mahnstufe",
									theClientDto.getMandant(),
									theClientDto.getLocUi()) },
					new int[] {
							QueryParameters.FLR_BREITE_SHARE_WITH_REST, // id
							QueryParameters.FLR_BREITE_S, // Kuerzel
							// Bestellungart
							QueryParameters.FLR_BREITE_M, // bestellnr.
							// z.B.12345678.92
							QueryParameters.FLR_BREITE_SHARE_WITH_REST, // lieferant
							QueryParameters.FLR_BREITE_SHARE_WITH_REST, // Ort
							QueryParameters.FLR_BREITE_M, // liefertermin
							QueryParameters.FLR_BREITE_M, // belegdatum
							QueryParameters.FLR_BREITE_S,
							QueryParameters.FLR_BREITE_XS,
							QueryParameters.FLR_BREITE_SHARE_WITH_REST, // bestellwert
							QueryParameters.FLR_BREITE_S,
							QueryParameters.FLR_BREITE_XXS },
					new String[] {
							"i_id",
							Facade.NICHT_SORTIERBAR, // BestellungFac.
							// FLRSPALTE_BESTELLUNGART
							// ,
							BestellungFac.FLR_BESTELLUNG_C_NR,

							BestellungFac.FLR_BESTELLUNG_FLRLIEFERANT
									+ "."
									+ LieferantFac.FLR_PARTNER
									+ "."
									+ PartnerFac.FLR_PARTNER_NAME1NACHNAMEFIRMAZEILE1,
							bProjektStattOrt ? BestellungFac.FLR_BESTELLUNG_C_BEZPROJEKTBEZEICHNUNG
									:
									// Sortierung fuers erste mal nach LKZ
									BestellungFac.FLR_BESTELLUNG_FLRLIEFERANT
											+ "."
											+ LieferantFac.FLR_PARTNER
											+ "."
											+ PartnerFac.FLR_PARTNER_FLRLANDPLZORT
											+ "."
											+ SystemFac.FLR_LP_FLRLAND
											+ "."
											+ SystemFac.FLR_LP_LANDLKZ
											+ ", "
											+
											// und dann nach plz
											"bestellung."
											+ BestellungFac.FLR_BESTELLUNG_FLRLIEFERANT
											+ "."
											+ LieferantFac.FLR_PARTNER
											+ "."
											+ PartnerFac.FLR_PARTNER_FLRLANDPLZORT
											+ "."
											+ SystemFac.FLR_LP_LANDPLZORTPLZ,

							BestellungFac.FLR_BESTELLUNG_T_LIEFERTERMIN,
							BestellungFac.FLR_BESTELLUNG_T_BELEGDATUM,
							BestellungFac.FLR_BESTELLUNG_FLRPERSONAL + "."
									+ "c_kurzzeichen",
							BestellungFac.FLR_BESTELLUNG_BESTELLUNGSTATUS_C_NR,
							BestellungFac.FLR_BESTELLUNG_N_BESTELLWERT,
							BestellungFac.FLR_BESTELLUNG_WAEHRUNG_C_NR,
							BestellungFac.FLR_BESTELLUNG_MAHNSTUFE_I_ID }));
		}
		return super.getTableInfo();
	}

	public PrintInfoDto getSDocPathAndPartner(Object key) {
		BestellungDto bestDto = null;
		LieferantDto lieferantDto = null;
		try {
			bestDto = getBestellungFac().bestellungFindByPrimaryKey(
					(Integer) key);
			lieferantDto = getLieferantFac().lieferantFindByPrimaryKeySmall(
					bestDto.getLieferantIIdBestelladresse());
		} catch (Exception e) {
			// Nicht gefunden
		}
		if (bestDto != null) {
			// String sPath = JCRDocFac.HELIUMV_NODE + "/"
			// + theClientDto.getMandant() + "/"
			// + LocaleFac.BELEGART_BESTELLUNG.trim() + "/"
			// + bestDto.getBelegartCNr().trim() + "/"
			// + bestDto.getCNr().replace("/", ".");
			DocPath docPath = new DocPath(new DocNodeBestellung(bestDto));
			Integer sPartnerIId = null;
			if (lieferantDto != null) {
				sPartnerIId = lieferantDto.getPartnerIId();
			}
			return new PrintInfoDto(docPath, sPartnerIId, getSTable());
		} else {
			return null;
		}
	}

	public String getSTable() {
		return "BESTELLUNG";
	}
}
