/**
 * 
 */
package com.sam.user.web.app;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.sam.user.web.app.data.User;
import com.sam.user.web.app.service.UserInt;

/**
 * @author Samuel Tanor-Gyedu
 * 
 */
public class SuccessPage extends WebPage {
	@SpringBean
	UserInt userInt;

	public SuccessPage(final PageParameters parameters) {
		String password = "";
		String username = "Empty";
		String password2;
		String email;
		String message = "";

		if (parameters.containsKey("login")) {

			if (parameters.containsKey("username")
					&& parameters.containsKey("password")) {
				username = parameters.getString("username");
				password = parameters.getString("password");

				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				if (username.contains("@")) {
					user.setEmail(username);
				}

				User loggedInUser = userInt.login(user);
				if (loggedInUser == null) {
					
					message = "username or password is in-correct.";
					parameters.add("message",message);
					setResponsePage(LoginPage.class, parameters);
				} else {
					PageParameters users = new PageParameters();
					users.add("username", username);
					setResponsePage(LandPage.class, users);
				}

			}

		} else if (parameters.containsKey("register")) {

			username = parameters.getString("username");
			password = parameters.getString("password");
			password2 = parameters.getString("password2");
			email = parameters.getKey("email");
			message = "";

			long id = -4;

			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);

			if (!password.equals(password2)) {
				message =  "Passwords do not match! ";
				parameters.add("message", message);
				setResponsePage(Register.class, parameters);

			} else {
				id = userInt.register(user);

				if (id == 0) {
					message = "email already exists error_" + id;
					parameters.add("message", message);
					setResponsePage(Register.class, parameters);

				} else if (id == -1) {
					message = "Username already exists error_" + id;
					parameters.add("message", message);
					setResponsePage(Register.class, parameters);

				} else {
					PageParameters users = new PageParameters();
					users.add("username", username);

					setResponsePage(LandPage.class, users);
				}

			}

			/*
			 * final Label result = new Label("result", "Username : " + username
			 * + " ID: " + userId); add(result);
			 */

		}
	}
}
