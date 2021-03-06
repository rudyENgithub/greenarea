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
package it.vige.greenarea.sgapl.sgot.webservice.wsdata;

import java.io.Serializable;

public class RequestShippingResponseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6466184748534553365L;
	private ResultOperationResponse result;
	private String shippingOrderID;
	private String totalCost;// Long totalCost;
	private Long maxTimeShipment;
	private Long maxTimeValidity;

	public RequestShippingResponseData() {
		result = null;
		shippingOrderID = null;
		totalCost = null;
		maxTimeShipment = null;
		maxTimeValidity = null;
	}

	public RequestShippingResponseData(ResultOperationResponse result) {
		this();
		this.result = result;
	}

	public Long getMaxTimeShipment() {
		return maxTimeShipment;
	}

	public void setMaxTimeShipment(Long maxTimeShipment) {
		this.maxTimeShipment = maxTimeShipment;
	}

	public Long getMaxTimeValidity() {
		return maxTimeValidity;
	}

	public void setMaxTimeValidity(Long maxTimeValidity) {
		this.maxTimeValidity = maxTimeValidity;
	}

	public ResultOperationResponse getResult() {
		return result;
	}

	public void setResult(ResultOperationResponse result) {
		this.result = result;
	}

	public String getShippingOrderID() {
		return shippingOrderID;
	}

	public void setShippingOrderID(String shippingOrderID) {
		this.shippingOrderID = shippingOrderID;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

}
