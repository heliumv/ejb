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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries( {
		@NamedQuery(name = "ZugehoerigefindByArtikelIIdArtikelIIdZugehoerig", query = "SELECT OBJECT(o) FROM Zugehoerige o WHERE o.artikelIId = ?1 AND o.artikelIIdZugehoerig = ?2"),
		@NamedQuery(name = "ZugehoerigefindByArtikelIId", query = "SELECT OBJECT(o) FROM Zugehoerige o WHERE o.artikelIId = ?1") })
@Entity
@Table(name = "WW_ZUGEHOERIGE")
public class Zugehoerige implements Serializable {
	@Id
	@Column(name = "I_ID")
	private Integer iId;

	@Column(name = "ARTIKEL_I_ID")
	private Integer artikelIId;

	@Column(name = "ARTIKEL_I_ID_ZUGEHOERIG")
	private Integer artikelIIdZugehoerig;

	private static final long serialVersionUID = 1L;

	public Zugehoerige() {
		super();
	}

	public Zugehoerige(Integer id, Integer artikelIId,
			Integer artikelIIdZugehoerig2) {
		setIId(id);
		setArtikelIId(artikelIId);
		setArtikelIIdZugehoerig(artikelIIdZugehoerig2);
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

	public Integer getArtikelIIdZugehoerig() {
		return this.artikelIIdZugehoerig;
	}

	public void setArtikelIIdZugehoerig(Integer artikelIIdZugehoerig) {
		this.artikelIIdZugehoerig = artikelIIdZugehoerig;
	}

}
