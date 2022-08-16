package ru.ganichev.invest.portfolio;


public class AuthorizedUser {
    private static long id;

    public static long id() {
        return id;
    }

    public static void setId(long id) {
        AuthorizedUser.id = id;
    }

}
