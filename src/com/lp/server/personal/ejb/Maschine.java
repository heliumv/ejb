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
package com.lp.server.personal.ejb;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.lp.server.util.ICBez;

@NamedQueries( {
		@NamedQuery(name = "MaschinefindByMandantCNrCInventarnummer", query = "SELECT OBJECT(C) FROM Maschine c WHERE c.mandantCNr = ?1 AND  c.cInventarnummer = ?2"),
		@NamedQuery(name = "MaschinefindByCIdentifikationsnr", query = "SELECT OBJECT(C) FROM Maschine c WHERE c.cIdentifikationsnr = ?1"),
		@NamedQuery(name = "MaschinefindByMaschinengruppeIId", query = "SELECT OBJECT(C) FROM Maschine c WHERE c.maschinengruppeIId = ?1"),
		@NamedQuery(name = "MaschinefindByByMandantCNr", query = "SELECT OBJECT(C) FROM Maschine c WHERE c.mandantCNr = ?1") })
@Entity
@Table(name = "PERS_MASCHINE")
public class Maschine implements Serializable, ICBez {
	@Id
	@Column(name = "I_ID")
	private Integer iId;

	@Column(name = "C_INVENTARNUMMER")
	private String cInventarnummer;

	@Column(name = "C_BEZ")
	private String cBez;

	@Column(name = "F_VERFUEGBARKEITINPROZENT")
	private Double fVerfuegbarkeitinprozent;

	@Column(name = "B_AUTOENDEBEIGEHT")
	private Short bAutoendebeigeht;

	@Column(name = "T_KAUFDATUM")
	private Timestamp tKaufdatum;

	@Column(name = "C_IDENTIFIKATIONSNR")
	private String cIdentifikationsnr;

	@Column(name = "MANDANT_C_NR")
	private String mandantCNr;

	@Column(name = "MASCHINENGRUPPE_I_ID")
	private Integer maschinengruppeIId;

	@Column(name = "B_VERSTECKT")
	private Short bVersteckt;
	
	private static final long serialVersionUID = 1L;

	public Maschine() {
		super();
	}

	public Maschine(Integer id, String mandantCNr2, String inventarnummer,
			Double verfuegbarkeitinprozent, Short autoendebeigeht,
			Integer maschinengruppeIId2, Short bVersteckt) {
		setIId(id);
		setMandantCNr(mandantCNr2);
		setCInventarnummer(inventarnummer);
		setFVerfuegbarkeitinprozent(verfuegbarkeitinprozent);
		setBAutoendebeigeht(autoendebeigeht);
		setMaschinengruppeIId(maschinengruppeIId2);
		setBVersteckt(bVersteckt);
	}

	public Integer getIId() {
		return this.iId;
	}

	public void setIId(Integer iId) {
		this.iId = iId;
	}
	public Short getBVersteckt() {
		return bVersteckt;
	}

	public void setBVersteckt(Short versteckt) {
		bVersteckt = versteckt;
	}
	public String getCInventarnummer() {
		return this.cInventarnummer;
	}

	public void setCInventarnummer(String cInventarnummer) {
		this.cInventarnummer = cInventarnummer;
	}

	public String getCBez() {
		return this.cBez;
	}

	public void setCBez(String cBez) {
		this.cBez = cBez;
	}

	public Double getFVerfuegbarkeitinprozent() {
		return this.fVerfuegbarkeitinprozent;
	}

	public void setFVerfuegbarkeitinprozent(Double fVerfuegbarkeitinprozent) {
		this.fVerfuegbarkeitinprozent = fVerfuegbarkeitinprozent;
	}

	public Short getBAutoendebeigeht() {
		return this.bAutoendebeigeht;
	}

	public void setBAutoendebeigeht(Short bAutoendebeigeht) {
		this.bAutoendebeigeht = bAutoendebeigeht;
	}

	public Timestamp getTKaufdatum() {
		return this.tKaufdatum;
	}

	public void setTKaufdatum(Timestamp tKaufdatum) {
		this.tKaufdatum = tKaufdatum;
	}

	public String getCIdentifikationsnr() {
		return this.cIdentifikationsnr;
	}

	public void setCIdentifikationsnr(String cIdentifikationsnr) {
		this.cIdentifikationsnr = cIdentifikationsnr;
	}

	public String getMandantCNr() {
		return this.mandantCNr;
	}

	public void setMandantCNr(String mandantCNr) {
		this.mandantCNr = mandantCNr;
	}

	public Integer getMaschinengruppeIId() {
		return this.maschinengruppeIId;
	}

	public void setMaschinengruppeIId(Integer maschinengruppeIId) {
		this.maschinengruppeIId = maschinengruppeIId;
	}

}
