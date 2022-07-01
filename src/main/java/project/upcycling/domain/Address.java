package project.upcycling.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String roadFullAddr;
    private String zipNo;
    private String addrDetail;

    public Address(String roadFullAddr, String zipNo, String addrDetail) {
        this.roadFullAddr = roadFullAddr;
        this.zipNo = zipNo;
        this.addrDetail = addrDetail;
    }
}
