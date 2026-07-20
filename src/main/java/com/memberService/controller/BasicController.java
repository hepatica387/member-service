package com.memberService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.memberService.domain.Member;
import com.memberService.service.MemberService;

@Controller
// @RequestMapping("/members/")
public class BasicController {

  private final MemberService memberService;

  BasicController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/members")
  public String members(Model model) {
    List<Member> members = memberService.findAll();
    model.addAttribute("members", members);
    return "/members/list";
  }

  @GetMapping("/members/new")
  public String add(Model model) {
    Member member = new Member();
    model.addAttribute("member", member);
    return "/members/add";
  }

  @PostMapping("/members/new")
  public String memberAdd(Member member) {
    memberService.save(member);
    return "redirect:/members";
  }

  @GetMapping("/members/{id}")
  public String detail(@PathVariable("id") Long id, Model model) {
    Member member = memberService.findById(id).orElseThrow();
    model.addAttribute("member", member);
    return "/members/detail";
  }

  @GetMapping("/members/{id}/edit")
  public String edit(@PathVariable("id") long id, Model model) {
    Member member = memberService.findById(id).orElse(null);
    model.addAttribute("member", member);
    return "/members/edit";
  }

  @PostMapping("/members/{id}")
  public String edit(@PathVariable("id") long id, Member updateMember) {
    memberService.update(id, updateMember);
    return "redirect:/members/" + id;
  }

  @PostMapping("/members/{id}/delete")
  public String delete(@PathVariable("id") long id) {
    memberService.delete(id);
    return "redirect:/members";
  }
}
