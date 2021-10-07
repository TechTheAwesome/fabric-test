package nl.devv.tech.testmod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block BRICK;

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(ModMain.ID, id), block);
    }

    static {
        BRICK = register("brick", new Block(FabricBlockSettings.of(Material.METAL).strength(4F, 0.2F)));
    }
    public static void initialize() {

    }
}
