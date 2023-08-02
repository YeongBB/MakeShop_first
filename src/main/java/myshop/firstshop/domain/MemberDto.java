package myshop.firstshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class MemberDto {

    private String name;

    private String password;

    private LocalDateTime birthDate;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "member")
    private List<Order> orders;

    public MemberDto(String name, String password, LocalDateTime birthDate, String phoneNumber, String email) {
        this.name = name;
        this.password = password;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
