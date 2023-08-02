package myshop.firstshop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String memberId;
    private String password;

    private LocalDateTime birthDate;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "member")
    private List<Order> orders;

    public void update(MemberDto memberDto){
        this.name = memberDto.getName();
        this.password = memberDto.getPassword();
        this.birthDate = memberDto.getBirthDate();
        this.phoneNumber = memberDto.getPhoneNumber();
        this.email = memberDto.getEmail();
        this.orders = memberDto.getOrders();
    }
    public Member(String name, String memberId, String password, LocalDateTime birthDate, String phoneNumber, String email) {
        this.name = name;
        this.memberId = memberId;
        this.password = password;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
