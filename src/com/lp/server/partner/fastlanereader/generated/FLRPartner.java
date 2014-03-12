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
package com.lp.server.partner.fastlanereader.generated;

import com.lp.server.system.fastlanereader.generated.FLRLandplzort;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class FLRPartner implements Serializable {
	private static final long serialVersionUID = 4482981642873591617L;

	/** identifier field */
    private Integer i_id;

    /** nullable persistent field */
    private String anrede_c_nr;

    /** nullable persistent field */
    private String c_name1nachnamefirmazeile1;

    /** nullable persistent field */
    private String c_name2vornamefirmazeile2;

    /** nullable persistent field */
    private String c_name3vorname2abteilung;

    /** nullable persistent field */
    private String c_strasse;

    /** nullable persistent field */
    private String c_titel;

    /** nullable persistent field */
    private String c_ntitel;

    /** nullable persistent field */
    private String partnerart_c_nr;

    /** nullable persistent field */
    private Short b_versteckt;

    /** nullable persistent field */
    private String c_kbez;

    /** nullable persistent field */
    private String locale_c_nr_kommunikation;

    /** nullable persistent field */
    private String x_bemerkung;

    /** nullable persistent field */
    private Integer branche_i_id;

    /** nullable persistent field */
    private Integer partnerklasse_i_id;

    /** nullable persistent field */
    private String c_adressart;

    /** nullable persistent field */
    private String c_iln;

    /** nullable persistent field */
    private String c_uid;

    /** nullable persistent field */
    private String c_filialnummer;

    /** nullable persistent field */
    private Double f_gmtversatz;

    /** nullable persistent field */
    private String c_email;

    /** nullable persistent field */
    private String c_fax;

    /** nullable persistent field */
    private String c_telefon;

    /** nullable persistent field */
    private Date t_geburtsdatumansprechpartner;

    /** nullable persistent field */
    private FLRLandplzort flrlandplzort;

    /** nullable persistent field */
    private com.lp.server.partner.fastlanereader.generated.FLRPartnerklasse flrpartnerklasse;

    /** persistent field */
    private Set partner_paselektion_set;

    /** persistent field */
    private Set ansprechpartner;

    private Timestamp t_aendern ;
    
    /** full constructor */
    public FLRPartner(String anrede_c_nr, String c_name1nachnamefirmazeile1, String c_name2vornamefirmazeile2, String c_name3vorname2abteilung, String c_strasse, String c_titel, String c_ntitel, String partnerart_c_nr, Short b_versteckt, String c_kbez, String locale_c_nr_kommunikation, String x_bemerkung, Integer branche_i_id, Integer partnerklasse_i_id, String c_adressart, String c_iln, String c_uid, String c_filialnummer, Double f_gmtversatz, String c_email, String c_fax, String c_telefon, Date t_geburtsdatumansprechpartner, FLRLandplzort flrlandplzort, com.lp.server.partner.fastlanereader.generated.FLRPartnerklasse flrpartnerklasse, Set partner_paselektion_set, Set ansprechpartner) {
        this.anrede_c_nr = anrede_c_nr;
        this.c_name1nachnamefirmazeile1 = c_name1nachnamefirmazeile1;
        this.c_name2vornamefirmazeile2 = c_name2vornamefirmazeile2;
        this.c_name3vorname2abteilung = c_name3vorname2abteilung;
        this.c_strasse = c_strasse;
        this.c_titel = c_titel;
        this.c_ntitel = c_ntitel;
        this.partnerart_c_nr = partnerart_c_nr;
        this.b_versteckt = b_versteckt;
        this.c_kbez = c_kbez;
        this.locale_c_nr_kommunikation = locale_c_nr_kommunikation;
        this.x_bemerkung = x_bemerkung;
        this.branche_i_id = branche_i_id;
        this.partnerklasse_i_id = partnerklasse_i_id;
        this.c_adressart = c_adressart;
        this.c_iln = c_iln;
        this.c_uid = c_uid;
        this.c_filialnummer = c_filialnummer;
        this.f_gmtversatz = f_gmtversatz;
        this.c_email = c_email;
        this.c_fax = c_fax;
        this.c_telefon = c_telefon;
        this.t_geburtsdatumansprechpartner = t_geburtsdatumansprechpartner;
        this.flrlandplzort = flrlandplzort;
        this.flrpartnerklasse = flrpartnerklasse;
        this.partner_paselektion_set = partner_paselektion_set;
        this.ansprechpartner = ansprechpartner;
    }

    /** default constructor */
    public FLRPartner() {
    }

    /** minimal constructor */
    public FLRPartner(Set partner_paselektion_set, Set ansprechpartner) {
        this.partner_paselektion_set = partner_paselektion_set;
        this.ansprechpartner = ansprechpartner;
    }

    public Integer getI_id() {
        return this.i_id;
    }

    public void setI_id(Integer i_id) {
        this.i_id = i_id;
    }

    public String getAnrede_c_nr() {
        return this.anrede_c_nr;
    }

    public void setAnrede_c_nr(String anrede_c_nr) {
        this.anrede_c_nr = anrede_c_nr;
    }

    public String getC_name1nachnamefirmazeile1() {
        return this.c_name1nachnamefirmazeile1;
    }

    public void setC_name1nachnamefirmazeile1(String c_name1nachnamefirmazeile1) {
        this.c_name1nachnamefirmazeile1 = c_name1nachnamefirmazeile1;
    }

    public String getC_name2vornamefirmazeile2() {
        return this.c_name2vornamefirmazeile2;
    }

    public void setC_name2vornamefirmazeile2(String c_name2vornamefirmazeile2) {
        this.c_name2vornamefirmazeile2 = c_name2vornamefirmazeile2;
    }

    public String getC_name3vorname2abteilung() {
        return this.c_name3vorname2abteilung;
    }

    public void setC_name3vorname2abteilung(String c_name3vorname2abteilung) {
        this.c_name3vorname2abteilung = c_name3vorname2abteilung;
    }

    public String getC_strasse() {
        return this.c_strasse;
    }

    public void setC_strasse(String c_strasse) {
        this.c_strasse = c_strasse;
    }

    public String getC_titel() {
        return this.c_titel;
    }

    public void setC_titel(String c_titel) {
        this.c_titel = c_titel;
    }

    public String getC_ntitel() {
        return this.c_ntitel;
    }

    public void setC_ntitel(String c_ntitel) {
        this.c_ntitel = c_ntitel;
    }

    public String getPartnerart_c_nr() {
        return this.partnerart_c_nr;
    }

    public void setPartnerart_c_nr(String partnerart_c_nr) {
        this.partnerart_c_nr = partnerart_c_nr;
    }

    public Short getB_versteckt() {
        return this.b_versteckt;
    }

    public void setB_versteckt(Short b_versteckt) {
        this.b_versteckt = b_versteckt;
    }

    public String getC_kbez() {
        return this.c_kbez;
    }

    public void setC_kbez(String c_kbez) {
        this.c_kbez = c_kbez;
    }

    public String getLocale_c_nr_kommunikation() {
        return this.locale_c_nr_kommunikation;
    }

    public void setLocale_c_nr_kommunikation(String locale_c_nr_kommunikation) {
        this.locale_c_nr_kommunikation = locale_c_nr_kommunikation;
    }

    public String getX_bemerkung() {
        return this.x_bemerkung;
    }

    public void setX_bemerkung(String x_bemerkung) {
        this.x_bemerkung = x_bemerkung;
    }

    public Integer getBranche_i_id() {
        return this.branche_i_id;
    }

    public void setBranche_i_id(Integer branche_i_id) {
        this.branche_i_id = branche_i_id;
    }

    public Integer getPartnerklasse_i_id() {
        return this.partnerklasse_i_id;
    }

    public void setPartnerklasse_i_id(Integer partnerklasse_i_id) {
        this.partnerklasse_i_id = partnerklasse_i_id;
    }

    public String getC_adressart() {
        return this.c_adressart;
    }

    public void setC_adressart(String c_adressart) {
        this.c_adressart = c_adressart;
    }

    public String getC_iln() {
        return this.c_iln;
    }

    public void setC_iln(String c_iln) {
        this.c_iln = c_iln;
    }

    public String getC_uid() {
        return this.c_uid;
    }

    public void setC_uid(String c_uid) {
        this.c_uid = c_uid;
    }

    public String getC_filialnummer() {
        return this.c_filialnummer;
    }

    public void setC_filialnummer(String c_filialnummer) {
        this.c_filialnummer = c_filialnummer;
    }

    public Double getF_gmtversatz() {
        return this.f_gmtversatz;
    }

    public void setF_gmtversatz(Double f_gmtversatz) {
        this.f_gmtversatz = f_gmtversatz;
    }

    public String getC_email() {
        return this.c_email;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }

    public String getC_fax() {
        return this.c_fax;
    }

    public void setC_fax(String c_fax) {
        this.c_fax = c_fax;
    }

    public String getC_telefon() {
        return this.c_telefon;
    }

    public void setC_telefon(String c_telefon) {
        this.c_telefon = c_telefon;
    }

    public Date getT_geburtsdatumansprechpartner() {
        return this.t_geburtsdatumansprechpartner;
    }

    public void setT_geburtsdatumansprechpartner(Date t_geburtsdatumansprechpartner) {
        this.t_geburtsdatumansprechpartner = t_geburtsdatumansprechpartner;
    }

    public FLRLandplzort getFlrlandplzort() {
        return this.flrlandplzort;
    }

    public void setFlrlandplzort(FLRLandplzort flrlandplzort) {
        this.flrlandplzort = flrlandplzort;
    }

    public com.lp.server.partner.fastlanereader.generated.FLRPartnerklasse getFlrpartnerklasse() {
        return this.flrpartnerklasse;
    }

    public void setFlrpartnerklasse(com.lp.server.partner.fastlanereader.generated.FLRPartnerklasse flrpartnerklasse) {
        this.flrpartnerklasse = flrpartnerklasse;
    }

    public Set getPartner_paselektion_set() {
        return this.partner_paselektion_set;
    }

    public void setPartner_paselektion_set(Set partner_paselektion_set) {
        this.partner_paselektion_set = partner_paselektion_set;
    }

    public Set getAnsprechpartner() {
        return this.ansprechpartner;
    }

    public void setAnsprechpartner(Set ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }


	public Timestamp getT_aendern() {
		return t_aendern;
	}

	public void setT_aendern(Timestamp t_aendern) {
		this.t_aendern = t_aendern;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("i_id", getI_id())
            .toString();
    }
}
