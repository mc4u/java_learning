package com.cloud4u.membership.controller;

import com.cloud4u.membership.domain.dto.MemberInfo;
import com.cloud4u.membership.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/membership/api")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<MemberInfo> registration(@RequestBody MemberInfo memberInfo) {
        return ResponseEntity.ok(memberService.register(memberInfo));
    }

    @GetMapping(value = "/login/{emailId}/{password}")
    public ResponseEntity<MemberInfo> login(@PathVariable("emailId") String emailId,
                                            @PathVariable("password") String password) {
        return ResponseEntity.ok(memberService.login(emailId, password));
    }
}
