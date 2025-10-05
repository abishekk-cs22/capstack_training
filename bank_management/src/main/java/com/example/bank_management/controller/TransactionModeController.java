package com.example.bank_management.controller;

import com.example.bank_management.Entity.TransactionMode;
import com.example.bank_management.Repositories.TransactionModeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-modes")
public class TransactionModeController {

    private final TransactionModeRepository transactionModeRepository;

    public TransactionModeController(TransactionModeRepository transactionModeRepository) {
        this.transactionModeRepository = transactionModeRepository;
    }

    // ✅ Get all transaction modes
    @GetMapping
    public List<TransactionMode> getAllTransactionModes() {
        return transactionModeRepository.findAll();
    }

    // ✅ Get single transaction mode by ID
    @GetMapping("/{id}")
    public ResponseEntity<TransactionMode> getTransactionModeById(@PathVariable Long id) {
        return transactionModeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Create new transaction mode
    @PostMapping
    public TransactionMode createTransactionMode(@RequestBody TransactionMode transactionMode) {
        return transactionModeRepository.save(transactionMode);
    }

    // ✅ Update existing transaction mode
    @PutMapping("/{id}")
    public ResponseEntity<TransactionMode> updateTransactionMode(@PathVariable Long id,
                                                                 @RequestBody TransactionMode updatedMode) {
        return transactionModeRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedMode.getName());
                    transactionModeRepository.save(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Delete transaction mode
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionMode(@PathVariable Long id) {
        if (transactionModeRepository.existsById(id)) {
            transactionModeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

