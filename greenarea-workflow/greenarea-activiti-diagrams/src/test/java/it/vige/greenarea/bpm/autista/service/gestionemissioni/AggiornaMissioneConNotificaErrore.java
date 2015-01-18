package it.vige.greenarea.bpm.autista.service.gestionemissioni;

import static it.vige.greenarea.bpm.risultato.Categoria.ERROREGRAVE;
import static it.vige.greenarea.bpm.risultato.Tipo.ERRORESISTEMA;
import static org.slf4j.LoggerFactory.getLogger;
import it.vige.greenarea.bpm.autista.gestionemissioni.EmptyAggiornaMissione;
import it.vige.greenarea.bpm.risultato.Messaggio;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.slf4j.Logger;

public class AggiornaMissioneConNotificaErrore extends EmptyAggiornaMissione {

	private static final long serialVersionUID = 1031424583574482517L;

	private Logger logger = getLogger(getClass());

	@Override
	public void notify(DelegateTask delegateTask) {
		super.notify(delegateTask);
		DelegateExecution execution = delegateTask.getExecution();
		String eseguito = (String) execution
				.getVariable("test_aggiorna_missione_con_notifica_errore_eseguito");
		if (eseguito == null) {
			logger.info("Aggiorna Missione con Notifica Errore");
			execution
					.setVariable(
							"test_aggiorna_missione_con_notifica_errore_eseguito",
							"OK");
			Messaggio messaggio = (Messaggio) execution
					.getVariable("messaggio");
			messaggio.setCategoria(ERROREGRAVE);
			messaggio.setTipo(ERRORESISTEMA);
		}
	}

}
