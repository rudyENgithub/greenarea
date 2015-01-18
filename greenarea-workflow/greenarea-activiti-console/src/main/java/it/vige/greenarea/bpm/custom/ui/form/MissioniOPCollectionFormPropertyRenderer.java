package it.vige.greenarea.bpm.custom.ui.form;

import static com.vaadin.terminal.Sizeable.UNITS_PIXELS;
import static it.vige.greenarea.bpm.custom.GreenareaMessages.MISSIONI_OP_TABLE_FIELDS;
import static it.vige.greenarea.bpm.custom.ui.mainlayout.GreenareaExplorerLayout.STYLE_COLLECTION;
import static it.vige.greenarea.dto.Operazione.CANCELLAZIONE;
import static it.vige.greenarea.dto.Operazione.DETTAGLIO;
import static it.vige.greenarea.dto.Operazione.MODIFICA;
import static it.vige.greenarea.dto.TipoRichiesta.CONSEGNA;
import static org.activiti.explorer.ExplorerApp.get;
import static org.activiti.explorer.Messages.FORM_FIELD_REQUIRED;
import static org.activiti.explorer.ui.mainlayout.ExplorerLayout.STYLE_DETAIL_BLOCK;
import static org.slf4j.LoggerFactory.getLogger;
import it.vige.greenarea.bpm.custom.ui.GreenareaMissioniTableCellStyleGenerator;
import it.vige.greenarea.bpm.form.MissioniOPCollectionFormType;
import it.vige.greenarea.dto.Missione;
import it.vige.greenarea.dto.Pacco;
import it.vige.greenarea.dto.Richiesta;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.form.FormProperty;
import org.activiti.explorer.I18nManager;
import org.slf4j.Logger;

import com.vaadin.ui.Field;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

public class MissioniOPCollectionFormPropertyRenderer extends
		GreenareaAbstractFormPropertyRenderer<Missione> {

	private static final long serialVersionUID = -5680213877307810907L;
	private GreenareaPagedTable<Missione> table;
	private Map<String, Missione> values;
	private Logger logger = getLogger(getClass());
	private DecimalFormat df = new DecimalFormat("#.##");

	public MissioniOPCollectionFormPropertyRenderer() {
		super(MissioniOPCollectionFormType.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Field getPropertyField(FormProperty formProperty) {

		values = (Map<String, Missione>) formProperty.getType().getInformation(
				"values");
		table = new GreenareaPagedTable<Missione>(values.values(),
				getGreenareaFormPropertiesForm());
		table.setCaption(getPropertyLabel(formProperty));
		table.setRequired(formProperty.isRequired());
		table.setRequiredError(getMessage(FORM_FIELD_REQUIRED,
				getPropertyLabel(formProperty)));
		table.setEnabled(formProperty.isReadable());
		table.setSelectable(false);
		table.setStyleName(STYLE_COLLECTION);
		table.setCellStyleGenerator(new GreenareaMissioniTableCellStyleGenerator());

		if (values != null && values.size() > 0) {
			I18nManager i18nManager = get().getI18nManager();
			String id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "nome");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "codicefiliale");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "statomissione");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "numeroconsegnepreviste");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "numerocollidaconsegnare");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "numeroritiriprevisti");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "numerocollidaritirare");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS + "carico");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "targaveicolo");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS + "euro");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "tipoalimentazione");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "caricopercentuale");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS + "ranking");
			table.addContainerProperty(id, String.class, null);
			id = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ "creditomobilita");
			table.addContainerProperty(id, String.class, null);
			if (formProperty.isWritable())
				table.addContainerProperty("", HorizontalLayout.class, null);

			for (Map.Entry<String, Missione> enumEntry : values.entrySet()) {

				id = enumEntry.getKey();
				Missione value = enumEntry.getValue();
				table.addItem(getValues(value, formProperty), id);

				if (enumEntry.getValue() != null) {
				}
			}
		}
		table.setPageLength(10);
		return new PaginatedCollectionField<Missione>(table);
	}

	@Override
	public String getFieldValue(FormProperty formProperty, Field field) {
		String id = "";
		if (table != null)
			id = (String) table.getValue();
		return id;
	}

	@Override
	protected boolean visible(Method method, java.lang.reflect.Field field) {
		return true;
	}

	private Object[] getValues(Missione type, FormProperty formProperty) {
		I18nManager i18nManager = get().getI18nManager();
		List<Object> result = new ArrayList<Object>();
		result.add(type.getNome());
		result.add(type.getCodiceFiliale());
		result.add(type.getStato());
		List<Richiesta> richieste = type.getRichieste();
		int numeroConsegne = 0;
		int numeroRitiri = 0;
		int numeroColliConsegne = 0;
		int numeroColliRitiri = 0;
		for (Richiesta richiesta : richieste) {
			if (richiesta.getTipo().equals(CONSEGNA.name())) {
				numeroConsegne++;
				numeroColliConsegne = numeroColliConsegne
						+ richiesta.getPacchi().length;
			} else {
				numeroRitiri++;
				numeroColliRitiri = numeroColliRitiri
						+ richiesta.getPacchi().length;
			}
		}
		result.add(numeroConsegne);
		result.add(numeroColliConsegne);
		result.add(numeroRitiri);
		result.add(numeroColliRitiri);
		double caricoTotale = 0.0;
		for (Richiesta richiesta : richieste) {
			if (richiesta.getTipo().equals(CONSEGNA.name())) {
				Pacco[] pacchi = richiesta.getPacchi();
				for (Pacco pacco : pacchi)
					caricoTotale += new Double(pacco.getAttributi().get(
							"Weight"));
			}
		}
		result.add(df.format(caricoTotale));
		result.add(type.getVeicolo().getTarga());
		result.add(i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
				+ "euro_value")
				+ " " + type.getVeicolo().getValori().getEuro());
		String tipoAlimentazione = type.getVeicolo().getValori().getFuel();
		try {
			tipoAlimentazione = i18nManager.getMessage(MISSIONI_OP_TABLE_FIELDS
					+ tipoAlimentazione);
		} catch (Exception ex) {
			logger.error("errore internazionalizzazione ", tipoAlimentazione);
		}
		result.add(tipoAlimentazione);
		double caricoTotaleVeicolo = type.getVeicolo().getValori().getWeight();
		result.add(df.format(caricoTotale / caricoTotaleVeicolo * 100) + "%");
		result.add(type.getRanking());
		result.add(df.format(type.getCreditoMobilita()));
		if (formProperty.isWritable())
			result.add(getButtons(type.toString(), table));
		return result.toArray();
	}

	@Override
	protected HorizontalLayout getButtons(final String item, final Table table) {
		FormProperty operations = getOperations();
		@SuppressWarnings("unchecked")
		Map<String, String> mapOperations = (Map<String, String>) operations
				.getType().getInformation("values");

		HorizontalLayout buttons = new HorizontalLayout();
		buttons.setSpacing(true);
		buttons.setWidth(20, UNITS_PIXELS);
		buttons.addStyleName(STYLE_DETAIL_BLOCK);
		for (String operation : mapOperations.keySet()) {
			if (operation.equals(MODIFICA.name())
					|| operation.equals(CANCELLAZIONE.name())
					|| operation.equals(DETTAGLIO.name())) {
				addButton(operation, buttons, item, table);
			}
		}

		Label buttonSpacer = new Label();
		buttons.addComponent(buttonSpacer);
		buttons.setExpandRatio(buttonSpacer, 1.0f);
		return buttons;
	}
}
