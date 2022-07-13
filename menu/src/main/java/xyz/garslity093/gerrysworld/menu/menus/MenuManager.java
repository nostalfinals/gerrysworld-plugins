package xyz.garslity093.gerrysworld.menu.menus;

import xyz.garslity093.gerrysworld.menu.framework.menu.Menu;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.menus
 * @className: MenuManager
 * @author: GerryYuu
 * @date: 7/13/2022 3:55 PM
 */

public class MenuManager {
    private static Menu mainMenu;

    public MenuManager() {
        mainMenu = new MainMenu();
    }

    public static Menu getMainMenu() {
        return mainMenu;
    }
}
