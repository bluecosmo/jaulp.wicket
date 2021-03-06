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
package org.jaulp.wicket.dialogs.examples;

import java.io.Serializable;

/**
 * The Class MessageBean.
 */
public class MessageBean implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The message content. */
	String messageContent;

	/**
	 * Gets the message content.
	 *
	 * @return the message content
	 */
	public String getMessageContent()
	{
		return messageContent;
	}

	/**
	 * Sets the message content.
	 *
	 * @param messageContent
	 *            the new message content
	 */
	public void setMessageContent(String messageContent)
	{
		this.messageContent = messageContent;
	}

	/**
	 * Instantiates a new message bean.
	 */
	public MessageBean()
	{
		super();
	}


}
