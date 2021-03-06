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
package org.jaulp.wicket.base.mainbase;

import java.util.Set;

import net.sourceforge.jaulp.io.annotations.ImportResource;
import net.sourceforge.jaulp.io.annotations.ImportResources;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.jaulp.wicket.PackageResourceReferenceWrapper;
import org.jaulp.wicket.PackageResourceReferences;
import org.jaulp.wicket.base.BasePage;
import org.jaulp.wicket.base.enums.ResourceReferenceType;

/**
 * The Class BasePage.
 * 
 * @author Asterios Raptis
 */
@ImportResources(resources = {
		@ImportResource(resourceName = "BaseMainPage.js", resourceType = "js"),
		@ImportResource(resourceName = "BaseMainPage.css", resourceType = "css") })
public abstract class BaseMainPage extends BasePage
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Instantiates a new base page.
	 */
	public BaseMainPage()
	{
		super();
	}

	/**
	 * Instantiates a new base page.
	 * 
	 * @param parameters
	 *            the parameters
	 */
	public BaseMainPage(final PageParameters parameters)
	{
		super(parameters);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void renderHead(IHeaderResponse response)
	{
		Set<PackageResourceReferenceWrapper> headerContributors = PackageResourceReferences
			.getInstance().getPackageResourceReference(BaseMainPage.class);
		if (null != headerContributors && !headerContributors.isEmpty())
		{
			for (final PackageResourceReferenceWrapper packageResourceReference : headerContributors)
			{
				if (packageResourceReference.getType().equals(ResourceReferenceType.JS))
				{
					JavaScriptResourceReference reference = new JavaScriptResourceReference(
						BaseMainPage.class, packageResourceReference.getPackageResourceReference()
							.getName());
					if (!response.wasRendered(reference))
					{
						JavaScriptReferenceHeaderItem headerItem = JavaScriptHeaderItem
							.forReference(reference);
						response.render(headerItem);
					}
				}
				if (packageResourceReference.getType().equals(ResourceReferenceType.CSS))
				{
					CssResourceReference reference = new CssResourceReference(BaseMainPage.class,
						packageResourceReference.getPackageResourceReference().getName());
					if (!response.wasRendered(reference))
					{
						CssReferenceHeaderItem headerItem = CssHeaderItem.forReference(reference);
						response.render(headerItem);
					}
				}
			}
		}
	}

}