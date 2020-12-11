package com.inkombizz.master.repository.v1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inkombizz.master.resource.v1.UserModel;
import com.inkombizz.master.service.v1.UserService;

/**
 *
 * @author de4ragil
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

//	User
	UserModel findByUsername(String username);
	
//	Same Query
//	List<UserModel> findByUsername(String search);
	
//	Like Query Case Sensitive
	List<UserModel> findByUsernameContaining(String search);

//	Like Query not Case Sensitive
	List<UserModel> findByUsernameContainingIgnoreCase(String search);
	

//	Like Query JPA Modeling
	@Query("select "
			+ " u.code as user_code, "
			+ " u.username as user_username, "
			+ " u.email as user_email "
			+ " from UserModel u "
			+ " ")
	List<UserService> list();
	

//	Like Query JPA Modeling
	@Query("select "
			+ " u.code as user_code, "
			+ " u.username as user_username, "
			+ " u.email as user_email "
			+ " from UserModel u "
			+ " where u.username like %:prm% OR u.email = :prm ")
	List<UserService> findByUsernameOrEmail(String prm);
}
