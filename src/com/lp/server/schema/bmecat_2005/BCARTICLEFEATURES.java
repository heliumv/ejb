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


package com.lp.server.schema.bmecat_2005;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}REFERENCE_FEATURE_SYSTEM_NAME" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}REFERENCE_FEATURE_GROUP_ID" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}REFERENCE_FEATURE_GROUP_NAME" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}REFERENCE_FEATURE_GROUP_ID2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_ARTICLEORDER" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}FEATURE" maxOccurs="unbounded" minOccurs="0"/>
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
    "referencefeaturesystemname",
    "referencefeaturegroupid",
    "referencefeaturegroupname",
    "referencefeaturegroupid2",
    "classificationgrouparticleorder",
    "feature"
})
@XmlRootElement(name = "ARTICLE_FEATURES")
public class BCARTICLEFEATURES {

    @XmlElement(name = "REFERENCE_FEATURE_SYSTEM_NAME")
    protected String referencefeaturesystemname;
    @XmlElement(name = "REFERENCE_FEATURE_GROUP_ID")
    protected List<TypeCLASSIFICATIONGROUPID> referencefeaturegroupid;
    @XmlElement(name = "REFERENCE_FEATURE_GROUP_NAME")
    protected List<BCREFERENCEFEATUREGROUPNAME> referencefeaturegroupname;
    @XmlElement(name = "REFERENCE_FEATURE_GROUP_ID2")
    protected List<TypeCLASSIFICATIONGROUPID> referencefeaturegroupid2;
    @XmlElement(name = "CLASSIFICATION_GROUP_ARTICLEORDER")
    protected BigInteger classificationgrouparticleorder;
    @XmlElement(name = "FEATURE")
    protected List<BCFEATURE> feature;

    /**
     * Gets the value of the referencefeaturesystemname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFERENCEFEATURESYSTEMNAME() {
        return referencefeaturesystemname;
    }

    /**
     * Sets the value of the referencefeaturesystemname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFERENCEFEATURESYSTEMNAME(String value) {
        this.referencefeaturesystemname = value;
    }

    /**
     * Gets the value of the referencefeaturegroupid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referencefeaturegroupid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getREFERENCEFEATUREGROUPID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeCLASSIFICATIONGROUPID }
     * 
     * 
     */
    public List<TypeCLASSIFICATIONGROUPID> getREFERENCEFEATUREGROUPID() {
        if (referencefeaturegroupid == null) {
            referencefeaturegroupid = new ArrayList<TypeCLASSIFICATIONGROUPID>();
        }
        return this.referencefeaturegroupid;
    }

    /**
     * Gets the value of the referencefeaturegroupname property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referencefeaturegroupname property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getREFERENCEFEATUREGROUPNAME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCREFERENCEFEATUREGROUPNAME }
     * 
     * 
     */
    public List<BCREFERENCEFEATUREGROUPNAME> getREFERENCEFEATUREGROUPNAME() {
        if (referencefeaturegroupname == null) {
            referencefeaturegroupname = new ArrayList<BCREFERENCEFEATUREGROUPNAME>();
        }
        return this.referencefeaturegroupname;
    }

    /**
     * Gets the value of the referencefeaturegroupid2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referencefeaturegroupid2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getREFERENCEFEATUREGROUPID2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeCLASSIFICATIONGROUPID }
     * 
     * 
     */
    public List<TypeCLASSIFICATIONGROUPID> getREFERENCEFEATUREGROUPID2() {
        if (referencefeaturegroupid2 == null) {
            referencefeaturegroupid2 = new ArrayList<TypeCLASSIFICATIONGROUPID>();
        }
        return this.referencefeaturegroupid2;
    }

    /**
     * Gets the value of the classificationgrouparticleorder property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCLASSIFICATIONGROUPARTICLEORDER() {
        return classificationgrouparticleorder;
    }

    /**
     * Sets the value of the classificationgrouparticleorder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCLASSIFICATIONGROUPARTICLEORDER(BigInteger value) {
        this.classificationgrouparticleorder = value;
    }

    /**
     * Gets the value of the feature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFEATURE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCFEATURE }
     * 
     * 
     */
    public List<BCFEATURE> getFEATURE() {
        if (feature == null) {
            feature = new ArrayList<BCFEATURE>();
        }
        return this.feature;
    }

}