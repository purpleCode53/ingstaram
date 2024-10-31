package com.toy.Ingstaram.Controller;

import com.toy.Ingstaram.repository.Member;
import com.toy.Ingstaram.repository.dto.LoginDto;
import com.toy.Ingstaram.service.LoginService;
import com.toy.Ingstaram.service.MemberService;
import com.toy.Ingstaram.utils.security.JwtToken;
import com.toy.Ingstaram.utils.security.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/member")
@RestController
public class LoginController {

    @Autowired
    private MemberService memberService;

    @GetMapping("login/{loginId}")
    public ResponseEntity<Member> getMember(@PathVariable("loginId") String loginId) {
        Member member = memberService.findMemberByLoginId(loginId);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("login")
    public JwtToken login(@RequestBody LoginDto loginDto) {
        String username = loginDto.getLoginId();
        String password = loginDto.getPassword();
        JwtToken jwtToken = memberService.signIn(username, password);
        log.info("request username = {}, password = {}", username, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return jwtToken;
    }

    @PostMapping("test")
    public String test() {
        return SecurityUtil.getCurrentUsername();
    }

}
