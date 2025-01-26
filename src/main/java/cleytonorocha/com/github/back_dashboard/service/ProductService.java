package cleytonorocha.com.github.back_dashboard.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cleytonorocha.com.github.back_dashboard.exception.ItemNotFoundException;
import cleytonorocha.com.github.back_dashboard.model.entity.Product;
import cleytonorocha.com.github.back_dashboard.model.repository.ProductRepository;
import cleytonorocha.com.github.back_dashboard.rest.DTO.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductDTO> findAll(Integer page, Integer linesPerPage, String orderBy, String direction) {
        log.info("Fetching all products with page: {}, linesPerPage: {}, orderBy: {}, direction: {}", page,
                linesPerPage, orderBy, direction);

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        log.debug("PageRequest created: {}", pageRequest);

        Page<Product> products = productRepository.findAll(pageRequest);
        log.debug("Products fetched: {}", products.getContent());

        Page<ProductDTO> productDTOs = new PageImpl<>(products.stream()
                .map(ProductDTO::toDTO)
                .toList());
        log.info("Returning {} products", productDTOs.getTotalElements());

        return productDTOs;

    }

    public ProductDTO findById(Long id) {
        log.info("Fetching product with id: {}", id);
        return productRepository.findById(id)
                .map(ProductDTO::toDTO)
                .orElseThrow(() -> {
                    log.warn("Product with id: {} not found", id);
                    return new ItemNotFoundException();
                });
    }

    public ProductDTO save(ProductDTO product) {
        log.info("Saving product: {}", product);
        Product savedProduct = productRepository.save(ProductDTO.toEntity(product));
        return ProductDTO.toDTO(savedProduct);
    }

    public ProductDTO update(Long id, ProductDTO product) {
        log.info("Updating product with id: {}", id);
        if (productRepository.existsById(id)) {
            product.setId(id);
            Product updatedProduct = productRepository.save(ProductDTO.toEntity(product));
            return ProductDTO.toDTO(updatedProduct);
        } else {
            log.warn("Product with id: {} not found", id);
            throw new ItemNotFoundException();
        }
    }

    public void deleteById(Long id) {
        log.info("Deleting product with id: {}", id);
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            log.warn("Product with id: {} not found", id);
            throw new ItemNotFoundException();
        }
    }
}
