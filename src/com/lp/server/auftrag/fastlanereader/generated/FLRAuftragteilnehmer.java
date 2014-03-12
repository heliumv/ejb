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
package com.lp.server.auftrag.fastlanereader.generated;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.lp.server.partner.fastlanereader.generated.FLRPartner;
import com.lp.server.personal.fastlanereader.generated.FLRPersonal;
import com.lp.server.system.fastlanereader.generated.FLRFunktion;

/** @author Hibernate CodeGenerator */
public class FLRAuftragteilnehmer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer i_id;

	/** nullable persistent field */
	private int i_sort;

	/** nullable persistent field */
	private com.lp.server.auftrag.fastlanereader.generated.FLRAuftragReport flrauftrag;

	/** nullable persistent field */
	private FLRPartner flrpartner;

	/** nullable persistent field */
	private FLRFunktion flrfunktion;

	/** nullable persistent field */
	private FLRPersonal flrpersonal;

	/** full constructor */
	public FLRAuftragteilnehmer(
			int i_sort,
			com.lp.server.auftrag.fastlanereader.generated.FLRAuftragReport flrauftrag,
			FLRPartner flrpartner, FLRFunktion flrfunktion,
			FLRPersonal flrpersonal) {
		this.i_sort = i_sort;
		this.flrauftrag = flrauftrag;
		this.flrpartner = flrpartner;
		this.flrfunktion = flrfunktion;
		this.flrpersonal = flrpersonal;
	}

	/** default constructor */
	public FLRAuftragteilnehmer() {
	}

	public Integer getI_id() {
		return this.i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public int getI_sort() {
		return this.i_sort;
	}

	public void setI_sort(int i_sort) {
		this.i_sort = i_sort;
	}

	public com.lp.server.auftrag.fastlanereader.generated.FLRAuftragReport getFlrauftrag() {
		return this.flrauftrag;
	}

	public void setFlrauftrag(
			com.lp.server.auftrag.fastlanereader.generated.FLRAuftragReport flrauftrag) {
		this.flrauftrag = flrauftrag;
	}

	public FLRPartner getFlrpartner() {
		return this.flrpartner;
	}

	public void setFlrpartner(FLRPartner flrpartner) {
		this.flrpartner = flrpartner;
	}

	public FLRFunktion getFlrfunktion() {
		return this.flrfunktion;
	}

	public void setFlrfunktion(FLRFunktion flrfunktion) {
		this.flrfunktion = flrfunktion;
	}

	public FLRPersonal getFlrpersonal() {
		return this.flrpersonal;
	}

	public void setFlrpersonal(FLRPersonal flrpersonal) {
		this.flrpersonal = flrpersonal;
	}

	public String toString() {
		return new ToStringBuilder(this).append("i_id", getI_id()).toString();
	}

}
