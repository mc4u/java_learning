package com.cloud4u.membership.controller;

import com.cloud4u.membership.domain.dto.MemberInfo;
import com.cloud4u.membership.domain.entity.MemberEntity;
import com.cloud4u.membership.service.MemberService;
import java.lang.reflect.Member;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/membership/api")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(value = "registration")
    public ResponseEntity<MemberInfo> registration(@RequestBody MemberInfo memberInfo) {
        return ResponseEntity.ok(memberService.register(memberInfo));
    }
    @PutMapping(value="update/{id}")
    public MemberEntity updateMember(@PathVariable("id") long id ,@RequestBody MemberEntity member)
    {
    	return memberService.udpateMember(id,member);
    }
    @GetMapping("find/{name}")
	public MemberEntity Findbyname(@PathVariable("name") String memberName)
	{
		return memberService.fetchbyname(memberName);
	}
}
