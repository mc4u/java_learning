package com.cloud4u.membership.service;

import com.cloud4u.membership.domain.dto.MemberInfo;
import com.cloud4u.membership.domain.entity.MemberDetailEntity;
import com.cloud4u.membership.domain.entity.MemberEntity;
import com.cloud4u.membership.domain.entity.MemberShipDetailEntity;
import com.cloud4u.membership.exception.UserNotFoundException;
import com.cloud4u.membership.util.MemberMapper;
import com.cloud4u.membership.repo.MemberRepository;
import com.cloud4u.membership.repo.MembersDetailRepositry;
import com.cloud4u.membership.repo.MembershipDetailRepositry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    private  MembershipDetailRepositry membershipDetailRepositry;
    @Autowired
    private MembersDetailRepositry membersDetailRepositry;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberInfo register(MemberInfo memberInfo) {
        MemberEntity entity = new MemberEntity(memberInfo.getName(),
                memberInfo.getEmailId(),
                memberInfo.getPassword(),
                memberInfo.getOrgId());
        MemberEntity memberEntity =  memberRepository.save(entity);
        return new MemberInfo()
                //.setId(memberEntity.getId())
                .setName(memberEntity.getName())
                .setEmailId(memberEntity.getEmailId())
                .setOrgId(memberEntity.getOrgId());
    }

    // return the member by member id
    public MemberInfo GetMember(Long memberId) {
        MemberEntity memberEntity =  memberRepository.getById(memberId);
        return new MemberInfo()
                .setName(memberEntity.getName())
                .setEmailId(memberEntity.getEmailId())
                .setOrgId(memberEntity.getOrgId());
    }

    public MemberInfo login(String emailId, String password) {
        return memberRepository.findByEmailIdAndPassword(emailId, password)
                .map(memberEntity -> new MemberInfo()
                        .setName(memberEntity.getName())
                        .setEmailId(memberEntity.getEmailId())
                        .setOrgId(memberEntity.getOrgId()))
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

	public MemberDetailEntity getMemberDetails(long member_id) {
	
		return membersDetailRepositry.findById(member_id).get();
	}


	public List<MemberShipDetailEntity> getNotification() {
		
		return membershipDetailRepositry.findAll();
	}

	public List<MemberShipDetailEntity> listAll() {
		
		return membershipDetailRepositry.findAll();
	}
}
