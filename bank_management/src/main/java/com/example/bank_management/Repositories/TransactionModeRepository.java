package com.example.bank_management.Repositories;

import com.example.bank_management.Entity.TransactionMode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionModeRepository extends JpaRepository<TransactionMode, Long> {
}
