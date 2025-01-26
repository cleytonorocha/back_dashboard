package cleytonorocha.com.github.back_dashboard.config;

import java.math.BigDecimal;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

import cleytonorocha.com.github.back_dashboard.model.entity.Product;
import cleytonorocha.com.github.back_dashboard.model.enums.ProductCategory;
import cleytonorocha.com.github.back_dashboard.model.enums.ProductStatus;
import cleytonorocha.com.github.back_dashboard.model.repository.ProductRepository;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class DbMock {
        private final ProductRepository productRepository;
        private final Faker faker;
        private final Integer QUANTITY = 500;

        @Bean
        @SuppressWarnings("deprecation")
        String saveMock() {
                Product product = new Product();

                for (var i = 0; i < QUANTITY; i++) {
                        product.setId(null);
                        product.setName(faker.commerce().productName());
                        product.setDescription(faker.lorem().sentence());
                        product.setStock(faker.number().numberBetween(1, 100));
                        product.setRating(
                                        BigDecimal.valueOf(
                                                        faker.number()
                                                                        .randomDouble(2, 1, 5)));
                        product.setPrice(
                                        BigDecimal.valueOf(
                                                        faker.number().randomDouble(2, 10, 1000)));
                        product.setCodeQr(faker.code().isbn13());
                        product.setImageUrl(faker.internet().url());
                        product.setCategory(
                                        ProductCategory.toEnum(
                                                        RandomUtils.nextInt(1, ProductCategory.values().length)));
                        product.setStatus(
                                        ProductStatus.toEnum(
                                                        RandomUtils.nextInt(1, ProductStatus.values().length)));

                        productRepository.save(product);

                }

                return null;
        }

}
