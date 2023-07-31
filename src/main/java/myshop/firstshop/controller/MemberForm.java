package myshop.firstshop.controller;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberForm {

    @NotEmpty(message = "이름은 필수 입니다")
    private String name;
    private String memberId;
    private String password;

    private LocalDateTime birthDate;
    private String phoneNumber;
    private String email;
}
