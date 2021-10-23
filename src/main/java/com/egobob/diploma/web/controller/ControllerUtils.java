package com.egobob.diploma.web.controller;

final class ControllerUtils {

    public static final String USER_FOLDER = "user";
    public static final String USERS_VIEW = resolvePath(USER_FOLDER, "users");
    public static final String USER_FORM_VIEW = resolvePath(USER_FOLDER, "user_form");
    public static final String USER_SHOW_VIEW = resolvePath(USER_FOLDER, "user_show");

    public static final String CLIENT_FOLDER = "client";
    public static final String CLIENTS_VIEW = resolvePath(CLIENT_FOLDER, "clients");
    public static final String CLIENT_FORM_VIEW = resolvePath(CLIENT_FOLDER, "client_form");
    public static final String CLIENT_SHOW_VIEW = resolvePath(CLIENT_FOLDER, "client_show");


    private static String resolvePath(String folder, String viewName) {
        return folder + "/" + viewName;
    }

}
