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

import cleytonorocha.com.github.back_dashboard.model.entity.Local;
import cleytonorocha.com.github.back_dashboard.service.LocalService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/local")
public class LocalController {

    private final LocalService localService;

    @GetMapping
    public ResponseEntity<List<Local>> getAllLocals() {
        List<Local> locals = localService.getAllLocals();
        return ResponseEntity.ok(locals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> getLocalById(@PathVariable Long id) {
        return localService.getLocalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Local> createLocal(@RequestBody Local local) {
        Local savedLocal = localService.createLocal(local);
        return ResponseEntity.ok(savedLocal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Local> updateLocal(@PathVariable Long id, @RequestBody Local local) {
        try {
            Local updatedLocal = localService.updateLocal(id, local);
            return ResponseEntity.ok(updatedLocal);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocal(@PathVariable Long id) {
        localService.deleteLocal(id);
        return ResponseEntity.noContent().build();
    }
}
