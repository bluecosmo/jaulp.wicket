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
package de.alpharogroup.wicket.components.i18n.dropdownchoice;

import java.util.List;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import de.alpharogroup.wicket.components.labeled.LabeledFormComponentPanel;

public class EnumLocalizedDropdownChoicePanel<T extends Enum<T>, M>
	extends
		LabeledFormComponentPanel<M>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private final LocalisedDropDownChoice<T> dropdownChoice;

	public EnumLocalizedDropdownChoicePanel(String id, IModel<M> model, IModel<String> labelModel,
		List<T> enumValues)
	{
		super(id, model, labelModel);
		setDefaultModel(model);
		PropertyModel<T> pm = new PropertyModel<>(model.getObject(), id);
		ChoiceRenderer<T> choiceRenderer = new ChoiceRenderer<>("name", "name");

		add(dropdownChoice = newLocalisedDropDownChoice("dropdownChoice", pm, enumValues,
			choiceRenderer));

		add(feedback = newComponentFeedbackPanel("feedback", dropdownChoice));

		String markupId = dropdownChoice.getMarkupId();
		add(label = newLabel("label", markupId, getLabel()));

		// Add bootstrap css...
		getLabelComponent().add(new AttributeAppender("class", "control-label"));

	}

	protected LocalisedDropDownChoice<T> newLocalisedDropDownChoice(final String id,
		final IModel<T> model, final List<? extends T> data,
		final IChoiceRenderer<? super T> renderer)
	{
		LocalisedDropDownChoice<T> ddc = new LocalisedDropDownChoice<>(id, model, data, renderer);
		return ddc;
	}

	public LocalisedDropDownChoice<T> getDropdownChoice()
	{
		return dropdownChoice;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInput()
	{
		return dropdownChoice.getInput();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void convertInput()
	{
		setConvertedInput(getModel().getObject());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onBeforeRender()
	{
		dropdownChoice.setRequired(isRequired());
		super.onBeforeRender();
	}

}
