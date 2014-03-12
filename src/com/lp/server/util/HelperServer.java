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
package com.lp.server.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.NamingException;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import com.lp.server.benutzer.service.BenutzerFac;
import com.lp.server.partner.fastlanereader.generated.FLRPartner;
import com.lp.server.system.jms.service.LPInfoTopicBean;
import com.lp.server.system.jms.service.LPTopicFertBean;
import com.lp.server.system.jms.service.LPTopicGfBean;
import com.lp.server.system.jms.service.LPTopicManageBean;
import com.lp.server.system.jms.service.LPTopicQsBean;
import com.lp.server.system.pkgenerator.format.LpBelegnummer;
import com.lp.server.system.pkgenerator.format.LpBelegnummerFormat;
import com.lp.server.system.pkgenerator.format.LpDefaultBelegnummerFormat;
import com.lp.server.system.pkgenerator.format.LpMandantBelegnummerFormat;
import com.lp.server.system.service.TheClientDto;
import com.lp.server.util.logger.LPLogService;
import com.lp.util.EJBExceptionLP;

public class HelperServer {

	private static ResourceBundle lpBundel = null;
	static final private String RESOURCE_BUNDEL_LP = "com.lp.server.res.lp";
	static private ResourceBundle messagesBundel = null;
	static final public String RESOURCE_BUNDEL_ALLG = "com.lp.server.res.messages";

	public static BigDecimal getBigDecimalWithScalingFromDB(String dbValue, int length) {
		if(length % 2 != 0) throw new IllegalArgumentException("length muss eine gerade Zahl sein (wegen Symetrie)");
		if(dbValue == null) return null;
		if(length < dbValue.length()) throw new IllegalArgumentException("dbValue ist laenger als length (=" + length + ")");
		Matcher m = Pattern.compile("[\\d]*[A-Z]+([\\s\\d]*)").matcher(String.format("%-" + length + "s", dbValue));
		if(!m.find()) throw new IllegalArgumentException("dbValue (= \""+ dbValue + "\") ist nicht gueltig formatiert");
		int scale = m.group(1).length() - length/2;
		
		StringBuffer encoded = new StringBuffer();
		for(char c : dbValue.toCharArray()) {
			if(c != '0')
				encoded.append((char)(c-17));
		}
		
		return new BigDecimal(encoded + "E" + scale);
	}
	
	public static String getDBValueFromBigDecimal(BigDecimal bd, int length) {
		if(length % 2 != 0) throw new IllegalArgumentException("length muss eine gerade Zahl sein (wegen Symetrie)");
		if(bd == null) return null;
		String value = bd.unscaledValue().toString();
		if(value.length() > length)
			throw new IllegalArgumentException("Unscaled value " + value + " ist laenger als length (=" + length + ")!");
		int spacesBefore = length/2-value.length()+bd.scale();
		value = String.format("%" + (spacesBefore+value.length()) + "s", value);
		value = String.format("%-" + length + "s", value);
		StringBuffer decoded = new StringBuffer();
		for(char c : value.toCharArray()) {
			if(c == ' ')
				decoded.append('0');
			else decoded.append((char)(c+17));
		}
		return decoded.toString();
	}
	
	static public ResourceBundle getLPResourceBundle() {
		if (lpBundel == null) {
			lpBundel = ResourceBundle.getBundle(RESOURCE_BUNDEL_LP);
		}
		return lpBundel;
	}

	/**
	 * getReportDir
	 * 
	 * @return String
	 */
	static public String getPdfDir() {
		if (lpBundel == null) {
			lpBundel = ResourceBundle.getBundle(RESOURCE_BUNDEL_LP);
		}
		return lpBundel.getString("drucken.pdf.output.dir");
	}

	/**
	 * getTextRespectUISpr Ermittelt den Wert der Property sTokenI
	 * Property-Datei message_<loI>
	 * 
	 * @param sTokenI
	 *            Property, die ausgelesen wird loI Locale
	 * @param loI
	 *            Locale
	 * @return String
	 */
	static public String getTextRespectUISpr(String sTokenI, Locale loI) {
		/** @todo JO PJ 4320 */
		// if (messagesBundel == null) {
		messagesBundel = ResourceBundle.getBundle(RESOURCE_BUNDEL_ALLG, loI);
		// }

		try {
			return messagesBundel.getString(sTokenI);
		} catch (Exception ex) {
			LPLogService.getInstance().getLogger(HelperServer.class)
					.error("resourcebundletext fehlt: " + sTokenI, ex);
			return "resourcebundletext fehlt: " + sTokenI;
		}
	}

