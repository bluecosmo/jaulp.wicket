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
package de.alpharogroup.wicket.components.deregistration;

import org.apache.wicket.util.io.IClusterable;

/**
 * The Class DeregistrationModel.
 * 
 * @author Asterios Raptis
 */
public class DeregistrationModel implements IClusterable
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The motivation. */
	private String motivation;

	/**
	 * Gets the motivation.
	 * 
	 * @return the motivation
	 */
	public String getMotivation()
	{
		return motivation;
	}

	/**
	 * Sets the motivation.
	 * 
	 * @param motivation
	 *            the new motivation
	 */
	public void setMotivation(final String motivation)
	{
		this.motivation = motivation;
	}

}
