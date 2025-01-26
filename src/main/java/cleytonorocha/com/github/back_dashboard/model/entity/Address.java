package cleytonorocha.com.github.back_dashboard.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
