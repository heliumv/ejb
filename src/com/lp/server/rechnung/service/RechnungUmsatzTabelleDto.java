/*******************************************************************************
 * HELIUM V, Open Source ERP software for sustained success
 * at small and medium-sized enterprises.
 * Copyright (C) 2004 - 2015 HELIUM V IT-Solutions GmbH
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
package com.lp.server.rechnung.service;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lp.server.auftrag.service.TabelleDto;

public class RechnungUmsatzTabelleDto extends TabelleDto implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal bdOffeneBrutto;
	private BigDecimal bdOffeneNetto;
	private String sEmpty = TabelleDto.LEERESPALTE;
	private BigDecimal bdUmsatzBrutto;
	private BigDecimal bdUmsatzNetto;
	private BigDecimal bdAnzahlungBrutto;
	private BigDecimal bdAnzahlungNetto;

	public BigDecimal getBdAnzahlungBrutto() {
		return bdAnzahlungBrutto;
	}

	public BigDecimal getBdAnzahlungNetto() {
		return bdAnzahlungNetto;
	}

	public BigDecimal getBdOffeneBrutto() {
		return bdOffeneBrutto;
	}

	public BigDecimal getBdOffeneNetto() {
		return bdOffeneNetto;
	}

	public BigDecimal getBdUmsatzBrutto() {
		return bdUmsatzBrutto;
	}

	public BigDecimal getBdUmsatzNetto() {
		return bdUmsatzNetto;
	}

	public String getSEmpty() {
		return sEmpty;
	}

	public void setBdAnzahlungBrutto(BigDecimal bdAnzahlungBrutto) {
		this.bdAnzahlungBrutto = bdAnzahlungBrutto;
	}

	public void setBdAnzahlungNetto(BigDecimal bdAnzahlungNetto) {
		this.bdAnzahlungNetto = bdAnzahlungNetto;
	}

	public void setBdOffeneBrutto(BigDecimal bdOffeneBrutto) {
		this.bdOffeneBrutto = bdOffeneBrutto;
	}

	public void setBdOffeneNetto(BigDecimal bdOffeneNetto) {
		this.bdOffeneNetto = bdOffeneNetto;
	}

	public void setBdUmsatzBrutto(BigDecimal bdUmsatzBrutto) {
		this.bdUmsatzBrutto = bdUmsatzBrutto;
	}

	public void setBdUmsatzNetto(BigDecimal bdUmsatzNetto) {
		this.bdUmsatzNetto = bdUmsatzNetto;
	}

	public void setSEmpty(String sEmpty) {
		this.sEmpty = sEmpty;
	}

}
