package cleytonorocha.com.github.back_dashboard.model.entity;

import java.math.BigDecimal;

import cleytonorocha.com.github.back_dashboard.model.enums.ProductCategory;
import cleytonorocha.com.github.back_dashboard.model.enums.ProductStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String name;
    
    @Lob
    private String description;

    @Column(nullable = false)
    private Integer stock;

    @Column(precision = 4, scale = 2, nullable = false)
    private BigDecimal rating;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
    
    @Lob
    private String codeQr;

    @Lob
    private String imageUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ProductCategory category;
    
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;

}
