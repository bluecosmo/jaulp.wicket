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
package org.jaulp.wicket.data.provider.examples.pages.datatable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.jaulp.wicket.data.provider.examples.datatable.DefaultDataTablePanel;

public class DefaultDataTablePage extends WebPage
{

	private static final long serialVersionUID = 1L;

	public DefaultDataTablePage()
	{
		super();
		initLayout();
	}

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 *
	 * @param parameters
	 *            Page parameters
	 */
	public DefaultDataTablePage(final PageParameters parameters)
	{
		super(parameters);
		initLayout();
	}

	private void initLayout()
	{
		DefaultDataTablePanel defaultDataTablePanel = new DefaultDataTablePanel(
			"defaultDataTablePanel");
		add(defaultDataTablePanel);
	}
}
