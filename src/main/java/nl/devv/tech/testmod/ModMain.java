package nl.devv.tech.testmod;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.Identifier;

public class ModMain implements ModInitializer {
    //Global mod variables
	public static final String MOD_ID = "testmod";

	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        ModGroups.initialize();
        ModBlocks.initialize();
		ModItems.initialize();
	}
}