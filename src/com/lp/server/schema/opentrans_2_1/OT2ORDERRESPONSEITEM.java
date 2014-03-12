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
import com.lp.server.schema.bmecat_2005.BCSPECIALTREATMENTCLASS;


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
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}LINE_ITEM_ID"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}PRODUCT_ID"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}PRODUCT_FEATURES" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}PRODUCT_COMPONENTS" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}QUANTITY"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ORDER_UNIT"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}PRODUCT_PRICE_FIX" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}PRICE_LINE_AMOUNT" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}DELIVERY_DATE" minOccurs="0"/>
 *           &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}PARTIAL_DELIVERY_LIST" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}SHIPMENT_PARTIES_REFERENCE" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}SPECIAL_TREATMENT_CLASS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}MIME_INFO" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}REMARKS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}ITEM_UDX" minOccurs="0"/>
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
    "lineitemid",
    "productid",
    "productfeatures",
    "productcomponents",
    "quantity",
    "orderunit",
    "productpricefix",
    "pricelineamount",
    "deliverydate",
    "partialdeliverylist",
    "shipmentpartiesreference",
    "specialtreatmentclass",
    "mimeinfo",
    "remarks",
    "itemudx"
})
@XmlRootElement(name = "ORDERRESPONSE_ITEM")
public class OT2ORDERRESPONSEITEM {

    @XmlElement(name = "LINE_ITEM_ID", required = true)
    protected String lineitemid;
    @XmlElement(name = "PRODUCT_ID", required = true)
    protected OT2PRODUCTID productid;
    @XmlElement(name = "PRODUCT_FEATURES")
    protected OT2PRODUCTFEATURES productfeatures;
    @XmlElement(name = "PRODUCT_COMPONENTS")
    protected OT2PRODUCTCOMPONENTS productcomponents;
    @XmlElement(name = "QUANTITY", required = true)
    protected BigDecimal quantity;
    @XmlElement(name = "ORDER_UNIT", namespace = "http://www.bmecat.org/bmecat/2005", required = true)
    protected String orderunit;
    @XmlElement(name = "PRODUCT_PRICE_FIX")
    protected OT2PRODUCTPRICEFIX productpricefix;
    @XmlElement(name = "PRICE_LINE_AMOUNT")
    protected BigDecimal pricelineamount;
    @XmlElement(name = "DELIVERY_DATE")
    protected OT2DELIVERYDATE deliverydate;
    @XmlElement(name = "PARTIAL_DELIVERY_LIST")
    protected OT2PARTIALDELIVERYLIST partialdeliverylist;
    @XmlElement(name = "SHIPMENT_PARTIES_REFERENCE")
    protected OT2SHIPMENTPARTIESREFERENCE shipmentpartiesreference;
    @XmlElement(name = "SPECIAL_TREATMENT_CLASS", namespace = "http://www.bmecat.org/bmecat/2005")
    protected List<BCSPECIALTREATMENTCLASS> specialtreatmentclass;
    @XmlElement(name = "MIME_INFO")
    protected OT2MIMEINFO mimeinfo;
    @XmlElement(name = "REMARKS")
    protected List<OT2REMARKS> remarks;
    @XmlElement(name = "ITEM_UDX")
    protected UdxITEM itemudx;

    /**
     * Gets the value of the lineitemid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINEITEMID() {
        return lineitemid;
    }

    /**
     * Sets the value of the lineitemid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINEITEMID(String value) {
        this.lineitemid = value;
    }

    /**
     * Gets the value of the productid property.
     * 
     * @return
     *     possible object is
     *     {@link OT2PRODUCTID }
     *     
     */
    public OT2PRODUCTID getPRODUCTID() {
        return productid;
    }

    /**
     * Sets the value of the productid property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2PRODUCTID }
     *     
     */
    public void setPRODUCTID(OT2PRODUCTID value) {
        this.productid = value;
    }

    /**
     * Gets the value of the productfeatures property.
     * 
     * @return
     *     possible object is
     *     {@link OT2PRODUCTFEATURES }
     *     
     */
    public OT2PRODUCTFEATURES getPRODUCTFEATURES() {
        return productfeatures;
    }

    /**
     * Sets the value of the productfeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2PRODUCTFEATURES }
     *     
     */
    public void setPRODUCTFEATURES(OT2PRODUCTFEATURES value) {
        this.productfeatures = value;
    }

    /**
     * Gets the value of the productcomponents property.
     * 
     * @return
     *     possible object is
     *     {@link OT2PRODUCTCOMPONENTS }
     *     
     */
    public OT2PRODUCTCOMPONENTS getPRODUCTCOMPONENTS() {
        return productcomponents;
    }

