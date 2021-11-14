package com.cloud4u.membership.service;

import com.cloud4u.membership.domain.dto.MemberInfo;
import com.cloud4u.membership.domain.entity.MemberEntity;
import com.cloud4u.membership.util.MemberMapper;
import com.cloud4u.membership.repo.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

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

}
