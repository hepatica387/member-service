package com.memberService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.memberService.domain.Member;

import jakarta.persistence.EntityManager;

@Controller
// @RequestMapping("/members/")
public class BasicController {

  private final EntityManager entityManager;

  BasicController(EntityManager entityManager) {
    this.entityManager = entityManager;
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

  @GetMapping("/members/{memberId}")
  public String detail() {
    return "/members/detail";
  }

  @GetMapping("/members/{memberId}/edit")
  public String edit() {
    return "/members/edit";
  }
}
