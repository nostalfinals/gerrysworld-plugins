package framework.menu.action;

import org.bukkit.event.inventory.ClickType;

import java.util.HashSet;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.action
 * @className: WindowAction
 * @author: GerryYuu
 * @date: 7/12/2022 5:33 PM
 */

public abstract class ButtonAction implements Action {
    private HashSet<ClickType> clickTypes = new HashSet<>();

    public HashSet<ClickType> getClickTypes() {
        return clickTypes;
    }

    public ButtonAction addClickType(ClickType clickType) {
        clickTypes.add(clickType);
        return this;
    }
}
