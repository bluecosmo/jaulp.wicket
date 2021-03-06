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
package org.jaulp.wicket.model.dropdownchoices;

import org.apache.wicket.util.io.IClusterable;

/**
 * The Class SelectOptionModel.
 */
public class SelectOptionModel implements IClusterable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7091799192618838124L;

	/** The key. */
	private String key;

	/** The value. */
	private String value;

	/**
	 * Instantiates a new select option.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public SelectOptionModel(final String key, final String value)
	{
		this.key = key;
		this.value = value;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 *            the new key
	 */
	public void setKey(final String key)
	{
		this.key = key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(final String value)
	{
		this.value = value;
	}

}
