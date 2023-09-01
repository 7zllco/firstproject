package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUp(){
        return "members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm form){
        Member member = form.toEntity();
        Member saved = memberRepository.save(member);
        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        Member m = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", m);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        ArrayList<Member> ml = memberRepository.findAll();
        model.addAttribute("memberList", ml);
        return "members/index";
    }
}
