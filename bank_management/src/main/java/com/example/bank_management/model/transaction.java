package com.example.bank_management.model;

public class transaction {
	private long id;
	private String description;
	private int amount;
    private String transaction_mode;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTransaction_mode() {
		return transaction_mode;
	}
	public void setTransaction_mode(String transaction_mode) {
		this.transaction_mode = transaction_mode;
	}
    
}
