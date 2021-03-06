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
package de.alpharogroup.wicket.components.termofuse.disclaimer;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;

import de.alpharogroup.wicket.components.i18n.list.HeaderContentListModel;

public class DisclaimerPanel extends Panel
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public DisclaimerPanel(String id)
	{
		this(id, null);
	}


	public DisclaimerPanel(String id, IModel<HeaderContentListModel> model)
	{
		super(id, model);

		add(new Label("disclaimerLbl", newDisclaimerModel()));

		add(new Label("disclaimerContentLbl", newDisclaimerContentModel()));

		add(new Label("disclaimerLinkLabel", newDisclaimerLinkLabelModel()));
	}


	/**
	 * Factory method to create a IModel for the disclaimer content. This method is invoked in the
	 * constructor from this class and can be overridden so users can provide their own version of a
	 * disclaimer content.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newDisclaimerLinkLabelModel()
	{
		return newIModel("imprint.disclaimer.link.label");
	}

	/**
	 * Creates a new StringResourceModel from the given key.
	 * 
	 * @param key
	 *            the key
	 * @return the i model
	 */
	protected IModel<String> newIModel(String key)
	{
		return new StringResourceModel(key, this, null);
	}

	/**
	 * Factory method to create a IModel for the disclaimer content. This method is invoked in the
	 * constructor from this class and can be overridden so users can provide their own version of a
	 * disclaimer content.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newDisclaimerContentModel()
	{
		return newIModel("imprint.disclaimer.content");
	}

	/**
	 * Factory method to create a IModel for the disclaimer header. This method is invoked in the
	 * constructor from this class and can be overridden so users can provide their own version of a
	 * disclaimer header.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newDisclaimerModel()
	{
		return newIModel("imprint.disclaimer.label");
	}


}
