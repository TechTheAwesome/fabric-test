package nl.devv.tech.testmod.block;

import net.minecraft.util.Identifier;
import nl.devv.tech.testmod.ModMain;
import nl.devv.tech.testmod.util.BlockGeneratable;

import static net.devtech.arrp.json.blockstate.JState.*;
import net.devtech.arrp.json.blockstate.JState;
import static net.devtech.arrp.json.models.JModel.*;

import net.devtech.arrp.api.RuntimeResourcePack;

import static net.devtech.arrp.json.lang.JLang.*;

public class ResourceTestBlock extends BlockGeneratable {

    public ResourceTestBlock(Settings settings) {
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
        // TODO Auto-generated method stub

    }

    @Override
    public void generateLang(RuntimeResourcePack pack, Identifier id) {
        pack.addLang(ModMain.id("en_us"), lang().entry("block.testmod.resource_test", "here we are!"));
    }


}