package it.vige.greenarea.bpm.amministratore.service.gestiscifiltri;

import static it.vige.greenarea.bpm.risultato.Categoria.ERROREGRAVE;
import static it.vige.greenarea.bpm.risultato.Tipo.ERRORESISTEMA;
import static org.slf4j.LoggerFactory.getLogger;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;

import it.vige.greenarea.bpm.amministratore.gestiscifiltri.EmptyCancellaFiltro;
import it.vige.greenarea.bpm.risultato.Messaggio;

public class CancellaFiltroConNotificaErrore extends EmptyCancellaFiltro {

	private Logger logger = getLogger(getClass());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		super.execute(execution);
		logger.info("Cancella Filtro con Notifica Errore");
		Messaggio messaggio = (Messaggio) execution.getVariable("messaggio");
		messaggio.setCategoria(ERROREGRAVE);
		messaggio.setTipo(ERRORESISTEMA);
		throw new BpmnError("errorecancellazionefiltro");
	}

}
