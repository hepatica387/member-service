package com.memberService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.memberService.domain.Member;
import com.memberService.repository.MemberRepository;

@Service
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
    return memberRepository.findById(id);
  }

  public void delete(long id) {
    memberRepository.deleteById(id);
  }
}
