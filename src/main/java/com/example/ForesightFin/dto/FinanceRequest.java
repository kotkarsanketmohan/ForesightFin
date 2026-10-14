package com.example.ForesightFin.dto;

import java.time.LocalDate;

public class FinanceRequest {

    private Double amount;
    private String title;
    private LocalDate date;
    private String type;

    public FinanceRequest() {}

    public FinanceRequest(Double amount, String title, LocalDate date, String type) {
        this.amount = amount;
        this.title = title;
        this.date = date;
        this.type = type;
    }

    // Getters & Setters
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
