package cleytonorocha.com.github.back_dashboard.model.enums;

import java.util.Arrays;

import cleytonorocha.com.github.back_dashboard.exception.EnumIdException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductCategory {
    ELECTRONICS(1, "ELECTRONICS"),
    FOOD(2, "FOOD"),
    CLOTHING(3, "CLOTHING"),
    BOOKS(4, "BOOKS"),
    FURNITURE(5, "FURNITURE"),
    TOYS(6, "TOYS"),
    BEAUTY(7, "BEAUTY"),
    SPORTS(8, "SPORTS"),
    AUTOMOTIVE(9, "AUTOMOTIVE"),
    JEWELRY(10, "JEWELRY"),
    MUSIC(11, "MUSIC"),
    GARDEN(12, "GARDEN"),
    PETS(13, "PETS"),
    OFFICE(14, "OFFICE"),
    HEALTH(15, "HEALTH"),
    BABY(16, "BABY"),
    GROCERY(17, "GROCERY");

    private final Integer cod;
    private final String description;

    public static ProductCategory toEnum(Integer cod) {
        return Arrays.stream(ProductCategory.values())
                .filter(f -> f.getCod().equals(cod))
                .findFirst()
                .orElseThrow(() -> new EnumIdException());
    }
}
