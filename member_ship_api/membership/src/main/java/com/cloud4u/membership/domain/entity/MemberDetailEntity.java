package com.cloud4u.membership.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="member_detail_entity")
public class MemberDetailEntity {
	@Id
	@Column(name = "member_id")
	private long memberId;
	@Column(name = "member_address")
	private String member_address;
	@Column(name = "date_of_birth")
	private String dob;
	@Column(name = "profession")
	private String profession;
	@Column(name = "height")
	private String height;
	@Column(name = "weight")
	private String weight;
	
}
