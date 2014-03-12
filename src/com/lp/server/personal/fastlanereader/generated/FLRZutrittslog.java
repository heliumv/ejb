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
package com.lp.server.personal.fastlanereader.generated;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.lp.server.system.fastlanereader.generated.FLRMandant;

/** @author Hibernate CodeGenerator */
public class FLRZutrittslog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/** identifier field */
	private Integer i_id;

	/** nullable persistent field */
	private String c_person;

	/** nullable persistent field */
	private String c_ausweis;

	/** nullable persistent field */
	private String c_zutrittscontroller;

	/** nullable persistent field */
	private String c_zutrittsobjekt;

	/** nullable persistent field */
	private String mandant_c_nr;

	/** nullable persistent field */
	private String mandant_c_nr_objekt;

	/** nullable persistent field */
	private Date t_zeitpunkt;

	/** nullable persistent field */
	private Short b_erlaubt;

	/** nullable persistent field */
	private FLRMandant flrmandant;

	/** full constructor */
	public FLRZutrittslog(String c_person, String c_ausweis,
			String c_zutrittscontroller, String c_zutrittsobjekt,
			String mandant_c_nr, String mandant_c_nr_objekt, Date t_zeitpunkt,
			Short b_erlaubt, FLRMandant flrmandant) {
		this.c_person = c_person;
		this.c_ausweis = c_ausweis;
		this.c_zutrittscontroller = c_zutrittscontroller;
		this.c_zutrittsobjekt = c_zutrittsobjekt;
		this.mandant_c_nr = mandant_c_nr;
		this.mandant_c_nr_objekt = mandant_c_nr_objekt;
		this.t_zeitpunkt = t_zeitpunkt;
		this.b_erlaubt = b_erlaubt;
		this.flrmandant = flrmandant;
	}

	/** default constructor */
	public FLRZutrittslog() {
	}

	public Integer getI_id() {
		return this.i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public String getC_person() {
		return this.c_person;
	}

	public void setC_person(String c_person) {
		this.c_person = c_person;
	}

	public String getC_ausweis() {
		return this.c_ausweis;
	}

	public void setC_ausweis(String c_ausweis) {
		this.c_ausweis = c_ausweis;
	}

	public String getC_zutrittscontroller() {
		return this.c_zutrittscontroller;
	}

	public void setC_zutrittscontroller(String c_zutrittscontroller) {
		this.c_zutrittscontroller = c_zutrittscontroller;
	}

	public String getC_zutrittsobjekt() {
		return this.c_zutrittsobjekt;
	}

	public void setC_zutrittsobjekt(String c_zutrittsobjekt) {
		this.c_zutrittsobjekt = c_zutrittsobjekt;
	}

	public String getMandant_c_nr() {
		return this.mandant_c_nr;
	}

	public void setMandant_c_nr(String mandant_c_nr) {
		this.mandant_c_nr = mandant_c_nr;
	}

	public String getMandant_c_nr_objekt() {
		return this.mandant_c_nr_objekt;
	}

	public void setMandant_c_nr_objekt(String mandant_c_nr_objekt) {
		this.mandant_c_nr_objekt = mandant_c_nr_objekt;
	}

	public Date getT_zeitpunkt() {
		return this.t_zeitpunkt;
	}

	public void setT_zeitpunkt(Date t_zeitpunkt) {
		this.t_zeitpunkt = t_zeitpunkt;
	}

	public Short getB_erlaubt() {
		return this.b_erlaubt;
	}

	public void setB_erlaubt(Short b_erlaubt) {
		this.b_erlaubt = b_erlaubt;
	}

	public FLRMandant getFlrmandant() {
		return this.flrmandant;
	}

	public void setFlrmandant(FLRMandant flrmandant) {
		this.flrmandant = flrmandant;
	}

	public String toString() {
		return new ToStringBuilder(this).append("i_id", getI_id()).toString();
	}

}
