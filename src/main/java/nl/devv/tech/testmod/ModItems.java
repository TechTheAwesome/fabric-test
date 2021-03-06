package nl.devv.tech.testmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nl.devv.tech.testmod.item.ResourceItem;
import nl.devv.tech.testmod.util.ItemGeneratable;

public class ModItems {
    public static final Item WRENCH;
    public static final Item BRICK;
    public static final Item RESOURCE_TEST;
    public static final Item ITEM_TEST;

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, ModMain.id(id), item);
    }

    private static Item register(Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, Registry.BLOCK.getId(block),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    
    private static Item register(String id, ItemGeneratable item) {
        Identifier identifier = ModMain.id(id);
        ModResource.registerClient(p -> item.client(p, identifier));
        ModResource.registerServer(p -> item.server(p, identifier));
        return Registry.register(Registry.ITEM, identifier, item);
    }

    static {
        WRENCH = register("wrench", new Item(new FabricItemSettings().group(ModGroups.ITEM_GROUP)));
        BRICK = register(ModBlocks.BRICK, ModGroups.ITEM_GROUP);
        RESOURCE_TEST = register(ModBlocks.RESOURCE_TEST, ModGroups.ITEM_GROUP);
        ITEM_TEST = register("item_test", new ResourceItem(new FabricItemSettings().group(ModGroups.ITEM_GROUP)));
    }

    public static void initialize() {

    }
}
