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
package it.vige.greenarea.cl.restservices;

import static it.vige.greenarea.Conversioni.convertiTransportsToRichieste;
import static it.vige.greenarea.dto.TipoRichiesta.CONSEGNA;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;
import java.util.SortedSet;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import it.vige.greenarea.cl.control.MissionControl;
import it.vige.greenarea.cl.library.entities.ExchangeStop;
import it.vige.greenarea.cl.library.entities.Transport;
import it.vige.greenarea.cl.scheduling.Scheduler;
import it.vige.greenarea.dto.DettaglioMissione;
import it.vige.greenarea.dto.ImpattoAmbientale;
import it.vige.greenarea.dto.Indirizzo;
import it.vige.greenarea.dto.Missione;
import it.vige.greenarea.dto.PerformanceVeicoli;
import it.vige.greenarea.dto.Richiesta;
import it.vige.greenarea.dto.RichiestaMissioni;
import it.vige.greenarea.gtg.db.facades.ExchangeStopFacade;

/**
 * <p>
 * Class: UserRESTService
 * </p>
 * <p>
 * Description: Classe che gestisce l'utilizzo parte utente
 * </p>
 * 
 */
@Path("/Richieste")
@Stateless
public class RichiesteRESTService {

	@EJB
	private Scheduler sc;
	@EJB
	private MissionControl mc;
	@EJB
	private ExchangeStopFacade esf;

	/**
	 * <p>
	 * Method: getRichieste
	 * </p>
	 * <p>
	 * Description: Questo metodo restituisce i veicoli utilizzabili nelle
	 * missioni
	 * </p>
	 * 
	 * @return
	 */
	@POST
	@Path("/getRichieste")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public List<Richiesta> getRichieste(Richiesta richiesta) {
		List<Transport> trasporti = sc.getAllSchedule(richiesta);
		List<Richiesta> richieste = convertiTransportsToRichieste(trasporti);
		aggiungiIDStop(richieste, esf.findAll());
		return richieste;
	}

	private void aggiungiIDStop(List<Richiesta> richieste, List<ExchangeStop> exchangeStops) {
		for (Richiesta richiesta : richieste) {
			for (ExchangeStop exchangeStop : exchangeStops) {
				Indirizzo indirizzoRichiesta = null;
				if (richiesta.getTipo().equals(CONSEGNA))
					indirizzoRichiesta = richiesta.getToAddress();
				else
					indirizzoRichiesta = richiesta.getFromAddress();
				if (exchangeStop.getLocation().getLatitude() == indirizzoRichiesta.getLatitude()
						&& exchangeStop.getLocation().getLongitude() == indirizzoRichiesta.getLongitude())
					richiesta.setIdStop(exchangeStop.getId());
			}
		}

	}

	/**
	 * <p>
	 * Method: getDettaglioPAMissioni
	 * </p>
	 * <p>
	 * Description: Questo metodo restituisce i dettagli utilizzabili nelle
	 * missioni
	 * </p>
	 * 
	 * @return
	 */
	@POST
	@Path("/getDettaglioMissioni")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public SortedSet<DettaglioMissione> getDettaglioMissioni(RichiestaMissioni richiesta) {
		SortedSet<DettaglioMissione> missioni = mc.getDettaglioMissioni(richiesta);
		return missioni;
	}

	/**
	 * <p>
	 * Method: getImpattoAmbientale
	 * </p>
	 * <p>
	 * Description: Questo metodo restituisce gli impatti utilizzabili nelle
	 * missioni
	 * </p>
	 * 
	 * @return
	 */
	@POST
	@Path("/getImpattoAmbientale")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public List<ImpattoAmbientale> getImpattoAmbientale(RichiestaMissioni richiesta) {
		List<ImpattoAmbientale> missioni = mc.getImpattoAmbientale(richiesta);
		return missioni;
	}

	/**
	 * <p>
	 * Method: getImpattoAmbientale
	 * </p>
	 * <p>
	 * Description: Questo metodo restituisce gli impatti utilizzabili nelle
	 * missioni
	 * </p>
	 * 
	 * @return
	 */
	@POST
	@Path("/getPerformanceVeicoli")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public List<PerformanceVeicoli> getPerformanceVeicoli(RichiestaMissioni richiesta) {
		List<PerformanceVeicoli> missioni = mc.getPerformanceVeicoli(richiesta);
		return missioni;
	}

	/**
	 * <p>
	 * Method: getSintesiMissioni
	 * </p>
	 * <p>
	 * Description: Questo metodo restituisce i veicoli utilizzabili nelle
	 * missioni
	 * </p>
	 * 
	 * @return
	 */
	@POST
	@Path("/getSintesiMissioni")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public List<Missione> getSintesiMissioni(RichiestaMissioni richiesta) {
		List<Missione> missioni = mc.getMissioni(richiesta);
		return missioni;
	}

	/**
	 * <p>
	 * Method: getDettaglioConsegne
	 * </p>
	 * <p>
	 * Description: Questo metodo restituisce i veicoli utilizzabili nelle
	 * missioni
	 * </p>
	 * 
	 * @return
	 */
	@POST
	@Path("/getDettaglioConsegne")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public List<Richiesta> getDettaglioConsegne(RichiestaMissioni richiesta) {
		List<Richiesta> richieste = mc.getConsegne(richiesta);
		return richieste;
	}
}
