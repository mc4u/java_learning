package com.cloud4u.membership.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member_ship_detail")
public class MemberShipDetailEntity {
	@Id
	@Column(name = "member_id")
	private long memberId;
	@Column(name = "membership_type")
	private String membershipType;
	@Column(name = "package_id")
	private long packageId;
	@Column(name = "jointing_date")
	private String jointingDate;
	@Column(name = "subscription_end")
	private String endingDate;
	@Column(name = "is_renewal")
	private String renewalDate;
	
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	public long getPackageId() {
		return packageId;
	}
	public String getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}
	public MemberShipDetailEntity() {
		super();
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getJointingDate() {
		return jointingDate;
	}
	public void setJointingDate(String jointingDate) {
		this.jointingDate = jointingDate;
	}
	public String getRenewalDate() {
		return renewalDate;
	}
	public void setRenewalDate(String renewalDate) {
		this.renewalDate = renewalDate;
	}
    




}
