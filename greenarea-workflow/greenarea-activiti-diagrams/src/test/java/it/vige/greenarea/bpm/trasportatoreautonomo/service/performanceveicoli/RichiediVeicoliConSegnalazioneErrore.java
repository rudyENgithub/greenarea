package it.vige.greenarea.bpm.trasportatoreautonomo.service.performanceveicoli;

import static it.vige.greenarea.bpm.risultato.Categoria.ERROREGRAVE;
import static it.vige.greenarea.bpm.risultato.Tipo.ERRORESISTEMA;
import static org.slf4j.LoggerFactory.getLogger;
import it.vige.greenarea.bpm.risultato.Messaggio;
import it.vige.greenarea.bpm.societaditrasporto.aggiornastatoveicoli.EmptyAggiornaStato;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;

public class RichiediVeicoliConSegnalazioneErrore extends EmptyAggiornaStato {

	private Logger logger = getLogger(getClass());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		super.execute(execution);
		String eseguito = (String) execution
				.getVariable("test_richiedi_veicoli_con_segnalazione_errore_eseguito");
		if (eseguito == null) {
			logger.info("Richiedi Veicoli con Segnalazione Errore");
			execution.setVariable(
					"test_richiedi_veicoli_con_segnalazione_errore_eseguito",
					"OK");
			Messaggio messaggio = (Messaggio) execution
					.getVariable("messaggio");
			messaggio.setCategoria(ERROREGRAVE);
			messaggio.setTipo(ERRORESISTEMA);
			throw new BpmnError("erroreRichiediVeicoli");
		}
	}

}
