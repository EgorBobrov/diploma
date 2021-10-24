package com.egobob.diploma.domain.document;

public enum DocumentStatus {
    CREATED("Поставлен на учёт"),
    IN_PROGRESS("В работе"),
    DONE("Исполнен"),
    CHECKED("Проверен"),
    ARCHIVED("Отправлен в архив");

    private DocumentStatus(String value) {
        this.value = value;
    }
    public final String value;
}
