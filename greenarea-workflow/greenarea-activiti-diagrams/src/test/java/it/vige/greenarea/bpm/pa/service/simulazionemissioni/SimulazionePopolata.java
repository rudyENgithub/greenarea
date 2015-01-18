package it.vige.greenarea.bpm.pa.service.simulazionemissioni;

import static it.vige.greenarea.dto.Color.VERDE;
import it.vige.greenarea.bpm.pa.simulazionemissioni.EmptySimulazione;
import it.vige.greenarea.dto.FasciaOraria;
import it.vige.greenarea.dto.Missione;
import it.vige.greenarea.dto.Veicolo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;

public class SimulazionePopolata extends EmptySimulazione {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		super.execute(execution);
		@SuppressWarnings("unchecked")
		List<Missione> simulazioni = (List<Missione>) execution
				.getVariable("simulazioni");
		Missione request = new Missione();
		request.setVeicolo(new Veicolo("", ""));
		request.setRanking(VERDE);
		request.setCompagnia("tnt");
		request.setDataInizio(new Timestamp(new Date().getTime()));
		request.setNome("334");
		request.setFasciaOraria(new FasciaOraria(33, null));
		request.setCreditoMobilita(23.55);

		Missione request2 = new Missione();
		request2.setVeicolo(new Veicolo("", ""));
		request2.setRanking(VERDE);
		request2.setCompagnia("tnt");
		request2.setDataInizio(new Timestamp(new Date().getTime()));
		request2.setNome("334");
		request2.setFasciaOraria(new FasciaOraria(33, null));
		request2.setCreditoMobilita(23.55);

		simulazioni.add(request);
		simulazioni.add(request2);
	}
}
