package delivery.com.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @OneToOne(fetch = LAZY, mappedBy = "member", cascade = ALL)
    private Basket basket;

    private String name;

    public Member(String name) {
        this.name = name;
        this.basket = new Basket(this);
    }

}
