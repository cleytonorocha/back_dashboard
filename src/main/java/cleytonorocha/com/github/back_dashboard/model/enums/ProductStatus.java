package cleytonorocha.com.github.back_dashboard.model.enums;

import java.util.stream.Stream;

import cleytonorocha.com.github.back_dashboard.exception.EnumIdException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatus {
    AVAILABLE(1, "Available"),
    OUT_OF_STOCK(2, "Out of Stock"),
    DISCONTINUED(3, "Discontinued"),
    PENDING(4, "Pending"),
    RESERVED(5, "Reserved");

    private final Integer cod;
    private final String description;

    public static ProductStatus toEnum(Integer cod){
        return Stream.of(ProductStatus.values())
        .filter(f -> f.getCod().equals(cod))
        .findFirst()
        .orElseThrow(() -> new EnumIdException());
    }
}
