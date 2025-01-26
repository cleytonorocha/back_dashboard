package cleytonorocha.com.github.back_dashboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cleytonorocha.com.github.back_dashboard.model.entity.Local;
import cleytonorocha.com.github.back_dashboard.model.repository.LocalRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocalService {

    private final LocalRepository localRepository;

    public List<Local> getAllLocals() {
        return localRepository.findAll();
    }

    public Optional<Local> getLocalById(Long id) {
        return localRepository.findById(id);
    }

    public Local createLocal(Local local) {
        return localRepository.save(local);
    }

    public Local updateLocal(Long id, Local local) {
        return localRepository.findById(id)
                .map(map -> {
                    map.setAddress(local.getAddress());
                    return localRepository.save(map);
                }).orElseThrow(() -> new RuntimeException("Local not found with id: " + id));
    }

    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }
}
