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
package de.alpharogroup.wicket.components.examples.labeled;

import java.util.Date;

import org.apache.wicket.extensions.yui.calendar.DateTimeField;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.jaulp.test.objects.Gender;
import org.jaulp.test.objects.Member;
import org.jaulp.wicket.base.BasePanel;

import de.alpharogroup.wicket.components.labeled.checkbox.LabeledCheckboxPanel;
import de.alpharogroup.wicket.components.labeled.label.LabeledEnumLabelPanel;
import de.alpharogroup.wicket.components.labeled.label.LabeledLabelPanel;
import de.alpharogroup.wicket.components.labeled.textarea.LabeledTextAreaPanel;
import de.alpharogroup.wicket.components.labeled.textfield.LabeledDateTextFieldPanel;
import de.alpharogroup.wicket.components.labeled.textfield.LabeledDateTimeFieldPanel;
import de.alpharogroup.wicket.components.labeled.textfield.LabeledTextFieldPanel;

public class LabeledComponentsPanel extends BasePanel<Object>
{
	private static final long serialVersionUID = 1L;
	private FeedbackPanel feedbackPanel;

	public LabeledComponentsPanel(String id)
	{
		super(id);
		final Member person = new Member();
		person.setGender(Gender.UNDEFINED);
		person.setName("foo");
		person.setAbout("");
		person.setMarried(false);
		person.setDateofbirth(new Date());
		person.setDateofMarriage(new Date());

		final CompoundPropertyModel<Member> cpm = new CompoundPropertyModel<Member>(person);

		final Form<Member> form = new Form<Member>("form", cpm);

		add(form);

		LabeledEnumLabelPanel<Member> genderLabel = new LabeledEnumLabelPanel<Member>("gender",
			cpm, Model.of("Gender:"));
		form.add(genderLabel);

		LabeledLabelPanel<Member> nameLabel = new LabeledLabelPanel<Member>("name", cpm,
			Model.of("Name:"));
		form.add(nameLabel);

		LabeledTextFieldPanel<Member> nameTextField = new LabeledTextFieldPanel<Member>("nickname",
			cpm, Model.of("Input your nickname:"));
		form.add(nameTextField);

		LabeledTextAreaPanel<Member> about = new LabeledTextAreaPanel<Member>("about", cpm,
			Model.of("About:"));
		form.add(about);

		LabeledCheckboxPanel<Member> married = new LabeledCheckboxPanel<Member>("married", cpm,
			Model.of("Married:"));

		form.add(married);

		LabeledDateTextFieldPanel<Member> dateofbirth = new LabeledDateTextFieldPanel<Member>(
			"dateofbirth", cpm, Model.of("Date of birth:"));
		form.add(dateofbirth);


		LabeledDateTimeFieldPanel<Member> dateofMarriage = new LabeledDateTimeFieldPanel<Member>(
			"dateofMarriage", cpm, Model.of("Date of marriage:"))
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected DateTimeField newDateTimeField(String id, IModel<Member> model)
			{
				PropertyModel<Date> textFieldModel = new PropertyModel<Date>(model.getObject(),
					getId());
				DateTimeField dateTextField = new DateTimeField(id, textFieldModel);
				return dateTextField;
			}

		};
		form.add(dateofMarriage);

		// Create submit button for the form
		final Button submitButton = new Button("submitButton")
		{
			/**
			 * The serialVersionUID.
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit()
			{
				info("Member:" + person.toString());
			}
		};

		form.add(submitButton);

		add(feedbackPanel = new FeedbackPanel("feedbackpanel"));
		feedbackPanel.setOutputMarkupId(true);
	}
}
