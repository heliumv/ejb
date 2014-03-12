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
package com.lp.server.inserat.fastlanereader.generated;

import com.lp.server.eingangsrechnung.fastlanereader.generated.FLREingangsrechnung;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class FLRInserater implements Serializable {

    /** identifier field */
    private Integer i_id;

    /** nullable persistent field */
    private Integer inserat_i_id;

    /** nullable persistent field */
    private BigDecimal n_betrag;

    /** nullable persistent field */
    private Integer eingangsrechnung_i_id;

    /** nullable persistent field */
    private String c_text;

    /** nullable persistent field */
    private FLREingangsrechnung flreingangsrechnung;

    /** nullable persistent field */
    private com.lp.server.inserat.fastlanereader.generated.FLRInserat flrinserat;

    /** full constructor */
    public FLRInserater(Integer inserat_i_id, BigDecimal n_betrag, Integer eingangsrechnung_i_id, String c_text, FLREingangsrechnung flreingangsrechnung, com.lp.server.inserat.fastlanereader.generated.FLRInserat flrinserat) {
        this.inserat_i_id = inserat_i_id;
        this.n_betrag = n_betrag;
        this.eingangsrechnung_i_id = eingangsrechnung_i_id;
        this.c_text = c_text;
        this.flreingangsrechnung = flreingangsrechnung;
        this.flrinserat = flrinserat;
    }

    /** default constructor */
    public FLRInserater() {
    }

    public Integer getI_id() {
        return this.i_id;
    }

    public void setI_id(Integer i_id) {
        this.i_id = i_id;
    }

    public Integer getInserat_i_id() {
        return this.inserat_i_id;
    }

    public void setInserat_i_id(Integer inserat_i_id) {
        this.inserat_i_id = inserat_i_id;
    }

    public BigDecimal getN_betrag() {
        return this.n_betrag;
    }

    public void setN_betrag(BigDecimal n_betrag) {
        this.n_betrag = n_betrag;
    }

    public Integer getEingangsrechnung_i_id() {
        return this.eingangsrechnung_i_id;
    }

    public void setEingangsrechnung_i_id(Integer eingangsrechnung_i_id) {
        this.eingangsrechnung_i_id = eingangsrechnung_i_id;
    }

    public String getC_text() {
        return this.c_text;
    }

    public void setC_text(String c_text) {
        this.c_text = c_text;
    }

    public FLREingangsrechnung getFlreingangsrechnung() {
        return this.flreingangsrechnung;
    }

    public void setFlreingangsrechnung(FLREingangsrechnung flreingangsrechnung) {
        this.flreingangsrechnung = flreingangsrechnung;
    }

    public com.lp.server.inserat.fastlanereader.generated.FLRInserat getFlrinserat() {
        return this.flrinserat;
    }

    public void setFlrinserat(com.lp.server.inserat.fastlanereader.generated.FLRInserat flrinserat) {
        this.flrinserat = flrinserat;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("i_id", getI_id())
            .toString();
    }

}
