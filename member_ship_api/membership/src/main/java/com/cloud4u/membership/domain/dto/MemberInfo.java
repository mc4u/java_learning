package com.cloud4u.membership.domain.dto;

public class MemberInfo {
    //private Long id;
    private String name;
    private String emailId;
    private String password;
    private Long orgId;

    /*public Long getId() {
        return id;
    }

    public MemberInfo setId(Long id) {
        this.id = id;
        return this;
    }*/

    public String getName() {
        return name;
    }

    public MemberInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public MemberInfo setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MemberInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getOrgId() {
        return orgId;
    }

    public MemberInfo setOrgId(Long orgId) {
        this.orgId = orgId;
        return this;
    }
}
