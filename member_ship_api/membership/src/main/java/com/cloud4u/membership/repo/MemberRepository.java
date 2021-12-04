package com.cloud4u.membership.repo;

import com.cloud4u.membership.domain.entity.MemberEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByEmailIdAndPassword(String emailId, String password);
   
}
