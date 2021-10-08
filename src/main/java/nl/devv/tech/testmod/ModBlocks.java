package nl.devv.tech.testmod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block BRICK;
    // public static final Block RESOURCE_TEST;

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, ModMain.id(id), block);
    }

    static {
        BRICK = register("brick", new Block(FabricBlockSettings.of(Material.METAL).strength(4F, 0.2F)));
        // RESOURCE_TEST = register("resource_test",
        //         new ResourceTestBlock(FabricBlockSettings.of(Material.METAL).strength(3F, 2F)));
    }
    public static void initialize() {

    }
}
