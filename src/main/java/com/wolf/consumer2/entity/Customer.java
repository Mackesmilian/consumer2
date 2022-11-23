package com.wolf.consumer2.entity;

public class Customer {

    private String name;
    private Integer aggregatedBalance;

    public Customer() {
    }

    public Customer(String name, Integer aggregatedBalance) {
        this.name = name;
        this.aggregatedBalance = aggregatedBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAggregatedBalance() {
        return aggregatedBalance;
    }

    public void setAggregatedBalance(Integer aggregatedBalance) {
        this.aggregatedBalance = aggregatedBalance;
    }
}
