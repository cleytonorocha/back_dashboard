package cleytonorocha.com.github.back_dashboard.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cleytonorocha.com.github.back_dashboard.exception.ItemNotFoundException;
import cleytonorocha.com.github.back_dashboard.model.entity.Sale;
import cleytonorocha.com.github.back_dashboard.model.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository salesRepository;

    public Page<Sale> findAll(Integer page, Integer linesPerPage, String orderBy, String direction) {
        log.info("Fetching all sales with page: {}, linesPerPage: {}, orderBy: {}, direction: {}", page,
                linesPerPage, orderBy, direction);

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        log.debug("PageRequest created: {}", pageRequest);

        Page<Sale> sales = salesRepository.findAll(pageRequest);
        log.debug("Sales fetched: {}", sales.getContent());

        log.info("Returning {} sales", sales.getTotalElements());

        return sales;
    }

    public Sale findById(Long id) {
        log.info("Fetching sale with id: {}", id);
        return salesRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Sale with id: {} not found", id);
                    return new ItemNotFoundException();
                });
    }

    public Sale save(Sale sale) {
        log.info("Saving sale: {}", sale);
        return salesRepository.save(sale);
    }

    public Sale update(Long id, Sale sale) {
        log.info("Updating sale with id: {}", id);
        if (salesRepository.existsById(id)) {
            sale.setId(id);
            return salesRepository.save(sale);
        } else {
            log.warn("Sale with id: {} not found", id);
            throw new ItemNotFoundException();
        }
    }

    public void deleteById(Long id) {
        log.info("Deleting sale with id: {}", id);
        if (salesRepository.existsById(id)) {
            salesRepository.deleteById(id);
        } else {
            log.warn("Sale with id: {} not found", id);
            throw new ItemNotFoundException();
        }
    }
}
