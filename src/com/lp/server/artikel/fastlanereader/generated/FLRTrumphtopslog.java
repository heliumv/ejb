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
package com.lp.server.artikel.fastlanereader.generated;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class FLRTrumphtopslog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer i_id;

	/** nullable persistent field */
	private Integer artikel_i_id;

	/** nullable persistent field */
	private BigDecimal n_gestpreisneu;

	/** nullable persistent field */
	private Date t_anlegen;

	/** full constructor */
	public FLRTrumphtopslog(Integer artikel_i_id, BigDecimal n_gestpreisneu,
			Date t_anlegen) {
		this.artikel_i_id = artikel_i_id;
		this.n_gestpreisneu = n_gestpreisneu;
		this.t_anlegen = t_anlegen;
	}

	/** default constructor */
	public FLRTrumphtopslog() {
	}

	public Integer getI_id() {
		return this.i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public Integer getArtikel_i_id() {
		return this.artikel_i_id;
	}

	public void setArtikel_i_id(Integer artikel_i_id) {
		this.artikel_i_id = artikel_i_id;
	}

	public BigDecimal getN_gestpreisneu() {
		return this.n_gestpreisneu;
	}

	public void setN_gestpreisneu(BigDecimal n_gestpreisneu) {
		this.n_gestpreisneu = n_gestpreisneu;
	}

	public Date getT_anlegen() {
		return this.t_anlegen;
	}

	public void setT_anlegen(Date t_anlegen) {
		this.t_anlegen = t_anlegen;
	}

	public String toString() {
		return new ToStringBuilder(this).append("i_id", getI_id()).toString();
	}

}
