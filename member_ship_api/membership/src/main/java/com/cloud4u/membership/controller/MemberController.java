package com.cloud4u.membership.controller;

import com.cloud4u.membership.domain.dto.MemberInfo;
import com.cloud4u.membership.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
