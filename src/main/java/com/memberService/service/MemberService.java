package com.memberService.service;

import java.util.List;
import java.util.Optional;

import com.memberService.domain.Member;
import com.memberService.repository.MemberRepository;

public class MemberService {

  private MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public void save(Member member) {
    memberRepository.save(member);
  }

  public List<Member> findAll() {
    return memberRepository.findAll();
  }

  public Optional<Member> findById(Long id) {
    Member member = memberRepository.findById(id).orElseThrow();
    return Optional.ofNullable(member);
  }

  public void delete(Member member) {
    memberRepository.delete(member);
  }
}
