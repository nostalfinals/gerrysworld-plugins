package xyz.garslity093.gerrysworld.menu.framework.button;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.garslity093.gerrysworld.menu.framework.utils.SkullUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.framework.button
 * @className: ItemStackBuilder
 * @author: GerryYuu
 * @date: 7/13/2022 1:56 AM
 */

public class ItemStackBuilder {
    private Material material;
    private String name;

    private int amount;

    private List<String> lore;

    private String skullValue;

    public ItemStackBuilder() {
        lore = new ArrayList<>();
        amount = 1;
    }

    public ItemStackBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public ItemStackBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemStackBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemStackBuilder addLore(String s) {
        lore.add(s);
        return this;
    }

    public ItemStackBuilder setSkullValue(String s) {
        skullValue = s;
        return this;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(Material.STONE, amount);
        if (material != null) itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (name != null) itemMeta.setDisplayName(name);
        itemStack.setAmount(amount);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        if (skullValue != null) {
            return SkullUtils.processItem(skullValue, itemStack);
        }
        return itemStack;
    }
}
