package framework.menu.action;

import java.util.HashSet;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.framework.action
 * @className: MenuAction
 * @author: GerryYuu
 * @date: 7/13/2022 4:04 PM
 */

public abstract class MenuAction implements Action {
    private HashSet<MenuActionType> menuActionTypes = new HashSet<>();

    public HashSet<MenuActionType> getMenuActionTypes() {
        return menuActionTypes;
    }

    public MenuAction addMenuActionType(MenuActionType menuActionType) {
        menuActionTypes.add(menuActionType);
        return this;
    }
}
