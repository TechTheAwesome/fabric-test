package nl.devv.tech.testmod;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModGroups {
    public static final ItemGroup ITEM_GROUP;
    static {
        ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(ModMain.ID, "item_group"))
                .icon(() -> new ItemStack(ModItems.WRENCH))
                .build();
    }
    public static void initialize() {

    }
}
