package com.jshi.laughtale.member.controller;

import com.jshi.laughtale.member.dto.MemberCheck;
import com.jshi.laughtale.member.dto.MemberUpdate;
import com.jshi.laughtale.member.service.MemberService;
import com.jshi.laughtale.security.details.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping
    public ResponseEntity<MemberCheck.Response> check(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return ResponseEntity.ok(memberService.check(customUserDetails.getId()));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Map<String, String>> login(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.login(memberId));
    }

    @PatchMapping("/modify")
    public ResponseEntity<Void> update(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @RequestBody MemberUpdate.Request update
    ) {
        memberService.update(customUserDetails, update);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/role")
    public ResponseEntity<Void> updateRole(
            @RequestBody MemberUpdate.RoleRequest update
    ) {
        memberService.updateRole(update);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> withdraw(
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        memberService.withdraw(customUserDetails);
        return ResponseEntity.ok().build();
    }
}
