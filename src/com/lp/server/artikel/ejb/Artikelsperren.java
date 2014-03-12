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
package com.lp.server.artikel.ejb;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries( {
		@NamedQuery(name = "ArtikelsperrenfindByArtikelIIdSperrenIId", query = "SELECT OBJECT(c) FROM Artikelsperren c WHERE c.artikelIId = ?1 AND c.sperrenIId = ?2"),
		@NamedQuery(name = "ArtikelsperrenfindByArtikelIId", query = "SELECT OBJECT(c) FROM Artikelsperren c WHERE c.artikelIId = ?1"),
		@NamedQuery(name = "ArtikelsperrenfindByArtikelIIdOrderByISort", query = "SELECT OBJECT(C) FROM Artikelsperren c WHERE c.artikelIId = ?1 ORDER BY c.iSort"),
		@NamedQuery(name = "ArtikelsperrenejbSelectNextReihung", query = "SELECT MAX (o.iSort) FROM Artikelsperren o WHERE o.artikelIId = ?1") })
@Entity
@Table(name = "WW_ARTIKELSPERREN")
public class Artikelsperren implements Serializable {
	@Id
	@Column(name = "I_ID")
	private Integer iId;

	@Column(name = "ARTIKEL_I_ID")
	private Integer artikelIId;

	@Column(name = "SPERREN_I_ID")
	private Integer sperrenIId;

	@Column(name = "C_GRUND")
	private String cGrund;

	@Column(name = "PERSONAL_I_ID_AENDERN")
	private Integer personalIIdAendern;
	
	@Column(name = "T_AENDERN")
	private Timestamp tAendern;

	@Column(name = "I_SORT")
	private Integer iSort;
	
	public Integer getiSort() {
		return iSort;
	}

	public void setiSort(Integer iSort) {
		this.iSort = iSort;
	}
	
	public String getCGrund() {
		return cGrund;
	}

	public void setCGrund(String grund) {
		cGrund = grund;
	}

	public Integer getPersonalIIdAendern() {
		return personalIIdAendern;
	}

	public void setPersonalIIdAendern(Integer personalIIdAendern) {
		this.personalIIdAendern = personalIIdAendern;
	}

	public Timestamp getTAendern() {
		return tAendern;
	}

	public void setTAendern(Timestamp aendern) {
		tAendern = aendern;
	}


	private static final long serialVersionUID = 1L;

	public Artikelsperren() {
		super();
	}

	public Artikelsperren(Integer id, Integer artikelIId, Integer sperrenIId, Integer personalIIdAendern,Timestamp tAendern, String cGrund,Integer iSort) {
		setIId(id);
	    setArtikelIId(artikelIId);
	    setSperrenIId(sperrenIId);
	    setPersonalIIdAendern(personalIIdAendern);
	    setTAendern(tAendern);
	    setCGrund(cGrund);
	    setiSort(iSort);
	}

	public Integer getIId() {
		return this.iId;
	}

	public void setIId(Integer iId) {
		this.iId = iId;
	}

	public Integer getArtikelIId() {
		return this.artikelIId;
	}

	public void setArtikelIId(Integer artikelIId) {
		this.artikelIId = artikelIId;
	}

	public Integer getSperrenIId() {
		return this.sperrenIId;
	}

	public void setSperrenIId(Integer sperrenIId) {
		this.sperrenIId = sperrenIId;
	}

}
