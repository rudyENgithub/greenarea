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
package it.vige.greenarea.itseasy.sgrl.wswrapper;

import it.vige.greenarea.sgrl.webservices.LogisticNetworkRouting;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "LogisticNetworkRouting", targetNamespace = "http://webservices.sgrl.greenarea.vige.it/", wsdlLocation = "http://NBW72011844431.vige.local:8080/SGRL/LogisticNetworkRouting?wsdl")
public class LogisticNetworkRoutingService extends Service {

	private static URL LOGISTICNETWORKROUTING_WSDL_LOCATION;
	private static WebServiceException LOGISTICNETWORKROUTING_EXCEPTION;
	private final static QName LOGISTICNETWORKROUTING_QNAME = new QName(
			"http://webservices.sgrl.greenarea.vige.it/",
			"LogisticNetworkRouting");

	public static void setRootUrl(String root) {
		URL url = null;
		WebServiceException e = null;
		try {
			url = new URL(root + "LogisticNetworkRouting?wsdl");
		} catch (MalformedURLException ex) {
			e = new WebServiceException(ex);
		}
		LOGISTICNETWORKROUTING_WSDL_LOCATION = url;
		LOGISTICNETWORKROUTING_EXCEPTION = e;
	}

	public LogisticNetworkRoutingService() {
		super(__getWsdlLocation(), LOGISTICNETWORKROUTING_QNAME);
	}

	public LogisticNetworkRoutingService(WebServiceFeature... features) {
		super(__getWsdlLocation(), LOGISTICNETWORKROUTING_QNAME, features);
	}

	public LogisticNetworkRoutingService(URL wsdlLocation) {
		super(wsdlLocation, LOGISTICNETWORKROUTING_QNAME);
	}

	public LogisticNetworkRoutingService(URL wsdlLocation,
			WebServiceFeature... features) {
		super(wsdlLocation, LOGISTICNETWORKROUTING_QNAME, features);
	}

	public LogisticNetworkRoutingService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public LogisticNetworkRoutingService(URL wsdlLocation, QName serviceName,
			WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	/**
	 * 
	 * @return returns LogisticNetworkRouting
	 */
	@WebEndpoint(name = "LogisticNetworkRoutingPort")
	public LogisticNetworkRouting getLogisticNetworkRoutingPort() {
		return super.getPort(new QName(
				"http://webservices.sgrl.greenarea.vige.it/",
				"LogisticNetworkRoutingPort"), LogisticNetworkRouting.class);
	}

	/**
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return returns LogisticNetworkRouting
	 */
	@WebEndpoint(name = "LogisticNetworkRoutingPort")
	public LogisticNetworkRouting getLogisticNetworkRoutingPort(
			WebServiceFeature... features) {
		return super.getPort(new QName(
				"http://webservices.sgrl.greenarea.vige.it/",
				"LogisticNetworkRoutingPort"), LogisticNetworkRouting.class,
				features);
	}

	private static URL __getWsdlLocation() {
		if (LOGISTICNETWORKROUTING_EXCEPTION != null) {
			throw LOGISTICNETWORKROUTING_EXCEPTION;
		}
		return LOGISTICNETWORKROUTING_WSDL_LOCATION;
	}

}
