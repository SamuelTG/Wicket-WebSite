package com.sam.user.web.app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sam.user.web.app.data.User;

public interface UserRepo extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
	public User queryLogin(@Param("username") String username, @Param("password") String password);

	@Query("SELECT COUNT(u.email) FROM User u WHERE u.email=:email")
	public Long CheckUseremailExist(@Param("email") String email);

	@Query("SELECT COUNT(u.username) FROM User u WHERE u.username=:username")
	public Long CheckUsernameExist(@Param("username") String username);
}
