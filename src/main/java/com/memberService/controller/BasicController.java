package com.memberService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.memberService.repository.MemberRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.memberService.domain.Member;

@Controller
// @RequestMapping("/members/")
public class BasicController {

  private final MemberRepository memberRepository;

  BasicController(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/members")
  public String members() {
    return "/members/list";
  }

  @GetMapping("/members/new")
  public String add(Model model) {
    Member member = new Member();
    model.addAttribute("member", member);
    model.addAttribute("name", member.getName());
    model.addAttribute("email", member.getEmail());
    model.addAttribute("phone", member.getPhone());
    return "/members/add";
  }

  @GetMapping("/members/{id}")
  public String detail() {
    return "/members/detail";
  }

  @GetMapping("/members/{id}/edit")
  public String edit(@PathVariable("id") long id, Model model) {
    Member member = memberRepository.findById(id).orElse(null);
    model.addAttribute("member", member);
    return "/members/edit";
  }

  @PostMapping("/members/{id}")
  public String edit(@PathVariable("id") long id, Member updateMember) {
    updateMember.setId(id);
    memberRepository.save(updateMember);
    return "redirect:/members/" + id;
  }

  @PostMapping("/members/{id}/delete")
  public String delete(@PathVariable("id") long id) {
    memberRepository.deleteById(id);
    return "redirect:/members/";
  }
}
