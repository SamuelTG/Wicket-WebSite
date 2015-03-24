package com.sam.user.web.app;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.sam.user.web.app.service.UserInt;

public class LandPage extends WebPage {
	private static final CompressedResourceReference MYPAGE_JS = new CompressedResourceReference(
			LandPage.class, "LandPageScript.js");
	private static final CompressedResourceReference MYPAGE_JS2 = new CompressedResourceReference(
			LandPage.class, "custom.js");
	private static final CompressedResourceReference MYPAGE_CSS = new CompressedResourceReference(
			LandPage.class, "component.css");
	private static final CompressedResourceReference MYPAGE_CSS2 = new CompressedResourceReference(
			LandPage.class, "default.css");

	@SpringBean
	UserInt userInt;

	public LandPage(final PageParameters parameters) {

		add(CSSPackageResource.getHeaderContribution(MYPAGE_CSS));
		add(CSSPackageResource.getHeaderContribution(MYPAGE_CSS2));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS2));

		add(new Label("user", parameters.getString("username")));

	}

}
