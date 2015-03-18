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
package de.alpharogroup.wicket.components.editable.textfield;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * An editable TextField that can be switched to a Label.
 */
public class EditableTextField extends Panel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The flag editable. */
	@Getter @Setter
	private boolean editable;

	/** The Label component. */
	@Getter
	private final Label label;

	/** The text field. */
	@Getter
	private final TextField<String> textField;

	/**
	 * Instantiates a new editable text field.
	 * 
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 */
	public EditableTextField(String id, IModel<String> model)
	{
		super(id, model);
		this.setOutputMarkupId(true).setOutputMarkupPlaceholderTag(true);
		editable = true;
		add(label = newLabel("label", model));
		add(textField = newTextField("textField", model));
	}

	/**
	 * Factory method for creating the TextField. This method is invoked in the constructor from the
	 * derived classes and can be overridden so users can provide their own version of a TextField.
	 * 
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the text field
	 */
	protected TextField<String> newTextField(String id, IModel<String> model)
	{
		TextField<String> textField = new TextField<String>(id, model)
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure()
			{
				setVisibilityAllowed(isEditable());
			}
		};
		textField.setOutputMarkupId(true).setOutputMarkupPlaceholderTag(true);
		return textField;
	}

	/**
	 * Factory method for creating the Label. This method is invoked in the constructor
	 * from the derived classes and can be overridden so users can provide their own version of a
	 * Label.
	 * 
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the Label
	 */
	protected Label newLabel(String id, IModel<String> model)
	{
		Label label = new Label(id, model)
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure()
			{
				setVisibilityAllowed(!isEditable());
			}
		};
		label.setOutputMarkupId(true).setOutputMarkupPlaceholderTag(true);
		return label;
	}

}