	/**
	 * @todo MB->ALL wer braucht das? PJ 4328
	 */
	static public void TestDir() {
		String dirrep = "./";
		File pathName = new File(dirrep);
		try {
			String[] fileNamen = pathName.list();
			int i = 0;
		} catch (Exception ex) {
			int i = 0;
		}
	}

	@Deprecated
	// Neue function mit Mandantkuerzel benutzen
	public static String getBelegnummernFilter(LpBelegnummerFormat format,
			Integer iAktGeschaeftsjahr, String sValueI) {
		return HelperServer.getBelegnummernFilter(format, iAktGeschaeftsjahr,
				null, sValueI);
	}

	public static String formatNameAusFLRPartner(FLRPartner flrPartner) {
		String s = null;
		if (flrPartner != null) {
			s = flrPartner.getC_name1nachnamefirmazeile1();
			if (flrPartner.getC_name2vornamefirmazeile2() != null) {
				s += " " + flrPartner.getC_name2vornamefirmazeile2();
			}
		}
		return s;
	}

	public static String getBelegnummernFilter(LpBelegnummerFormat format,
			Integer iAktGeschaeftsjahr, String sMandantKuerzelI, String sValueI) {
		// Sonderzeichen weg
		String sLfdNr = sValueI.trim().replaceAll("%", "").replaceAll("'", "");
		String sGJ = null;
		Integer iLfdNr = null;
		Integer iGJ = null;
		// pruefen, ob ein bestimmtes GJ gewuenscht
		if (sLfdNr.indexOf('.') >= 0 || sLfdNr.indexOf(',') >= 0) {
			// zerlegen
			StringTokenizer st = new StringTokenizer(sLfdNr, ".,");
			// Die lfd. nummer der Belegnummer ist das erste Token
			if (st.hasMoreTokens()) {
				sLfdNr = st.nextToken();
			} else {
				// wenn gar kein Token dann zieht der orginalstring
				return sValueI;
			}
			// und das GJ ist das zweite
			if (st.hasMoreTokens()) {
				sGJ = st.nextToken();
			}
		}
		try {
			iLfdNr = new Integer(Integer.parseInt(sLfdNr));
			if (sGJ != null) {
				iGJ = new Integer(Integer.parseInt(sGJ));
				// fuer 4stellige GJ 1900 bzw. 2000 addieren
				if (format instanceof LpDefaultBelegnummerFormat) {
					LpDefaultBelegnummerFormat defaultFormat = (LpDefaultBelegnummerFormat) format;
					switch (defaultFormat.getStellenGeschaeftsjahr()) {
					case 2: {
						// nothing here
					}
						break;
					case 4: {
						// alle 1-2 stelligen auf 4stellig umsetzen
						if (iGJ.intValue() < 100) {
							if (iGJ.intValue() > 70) {
								iGJ = new Integer(1900 + iGJ.intValue());
							} else {
								iGJ = new Integer(2000 + iGJ.intValue());
							}
						}
					}
						break;
					default: {

						/*
						 * throw new EJBExceptionLP(EJBExceptionLP.
						 * FEHLER_MANDANTPARAMETER_NICHT_ANGELEGT, new
						 * Exception(
						 * "defaultFormat.getStellenGeschaeftsjahr() muss 2 oder 4 sein"
						 * ));
						 */
					}
					}
				}
			} else {
				iGJ = iAktGeschaeftsjahr;
			}
		} catch (NumberFormatException ex) {
			// fehlerhafte eingabe (zb buchstaben)
			return sValueI;
		}
		if (format instanceof LpMandantBelegnummerFormat) {
			return "'"
					+ format.format(new LpBelegnummer(iGJ, sMandantKuerzelI,
							iLfdNr)) + "'";
		} else {
			return "'" + format.format(new LpBelegnummer(iGJ, null, iLfdNr))
					+ "'";
		}
	}

	public static String getBelegnummernFilterForHibernateCriterias(
			LpBelegnummerFormat format, Integer iAktGeschaeftsjahr,
			String sMandantKuerzel, String sValueI) {
		return getBelegnummernFilter(format, iAktGeschaeftsjahr,
				sMandantKuerzel, sValueI).replaceAll("'", "");
	}

	/**
	 * getCsv liefert einen String aus einer Liste von String[]-Elementen im
	 * csv-Format
	 * 
	 * @param allElements
	 *            List
	 * @param separator
	 *            Trennzeichen (default TAB)
	 * @return String
	 */
	protected static String getCsv(List<?> allElements, char separator) {
		StringWriter sw = new StringWriter();
		CSVWriter writer = new CSVWriter(sw, separator, '"', "\r\n");
		writer.writeAll(allElements);
		return sw.toString();
	}

