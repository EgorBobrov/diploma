package com.egobob.diploma.web.controller;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class ControllerUtils {

    public static final String USER_FOLDER = "user";
    public static final String USERS_VIEW = resolvePath(USER_FOLDER, "users");
    public static final String USER_FORM_VIEW = resolvePath(USER_FOLDER, "user_form");
    public static final String USER_SHOW_VIEW = resolvePath(USER_FOLDER, "user_show");

    public static final String CLIENT_FOLDER = "client";
    public static final String CLIENTS_VIEW = resolvePath(CLIENT_FOLDER, "clients");
    public static final String CLIENT_FORM_VIEW = resolvePath(CLIENT_FOLDER, "client_form");
    public static final String CLIENT_SHOW_VIEW = resolvePath(CLIENT_FOLDER, "client_show");

    public static final String PROJECT_FOLDER = "project";
    public static final String PROJECTS_VIEW = resolvePath(PROJECT_FOLDER, "projects");
    public static final String PROJECT_FORM_VIEW = resolvePath(PROJECT_FOLDER, "project_form");
    public static final String PROJECT_SHOW_VIEW = resolvePath(PROJECT_FOLDER, "project_show");

    public static final String DOCUMENT_FOLDER = "document";
    public static final String DOCUMENTS_VIEW = resolvePath(DOCUMENT_FOLDER, "documents");
    public static final String DOCUMENT_FORM_VIEW = resolvePath(DOCUMENT_FOLDER, "document_form");
    public static final String DOCUMENT_SHOW_VIEW = resolvePath(DOCUMENT_FOLDER, "document_show");

    public static final String DOCUMENT_TYPE_FOLDER = "doctype";
    public static final String DOCUMENT_TYPES_VIEW = resolvePath(DOCUMENT_TYPE_FOLDER, "doctypes");
    public static final String DOCUMENT_TYPE_FORM_VIEW = resolvePath(DOCUMENT_TYPE_FOLDER, "doctype_form");
    public static final String DOCUMENT_TYPE_SHOW_VIEW = resolvePath(DOCUMENT_TYPE_FOLDER, "doctype_show");

    public static final String NOTE_FOLDER = "note";
    public static final String NOTES_VIEW = resolvePath(NOTE_FOLDER, "notes");
    public static final String NOTE_FORM_VIEW = resolvePath(NOTE_FOLDER, "note_form");
    public static final String NOTE_SHOW_VIEW = resolvePath(NOTE_FOLDER, "note_show");

    public static final String REPORT_FOLDER = "report";
    public static final String REPORTS_VIEW = resolvePath(REPORT_FOLDER, "reports");
    public static final String USERS_REPORT_FORM_VIEW = resolvePath(REPORT_FOLDER, "users_report_form");
    public static final String USERS_REPORT_SHOW_VIEW = resolvePath(REPORT_FOLDER, "users_report_show");
    public static final String PROJECT_DOCS_REPORT_FORM_VIEW = resolvePath(REPORT_FOLDER, "project_docs_report_form");
    public static final String PROJECT_DOCS_REPORT_SHOW_VIEW = resolvePath(REPORT_FOLDER, "project_docs_report_show");
    public static final String DOCUMENT_REPORT_FORM_VIEW = resolvePath(REPORT_FOLDER, "document_report_form");
    public static final String DOCUMENT_REPORT_SHOW_VIEW = resolvePath(REPORT_FOLDER, "document_report_show");
    public static final String CLIENT_PROJECTS_REPORT_FORM_VIEW = resolvePath(REPORT_FOLDER, "client_projects_report_form");
    public static final String CLIENT_PROJECTS_REPORT_SHOW_VIEW = resolvePath(REPORT_FOLDER, "client_projects_report_show");

    private static String resolvePath(String folder, String viewName) {
        return folder + "/" + viewName;
    }

}
