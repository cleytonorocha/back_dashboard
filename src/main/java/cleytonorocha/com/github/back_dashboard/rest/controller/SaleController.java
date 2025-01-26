package cleytonorocha.com.github.back_dashboard.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cleytonorocha.com.github.back_dashboard.model.entity.Sale;
import cleytonorocha.com.github.back_dashboard.service.SaleService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService salesService;

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> salesList = salesService.getAllSales();
        return ResponseEntity.ok(salesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        return salesService.getSalesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sales) {
        Sale savedSales = salesService.createSale(sales);
        return ResponseEntity.ok(savedSales);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable Long id, @RequestBody Sale sales) {
        try {
            Sale updatedSales = salesService.updateSale(id, sales);
            return ResponseEntity.ok(updatedSales);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        salesService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
