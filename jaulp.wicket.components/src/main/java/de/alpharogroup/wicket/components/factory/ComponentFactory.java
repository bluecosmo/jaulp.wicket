package de.alpharogroup.wicket.components.factory;

import net.sourceforge.jaulp.locale.ResourceBundleKey;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.EnumLabel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.resource.IResource;
import org.jaulp.wicket.base.util.resource.ResourceModelFactory;

/**
 * A factory for create Component objects.
 */
public class ComponentFactory {

	/** 
	 * Factory method for create a new CheckBox.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the created CheckBox
	 */
	public static CheckBox newCheckBox(final String id, final IModel<Boolean> model) {
		CheckBox checkBox = new CheckBox(id, model);
		checkBox.setOutputMarkupId(true);
		return checkBox;
	}
	
	/**
	 * Factory method for create a new ComponentFeedbackPanel.
	 * 
	 * @param id
	 *            the id
	 * @param filter
	 *            the filter
	 * @return the component feedback panel
	 */
	public static ComponentFeedbackPanel newComponentFeedbackPanel(final String id, final Component filter) {
		ComponentFeedbackPanel feedbackPanel = new ComponentFeedbackPanel(id,
				filter);
		feedbackPanel.setOutputMarkupId(true);
		return feedbackPanel;
	}
	
	/**
	 * Factory method for create a new EnumLabel.
	 *
	 * @param id the id
	 * @param model the model of the label
	 * @return the enum label
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> EnumLabel newEnumLabel(final String id, final PropertyModel<T> model) {
		EnumLabel enumLabel = new EnumLabel(id, model) {
			private static final long serialVersionUID = 1L;
			protected String resourceKey(Enum value) {
				return value.name();
			}
		};
		enumLabel.setOutputMarkupId(true);
		return enumLabel;
	}
	
	/**
	 * Factory method for create a new FeedbackPanel.
	 * 
	 * @param id
	 *            the id
	 * @return the FeedbackPanel
	 */
	public static FeedbackPanel newFeedbackPanel(final String id) {
		FeedbackPanel feedbackPanel = new FeedbackPanel(id);
		feedbackPanel.setOutputMarkupId(true);
		return feedbackPanel;
	}

	/**
	 * Factory method for create a new Form.
	 *
	 * @param <T> the generic type
	 * @param id            the id
	 * @return the form
	 */
	public static<T> Form<T> newForm(final String id) {
		return newForm(id, null);
	}

	/**
	 * Factory method for create a new Form.
	 *
	 * @param <T> the generic type
	 * @param id            the id
	 * @param model            the model
	 * @return the form
	 */
	public static<T> Form<T> newForm(final String id, final IModel<T> model) {
		Form<T> form = new Form<>(id, model);
		form.setOutputMarkupId(true);
		return form;
	}

	/**
	 * Factory method for create a new hidden field.
	 *
	 * @param id the id
	 * @return the component
	 */
	public static Component newHiddenField(final String id) {
		HiddenField<String> hiddenField = new HiddenField<String>(id);
		hiddenField.setOutputMarkupId(true);
		return hiddenField;
	}

	/** 
	 * Factory method for create a new Image.
	 *
	 * @param id the id
	 * @param imageResource the IResource object
	 * @return the created Image
	 */
	public static Image newImage(final String id, final IResource imageResource) {
		Image image = new Image(id, imageResource);
		image.setOutputMarkupId(true);
		return image;		
	}
	


	/**
	 * Factory method for create a new Label with a {@link IModel<String>}.
	 *
	 * @param <T> the generic type
	 * @param id            the id
	 * @param model            the {@link IModel<String>} for the label.
	 * @return the label
	 */
	public static<T> Label newLabel(final String id, final IModel<T> model) {
		Label label = new Label(id, model);
		label.setOutputMarkupId(true);
		return label;
	}

	/**
	 * Factory method for create a new Label with a {@link PropertyModel}.
	 *
	 * @param <T> the generic type
	 * @param id            the id
	 * @param model            the model
	 * @return the label
	 */
	public static <T> Label newLabel(final String id, final PropertyModel<T> model) {
		Label label = new Label(id, model);
		label.setOutputMarkupId(true);
		return label;
	}
	
