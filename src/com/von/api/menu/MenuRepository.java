package com.von.api.menu;

public class MenuRepository {
    private static MenuRepository instance;

    private MenuRepository() {
        instance = new MenuRepository();
    }

    public static MenuRepository getInstance(){
        return instance;
    }

}
