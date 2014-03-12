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
package com.lp.server.lieferschein.ejbfac;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.lp.server.angebot.service.AngebotReportFac;
import com.lp.server.angebot.service.AngebotServiceFac;
import com.lp.server.artikel.service.ArtgruDto;
import com.lp.server.artikel.service.ArtikelDto;
import com.lp.server.artikel.service.ArtikelFac;
import com.lp.server.artikel.service.LagerDto;
import com.lp.server.artikel.service.MaterialDto;
import com.lp.server.artikel.service.MaterialzuschlagDto;
import com.lp.server.artikel.service.SeriennrChargennrMitMengeDto;
import com.lp.server.artikel.service.VerkaufspreisDto;
import com.lp.server.artikel.service.VerleihDto;
import com.lp.server.artikel.service.VkpreisfindungDto;
import com.lp.server.auftrag.service.AuftragDto;
import com.lp.server.auftrag.service.AuftragReportFac;
import com.lp.server.auftrag.service.AuftragauftragdokumentDto;
import com.lp.server.auftrag.service.AuftragdokumentDto;
import com.lp.server.auftrag.service.AuftragpositionDto;
import com.lp.server.benutzer.service.RechteFac;
import com.lp.server.finanz.service.KontoDto;
import com.lp.server.finanz.service.KontoDtoSmall;
import com.lp.server.lieferschein.fastlanereader.generated.FLRLieferschein;
import com.lp.server.lieferschein.fastlanereader.generated.FLRLieferscheinReportAngelegte;
import com.lp.server.lieferschein.fastlanereader.generated.FLRLieferscheinposition;
import com.lp.server.lieferschein.service.LieferscheinDto;
import com.lp.server.lieferschein.service.LieferscheinFac;
import com.lp.server.lieferschein.service.LieferscheinReportFac;
import com.lp.server.lieferschein.service.LieferscheinServiceFac;
import com.lp.server.lieferschein.service.LieferscheinpositionDto;
import com.lp.server.lieferschein.service.LieferscheinpositionFac;
import com.lp.server.lieferschein.service.LieferscheintextDto;
import com.lp.server.lieferschein.service.ReportLieferscheinAngelegteDto;
import com.lp.server.lieferschein.service.ReportLieferscheinJournalKriterienDto;
import com.lp.server.lieferschein.service.ReportLieferscheinOffeneDto;
import com.lp.server.partner.fastlanereader.generated.FLRKunde;
import com.lp.server.partner.service.AnsprechpartnerDto;
import com.lp.server.partner.service.KundeDto;
import com.lp.server.partner.service.KundeFac;
import com.lp.server.partner.service.KundesokoDto;
import com.lp.server.partner.service.PartnerDto;
import com.lp.server.partner.service.PartnerFac;
import com.lp.server.personal.service.PersonalDto;
import com.lp.server.personal.service.PersonalFac;
import com.lp.server.projekt.service.ProjektDto;
import com.lp.server.rechnung.service.RechnungFac;
import com.lp.server.rechnung.service.RechnungkontierungDto;
import com.lp.server.stueckliste.service.StuecklisteMitStrukturDto;
import com.lp.server.stueckliste.service.StuecklistepositionDto;
import com.lp.server.system.jcr.service.PrintInfoDto;
import com.lp.server.system.pkgenerator.format.LpBelegnummerFormat;
import com.lp.server.system.service.BelegartDto;
import com.lp.server.system.service.KostenstelleDto;
import com.lp.server.system.service.LandDto;
import com.lp.server.system.service.LocaleFac;
import com.lp.server.system.service.MandantDto;
import com.lp.server.system.service.MediaFac;
import com.lp.server.system.service.MediastandardDto;
import com.lp.server.system.service.MwstsatzDto;
import com.lp.server.system.service.ParameterFac;
import com.lp.server.system.service.ParametermandantDto;
import com.lp.server.system.service.ReportJournalKriterienDto;
import com.lp.server.system.service.SpediteurDto;
import com.lp.server.system.service.SystemFac;
import com.lp.server.system.service.TheClientDto;
import com.lp.server.util.BelegPositionDruckIdentDto;
import com.lp.server.util.BelegPositionDruckTextbausteinDto;
import com.lp.server.util.HelperServer;
import com.lp.server.util.LPReport;
import com.lp.server.util.fastlanereader.FLRSessionFactory;
import com.lp.server.util.fastlanereader.service.query.QueryParameters;
import com.lp.server.util.report.JasperPrintLP;
import com.lp.server.util.report.MwstsatzReportDto;
import com.lp.server.util.report.TimingInterceptor;
import com.lp.service.StuecklisteInfoDto;
import com.lp.util.EJBExceptionLP;
import com.lp.util.Helper;
import com.lp.util.LPDatenSubreport;

