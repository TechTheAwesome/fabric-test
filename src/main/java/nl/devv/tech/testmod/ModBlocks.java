package nl.devv.tech.testmod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import nl.devv.tech.testmod.block.ResourceBlock;
import nl.devv.tech.testmod.util.BlockGeneratable;

public class ModBlocks {
    public static final Block BRICK;
    public static final Block RESOURCE_TEST;

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, ModMain.id(id), block);
    }
    
    private static Block register(String id, BlockGeneratable block) {
        Identifier identifier = ModMain.id(id);
        ModResource.registerClient(p -> block.client(p, identifier));
        ModResource.registerServer(p -> block.server(p, identifier));
        return Registry.register(Registry.BLOCK, identifier, block);
    }

    static {
        BRICK = register("brick", new Block(FabricBlockSettings.of(Material.METAL).strength(4F, 0.2F)));
        RESOURCE_TEST = register("resource_test", new ResourceBlock(FabricBlockSettings.of(Material.METAL).strength(3F, 2F)));
    }
    public static void initialize() {
    }
}
