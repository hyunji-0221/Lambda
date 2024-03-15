package com.von.api.menu;

import com.von.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    MenuServiceImpl service;
    private static MenuController instance = new MenuController();


    private MenuController() {
        this.service = MenuServiceImpl.getInstance();
    }
    public static MenuController getInstance(){
        return instance;
    }

    public Messenger makeMenuTable(){
        return service.makeMenuTable();
    }
    public Messenger removeMenuTable(){
        return service.removeTable();
    }

    public List<?> getMenusByCategory(String category){
        return service.getMenusByCategory(category);
    }

//    public Messenger returnMessenger() throws SQLException {
//        return service.returnMessenger();
//    }

    public List<?> returnAllMenus(String category) throws SQLException {
        return service.returnAllMenus(category);
    }
}
