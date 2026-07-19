package com.memberService.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.memberService.domain.Member;
import com.memberService.repository.MemberRepository;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

  // 가짜 객체 생성
  @Mock
  MemberRepository memberRepository;

  // 가짜 객체를 MemberService에 주입
  @InjectMocks
  MemberService memberService;

  @Test
  @DisplayName("회원 등록")
  void saveMember() {
    // given
    Member member = new Member("홍길동", "hong@test.com", "01012345678");

    // when
    memberService.save(member);

    // then
    // 특정 메서드가 호출됐는지 검증
    // 검증할 때는 Mockit의 verify을 사용
    verify(memberRepository.save(member));

  }

  @Test
  @DisplayName("회원 목록 조회")
  void findMembers() {
    // given
    Member member1 = new Member("홍길동", "hong@test.com", "01012345678");
    Member member2 = new Member("홍길동", "hong@test.com", "01012345678");

    List<Member> savedMember = List.of(member1, member2);

    // 가짜 객체가 어떤 값을 반환할지 정하기
    when(memberRepository.findAll()).thenReturn(savedMember);

    // when
    List<Member> members = memberService.findAll();

    // than
    assertThat(members).isNotNull();
    assertThat(members).hasSize(2);
    assertThat(members).containsExactly(member1, member2);

    verify(memberRepository).findAll();

  }

  @Test
  @DisplayName("회원 상세 조회")
  void findMemberById() {
    // given
    Member member1 = new Member("홍길동", "hong@test.com", "01012345678");

    when(memberRepository.findById(1L)).thenReturn(Optional.of(member1));

    // when
    Optional<Member> member = memberService.findById(1L);

    // then
    assertThat(member).isPresent();
    assertThat(member.get()).isEqualTo(member1);
    verify(memberRepository).findById(1L);

  }

  @Test
  @DisplayName("회원 정보 수정")
  void updateMember() {
    // given
    Member member = new Member("홍길동", "hong@test.com", "01012345678");

    // when
    member.setName("고길동");
    memberService.save(member);

    // then
    verify(memberRepository).save(member);
  }

  @Test
  @DisplayName("회원 삭제")
  void deleteMember() {
    // given
    long memberId = 1L;

    // when
    memberService.delete(memberId);

    // then
    verify(memberRepository).deleteById(memberId);
  }
}
