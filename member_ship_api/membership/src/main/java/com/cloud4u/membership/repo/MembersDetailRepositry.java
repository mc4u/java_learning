package com.cloud4u.membership.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud4u.membership.domain.entity.MemberDetailEntity;

public interface MembersDetailRepositry extends JpaRepository<MemberDetailEntity,Long> {

}
