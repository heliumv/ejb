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

import java.io.Serializable;

public class ZutrittscontrollerDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer iId;
	private String cBez;
	private String cAdresse;

	public Integer getIId() {
		return iId;
	}

	public String getBezeichnung() {
		String sBez = getCNr();
		if (getCBez() != null) {
			sBez = sBez + " " + getCBez();
		}
		return sBez;
	}

	public void setIId(Integer iId) {
		this.iId = iId;
	}

	private String cNr;

	public String getCBez() {
		return cBez;
	}

	public void setCBez(String cBez) {
		this.cBez = cBez;
	}

	public String getCAdresse() {
		return cAdresse;
	}

	public String getCNr() {
		return cNr;
	}

	public void setCAdresse(String cAdresse) {
		this.cAdresse = cAdresse;
	}

	public void setCNr(String cNr) {
		this.cNr = cNr;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ZutrittscontrollerDto))
			return false;
		ZutrittscontrollerDto that = (ZutrittscontrollerDto) obj;
		if (!(that.iId == null ? this.iId == null : that.iId.equals(this.iId)))
			return false;
		if (!(that.cBez == null ? this.cBez == null : that.cBez
				.equals(this.cBez)))
			return false;
		if (!(that.cAdresse == null ? this.cAdresse == null : that.cAdresse
				.equals(this.cAdresse)))
			return false;
		return true;
	}

	public int hashCode() {
		int result = 17;
		result = 37 * result + this.iId.hashCode();
		result = 37 * result + this.cBez.hashCode();
		result = 37 * result + this.cAdresse.hashCode();
		return result;
	}

	public String toString() {
		StringBuffer returnStringBuffer = new StringBuffer(96);
		returnStringBuffer.append("[");
		returnStringBuffer.append("iId:").append(iId);
		returnStringBuffer.append("cBez:").append(cBez);
		returnStringBuffer.append("cAdresse:").append(cAdresse);
		returnStringBuffer.append("]");
		return returnStringBuffer.toString();
	}
}