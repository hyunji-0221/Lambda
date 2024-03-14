package com.von.api.menu;

public class MenuController {
    MenuServiceImpl service;

    public MenuController() {
        this.service = MenuServiceImpl.getInstance();
    }
}
