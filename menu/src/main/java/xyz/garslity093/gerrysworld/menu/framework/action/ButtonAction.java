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
    private final List<ClickType> CLICK_TYPES = new ArrayList<>();

    public List<ClickType> getClickType() {
        return CLICK_TYPES;
    }

    public ButtonAction addClickType(ClickType clickType) {
        CLICK_TYPES.add(clickType);
        return this;
    }

}
