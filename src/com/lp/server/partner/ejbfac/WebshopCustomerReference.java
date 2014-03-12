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
package com.lp.server.partner.ejbfac;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Eine Datenklasse die eine Kundenreferenz enth&auml;lt
 * 
 * @author Gerold
 */
@XmlRootElement(name = "WebshopCustomerReference")
public class WebshopCustomerReference {

	private String cnr ;
	private Integer id ;
	private String externalCnr ;
	
	public WebshopCustomerReference() {
	}
	
	public WebshopCustomerReference(String cnr, Integer id) {
		setCnr(cnr) ;
		setId(id) ;
	}

	public WebshopCustomerReference(String cnr, Integer id, String externalCnr) {
		this(cnr, id) ;
		setExternalCnr(externalCnr) ;
	}
	
	
	public String getCnr() {
		return cnr;
	}

	public void setCnr(String cnr) {
		this.cnr = cnr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExternalCnr() {
		return externalCnr;
	}

	public void setExternalCnr(String externalCnr) {
		this.externalCnr = externalCnr;
	}
}
