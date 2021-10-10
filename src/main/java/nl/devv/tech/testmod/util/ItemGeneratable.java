package nl.devv.tech.testmod.util;

import net.minecraft.item.Item;

public abstract class ItemGeneratable extends Item implements IResourceGeneratable.Item {

    public ItemGeneratable(Settings settings) {
        super(settings);
    }
};
