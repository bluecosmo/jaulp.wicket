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
package de.alpharogroup.wicket.components.examples.popupoverlay;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.jaulp.wicket.behaviors.popupoverlay.PopupoverlayPanel;
import org.wicketstuff.annotation.mount.MountPath;

import de.alpharogroup.wicket.components.examples.area.publicly.PubliclyBasePage;
import de.alpharogroup.wicket.components.examples.fragment.swapping.person.PersonModel;
import de.alpharogroup.wicket.components.examples.fragment.swapping.person.PersonPanel;


@MountPath("public/popupoverlay")
public class PopupoverlayPage extends PubliclyBasePage<PersonModel>
{
	private static final long serialVersionUID = 1L;

	public PopupoverlayPage(final PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	public Component getContainerPanel()
	{
		PopupoverlayPanel<PersonModel> popupoverlayPanel = new PopupoverlayPanel<PersonModel>(CONTAINER_PANEL_ID, Model.of(new PersonModel()))
		{
			/**
			 * The serialVersionUID.
			 */
			private static final long serialVersionUID = 1L;
			@Override
			protected MarkupContainer newOverlayReference(String id, IModel<PersonModel> model)
			{
				PersonPanel panel = new PersonPanel(id, model);
				panel.add(new AttributeAppender("style", " height: 800px; width: 600px;"));
				panel.add(new AttributeAppender("class", " overlay-panel"));
				panel.setOutputMarkupId(true);
				return panel;
			}
		};

		return popupoverlayPanel;
	}
}
