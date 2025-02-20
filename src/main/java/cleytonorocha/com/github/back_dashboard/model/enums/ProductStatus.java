package cleytonorocha.com.github.back_dashboard.model.enums;

import java.util.Arrays;

import cleytonorocha.com.github.back_dashboard.exception.EnumIdException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatus {
    AVAILABLE(1, "AVAILABLE"),
    OUT_OF_STOCK(2, "OUT OF STOCK"),
    DISCONTINUED(3, "DISCONTINUED"),
    PENDING(4, "PENDING"),
    RESERVED(5, "RESERVED");

    private final Integer cod;
    private final String description;

    public static ProductStatus toEnum(Integer cod){
        return Arrays.stream(ProductStatus.values())
        .filter(f -> f.getCod().equals(cod))
        .findFirst()
        .orElseThrow(() -> new EnumIdException());
    }
}
