package myshop.firstshop.controller;

import lombok.RequiredArgsConstructor;
import myshop.firstshop.domain.Member;
import myshop.firstshop.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/new")
    public String createForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/member/new")
    public String createMember(@Validated MemberForm form, BindingResult result){

        if(result.hasErrors()){
            return "members/createMemberForm";
        }

        Member member = new Member(form.getName(),form.getMemberId(), form.getPassword(), form.getBirthDate(), form.getPhoneNumber(), form.getEmail());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String listMember(Model model){
        List<Member> members = memberService.memberList();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
