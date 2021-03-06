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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.30 at 04:44:14 PM MEZ 
//


package com.lp.server.schema.opentrans_2_1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lp.server.schema.bmecat_2005.BCPRICEFLAG;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}PRICE_AMOUNT"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}ALLOW_OR_CHARGES_FIX" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}PRICE_FLAG" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}TAX_DETAILS_FIX" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}PRICE_QUANTITY" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}PRICE_BASE_FIX" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "priceamount",
    "alloworchargesfix",
    "priceflag",
    "taxdetailsfix",
    "pricequantity",
    "pricebasefix"
})
@XmlRootElement(name = "PRODUCT_PRICE_FIX")
public class OT2PRODUCTPRICEFIX {

    @XmlElement(name = "PRICE_AMOUNT", namespace = "http://www.bmecat.org/bmecat/2005", required = true)
    protected BigDecimal priceamount;
    @XmlElement(name = "ALLOW_OR_CHARGES_FIX")
    protected OT2ALLOWORCHARGESFIX alloworchargesfix;
    @XmlElement(name = "PRICE_FLAG", namespace = "http://www.bmecat.org/bmecat/2005")
    protected List<BCPRICEFLAG> priceflag;
    @XmlElement(name = "TAX_DETAILS_FIX")
    protected List<OT2TAXDETAILSFIX> taxdetailsfix;
    @XmlElement(name = "PRICE_QUANTITY", namespace = "http://www.bmecat.org/bmecat/2005", defaultValue = "1")
    protected BigDecimal pricequantity;
    @XmlElement(name = "PRICE_BASE_FIX")
    protected OT2PRICEBASEFIX pricebasefix;

    /**
     * Gets the value of the priceamount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPRICEAMOUNT() {
        return priceamount;
    }

    /**
     * Sets the value of the priceamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPRICEAMOUNT(BigDecimal value) {
        this.priceamount = value;
    }

    /**
     * Gets the value of the alloworchargesfix property.
     * 
     * @return
     *     possible object is
     *     {@link OT2ALLOWORCHARGESFIX }
     *     
     */
    public OT2ALLOWORCHARGESFIX getALLOWORCHARGESFIX() {
        return alloworchargesfix;
    }

    /**
     * Sets the value of the alloworchargesfix property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2ALLOWORCHARGESFIX }
     *     
     */
    public void setALLOWORCHARGESFIX(OT2ALLOWORCHARGESFIX value) {
        this.alloworchargesfix = value;
    }

    /**
     * Gets the value of the priceflag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priceflag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPRICEFLAG().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCPRICEFLAG }
     * 
     * 
     */
    public List<BCPRICEFLAG> getPRICEFLAG() {
        if (priceflag == null) {
            priceflag = new ArrayList<BCPRICEFLAG>();
        }
        return this.priceflag;
    }

    /**
     * Gets the value of the taxdetailsfix property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxdetailsfix property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTAXDETAILSFIX().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OT2TAXDETAILSFIX }
     * 
     * 
     */
    public List<OT2TAXDETAILSFIX> getTAXDETAILSFIX() {
        if (taxdetailsfix == null) {
            taxdetailsfix = new ArrayList<OT2TAXDETAILSFIX>();
        }
        return this.taxdetailsfix;
    }

    /**
     * Gets the value of the pricequantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPRICEQUANTITY() {
        return pricequantity;
    }

    /**
     * Sets the value of the pricequantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPRICEQUANTITY(BigDecimal value) {
        this.pricequantity = value;
    }

    /**
     * Gets the value of the pricebasefix property.
     * 
     * @return
     *     possible object is
     *     {@link OT2PRICEBASEFIX }
     *     
     */
    public OT2PRICEBASEFIX getPRICEBASEFIX() {
        return pricebasefix;
    }

    /**
     * Sets the value of the pricebasefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2PRICEBASEFIX }
     *     
     */
    public void setPRICEBASEFIX(OT2PRICEBASEFIX value) {
        this.pricebasefix = value;
    }

}
