/******************************************************************************
 * Vige, Home of Professional Open Source Copyright 2010, Vige, and           *
 * individual contributors by the @authors tag. See the copyright.txt in the  *
 * distribution for a full listing of individual contributors.                *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may    *
 * not use this file except in compliance with the License. You may obtain    *
 * a copy of the License at http://www.apache.org/licenses/LICENSE-2.0        *
 * Unless required by applicable law or agreed to in writing, software        *
 * distributed under the License is distributed on an "AS IS" BASIS,          *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 * See the License for the specific language governing permissions and        *
 * limitations under the License.                                             *
 ******************************************************************************/
package it.vige.greenarea.bpm.form;

import static it.vige.greenarea.Constants.BASE_URI_RICHIESTE;
import static it.vige.greenarea.Utilities.yyyyMMddNH;
import static javax.ws.rs.client.ClientBuilder.newClient;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;

import org.activiti.engine.form.AbstractFormType;
import org.slf4j.Logger;

import it.vige.greenarea.dto.Missione;
import it.vige.greenarea.dto.RichiestaMissioni;

public class ElencoMissioniTrFormType extends AbstractFormType implements Serializable {

	private Logger logger = getLogger(getClass());
	private static final long serialVersionUID = 1L;
	protected Map<String, String> values = new LinkedHashMap<String, String>();

	@Override
	public String getName() {
		return "missioniTrEnum";
	}

	@Override
	public Object getInformation(String key) {
		if (key.equals("values")) {
			return values;
		}
		return null;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		return propertyValue;
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		getMissioni();
		return (String) modelValue;
	}

	private void getMissioni() {
		Client client = newClient();
		Builder bldr = client.target(BASE_URI_RICHIESTE + "/getSintesiMissioni").request(APPLICATION_JSON);
		RichiestaMissioni richiesta = new RichiestaMissioni();
		String todayStr = yyyyMMddNH.format(new Date());
		Date today;
		try {
			today = yyyyMMddNH.parse(todayStr);
			richiesta.setDataInizio(today);
			richiesta.setDataFine(today);
		} catch (ParseException e) {
			logger.error("parsinge della data", e);
		}
		List<Missione> missioni = bldr.post(entity(richiesta, APPLICATION_JSON), new GenericType<List<Missione>>() {
		});
		values.clear();
		if (missioni != null)
			for (Missione missione : missioni) {
				values.put(missione.getNome(), missione.getNome());
			}
	}

}
