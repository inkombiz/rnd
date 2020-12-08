package com.inkombizz.master.repository.v1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inkombizz.master.model.v1.RoleModel;
import com.inkombizz.master.model.v1.RoleModel;

/**
 *
 * @author de4ragil
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleModel, String> {
	
//	Same Query
	List<RoleModel> findByCode(String search);
	
//	Like Query Case Sensitive
	List<RoleModel> findByCodeContaining(String search);

//	Like Query not Case Sensitive
	List<RoleModel> findByCodeContainingIgnoreCase(String search);
	

//	Like Query JPA Modeling
	@Query("select role from RoleModel role where role.code like %:code% OR role.name = :name ")
	List<RoleModel> findByCodeOrName(String code, String name);
}
