package com.cloud4u.membership.service;

import com.cloud4u.membership.domain.dto.MemberInfo;
import com.cloud4u.membership.domain.entity.MemberEntity;
import com.cloud4u.membership.repo.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void testRegister() {
        when(memberRepository.save(any()))
                .thenReturn(getMemberEntity(buildMemberInfo()));
        MemberInfo register = memberService.register(buildMemberInfo());
        assertEquals("abc@gmail.com", register.getEmailId());
    }

    /*@Test
    public void testLogin() {
        when(memberRepository.findByEmailIdAndPassword(anyString(), anyString()))
                .thenReturn(getMemberEntity(buildMemberInfo()));
        MemberInfo register = memberService.register(buildMemberInfo());
        assertEquals("abc@gmail.com", register.getEmailId());
    }*/


    private MemberInfo buildMemberInfo() {
        return new MemberInfo()
                .setName("A")
                .setEmailId("abc@gmail.com")
                .setOrgId(1l);
    }

    private MemberEntity getMemberEntity(MemberInfo memberInfo) {
        return new MemberEntity(memberInfo.getName(),
                memberInfo.getEmailId(),
                memberInfo.getPassword(),
                memberInfo.getOrgId());
    }

}
