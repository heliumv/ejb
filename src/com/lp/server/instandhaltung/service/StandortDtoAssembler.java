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
package com.lp.server.instandhaltung.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.lp.server.instandhaltung.ejb.Standort;

public class StandortDtoAssembler {
	public static StandortDto createDto(Standort bean) {
		StandortDto dto = new StandortDto();
		if (bean != null) {
			dto.setIId(bean.getIId());
			dto.setInstandhaltungIId(bean.getInstandhaltungIId());
			dto.setPartnerIId(bean.getPartnerIId());
			dto.setBVersteckt(bean.getBVersteckt());
			dto.setAnsprechpartnerIId(bean.getAnsprechpartnerIId());
			dto.setXBemerkung(bean.getXBemerkung());
			dto.setAuftragIId(bean.getAuftragIId());
			dto.setCDokumentenlink(bean.getCDokumentenlink());
		}
		return dto;
	}

	public static StandortDto[] createDtos(Collection<?> beans) {
		List<StandortDto> list = new ArrayList<StandortDto>();
		if (beans != null) {
			Iterator<?> iterator = beans.iterator();
			while (iterator.hasNext()) {
				list.add(createDto((Standort) iterator.next()));
			}
		}
		StandortDto[] returnArray = new StandortDto[list.size()];
		return (StandortDto[]) list.toArray(returnArray);
	}
}
