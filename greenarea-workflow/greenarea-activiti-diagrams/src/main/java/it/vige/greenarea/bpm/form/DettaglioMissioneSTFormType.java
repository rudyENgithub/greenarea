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

import it.vige.greenarea.dto.Missione;

import java.io.Serializable;

import org.activiti.engine.form.AbstractFormType;

public class DettaglioMissioneSTFormType extends AbstractFormType implements Serializable {

	private static final long serialVersionUID = 3503702529278473233L;
	
	private Missione missione;

	@Override
	public String getName() {
		return "dettaglioMissioneST";
	}

	@Override
	public Missione convertFormValueToModelValue(String propertyValue) {
		return missione;
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		if (modelValue != null) {
			missione = (Missione) modelValue;
			return modelValue.toString();
		} else
			return "";
	}

	@Override
	public Object getInformation(String key) {
		return missione;
	}
}
