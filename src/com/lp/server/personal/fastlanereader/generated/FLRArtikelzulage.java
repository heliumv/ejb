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
package com.lp.server.personal.fastlanereader.generated;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.lp.server.artikel.fastlanereader.generated.FLRArtikel;

/** @author Hibernate CodeGenerator */
public class FLRArtikelzulage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/** identifier field */
	private Integer i_id;

	/** nullable persistent field */
	private Date t_gueltigab;

	/** nullable persistent field */
	private com.lp.server.personal.fastlanereader.generated.FLRZulage flrzulage;

	/** nullable persistent field */
	private FLRArtikel flrartikel;

	/** full constructor */
	public FLRArtikelzulage(
			Date t_gueltigab,
			com.lp.server.personal.fastlanereader.generated.FLRZulage flrzulage,
			FLRArtikel flrartikel) {
		this.t_gueltigab = t_gueltigab;
		this.flrzulage = flrzulage;
		this.flrartikel = flrartikel;
	}

	/** default constructor */
	public FLRArtikelzulage() {
	}

	public Integer getI_id() {
		return this.i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public Date getT_gueltigab() {
		return this.t_gueltigab;
	}

	public void setT_gueltigab(Date t_gueltigab) {
		this.t_gueltigab = t_gueltigab;
	}

	public com.lp.server.personal.fastlanereader.generated.FLRZulage getFlrzulage() {
		return this.flrzulage;
	}

	public void setFlrzulage(
			com.lp.server.personal.fastlanereader.generated.FLRZulage flrzulage) {
		this.flrzulage = flrzulage;
	}

	public FLRArtikel getFlrartikel() {
		return this.flrartikel;
	}

	public void setFlrartikel(FLRArtikel flrartikel) {
		this.flrartikel = flrartikel;
	}

	public String toString() {
		return new ToStringBuilder(this).append("i_id", getI_id()).toString();
	}

}
