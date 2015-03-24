package com.sam.user.web.app;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.sam.user.web.app.service.UserInt;

public class HomePage extends WebPage {

	@SpringBean
	UserInt userInt;

	private static final CompressedResourceReference MYPAGE_SLIDER = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/css/slider.js");
	private static final CompressedResourceReference MYPAGE_JS = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/cufon-replace.js");
	private static final CompressedResourceReference MYPAGE_JS2 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/cufon-yui.js");
	private static final CompressedResourceReference MYPAGE_JS3 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/FF-cash.js");
	private static final CompressedResourceReference MYPAGE_JS4 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/html5.js");
	private static final CompressedResourceReference MYPAGE_JS5 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/jquery-1.6.min.js");
	private static final CompressedResourceReference MYPAGE_JS6 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/jquery.easing.1.3.js");
	private static final CompressedResourceReference MYPAGE_JS7 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/Open_Sans_400.font.js");
	private static final CompressedResourceReference MYPAGE_JS8 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/Open_Sans_Light_300.font.js");
	private static final CompressedResourceReference MYPAGE_JS9 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/Open_Sans_Semibold_600.font.js");
	private static final CompressedResourceReference MYPAGE_JS10 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/tms_presets.js");
	private static final CompressedResourceReference MYPAGE_JS11 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/scripts/tms-0.3.js");
	private static final CompressedResourceReference MYPAGE_CSS = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/css/ie.css");
	private static final CompressedResourceReference MYPAGE_CSS2 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/css/layout.css");
	private static final CompressedResourceReference MYPAGE_CSS3 = new CompressedResourceReference(HomePage.class, "/com/sam/user/web/app/css/style.css");

	public HomePage(final PageParameters parameters) {

		add(CSSPackageResource.getHeaderContribution(MYPAGE_CSS));
		add(CSSPackageResource.getHeaderContribution(MYPAGE_CSS2));
		add(CSSPackageResource.getHeaderContribution(MYPAGE_CSS3));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_SLIDER));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS2));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS3));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS4));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS5));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS6));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS7));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS8));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS9));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS10));
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS11));

	}

	private HomePage() {
		add(new Label("home", "Welcome!!"));
	}
}
