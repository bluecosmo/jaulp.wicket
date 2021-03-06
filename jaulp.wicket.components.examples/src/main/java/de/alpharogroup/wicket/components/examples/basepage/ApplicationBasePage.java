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
package de.alpharogroup.wicket.components.examples.basepage;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.jaulp.io.annotations.ImportResource;
import net.sourceforge.jaulp.io.annotations.ImportResources;
import net.sourceforge.jaulp.locale.ResourceBundleKey;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.settings.IJavaScriptLibrarySettings;
import org.apache.wicket.util.string.StringValue;
import org.apache.wicket.util.time.Duration;
import org.jaulp.wicket.base.GenericBasePage;
import org.jaulp.wicket.base.util.WicketComponentUtils;
import org.jaulp.wicket.base.util.parameter.PageParametersUtils;
import org.jaulp.wicket.base.util.resource.ResourceModelFactory;
import org.jaulp.wicket.behaviors.AddJsQueryStatementsBehavior;
import org.jaulp.wicket.behaviors.BuildableChainableStatement;
import org.jaulp.wicket.behaviors.FaviconBehavior;
import org.jaulp.wicket.behaviors.GoogleAnalyticsBehavior;
import org.odlabs.wiquery.core.javascript.JsUtils;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.common.NotificationPanel;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import de.alpharogroup.wicket.bootstrap3.application.WicketBootstrap3Application;
import de.alpharogroup.wicket.components.examples.application.WicketApplication;
import de.alpharogroup.wicket.components.examples.imprint.ImprintPage;
import de.alpharogroup.wicket.components.examples.termofuse.TermOfUsePage;
import de.alpharogroup.wicket.components.footer.FooterMenuPanel;
import de.alpharogroup.wicket.components.footer.FooterPanel;
import de.alpharogroup.wicket.components.i18n.list.LinkListPanel;
import de.alpharogroup.wicket.components.link.LinkModel;

/**
 * The Class ApplicationBasePage.
 *
 * @param <T>
 *            the generic type
 */
@ImportResources(resources = {
		@ImportResource(resourceName = "main.css", resourceType = "css", index = 1),
		@ImportResource(resourceName = "bootstrap_alert.js", resourceType = "js", index = 2) })
