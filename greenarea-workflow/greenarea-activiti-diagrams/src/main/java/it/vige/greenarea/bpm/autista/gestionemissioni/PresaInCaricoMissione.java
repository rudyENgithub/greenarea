package it.vige.greenarea.bpm.autista.gestionemissioni;

import static org.slf4j.LoggerFactory.getLogger;

import org.activiti.engine.delegate.DelegateTask;
import org.slf4j.Logger;

public class PresaInCaricoMissione extends EmptyPresaInCaricoMissione {

	private static final long serialVersionUID = 1382234736647448083L;

	private Logger logger = getLogger(getClass());

	@Override
	public void notify(DelegateTask delegateTask) {
		super.notify(delegateTask);
		logger.info("CDI Presa in Carico Missione");
	}

}
