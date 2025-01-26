package cleytonorocha.com.github.back_dashboard.model.enums;

import java.util.stream.Stream;

import cleytonorocha.com.github.back_dashboard.exception.EnumIdException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductCategory {
    ELECTRONICS(1, "Electronics"),
    FOOD(2, "Food"),
    CLOTHING(3, "Clothing"),
    BOOKS(4, "Books"),
    FURNITURE(5, "Furniture"),
    TOYS(6, "Toys"),
    BEAUTY(7, "Beauty"),
    SPORTS(8, "Sports"),
    AUTOMOTIVE(9, "Automotive"),
    JEWELRY(10, "Jewelry"),
    MUSIC(11, "Music"),
    GARDEN(12, "Garden"),
    PETS(13, "Pets"),
    OFFICE(14, "Office"),
    HEALTH(15, "Health"),
    BABY(16, "Baby"),
    GROCERY(17, "Grocery");

    private final Integer cod;
    private final String description;

    public static ProductCategory toEnum(Integer cod){
        return Stream.of(ProductCategory.values())
        .filter(f -> f.getCod().equals(cod))
        .findFirst()
        .orElseThrow(() -> new EnumIdException());
    }
}
