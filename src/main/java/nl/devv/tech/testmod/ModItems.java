package nl.devv.tech.testmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item WRENCH;
    public static final Item BRICK;

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ModMain.ID, id), item);
    }

    private static Item register(Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, Registry.BLOCK.getId(block), new BlockItem(block, new FabricItemSettings().group(group))); 
    }

    static {
        WRENCH = register("wrench", new Item(new FabricItemSettings().group(ModGroups.ITEM_GROUP)));
        BRICK = register(ModBlocks.BRICK, ModGroups.ITEM_GROUP);
    }

    public static void initialize() {

    }
}
