package nl.devv.tech.testmod.item;

import net.devtech.arrp.api.RuntimeResourcePack;
import static net.devtech.arrp.json.models.JModel.*;
import net.minecraft.util.Identifier;
import nl.devv.tech.testmod.util.ItemGeneratable;
import nl.devv.tech.testmod.ModMain;


public class ResourceItem extends ItemGeneratable {

    public ResourceItem(Settings settings) {
        super(settings);
    }

    @Override
    public void generateItemModel(RuntimeResourcePack pack, Identifier id) {
        Identifier path = ModMain.prefixID(id, "item");
        pack.addModel(model("item/generated")
        .textures(textures()
        .layer0(path.toString()))
                , path);
    }
    
}