    /**
     * Sets the value of the productcomponents property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2PRODUCTCOMPONENTS }
     *     
     */
    public void setPRODUCTCOMPONENTS(OT2PRODUCTCOMPONENTS value) {
        this.productcomponents = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQUANTITY() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQUANTITY(BigDecimal value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the orderunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDERUNIT() {
        return orderunit;
    }

    /**
     * Sets the value of the orderunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDERUNIT(String value) {
        this.orderunit = value;
    }

    /**
     * Gets the value of the productpricefix property.
     * 
     * @return
     *     possible object is
     *     {@link OT2PRODUCTPRICEFIX }
     *     
     */
    public OT2PRODUCTPRICEFIX getPRODUCTPRICEFIX() {
        return productpricefix;
    }

    /**
     * Sets the value of the productpricefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2PRODUCTPRICEFIX }
     *     
     */
    public void setPRODUCTPRICEFIX(OT2PRODUCTPRICEFIX value) {
        this.productpricefix = value;
    }

    /**
     * Gets the value of the pricelineamount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPRICELINEAMOUNT() {
        return pricelineamount;
    }

    /**
     * Sets the value of the pricelineamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPRICELINEAMOUNT(BigDecimal value) {
        this.pricelineamount = value;
    }

    /**
     * Gets the value of the deliverydate property.
     * 
     * @return
     *     possible object is
     *     {@link OT2DELIVERYDATE }
     *     
     */
    public OT2DELIVERYDATE getDELIVERYDATE() {
        return deliverydate;
    }

    /**
     * Sets the value of the deliverydate property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2DELIVERYDATE }
     *     
     */
    public void setDELIVERYDATE(OT2DELIVERYDATE value) {
        this.deliverydate = value;
    }

    /**
     * Gets the value of the partialdeliverylist property.
     * 
     * @return
     *     possible object is
     *     {@link OT2PARTIALDELIVERYLIST }
     *     
     */
    public OT2PARTIALDELIVERYLIST getPARTIALDELIVERYLIST() {
        return partialdeliverylist;
    }

    /**
     * Sets the value of the partialdeliverylist property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2PARTIALDELIVERYLIST }
     *     
     */
    public void setPARTIALDELIVERYLIST(OT2PARTIALDELIVERYLIST value) {
        this.partialdeliverylist = value;
    }

    /**
     * Gets the value of the shipmentpartiesreference property.
     * 
     * @return
     *     possible object is
     *     {@link OT2SHIPMENTPARTIESREFERENCE }
     *     
     */
    public OT2SHIPMENTPARTIESREFERENCE getSHIPMENTPARTIESREFERENCE() {
        return shipmentpartiesreference;
    }

    /**
     * Sets the value of the shipmentpartiesreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2SHIPMENTPARTIESREFERENCE }
     *     
     */
    public void setSHIPMENTPARTIESREFERENCE(OT2SHIPMENTPARTIESREFERENCE value) {
        this.shipmentpartiesreference = value;
    }

    /**
     * Gets the value of the specialtreatmentclass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialtreatmentclass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSPECIALTREATMENTCLASS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCSPECIALTREATMENTCLASS }
     * 
     * 
     */
    public List<BCSPECIALTREATMENTCLASS> getSPECIALTREATMENTCLASS() {
        if (specialtreatmentclass == null) {
            specialtreatmentclass = new ArrayList<BCSPECIALTREATMENTCLASS>();
        }
        return this.specialtreatmentclass;
    }

    /**
     * Gets the value of the mimeinfo property.
     * 
     * @return
     *     possible object is
     *     {@link OT2MIMEINFO }
     *     
     */
    public OT2MIMEINFO getMIMEINFO() {
        return mimeinfo;
    }

    /**
     * Sets the value of the mimeinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2MIMEINFO }
     *     
     */
    public void setMIMEINFO(OT2MIMEINFO value) {
        this.mimeinfo = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remarks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getREMARKS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OT2REMARKS }
     * 
     * 
     */
    public List<OT2REMARKS> getREMARKS() {
        if (remarks == null) {
            remarks = new ArrayList<OT2REMARKS>();
        }
        return this.remarks;
    }

    /**
     * Gets the value of the itemudx property.
     * 
     * @return
     *     possible object is
     *     {@link UdxITEM }
     *     
     */
    public UdxITEM getITEMUDX() {
        return itemudx;
    }

    /**
     * Sets the value of the itemudx property.
     * 
     * @param value
     *     allowed object is
     *     {@link UdxITEM }
     *     
     */
    public void setITEMUDX(UdxITEM value) {
        this.itemudx = value;
    }

}