@Stateless
@Interceptors(TimingInterceptor.class)
public class LieferscheinReportFacBean extends LPReport implements
		JRDataSource, LieferscheinReportFac {

	private String cAktuellerReport = null;
	private Object[][] data = null;

	private final static int FELD_ALLE_LIEFERSCHEINNUMMER = 0;
	private final static int FELD_ALLE_RECHNUNGSNUMMER = 1;
	private final static int FELD_ALLE_BELEGDATUM = 2;
	private final static int FELD_ALLE_KUNDE = 3;
	private final static int FELD_ALLE_KUNDE2 = 4;
	private final static int FELD_ALLE_KOSTENSTELLENUMMER = 5;
	private final static int FELD_ALLE_BETRAG = 6;
	private final static int FELD_ALLE_ORT = 7;
	private final static int FELD_ALLE_DEBITORENKONTO = 8;
	private final static int FELD_ALLE_ADRESSE = 9;
	private final static int FELD_ALLE_VERTRETER = 10;
	private final static int FELD_ALLE_KURS = 11;
	private final static int FELD_ALLE_WAEHRUNG = 12;
	private final static int FELD_ALLE_KUNDE_RECHNUNG = 13;
	private final static int FELD_ALLE_KUNDE2_RECHNUNG = 14;
	private final static int FELD_ALLE_ADRESSE_RECHNUNG = 15;
	private final static int FELD_ALLE_LAENDERART = 16;
	private final static int FELD_ALLE_PROJEKT = 17;
	private final static int FELD_ALLE_STATUS = 18;
	private final static int REPORT_ALLE_ANZAHL_SPALTEN = 19;

	public boolean next() throws JRException {
		index++;
		return (index < data.length);
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;

		String fieldName = field.getName();

		if (cAktuellerReport
				.equals(LieferscheinReportFac.REPORT_LIEFERSCHEIN_ETIKETT)) {

			if ("Adressefuerausdruck".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ADRESSETIKETT];
			}
		} else if (cAktuellerReport
				.equals(LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT)) {
			if ("F_IDENT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_IDENT];
			} else if ("F_MENGE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_MENGE];
			} else if ("F_BEZ".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_BEZ];
			} else if ("F_KBEZ".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_KBEZ];
			} else if ("F_ZBEZ".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_ZBEZ];
			} else if ("F_ZBEZ2".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_ZBEZ2];
			} else if ("F_SERIENCHARGENR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_SERIENCHARGENR];
			} else if ("F_POSITION".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_POSITION];
			} else if ("F_EINHEIT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_EINHEIT];
			} else if ("F_REFERENZNUMMER".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_REFERENZNUMMER];
			} else if ("F_GEWICHT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_GEWICHT];
			} else if ("F_KUNDENARTIKELNUMMER".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_KUNDENARTIKELNUMMER];
			} else if ("F_TEXTEINGABE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_TEXTEINGABE];
			} else if ("WE_REFERENZ".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_WE_REFERENZ];
			} else if ("F_INDEX".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_INDEX];
			} else if ("F_REVISION".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_REVISION];
			}
		} else if (cAktuellerReport
				.equals(LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETTEN)) {
			if ("F_IDENT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_IDENT];
			} else if ("F_MENGE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ANLIEFERMENGE];
			} else if ("F_BEZEICHNUNG".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_BEZ];
			} else if ("F_KURZBEZEICHNUNG".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_KBEZ];
			} else if ("F_ZUSATZBEZEICHNUNG".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_ZBEZ];
			} else if ("F_ZUSATZBEZEICHNUNG2".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_ZBEZ2];
			} else if ("F_SERIENCHARGENR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_SERIENCHARGENR];
			} else if ("F_POSITION".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_POSITION];
			} else if ("F_EINHEIT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_EINHEIT];
			} else if ("F_REFERENZNUMMER".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_REFERENZNUMMER];
			} else if ("F_STUECKGEWICHT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_GEWICHT];
			} else if ("F_KUNDENARTIKELNUMMER".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_KUNDENARTIKELNUMMER];
			} else if ("F_TEXTEINGABE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_TEXTEINGABE];
			} else if ("WE_REFERENZ".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_WE_REFERENZ];
			} else if ("F_INDEX".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_INDEX];
			} else if ("F_REVISION".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_REVISION];
			} else if ("F_PAKETMENGE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_PAKETMENGE];
			} else if ("F_VERPACKUNGSMENGE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_VERPACKUNGSMENGE];
			} else if ("F_AKTUELLESPAKET".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_AKTUELLESPAKET];
			}
		} else if (cAktuellerReport
				.equals(LieferscheinReportFac.REPORT_LIEFERSCHEIN)) {
			if ("Position".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITION];
			}
			if ("POSITION_NR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITION_NR];
			} else if ("Ident".equals(fieldName)) {
				value = Helper
						.formatStyledTextForJasper(data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENT]);
			} else if ("F_LAGER_UEBERSTEUERT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LAGER_UEBERSTEUERT];
			} else if ("Menge".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_MENGE];
			} else if ("KeinLieferrest".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_KEIN_LIEFERREST];
			} else if ("Einheit".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_EINHEIT];
			} else if ("Bestellt".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_BESTELLT];
			} else if ("Lieferrest".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LIEFERREST];
			} else if ("Positionsart".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART];
			} else if ("Freiertext".equals(fieldName)) {
				value = Helper
						.formatStyledTextForJasper(data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_FREIERTEXT]);
			} else if ("Leerzeile".equals(fieldName)) {
				value = Helper
						.formatStyledTextForJasper(data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LEERZEILE]);
			} else if ("Image".equals(fieldName)) {
				value = Helper
						.byteArrayToImage((byte[]) data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IMAGE]);
			} else if ("Seitenumbruch".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH];
			} else if ("F_STKLMENGE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLMENGE];
			} else if ("F_STKLEINHEIT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLEINHEIT];
			} else if ("F_STKLARTIKELCNR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLARTIKELCNR];
			} else if ("F_STKLARTIKELBEZ".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLARTIKELBEZ];
			} else if ("F_STKLARTIKELKBEZ".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLARTIKELKBEZ];
			} else if ("F_STKLARTIKEL_KDARTIKELNR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLARTIKEL_KDARTIKELNR];
			} else if ("F_STKLARTIKEL_KDPREIS".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLARTIKEL_KDPREIS];
			} else if (F_IDENTNUMMER.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENTNUMMER];
			} else if (F_BEZEICHNUNG.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_BEZEICHNUNG];
			} else if ("F_LV_POSITION".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LV_POSITION];
			} else if (F_KURZBEZEICHNUNG.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_KURZBEZEICHNUNG];
			} else if ("AUFTRAG_BESTELLDATUM".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_BESTELLDATUM];
			} else if ("F_POSITIONSOBJEKT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSOBJEKT];
			} else if ("AUFTRAG_BESTELLNUMMER".equals(fieldName)) {
				value = Helper
						.formatStyledTextForJasper(data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_BESTELLNUMMER]);
			} else if ("AUFTRAG_NUMMER".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_NUMMER];
			} else if ("AUFTRAG_PROJEKT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_PROJEKT];
			} else if ("F_WARENVERKEHRSNUMMER".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WARENVERKEHRSNUMMER];
			} else if ("F_SERIENCHARGENR".equals(fieldName)) {
				value = Helper
						.formatStyledTextForJasper(data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SERIENCHARGENR]);
			} else if ("F_SERIENCHARGENR_MENGE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SERIENCHARGENR_MENGE];
			} else if ("F_CHARGE_MINDESTHALTBARKEIT".equals(fieldName)) {
				value = Helper
						.formatStyledTextForJasper(data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_MINDESTHALTBARKEIT]);
			} else if (F_KUNDEARTIKELNR.equals(fieldName)) {
				value = Helper
						.formatStyledTextForJasper(data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_KUNDEARTIKELNR]);
			} else if ("F_KUNDEARTIKELNR_LIEFERADRESSE".equals(fieldName)) {
				value = Helper
						.formatStyledTextForJasper(data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_KUNDEARTIKELNR_LIEFERADRESSE]);
			} else if ("F_VERPACKUNGSMENGE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_VERPACKUNGSMENGE];
			} else if ("F_ARTIKEL_WERBEABGABEPFLICHTIG".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_WERBEABGABEPFLICHTIG];
			} else if ("F_VERPACKUNGSEANNR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_VERPACKUNGSEANNR];
			} else if ("F_VERKAUFSEANNR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_VERKAUFSEANNR];
			} else if ("F_GEWICHT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_GEWICHT];
			} else if ("F_VERPACKUNGSART".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_VERPACKUNGSART];
			} else if (F_REFERENZNUMMER.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_REFERENZNUMMER];
			} else if (F_ZUSATZBEZEICHNUNG2.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKELCZBEZ2];
			} else if (F_ARTIKELKOMMENTAR.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKELKOMMENTAR];
			} else if (F_ZUSATZBEZEICHNUNG.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ZUSATZBEZEICHNUNG];
			} else if (F_ARTIKEL_BAUFORM.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_BAUFORM];
			} else if (F_ARTIKEL_VERPACKUNGSART.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERPACKUNGSART];
			} else if (F_ARTIKEL_MATERIAL.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_MATERIAL];
			} else if (F_ARTIKEL_MATERIALGEWICHT.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_MATERIALGEWICHT];
			} else if (F_ARTIKEL_KURS_MATERIALZUSCHLAG.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_KURS_MATERIALZUSCHLAG];
			} else if (F_ARTIKEL_DATUM_MATERIALZUSCHLAG.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_DATUM_MATERIALZUSCHLAG];
			} else if (F_ARTIKEL_BREITE.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_BREITE];
			} else if (F_ARTIKEL_HOEHE.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_HOEHE];
			} else if (F_ARTIKEL_TIEFE.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_TIEFE];
			} else if (F_ARTIKEL_URSPRUNGSLAND.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_URSPRUNGSLAND];
			} else if ("F_TYP_CNR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_TYP_CNR];
			} else if ("F_IDENT_TEXTEINGABE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENT_TEXTEINGABE];
			} else if ("F_SETARTIKEL_TYP".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SETARTIKEL_TYP];
			} else if ("F_SERIENNUMMERN_DER_SETPOSITIONEN".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SERIENNUMMERN_DER_SETPOSITIONEN];
			} else if ("WE_REFERENZ".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WE_REFERENZ];
			} else if ("F_FIBU_MWST_CODE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_FIBU_MWST_CODE];
			} else if ("F_DOKUMENTENPFLICHTIG".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_DOKUMENTENPFLICHTIG];
			} else if ("F_ARTIKEL_INDEX".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_INDEX];
			} else if ("F_ARTIKEL_REVISION".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_REVISION];
			} else if ("F_VERLEIHTAGE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERLEIHTAGE];
			} else if ("F_VERLEIHFAKTOR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERLEIHFAKTOR];
			} else if ("F_LS_POSITION_NR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LS_POSITION_NR];
			} else if ("F_VONPOSITION".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VONPOSITION];
			} else if ("F_BISPOSITION".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_BISPOSITION];
			} else if ("F_ZWSNETTOSUMME".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ZWSNETTOSUMME];
			} else if ("F_ZWSTEXT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ZWSTEXT];
			} else if ("F_RABATT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_RABATT];
			} else if ("F_AUFTRAG_BESTAETIGUNG_TERMIN".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_BESTAETIGUNG_TERMIN];
			} else if ("F_AUFTRAG_VERSANDWEG".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_VERSANDWEG];
			}
		} else if (cAktuellerReport
				.equals(LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE)) {

			if ("Lieferscheinnummer".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERSCHEINCNR];
			} else if ("Lieferscheinkunde".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERSCHEINKUNDE];
			} else if ("F_KOSTENSTELLECNR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_KOSTENSTELLECNR];
			} else if ("Anlagedatum".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ANLAGEDATUM];
			} else if ("Liefertermin".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERTERMIN];
			} else if ("Zahlungsziel".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ZAHLUNGSZIEL];
			} else if ("Projektbezeichnung".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_PROJEKTBEZEICHNUNG];
			} else if ("Artikelcnr".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELCNR];
			} else if ("Artikelbezeichnung".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELBEZEICHNUNG];
			} else if ("Artikelmenge".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELMENGE];
			} else if ("Artikeleinheit".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELEINHEIT];
			} else if ("Artikelnettogesamtpreisplusversteckteraufschlagminusrabatt"
					.equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELNETTOGESAMTPREISPLUSVERSTECKTERAUFSCHLAGMINUSRABATT];
			} else if ("Artikelgestehungspreis".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELGESTEHUNGSPREIS];
			} else if ("Artikeloffenerwert".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELOFFENERWERT];
			} else if ("Artikeloffenerdb".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELOFFENERDB];
			} else if ("F_AUFTRAG".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_AUFTRAGSNUMMER];
			} else if ("F_BESTELLNUMMER".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_BESTELLNUMMER];
			} else if ("F_AUFTRAG_PROJEKT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_AUFTRAG_PROJEKT];
			} else if ("F_LIEFERART".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERART];
			} else if ("F_LIEFERARTORT".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERARTORT];
			} else if ("F_ZIELLAGER".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ZIELLAGER];
			} else if ("F_ABLAGER".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ABLAGER];
			} else if ("F_RECHNUNGSADRESSE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_RECHNUNGSADRESSE];
			} else if ("F_VERRECHENBAR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_VERRECHENBAR];
			} else if ("F_SPEDITEUR".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_SPEDITEUR];
			} else if ("F_TEXTEINGABE".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_TEXTEINGABE];
			}

		} else if (cAktuellerReport
				.equals(LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE)) {
			if ("Lieferscheinnummer".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE_NUMMER];
			} else if ("KundeAnrede".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE_KUNDE];
			} else if ("Anlagedatum".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE_ANLAGEDATUM];
			} else if ("AngelegtVon".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE_ANGELEGTVON];
			} else if ("Auftragsnummer".equals(fieldName)) {
				value = data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE_AUFTRAGSNUMMER];
			}
		} else if (cAktuellerReport
				.equals(LieferscheinReportFac.REPORT_LIEFERSCHEIN_ALLE)) {
			if ("F_BELEGDATUM".equals(fieldName)) {
				value = data[index][FELD_ALLE_BELEGDATUM];
			} else if ("F_BETRAG".equals(fieldName)) {
				value = data[index][FELD_ALLE_BETRAG];
			} else if ("F_KOSTENSTELLENUMMER".equals(fieldName)) {
				value = data[index][FELD_ALLE_KOSTENSTELLENUMMER];
			} else if ("F_KUNDE".equals(fieldName)) {
				value = data[index][FELD_ALLE_KUNDE];
			} else if ("F_KUNDE2".equals(fieldName)) {
				value = data[index][FELD_ALLE_KUNDE2];
			} else if ("F_KUNDE_RECHNUNG".equals(fieldName)) {
				value = data[index][FELD_ALLE_KUNDE_RECHNUNG];
			} else if ("F_KUNDE2_RECHNUNG".equals(fieldName)) {
				value = data[index][FELD_ALLE_KUNDE2_RECHNUNG];
			} else if ("F_ORT".equals(fieldName)) {
				value = data[index][FELD_ALLE_ORT];
			} else if ("F_RECHNUNGSNUMMER".equals(fieldName)) {
				value = data[index][FELD_ALLE_RECHNUNGSNUMMER];
			} else if ("F_LIEFERSCHEINNUMMER".equals(fieldName)) {
				value = data[index][FELD_ALLE_LIEFERSCHEINNUMMER];
			} else if ("F_DEBITORENKONTO".equals(fieldName)) {
				value = data[index][FELD_ALLE_DEBITORENKONTO];
			} else if ("F_ADRESSE".equals(fieldName)) {
				value = data[index][FELD_ALLE_ADRESSE];
			} else if ("F_ADRESSE_RECHNUNG".equals(fieldName)) {
				value = data[index][FELD_ALLE_ADRESSE_RECHNUNG];
			} else if ("F_VERTRETER".equals(fieldName)) {
				value = data[index][FELD_ALLE_VERTRETER];
			} else if ("F_WAEHRUNG".equals(fieldName)) {
				value = data[index][FELD_ALLE_WAEHRUNG];
			} else if ("F_KURS".equals(fieldName)) {
				value = data[index][FELD_ALLE_KURS];
			} else if ("F_LAENDERART".equals(fieldName)) {
				value = data[index][FELD_ALLE_LAENDERART];
			} else if ("F_PROJEKT".equals(fieldName)) {
				value = data[index][FELD_ALLE_PROJEKT];
			} else if ("F_STATUS".equals(fieldName)) {
				value = data[index][FELD_ALLE_STATUS];
			}
		}

		return value;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public JasperPrintLP[] printLieferschein(Integer iIdLieferscheinI,
			Integer iAnzahlKopienI, Boolean bMitLogo, TheClientDto theClientDto)
			throws EJBExceptionLP {
		return printLieferschein(iIdLieferscheinI, iAnzahlKopienI, bMitLogo,
				LocaleFac.BELEGART_LIEFERSCHEIN, theClientDto);

	}

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public JasperPrintLP printLieferscheinAlle(
			ReportLieferscheinJournalKriterienDto krit,
			TheClientDto theClientDto) {
		Session session = null;
		try {
			cAktuellerReport = LieferscheinReportFac.REPORT_LIEFERSCHEIN_ALLE;
			SessionFactory factory = FLRSessionFactory.getFactory();
			session = factory.openSession();
			// Kunde oder Statistikadresse verwenden
			final String critKundeIId;
			final String critFLRKunde;
			if (krit.getBVerwendeRechnungsAdresse()) {
				critKundeIId = LieferscheinFac.FLR_LIEFERSCHEIN_KUNDE_I_ID_RECHNUNGSADRESSE;
				critFLRKunde = LieferscheinFac.FLR_LIEFERSCHEIN_FLRKUNDERECHNUNGSADRESSE;
			} else {
				critKundeIId = LieferscheinFac.FLR_LIEFERSCHEIN_KUNDE_I_ID_LIEFERADRESSE;
				critFLRKunde = LieferscheinFac.FLR_LIEFERSCHEIN_FLRKUNDE;
			}

			Criteria c = session.createCriteria(FLRLieferschein.class);
			// Filter nach Mandant
			c.add(Restrictions.eq(
					LieferscheinFac.FLR_LIEFERSCHEIN_MANDANT_C_NR,
					theClientDto.getMandant()));

			// Filter nach Kostenstelle
			if (krit.kostenstelleIId != null) {
				c.add(Restrictions.eq(
						LieferscheinFac.FLR_LIEFERSCHEIN_KOSTENSTELLE_I_ID,
						krit.kostenstelleIId));
			}
			// Filter nach einem Kunden
			if (krit.kundeIId != null) {
				c.add(Restrictions.eq(critKundeIId, krit.kundeIId));
			}
			// Filter nach einem Vertrter
			if (krit.vertreterIId != null) {
				c.add(Restrictions
						.eq(LieferscheinFac.FLR_LIEFERSCHEIN_FLRVERTRETER
								+ ".i_id", krit.vertreterIId));
			}
			// Filter nach Status (keine stornierten)
			c.add(Restrictions.not(Restrictions
					.eq(LieferscheinFac.FLR_LIEFERSCHEIN_LIEFERSCHEINSTATUS_STATUS_C_NR,
							LieferscheinFac.LSSTATUS_STORNIERT)));
			// Nur offene anzeigen?
			if (krit.getBNurOffene()) {
				Collection<String> cStati = new LinkedList<String>();
				cStati.add(LieferscheinFac.LSSTATUS_ANGELEGT);
				cStati.add(LieferscheinFac.LSSTATUS_OFFEN);
				c.add(Restrictions
						.in(LieferscheinFac.FLR_LIEFERSCHEIN_LIEFERSCHEINSTATUS_STATUS_C_NR,
								cStati));
			}
			// Datum von/bis
			String sVon = null;
			String sBis = null;
			if (krit.dVon != null) {
				c.add(Restrictions.ge(
						LieferscheinFac.FLR_LIEFERSCHEIN_D_BELEGDATUM,
						krit.dVon));
				sVon = Helper.formatDatum(krit.dVon, theClientDto.getLocUi());
			}
			if (krit.dBis != null) {
				c.add(Restrictions.le(
						LieferscheinFac.FLR_LIEFERSCHEIN_D_BELEGDATUM,
						krit.dBis));
				sBis = Helper.formatDatum(krit.dBis, theClientDto.getLocUi());
			}

			// Belegnummer von/bis
			LpBelegnummerFormat f = getBelegnummerGeneratorObj()
					.getBelegnummernFormat(theClientDto.getMandant());
			Integer iGeschaeftsjahr = getParameterFac().getGeschaeftsjahr(
					theClientDto.getMandant());
			String sMandantKuerzel = getParameterFac().getMandantparameter(
					theClientDto.getMandant(),
					ParameterFac.KATEGORIE_ALLGEMEIN,
					ParameterFac.PARAMETER_BELEGNUMMER_MANDANTKENNUNG)
					.getCWert();
			if (krit.sBelegnummerVon != null) {
				sVon = HelperServer.getBelegnummernFilterForHibernateCriterias(
						f, iGeschaeftsjahr, sMandantKuerzel,
						krit.sBelegnummerVon);
				c.add(Restrictions.ge(LieferscheinFac.FLR_LIEFERSCHEIN_C_NR,
						sVon));
			}
			if (krit.sBelegnummerBis != null) {
				sBis = HelperServer.getBelegnummernFilterForHibernateCriterias(
						f, iGeschaeftsjahr, sMandantKuerzel,
						krit.sBelegnummerBis);
				c.add(Restrictions.le(LieferscheinFac.FLR_LIEFERSCHEIN_C_NR,
						sBis));
			}
			// Sortierung nach Kostenstelle ist optional
			if (krit.bSortiereNachKostenstelle) {
				c.createCriteria(
						LieferscheinFac.FLR_LIEFERSCHEIN_FLRKOSTENSTELLE)
						.addOrder(Order.asc("c_nr"));
			}
			// Sortierung nach Partner ist optional
			if (krit.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_PARTNER) {
				c.createCriteria(critFLRKunde)
						.createCriteria(KundeFac.FLR_PARTNER)
						.addOrder(
								Order.asc(PartnerFac.FLR_PARTNER_NAME1NACHNAMEFIRMAZEILE1));
			} else if (krit.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_BELEGNUMMER) {
				c.addOrder(Order.asc(LieferscheinFac.FLR_LIEFERSCHEIN_C_NR));
			}
			if (krit.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_VERTRETER) {
				c.createCriteria(LieferscheinFac.FLR_LIEFERSCHEIN_FLRVERTRETER)
						.addOrder(
								Order.asc(PersonalFac.FLR_PERSONAL_C_KURZZEICHEN));
			}
			List<?> list = c.list();
			data = new Object[list.size()][REPORT_ALLE_ANZAHL_SPALTEN];

			int i = 0;
			for (Iterator<?> iter = list.iterator(); iter.hasNext();) {
				FLRLieferschein r = (FLRLieferschein) iter.next();
				data[i][FELD_ALLE_BELEGDATUM] = r.getD_belegdatum();
				data[i][FELD_ALLE_PROJEKT] = r.getC_bez_projektbezeichnung();
				data[i][FELD_ALLE_STATUS] = r
						.getLieferscheinstatus_status_c_nr();
				data[i][FELD_ALLE_BELEGDATUM] = r.getD_belegdatum();
				data[i][FELD_ALLE_LIEFERSCHEINNUMMER] = r.getC_nr();
				// Bezahlte Betraege

				BigDecimal bdWertmw = r.getN_gesamtwertinlieferscheinwaehrung();

				data[i][FELD_ALLE_BETRAG] = bdWertmw;
				// Kostenstelle
				if (r.getFlrkostenstelle() != null) {
					String sKostenstellen = "";
					KostenstelleDto k = null;
					RechnungkontierungDto[] rechnungkontierungsDto = getRechnungFac()
							.rechnungkontierungFindByRechnungIId(r.getI_id());
					if (rechnungkontierungsDto.length != 0) {
						for (int e = 0; e < rechnungkontierungsDto.length; e++) {
							k = getSystemFac().kostenstelleFindByPrimaryKey(
									rechnungkontierungsDto[e]
											.getKostenstelleIId());
							sKostenstellen = sKostenstellen + k.getCNr() + " ";
						}
					} else {
						sKostenstellen = r.getFlrkostenstelle().getC_nr();
					}
					data[i][FELD_ALLE_KOSTENSTELLENUMMER] = sKostenstellen;
				} else {
					data[i][FELD_ALLE_KOSTENSTELLENUMMER] = null;
				}
				// Kundendaten
				FLRKunde flrKunde, flrKundeStatistik;
				if (krit.getBVerwendeRechnungsAdresse()) {
					flrKunde = r.getFlrkunderechnungsadresse();
				} else {
					flrKunde = r.getFlrkunde();

					// Statistikdaten wenn nicht Kriterium Rechnungsadresse
					flrKundeStatistik = r.getFlrkunderechnungsadresse();
					data[i][FELD_ALLE_KUNDE_RECHNUNG] = flrKundeStatistik
							.getFlrpartner().getC_name1nachnamefirmazeile1();
					if (flrKundeStatistik.getFlrpartner()
							.getC_name2vornamefirmazeile2() != null) {
						data[i][FELD_ALLE_KUNDE2_RECHNUNG] = flrKundeStatistik
								.getFlrpartner().getC_name2vornamefirmazeile2();
					} else {
						data[i][FELD_ALLE_KUNDE2_RECHNUNG] = "";
					}
					PartnerDto partnerDtoStatistik = getPartnerFac()
							.partnerFindByPrimaryKey(
									flrKundeStatistik.getFlrpartner().getI_id(),
									theClientDto);
					data[i][FELD_ALLE_ADRESSE_RECHNUNG] = partnerDtoStatistik
							.formatAdresse();

				}
				data[i][FELD_ALLE_KUNDE] = flrKunde.getFlrpartner()
						.getC_name1nachnamefirmazeile1();
				if (r.getFlrvertreter() != null) {
					if (r.getFlrvertreter().getFlrpartner()
							.getC_name2vornamefirmazeile2() != null) {
						data[i][FELD_ALLE_VERTRETER] = r.getFlrvertreter()
								.getFlrpartner()
								.getC_name1nachnamefirmazeile1()
								+ " "
								+ r.getFlrvertreter().getFlrpartner()
										.getC_name2vornamefirmazeile2();
					} else {
						data[i][FELD_ALLE_VERTRETER] = r.getFlrvertreter()
								.getFlrpartner()
								.getC_name1nachnamefirmazeile1();
					}
				}
				if (flrKunde.getFlrpartner().getC_name2vornamefirmazeile2() != null) {
					data[i][FELD_ALLE_KUNDE2] = flrKunde.getFlrpartner()
							.getC_name2vornamefirmazeile2();
				} else {
					data[i][FELD_ALLE_KUNDE2] = "";
				}
				PartnerDto partnerDto = getPartnerFac()
						.partnerFindByPrimaryKey(
								flrKunde.getFlrpartner().getI_id(),
								theClientDto);
				data[i][FELD_ALLE_ADRESSE] = partnerDto.formatAdresse();
				data[i][FELD_ALLE_ORT] = partnerDto.formatAdresse();
				if (r.getFlrrechnung() != null) {
					data[i][FELD_ALLE_RECHNUNGSNUMMER] = r.getFlrrechnung()
							.getC_nr();
				}

				// Debitorenkontonummer
				KontoDtoSmall kontoDtoDeb = null;
				if (flrKunde.getKonto_i_id_debitorenkonto() != null) {
					kontoDtoDeb = getFinanzFac()
							.kontoFindByPrimaryKeySmallOhneExc(
									flrKunde.getKonto_i_id_debitorenkonto());
				}
				String sKontonummer;
				if (kontoDtoDeb != null) {
					sKontonummer = kontoDtoDeb.getCNr();
				} else {
					sKontonummer = "";
				}
				data[i][FELD_ALLE_DEBITORENKONTO] = sKontonummer;
				data[i][FELD_ALLE_WAEHRUNG] = r
						.getWaehrung_c_nr_lieferscheinwaehrung();
				data[i][FELD_ALLE_KURS] = new BigDecimal(
						r.getF_wechselkursmandantwaehrungzulieferscheinwaehrung());

				// 14217
				String sLaenderart = getFinanzServiceFac()
						.getLaenderartZuPartner(partnerDto.getIId(),
								theClientDto);
				data[i][FELD_ALLE_LAENDERART] = sLaenderart;
				i++;
			}
			Map<String, Object> mapParameter = new TreeMap<String, Object>();
			MandantDto mandantDto = getMandantFac().mandantFindByPrimaryKey(
					theClientDto.getMandant(), theClientDto);
			// Waehrung
			mapParameter.put(LPReport.P_WAEHRUNG, mandantDto.getWaehrungCNr());
			StringBuffer sSortierung = new StringBuffer();
			if (krit.bSortiereNachKostenstelle) {
				sSortierung.append(getTextRespectUISpr("lp.kostenstelle",
						theClientDto.getMandant(), theClientDto.getLocUi()));
				sSortierung.append(", ");
			}
			if (krit.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_PARTNER) {
				if (krit.getBVerwendeRechnungsAdresse()) {
					sSortierung.append(getTextRespectUISpr(
							"lp.rechnungsadresse", theClientDto.getMandant(),
							theClientDto.getLocUi()));
				} else {
					sSortierung
							.append(getTextRespectUISpr("lp.kunde",
									theClientDto.getMandant(),
									theClientDto.getLocUi()));
				}
			} else if (krit.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_BELEGNUMMER) {
				sSortierung.append(getTextRespectUISpr("bes.belegnummer",
						theClientDto.getMandant(), theClientDto.getLocUi()));
			} else if (krit.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_VERTRETER) {
				sSortierung.append(getTextRespectUISpr("lp.vertreter",
						theClientDto.getMandant(), theClientDto.getLocUi()));
			}
			StringBuffer sFilter = new StringBuffer();
			if (sVon != null) {
				sFilter.append(getTextRespectUISpr("lp.von",
						theClientDto.getMandant(), theClientDto.getLocUi()));
				sFilter.append(" " + sVon + " ");
			}
			if (sBis != null) {
				sFilter.append(getTextRespectUISpr("lp.bis",
						theClientDto.getMandant(), theClientDto.getLocUi()));
				sFilter.append(" " + sBis + " ");
			}
			if (krit.kostenstelleIId != null) {
				if (sFilter.length() > 0) {
					sFilter.append(", ");
				}
				KostenstelleDto kstDto = getSystemFac()
						.kostenstelleFindByPrimaryKey(krit.kostenstelleIId);
				sFilter.append(getTextRespectUISpr("lp.kostenstelle",
						theClientDto.getMandant(), theClientDto.getLocUi()));
				sFilter.append(" ");
				sFilter.append(kstDto.getCNr());
			}
			// Statistikadresse
			if (krit.getBVerwendeRechnungsAdresse()) {
				if (sFilter.length() > 0) {
					sFilter.append(", ");
				}
				sFilter.append(getTextRespectUISpr("lp.rechnungsadresse",
						theClientDto.getMandant(), theClientDto.getLocUi()));
			}

			mapParameter.put(LPReport.P_SORTIERUNG, sSortierung.toString());
			mapParameter.put(LPReport.P_SORTIERENACHKOSTENSTELLE, new Boolean(
					krit.bSortiereNachKostenstelle));
			mapParameter
					.put(LPReport.P_SORTIERENACHKUNDE,
							new Boolean(
									krit.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_PARTNER));
			mapParameter
					.put(LPReport.P_SORTIERENACHVERTRETER,
							new Boolean(
									krit.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_VERTRETER));
			mapParameter.put(LPReport.P_FILTER, sFilter.toString());
			initJRDS(mapParameter, LieferscheinReportFac.REPORT_MODUL,
					cAktuellerReport, theClientDto.getMandant(),
					theClientDto.getLocUi(), theClientDto);
			return getReportPrint();

		} catch (RemoteException ex) {
			throwEJBExceptionLPRespectOld(ex);
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private int addPositionToDataPosition(LieferscheinpositionDto lspos,
			Integer iArtikelpositionsnummer, AuftragDto auftragDto,
			AuftragpositionDto auftragpositionDto, int index, String sBelegart,
			TheClientDto theClientDto) throws EJBExceptionLP {
		data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITION_NR] = iArtikelpositionsnummer;
		// weiterzaehlen
		iArtikelpositionsnummer = new Integer(
				iArtikelpositionsnummer.intValue() + 1);
		try {
			// Positionsnummer
			data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITION] = getLieferscheinpositionFac()
					.getPositionNummer(lspos.getIId());
			data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_MENGE] = new BigDecimal(
					1);
			data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_EINHEIT] = SystemFac.EINHEIT_STUECK
					.trim();
			data[index][REPORT_LIEFERSCHEIN_POSITIONSART] = LocaleFac.POSITIONSART_IDENT;
			String sIdent = null;
			// Druckdaten zusammenstellen
			if (lspos.getCBez() != null)
				sIdent = lspos.getCBez();
			else
				sIdent = "";
			data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENT] = sIdent;
			Session session = null;
			try {
				if (lspos.getTypCNr().equals(LocaleFac.POSITIONTYP_MITPREISE)) {
					data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = LocaleFac.POSITIONSART_IDENT;
					data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENT] = lspos
							.getCBez();
					data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_MENGE] = new BigDecimal(
							1);
					data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_EINHEIT] = SystemFac.EINHEIT_STUECK
							.trim();
					data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH] = new Boolean(
							false);
					List<?> l = null;
					String sArtikelInfo = new String();
					SessionFactory factory = FLRSessionFactory.getFactory();
					session = factory.openSession();
					Criteria crit = session
							.createCriteria(FLRLieferscheinposition.class);
					crit.add(Restrictions.eq("position_i_id", lspos.getIId()));
					crit.addOrder(Order
							.asc(RechnungFac.FLR_RECHNUNGPOSITION_I_SORT));
					l = crit.list();
					Iterator<?> iter = l.iterator();
					while (iter.hasNext()) {
						index++;
						FLRLieferscheinposition pos = (FLRLieferscheinposition) iter
								.next();
						if (pos.getPositionsart_c_nr().equals(
								LocaleFac.POSITIONSART_IDENT))
							sArtikelInfo = pos.getFlrartikel().getC_nr();
						else if (pos.getPositionsart_c_nr().equals(
								LocaleFac.POSITIONSART_TEXTEINGABE))
							sArtikelInfo = pos.getC_textinhalt();
						else if (pos.getPositionsart_c_nr().equals(
								LocaleFac.POSITIONSART_HANDEINGABE))
							sArtikelInfo = pos.getC_bez();
						// Druckdaten zusammenstellen
						data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENT] = sArtikelInfo;
						// weitere Daten
						data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_MENGE] = pos
								.getN_menge();
						data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_EINHEIT] = pos
								.getEinheit_c_nr();
						data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = LocaleFac.POSITIONSART_IDENT;
						data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH] = new Boolean(
								false);
						data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_TYP_CNR] = pos
								.getTyp_c_nr();
					}
				} else {

					StringBuffer sbArtikelInfo = new StringBuffer();
					List<?> l = null;
					SessionFactory factory = FLRSessionFactory.getFactory();
					session = factory.openSession();
					Criteria crit = session
							.createCriteria(FLRLieferscheinposition.class);
					crit.add(Restrictions.eq("position_i_id", lspos.getIId()));
					l = crit.list();
					Iterator<?> iter = l.iterator();
					while (iter.hasNext()) {
						FLRLieferscheinposition pos = (FLRLieferscheinposition) iter
								.next();
						if (pos.getPositionsart_c_nr().equals(
								LocaleFac.POSITIONSART_IDENT)) {
							sbArtikelInfo.append(pos.getFlrartikel().getC_nr());
							// SK: Artikelgruppe wenn der Lieferscheindruck fuer
							// Rechnungen verwendet wird
							if (LocaleFac.BELEGART_RECHNUNG.equals(sBelegart)) {
								if ((Boolean) getParameterFac()
										.getMandantparameter(
												theClientDto.getMandant(),
												ParameterFac.KATEGORIE_RECHNUNG,
												ParameterFac.PARAMETER_RECHNUNG_ARTIKELGRUPPE_DRUCKEN)
										.getCWertAsObject()) {
									if (pos.getFlrartikel()
											.getFlrartikelgruppe() != null) {
										data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_ARTIKELGRUPPE] = data[index][REPORT_LIEFERSCHEIN_ARTIKEL_ARTIKELGRUPPE] == null ? pos
												.getFlrartikel()
												.getFlrartikelgruppe()
												.getC_nr()
												+ "\n"
												: data[index][REPORT_LIEFERSCHEIN_ARTIKEL_ARTIKELGRUPPE]
														+ pos.getFlrartikel()
																.getFlrartikelgruppe()
																.getC_nr()
														+ "\n";
									}
								}
							}
							if (iter.hasNext())
								sbArtikelInfo.append("\n");
						}
					}
					data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = LocaleFac.POSITIONSART_IDENT;
					data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_MENGE] = new BigDecimal(
							1);
					data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_EINHEIT] = SystemFac.EINHEIT_STUECK
							.trim();
					if (auftragDto != null) {
						Hashtable<?, ?> hAE = getAuftragReportFac()
								.getAuftragEigenschaften(auftragDto.getIId(),
										theClientDto);
						if (hAE != null) {
							sbArtikelInfo.append("\n");
							sbArtikelInfo
									.append("FA: "
											+ hAE.get(AuftragReportFac.AUFTRAG_EIGENSCHAFTEN_FA));
							sbArtikelInfo.append("\n");
							sbArtikelInfo
									.append("Cluster: "
											+ hAE.get(AuftragReportFac.AUFTRAG_EIGENSCHAFTEN_CLUSTER));
							sbArtikelInfo.append("\n");
							sbArtikelInfo
									.append("Equipmentnummer: "
											+ hAE.get(AuftragReportFac.AUFTRAG_EIGENSCHAFTEN_EQNR));
						}
					}
					data[index][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENT] = sbArtikelInfo
							.toString();

				}

			} finally {
				if (session != null) {
					session.close();
				}
			}
		} catch (RemoteException ex) {
		} catch (EJBExceptionLP ex) {
		}

		return index;
	}

	private void buildVersandwegParam(TheClientDto theClientDto,
			LieferscheinDto lieferscheinDto, Locale locDruck,
			HashMap<String, Object> parameter) throws RemoteException {
		parameter.put(
				"P_VERSANDWEG_AVISO_TERMIN",
				lieferscheinDto.getTLieferaviso() == null ? null : Helper
						.formatDatum(lieferscheinDto.getTLieferaviso(),
								locDruck));
		boolean hasVersandweg = getLieferscheinFac().hatLieferscheinVersandweg(
				lieferscheinDto, theClientDto);
		parameter.put("P_VERSANDWEG", new Boolean(hasVersandweg));
	}

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public JasperPrintLP[] printLieferschein(Integer iIdLieferscheinI,
			Integer iAnzahlKopienI, Boolean bMitLogo, String sBelegart,
			TheClientDto theClientDto) throws EJBExceptionLP {

		checkLieferscheinIId(iIdLieferscheinI);

		JasperPrintLP[] aJasperPrint = null;

		try {
			// Beinhaltet Chargennummer die Mindesthalbarkeit MHD?
			ParametermandantDto parameter_MhdInCharge = getParameterFac()
					.getMandantparameter(
							theClientDto.getMandant(),
							ParameterFac.KATEGORIE_ARTIKEL,
							ParameterFac.PARAMETER_CHARGENNUMMER_BEINHALTET_MINDESTHALTBARKEITSDATUM);
			final boolean bChargennummerBeinhaltetMindesthaltbarkeitsdatum = ((Boolean) parameter_MhdInCharge
					.getCWertAsObject()).booleanValue();

			ParametermandantDto parameterAbweichung = getParameterFac()
					.getMandantparameter(
							theClientDto.getMandant(),
							ParameterFac.KATEGORIE_RECHNUNG,
							ParameterFac.PARAMETER_MAXIMALE_ABWEICHUNG_SUMMENAUSDRUCK);
			final Double dAbweichung = (Double) parameterAbweichung
					.getCWertAsObject();

			LieferscheinDto lieferscheinDto = getLieferscheinFac()
					.lieferscheinFindByPrimaryKey(iIdLieferscheinI,
							theClientDto);
			LieferscheinpositionDto[] aLieferscheinpositionDto = getLieferscheinpositionFac()
					.getLieferscheinPositionenByLieferschein(
							lieferscheinDto.getIId(), theClientDto);

			cAktuellerReport = LieferscheinReportFac.REPORT_LIEFERSCHEIN;
			int iArtikelpositionsnummer = 1;
			Boolean bbSeitenumbruch = new Boolean(false); // dieser Wert
			// wechselt mit
			// jedem
			// Seitenumbruch
			// zwischen true und
			// false

			// es gilt das Locale des Auftragskunden
			KundeDto kundeDto = getKundeFac().kundeFindByPrimaryKey(
					lieferscheinDto.getKundeIIdLieferadresse(), theClientDto);

			Locale locDruck = Helper.string2Locale(kundeDto.getPartnerDto()
					.getLocaleCNrKommunikation());

			AnsprechpartnerDto ansprechpartnerDto = null;

			if (lieferscheinDto.getAnsprechpartnerIId() != null) {
				ansprechpartnerDto = getAnsprechpartnerFac()
						.ansprechpartnerFindByPrimaryKey(
								lieferscheinDto.getAnsprechpartnerIId(),
								theClientDto);

			}

			MandantDto mandantDto = getMandantFac().mandantFindByPrimaryKey(
					theClientDto.getMandant(), theClientDto);

			// Kurzzeichenkombi zum Andrucken zusammenbauen
			PersonalDto oPersonalBenutzer = getPersonalFac()
					.personalFindByPrimaryKey(theClientDto.getIDPersonal(),
							theClientDto);
			PersonalDto oPersonalAnleger = getPersonalFac()
					.personalFindByPrimaryKey(
							lieferscheinDto.getPersonalIIdAnlegen(),
							theClientDto);
			String sKurzzeichenkombi = Helper.getKurzzeichenkombi(
					oPersonalBenutzer.getCKurzzeichen(),
					oPersonalAnleger.getCKurzzeichen());

			// Kopftext
			String sKopftext = lieferscheinDto
					.getCLieferscheinKopftextUeberschrieben();

			if (sKopftext == null || sKopftext.length() == 0) {
				LieferscheintextDto oLieferscheintextDto = getLieferscheinServiceFac()
						.lieferscheintextFindByMandantLocaleCNr(
								kundeDto.getPartnerDto()
										.getLocaleCNrKommunikation(),
								LieferscheinServiceFac.LIEFERSCHEINTEXT_KOPFTEXT,
								theClientDto);

				sKopftext = oLieferscheintextDto.getCTextinhalt();
			}

			// Fusstext
			String sFusstext = lieferscheinDto
					.getCLieferscheinFusstextUeberschrieben();

			if (sFusstext == null || sFusstext.length() == 0) {
				LieferscheintextDto oLieferscheintextDto = getLieferscheinServiceFac()
						.lieferscheintextFindByMandantLocaleCNr(
								kundeDto.getPartnerDto()
										.getLocaleCNrKommunikation(),
								LieferscheinServiceFac.LIEFERSCHEINTEXT_FUSSTEXT,
								theClientDto);

				sFusstext = oLieferscheintextDto.getCTextinhalt();
			}
			// dem Report seine Parameter setzen
			HashMap parameter = new HashMap<Object, Object>();
			parameter.put("P_LIEFERSCHEINART",
					lieferscheinDto.getLieferscheinartCNr());

			// CK: PJ 13849
			parameter.put(
					"P_BEARBEITER",
					getPersonalFac().getPersonRpt(
							lieferscheinDto.getPersonalIIdAnlegen(),
							theClientDto));

			final boolean bDruckeRabatt = Helper.short2boolean(kundeDto
					.getBRechnungsdruckmitrabatt());
			parameter.put("P_RABATTSPALTE_DRUCKEN", new Boolean(bDruckeRabatt));

			final boolean bPreiseAndrucken = Helper.short2boolean(kundeDto
					.getBPreiseanlsandrucken());
			parameter.put("P_PREISE_ANDRUCKEN", new Boolean(bPreiseAndrucken));
			parameter
					.put(LPReport.P_WAEHRUNG, lieferscheinDto.getWaehrungCNr());
			// PJ 17820
			parameter.put("P_AUFTRAGANZAHL",
					getGesamtAnzahlAnAuftraegen(lieferscheinDto));

			LagerDto zielLagerDto = null;
			if (lieferscheinDto.getZiellagerIId() != null) {
				zielLagerDto = getLagerFac().lagerFindByPrimaryKey(
						lieferscheinDto.getZiellagerIId());
				parameter.put("P_ZIELLAGER", zielLagerDto.getCNr());
			} else {
				parameter.put("P_ZIELLAGER", null);
			}
			parameter.put("P_MANDANTADRESSE",
					Helper.formatMandantAdresse(mandantDto));

			parameter.put("P_MAXIMALE_ABWEICHUNG", dAbweichung);

			ParametermandantDto parameterWerbeabgabe = getParameterFac()
					.getMandantparameter(theClientDto.getMandant(),
							ParameterFac.KATEGORIE_ARTIKEL,
							ParameterFac.PARAMETER_WERBEABGABE_PROZENT);
			parameter.put("P_WERBEABGABE_PROZENT",
					(Integer) parameterWerbeabgabe.getCWertAsObject());
			ParametermandantDto parameterWerbeabgabeArtikel = getParameterFac()
					.getMandantparameter(theClientDto.getMandant(),
							ParameterFac.KATEGORIE_ARTIKEL,
							ParameterFac.PARAMETER_WERBEABGABE_ARTIKEL);
			parameter.put("P_WERBEABGABE_ARTIKEL",
					parameterWerbeabgabeArtikel.getCWert());
			parameter.put(
					"P_KUNDE_ADRESSBLOCK",
					formatAdresseFuerAusdruck(kundeDto.getPartnerDto(),
							ansprechpartnerDto, mandantDto, locDruck,
							LocaleFac.BELEGART_LIEFERSCHEIN));

			if (ansprechpartnerDto != null) {
				parameter.put(
						"P_ANSPRECHPARTNER_KUNDE_ADRESSBLOCK",
						getPartnerFac()
								.formatFixAnredeTitelName2Name1FuerAdresskopf(
										ansprechpartnerDto.getPartnerDto(),
										locDruck, null));
			}

			parameter
					.put("P_KUNDE_HINWEISEXTERN", kundeDto.getSHinweisextern());

			if (lieferscheinDto.getKundeIIdRechnungsadresse() != null) {
				KundeDto rechnungKunde = getKundeFac().kundeFindByPrimaryKey(
						lieferscheinDto.getKundeIIdRechnungsadresse(),
						theClientDto);

				AnsprechpartnerDto ansprechpartnerDtoRechnungsadresse = null;

				if (lieferscheinDto.getAnsprechpartnerIIdRechnungsadresse() != null) {
					ansprechpartnerDtoRechnungsadresse = getAnsprechpartnerFac()
							.ansprechpartnerFindByPrimaryKey(
									lieferscheinDto
											.getAnsprechpartnerIIdRechnungsadresse(),
									theClientDto);

				}

				if (lieferscheinDto.getKundeIIdRechnungsadresse().equals(
						kundeDto.getIId())
						&& sindAnsprechpartnerGleich(
								lieferscheinDto
										.getAnsprechpartnerIIdRechnungsadresse(),
								lieferscheinDto.getAnsprechpartnerIId())) {

				} else {

					parameter.put(
							"P_RECHNUNGSADRESSE",
							formatAdresseFuerAusdruck(
									rechnungKunde.getPartnerDto(),
									ansprechpartnerDtoRechnungsadresse,
									mandantDto, locDruck,
									LocaleFac.BELEGART_RECHNUNG));

					if (ansprechpartnerDtoRechnungsadresse != null) {
						parameter
								.put("P_ANSPRECHPARTNER_RECHNUNGSADRESSE",
										getPartnerFac()
												.formatFixAnredeTitelName2Name1FuerAdresskopf(
														ansprechpartnerDtoRechnungsadresse
																.getPartnerDto(),
														locDruck, null));
					}

				}

				if (rechnungKunde != null) {
					parameter.put("P_RECHNUNG_UID", rechnungKunde
							.getPartnerDto().getCUid());
					parameter.put("P_RECHNUNG_EORI", rechnungKunde
							.getPartnerDto().getCEori());
					parameter.put("P_RECHNUNG_FREMDSYSTEMNR",
							rechnungKunde.getCFremdsystemnr());
					parameter.put("P_RECHNUNG_TOUR", rechnungKunde.getCTour());
					parameter.put("P_RECHNUNG_LIEFERANTENNR",
							rechnungKunde.getCLieferantennr());
					parameter.put("P_RECHNUNG_ILN", rechnungKunde
							.getPartnerDto().getCIln());
					parameter.put("P_RECHNUNG_KUNDE_FIRMENBUCHNUMMER",
							rechnungKunde.getPartnerDto().getCFirmenbuchnr());
					parameter.put("P_RECHNUNG_KUNDE_KUNDENNUMMER",
							rechnungKunde.getIKundennummer());
				}
			}
			parameter.put("P_BEZEICHNUNG",
					lieferscheinDto.getCBezProjektbezeichnung());

			if (lieferscheinDto.getProjektIId() != null) {
				ProjektDto pjDto = getProjektFac().projektFindByPrimaryKey(
						lieferscheinDto.getProjektIId());
				parameter.put("P_PROJEKTNUMMER", pjDto.getCNr());
			}

			// Debitorenkonto des Kunden
			if (kundeDto.getIidDebitorenkonto() != null) {
				KontoDto kontoDto = getFinanzFac().kontoFindByPrimaryKey(
						kundeDto.getIidDebitorenkonto());
				parameter.put("P_KUNDE_DEBITORENKONTO", kontoDto.getCNr());
			}
			parameter.put("P_KUNDE_UID", kundeDto.getPartnerDto().getCUid());
			parameter.put("P_KUNDE_EORI", kundeDto.getPartnerDto().getCEori());
			parameter
					.put("P_KUNDE_FREMDSYSTEMNR", kundeDto.getCFremdsystemnr());
			parameter.put("P_KUNDE_TOUR", kundeDto.getCTour());
			parameter.put("P_LIEFERANTENNR", kundeDto.getCLieferantennr());
			parameter.put("P_KUNDE_ILN", kundeDto.getPartnerDto().getCIln());
			parameter.put("P_KUNDE_FIRMENBUCHNUMMER", kundeDto.getPartnerDto()
					.getCFirmenbuchnr());
			parameter.put("P_BELEGKENNUNG",
					baueKennungLieferschein(lieferscheinDto, theClientDto));
			parameter.put("P_BESTELLNUMMER",
					lieferscheinDto.getCBestellnummer());
			if (lieferscheinDto.getKostenstelleIId() != null) {
				KostenstelleDto kostenstelleDto = getSystemFac()
						.kostenstelleFindByPrimaryKey(
								lieferscheinDto.getKostenstelleIId());
				parameter
						.put(LPReport.P_KOSTENSTELLE, kostenstelleDto.getCNr());
			}
			parameter.put("P_KUNDE_KUNDENNUMMER", kundeDto.getIKundennummer());

			String sAuftragbestaetigung = null;
			// Hauptauftrag
			if (lieferscheinDto.getAuftragIId() != null) {
				AuftragDto auftragDto = getAuftragFac()
						.auftragFindByPrimaryKey(
								lieferscheinDto.getAuftragIId());
				sAuftragbestaetigung = auftragDto.getCNr();
				KundeDto lieferKunde = getKundeFac().kundeFindByPrimaryKey(
						auftragDto.getKundeIIdLieferadresse(), theClientDto);
				AnsprechpartnerDto akunde = null;
				if (lieferKunde.getAnsprechpartnerDto() != null) {
					AnsprechpartnerDto[] anspkunde = lieferKunde
							.getAnsprechpartnerDto();
					akunde = anspkunde[0];
				}
				parameter.put(
						"P_LIEFERADRESSE",
						formatAdresseFuerAusdruck(lieferKunde.getPartnerDto(),
								akunde, mandantDto, locDruck,
								LocaleFac.BELEGART_LIEFERSCHEIN));

				if (akunde != null) {
					parameter
							.put("P_ANSPRECHPARTNER_LIEFERADRESSE",
									getPartnerFac()
											.formatFixAnredeTitelName2Name1FuerAdresskopf(
													akunde.getPartnerDto(),
													locDruck, null));
				}

				parameter.put("P_FREMDSYSTEMNR",
						lieferKunde.getCFremdsystemnr());
				parameter.put("P_LIEFERANTENNR",
						lieferKunde.getCLieferantennr());
				parameter.put("P_ILN", lieferKunde.getPartnerDto().getCIln());

				if (lieferKunde.getIidDebitorenkonto() != null) {
					KontoDto kontoDto = getFinanzFac().kontoFindByPrimaryKey(
							lieferKunde.getIidDebitorenkonto());
					parameter.put("P_DEBITORENKONTO", kontoDto.getCNr());
				}
				parameter.put("P_TOUR", lieferKunde.getCTour());
				// AUFTRAGSEIGENSCHAFTEN
				Hashtable hAE = getAuftragReportFac().getAuftragEigenschaften(
						lieferscheinDto.getAuftragIId(), theClientDto);
				if (hAE != null) {
					parameter.put(P_AUFTRAGEIGENSCHAFT_FA,
							hAE.get(AuftragReportFac.AUFTRAG_EIGENSCHAFTEN_FA));
					parameter
							.put(P_AUFTRAGEIGENSCHAFT_CLUSTER,
									hAE.get(AuftragReportFac.AUFTRAG_EIGENSCHAFTEN_CLUSTER));
					parameter.put(P_AUFTRAGEIGENSCHAFT_EQNR, hAE
							.get(AuftragReportFac.AUFTRAG_EIGENSCHAFTEN_EQNR));
				}
			}
			parameter.put("P_ABNR", sAuftragbestaetigung);
			parameter.put(LPReport.P_UNSERZEICHEN, sKurzzeichenkombi);
			parameter.put("P_BELEGDATUM", Helper.formatDatum(
					lieferscheinDto.getTBelegdatum(), locDruck));
			parameter.put("P_LIEFERTERMIN", Helper.formatDatum(
					lieferscheinDto.getTLiefertermin(), locDruck));

			// Gewicht nur andrucken, wenn Hakerl bei Kunde
			// SK: Wenn Gewicht andrucken auch Paketanzahl mitgeben
			if (Helper.short2Boolean(kundeDto.getBLsgewichtangeben())) {
				parameter.put("P_GEWICHT_ANDRUCKEN", true);
				parameter.put("P_GEWICHT",
						lieferscheinDto.getFGewichtLieferung());
				parameter.put("P_PAKETANZAHL",
						lieferscheinDto.getIAnzahlPakete());
			}

			SpediteurDto spediteurDto = getMandantFac()
					.spediteurFindByPrimaryKey(
							lieferscheinDto.getSpediteurIId());
			parameter.put("P_SPEDITEUR", spediteurDto.getCNamedesspediteurs());

			if (spediteurDto.getPartnerIId() != null) {
				PartnerDto partnerDto = getPartnerFac()
						.partnerFindByPrimaryKey(spediteurDto.getPartnerIId(),
								theClientDto);

				AnsprechpartnerDto ansprechpartnerDtoSpediteur = null;

				if (spediteurDto.getAnsprechpartnerIId() != null) {
					ansprechpartnerDtoSpediteur = getAnsprechpartnerFac()
							.ansprechpartnerFindByPrimaryKey(
									spediteurDto.getAnsprechpartnerIId(),
									theClientDto);
				}

				parameter.put(
						"P_SPEDITEUR_ADRESSBLOCK",
						formatAdresseFuerAusdruck(partnerDto,
								ansprechpartnerDtoSpediteur, mandantDto,
								locDruck));
			}

			String cBriefanrede = "";

			if (ansprechpartnerDto != null) {
				cBriefanrede = getPartnerServicesFac().getBriefanredeFuerBeleg(
						lieferscheinDto.getAnsprechpartnerIId(),
						kundeDto.getPartnerIId(), locDruck, theClientDto);
			} else {
				// neutrale Anrede
				cBriefanrede = getBriefanredeNeutralOderPrivatperson(
						kundeDto.getPartnerIId(), locDruck, theClientDto);
			}

			// PJ15507

			if (lieferscheinDto.getAuftragIId() != null) {
				AuftragauftragdokumentDto[] auftragauftragdokumentDtos = getAuftragServiceFac()
						.auftragauftragdokumentFindByAuftragIId(
								lieferscheinDto.getAuftragIId());
				if (auftragauftragdokumentDtos != null
						&& auftragauftragdokumentDtos.length > 0) {

					Object[][] oSubData = new Object[auftragauftragdokumentDtos.length][1];

					for (int i = 0; i < auftragauftragdokumentDtos.length; i++) {
						AuftragdokumentDto aDokDto = getAuftragServiceFac()
								.auftragdokumentFindByPrimaryKey(
										auftragauftragdokumentDtos[i]
												.getAuftragdokumentIId());
						oSubData[i][0] = aDokDto.getBezeichnung();
					}
					String[] fieldnames = new String[] { "F_AUFTRAGDOKUMENT" };

					parameter.put("P_AUFTRAGDOKUMENTE", new LPDatenSubreport(
							oSubData, fieldnames));
				}
			}

			parameter.put("P_BRIEFANREDE", cBriefanrede);
			parameter.put("P_KOPFTEXT",
					Helper.formatStyledTextForJasper(sKopftext));
			parameter.put(
					"P_LIEFERART",
					getLocaleFac().lieferartFindByIIdLocaleOhneExc(
							lieferscheinDto.getLieferartIId(), locDruck,
							theClientDto));
			parameter
					.put("P_LIEFERART_ORT", lieferscheinDto.getCLieferartort());

			// die Kommunikationsinformation des Kunden
			Integer partnerIIdAnsprechpartner = null;
			if (ansprechpartnerDto != null) {
				partnerIIdAnsprechpartner = ansprechpartnerDto
						.getPartnerIIdAnsprechpartner();

				parameter.put("P_LS_ANSPRECHPARTNER_FREMDSYSTEMNUMMER",
						ansprechpartnerDto.getCFremdsystemnr());

			}

			String sEmail = getPartnerFac()
					.partnerkommFindRespectPartnerAsStringOhneExec(
							partnerIIdAnsprechpartner,
							kundeDto.getPartnerDto(),
							PartnerFac.KOMMUNIKATIONSART_EMAIL,
							theClientDto.getMandant(), theClientDto);
			String sFax = getPartnerFac()
					.partnerkommFindRespectPartnerAsStringOhneExec(
							partnerIIdAnsprechpartner,
							kundeDto.getPartnerDto(),
							PartnerFac.KOMMUNIKATIONSART_FAX,
							theClientDto.getMandant(), theClientDto);
			String sTelefon = getPartnerFac()
					.partnerkommFindRespectPartnerAsStringOhneExec(
							partnerIIdAnsprechpartner,
							kundeDto.getPartnerDto(),
							PartnerFac.KOMMUNIKATIONSART_TELEFON,
							theClientDto.getMandant(), theClientDto);

			parameter.put(LPReport.P_ANSPRECHPARTNEREMAIL,
					sEmail != null ? sEmail : "");
			parameter.put(LPReport.P_ANSPRECHPARTNERFAX, sFax != null ? sFax
					: "");
			parameter.put(LPReport.P_ANSPRECHPARTNERTELEFON,
					sTelefon != null ? sTelefon : "");

			// die folgenden Felder werden im Report mit jeweils einer
			// trennenden Leerzeile
			// hintereinandergehaengt
			StringBuffer buff = new StringBuffer();

			// Fusstext
			if (sFusstext != null) {
				parameter.put("P_FUSSTEXT",
						Helper.formatStyledTextForJasper(sFusstext));
				buff.append(sFusstext).append("\n\n");
			}

			// Eigentumsvorbehalt
			MediastandardDto mediastandardDto = getMediaFac()
					.mediastandardFindByCNrDatenformatCNrMandantCNr(
							MediaFac.MEDIASTANDARD_EIGENTUMSVORBEHALT,
							MediaFac.DATENFORMAT_MIMETYPE_TEXT_HTML,
							theClientDto.getMandant(),
							kundeDto.getPartnerDto()
									.getLocaleCNrKommunikation(), theClientDto);

			if (mediastandardDto != null) {
				parameter.put(LPReport.P_EIGENTUMSVORBEHALT, Helper
						.formatStyledTextForJasper(mediastandardDto
								.getOMediaText()));
				buff.append(mediastandardDto.getOMediaText()).append("\n\n");
			}

			// Lieferbedingungen
			mediastandardDto = getMediaFac()
					.mediastandardFindByCNrDatenformatCNrMandantCNr(
							MediaFac.MEDIASTANDARD_LIEFERBEDINGUNGEN,
							MediaFac.DATENFORMAT_MIMETYPE_TEXT_HTML,
							theClientDto.getMandant(),
							kundeDto.getPartnerDto()
									.getLocaleCNrKommunikation(), theClientDto);

			if (mediastandardDto != null) {
				parameter.put(LPReport.P_LIEFERBEDINGUNGEN, Helper
						.formatStyledTextForJasper(mediastandardDto
								.getOMediaText()));
				buff.append(mediastandardDto.getOMediaText()).append("\n\n");
			}

			PersonalDto vertreterDto = null;
			String cVertreterAnredeShort = null;

			if (lieferscheinDto.getPersonalIIdVertreter() != null) {
				vertreterDto = getPersonalFac()
						.personalFindByPrimaryKey(
								lieferscheinDto.getPersonalIIdVertreter(),
								theClientDto);

				cVertreterAnredeShort = getPersonalFac()
						.personalFindByPrimaryKey(
								lieferscheinDto.getPersonalIIdVertreter(),
								theClientDto).getPartnerDto()
						.formatFixName2Name1();
			}
			parameter.put("P_VERTRETER_ANREDE", cVertreterAnredeShort);

			StringBuffer buffVertreter = new StringBuffer();
			// Anrede des Mandanten
			String sMandantAnrede = mandantDto.getPartnerDto()
					.formatFixName1Name2();
			if (sMandantAnrede != null && sMandantAnrede.length() > 0) {
				parameter.put(P_MANDANT_ANREDE_UND_NAME, sMandantAnrede);
				buff.append(sMandantAnrede).append("\n\n");
				buffVertreter.append(sMandantAnrede).append("\n\n");
			}

			// Die Unterschrift fuer Belege inclusive Unterschriftstext und
			// -funktion
			// Beispiel:
			// "i.A. Ing. Werner Hehenwarter" - im Falle des Angebots der
			// Vertreter aus den Kopfdaten
			// "Einkaufsleiter"
			if (vertreterDto != null) {
				String sVertreterUFTitelName2Name1 = vertreterDto
						.formatFixUFTitelName2Name1();

				parameter.put(P_VERTRETER, vertreterDto.formatAnrede());

				buff.append(sVertreterUFTitelName2Name1);
				buffVertreter.append(sVertreterUFTitelName2Name1);
				parameter.put(P_VERTRETER_UNTERSCHRIFTSFUNKTION_UND_NAME,
						sVertreterUFTitelName2Name1);

				if (vertreterDto.getCUnterschriftstext() != null
						&& vertreterDto.getCUnterschriftstext().length() > 0) {
					String sUnterschriftstext = vertreterDto
							.getCUnterschriftstext();
					buff.append("\n").append(sUnterschriftstext);
					buffVertreter.append("\n").append(sUnterschriftstext);
					parameter.put(P_VERTRETER_UNTERSCHRIFTSTEXT,
							sUnterschriftstext);
				}
				// Vertreter Kontaktdaten
				String sVertreterEmail = vertreterDto.getCEmail();

				String sVertreterFaxDirekt = vertreterDto.getCDirektfax();

				String sVertreterFax = vertreterDto.getCFax();

				String sVertreterTelefon = vertreterDto.getCTelefon();
				parameter.put(LPReport.P_VERTRETEREMAIL,
						sVertreterEmail != null ? sVertreterEmail : "");
				if (sVertreterFaxDirekt != null && sVertreterFaxDirekt != "") {
					parameter.put(LPReport.P_VERTRETERFAX, sVertreterFaxDirekt);
				} else {
					parameter.put(LPReport.P_VERTRETERFAX,
							sVertreterFax != null ? sVertreterFax : "");
				}
				parameter.put(LPReport.P_VERTRETEERTELEFON,
						sVertreterTelefon != null ? sVertreterTelefon : "");

			}

			parameter.put("P_SUMMARY",
					Helper.formatStyledTextForJasper(buff.toString()));

			buildVersandwegParam(theClientDto, lieferscheinDto, locDruck,
					parameter);

			int iAnzahlZeilen = 0; // Anzahl der Zeilen in der Gruppe

			for (int i = 0; i < aLieferscheinpositionDto.length; i++) {
				if (aLieferscheinpositionDto[i]
						.getLieferscheinpositionartCNr()
						.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_IDENT)) {
					// Die Zeilenanzahl muss vor dem Befuellen festgelegt
					// werden.
					StuecklisteInfoDto stuecklisteInfoDto = getStuecklisteFac()
							.getStrukturdatenEinesArtikels(
									aLieferscheinpositionDto[i].getArtikelIId(),
									true, null, // in die Rekursion mit einer
									// leeren Listen einsteigen
									0, // in die Rekursion mit Ebene 0
										// einsteigen
									-1, // alle Stuecklisten komplett aufloesen
									false, // Menge pro Einheit der
									// uebergeorndeten Position
									new BigDecimal(1), // fuer 1 Einheit der
									// STKL
									true, // Fremdfertigung aufloesen
									theClientDto);

					iAnzahlZeilen++; // fuer die eigentliche Ident Position
					iAnzahlZeilen += stuecklisteInfoDto.getIiAnzahlPositionen()
							.intValue();
					// Auftragsdaten, wenn die Position auftragsbezogen ist
					if (aLieferscheinpositionDto[i].getAuftragpositionIId() != null) {
						iAnzahlZeilen++;
					}
					// Serien bzw Chargennummer Anzahl des Artikels
					int iAnzahlSerienChargeNr = berechneAnzahlSerienChargeNummern(
							aLieferscheinpositionDto[i].getArtikelIId(),
							aLieferscheinpositionDto[i]
									.getSeriennrChargennrMitMenge(),
							theClientDto);
					iAnzahlZeilen += iAnzahlSerienChargeNr;
				} else if (aLieferscheinpositionDto[i]
						.getLieferscheinpositionartCNr()
						.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_HANDEINGABE)) {
					iAnzahlZeilen++; // fuer die eigentliche Position
					// Auftragsdaten, wenn die Position auftragsbezogen ist
					if (aLieferscheinpositionDto[i].getAuftragpositionIId() != null) {
						iAnzahlZeilen++;
					}
				} else if (aLieferscheinpositionDto[i]
						.getLieferscheinpositionartCNr().equals(
								LocaleFac.POSITIONSART_POSITION)) {
					iAnzahlZeilen++; // fuer die eigentliche Position
					if (aLieferscheinpositionDto[i].getTypCNr().equals(
							LocaleFac.POSITIONTYP_MITPREISE)) {
						Session session = null;
						SessionFactory factory = FLRSessionFactory.getFactory();
						session = factory.openSession();
						Criteria crit = session
								.createCriteria(FLRLieferscheinposition.class);
						crit.add(Restrictions.eq("position_i_id",
								aLieferscheinpositionDto[i].getIId()));
						crit.addOrder(Order
								.asc(RechnungFac.FLR_RECHNUNGPOSITION_I_SORT));
						iAnzahlZeilen = iAnzahlZeilen + crit.list().size();
					}
					// Auftragsdaten, wenn die Position auftragsbezogen ist
					if (aLieferscheinpositionDto[i].getAuftragpositionIId() != null) {
						iAnzahlZeilen++;
					}
				}

				else {
					iAnzahlZeilen++; // fuer die Positionszeile
				}
			}

			int iAnzahlSpalten = LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANZAHL_ZEILEN; // Anzahl
			// der
			// Spalten
			// in
			// der
			// Gruppe

			data = new Object[iAnzahlZeilen][iAnzahlSpalten];

			// Der Index der aktuell verarbeiteten Lieferscheinposition
			int iIndex = 0;

			// die Datenmatrix befuellen
			for (int i = 0; i < iAnzahlZeilen; i++) {

				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSOBJEKT] = getSystemReportFac()
						.getPositionForReport(LocaleFac.BELEGART_LIEFERSCHEIN,
								aLieferscheinpositionDto[iIndex].getIId(),
								theClientDto);

				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_INTERNAL_IID] = aLieferscheinpositionDto[iIndex]
						.getIId();

				if (aLieferscheinpositionDto[iIndex].getTypCNr() != null) {
					if (aLieferscheinpositionDto[iIndex].getPositionsartCNr()
							.equals(LocaleFac.POSITIONSART_POSITION)) {
						AuftragpositionDto abPosDto = null;

						AuftragDto auftragDto = null;
						// Auftragsbezogene erhalten eine Kopfzeile
						if (aLieferscheinpositionDto[iIndex]
								.getAuftragpositionIId() != null) {
							abPosDto = getAuftragpositionFac()
									.auftragpositionFindByPrimaryKey(
											aLieferscheinpositionDto[iIndex]
													.getAuftragpositionIId());
							auftragDto = getAuftragFac()
									.auftragFindByPrimaryKey(
											abPosDto.getBelegIId());
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_AUFTRAGSDATEN;
							// Auch die naechste Zeile (die eigentliche Position
							// erhaelt die auftragsbezogenen Daten)
							for (int j = 0; j < 2; j++) {
								data[i + j][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_BESTELLDATUM] = auftragDto
										.getDBestelldatum();
								data[i + j][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_BESTELLNUMMER] = auftragDto
										.getCBestellnummer();
								data[i + j][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_NUMMER] = auftragDto
										.getCNr();
								data[i + j][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_PROJEKT] = auftragDto
										.getCBezProjektbezeichnung();
								data[i + j][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH] = bbSeitenumbruch;
							}
							i++;
						}
						Integer pNummer = null;
						if (aLieferscheinpositionDto[iIndex]
								.getAuftragpositionIId() != null) {
							pNummer = getAuftragpositionFac()
									.getPositionNummer(
											aLieferscheinpositionDto[iIndex]
													.getAuftragpositionIId());
						} else {
							if (lieferscheinDto.getAuftragIId() == null)
								pNummer = getLieferscheinpositionFac()
										.getPositionNummer(
												aLieferscheinpositionDto[iIndex]
														.getIId());

						}

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSOBJEKT] = getSystemReportFac()
								.getPositionForReport(
										LocaleFac.BELEGART_LIEFERSCHEIN,
										aLieferscheinpositionDto[iIndex]
												.getIId(), theClientDto);

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITION] = pNummer;
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITION_NR] = new Integer(
								iArtikelpositionsnummer);
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LS_POSITION_NR] = getLieferscheinpositionFac()
								.getLSPositionNummer(
										aLieferscheinpositionDto[iIndex]
												.getIId());
						iArtikelpositionsnummer++;

						i = addPositionToDataPosition(
								aLieferscheinpositionDto[iIndex],
								iArtikelpositionsnummer, auftragDto, abPosDto,
								i, sBelegart, theClientDto);
						iIndex++;

					}
				} else {
					// Artikelpositionen
					if (aLieferscheinpositionDto[iIndex]
							.getLieferscheinpositionartCNr()
							.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_IDENT)
							|| aLieferscheinpositionDto[iIndex]
									.getLieferscheinpositionartCNr()
									.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_HANDEINGABE)) {
						AuftragpositionDto abPosDto = null;
						AuftragDto auftragDto = null;

						// Auftragsbezogene erhalten eine Kopfzeile
						if (aLieferscheinpositionDto[iIndex]
								.getAuftragpositionIId() != null) {
							abPosDto = getAuftragpositionFac()
									.auftragpositionFindByPrimaryKey(
											aLieferscheinpositionDto[iIndex]
													.getAuftragpositionIId());
							auftragDto = getAuftragFac()
									.auftragFindByPrimaryKey(
											abPosDto.getBelegIId());
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_AUFTRAGSDATEN;
							// Auch die naechste Zeile (die eigentliche Position
							// erhaelt die auftragsbezogenen Daten)
							for (int j = 0; j < 2; j++) {
								data[i + j][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_BESTELLDATUM] = auftragDto
										.getDBestelldatum();
								data[i + j][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_BESTELLNUMMER] = auftragDto
										.getCBestellnummer();
								data[i + j][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_NUMMER] = auftragDto
										.getCNr();
								data[i + j][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_PROJEKT] = auftragDto
										.getCBezProjektbezeichnung();
								data[i + j][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH] = bbSeitenumbruch;
							}
							i++;
						}

						if (auftragDto != null) {
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_BESTAETIGUNG_TERMIN] = auftragDto
									.getTResponse() == null ? null : Helper
									.formatDatum(auftragDto.getTResponse(),
											locDruck);
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_VERSANDWEG] = new Boolean(
									getAuftragFac().hatAuftragVersandweg(
											auftragDto, theClientDto));
						} else {
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_BESTAETIGUNG_TERMIN] = null;
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_AUFTRAG_VERSANDWEG] = new Boolean(
									false);
						}

						Integer pNummer = null;
						if (aLieferscheinpositionDto[iIndex]
								.getAuftragpositionIId() != null) {
							pNummer = getAuftragpositionFac()
									.getPositionNummer(
											aLieferscheinpositionDto[iIndex]
													.getAuftragpositionIId());
						} else {
							if (lieferscheinDto.getAuftragIId() == null)
								pNummer = getLieferscheinpositionFac()
										.getPositionNummer(
												aLieferscheinpositionDto[iIndex]
														.getIId());
							iArtikelpositionsnummer++;
						}
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITION] = pNummer;
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITION_NR] = new Integer(
								iArtikelpositionsnummer);
						iArtikelpositionsnummer++;
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LS_POSITION_NR] = getLieferscheinpositionFac()
								.getLSPositionNummer(
										aLieferscheinpositionDto[iIndex]
												.getIId());

						// String cBezArtikelbezeichnunguebersteuert = null;
						// String cZBezArtikelbezeichnunguebersteuert = null;
						//
						// if (Helper
						// .short2boolean(aLieferscheinpositionDto[iIndex]
						// .getBArtikelbezeichnunguebersteuert())) {
						// cBezArtikelbezeichnunguebersteuert =
						// aLieferscheinpositionDto[iIndex]
						// .getCBez();
						// cZBezArtikelbezeichnunguebersteuert =
						// aLieferscheinpositionDto[iIndex]
						// .getCZusatzbez();
						// }
						ArtikelDto artikelDto = getArtikelFac()
								.artikelFindByPrimaryKey(
										aLieferscheinpositionDto[iIndex]
												.getArtikelIId(),
										theClientDto);

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_REFERENZNUMMER] = artikelDto
								.getCReferenznr();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_INDEX] = artikelDto
								.getCIndex();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_REVISION] = artikelDto
								.getCRevision();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_DOKUMENTENPFLICHTIG] = Helper
								.short2Boolean(artikelDto
										.getBDokumentenpflicht());

						BelegPositionDruckIdentDto druckDto = printIdent(
								aLieferscheinpositionDto[iIndex],
								/* LocaleFac.BELEGART_LIEFERSCHEIN */sBelegart,
								artikelDto, locDruck, kundeDto.getPartnerIId(),
								theClientDto);

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKELKOMMENTAR] = druckDto
								.getSArtikelkommentar();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IMAGE] = Helper
								.imageToByteArray(druckDto.getOImageKommentar());

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENT] = druckDto
								.getSArtikelInfo();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENT_TEXTEINGABE] = druckDto
								.getSIdentTexteingabe();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ZUSATZBEZEICHNUNG] = druckDto
								.getSZusatzBezeichnung();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKELCZBEZ2] = druckDto
								.getSArtikelZusatzBezeichnung2();

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSOBJEKT] = getSystemReportFac()
								.getPositionForReport(
										LocaleFac.BELEGART_LIEFERSCHEIN,
										aLieferscheinpositionDto[iIndex]
												.getIId(), theClientDto);

						// PJ18261

						if (aLieferscheinpositionDto[iIndex].getLagerIId() != null) {
							LagerDto lagerDtoUebersteuert = getLagerFac()
									.lagerFindByPrimaryKey(
											aLieferscheinpositionDto[iIndex]
													.getLagerIId());
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LAGER_UEBERSTEUERT] = lagerDtoUebersteuert
									.getCNr();
						}

						// PJ 15348
						if (aLieferscheinpositionDto[iIndex].getMwstsatzIId() != null) {

							MwstsatzDto mwstSatzDto = getMandantFac()
									.mwstsatzFindByPrimaryKey(
											aLieferscheinpositionDto[iIndex]
													.getMwstsatzIId(),
											theClientDto);
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_FIBU_MWST_CODE] = mwstSatzDto
									.getIFibumwstcode();

						}

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WE_REFERENZ] = getLagerFac()
								.getWareneingangsreferenzSubreport(
										sBelegart,
										aLieferscheinpositionDto[iIndex]
												.getIId(),
										aLieferscheinpositionDto[iIndex]
												.getSeriennrChargennrMitMenge(),
										false, theClientDto);

						// PJ 15926
						if (aLieferscheinpositionDto[iIndex].getVerleihIId() != null) {
							VerleihDto verleihDto = getArtikelFac()
									.verleihFindByPrimaryKey(
											aLieferscheinpositionDto[iIndex]
													.getVerleihIId());
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERLEIHTAGE] = verleihDto
									.getITage();
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERLEIHFAKTOR] = verleihDto
									.getFFaktor();
						}

						if (aLieferscheinpositionDto[iIndex]
								.getLieferscheinpositionartCNr()
								.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_IDENT)) {
							// Ident nur wenn "echter" Artikel
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENTNUMMER] = artikelDto
									.getCNr();
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SERIENCHARGENR] = SeriennrChargennrMitMengeDto
									.erstelleStringAusMehrerenSeriennummern(aLieferscheinpositionDto[iIndex]
											.getSeriennrChargennrMitMenge());
							// Warenverkehrsnummer fuer Artikel
							String sWarenverkehrsnummer = artikelDto
									.getCWarenverkehrsnummer();
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WARENVERKEHRSNUMMER] = sWarenverkehrsnummer;

							// Ursprungsland
							if (artikelDto.getLandIIdUrsprungsland() != null) {
								LandDto landDto = getSystemFac()
										.landFindByPrimaryKey(
												artikelDto
														.getLandIIdUrsprungsland());
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_URSPRUNGSLAND] = landDto
										.getCName().toUpperCase();
							}

							// Typ, wenn Setartikel

							if (aLieferscheinpositionDto[iIndex]
									.getPositioniIdArtikelset() != null) {

								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SETARTIKEL_TYP] = ArtikelFac.SETARTIKEL_TYP_POSITION;

							} else {

								Session session = null;
								SessionFactory factory = FLRSessionFactory
										.getFactory();
								session = factory.openSession();
								Criteria crit = session
										.createCriteria(FLRLieferscheinposition.class);
								crit.add(Restrictions.eq(
										"position_i_id_artikelset",
										aLieferscheinpositionDto[iIndex]
												.getIId()));

								List l = crit.list();
								int iZeilen = l.size();

								if (iZeilen > 0) {
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SETARTIKEL_TYP] = ArtikelFac.SETARTIKEL_TYP_KOPF;
									String snrs = "";
									Iterator it = l.iterator();
									while (it.hasNext()) {
										FLRLieferscheinposition lsPos = (FLRLieferscheinposition) it
												.next();
										LieferscheinpositionDto lsPosDto = getLieferscheinpositionFac()
												.lieferscheinpositionFindByPrimaryKey(
														lsPos.getI_id(),
														theClientDto);
										if (lsPosDto
												.getSeriennrChargennrMitMenge() != null) {
											Iterator itSnrs = lsPosDto
													.getSeriennrChargennrMitMenge()
													.iterator();
											while (itSnrs.hasNext()) {
												SeriennrChargennrMitMengeDto snrDo = (SeriennrChargennrMitMengeDto) itSnrs
														.next();
												if (snrDo
														.getCSeriennrChargennr() != null) {
													snrs += snrDo
															.getCSeriennrChargennr()
															+ ", ";
												}
											}

										}
									}
									if (snrs.endsWith(", ")) {
										snrs = snrs.substring(0,
												snrs.length() - 2);
									}
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SERIENNUMMERN_DER_SETPOSITIONEN] = snrs;

								}
								session.close();
							}

							// Artikelgruppe
							if (LocaleFac.BELEGART_RECHNUNG.equals(sBelegart)) {
								if ((Boolean) getParameterFac()
										.getMandantparameter(
												theClientDto.getMandant(),
												ParameterFac.KATEGORIE_RECHNUNG,
												ParameterFac.PARAMETER_RECHNUNG_ARTIKELGRUPPE_DRUCKEN)
										.getCWertAsObject()) {
									if (artikelDto.getArtgruIId() != null) {
										ArtgruDto artgruDto = getArtikelFac()
												.artgruFindByPrimaryKey(
														artikelDto
																.getArtgruIId(),
														theClientDto);

										data[i][REPORT_LIEFERSCHEIN_ARTIKEL_ARTIKELGRUPPE] = data[i][REPORT_LIEFERSCHEIN_ARTIKEL_ARTIKELGRUPPE] == null ? artgruDto
												.getCNr() + "\n"
												: data[i][REPORT_LIEFERSCHEIN_ARTIKEL_ARTIKELGRUPPE]
														+ artgruDto.getCNr()
														+ "\n";
									}
								}
							}
							// Gewicht nur andrucken, wenn Hakerl bei Kunde:
							// Gewicht auf LS andrucken
							if (Helper.short2Boolean(kundeDto
									.getBLsgewichtangeben())) {
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_GEWICHT] = artikelDto
										.getFGewichtkg();
							}
							if (artikelDto.getVerpackungDto() != null) {
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_VERPACKUNGSART] = artikelDto
										.getVerpackungDto()
										.getCVerpackungsart();
							}

							// KundeArtikelnr gueltig zu Belegdatum
							KundesokoDto kundeSokoDto_gueltig = this
									.getKundesokoFac()
									.kundesokoFindByKundeIIdArtikelIIdGueltigkeitsdatumOhneExc(
											lieferscheinDto
													.getKundeIIdRechnungsadresse(),
											artikelDto.getIId(),
											new java.sql.Date(lieferscheinDto
													.getTBelegdatum().getTime()));
							if (kundeSokoDto_gueltig != null) {
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_KUNDEARTIKELNR] = kundeSokoDto_gueltig
										.getCKundeartikelnummer();
							}

							KundesokoDto kundeSokoDtoLieferadresse_gueltig = this
									.getKundesokoFac()
									.kundesokoFindByKundeIIdArtikelIIdGueltigkeitsdatumOhneExc(
											lieferscheinDto
													.getKundeIIdLieferadresse(),
											artikelDto.getIId(),
											new java.sql.Date(lieferscheinDto
													.getTBelegdatum().getTime()));
							if (kundeSokoDtoLieferadresse_gueltig != null) {
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_KUNDEARTIKELNR_LIEFERADRESSE] = kundeSokoDtoLieferadresse_gueltig
										.getCKundeartikelnummer();
							}

							if (artikelDto.getVerpackungDto() != null) {
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_BAUFORM] = artikelDto
										.getVerpackungDto().getCBauform();
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERPACKUNGSART] = artikelDto
										.getVerpackungDto()
										.getCVerpackungsart();
							}
							if (artikelDto.getMaterialIId() != null) {
								MaterialDto materialDto = getMaterialFac()
										.materialFindByPrimaryKey(
												artikelDto.getMaterialIId(),
												theClientDto);
								if (materialDto.getMaterialsprDto() != null) {
									/**
									 * @todo MR->MR richtige Mehrsprachigkeit:
									 *       Material in Drucksprache.
									 */
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_MATERIAL] = materialDto
											.getMaterialsprDto().getCBez();
								} else {
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_MATERIAL] = materialDto
											.getCNr();
								}

								MaterialzuschlagDto mzDto = getMaterialFac()
										.getKursMaterialzuschlagDtoInZielwaehrung(
												artikelDto.getMaterialIId(),
												lieferscheinDto
														.getTBelegdatum(),
												lieferscheinDto
														.getWaehrungCNr(),
												theClientDto);

								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_KURS_MATERIALZUSCHLAG] = mzDto
										.getNZuschlag();
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_DATUM_MATERIALZUSCHLAG] = mzDto
										.getTGueltigab();

							}

							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_MATERIALGEWICHT] = artikelDto
									.getFMaterialgewicht();

							if (artikelDto.getGeometrieDto() != null) {
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_BREITE] = artikelDto
										.getGeometrieDto().getFBreite();
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_HOEHE] = artikelDto
										.getGeometrieDto().getFHoehe();
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_TIEFE] = artikelDto
										.getGeometrieDto().getFTiefe();
							}

						}
						String sBezeichnung = artikelDto.getArtikelsprDto() != null ? artikelDto
								.getArtikelsprDto().getCBez() : "";
						if (artikelDto.getArtikelsprDto() != null
								&& artikelDto.getArtikelsprDto().getCZbez() != null) {
							sBezeichnung = sBezeichnung + "\n"
									+ artikelDto.getArtikelsprDto().getCZbez();
						}
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_BEZEICHNUNG] = sBezeichnung;
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_KURZBEZEICHNUNG] = artikelDto
								.getArtikelsprDto() != null ? artikelDto
								.getArtikelsprDto().getCKbez() : "";

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_MENGE] = aLieferscheinpositionDto[iIndex]
								.getNMenge();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_VERPACKUNGSMENGE] = artikelDto
								.getFVerpackungsmenge();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_WERBEABGABEPFLICHTIG] = Helper
								.short2Boolean(artikelDto
										.getBWerbeabgabepflichtig());
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_VERPACKUNGSEANNR] = artikelDto
								.getCVerpackungseannr();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ARTIKEL_VERKAUFSEANNR] = artikelDto
								.getCVerkaufseannr();

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_EINHEIT] = aLieferscheinpositionDto[iIndex]
								.getEinheitCNr() == null ? null
								: getSystemFac()
										.formatEinheit(
												aLieferscheinpositionDto[iIndex]
														.getEinheitCNr(),
												Helper.string2Locale(kundeDto
														.getPartnerDto()
														.getLocaleCNrKommunikation()),
												theClientDto);

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_KEIN_LIEFERREST] = Helper
								.short2Boolean(aLieferscheinpositionDto[iIndex]
										.getBKeinlieferrest());

						BigDecimal bdBestellteMenge = null;
						BigDecimal bdLieferrest = null;

						if (aLieferscheinpositionDto[iIndex]
								.getAuftragpositionIId() != null) {
							AuftragpositionDto oAuftragpositionDto = getAuftragpositionFac()
									.auftragpositionFindByPrimaryKey(
											aLieferscheinpositionDto[iIndex]
													.getAuftragpositionIId());
							bdBestellteMenge = oAuftragpositionDto.getNMenge();
							bdLieferrest = bdBestellteMenge
									.subtract(aLieferscheinpositionDto[iIndex]
											.getNMenge());

							LieferscheinpositionDto[] lsPosDtos = getLieferscheinpositionFac()
									.lieferscheinpositionFindByAuftragpositionIId(
											aLieferscheinpositionDto[iIndex]
													.getAuftragpositionIId(),
											theClientDto);

							for (int k = 0; k < lsPosDtos.length; k++) {
								LieferscheinpositionDto lsPosDto = lsPosDtos[k];

								LieferscheinDto lsDto = getLieferscheinFac()
										.lieferscheinFindByPrimaryKey(
												lsPosDto.getLieferscheinIId(),
												theClientDto);

								if (!lsDto.getStatusCNr().equals(
										LocaleFac.STATUS_STORNIERT)) {
									if (lsDto.getTBelegdatum().before(
											lieferscheinDto.getTBelegdatum())) {
										bdLieferrest = bdLieferrest
												.subtract(lsPosDto.getNMenge());
									} else if (lsDto.getTBelegdatum().equals(
											lieferscheinDto.getTBelegdatum())) {
										if (lsDto.getCNr().compareTo(
												lieferscheinDto.getCNr()) < 0) {
											bdLieferrest = bdLieferrest
													.subtract(lsPosDto
															.getNMenge());
										}

									}
								}

							}

							if (bdLieferrest.doubleValue() < 0) {
								bdLieferrest = Helper.getBigDecimalNull();
							}

						} else {
							bdBestellteMenge = aLieferscheinpositionDto[iIndex]
									.getNMenge();
							bdLieferrest = Helper.getBigDecimalNull();
						}

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_BESTELLT] = bdBestellteMenge;
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LIEFERREST] = bdLieferrest;
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LV_POSITION] = aLieferscheinpositionDto[iIndex]
								.getCLvposition();

						// Wenn es zu einem Artikel eine Stueckliste gibt...
						if (aLieferscheinpositionDto[iIndex]
								.getLieferscheinpositionartCNr()
								.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_IDENT)) {
							StuecklisteInfoDto stuecklisteInfoDto = getStuecklisteFac()
									.getStrukturdatenEinesArtikels(
											aLieferscheinpositionDto[iIndex]
													.getArtikelIId(),
											true, null, // in die Rekursion mit
											// einer
											// leeren Listen einsteigen
											0, // in die Rekursion mit Ebene 0
												// einsteigen
											-1, // alle Stuecklisten komplett
											// aufloesen
											false, // Menge pro Einheit der
											// uebergeorndeten Position
											new BigDecimal(1), // fuer 1 Einheit
											// der STKL
											true, // Fremdfertigung aufloesen
											theClientDto);

							if (stuecklisteInfoDto.getIiAnzahlPositionen()
									.intValue() > 0) {
								// in die naechste Zeile schreiben, zuerst noch
								// die aktuelle fertig machen
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = aLieferscheinpositionDto[iIndex]
										.getLieferscheinpositionartCNr();
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH] = bbSeitenumbruch;

								ArrayList<?> alStuecklisteAufgeloest = stuecklisteInfoDto
										.getAlStuecklisteAufgeloest();

								Iterator<?> it = alStuecklisteAufgeloest
										.iterator();

								while (it.hasNext()) {
									i++;

									StuecklisteMitStrukturDto stuecklisteMitStrukturDto = (StuecklisteMitStrukturDto) it
											.next();

									StuecklistepositionDto stuecklistepositionDto = stuecklisteMitStrukturDto
											.getStuecklistepositionDto();

									// Pro Position eine kuenstliche Zeile zum
									// Andrucken erzeugen,
									// als Bezugsmenge gilt immer 1 Einheit der
									// Stueckliste
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_STUECKLISTENPOSITION;
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH] = bbSeitenumbruch;
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLMENGE] = stuecklistepositionDto
											.getNMenge();
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLEINHEIT] = getSystemFac()
											.formatEinheit(
													stuecklistepositionDto
															.getEinheitCNr(),
													Helper.string2Locale(kundeDto
															.getPartnerDto()
															.getLocaleCNrKommunikation()),
													theClientDto);

									// Einrueckung fuer Unterstuecklisten
									String einrueckung = "";
									for (int j = 0; j < stuecklisteMitStrukturDto
											.getIEbene(); j++) {
										einrueckung = einrueckung + "    ";
									}

									String artikelCNr = null;

									// @todo boeser Workaround ... PJ 4400
									if (stuecklistepositionDto.getArtikelDto()
											.getCNr().startsWith("~")) {
										artikelCNr = AngebotReportFac.REPORT_VORKALKULATION_ZEICHEN_FUER_HANDEINGABE;
									} else {
										artikelCNr = stuecklistepositionDto
												.getArtikelDto().getCNr();
									}

									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLARTIKELCNR] = einrueckung
											+ artikelCNr;
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLARTIKELBEZ] = getArtikelFac()
											.baueArtikelBezeichnungMehrzeilig(
													stuecklistepositionDto
															.getArtikelIId(),
													LocaleFac.POSITIONSART_IDENT,
													null, null, false,
													locDruck, theClientDto);

									if (stuecklistepositionDto.getArtikelIId() != null) {

										ArtikelDto artikelDtoStkl = getArtikelFac()
												.artikelFindByPrimaryKeySmall(
														stuecklistepositionDto
																.getArtikelIId(),
														theClientDto);

										data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLARTIKELKBEZ] = artikelDtoStkl
												.getKbezAusSpr();
									}

									// KundeArtikelnr gueltig zu Belegdatum
									KundesokoDto kundeSokoDto_gueltig = this
											.getKundesokoFac()
											.kundesokoFindByKundeIIdArtikelIIdGueltigkeitsdatumOhneExc(
													lieferscheinDto
															.getKundeIIdRechnungsadresse(),
													stuecklistepositionDto
															.getArtikelIId(),
													new java.sql.Date(
															lieferscheinDto
																	.getTBelegdatum()
																	.getTime()));
									if (kundeSokoDto_gueltig != null) {
										data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLARTIKEL_KDARTIKELNR] = kundeSokoDto_gueltig
												.getCKundeartikelnummer();
									}

									long belegTime = auftragDto == null ? lieferscheinDto
											.getTBelegdatum().getTime()
											: auftragDto.getTBelegdatum()
													.getTime();
									// PJ18038
									VkpreisfindungDto vkpreisfindungDto = getVkPreisfindungFac()
											.verkaufspreisfindung(
													stuecklistepositionDto
															.getArtikelIId(),
													lieferscheinDto
															.getKundeIIdRechnungsadresse(),
													stuecklistepositionDto
															.getNMenge(),
													new Date(belegTime),
													kundeDto.getVkpfArtikelpreislisteIIdStdpreisliste(),
													aLieferscheinpositionDto[iIndex]
															.getMwstsatzIId(),
													theClientDto
															.getSMandantenwaehrung(),
													theClientDto);

									VerkaufspreisDto kundenVKPreisDto = Helper
											.getVkpreisBerechnet(vkpreisfindungDto);
									if (kundenVKPreisDto != null) {
										data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_STKLARTIKEL_KDPREIS] = kundenVKPreisDto.nettopreis;
									}

								}
							}

							// Positionsart fuer Druck aendern, wenn bei Ident
							// die Serien oder Chargennummer angedruckt werden
							// soll
							if (Helper.short2Boolean(artikelDto
									.getBSeriennrtragend())
									|| Helper.short2Boolean(artikelDto
											.getBChargennrtragend())) {
								// Positionsart fuer aktuelle Position setzen,
								// da neue Unterpositionen angelegt werden
								if (data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] == null) {
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = aLieferscheinpositionDto[iIndex]
											.getLieferscheinpositionartCNr();
								}
								// Seitenumbruch
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH] = bbSeitenumbruch;
							}

							if (Helper.short2Boolean(artikelDto
									.getBSeriennrtragend())) {
								i++;
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SERIENCHARGENR] = SeriennrChargennrMitMengeDto
										.erstelleStringAusMehrerenSeriennummern(aLieferscheinpositionDto[iIndex]
												.getSeriennrChargennrMitMenge());

								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_SERIENNR;
								if (data[i - 1][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SETARTIKEL_TYP] != null) {
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SETARTIKEL_TYP] = new String(
											(String) data[i - 1][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SETARTIKEL_TYP]);
								}
								data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH] = bbSeitenumbruch;
							} else if (Helper.short2Boolean(artikelDto
									.getBChargennrtragend())) {
								// Chargennummer splitten in eigene Positionen
								String[] aChargeNummer = SeriennrChargennrMitMengeDto
										.erstelleStringArrayAusMehrerenSeriennummern(aLieferscheinpositionDto[iIndex]
												.getSeriennrChargennrMitMenge());
								for (int k = 0; k < aChargeNummer.length; k++) {
									String sChargeNummer = aChargeNummer[k];
									i++;
									if (bChargennummerBeinhaltetMindesthaltbarkeitsdatum) {
										// MHD als eigenes Feld falls vorhanden
										String[] aChargenrMHD = Helper
												.zerlegeChargennummerMHD(sChargeNummer);
										if (aChargenrMHD != null) {
											data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SERIENCHARGENR] = aChargenrMHD[0];
											if (aChargenrMHD.length > 1) {
												data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_MINDESTHALTBARKEIT] = aChargenrMHD[1];
											}
										}
									} else {
										data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SERIENCHARGENR] = sChargeNummer;
									}

									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_CHARGENR;
									data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH] = bbSeitenumbruch;
									if (data[i - 1][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SETARTIKEL_TYP] != null) {
										data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SETARTIKEL_TYP] = new String(
												(String) data[i - 1][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SETARTIKEL_TYP]);
									}
									// Menge dieser Charge holen,nur wenn
									// mehrere Chargennummer vorhanden sind
									if (aChargeNummer.length > 1) {
										// alle Chargennummern der Position
										List<SeriennrChargennrMitMengeDto> aChargenMitMengeDto = getLagerFac()
												.getAllSeriennrchargennrEinerBelegartposition(
														LocaleFac.BELEGART_LIEFERSCHEIN,
														aLieferscheinpositionDto[iIndex]
																.getIId());

										if (aChargenMitMengeDto != null) {
											for (int u = 0; u < aChargenMitMengeDto
													.size(); u++) {
												SeriennrChargennrMitMengeDto chargenMitMengeDto = aChargenMitMengeDto
														.get(u);
												// Menge der aktuellen Chargenr
												// holen
												if (sChargeNummer
														.equals(chargenMitMengeDto
																.getCSeriennrChargennr())) {
													data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SERIENCHARGENR_MENGE] = chargenMitMengeDto
															.getNMenge();
												}
											}
										}

									}
								}
							}
						}
					}

					// Betrifft Positionen
					else if (aLieferscheinpositionDto[iIndex]
							.getLieferscheinpositionartCNr()
							.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_BETRIFFT)) {
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_FREIERTEXT] = aLieferscheinpositionDto[iIndex]
								.getCBez();
					}

					// Texteingabe Positionen
					else if (aLieferscheinpositionDto[iIndex]
							.getLieferscheinpositionartCNr()
							.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_TEXTEINGABE)) {
						// IMS 1619 leerer Text soll als Leerezeile erscheinen
						String sText = aLieferscheinpositionDto[iIndex]
								.getXTextinhalt();

						if (sText != null && sText.trim().equals("")) {
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LEERZEILE] = " ";
						} else {
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_FREIERTEXT] = sText;
						}
					}

					// Textbaustein Positionen
					else if (aLieferscheinpositionDto[iIndex]
							.getLieferscheinpositionartCNr()
							.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_TEXTBAUSTEIN)) {
						// Dto holen
						MediastandardDto oMediastandardDto = getMediaFac()
								.mediastandardFindByPrimaryKey(
										aLieferscheinpositionDto[iIndex]
												.getMediastandardIId());
						// zum Drucken vorbereiten
						BelegPositionDruckTextbausteinDto druckDto = printTextbaustein(
								oMediastandardDto, theClientDto);
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_FREIERTEXT] = druckDto
								.getSFreierText();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IMAGE] = Helper
								.imageToByteArray(druckDto.getOImage());
					}

					// Leerzeile Positionen
					else if (aLieferscheinpositionDto[iIndex]
							.getLieferscheinpositionartCNr()
							.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_LEERZEILE)) {
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LEERZEILE] = " ";
					}

					else if (aLieferscheinpositionDto[iIndex]
							.getLieferscheinpositionartCNr()
							.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_INTELLIGENTE_ZWISCHENSUMME)) {
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VONPOSITION] = getLieferscheinpositionFac()
								.getLSPositionNummer(
										aLieferscheinpositionDto[iIndex]
												.getZwsVonPosition());
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_BISPOSITION] = getLieferscheinpositionFac()
								.getLSPositionNummer(
										aLieferscheinpositionDto[iIndex]
												.getZwsBisPosition());
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ZWSNETTOSUMME] = aLieferscheinpositionDto[iIndex]
								.getZwsNettoSumme();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_RABATT] = aLieferscheinpositionDto[iIndex]
								.getFRabattsatz();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_IDENT] = aLieferscheinpositionDto[iIndex]
								.getCBez();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_LS_POSITION_NR] = getLieferscheinpositionFac()
								.getLSPositionNummer(
										aLieferscheinpositionDto[iIndex]
												.getIId());
						updateZwischensummenData(i,
								aLieferscheinpositionDto[iIndex]
										.getZwsVonPosition(),
								aLieferscheinpositionDto[iIndex]
										.getZwsBisPosition(),
								aLieferscheinpositionDto[iIndex].getCBez());
					}
					// Seitenumbruch Positionen
					else if (aLieferscheinpositionDto[iIndex]
							.getLieferscheinpositionartCNr()
							.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_SEITENUMBRUCH)) {
						bbSeitenumbruch = new Boolean(
								!bbSeitenumbruch.booleanValue()); // toggle
					}

					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_SEITENUMBRUCH] = bbSeitenumbruch;

					// Positionsart setzen, wenn es keine kuenstliche Position
					// ist
					if (data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] == null) {
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_POSITIONSART] = aLieferscheinpositionDto[iIndex]
								.getLieferscheinpositionartCNr();
					}

					iIndex++; // die naechste
					// Lieferscheinposition
					// bearbeiten
				}
			}

			// die Anzahl der Exemplare ist 1 + Anzahl der Kopien
			int iAnzahlExemplare = 1;

			if (iAnzahlKopienI != null && iAnzahlKopienI.intValue() > 0) {
				iAnzahlExemplare += iAnzahlKopienI.intValue();
			}

			aJasperPrint = new JasperPrintLP[iAnzahlExemplare];
			Integer varianteIId = theClientDto.getReportvarianteIId();
			for (int iKopieNummer = 0; iKopieNummer < iAnzahlExemplare; iKopieNummer++) {
				// jede Kopie bekommt eine Kopienummer, das Original bekommt
				// keine
				if (iKopieNummer > 0) {
					parameter.put(LPReport.P_KOPIE_NUMMER, new Integer(
							iKopieNummer));
				}

				// Index zuruecksetzen !!!
				index = -1;
				theClientDto.setReportvarianteIId(varianteIId);
				initJRDS(parameter, LieferscheinReportFac.REPORT_MODUL,
						LieferscheinReportFac.REPORT_LIEFERSCHEIN,
						theClientDto.getMandant(), locDruck, theClientDto,
						bMitLogo.booleanValue(),
						lieferscheinDto.getKostenstelleIId());

				aJasperPrint[iKopieNummer] = getReportPrint();
			}

			PrintInfoDto values = getJCRDocFac().getPathAndPartnerAndTable(
					lieferscheinDto.getIId(),
					QueryParameters.UC_ID_LIEFERSCHEIN, theClientDto);
			aJasperPrint[0].setOInfoForArchive(values);
			aJasperPrint[0]
					.putAdditionalInformation(JasperPrintLP.KEY_BELEGART,
							LocaleFac.BELEGART_LIEFERSCHEIN);
			aJasperPrint[0].putAdditionalInformation(
					JasperPrintLP.KEY_BELEGIID, lieferscheinDto.getIId());

		} catch (RemoteException ex) {
			throwEJBExceptionLPRespectOld(ex);
		}
		return aJasperPrint;
	}

	/**
	 * Update des Data-Arrays um die Zwischensummenbezeichnung in allen
	 * Positionen verf&uuml;gbar zu haben.
	 * 
	 * @param i
	 *            ist der Index an dem die Zwischensummenposition definiert ist
	 * @param zwsVonPosition
	 *            ist die IId der Von-Position
	 * @param zwsBisPosition
	 *            ist die IId der Bis-Position
	 * @param cBez
	 */
	private void updateZwischensummenData(int lastIndex,
			Integer zwsVonPosition, Integer zwsBisPosition, String cBez) {
		for (int i = 0; i < lastIndex; i++) {
			if (zwsVonPosition
					.equals(data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_INTERNAL_IID])) {
				if (null == data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ZWSTEXT]) {
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ZWSTEXT] = cBez;
				} else {
					String s = (String) data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ZWSTEXT]
							+ "\n" + cBez;
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ZWSTEXT] = s;
				}

				return;
			}
		}
	}

	/**
	 * Das Datenarray des Lieferscheinausdrucks zurueckgeben. Wird vom
	 * Rechnungsdruck verwendet.
	 * 
	 * @param lieferscheinIId
	 *            Integer
	 * @param theClientDto der aktuelle Benutzer
	 * @return Object[][]
	 * @throws EJBExceptionLP
	 */
	public Object[][] getLieferscheinReportData(Integer lieferscheinIId,
			TheClientDto theClientDto) throws EJBExceptionLP {
		printLieferschein(lieferscheinIId, null, Boolean.TRUE,
				LocaleFac.BELEGART_RECHNUNG, theClientDto);
		return data;
	}

	/**
	 * Etikett fuer einen Lieferschein drucken. <br>
	 * Es handelt sich um einen einfachen A6 Druck.
	 * 
	 * @param iIdLieferscheinI
	 *            PK des Lieferschein
	 * @param iPaketnummer
	 *            Integer
	 * @param theClientDto
	 *            der aktuelle Benutzer
	 * @throws EJBExceptionLP
	 *             Ausnahme
	 * @return JasperPrint der Druck
	 */
	@SuppressWarnings("unchecked")
	public JasperPrintLP printLieferscheinEtikett(Integer iIdLieferscheinI,
			Integer iPaketnummer, TheClientDto theClientDto)
			throws EJBExceptionLP {
		checkLieferscheinIId(iIdLieferscheinI);

		// Erstellung des Report
		JasperPrintLP oPrintO = null;
		cAktuellerReport = LieferscheinReportFac.REPORT_LIEFERSCHEIN_ETIKETT;

		try {
			LieferscheinDto lieferscheinDto = getLieferscheinFac()
					.lieferscheinFindByPrimaryKey(iIdLieferscheinI,
							theClientDto);

			KundeDto kundeDto = getKundeFac().kundeFindByPrimaryKey(
					lieferscheinDto.getKundeIIdLieferadresse(), theClientDto);

			AnsprechpartnerDto oAnsprechpartnerDto = null;

			if (lieferscheinDto.getAnsprechpartnerIId() != null) {
				oAnsprechpartnerDto = getAnsprechpartnerFac()
						.ansprechpartnerFindByPrimaryKey(
								lieferscheinDto.getAnsprechpartnerIId(),
								theClientDto);
			}

			MandantDto mandantDto = getMandantFac().mandantFindByPrimaryKey(
					theClientDto.getMandant(), theClientDto);

			// es gilt das Locale des Lieferscheinkunden
			Locale locDruck = Helper.string2Locale(kundeDto.getPartnerDto()
					.getLocaleCNrKommunikation());

			String sAdressefuerausdruck = formatAdresseFuerAusdruck(
					kundeDto.getPartnerDto(), oAnsprechpartnerDto, mandantDto,
					locDruck);

			int iAnzahlZeilen = 1; // Anzahl der Zeilen in der Gruppe
			int iAnzahlSpalten = 4; // Anzahl der Spalten in der Gruppe

			data = new Object[iAnzahlZeilen][iAnzahlSpalten];

			// die Datenmatrix befuellen
			for (int i = 0; i < iAnzahlZeilen; i++) {
				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ADRESSETIKETT] = sAdressefuerausdruck;
			}

			HashMap parameter = new HashMap<Object, Object>();
			parameter.put("P_MANDANTADRESSE",
					Helper.formatMandantAdresse(mandantDto));
			parameter.put("P_VERSANDNUMMER",
					lieferscheinDto.getCVersandnummer());
			parameter.put("P_GEWICHT", lieferscheinDto.getFGewichtLieferung());
			parameter.put("P_LIEFERANTENNR", kundeDto.getCLieferantennr());
			parameter.put("P_KUNDENR", kundeDto.getIKundennummer());
			parameter.put("P_FILIALNR", kundeDto.getPartnerDto()
					.getCFilialnummer());

			// Debitorenkonto des Kunden
			if (kundeDto.getIidDebitorenkonto() != null) {
				KontoDto kontoDto = getFinanzFac().kontoFindByPrimaryKey(
						kundeDto.getIidDebitorenkonto());
				parameter.put("P_KUNDE_DEBITORENKONTO", kontoDto.getCNr());
			}

			SpediteurDto spediteurDto = getMandantFac()
					.spediteurFindByPrimaryKey(
							lieferscheinDto.getSpediteurIId());
			parameter.put("P_SPEDITEUR", spediteurDto.getCNamedesspediteurs());
			parameter.put(
					"P_LIEFERART",
					getLocaleFac().lieferartFindByIIdLocaleOhneExc(
							lieferscheinDto.getLieferartIId(), locDruck,
							theClientDto));
			parameter.put("P_LIEFERSCHEINCNR", lieferscheinDto.getCNr());

			// Anzahl der Pakete bestimmen, die kann nicht kleiner als 1 sein
			Integer iAnzahlDerPakete;
			if (lieferscheinDto.getIAnzahlPakete() == null
					|| lieferscheinDto.getIAnzahlPakete().intValue() <= 1) {
				iAnzahlDerPakete = new Integer(1);
			} else {
				iAnzahlDerPakete = lieferscheinDto.getIAnzahlPakete();
			}
			parameter.put("P_ANZAHLPAKETE", iAnzahlDerPakete);
			// eine bestimmte Paketnummer
			if (iPaketnummer != null) {
				parameter.put("P_PAKETNUMMER", iPaketnummer);
				initJRDS(parameter, LieferscheinReportFac.REPORT_MODUL,
						LieferscheinReportFac.REPORT_LIEFERSCHEIN_ETIKETT,
						theClientDto.getMandant(), locDruck, theClientDto);
				oPrintO = getReportPrint();
			}
			// oder sofort saemtliche Etiketten fuer alle Pakete
			else {
				Integer cachedReportvariante = theClientDto
						.getReportvarianteIId();
				for (int i = 1; i <= iAnzahlDerPakete.intValue(); i++) {
					index = -1;
					iPaketnummer = new Integer(i);
					parameter.put("P_PAKETNUMMER", iPaketnummer);
					theClientDto.setReportvarianteIId(cachedReportvariante);
					initJRDS(parameter, LieferscheinReportFac.REPORT_MODUL,
							LieferscheinReportFac.REPORT_LIEFERSCHEIN_ETIKETT,
							theClientDto.getMandant(), locDruck, theClientDto);
					// der erste
					if (i == 1) {
						oPrintO = getReportPrint();
					}
					// alle anderen dranhaengen
					else {
						oPrintO = Helper.addReport2Report(oPrintO,
								getReportPrint().getPrint());
					}
				}
			}
		} catch (RemoteException ex) {
			throwEJBExceptionLPRespectOld(ex);
		}

		return oPrintO;
	}

	@SuppressWarnings("unchecked")
	public JasperPrintLP printLieferscheinWAEtikett(Integer iIdLieferscheinI,
			Integer iPaketnummer, Integer iIdLieferscheinPositionI,
			BigDecimal bdHandmenge, TheClientDto theClientDto)
			throws EJBExceptionLP {
		checkLieferscheinIId(iIdLieferscheinI);

		// Erstellung des Report
		JasperPrintLP oPrintO = null;
		int iArtikelpositionsnummer = 1;
		cAktuellerReport = LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT;

		try {
			LieferscheinDto lieferscheinDto = getLieferscheinFac()
					.lieferscheinFindByPrimaryKey(iIdLieferscheinI,
							theClientDto);
			LieferscheinpositionDto[] aLieferscheinpositionDto = getLieferscheinpositionFac()
					.getLieferscheinPositionenByLieferschein(
							lieferscheinDto.getIId(), theClientDto);

			int iAnzahlZeilen = 0; // Anzahl der Zeilen in der Gruppe

			for (int i = 0; i < aLieferscheinpositionDto.length; i++) {

				if (iIdLieferscheinPositionI != null
						&& !iIdLieferscheinPositionI
								.equals(aLieferscheinpositionDto[i].getIId())) {
					continue;
				}

				if (aLieferscheinpositionDto[i]
						.getLieferscheinpositionartCNr()
						.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_IDENT)) {
					// Die Zeilenanzahl muss vor dem Befuellen festgelegt
					// werden.
					StuecklisteInfoDto stuecklisteInfoDto = getStuecklisteFac()
							.getStrukturdatenEinesArtikels(
									aLieferscheinpositionDto[i].getArtikelIId(),
									true, null, // in die Rekursion mit einer
									// leeren Listen einsteigen
									0, // in die Rekursion mit Ebene 0
										// einsteigen
									-1, // alle Stuecklisten komplett aufloesen
									false, // Menge pro Einheit der
									// uebergeorndeten Position
									new BigDecimal(1), // fuer 1 Einheit der
									// STKL
									true, // Fremdfertigung aufloesen
									theClientDto);

					iAnzahlZeilen++; // fuer die eigentliche Ident Position
					iAnzahlZeilen += stuecklisteInfoDto.getIiAnzahlPositionen()
							.intValue();
					// Auftragsdaten, wenn die Position auftragsbezogen ist
					if (aLieferscheinpositionDto[i].getAuftragpositionIId() != null) {
						iAnzahlZeilen++;
					}
					// Serien bzw Chargennummer Anzahl des Artikels
					int iAnzahlSerienChargeNr = berechneAnzahlSerienChargeNummern(
							aLieferscheinpositionDto[i].getArtikelIId(),
							aLieferscheinpositionDto[i]
									.getSeriennrChargennrMitMenge(),
							theClientDto);
					iAnzahlZeilen += iAnzahlSerienChargeNr;
				} else if (aLieferscheinpositionDto[i]
						.getLieferscheinpositionartCNr()
						.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_HANDEINGABE)) {
					iAnzahlZeilen++; // fuer die eigentliche Position
					// Auftragsdaten, wenn die Position auftragsbezogen ist
					if (aLieferscheinpositionDto[i].getAuftragpositionIId() != null) {
						iAnzahlZeilen++;
					}
				} else if (aLieferscheinpositionDto[i]
						.getLieferscheinpositionartCNr().equals(
								LocaleFac.POSITIONSART_POSITION)) {
					iAnzahlZeilen++; // fuer die eigentliche Position
					if (aLieferscheinpositionDto[i].getTypCNr().equals(
							LocaleFac.POSITIONTYP_MITPREISE)) {
						Session session = null;
						SessionFactory factory = FLRSessionFactory.getFactory();
						session = factory.openSession();
						Criteria crit = session
								.createCriteria(FLRLieferscheinposition.class);
						crit.add(Restrictions.eq("position_i_id",
								aLieferscheinpositionDto[i].getIId()));
						crit.addOrder(Order
								.asc(RechnungFac.FLR_RECHNUNGPOSITION_I_SORT));
						iAnzahlZeilen = iAnzahlZeilen + crit.list().size();
					}
					// Auftragsdaten, wenn die Position auftragsbezogen ist
					if (aLieferscheinpositionDto[i].getAuftragpositionIId() != null) {
						iAnzahlZeilen++;
					}
				}

				else {
					iAnzahlZeilen++; // fuer die Positionszeile
				}
			}

			KundeDto kundeDto = getKundeFac().kundeFindByPrimaryKey(
					lieferscheinDto.getKundeIIdLieferadresse(), theClientDto);

			AnsprechpartnerDto oAnsprechpartnerDto = null;

			if (lieferscheinDto.getAnsprechpartnerIId() != null) {
				oAnsprechpartnerDto = getAnsprechpartnerFac()
						.ansprechpartnerFindByPrimaryKey(
								lieferscheinDto.getAnsprechpartnerIId(),
								theClientDto);
			}

			MandantDto mandantDto = getMandantFac().mandantFindByPrimaryKey(
					theClientDto.getMandant(), theClientDto);

			// es gilt das Locale des Lieferscheinkunden
			Locale locDruck = Helper.string2Locale(kundeDto.getPartnerDto()
					.getLocaleCNrKommunikation());

			String sAdressefuerausdruck = formatAdresseFuerAusdruck(
					kundeDto.getPartnerDto(), oAnsprechpartnerDto, mandantDto,
					locDruck);

			// data = new Object[iAnzahlZeilen][LieferscheinReportFac.
			// REPORT_LIEFERSCHEIN_WA_ETIKETT_ANZAHL_SPALTEN];
			List<Object> dataList = new ArrayList<Object>(); // in dieser Liste
			String positionsartCNr = null;
			String typCNr = null;
			for (int i = 0; i < aLieferscheinpositionDto.length; i++) {
				if (iIdLieferscheinPositionI != null
						&& !iIdLieferscheinPositionI
								.equals(aLieferscheinpositionDto[i].getIId())) {
					continue;
				}

				positionsartCNr = aLieferscheinpositionDto[i]
						.getLieferscheinpositionartCNr();
				typCNr = aLieferscheinpositionDto[i].getTypCNr();
				if (typCNr == null) {
					if (positionsartCNr
							.equals(AngebotServiceFac.ANGEBOTPOSITIONART_IDENT)
							|| positionsartCNr
									.equals(AngebotServiceFac.ANGEBOTPOSITIONART_HANDEINGABE)
							|| positionsartCNr
									.equals(AngebotServiceFac.ANGEBOTPOSITIONART_AGSTUECKLISTE)) {
						dataList.add(befuelleZeileMitPreisbehafteterPosition(
								aLieferscheinpositionDto[i], lieferscheinDto,
								kundeDto, iArtikelpositionsnummer, null, false,
								locDruck, theClientDto));

						iArtikelpositionsnummer++;
					}
				}
			}
			// jetzt die Map mit dataRows in ein Object[][] fuer den Druck
			// umwandeln
			data = new Object[dataList.size()][LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ANZAHL_SPALTEN];
			data = (Object[][]) dataList.toArray(data);

			HashMap parameter = new HashMap<Object, Object>();
			parameter.put("Mandantenadresse",
					Helper.formatMandantAdresse(mandantDto));
			parameter.put("P_VERSANDNUMMER",
					lieferscheinDto.getCVersandnummer());
			parameter.put("P_HANDMENGE", bdHandmenge);

			parameter.put("P_PROJEKT",
					lieferscheinDto.getCBezProjektbezeichnung());
			parameter.put("P_LIEFERSCHEINNUMMER", lieferscheinDto.getCNr());
			parameter.put("P_KOMMISSION", lieferscheinDto.getCKommission());

			if (lieferscheinDto.getAuftragIId() != null) {
				AuftragDto auftragDto = getAuftragFac()
						.auftragFindByPrimaryKey(
								lieferscheinDto.getAuftragIId());
				parameter.put("P_AUFTRAGSNUMMER", auftragDto.getCNr());
			}
			parameter.put("P_LIEFERANTENNUMMER", kundeDto.getCLieferantennr());

			// sAdressefuerausdruck = sAdressefuerausdruck.replace("\n", " ");
			parameter.put("P_KUNDE_ADRESSBLOCK", sAdressefuerausdruck);

			if (lieferscheinDto.getAuftragIId() != null) {
				AuftragDto auftragDto = getAuftragFac()
						.auftragFindByPrimaryKey(
								lieferscheinDto.getAuftragIId());
				AnsprechpartnerDto oAnsprechpartnerAuftragDto = null;
				if (auftragDto.getAnsprechparnterIId() != null) {
					oAnsprechpartnerAuftragDto = getAnsprechpartnerFac()
							.ansprechpartnerFindByPrimaryKey(
									auftragDto.getAnsprechparnterIId(),
									theClientDto);
				}

				KundeDto kundeAuftragDto = getKundeFac().kundeFindByPrimaryKey(
						auftragDto.getKundeIIdAuftragsadresse(), theClientDto);

				String sAuftragsAdressefuerausdruck = formatAdresseFuerAusdruck(
						kundeAuftragDto.getPartnerDto(),
						oAnsprechpartnerAuftragDto, mandantDto, locDruck);
				parameter.put("P_KUNDEAUFTRAG_ADRESSBLOCK",
						sAuftragsAdressefuerausdruck);
			}

			parameter.put("P_BESTELLNUMMER",
					lieferscheinDto.getCBestellnummer());
			parameter.put("P_BELEGDATUM", Helper.formatDatum(
					lieferscheinDto.getTBelegdatum(), locDruck));
			parameter.put("P_LIEFERTERMIN", Helper.formatDatum(
					lieferscheinDto.getTLiefertermin(), locDruck));

			parameter.put("P_PAKETE", lieferscheinDto.getIAnzahlPakete());
			parameter.put("P_GEWICHT", lieferscheinDto.getFGewichtLieferung());
			parameter.put("P_VERSANDNUMMER",
					lieferscheinDto.getCVersandnummer());

			// Anzahl der Pakete bestimmen, die kann nicht kleiner als 1 sein
			Integer iAnzahlDerPakete;
			if (lieferscheinDto.getIAnzahlPakete() == null
					|| lieferscheinDto.getIAnzahlPakete().intValue() <= 1) {
				iAnzahlDerPakete = new Integer(1);
			} else {
				iAnzahlDerPakete = lieferscheinDto.getIAnzahlPakete();
			}
			parameter.put("P_ANZAHLPAKETE", iAnzahlDerPakete);

			// eine bestimmte Paketnummer
			if (iPaketnummer != null) {
				parameter.put("P_PAKETNUMMER", iPaketnummer);
				initJRDS(parameter, LieferscheinReportFac.REPORT_MODUL,
						LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT,
						theClientDto.getMandant(), locDruck, theClientDto);
				oPrintO = getReportPrint();
			}
			// oder sofort saemtliche Etiketten fuer alle Pakete
			else {
				Integer varianteIId = theClientDto.getReportvarianteIId();
				for (int i = 1; i <= iAnzahlDerPakete.intValue(); i++) {
					index = -1;
					iPaketnummer = new Integer(i);
					parameter.put("P_PAKETNUMMER", iPaketnummer);
					theClientDto.setReportvarianteIId(varianteIId);

					initJRDS(
							parameter,
							LieferscheinReportFac.REPORT_MODUL,
							LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT,
							theClientDto.getMandant(), locDruck, theClientDto);
					// der erste
					if (i == 1) {
						oPrintO = getReportPrint();
					}
					// alle anderen dranhaengen
					else {
						oPrintO = Helper.addReport2Report(oPrintO,
								getReportPrint().getPrint());
					}
				}
			}

		} catch (RemoteException ex) {
			throwEJBExceptionLPRespectOld(ex);
		}

		return oPrintO;
	}

	private Integer getGesamtAnzahlAnAuftraegen(LieferscheinDto lieferscheinDto) {

		HashMap hmAuftraege = new HashMap();

		if (lieferscheinDto.getAuftragIId() != null) {
			hmAuftraege.put(lieferscheinDto.getAuftragIId(), "");
		}

		// Auftrage aus LS-Positionen
		Session session = FLRSessionFactory.getFactory().openSession();
		String sQuery = "SELECT distinct auftragpos.auftrag_i_id FROM FLRLieferscheinposition lp LEFT OUTER JOIN lp.flrpositionensichtauftrag AS auftragpos WHERE lp.flrlieferschein.i_id="
				+ lieferscheinDto.getIId() + " ";

		Query querylagerbewegungen = session.createQuery(sQuery);
		List<?> results = querylagerbewegungen.list();
		Iterator<?> resultListIterator = results.iterator();
		while (resultListIterator.hasNext()) {
			Integer auftragIId = (Integer) resultListIterator.next();
			if (auftragIId != null && !hmAuftraege.containsKey(auftragIId)) {
				hmAuftraege.put(auftragIId, "");

			}
		}
		session.close();

		return hmAuftraege.size();
	}

	public int getGesamtzahlPakete(Integer iIdLieferscheinI,
			TheClientDto theClientDto) {
		int iAnzahl = 0;

		try {
			LieferscheinDto lieferscheinDto = getLieferscheinFac()
					.lieferscheinFindByPrimaryKey(iIdLieferscheinI,
							theClientDto);
			LieferscheinpositionDto[] aLieferscheinpositionDto = getLieferscheinpositionFac()
					.getLieferscheinPositionenByLieferschein(
							lieferscheinDto.getIId(), theClientDto);

			for (int i = 0; i < aLieferscheinpositionDto.length; i++) {
				iAnzahl += getAnzahlPaketeEinerPosition(
						aLieferscheinpositionDto[i].getIId(), theClientDto);
			}

		} catch (RemoteException ex) {
			throwEJBExceptionLPRespectOld(ex);
		}

		return iAnzahl;
	}

	public int getAnzahlPaketeEinerPosition(Integer iIdLieferscheinpositionI,
			TheClientDto theClientDto) {
		int iAnzahl = 0;
		try {
			LieferscheinpositionDto lsPos = getLieferscheinpositionFac()
					.lieferscheinpositionFindByPrimaryKey(
							iIdLieferscheinpositionI, theClientDto);

			if (lsPos.getPositionsartCNr().equals(
					LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_IDENT)) {
				ArtikelDto artikelDto = getArtikelFac()
						.artikelFindByPrimaryKey(lsPos.getArtikelIId(),
								theClientDto);

				if (artikelDto.getFVerpackungsmenge() == null
						|| artikelDto.getFVerpackungsmenge() == 0) {
					iAnzahl += 1;
				} else {
					iAnzahl += lsPos.getNMenge().doubleValue()
							/ artikelDto.getFVerpackungsmenge();
					if (lsPos.getNMenge().doubleValue()
							% artikelDto.getFVerpackungsmenge() > 0) {
						iAnzahl += 1;
					}
				}

			}

		} catch (RemoteException ex) {
			throwEJBExceptionLPRespectOld(ex);
		}
		return iAnzahl;
	}

	public JasperPrintLP printVersandetikett(Integer iIdLieferscheinI,
			TheClientDto theClientDto) {
		checkLieferscheinIId(iIdLieferscheinI);

		// Erstellung des Report
		cAktuellerReport = LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETTEN;

		try {
			LieferscheinDto lieferscheinDto = getLieferscheinFac()
					.lieferscheinFindByPrimaryKey(iIdLieferscheinI,
							theClientDto);
			LieferscheinpositionDto[] aLieferscheinpositionDto = getLieferscheinpositionFac()
					.getLieferscheinPositionenByLieferschein(
							lieferscheinDto.getIId(), theClientDto);

			KundeDto kundeDto = getKundeFac().kundeFindByPrimaryKey(
					lieferscheinDto.getKundeIIdLieferadresse(), theClientDto);

			AnsprechpartnerDto oAnsprechpartnerDto = null;

			if (lieferscheinDto.getAnsprechpartnerIId() != null) {
				oAnsprechpartnerDto = getAnsprechpartnerFac()
						.ansprechpartnerFindByPrimaryKey(
								lieferscheinDto.getAnsprechpartnerIId(),
								theClientDto);
			}

			MandantDto mandantDto = getMandantFac().mandantFindByPrimaryKey(
					theClientDto.getMandant(), theClientDto);

			// es gilt das Locale des Lieferscheinkunden
			Locale locDruck = Helper.string2Locale(kundeDto.getPartnerDto()
					.getLocaleCNrKommunikation());

			String sAdressefuerausdruck = formatAdresseFuerAusdruck(
					kundeDto.getPartnerDto(), oAnsprechpartnerDto, mandantDto,
					locDruck);

			HashMap parameter = new HashMap<Object, Object>();
			parameter.put("Mandantenadresse",
					Helper.formatMandantAdresse(mandantDto));
			parameter.put("P_VERSANDNUMMER",
					lieferscheinDto.getCVersandnummer());

			parameter.put("P_PROJEKT",
					lieferscheinDto.getCBezProjektbezeichnung());
			parameter.put("P_LIEFERSCHEINNUMMER", lieferscheinDto.getCNr());
			parameter.put(
					"P_ZIELLAGER",
					getLagerFac().lagerFindByPrimaryKey(
							lieferscheinDto.getLagerIId()).getCNr());
			parameter.put("P_KOMMISSION", lieferscheinDto.getCKommission());

			if (lieferscheinDto.getAuftragIId() != null) {
				AuftragDto auftragDto = getAuftragFac()
						.auftragFindByPrimaryKey(
								lieferscheinDto.getAuftragIId());
				parameter.put("P_AUFTRAGSNUMMER", auftragDto.getCNr());
			}
			parameter.put("P_LIEFERANTENNUMMER", kundeDto.getCLieferantennr());

			// sAdressefuerausdruck = sAdressefuerausdruck.replace("\n", " ");
			parameter.put("P_KUNDE_ADRESSBLOCK", sAdressefuerausdruck);

			if (lieferscheinDto.getAuftragIId() != null) {
				AuftragDto auftragDto = getAuftragFac()
						.auftragFindByPrimaryKey(
								lieferscheinDto.getAuftragIId());
				AnsprechpartnerDto oAnsprechpartnerAuftragDto = null;
				if (auftragDto.getAnsprechparnterIId() != null) {
					oAnsprechpartnerAuftragDto = getAnsprechpartnerFac()
							.ansprechpartnerFindByPrimaryKey(
									auftragDto.getAnsprechparnterIId(),
									theClientDto);
				}

				KundeDto kundeAuftragDto = getKundeFac().kundeFindByPrimaryKey(
						auftragDto.getKundeIIdAuftragsadresse(), theClientDto);

				String sAuftragsAdressefuerausdruck = formatAdresseFuerAusdruck(
						kundeAuftragDto.getPartnerDto(),
						oAnsprechpartnerAuftragDto, mandantDto, locDruck);
				parameter.put("P_KUNDEAUFTRAG_ADRESSBLOCK",
						sAuftragsAdressefuerausdruck);
			}

			parameter.put("P_BESTELLNUMMER",
					lieferscheinDto.getCBestellnummer());
			parameter.put("P_BELEGDATUM", Helper.formatDatum(
					lieferscheinDto.getTBelegdatum(), locDruck));
			parameter.put("P_LIEFERTERMIN", Helper.formatDatum(
					lieferscheinDto.getTLiefertermin(), locDruck));

			parameter.put("P_PAKETE", lieferscheinDto.getIAnzahlPakete());
			parameter.put("P_GEWICHT", lieferscheinDto.getFGewichtLieferung());
			parameter.put("P_VERSANDNUMMER",
					lieferscheinDto.getCVersandnummer());

			parameter.put(
					"P_PAKETEGESAMT",
					new Integer(getGesamtzahlPakete(iIdLieferscheinI,
							theClientDto)));

			int iAktuellesPaket = 0;

			ArrayList alDaten = new ArrayList();

			for (int i = 0; i < aLieferscheinpositionDto.length; i++) {

				int iAnzahlPosition = getAnzahlPaketeEinerPosition(
						aLieferscheinpositionDto[i].getIId(), theClientDto);

				BigDecimal bdPaketmenge = aLieferscheinpositionDto[i]
						.getNMenge();

				for (int j = 0; j < iAnzahlPosition; j++) {
					iAktuellesPaket++;

					Object[] oZeileVersand = new Object[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ANZAHL_SPALTEN];

					// Positionsdaten

					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_BEZ] =

					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_AKTUELLESPAKET] = new Integer(
							iAktuellesPaket);

					Object[] oZeile = befuelleZeileMitPreisbehafteterPosition(
							aLieferscheinpositionDto[i], lieferscheinDto,
							kundeDto, 0, null, false, locDruck, theClientDto);
					if (aLieferscheinpositionDto[i]
							.getPositionsartCNr()
							.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_IDENT)) {
						ArtikelDto artikelDto = getArtikelFac()
								.artikelFindByPrimaryKey(
										aLieferscheinpositionDto[i]
												.getArtikelIId(),
										theClientDto);

						oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_VERPACKUNGSMENGE] = artikelDto
								.getFVerpackungsmenge();

						if (artikelDto.getFVerpackungsmenge() != null) {

							if (bdPaketmenge.doubleValue() < artikelDto
									.getFVerpackungsmenge()) {

								oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_PAKETMENGE] = bdPaketmenge;

							} else {

								oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_PAKETMENGE] = new BigDecimal(
										artikelDto.getFVerpackungsmenge());

							}

							bdPaketmenge = bdPaketmenge
									.subtract(new BigDecimal(artikelDto
											.getFVerpackungsmenge()));

						}

					}

					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_BEZ] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_BEZ];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_BESTELLNUMMER] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_BESTELLNUMMER];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_ZBEZ] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_ZBEZ];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_KBEZ] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_KBEZ];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_ZBEZ2] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_ZBEZ2];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_REFERENZNUMMER] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_REFERENZNUMMER];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_REVISION] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_REVISION];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_TEXTEINGABE] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_TEXTEINGABE];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_INDEX] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_INDEX];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_GEWICHT] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_GEWICHT];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_IDENT] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_IDENT];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_KUNDENARTIKELNUMMER] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_KUNDENARTIKELNUMMER];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ARTIKEL_WE_REFERENZ] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_WE_REFERENZ];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_EINHEIT] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_EINHEIT];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_ANLIEFERMENGE] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_MENGE];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_SERIENCHARGENR] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_SERIENCHARGENR];
					oZeileVersand[REPORT_LIEFERSCHEIN_VERSANDETIKETT_POSITION] = oZeile[REPORT_LIEFERSCHEIN_WA_ETIKETT_POSITION];

					alDaten.add(oZeileVersand);
				}

			}

			data = new Object[alDaten.size()][LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETT_ANZAHL_SPALTEN];
			data = (Object[][]) alDaten.toArray(data);

			initJRDS(parameter, LieferscheinReportFac.REPORT_MODUL,
					LieferscheinReportFac.REPORT_LIEFERSCHEIN_VERSANDETIKETTEN,
					theClientDto.getMandant(), locDruck, theClientDto);

			return getReportPrint();
		} catch (RemoteException ex) {
			throwEJBExceptionLPRespectOld(ex);
			return null;
		}

	}

	/**
	 * Alle offenen Lieferscheine fuer einen bestimmten Mandanten drucken.
	 * 
	 * @param reportJournalKriterienDtoI
	 *            die Filter- und Sortierkriterien
	 * @param theClientDto
	 *            der aktuelle Benutzer
	 * @throws EJBExceptionLP
	 *             Ausnahme
	 * @return JasperPrint der Druck
	 */

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public JasperPrintLP printLieferscheinOffene(
			ReportJournalKriterienDto reportJournalKriterienDtoI, Integer iArt,
			boolean bMitDetails, TheClientDto theClientDto)
			throws EJBExceptionLP {
		if (reportJournalKriterienDtoI == null) {
			throw new EJBExceptionLP(EJBExceptionLP.FEHLER_PARAMETER_IS_NULL,
					new Exception("reportJournalKriterienDtoI == null"));
		}
		JasperPrintLP oPrintO = null;
		cAktuellerReport = LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE;
		int iIndex = 0;
		ArrayList<FLRLieferschein> oZeilen = new ArrayList();
		SessionFactory factory = FLRSessionFactory.getFactory();
		Session session = null;
		try {
			session = factory.openSession();
			// Hiberante Criteria fuer alle Tabellen ausgehend von meiner
			// Haupttabelle anlegen,
			// nach denen ich filtern und sortieren kann
			Criteria crit = session.createCriteria(FLRLieferschein.class);
			// Einschraenkung auf den aktuellen Mandanten
			crit.add(Restrictions.eq("mandant_c_nr", theClientDto.getMandant()));
			// Einschraenkung nach Status Offen
			crit.add(Restrictions
					.eq(LieferscheinFac.FLR_LIEFERSCHEIN_LIEFERSCHEINSTATUS_STATUS_C_NR,
							LieferscheinFac.LSSTATUS_GELIEFERT));
			if (iArt != null) {
				if (iArt == 1) {
					crit.add(Restrictions.eq(
							LieferscheinFac.FLR_LIEFERSCHEIN_B_VERRECHENBAR,
							Helper.boolean2Short(true)));
				} else if (iArt == 2) {
					crit.add(Restrictions.eq(
							LieferscheinFac.FLR_LIEFERSCHEIN_B_VERRECHENBAR,
							Helper.boolean2Short(false)));
				}
			}
			// Einschraenkung nach einer bestimmten Kostenstelle
			if (reportJournalKriterienDtoI.kostenstelleIId != null) {
				crit.add(Restrictions.eq(
						LieferscheinFac.FLR_LIEFERSCHEIN_KOSTENSTELLE_I_ID,
						reportJournalKriterienDtoI.kostenstelleIId));
			}

			// Einschraenkung nach einem bestimmten Kunden
			if (reportJournalKriterienDtoI.kundeIId != null) {
				crit.add(Restrictions
						.eq(LieferscheinFac.FLR_LIEFERSCHEIN_KUNDE_I_ID_LIEFERADRESSE,
								reportJournalKriterienDtoI.kundeIId));
			}

			// Einschraenkung nach Belegdatum von - bis
			String sVon = null;
			String sBis = null;

			if (reportJournalKriterienDtoI.dVon != null) {
				crit.add(Restrictions.ge(
						LieferscheinFac.FLR_LIEFERSCHEIN_D_BELEGDATUM,
						reportJournalKriterienDtoI.dVon));
				sVon = Helper.formatDatum(reportJournalKriterienDtoI.dVon,
						theClientDto.getLocUi());
			}

			if (reportJournalKriterienDtoI.dBis != null) {
				crit.add(Restrictions.le(
						LieferscheinFac.FLR_LIEFERSCHEIN_D_BELEGDATUM,
						reportJournalKriterienDtoI.dBis));
				sBis = Helper.formatDatum(reportJournalKriterienDtoI.dBis,
						theClientDto.getLocUi());
			}

			// Einschraenkung nach Belegnummer von - bis
			LpBelegnummerFormat f = getBelegnummerGeneratorObj()
					.getBelegnummernFormat(theClientDto.getMandant());

			Integer iGeschaeftsjahr = getParameterFac().getGeschaeftsjahr(
					theClientDto.getMandant());

			String sMandantKuerzel = getParameterFac().getMandantparameter(
					theClientDto.getMandant(),
					ParameterFac.KATEGORIE_ALLGEMEIN,
					ParameterFac.PARAMETER_BELEGNUMMER_MANDANTKENNUNG)
					.getCWert();

			if (reportJournalKriterienDtoI.sBelegnummerVon != null) {
				sVon = HelperServer.getBelegnummernFilterForHibernateCriterias(
						f, iGeschaeftsjahr, sMandantKuerzel,
						reportJournalKriterienDtoI.sBelegnummerVon);
				crit.add(Restrictions.ge("c_nr", sVon));
			}

			if (reportJournalKriterienDtoI.sBelegnummerBis != null) {
				sBis = HelperServer.getBelegnummernFilterForHibernateCriterias(
						f, iGeschaeftsjahr, sMandantKuerzel,
						reportJournalKriterienDtoI.sBelegnummerBis);
				crit.add(Restrictions.le("c_nr", sBis));
			}

			// Sortierung nach Kostenstelle ist immer die erste Sortierung
			if (reportJournalKriterienDtoI.bSortiereNachKostenstelle) {
				crit.createCriteria(
						LieferscheinFac.FLR_LIEFERSCHEIN_FLRKOSTENSTELLE)
						.addOrder(Order.asc("c_nr"));
			}

			// Sortierung nach Kunde, eventuell innerhalb der Kostenstelle
			if (reportJournalKriterienDtoI.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_PARTNER) {
				crit.createCriteria(LieferscheinFac.FLR_LIEFERSCHEIN_FLRKUNDE)
						.createCriteria(KundeFac.FLR_PARTNER)
						.addOrder(
								Order.asc(PartnerFac.FLR_PARTNER_NAME1NACHNAMEFIRMAZEILE1));
			}

			// es wird in jedem Fall nach der Belegnummer sortiert
			crit.addOrder(Order.asc("c_nr"));
			List<?> list = crit.list();
			Iterator<?> it = list.iterator();
			while (it.hasNext()) {
				FLRLieferschein flrlieferschein = (FLRLieferschein) it.next();
				oZeilen.add(flrlieferschein);
				session = factory.openSession();
				Criteria critPosition = session
						.createCriteria(FLRLieferscheinposition.class);
				critPosition
						.add(Restrictions
								.eq(LieferscheinpositionFac.FLR_LIEFERSCHEINPOSITION_FLRLIEFERSCHEIN,
										flrlieferschein));
				critPosition
						.add(Restrictions.or(
								Restrictions
										.isNotNull(LieferscheinpositionFac.FLR_LIEFERSCHEINPOSITION_N_MENGE),
								Restrictions
										.eq(LieferscheinpositionFac.FLR_LIEFERSCHEINPOSITION_LIEFERSCHEINPOSITIONART_C_NR,
												LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_TEXTEINGABE)));
				// critPosition
				// .add(Restrictions
				// .isNotNull(LieferscheinpositionFac.FLR_LIEFERSCHEINPOSITION_N_MENGE));
				List<?> posList = critPosition.list();
				for (Iterator<?> ipos = posList.iterator(); ipos.hasNext();) {
					FLRLieferscheinposition item = (FLRLieferscheinposition) ipos
							.next();
					iIndex++;
				}
				iIndex++;
			}
			data = new Object[iIndex][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ANZAHL_ZEILEN]; // Anzahl
			// der
			// Spalten
			// in
			// der
			// Gruppe
			Iterator<?> itZeilen = oZeilen.iterator();
			int i = 0;
			while (itZeilen.hasNext()) {
				FLRLieferschein flrlieferschein = (FLRLieferschein) itZeilen
						.next();
				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERSCHEINCNR] = flrlieferschein
						.getC_nr();
				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERSCHEINKUNDE] = flrlieferschein
						.getFlrkunde().getFlrpartner()
						.getC_name1nachnamefirmazeile1();
				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_KOSTENSTELLECNR] = flrlieferschein
						.getFlrkostenstelle().getC_nr();
				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ANLAGEDATUM] = flrlieferschein
						.getD_belegdatum(); // todo
				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERTERMIN] = flrlieferschein
						.getT_liefertermin();
				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ZAHLUNGSZIEL] = getMandantFac()
						.zahlungszielFindByIIdLocaleOhneExc(
								flrlieferschein.getZahlungsziel_i_id(),
								theClientDto.getLocMandant(), theClientDto);
				if (flrlieferschein.getFlrauftrag() != null) {
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_AUFTRAGSNUMMER] = flrlieferschein
							.getFlrauftrag().getC_nr();
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_AUFTRAG_PROJEKT] = flrlieferschein
							.getFlrauftrag().getC_bez();
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_BESTELLNUMMER] = flrlieferschein
							.getFlrauftrag().getC_bestellnummer();
				} else {
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_AUFTRAGSNUMMER] = null;
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_AUFTRAG_PROJEKT] = null;
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_BESTELLNUMMER] = null;
				}
				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERART] = getLocaleFac()
						.lieferartFindByIIdLocaleOhneExc(
								flrlieferschein.getLieferart_i_id(),
								theClientDto.getLocMandant(), theClientDto);

				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERARTORT] = flrlieferschein
						.getC_lieferartort();
				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_VERRECHENBAR] = Helper
						.short2Boolean(flrlieferschein.getB_verrechenbar());
				if (flrlieferschein.getFlrziellager() != null) {
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ZIELLAGER] = flrlieferschein
							.getFlrziellager().getC_nr();
				}
				if (flrlieferschein.getFlrlager() != null) {
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ABLAGER] = flrlieferschein
							.getFlrlager().getC_nr();
				}

				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_RECHNUNGSADRESSE] = flrlieferschein
						.getFlrkunderechnungsadresse().getFlrpartner()
						.getC_name1nachnamefirmazeile1();

				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_VERRECHENBAR] = Helper
						.short2Boolean(flrlieferschein.getB_verrechenbar());

				if (flrlieferschein.getSpediteur_i_id() != null) {
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_SPEDITEUR] = getMandantFac()
							.spediteurFindByPrimaryKey(
									flrlieferschein.getSpediteur_i_id())
							.getCNamedesspediteurs();
				} else {
					data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_SPEDITEUR] = null;
				}
				data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_PROJEKTBEZEICHNUNG] = flrlieferschein
						.getC_bez_projektbezeichnung();
				session = factory.openSession();
				Criteria critPosition = session
						.createCriteria(FLRLieferscheinposition.class);
				critPosition
						.add(Restrictions
								.eq(LieferscheinpositionFac.FLR_LIEFERSCHEINPOSITION_FLRLIEFERSCHEIN,
										flrlieferschein));

				critPosition
						.add(Restrictions.or(
								Restrictions
										.isNotNull(LieferscheinpositionFac.FLR_LIEFERSCHEINPOSITION_N_MENGE),
								Restrictions
										.eq(LieferscheinpositionFac.FLR_LIEFERSCHEINPOSITION_LIEFERSCHEINPOSITIONART_C_NR,
												LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_TEXTEINGABE)));

				// critPosition
				// .add(Restrictions
				// .isNotNull(LieferscheinpositionFac.FLR_LIEFERSCHEINPOSITION_N_MENGE));
				List<?> posList = critPosition.list();
				boolean darfVerkaufspreisSehen = getTheJudgeFac().hatRecht(
						RechteFac.RECHT_LP_DARF_PREISE_SEHEN_VERKAUF,
						theClientDto);

				for (Iterator<?> ipos = posList.iterator(); ipos.hasNext();) {
					FLRLieferscheinposition item = (FLRLieferscheinposition) ipos
							.next();
					i++;// in die naechste Zeile vorruecken
					// nur mengenbehaftete Positionen beruecksichtigen
					if (item.getN_menge() != null) {
						String artikelCNr = null;
						// TODO boeser Workaround ... PJ 4400
						if (item.getFlrartikel().getC_nr().startsWith("~")) {
							artikelCNr = AngebotReportFac.REPORT_VORKALKULATION_ZEICHEN_FUER_HANDEINGABE;
						} else {
							artikelCNr = item.getFlrartikel().getC_nr();
						}
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELCNR] = artikelCNr;
						String cArtikelBezeichnung = "";

						if (item.getPositionsart_c_nr()
								.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_IDENT)
								|| item.getPositionsart_c_nr()
										.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_HANDEINGABE)) {
							cArtikelBezeichnung = getArtikelFac()
									.baueArtikelBezeichnungMehrzeiligOhneExc(
											item.getFlrartikel().getI_id(),
											item.getPositionsart_c_nr(),
											item.getC_bez(), item.getC_zbez(),
											false, null, theClientDto);
						}

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELBEZEICHNUNG] = cArtikelBezeichnung;
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELMENGE] = item
								.getN_menge();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELEINHEIT] = item
								.getEinheit_c_nr() == null ? null : item
								.getEinheit_c_nr().trim();

						if (darfVerkaufspreisSehen) {
							// Positionspreise sind in Belegwaehrung abgelegt
							BigDecimal nPreisInBelegwaehrung = item
									.getN_nettogesamtpreisplusversteckteraufschlagminusrabatt();

							nPreisInBelegwaehrung = getBetragMalWechselkurs(
									nPreisInBelegwaehrung,
									Helper.getKehrwert(new BigDecimal(
											flrlieferschein
													.getF_wechselkursmandantwaehrungzulieferscheinwaehrung()
													.doubleValue())));

							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELNETTOGESAMTPREISPLUSVERSTECKTERAUFSCHLAGMINUSRABATT] = nPreisInBelegwaehrung;
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELOFFENERWERT] = item
									.getN_menge().multiply(
											nPreisInBelegwaehrung);
						} else {
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELNETTOGESAMTPREISPLUSVERSTECKTERAUFSCHLAGMINUSRABATT] = null;
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELOFFENERWERT] = null;
						}

						// Grundlage ist der positionsbezogene Gestehungspreis
						// des Artikels.
						BigDecimal bdGestehungspreis = Helper
								.getBigDecimalNull();

						if (item.getPositionsart_c_nr()
								.equals(LieferscheinpositionFac.LIEFERSCHEINPOSITIONSART_IDENT)) {
							try {
								BigDecimal bdGestehungswert = getLieferscheinFac()
										.berechneGestehungswertEinerLieferscheinposition(
												item.getI_id(), theClientDto);

								// Gestehungspreis bezogen auf 1 Stueck wird
								// gemittelt
								bdGestehungspreis = bdGestehungswert.divide(
										item.getN_menge(), 4,
										BigDecimal.ROUND_HALF_EVEN);
								bdGestehungspreis = Helper.rundeKaufmaennisch(
										bdGestehungspreis, 4);
							} catch (Throwable t) {
								// dieser Fall sollte nicht auftreten, bitte als
								// moeglichen Fehler pruefen!
							}
						}

						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELGESTEHUNGSPREIS] = bdGestehungspreis;
						if (darfVerkaufspreisSehen) {
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELOFFENERDB] = item
									.getN_menge().multiply(bdGestehungspreis);
						} else {
							data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_ARTIKELOFFENERDB] = null;
						}
						// die Positionen brauchen alle Attribute, nach denen im
						// Report gruppiert wird
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERSCHEINCNR] = flrlieferschein
								.getC_nr();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_KOSTENSTELLECNR] = flrlieferschein
								.getFlrkostenstelle().getC_nr();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERSCHEINKUNDE] = flrlieferschein
								.getFlrkunde().getFlrpartner()
								.getC_name1nachnamefirmazeile1();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERSCHEINCNR] = flrlieferschein
								.getC_nr(); // fuer die Gruppierung
					} else if (item.getPositionsart_c_nr().equals(
							LocaleFac.POSITIONSART_TEXTEINGABE)) {
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_TEXTEINGABE] = item
								.getC_textinhalt();
						// die Positionen brauchen alle Attribute, nach denen im
						// Report gruppiert wird
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERSCHEINCNR] = flrlieferschein
								.getC_nr();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_KOSTENSTELLECNR] = flrlieferschein
								.getFlrkostenstelle().getC_nr();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERSCHEINKUNDE] = flrlieferschein
								.getFlrkunde().getFlrpartner()
								.getC_name1nachnamefirmazeile1();
						data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE_LIEFERSCHEINCNR] = flrlieferschein
								.getC_nr(); // fuer die Gruppierung
					}
				}
				i++; // in die naechste Zeile vorruecken
			}
			// Erstellung des Report
			HashMap parameter = new HashMap<Object, Object>();
			// die Parameter dem Report uebergeben
			parameter.put(
					LPReport.P_SORTIERUNG,
					buildSortierungLieferscheinOffene(
							reportJournalKriterienDtoI, theClientDto));
			parameter.put(
					LPReport.P_FILTER,
					buildFilterLieferscheinOffene(reportJournalKriterienDtoI,
							theClientDto));
			// die Parameter zur Bildung von Zwischensummen uebergeben
			if (reportJournalKriterienDtoI.bSortiereNachKostenstelle) {
				parameter.put(LPReport.P_SORTIERENACHKOSTENSTELLE, new Boolean(
						true));
			} else {
				parameter.put(LPReport.P_SORTIERENACHKOSTENSTELLE, new Boolean(
						false));
			}
			if (reportJournalKriterienDtoI.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_PARTNER) {
				parameter.put(LPReport.P_SORTIERENACHKUNDE, new Boolean(true));
			} else {
				parameter.put(LPReport.P_SORTIERENACHKUNDE, new Boolean(false));
			}
			parameter.put("P_LIEFERSCHEINWAEHRUNG",
					theClientDto.getSMandantenwaehrung());
			parameter.put("P_DETAILS", new Boolean(bMitDetails));

			initJRDS(parameter, LieferscheinReportFac.REPORT_MODUL,
					LieferscheinReportFac.REPORT_LIEFERSCHEIN_OFFENE,
					theClientDto.getMandant(), theClientDto.getLocUi(),
					theClientDto);

			oPrintO = getReportPrint();
		} catch (RemoteException re) {
			throwEJBExceptionLPRespectOld(re);
		} finally {
			closeSession(session);
		}
		return oPrintO;
	}

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public JasperPrintLP printLieferscheinAngelegte(
			ReportJournalKriterienDto reportJournalKriterienDtoI,
			TheClientDto theClientDto) throws EJBExceptionLP {

		if (reportJournalKriterienDtoI == null) {
			throw new EJBExceptionLP(EJBExceptionLP.FEHLER_PARAMETER_IS_NULL,
					new Exception("reportJournalKriterienDtoI == null"));
		}

		cAktuellerReport = LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE;

		// die Liste aller angelegten Lieferscheine entsprechend den Kriterien
		// zusammenstellen
		ReportLieferscheinAngelegteDto[] aReportLieferscheinAngelegteDto = getListeReportLieferscheinAngelegte(
				reportJournalKriterienDtoI, theClientDto);

		// es gilt das Locale des aktuellen Benutzers
		Locale locDruck = theClientDto.getLocUi();

		int iAnzahlZeilen = aReportLieferscheinAngelegteDto.length; // Anzahl
		// der
		// Zeilen in
		// der
		// Gruppe
		int iAnzahlSpalten = 5; // Anzahl der Spalten in der Gruppe

		data = new Object[iAnzahlZeilen][iAnzahlSpalten];

		// die Datenmatrix befuellen
		for (int i = 0; i < iAnzahlZeilen; i++) {
			ReportLieferscheinAngelegteDto reportLieferscheinAngelegteDto = aReportLieferscheinAngelegteDto[i];

			data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE_NUMMER] = reportLieferscheinAngelegteDto
					.getCNrLieferschein();
			data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE_KUNDE] = reportLieferscheinAngelegteDto
					.getKundeCName1();
			data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE_ANLAGEDATUM] = Helper
					.formatDatum(reportLieferscheinAngelegteDto.getTAnlegen(),
							locDruck);
			data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE_ANGELEGTVON] = reportLieferscheinAngelegteDto
					.getPersonalanlegenKurzzeichen();
			data[i][LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE_AUFTRAGSNUMMER] = reportLieferscheinAngelegteDto
					.getCNrAuftrag();
		}

		HashMap parameter = new HashMap<Object, Object>();

		initJRDS(parameter, LieferscheinReportFac.REPORT_MODUL,
				LieferscheinReportFac.REPORT_LIEFERSCHEIN_ANGELEGTE,
				theClientDto.getMandant(), theClientDto.getLocUi(),
				theClientDto);
		return getReportPrint();
	}

	private void checkLieferscheinIId(Integer iIdLieferscheinI)
			throws EJBExceptionLP {
		if (iIdLieferscheinI == null) {
			throw new EJBExceptionLP(EJBExceptionLP.FEHLER_PARAMETER_IS_NULL,
					new Exception("iIdLieferscheinI == null"));
		}
		myLogger.info("LieferscheinIId: " + iIdLieferscheinI.toString());
	}

	private String baueKennungLieferschein(LieferscheinDto lieferscheinDtoI,
			TheClientDto theClientDto) throws EJBExceptionLP {
		StringBuffer abKennung = null;
		try {
			BelegartDto belegartDto = getLocaleFac().belegartFindByPrimaryKey(
					lieferscheinDtoI.getBelegartCNr(), theClientDto);

			abKennung = new StringBuffer(belegartDto.getCKurzbezeichnung());
			abKennung.append(" ").append(lieferscheinDtoI.getCNr());
		} catch (RemoteException ex) {
			throwEJBExceptionLPRespectOld(ex);
		}
		return abKennung.toString();
	}

	/**
	 * Diese Methode liefert eine Liste von allen gelieferten Lieferscheine
	 * eines Mandanten, die nach den eingegebenen Kriterien des Benutzers
	 * zusammengestellt wird. <br>
	 * Achtung: Hibernate verwendet lazy initialization, d.h. der Zugriff auf
	 * Collections muss innerhalb der Session erfolgen.
	 * 
	 * @param reportJournalKriterienDtoI
	 *            die Kriterien des Benutzers
	 * @param theClientDto
	 *            der aktuelle Benutzer
	 * @return ReportLieferscheinOffeneDto[] die Liste der Lieferscheine
	 * @throws EJBExceptionLP
	 *             Ausnahme
	 */
	private ReportLieferscheinOffeneDto[] getListeReportLieferscheinOffene(
			ReportJournalKriterienDto reportJournalKriterienDtoI, Integer iArt,
			boolean bMitDetails, TheClientDto theClientDto)
			throws EJBExceptionLP {

		ReportLieferscheinOffeneDto[] aResult = null;
		SessionFactory factory = FLRSessionFactory.getFactory();
		Session session = null;

		try {
			session = factory.openSession();

			// Hiberante Criteria fuer alle Tabellen ausgehend von meiner
			// Haupttabelle anlegen,
			// nach denen ich filtern und sortieren kann
			Criteria crit = session.createCriteria(FLRLieferschein.class);

			// Einschraenkung auf den aktuellen Mandanten
			crit.add(Restrictions.eq("mandant_c_nr", theClientDto.getMandant()));

			// Einschraenkung nach Status Offen
			crit.add(Restrictions
					.eq(LieferscheinFac.FLR_LIEFERSCHEIN_LIEFERSCHEINSTATUS_STATUS_C_NR,
							LieferscheinFac.LSSTATUS_GELIEFERT));
			if (iArt != null) {
				if (iArt == 1) {
					crit.add(Restrictions.eq(
							LieferscheinFac.FLR_LIEFERSCHEIN_B_VERRECHENBAR,
							Helper.boolean2Short(true)));
				} else if (iArt == 2) {
					crit.add(Restrictions.eq(
							LieferscheinFac.FLR_LIEFERSCHEIN_B_VERRECHENBAR,
							Helper.boolean2Short(false)));
				}
			}
			// Einschraenkung nach einer bestimmten Kostenstelle
			if (reportJournalKriterienDtoI.kostenstelleIId != null) {
				crit.add(Restrictions.eq(
						LieferscheinFac.FLR_LIEFERSCHEIN_KOSTENSTELLE_I_ID,
						reportJournalKriterienDtoI.kostenstelleIId));
			}

			// Einschraenkung nach einem bestimmten Kunden
			if (reportJournalKriterienDtoI.kundeIId != null) {
				crit.add(Restrictions
						.eq(LieferscheinFac.FLR_LIEFERSCHEIN_KUNDE_I_ID_LIEFERADRESSE,
								reportJournalKriterienDtoI.kundeIId));
			}

			// Einschraenkung nach Belegdatum von - bis
			String sVon = null;
			String sBis = null;

			if (reportJournalKriterienDtoI.dVon != null) {
				crit.add(Restrictions.ge(
						LieferscheinFac.FLR_LIEFERSCHEIN_D_BELEGDATUM,
						reportJournalKriterienDtoI.dVon));
				sVon = Helper.formatDatum(reportJournalKriterienDtoI.dVon,
						theClientDto.getLocUi());
			}

			if (reportJournalKriterienDtoI.dBis != null) {
				crit.add(Restrictions.le(
						LieferscheinFac.FLR_LIEFERSCHEIN_D_BELEGDATUM,
						reportJournalKriterienDtoI.dBis));
				sBis = Helper.formatDatum(reportJournalKriterienDtoI.dBis,
						theClientDto.getLocUi());
			}

			// Einschraenkung nach Belegnummer von - bis
			LpBelegnummerFormat f = getBelegnummerGeneratorObj()
					.getBelegnummernFormat(theClientDto.getMandant());

			Integer iGeschaeftsjahr = getParameterFac().getGeschaeftsjahr(
					theClientDto.getMandant());

			String sMandantKuerzel = getParameterFac().getMandantparameter(
					theClientDto.getMandant(),
					ParameterFac.KATEGORIE_ALLGEMEIN,
					ParameterFac.PARAMETER_BELEGNUMMER_MANDANTKENNUNG)
					.getCWert();

			if (reportJournalKriterienDtoI.sBelegnummerVon != null) {
				sVon = HelperServer.getBelegnummernFilterForHibernateCriterias(
						f, iGeschaeftsjahr, sMandantKuerzel,
						reportJournalKriterienDtoI.sBelegnummerVon);
				crit.add(Restrictions.ge("c_nr", sVon));
			}

			if (reportJournalKriterienDtoI.sBelegnummerBis != null) {
				sBis = HelperServer.getBelegnummernFilterForHibernateCriterias(
						f, iGeschaeftsjahr, sMandantKuerzel,
						reportJournalKriterienDtoI.sBelegnummerBis);
				crit.add(Restrictions.le("c_nr", sBis));
			}

			// Sortierung nach Kostenstelle ist immer die erste Sortierung
			if (reportJournalKriterienDtoI.bSortiereNachKostenstelle) {
				crit.createCriteria(
						LieferscheinFac.FLR_LIEFERSCHEIN_FLRKOSTENSTELLE)
						.addOrder(Order.asc("c_nr"));
			}

			// Sortierung nach Kunde, eventuell innerhalb der Kostenstelle
			if (reportJournalKriterienDtoI.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_PARTNER) {
				crit.createCriteria(LieferscheinFac.FLR_LIEFERSCHEIN_FLRKUNDE)
						.createCriteria(KundeFac.FLR_PARTNER)
						.addOrder(
								Order.asc(PartnerFac.FLR_PARTNER_NAME1NACHNAMEFIRMAZEILE1));
			}

			// es wird in jedem Fall nach der Belegnummer sortiert
			crit.addOrder(Order.asc("c_nr"));

			List<?> list = crit.list();
			aResult = new ReportLieferscheinOffeneDto[list.size()];
			int iIndex = 0;
			Iterator<?> it = list.iterator();
			ReportLieferscheinOffeneDto reportDto = null;

			while (it.hasNext()) {
				FLRLieferschein flrlieferschein = (FLRLieferschein) it.next();

				reportDto = new ReportLieferscheinOffeneDto();
				reportDto.setIIdLieferschein(flrlieferschein.getI_id());
				reportDto.setCNrLieferschein(flrlieferschein.getC_nr());
				reportDto.setKundeCName1(flrlieferschein.getFlrkunde()
						.getFlrpartner().getC_name1nachnamefirmazeile1());
				reportDto.setKostenstelleCNr(flrlieferschein
						.getFlrkostenstelle().getC_nr());

				aResult[iIndex] = reportDto;
				iIndex++;
			}
		} catch (RemoteException re) {
			throwEJBExceptionLPRespectOld(re);
		} finally {
			closeSession(session);
		}
		return aResult;
	}

	/**
	 * String zum Andrucken der Filterkriterien.
	 * 
	 * @param reportJournalKriterienDtoI
	 *            die Kriterien
	 * @param theClientDto
	 *            der aktuelle Benutzer
	 * @return String die Filterkriterien
	 * @throws EJBExceptionLP
	 *             Ausnahme
	 */
	private String buildFilterLieferscheinOffene(
			ReportJournalKriterienDto reportJournalKriterienDtoI,
			TheClientDto theClientDto) throws EJBExceptionLP {

		StringBuffer buff = new StringBuffer("");

		// Belegdatum
		if (reportJournalKriterienDtoI.dVon != null
				|| reportJournalKriterienDtoI.dBis != null) {
			buff.append(getTextRespectUISpr("bes.belegdatum",
					theClientDto.getMandant(), theClientDto.getLocUi()));
		}

		if (reportJournalKriterienDtoI.dVon != null) {
			buff.append(" ").append(
					getTextRespectUISpr("lp.von", theClientDto.getMandant(),
							theClientDto.getLocUi()));
			buff.append(" ").append(
					Helper.formatDatum(reportJournalKriterienDtoI.dVon,
							theClientDto.getLocUi()));
		}

		if (reportJournalKriterienDtoI.dBis != null) {
			buff.append(" ").append(
					getTextRespectUISpr("lp.bis", theClientDto.getMandant(),
							theClientDto.getLocUi()));
			buff.append(" ").append(
					Helper.formatDatum(reportJournalKriterienDtoI.dBis,
							theClientDto.getLocUi()));
		}

		// Kostenstelle
		if (reportJournalKriterienDtoI.kostenstelleIId != null) {
			buff.append(" ")
					.append(getTextRespectUISpr("lp.kostenstelle",
							theClientDto.getMandant(), theClientDto.getLocUi()));
			buff.append(" ").append(
					getSystemFac().kostenstelleFindByPrimaryKey(
							reportJournalKriterienDtoI.kostenstelleIId)
							.getCNr());
		}

		// Kunde
		if (reportJournalKriterienDtoI.kundeIId != null) {
			buff.append(" ").append(
					getTextRespectUISpr("lp.kunde", theClientDto.getMandant(),
							theClientDto.getLocUi()));
			buff.append(" ").append(
					getKundeFac()
							.kundeFindByPrimaryKey(
									reportJournalKriterienDtoI.kundeIId,
									theClientDto).getPartnerDto()
							.getCName1nachnamefirmazeile1());
		}

		// Lieferscheinnummer
		if (reportJournalKriterienDtoI.sBelegnummerVon != null
				|| reportJournalKriterienDtoI.sBelegnummerBis != null) {
			buff.append(" ")
					.append(getTextRespectUISpr("ls.lieferscheinnummer",
							theClientDto.getMandant(), theClientDto.getLocUi()));
		}

		if (reportJournalKriterienDtoI.sBelegnummerVon != null) {
			buff.append(" ").append(
					getTextRespectUISpr("lp.von", theClientDto.getMandant(),
							theClientDto.getLocUi()));
			buff.append(" ").append(reportJournalKriterienDtoI.sBelegnummerVon);
		}

		if (reportJournalKriterienDtoI.sBelegnummerBis != null) {
			buff.append(" ").append(
					getTextRespectUISpr("lp.bis", theClientDto.getMandant(),
							theClientDto.getLocUi()));
			buff.append(" ").append(reportJournalKriterienDtoI.sBelegnummerBis);
		}

		String cBuffer = buff.toString().trim();

		return cBuffer;
	}

	/**
	 * String zum Andrucken der Sortierkriterien.
	 * 
	 * @param reportJournalKriterienDtoI
	 *            die Kriterien
	 * @param theClientDto
	 *            der aktuelle Benutzer
	 * @return String die Sortierkriterien
	 */
	private String buildSortierungLieferscheinOffene(
			ReportJournalKriterienDto reportJournalKriterienDtoI,
			TheClientDto theClientDto) {

		StringBuffer buff = new StringBuffer(getTextRespectUISpr(
				"lp.sortierungnach", theClientDto.getMandant(),
				theClientDto.getLocUi()));

		if (reportJournalKriterienDtoI.bSortiereNachKostenstelle) {
			buff.append(
					getTextRespectUISpr("lp.kostenstelle",
							theClientDto.getMandant(), theClientDto.getLocUi()))
					.append(", ");
		}

		if (reportJournalKriterienDtoI.iSortierung == ReportJournalKriterienDto.KRIT_SORT_NACH_PARTNER) {
			buff.append(
					getTextRespectUISpr("lp.kunde", theClientDto.getMandant(),
							theClientDto.getLocUi())).append(", ");
		}

		buff.append(getTextRespectUISpr("ls.lieferscheinnummer",
				theClientDto.getMandant(), theClientDto.getLocUi()));

		return buff.toString();
	}

	/**
	 * Diese Methode liefert eine Liste von allen angelegten Lieferscheine eines
	 * Mandanten, die nach den eingegebenen Kriterien des Benutzers
	 * zusammengestellt wird. <br>
	 * Achtung: Hibernate verwendet lazy initialization, d.h. der Zugriff auf
	 * Collections muss innerhalb der Session erfolgen.
	 * 
	 * @param reportJournalKriterienDtoI
	 *            die Kriterien des Benutzers
	 * @param theClientDto
	 *            der aktuelle Benutzer
	 * @return ReportLieferscheinOffeneDto[] die Liste der Lieferscheine
	 * @throws EJBExceptionLP
	 *             Ausnahme
	 */
	private ReportLieferscheinAngelegteDto[] getListeReportLieferscheinAngelegte(
			ReportJournalKriterienDto reportJournalKriterienDtoI,
			TheClientDto theClientDto) throws EJBExceptionLP {

		ReportLieferscheinAngelegteDto[] aResult = null;
		SessionFactory factory = FLRSessionFactory.getFactory();
		Session session = factory.openSession();

		// Hiberante Criteria fuer alle Tabellen ausgehend von meiner
		// Haupttabelle anlegen,
		// nach denen ich filtern und sortieren kann
		Criteria crit = session
				.createCriteria(FLRLieferscheinReportAngelegte.class);

		// Einschraenkung auf den aktuellen Mandanten
		crit.add(Restrictions.eq("mandant_c_nr", theClientDto.getMandant()));

		// Einschraenkung nach Status Offen
		crit.add(Restrictions
				.eq(LieferscheinFac.FLR_LIEFERSCHEIN_LIEFERSCHEINSTATUS_STATUS_C_NR,
						LieferscheinFac.LSSTATUS_ANGELEGT));

		// Einschraenkung nach einer bestimmten Kostenstelle
		/*
		 * if (reportJournalKriterienDtoI.kostenstelleIId != null) { crit.add
		 * (Restrictions.eq(LieferscheinFac.FLR_LIEFERSCHEIN_KOSTENSTELLE_I_ID ,
		 * reportJournalKriterienDtoI.kostenstelleIId)); }
		 * 
		 * // Einschraenkung nach einem bestimmten Kunden if
		 * (reportJournalKriterienDtoI.kundeIId != null) { crit.add(Restrictions
		 * .eq(LieferscheinFac.FLR_LIEFERSCHEIN_KUNDE_I_ID_LIEFERADRESSE,
		 * reportJournalKriterienDtoI.kundeIId)); }
		 * 
		 * // Einschraenkung nach Belegdatum von - bis String sVon = null;
		 * String sBis = null;
		 * 
		 * if (reportJournalKriterienDtoI.dVon != null) { crit.add(Restrictions
		 * .ge(LieferscheinFac.FLR_LIEFERSCHEIN_D_BELEGDATUM,
		 * reportJournalKriterienDtoI.dVon)); sVon =
		 * Helper.formatDatum(reportJournalKriterienDtoI.dVon,
		 * theClientDto.getLocUi()); }
		 * 
		 * if (reportJournalKriterienDtoI.dBis != null) { crit.add(Restrictions
		 * .le(LieferscheinFac.FLR_LIEFERSCHEIN_D_BELEGDATUM,
		 * reportJournalKriterienDtoI.dBis)); sBis =
		 * Helper.formatDatum(reportJournalKriterienDtoI.dBis,
		 * theClientDto.getLocUi()); }
		 * 
		 * // Einschraenkung nach Belegnummer von - bis LpBelegnummerFormat f =
		 * getBelegnummerGeneratorObj().getBelegnummernFormat(
		 * theClientDto.getMandant());
		 * 
		 * Integer iGeschaeftsjahr =
		 * getParameterFac().getGeschaeftsjahr(theClientDto. getMandant());
		 * 
		 * if (reportJournalKriterienDtoI.sBelegnummerVon != null) { sVon =
		 * HelperServer.getBelegnummernFilterForHibernateCriterias(f,
		 * iGeschaeftsjahr, reportJournalKriterienDtoI.sBelegnummerVon);
		 * crit.add(Restrictions.ge("c_nr", sVon)); }
		 * 
		 * if (reportJournalKriterienDtoI.sBelegnummerBis != null) { sBis =
		 * HelperServer.getBelegnummernFilterForHibernateCriterias(f,
		 * iGeschaeftsjahr, reportJournalKriterienDtoI.sBelegnummerBis);
		 * crit.add(Restrictions.le("c_nr", sBis)); }
		 * 
		 * // Sortierung nach Kostenstelle ist immer die erste Sortierung if
		 * (reportJournalKriterienDtoI.bSortiereNachKostenstelle) {
		 * crit.createCriteria (LieferscheinFac.FLR_LIEFERSCHEIN_FLRKOSTENSTELLE
		 * ).addOrder(Order.asc("c_nr")); }
		 * 
		 * // Sortierung nach Kunde, eventuell innerhalb der Kostenstelle if
		 * (reportJournalKriterienDtoI.iSortierung ==
		 * ReportJournalKriterienDto.KRIT_SORT_NACH_PARTNER) {
		 * crit.createCriteria
		 * (LieferscheinFac.FLR_LIEFERSCHEIN_FLRKUNDE).createCriteria (KundeFac.
		 * FLR_PARTNER).addOrder(Order.asc(PartnerFac.
		 * FLR_PARTNER_NAME1NACHNAMEFIRMAZEILE1)); }
		 */

		// es wird in jedem Fall nach der Belegnummer sortiert
		crit.addOrder(Order.asc("c_nr"));

		List<?> list = crit.list();
		aResult = new ReportLieferscheinAngelegteDto[list.size()];
		int iIndex = 0;
		Iterator<?> it = list.iterator();
		ReportLieferscheinAngelegteDto reportDto = null;

		while (it.hasNext()) {
			FLRLieferscheinReportAngelegte flrlieferschein = (FLRLieferscheinReportAngelegte) it
					.next();

			reportDto = new ReportLieferscheinAngelegteDto();
			reportDto.setIIdLieferschein(flrlieferschein.getI_id());
			reportDto.setCNrLieferschein(flrlieferschein.getC_nr());
			reportDto.setKundeCName1(flrlieferschein.getFlrkunde()
					.getFlrpartner().getC_name1nachnamefirmazeile1());
			reportDto.setKostenstelleCNr(flrlieferschein.getFlrkostenstelle()
					.getC_nr());
			if (flrlieferschein.getFlrauftrag() != null) {
				reportDto.setCNrAuftrag(flrlieferschein.getFlrauftrag()
						.getC_nr());
			}
			// @todo nicht ueber Bean PJ 4408
			PersonalDto personalAnlegenDto = getPersonalFac()
					.personalFindByPrimaryKey(
							flrlieferschein.getFlrpersonalanlegen().getI_id(),
							theClientDto);

			reportDto.setPersonalanlegenKurzzeichen(personalAnlegenDto
					.getCKurzzeichen());
			reportDto.setTAnlegen(flrlieferschein.getT_anlegen());

			aResult[iIndex] = reportDto;
			iIndex++;
		}

		closeSession(session);

		return aResult;
	}

	/**
	 * Fuer Serien- oder Chargennummerntragenden Artikel, die Anzahl der Serien
	 * oder Chargennummern berechnen.
	 * 
	 * @param artikelIId
	 *            int
	 * @param cSerienchargennummerI
	 *            String
	 * @param theClientDto
	 *            String
	 * @return int
	 * @throws EJBExceptionLP
	 */
	private int berechneAnzahlSerienChargeNummern(int artikelIId,
			List cSerienchargennummerI, TheClientDto theClientDto)
			throws EJBExceptionLP {
		int iAnzahl = 0;

		ArtikelDto artikelDto = getArtikelFac().artikelFindByPrimaryKey(
				artikelIId, theClientDto);
		if (Helper.short2Boolean(artikelDto.getBChargennrtragend())) {
			if (cSerienchargennummerI != null) {
				iAnzahl = cSerienchargennummerI.size();
			}
		}
		if (Helper.short2Boolean(artikelDto.getBSeriennrtragend())) {
			return 1;
		}

		return iAnzahl;
	}

	private Object[] befuelleZeileMitPreisbehafteterPosition(
			LieferscheinpositionDto positionDto,
			LieferscheinDto lieferscheinDto,
			KundeDto kundeDto,
			int iArtikelpositionsnummerI, // Referenz
			LinkedHashMap<Object, MwstsatzReportDto> mwstMapI, // Referenz
			Boolean bbSeitenumbruchI, Locale localeCNrI,
			TheClientDto theClientDto) throws EJBExceptionLP {
		Object[] dataRow = null;
		try {
			dataRow = new Object[LieferscheinReportFac.REPORT_LIEFERSCHEIN_WA_ETIKETT_ANZAHL_SPALTEN];
			ArtikelDto artikelDto = getArtikelFac().artikelFindByPrimaryKey(
					positionDto.getArtikelIId(), theClientDto);
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_POSITION] = ""
					+ getLieferscheinpositionFac().getPositionNummer(
							positionDto.getIId());
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_IDENT] = artikelDto.getCNr();
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_MENGE] = positionDto
					.getNMenge();
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_EINHEIT] = positionDto
					.getEinheitCNr().trim();
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_SERIENCHARGENR] = SeriennrChargennrMitMengeDto
					.erstelleStringAusMehrerenSeriennummern(positionDto
							.getSeriennrChargennrMitMenge());
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_TEXTEINGABE] = positionDto
					.getXTextinhalt();

			// PJ15262
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_WE_REFERENZ] = getLagerFac()
					.getWareneingangsreferenzSubreport(
							LocaleFac.BELEGART_LIEFERSCHEIN,
							positionDto.getIId(),
							positionDto.getSeriennrChargennrMitMenge(), false,
							theClientDto);

			// KundeArtikelnr gueltig zu Belegdatum
			KundesokoDto kundeSokoDto_gueltig = this.getKundesokoFac()
					.kundesokoFindByKundeIIdArtikelIIdGueltigkeitsdatumOhneExc(
							kundeDto.getIId(),
							artikelDto.getIId(),
							new java.sql.Date(lieferscheinDto.getTBelegdatum()
									.getTime()));
			if (kundeSokoDto_gueltig != null) {
				dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_KUNDENARTIKELNUMMER] = kundeSokoDto_gueltig
						.getCKundeartikelnummer();
			}

			if (artikelDto.getArtikelsprDto() != null) {
				dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_BEZ] = artikelDto
						.getArtikelsprDto().getCBez();
				dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_ZBEZ] = artikelDto
						.getArtikelsprDto().getCZbez();
				dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_ZBEZ2] = artikelDto
						.getArtikelsprDto().getCZbez2();
				dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_KBEZ] = artikelDto
						.getArtikelsprDto().getCKbez();
			}
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_REFERENZNUMMER] = artikelDto
					.getCReferenznr();
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_GEWICHT] = artikelDto
					.getFGewichtkg();
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_INDEX] = artikelDto
					.getCIndex();
			dataRow[REPORT_LIEFERSCHEIN_WA_ETIKETT_ARTIKEL_REVISION] = artikelDto
					.getCRevision();
			// Dto holen damit LPReport.printIdent verwendet werden kann
		} catch (RemoteException ex) {
			throwEJBExceptionLPRespectOld(ex);
		}
		return dataRow;
	}
}
