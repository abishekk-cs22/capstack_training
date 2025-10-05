package com.example.bank_management.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction_modes")
public class TransactionMode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // Cash, Online, Cheque

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
