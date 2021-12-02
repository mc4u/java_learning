package com.cloud4u.membership.repo;

import com.cloud4u.membership.domain.entity.MemberEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

	@Query(value="select department_name from Department where UPPER(department_name) = UPPER(?1)")
	public MemberEntity findByFirstnameIgnoreCase(String memberName);

	
}
