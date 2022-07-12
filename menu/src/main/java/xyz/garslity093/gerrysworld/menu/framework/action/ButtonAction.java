package xyz.garslity093.gerrysworld.menu.framework.action;

import org.bukkit.event.inventory.ClickType;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.action
 * @className: WindowAction
 * @author: GerryYuu
 * @date: 7/12/2022 5:33 PM
 */

public abstract class ButtonAction implements Action {
    private List<ClickType> clickTypes = new ArrayList<>();

    public List<ClickType> getClickTypes() {
        return clickTypes;
    }

    public ButtonAction addClickType(ClickType clickType) {
        clickTypes.add(clickType);
        return this;
    }
}
