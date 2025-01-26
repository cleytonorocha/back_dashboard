package cleytonorocha.com.github.back_dashboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cleytonorocha.com.github.back_dashboard.model.entity.Sale;
import cleytonorocha.com.github.back_dashboard.model.repository.SalesRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {

    private SalesRepository salesRepository;

    public List<Sale> getAllSales() {
        return salesRepository.findAll();
    }

    public Optional<Sale> getSalesById(Long id) {
        return salesRepository.findById(id);
    }

    public Sale createSale(Sale sales) {
        return salesRepository.save(sales);
    }

    public Sale updateSale(Long id, Sale sale) {
        return salesRepository.findById(id)
                .map(m -> {
                    m.setId(sale.getId());
                    return salesRepository.save(m);
                }).orElseThrow(() -> new RuntimeException("Sale not found with id: " + id));
    }

    public void deleteSale(Long id) {
        salesRepository.deleteById(id);
    }
}
