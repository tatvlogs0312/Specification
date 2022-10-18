package com.example.specification.model;

public class SearchCriteria {
    private String key;
    private Operator operation;
    private Object value;

    public SearchCriteria(String key, Operator operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Operator getOperation() {
        return operation;
    }

    public void setOperation(Operator operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