	protected static String getCsv(List<?> allElements) {
		return getCsv(allElements, ';');
	}

	protected static String getCsv(java.sql.ResultSet resultSet,
			char separator, Boolean includeHeaders) {
		StringWriter sw = new StringWriter();
		CSVWriter writer = new CSVWriter(sw, separator, '"', "\r\n");
		try {
			writer.writeAll(resultSet, includeHeaders);
		} catch (IOException ex) {
			LPLogService.getInstance().getLogger(HelperServer.class)
					.error("CSV Export IOException", ex);
		} catch (SQLException ex) {
			LPLogService.getInstance().getLogger(HelperServer.class)
					.error("CSV Export SQLException", ex);
		}
		return sw.toString();
	}

	protected static String getCsv(java.sql.ResultSet resultSet,
			Boolean includeHeaders) {
		return getCsv(resultSet, '\t', includeHeaders);
	}

	protected static String getCsv(java.sql.ResultSet resultSet) {
		return getCsv(resultSet, '\t', true);
	}

	/**
	 * readCsv liest aus einem Reader csv Format in eine Liste von
	 * String[]-Elementen
	 * 
	 * @param reader
	 *            Reader
	 * @param separator
	 *            Trennzeichen (Default TAB)
	 * @param quotechar
	 *            Textkennung (Default ")
	 * @param startline
	 *            erste Zeile ab der gelesen werden soll
	 * @return List Liste von String[]
	 */
	protected static List<?> readCsv(Reader reader, char separator,
			char quotechar, int startline) {
		CSVReader csvreader = new CSVReader(reader, separator);
		List<?> entries = null;
		try {
			entries = csvreader.readAll();
		} catch (IOException ex) {
			LPLogService.getInstance().getLogger(HelperServer.class)
					.error("CSV Import IOException", ex);
		}
		return entries;
	}

	public static String formatAdresseEinesFLRPartner(FLRPartner flrPartner) {
		if (flrPartner != null) {
			String sZeile = flrPartner.getC_name1nachnamefirmazeile1();

			if (flrPartner.getC_name2vornamefirmazeile2() != null) {
				sZeile += " " + flrPartner.getC_name2vornamefirmazeile2();
			}
			return sZeile;
		} else {
			return "";
		}

	}

	protected static List<?> readCsv(Reader reader, char separator,
			char quotechar) {
		return readCsv(reader, separator, quotechar, 0);
	}

	protected static List<?> readCsv(Reader reader, char separator) {
		return readCsv(reader, separator, '"', 0);
	}

	protected static List<?> readCsv(Reader reader) {
		return readCsv(reader, '\t', '"', 0);
	}


	
	public static String formatNumberForSQL(BigDecimal value){
		DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
		dfs.setDecimalSeparator('.');
		DecimalFormat dFormat = new DecimalFormat("0.00", dfs);

		return dFormat.format(value.doubleValue());
	}

	
	public static void sendJmsMessage(Context initialContext, String thema,
			String message, Integer nachrichtarchivIId, boolean popup,
			TheClientDto theClient) {

		javax.jms.Topic topic = null;
		javax.jms.TopicSession session = null;
		String destination = null;
		if (thema.trim().equals(LPTopicQsBean.TOPIC_NAME_QS))
			destination = LPTopicQsBean.DESTINATION_TOPIC_NAME_QS;
		if (thema.trim().equals(LPTopicFertBean.TOPIC_NAME_FERT))
			destination = LPTopicFertBean.DESTINATION_TOPIC_NAME_FERT;
		if (thema.trim().equals(LPTopicGfBean.TOPIC_NAME_GF))
			destination = LPTopicManageBean.DESTINATION_TOPIC_NAME_MANAGE;
		if (thema.trim().equals(LPTopicManageBean.TOPIC_NAME_MANAGE))
			destination = LPTopicManageBean.DESTINATION_TOPIC_NAME_MANAGE;

		try {
			TopicConnectionFactory fact = (TopicConnectionFactory) initialContext
					.lookup("ConnectionFactory");
			topic = (Topic) initialContext.lookup(destination);

			javax.jms.TopicConnection connect = fact.createTopicConnection();
			session = connect.createTopicSession(false,
					javax.jms.Session.AUTO_ACKNOWLEDGE);
			javax.jms.TopicPublisher sender = session.createPublisher(topic);

			connect.start();

			TextMessage tm = session.createTextMessage(message);
			if (nachrichtarchivIId != null)
				tm.setIntProperty(BenutzerFac.NPROP_NACHRICHTARCHIV_I_ID,
						nachrichtarchivIId);
			tm.setBooleanProperty(BenutzerFac.NPROP_POPUP, popup);

			// tm.setJMSDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);
			// tm.setJMSExpiration(0); // 0 kein Ablauf, sonst Zeitpunkt in ms
			// tm.setJMSPriority(LPMessage.LP_JMS_PRIORITY_MEDIUM);

			sender.publish(tm);
			connect.close();
			session.close();
		} catch (JMSException e) {
			e.printStackTrace();
			throw new EJBExceptionLP(EJBExceptionLP.FEHLER_SYSTEM_JMS, e);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new EJBExceptionLP(EJBExceptionLP.FEHLER_SYSTEM_JMS, e);
		}
	}

