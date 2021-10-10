package nl.devv.tech.testmod.util;

import net.devtech.arrp.api.RuntimeResourcePack;
import net.minecraft.util.Identifier;

public interface IResourceGeneratable {
    interface Item extends IResourceGeneratable{
        @Override
		default void client(RuntimeResourcePack pack, Identifier id) {
			this.generateItemModel(pack, id);
		}

		void generateItemModel(RuntimeResourcePack pack, Identifier id);

		@Override
		default void server(RuntimeResourcePack pack, Identifier id) {
			//usually empty
		}
    }

	interface Block extends IResourceGeneratable {
		@Override
		default void client(RuntimeResourcePack pack, Identifier id) {
			this.generateBlockModel(pack, id);
			this.generateBlockState(pack, id);
			this.generateItemModel(pack, id);
			this.generateLang(pack, id);
		}

		void generateBlockState(RuntimeResourcePack pack, Identifier id);

		void generateBlockModel(RuntimeResourcePack pack, Identifier id);

		void generateItemModel(RuntimeResourcePack pack, Identifier id);

		void generateLang(RuntimeResourcePack pack, Identifier id);

		@Override
		default void server(RuntimeResourcePack pack, Identifier id) {
			this.generateLootTable(pack, id);
		}

		void generateLootTable(RuntimeResourcePack pack, Identifier id);

	}
	
	void client(RuntimeResourcePack pack, Identifier id);

	void server(RuntimeResourcePack pack, Identifier id);
}