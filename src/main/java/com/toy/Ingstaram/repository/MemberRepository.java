package com.toy.Ingstaram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findMemberByLoginId(String loginId);

    Optional<Member> findByLoginId(String loginId);

}
