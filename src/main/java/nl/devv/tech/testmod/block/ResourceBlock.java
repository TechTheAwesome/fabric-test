package nl.devv.tech.testmod.block;

import net.minecraft.util.Identifier;
import nl.devv.tech.testmod.ModMain;
import nl.devv.tech.testmod.util.BlockGeneratable;

import static net.devtech.arrp.json.blockstate.JState.*;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JLootTable;

import static net.devtech.arrp.json.models.JModel.*;

import net.devtech.arrp.api.RuntimeResourcePack;

import static net.devtech.arrp.json.lang.JLang.*;

public class ResourceBlock extends BlockGeneratable {
    public ResourceBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void generateItemModel(RuntimeResourcePack pack, Identifier id) {
        pack.addModel(model().parent(ModMain.id("block/resource_test").toString()), ModMain.id("item/resource_test"));
    }

    @Override
    public void generateBlockState(RuntimeResourcePack pack, Identifier id) {
        pack.addBlockState(state(variant(JState.model(ModMain.id("block/resource_test")))), ModMain.id("resource_test"));

    }

    @Override
    public void generateBlockModel(RuntimeResourcePack pack, Identifier id) {
        pack.addModel(
            model().parent("block/cube_all")
            .textures(
                textures().var("all", ModMain.id("block/resource_test").toString())),
            ModMain.id("block/resource_test"));


    }

    @Override
    public void generateLootTable(RuntimeResourcePack pack, Identifier id) {
        pack.addLootTable(id,
			JLootTable.loot("minecraft:block")
			.pool(JLootTable.pool()
		    .rolls(1)
			.entry(JLootTable.entry()
			    .type("minecraft:item")
			    .name(id.toString()))
			    .condition(JLootTable.predicate("minecraft:survives_explosion"))));
    }

    @Override
    public void generateLang(RuntimeResourcePack pack, Identifier id) {
        pack.addLang(ModMain.id("en_us"), lang().entry("block.testmod.resource_test", "here we are!"));
    }


}