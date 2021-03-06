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
package de.alpharogroup.wicket.components.buttons;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * The Class ButtonPanel.
 */
public abstract class ButtonPanel extends Panel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The button component. */
	private final Button button;

	/** The Label component. */
	private final Component label;

	/** The form. */
	private final Form<?> form;

	/**
	 * Instantiates a new button panel.
	 *
	 * @param id
	 *            the id
	 * @param labelModel
	 *            the label model
	 */
	public ButtonPanel(String id, IModel<String> labelModel)
	{
		this(id, labelModel, null);
	}

	/**
	 * Instantiates a new button panel.
	 *
	 * @param id
	 *            the id
	 * @param labelModel
	 *            the label model
	 * @param form
	 *            the form
	 */
	public ButtonPanel(String id, IModel<String> labelModel, final Form<?> form)
	{
		super(id);
		this.form = form;
		this.setOutputMarkupId(true);
		add(button = newButton("button"));
		button.add(label = newLabel("label", labelModel));
	}

	/**
	 * Factory method for creating the Button. This method is invoked in the constructor from the
	 * derived classes and can be overridden so users can provide their own version of a Button.
	 * 
	 * @param id
	 *            the wicket id
	 * @return the Button
	 */
	protected abstract Button newButton(String id);

	/**
	 * Factory method for creating the Label. This method is invoked in the constructor from the
	 * derived classes and can be overridden so users can provide their own version of a Label.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the label
	 */
	protected Label newLabel(String id, IModel<String> model)
	{
		return new Label(id, model);
	}

	/**
	 * Gets the form.
	 *
	 * @return the form
	 */
	public Form<?> getForm()
	{
		return form;
	}

	/**
	 * Gets the button.
	 *
	 * @return the button
	 */
	public Button getButton()
	{
		return button;
	}

	/**
	 * Gets the label component.
	 * 
	 * @return the label component
	 */
	public Component getLabel()
	{
		return label;
	}

}
