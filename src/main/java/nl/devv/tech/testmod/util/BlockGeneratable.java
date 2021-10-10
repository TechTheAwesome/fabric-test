package nl.devv.tech.testmod.util;

import net.minecraft.block.Block;

public abstract class BlockGeneratable extends Block implements IResourceGeneratable.Block {

	public BlockGeneratable(Settings settings) {
		super(settings);
	}
};
