/**
 * Copyright (C) 2007 Asterios Raptis
 *
 * This program is open source software; you can redistribute it and/or modify
 * it under the terms of the Apache License V2.0 as published by
 * the Apache Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY.
 */
package org.jaulp.wicket.base;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * The Class BasePage.
 * 
 * @author Asterios Raptis
 */
public abstract class BasePage extends AbstractBasePage {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The title. */
	private final IModel<String> title;

	/**
	 * Instantiates a new base page.
	 */
	public BasePage() {
		this(new PageParameters());
	}

	/**
	 * Instantiates a new base page.
	 * 
	 * @param parameters
	 *            the parameters
	 */
	public BasePage(final PageParameters parameters) {
		super(parameters);
		add(new Label("title", title = newTitle()));
	}
	
	/**
	 * Factory method that can be overwritten for new page title.
	 *
	 * @return the i model
	 */
	protected IModel<String> newTitle(){
		return new StringResourceModel("page.title", this, null, "Home page");
		
	}

	/**
	 * Gets the page title.
	 *
	 * @return the page title
	 */
	public IModel<String> getTitle() {
		return title;
	}

}