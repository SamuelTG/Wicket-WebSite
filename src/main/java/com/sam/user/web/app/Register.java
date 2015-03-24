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

import com.sam.user.web.app.data.User;
import com.sam.user.web.app.service.UserInt;

public class Register extends WebPage {
	private final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$!%]).{6,20})";
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	@SpringBean
	UserInt userInt;

	long id = -4;
	String message = "";

	public Register(final PageParameters parameters) {

		add(CSSPackageResource.getHeaderContribution(Register.class, "style.css"));

		add(new FeedbackPanel("feedback"));

		final TextField<String> username = new TextField<String>("username", Model.of(""));
		username.setRequired(true);
		//username.add(new UsernameValidator());

		final TextField<String> email = new TextField<String>("email", Model.of(""));
		email.setRequired(true);
		email.add(new PatternValidator(EMAIL_PATTERN));

		final PasswordTextField password = new PasswordTextField("password", Model.of(""));
		password.setRequired(true);
		password.add(new PatternValidator(PASSWORD_PATTERN));

		final PasswordTextField password2 = new PasswordTextField("password2", Model.of(""));
		password2.setRequired(true);
		password2.add(new PatternValidator(PASSWORD_PATTERN));

		add(new Label("msg", parameters.getKey("message")));

		final User user = new User();
		Form<?> form = new Form<Void>("userForm") {

			@Override
			protected void onSubmit() {

				final String usernameValue = username.getModelObject();
				final String emailValue = email.getModelObject();
				final String passwordValue = password.getModelObject();
				final String passwordValue2 = password2.getModelObject();

				PageParameters pageParameters = new PageParameters();
				pageParameters.add("username", usernameValue);
				pageParameters.add("email", emailValue);
				pageParameters.add("password", passwordValue);
				pageParameters.add("password2", passwordValue2);
				pageParameters.add("register", "register");
				setResponsePage(SuccessPage.class, pageParameters);

			}

		};

		add(form);
		// form.add(msg);
		form.add(username);
		form.add(password);
		form.add(password2);
		form.add(email);
	}
}
