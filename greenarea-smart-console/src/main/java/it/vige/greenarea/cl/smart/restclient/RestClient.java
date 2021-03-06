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
package it.vige.greenarea.cl.smart.restclient;

import static javax.ws.rs.client.ClientBuilder.newClient;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;

import it.vige.greenarea.cl.bean.Request;
import it.vige.greenarea.cl.bean.TimeSlotInfo;
import it.vige.greenarea.cl.library.entities.Mission;
import it.vige.greenarea.cl.library.entities.TimeSlot;
import it.vige.greenarea.cl.library.entities.TruckServiceClass;
import it.vige.greenarea.cl.library.entities.ValueMission;
import it.vige.greenarea.cl.library.entities.Vehicle;
import it.vige.greenarea.dto.Missione;
import it.vige.greenarea.dto.Sched;

/**
 * Jersey REST client generated for REST resource:UserRESTService [/User]<br>
 * USAGE:
 * 
 * <pre>
 *        RestClient client = new RestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 * 
 * @author MacRed
 */
public class RestClient {
	private Client client;
	private static final String BASE_URI = "http://localhost:8080/greenarea-service/resources";

	// private static final String BASE_URI =
	// "http://163.162.24.18:80/cityLogistics/resources";

	public RestClient() {
		client = newClient();
	}

	public List<Sched> getAllSchedules() throws Exception {

		Invocation.Builder bldr = client.target(BASE_URI + "/TimeSlot/getAllSchedules").request(APPLICATION_JSON);
		return bldr.get(new GenericType<List<Sched>>() {
		});
	}

	public List<Sched> getSchedules(Integer idTimeslot) throws Exception {

		Invocation.Builder bldr = client.target(BASE_URI + "/TimeSlot/getSchedules/" + idTimeslot)
				.request(APPLICATION_JSON);
		return bldr.get(new GenericType<List<Sched>>() {
		});
	}

	public List<TimeSlot> findAllTimeSlots() throws Exception {
		Invocation.Builder bldr = client.target(BASE_URI + "/TimeSlot/findAllTimeSlot").request(APPLICATION_JSON);
		return bldr.get(new GenericType<List<TimeSlot>>() {
		});

	}

	public Request getInfoRequest(String idMission) throws Exception {
		Invocation.Builder bldr = client.target(BASE_URI + "/User/getInfoRequest/" + idMission)
				.request(APPLICATION_JSON);
		return bldr.get(Request.class);
	}

	public Mission addMission(Object requestEntity) throws Exception {
		Invocation.Builder bldr = client.target(BASE_URI + "/User/addMission").request(APPLICATION_JSON);
		return bldr.post(entity(requestEntity, APPLICATION_JSON), Mission.class);
	}

	public ValueMission addValueMission(Object requestEntity) throws Exception {
		Invocation.Builder bldr = client.target(BASE_URI + "/User/addValueMission").request(APPLICATION_JSON);
		return bldr.post(entity(requestEntity, APPLICATION_JSON), ValueMission.class);
	}

	public List<Vehicle> getAllVehicles() throws Exception {
		Invocation.Builder bldr = client.target(BASE_URI + "/User/findVehicles").request(APPLICATION_JSON);
		return bldr.get(new GenericType<List<Vehicle>>() {
		});
	}

	public List<TruckServiceClass> getAllTruckServiceClasses() throws Exception {
		Invocation.Builder bldr = client.target(BASE_URI + "/User/getTruckServiceClass").request(APPLICATION_JSON);
		return bldr.get(new GenericType<List<TruckServiceClass>>() {
		});
	}

	public void close() {
		client.close();
	}

	public TimeSlotInfo getInfoTimeSlot(String idTimeSlot) throws Exception {
		Invocation.Builder bldr = client.target(BASE_URI + "/TimeSlot/getInfoTimeSlot/" + idTimeSlot)
				.request(APPLICATION_JSON);
		return bldr.get(TimeSlotInfo.class);
	}

	public Mission buildCityLogisticsMission(Missione missione) throws Exception {
		Invocation.Builder bldr = client.target(BASE_URI + "/TimeSlot/buildCityLogisticsMission")
				.request(APPLICATION_JSON);
		return bldr.post(entity(missione, APPLICATION_JSON), Mission.class);
	}

}
