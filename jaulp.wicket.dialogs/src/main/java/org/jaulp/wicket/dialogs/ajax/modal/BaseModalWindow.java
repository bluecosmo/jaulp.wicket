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
package org.jaulp.wicket.dialogs.ajax.modal;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 * The Class BaseModalWindow.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class BaseModalWindow<T> extends ModalWindow
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new base modal window.
	 * 
	 * @param id
	 *            the id
	 * @param title
	 *            the title
	 * @param initialWidth
	 *            the initial width
	 * @param initialHeight
	 *            the initial height
	 * @param model
	 *            the model
	 */
	public BaseModalWindow(final String id, final String title, final int initialWidth,
		final int initialHeight, final CompoundPropertyModel<T> model)
	{
		super(id);
		setInitialWidth(initialWidth);
		setInitialHeight(initialHeight);
		setTitle(title);

		setContent(new BaseModalPanel<T>(this.getContentId(), model)
		{
			/**
			 * The serialVersionUID.
			 */
			private static final long serialVersionUID = 1L;

			@Override
			void onCancel(final AjaxRequestTarget target)
			{
				BaseModalWindow.this.onCancel(target);
			}

			@Override
			void onSelect(final AjaxRequestTarget target, final T object)
			{
				BaseModalWindow.this.onSelect(target, object);
			}
		});
	}

	/**
	 * On cancel.
	 * 
	 * @param target
	 *            the target
	 */
	public abstract void onCancel(AjaxRequestTarget target);

	/**
	 * On select.
	 * 
	 * @param target
	 *            the target
	 * @param object
	 *            the object
	 */
	public abstract void onSelect(AjaxRequestTarget target, T object);

}