	/**
	 * Factory method for create a new {@link Label} with a {@link ResourceBundleKey}.
	 * 
	 * @param id
	 *            the id
	 * @param resourceKey
	 *            the resource key
	 * @param component
	 *            the component to find resource keys
	 * @return the new {@link Label}
	 */
	public static Label newLabel(final String id, final ResourceBundleKey resourceKey, final Component component) {
		return ComponentFactory.newLabel(id, ResourceModelFactory.newResourceModel(resourceKey, component));
	}
	
	/**
	 * Factory method for create a new Label with the for attribute.
	 * 
	 * @param id
	 *            the id
	 * @param forId
	 *            the for id
	 * @param model
	 *            the model
	 * @return the label
	 */
	public static Label newLabel(final String id, final String forId, final IModel<String> model) {
		Label label = new Label(id, model);
		label.add(new AttributeAppender("for", Model.of(forId), " "));
		label.setOutputMarkupId(true);
		return label;
	}

	
	/**
	 * Factory method for create a new Label with the for attribute.
	 * 
	 * @param id
	 *            the id
	 * @param forId
	 *            the for id
	 * @param model
	 *            the model
	 * @return the label
	 */
	public static Label newLabel(final String id, final String forId, final ResourceBundleKey resourceBundleKey, final Component component) {	
		return ComponentFactory.newLabel(id, forId, ResourceModelFactory.newResourceModel(resourceBundleKey, component));
	}

	/**
	 * Factory method for create a new Label.
	 *
	 * @param id the id
	 * @param resourceKey the resource key
	 * @param defaultValue the default value
	 * @param component the component
	 * @return the label
	 */
	public static Label newLabel(final String id, final String resourceKey,
			final String defaultValue, final Component component) {
		return ComponentFactory.newLabel(id, ResourceModelFactory
				.newResourceModel(resourceKey, component, defaultValue));
	}

	/**
	 * Factory method for create a new MultiLineLabel with a {@link IModel<String>}.
	 *
	 * @param <T> the generic type
	 * @param id            the id
	 * @param model            the {@link IModel<String>} for the label.
	 * @return the label
	 */
	public static<T> MultiLineLabel newMultiLineLabel(final String id, final IModel<T> model) {
		MultiLineLabel multiLineLabel = new MultiLineLabel(id, model);
		multiLineLabel.setOutputMarkupId(true);
		return multiLineLabel;
	}

	/**
	 * Factory method for create a new TextArea.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the text area
	 */
	public static<T> TextArea<T> newTextArea(final String id, final PropertyModel<T> model) {
		TextArea<T> textArea = new TextArea<T>(id, model);
		textArea.setOutputMarkupId(true);
		return textArea;
	}

	/**
	 * Factory method for create a new {@link TextField}.
	 * 
	 * @param id
	 *            the id
	 * @return the new {@link TextField}
	 */
	public static Component newTextField(final String id) {
		TextField<String> textField = new TextField<>(id);
		textField.setOutputMarkupId(true);
		return textField;
	}

	/**
	 * Factory method for create a new {@link TextField}.
	 * 
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the new {@link TextField}
	 */
	public static<T> Component newTextField(final String id, final IModel<T> model) {
		TextField<T> textField = new TextField<>(id, model);
		textField.setOutputMarkupId(true);
		return textField;
	}
	
	/**
	 * Factory method for create a new {@link RadioGroup}.
	 *
	 * @param id the id
	 * @return the new {@link RadioGroup}
	 */
	public static<T> RadioGroup<T> newRadioGroup(final String id) {
		return newRadioGroup(id, null);
	}
	
	/**
	 * Factory method for create a new {@link RadioGroup}.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the new {@link RadioGroup}
	 */
	public static<T> RadioGroup<T> newRadioGroup(final String id, final IModel<T> model) {
		RadioGroup<T> radioGroup = new RadioGroup<T>(id, model);
		radioGroup.setOutputMarkupId(true);
		return radioGroup;
	}
	
}
