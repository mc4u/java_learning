package com.cloud4u.membership.repo;
import com.cloud4u.membership.domain.entity.MemberShipDetailEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipDetailRepositry extends JpaRepository<MemberShipDetailEntity, Long> {

	

}
