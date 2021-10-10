package nl.devv.tech.testmod;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.Identifier;

public class ModMain implements ModInitializer {
	//Global mod variables
	public static final String MOD_ID = "testmod";
	public static final boolean IS_CLIENT = FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;

	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}

	public static Identifier id(String namespace, String id) {
		return new Identifier(namespace, id);
	}

	public static Identifier prefixID(Identifier id, String prefix) {
		return new Identifier(id.getNamespace(), prefix + '/' + id.getPath());
	}
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger Debug = LogManager.getLogger(MOD_ID);
	public static RuntimeResourcePack RESOURCE_PACK;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModGroups.initialize();
		ModBlocks.initialize();
		ModItems.initialize();

		RESOURCE_PACK = ModResource.initialize("test_resource_pack");
		RRPCallback.AFTER_VANILLA.register(a -> a.add(RESOURCE_PACK));
	}
}