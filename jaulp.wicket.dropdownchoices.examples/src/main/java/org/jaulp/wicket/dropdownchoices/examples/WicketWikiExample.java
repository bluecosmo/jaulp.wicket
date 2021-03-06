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
package org.jaulp.wicket.dropdownchoices.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.jaulp.wicket.components.i18n.dropdownchoice.panels.TwoDropDownChoicesPanel;
import org.jaulp.wicket.components.i18n.dropdownchoice.renderers.PropertiesChoiceRenderer;
import org.jaulp.wicket.dropdownchoices.panel.TrademarksModelsPanel;
import org.jaulp.wicket.dropdownchoices.panel.WicketWikiExamplePanel;
import org.jaulp.wicket.dropdownchoices.panel.base.BaseDropDownChoicePanel;
import org.jaulp.wicket.dropdownchoices.panel.localised.LocalisedDropDownChoicePanel;
import org.jaulp.wicket.dropdownchoices.panel.simple.SimpleDropDownChoicePanel;
import org.jaulp.wicket.dropdownchoices.three.choices.ThreeDropDownChoicesPanel;
import org.jaulp.wicket.model.dropdownchoices.StringTwoDropDownChoicesModel;

/**
 * @author Asterios Raptis
 */
public class WicketWikiExample extends WebPage
{

	private static final long serialVersionUID = 1L;
	private final FeedbackPanel feedback;

	public WicketWikiExample(final PageParameters params)
	{
		super(params);

		// Construct form and feedback panel and hook them up
		feedback = new FeedbackPanel("feedback");
		add(feedback);

		SimpleDropDownChoicePanel simpleDropDownChoicePanel = new SimpleDropDownChoicePanel(
			"simpleDropDownChoicePanel");

		add(simpleDropDownChoicePanel);

		BaseDropDownChoicePanel baseDropDownChoicePanel = new BaseDropDownChoicePanel(
			"baseDropDownChoicePanel");

		add(baseDropDownChoicePanel);

		WicketWikiExamplePanel wicketWikiExamplePanel = new WicketWikiExamplePanel(
			"wicketWikiExamplePanel");

		add(wicketWikiExamplePanel);

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

		final StringTwoDropDownChoicesModel stringTwoDropDownChoicesModel = new StringTwoDropDownChoicesModel(
			"trademark.audi", modelsMap);

		TwoDropDownChoicesPanel twoDropDownChoicesPanel = new TrademarksModelsPanel(
			"twoDropDownChoicesPanel", stringTwoDropDownChoicesModel, new PropertiesChoiceRenderer(
				this, this.getClass()), new PropertiesChoiceRenderer(this, this.getClass()));
		add(twoDropDownChoicesPanel);

		LocalisedDropDownChoicePanel localisedDropDownChoicePanel = new LocalisedDropDownChoicePanel(
			"localisedDropDownChoicePanel");
		add(localisedDropDownChoicePanel);

		ThreeDropDownChoicesPanel threeDropDownChoicesPanel = new ThreeDropDownChoicesPanel(
			"threeDropDownChoicesPanel");
		add(threeDropDownChoicesPanel);
	}

	public FeedbackPanel getFeedback()
	{
		return feedback;
	}

}
