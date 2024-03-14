package com.von.api.menu;

public class MenuServiceImpl implements MenuService{
    private static MenuServiceImpl instance;
    private MenuRepository repository;

    private MenuServiceImpl() {
        instance  = new MenuServiceImpl();
        this.repository = MenuRepository.getInstance();
    }
    public static MenuServiceImpl getInstance(){
        return instance;
    }
}