public abstract class ApplicationBasePage<T> extends GenericBasePage<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant COPYRIGHT_URL. */
	protected static final String COPYRIGHT_URL = "http://www.alpharogroup.de/";

	/** The Constant NAVBAR_PANEL_ID. */
	protected static final String NAVBAR_PANEL_ID = "navbar";

	/** The Constant CONTAINER_PANEL_ID. */
	protected static final String CONTAINER_PANEL_ID = "container";

	/** The Constant FOOTER_PANEL_ID. */
	protected static final String FOOTER_PANEL_ID = "footer";

	/** The feedback. */
	protected FeedbackPanel feedback;

	/**
	 * Gets the feedback.
	 * 
	 * @return the feedback
	 */
	public FeedbackPanel getFeedback()
	{
		return feedback;
	}

	/**
	 * Instantiates a new application base page.
	 */
	public ApplicationBasePage()
	{
		this(new PageParameters());
	}

	/**
	 * Instantiates a new application base page.
	 *
	 * @param parameters
	 *            the parameters
	 */
	public ApplicationBasePage(PageParameters parameters)
	{
		super(parameters);
		initializeComponents();
	}

	/**
	 * Instantiates a new application base page.
	 *
	 * @param model
	 *            the model
	 */
	public ApplicationBasePage(IModel<T> model)
	{
		super(model);
		initializeComponents();
	}

	/**
	 * Initialize components.
	 */
	private void initializeComponents()
	{
		add(new FaviconBehavior());
		add(new GoogleAnalyticsBehavior(ApplicationBasePage.class));
		add(new BootstrapBaseBehavior());
		HeaderResponseContainer headerResponseContainer = new HeaderResponseContainer(
			WicketBootstrap3Application.FOOTER_FILTER_NAME,
			WicketBootstrap3Application.FOOTER_FILTER_NAME);
		add(headerResponseContainer);
	}

	/**
	 * New feedback panel.
	 *
	 * @param id
	 *            the id
	 * @return the feedback panel
	 */
	protected FeedbackPanel newFeedbackPanel(String id)
	{
		NotificationPanel notificationPanel = new NotificationPanel(id);
		notificationPanel.setOutputMarkupId(true);
		notificationPanel.setOutputMarkupPlaceholderTag(true);
		notificationPanel.hideAfter(Duration.seconds(5));
		return notificationPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onConfigure()
	{
		super.onConfigure();
		configureTheme(getPageParameters());
	}

	/**
	 * sets the theme for the current user.
	 *
	 * @param pageParameters
	 *            current page parameters
	 */
	private void configureTheme(PageParameters pageParameters)
	{
		newTheme(pageParameters.get("theme"));
	}

	/**
	 * New theme.
	 *
	 * @param theme
	 *            the theme
	 */
	protected void newTheme(StringValue theme)
	{
		changeTheme(PageParametersUtils.getString(theme));
	}

	/**
	 * Change theme.
	 *
	 * @param themeParameter
	 *            the theme parameter
	 */
	protected void changeTheme(String themeParameter)
	{
		if (themeParameter != null && !themeParameter.isEmpty())
		{
			IBootstrapSettings settings = Bootstrap.getSettings(getWicketApplication());
			settings.getActiveThemeProvider().setActiveTheme(themeParameter);
		}
	}

	/**
	 * Gets the Container panel.
	 * 
	 * @return 's the Container panel.
	 */
	public abstract Component getContainerPanel();

	/**
	 * Factory method that can be overwritten for new meta tag content for keywords.
	 * 
	 * @return the new <code>IModel</code>
	 */
	@Override
	protected IModel<String> newKeywords()
	{
		return ResourceModelFactory.newResourceModel("page.meta.keywords", this,
			"wicket, components, examples");
	}

	/**
	 * Factory method that can be overwritten for new meta tag content for the title.
	 * 
	 * @return the new <code>IModel</code>
	 */
	@Override
	protected IModel<String> newTitle()
	{
		return ResourceModelFactory.newResourceModel("page.title", this, "jaulp.wicket.components");
	}

	/**
	 * Gets the Footer panel.
	 *
	 * @param id
	 *            the id
	 * @return 's the Footer panel.
	 */
	protected Panel newFooterPanel(String id)
	{
		return new FooterPanel(id)
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected Component newFooterMenuPanel(String id)
			{
				List<LinkModel> linkModel = new ArrayList<LinkModel>();
				linkModel
					.add(LinkModel
						.builder()
						.url("http://www.alpharogroup.de/")
						.resourceModelKey(
							ResourceBundleKey.builder().key("main.footer.copyright.label")
								.defaultValue("\u0040 copyright 2012 Design by Alpha Ro Group")
								.build()).build());
				linkModel.add(LinkModel
					.builder()
					.pageClass(ImprintPage.class)
					.resourceModelKey(
						ResourceBundleKey.builder().key("main.global.menu.masthead.label")
							.defaultValue("Imprint").build()).build());
				linkModel.add(LinkModel
					.builder()
					.pageClass(TermOfUsePage.class)
					.resourceModelKey(
						ResourceBundleKey.builder().key("main.global.menu.term.of.use.label")
							.defaultValue("AGBs").build()).build());
				FooterMenuPanel footerMenu = new FooterMenuPanel(id, linkModel)
				{
					private static final long serialVersionUID = 1L;

					@Override
					protected Component newLinkListPanel(String id, IModel<List<LinkModel>> model)
					{
						LinkListPanel listPanel = new LinkListPanel(id, model)
						{
							private static final long serialVersionUID = 1L;

							@Override
							protected Component newListComponent(String id, ListItem<LinkModel> item)
							{
								LinkModel model = item.getModelObject();
								item.add(new AttributeAppender("class", "btn"));
								Label itemLinkLabel = new Label("itemLinkLabel",
									ResourceModelFactory.newResourceModel(
										model.getResourceModelKey(), this));
								itemLinkLabel.add(new AttributeAppender("class", "a"));
								if (model.getUrl() != null)
								{
									return new ExternalLink(id, Model.of(model.getUrl()))
										.add(itemLinkLabel);
								}
								// add css class to current page.
								if (model.getPageClass().equals(getPage().getClass()))
								{
									itemLinkLabel.add(new AttributeAppender("class", " "
										+ getCurrentPageCssClass()));
								}
								return new BookmarkablePageLink<String>(id, model.getPageClass())
									.add(itemLinkLabel);
							}

							@Override
							protected String getCurrentPageCssClass()
							{
								return "active";
							}
						};
						return listPanel;
					}
				};
				// Add bootstrap class to ul element...
				add(new AddJsQueryStatementsBehavior().add(
					new BuildableChainableStatement.Builder().label("find")
						.args(JsUtils.quotes("ul")).build()).add(
					new BuildableChainableStatement.Builder().label("addClass")
						.args(JsUtils.quotes("nav text-center")).build()));
				return footerMenu;
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		IJavaScriptLibrarySettings javaScriptSettings = getApplication()
			.getJavaScriptLibrarySettings();
		response.render(JavaScriptHeaderItem.forReference(javaScriptSettings.getJQueryReference()));
		Bootstrap.renderHead(response);
		WicketComponentUtils.renderHeaderResponse(response, ApplicationBasePage.class);
	}

	/**
	 * Gets the wicket application.
	 *
	 * @return the wicket application
	 */
	public WicketApplication getWicketApplication()
	{
		return WicketApplication.get();
	}

}