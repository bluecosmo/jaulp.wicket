/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jaulp.wicket.dropdownchoices.three.choices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.jaulp.wicket.components.i18n.dropdownchoice.renderers.PropertiesChoiceRenderer;
import org.jaulp.wicket.components.i18n.dropdownchoice.renderers.SelectedValuesChoiceRenderer;
import org.jaulp.wicket.model.dropdownchoices.StringThreeDropDownChoicesModel;

import de.alpharogroup.wicket.components.i18n.dropdownchoice.LocalisedDropDownChoice;

/**
 * The Class TwoDropDownChoicesPanel.
 *
 * @author Asterios Raptis
 */
public class ThreeDropDownChoicesPanel extends Panel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new two drop down choices panel.
	 *
	 * @param id
	 *            the id
	 */
	public ThreeDropDownChoicesPanel(final String id)
	{
		super(id);

		/** The models map. */
		Map<String, List<String>> modelsMap = new HashMap<String, List<String>>();

		modelsMap.put("trademark.audi",
			Arrays.asList(new String[] { "audi.a4", "audi.a6", "audi.tt" }));
		modelsMap.put(
			"trademark.cadillac",
			Arrays.asList(new String[] { "cadillac.cts", "cadillac.dts", "cadillac.escalade",
					"cadillac.srx", "cadillac.deville" }));
		modelsMap.put(
			"trademark.ford",
			Arrays.asList(new String[] { "ford.crown", "ford.escape", "ford.expedition",
					"ford.explorer", "ford.f_150" }));

		final StringThreeDropDownChoicesModel stringThreeDropDownChoicesModel = new StringThreeDropDownChoicesModel(
			"trademark.audi", modelsMap, new ArrayList<String>());

		final CompoundPropertyModel<StringThreeDropDownChoicesModel> boundOptionModel = new CompoundPropertyModel<StringThreeDropDownChoicesModel>(
			stringThreeDropDownChoicesModel);

		final Form<StringThreeDropDownChoicesModel> selectOptionForm = new Form<StringThreeDropDownChoicesModel>(
			"selectOptionForm", boundOptionModel);

		add(selectOptionForm);

		final LocalisedDropDownChoice<String> trademarks = new LocalisedDropDownChoice<String>(
			"trademarks", new PropertyModel<String>(stringThreeDropDownChoicesModel,
				"selectedRootOption"), stringThreeDropDownChoicesModel.getRootChoices(),
			new PropertiesChoiceRenderer(this, this.getClass()));
		trademarks.setDefaultChoice(true);
		trademarks.setOutputMarkupId(true);

		final LocalisedDropDownChoice<String> models = new LocalisedDropDownChoice<String>(
			"models", new PropertyModel<String>(stringThreeDropDownChoicesModel,
				"selectedChildOption"), stringThreeDropDownChoicesModel.getChildChoices(),
			new PropertiesChoiceRenderer(this, this.getClass()));
		models.setDefaultChoice(true);
		models.setOutputMarkupId(true);

		final LocalisedDropDownChoice<String> selectedModels = new LocalisedDropDownChoice<String>(
			"selectedModels", new PropertyModel<String>(stringThreeDropDownChoicesModel,
				"selectedValueOption"), stringThreeDropDownChoicesModel.getSelectedValuesChoices(),
			new SelectedValuesChoiceRenderer(this, this.getClass()));
		selectedModels.setDefaultChoice(true);
		selectedModels.setOutputMarkupId(true);

		selectOptionForm.add(trademarks);
		selectOptionForm.add(models);

		selectOptionForm.add(selectedModels);

		trademarks.add(new AjaxFormComponentUpdatingBehavior("onchange")
		{

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(final AjaxRequestTarget target)
			{
				target.add(models);
			}
		});

		// Create submit button for the form
		final Button entryButton = new Button("entryButton")
		{
			/**
			 * The serialVersionUID.
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit()
			{
				String selectedRootOption = stringThreeDropDownChoicesModel.getSelectedRootOption();
				String selectedChildOption = stringThreeDropDownChoicesModel
					.getSelectedChildOption();
				System.out.println("RootOption:" + selectedRootOption);
				System.out.println("ChildOption:" + selectedChildOption);
				if (selectedRootOption != null && selectedChildOption != null)
				{
					stringThreeDropDownChoicesModel
						.addSelectedValue(stringThreeDropDownChoicesModel.getSelectedRootOption()
							+ "=>" + stringThreeDropDownChoicesModel.getSelectedChildOption());
				}
				else
				{
					getPage().error("Select trademark and model.");
				}

			}
		};

		selectOptionForm.add(entryButton);
	}
}
