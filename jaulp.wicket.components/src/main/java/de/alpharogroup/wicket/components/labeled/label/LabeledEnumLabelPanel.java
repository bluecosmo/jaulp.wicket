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
package de.alpharogroup.wicket.components.labeled.label;

import lombok.Getter;

import org.apache.wicket.markup.html.basic.EnumLabel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import de.alpharogroup.wicket.components.factory.ComponentFactory;

/**
 * Convenience class for labeled EnumLabel.
 * 
 * @param <T>
 *            the generic type
 */
public class LabeledEnumLabelPanel<T> extends Panel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The right side label. */
	@SuppressWarnings("rawtypes")
	@Getter
	private final EnumLabel enumLabel;

	/** The left side Label component. */
	@Getter
	private final Label label;

	/**
	 * Instantiates a new LabeledEnumLabelPanel.
	 * 
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @param labelModel
	 *            the label model
	 */
	public LabeledEnumLabelPanel(String id, IModel<T> model, IModel<String> labelModel)
	{
		super(id, model);

		PropertyModel<T> viewableLabelModel = new PropertyModel<>(model.getObject(), id);
		add(enumLabel = newEnumLabel("viewableLabel", viewableLabelModel));

		String markupId = enumLabel.getMarkupId();
		add(label = newLabel("label", markupId, labelModel));
	}

	/**
	 * New enum label.
	 *
	 * @param id
	 *            the id
	 * @param viewableLabelModel
	 *            the viewable label model
	 * @return the enum label
	 */
	@SuppressWarnings({ "rawtypes" })
	protected EnumLabel newEnumLabel(final String id, PropertyModel<T> viewableLabelModel)
	{
		return ComponentFactory.newEnumLabel(id, viewableLabelModel);
	}

	/**
	 * Factory method for creating the Label. This method is invoked in the constructor from the
	 * derived classes and can be overridden so users can provide their own version of a Label.
	 * 
	 * @param id
	 *            the id
	 * @param forId
	 *            the for id
	 * @param model
	 *            the model
	 * @return the label
	 */
	protected Label newLabel(String id, String forId, IModel<String> model)
	{
		return ComponentFactory.newLabel(id, forId, model);
	}
}
