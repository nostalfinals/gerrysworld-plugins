package xyz.garslity093.gerrysworld.menu.menus;

import framework.menu.menu.Menu;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.menus
 * @className: MenuManager
 * @author: GerryYuu
 * @date: 7/13/2022 3:55 PM
 */

public class MenuManager {
    private static final Menu MAIN_MENU = new MainMenu();

    public static Menu getMainMenu() {
        return MAIN_MENU;
    }
}
