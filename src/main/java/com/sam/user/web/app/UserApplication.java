package com.sam.user.web.app;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebRequestCycleProcessor;
import org.apache.wicket.protocol.http.request.CryptedUrlWebRequestCodingStrategy;
import org.apache.wicket.protocol.http.request.WebRequestCodingStrategy;
import org.apache.wicket.request.IRequestCodingStrategy;
import org.apache.wicket.request.IRequestCycleProcessor;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class UserApplication extends WebApplication {
	public UserApplication() {
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class getHomePage() {
		return LoginPage.class;
	}

	@Override
	protected void init() {
		super.init();
		addComponentInstantiationListener(new SpringComponentInjector(this));
	}

//	@Override
//	protected IRequestCycleProcessor newRequestCycleProcessor() {
//
//		return new WebRequestCycleProcessor() {
//			protected IRequestCodingStrategy newRequestCodingStrategy() {
//				return new CryptedUrlWebRequestCodingStrategy(new WebRequestCodingStrategy());
//			}
//		};
//	}
}
