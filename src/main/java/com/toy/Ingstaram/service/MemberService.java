package com.toy.Ingstaram.service;

import com.toy.Ingstaram.repository.Member;
import com.toy.Ingstaram.utils.security.JwtToken;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    JwtToken signIn(String username, String password);

    Member findMemberByLoginId(String loginId);
}
