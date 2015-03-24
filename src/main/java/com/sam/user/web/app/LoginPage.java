package com.sam.user.web.app;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.PatternValidator;

import com.sam.user.web.app.service.UserInt;

public class LoginPage extends WebPage {
	private final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%]).{6,20})";

	@SpringBean
	UserInt userInt;

	public LoginPage(final PageParameters parameters) {

		add(CSSPackageResource.getHeaderContribution(LoginPage.class, "style.css"));

		add(new FeedbackPanel("feedback"));

		final TextField<String> username = new TextField<String>("username", Model.of(""));
		username.setRequired(true);
		//username.add(new UsernameValidator());

		final PasswordTextField password = new PasswordTextField("password", Model.of(""));
		password.setRequired(true);
		password.add(new PatternValidator(PASSWORD_PATTERN));

		add(new Label("msg", parameters.getString("message")));

		Form<?> form = new Form<Void>("userForm") {

			@Override
			protected void onSubmit() {

				final String usernameValue = username.getModelObject();
				final String passwordValue = password.getModelObject();

				PageParameters pageParameters = new PageParameters();
				pageParameters.add("username", usernameValue);
				pageParameters.add("password", passwordValue);
				pageParameters.add("login", "login");

				setResponsePage(SuccessPage.class, pageParameters);

			}

		};

		add(form);
		form.add(username);
		form.add(password);
	}

}