	public static void sendJmsInfo(Context initialContext, String message) {
		javax.jms.Topic topic = null;
		javax.jms.TopicSession session = null;
		try {
			TopicConnectionFactory fact = (TopicConnectionFactory) initialContext
					.lookup("ConnectionFactory");
			topic = (Topic) initialContext
					.lookup(LPInfoTopicBean.DESTINATION_INFOTOPIC_NAME);
			javax.jms.TopicConnection connect = fact.createTopicConnection();
			session = connect.createTopicSession(false,
					javax.jms.Session.AUTO_ACKNOWLEDGE);
			javax.jms.TopicPublisher sender = session.createPublisher(topic);
			connect.start();
			TextMessage tm = session.createTextMessage(message);
			// tm.setStringProperty(TOPIC_FILTER_RECEIVER,
			// TOPIC_FILTER_ALL_USER);
			sender.publish(tm);
			connect.close();
			session.close();
		} catch (JMSException e) {
			e.printStackTrace();
			throw new EJBExceptionLP(EJBExceptionLP.FEHLER_SYSTEM_JMS, e);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new EJBExceptionLP(EJBExceptionLP.FEHLER_SYSTEM_JMS, e);
		}
	}

	public static String formatFaxnummerFuerMail(String faxNummer,
			String faxDomain) {
		if (!faxDomain.startsWith("@"))
			faxDomain = "@" + faxDomain;
		if (!faxNummer.endsWith(faxDomain))
			faxNummer = (faxNummer.replace(" ", "") + faxDomain);
		return faxNummer;
	}

	public static File bytesToFile(byte[] anhang, String dateiName)
			throws IOException {
		File f = null;
		if (dateiName == null)
			dateiName = "anhang.pdf.";
		else
			dateiName += ".";
		f = File.createTempFile(dateiName, "");
		FileOutputStream out = new FileOutputStream(f);
		out.write(anhang); // bytearray in die Datei schreiben
		out.flush();
		out.close();
		f.deleteOnExit();
		return f;
	}

	public static Integer[] getMonateFuerQuartal(Integer iQuartal) {
		Integer[] iPerioden;
		iPerioden = new Integer[3];
		switch (iQuartal) {
		case 1:
			iPerioden[0] = 1;
			iPerioden[1] = 2;
			iPerioden[2] = 3;
			break;
		case 2:
			iPerioden[0] = 4;
			iPerioden[1] = 5;
			iPerioden[2] = 6;
			break;
		case 3:
			iPerioden[0] = 7;
			iPerioden[1] = 8;
			iPerioden[2] = 9;
			break;
		case 4:
			iPerioden[0] = 10;
			iPerioden[1] = 11;
			iPerioden[2] = 12;
			break;
		}
		return iPerioden;
	}
	
	
	/**
	 * Null sicherer compare
	 * 
	 * @param c1 das erste Objekt, kann null sein
	 * @param c2 das zweite Objekt, kann null sein
	 * @param nullGreater wenn true wird ein null wert als groesser angesehen, 
	 *   ansonsten kleiner
	 * @return negativer Wert wenn c1 < c2, 0 wenn c1 == c2 und positiv wenn c1 > c2
	 */
	public static int nullsafeCompare(Comparable c1, Comparable c2, boolean nullGreater) {
		if(c1 == c2) return 0 ;
		if(c1 == null) return nullGreater ? 1 : -1 ;
		if(c2 == null) return nullGreater ? -1 : 1 ;
		
		return c1.compareTo(c2) ;
	}

	public static StringBuffer removeScriptHtml(StringBuffer pdf) {
		String temp1 = pdf.substring(0, pdf.indexOf("script>")-1);
		String temp2 = pdf.substring(pdf.indexOf("</script>")+9);
		StringBuffer retval = new StringBuffer();
		retval.append(temp1);
		retval.append(temp2);
		return retval;
	}	

}
