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
	@Column(name ="member_name")
	private String member_name;
	@Column(name ="sex")
	private String sex;
	@Column(name ="Age")
	private String age;
	
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
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
