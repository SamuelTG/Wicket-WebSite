package com.sam.user.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.user.web.app.data.User;
import com.sam.user.web.app.repo.UserRepo;

@Service
public class UserService implements UserInt {
	@Autowired
	UserRepo userRepo;

	@Override
	public String echo(String echo) {

		return echo;
	}

	@Override
	public User getUser(Long userId) {
		if (userRepo.exists(userId)) {
			User userDAO = userRepo.findOne(userId);
			return userDAO;
		}
		return null;
	}

	@Override
	public User login(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		//String email = user.getEmail();

		User userDAO = userRepo.queryLogin(username, password);
		if (userDAO != null) {
			return userDAO;
		}
		return null;
	}

	@Override
	public Long register(User user) {
		if (user != null) {
			if ((user.getUsername() != null || user.getFirstName() != "") && (user.getPassword() != null || user.getPassword() != "")) {

				Long emailExist = userRepo.CheckUseremailExist(user.getEmail());
				Long usernameExist = userRepo.CheckUsernameExist(user.getUsername());

				if (emailExist > 0) {
					return 0L;
				}

				if (usernameExist > 0) {
					return -1L;
				} else {
					User userDAO = userRepo.save(user);
					return userDAO.getId();
				}
			} else {
				return -2L;
			}
		}
		return -2L;
	}
}
