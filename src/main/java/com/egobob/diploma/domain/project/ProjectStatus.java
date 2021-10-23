package com.egobob.diploma.domain.project;

public enum ProjectStatus {
    ONGOING("Активен"), TERMINATED("Завершён");
    private ProjectStatus(String value) {
        this.value = value;
    }
    public final String value;
}
