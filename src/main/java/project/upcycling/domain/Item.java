package project.upcycling.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

    private String image;

    private LocalDate dueDate;
    private int targetAmount;
    private int totalFundingAmount;
    private String content;
    private Category category;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Item(String name, int price, String image, LocalDate dueDate, int targetAmount, String content, Category category, Member member) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.dueDate = dueDate;
        this.targetAmount = targetAmount;
        this.content = content;
        this.category = category;
        this.member = member;
        this.totalFundingAmount = 0;
    }
}
