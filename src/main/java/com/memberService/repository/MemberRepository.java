package com.memberService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.memberService.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
