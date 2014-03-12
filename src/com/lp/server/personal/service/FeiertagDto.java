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
package com.lp.server.personal.service;

import java.sql.Timestamp;

import java.io.Serializable;

import com.lp.util.Helper;

public class FeiertagDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer iId;
	private String mandantCNr;

	private Integer religionIId;
	private Integer tagesartIId;

	private Integer iTag;
	private Integer iMonat;

	public Integer getiTag() {
		return iTag;
	}

	public void setiTag(Integer iTag) {
		this.iTag = iTag;
	}

	public Integer getiMonat() {
		return iMonat;
	}

	public void setiMonat(Integer iMonat) {
		this.iMonat = iMonat;
	}

	private Integer iOffsetOstersonntag;

	public Integer getIOffsetOstersonntag() {
		return iOffsetOstersonntag;
	}

	public void setIOffsetOstersonntag(Integer iOffsetOstersonntag) {
		this.iOffsetOstersonntag = iOffsetOstersonntag;
	}

	public Integer getIId() {
		return iId;
	}

	private String cBez;

	public void setIId(Integer iId) {
		this.iId = iId;
	}

	public String getMandantCNr() {
		return mandantCNr;
	}

	public void setMandantCNr(String mandantCNr) {
		this.mandantCNr = mandantCNr;
	}


	public Integer getReligionIId() {
		return religionIId;
	}

	public void setReligionIId(Integer religionIId) {
		this.religionIId = religionIId;
	}

	public Integer getTagesartIId() {
		return tagesartIId;
	}

	public void setTagesartIId(Integer tagesartIId) {
		this.tagesartIId = tagesartIId;
	}

	public String getCBez() {
		return cBez;
	}

	public void setCBez(String cBez) {
		this.cBez = cBez;
	}

}
