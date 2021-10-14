package nl.devv.tech.testmod;

import java.util.function.Consumer;

import net.devtech.arrp.api.RuntimeResourcePack;

public class ModResources {
    private static Consumer<RuntimeResourcePack> server, client;
    
    public static RuntimeResourcePack initialize(String id) {
        final RuntimeResourcePack handler = RuntimeResourcePack.create(id);
		if (server != null) {
			server.accept(handler);
		}
        if (ModMain.IS_CLIENT) {
            if (client != null) {
                client.accept(handler);
            }
        }
        return handler;
	}

	public static void registerServer(Consumer<RuntimeResourcePack> consumer) {
		if (server == null) {
			server = consumer;
		} else {
			server = server.andThen(consumer);
		}
	}

	public static void registerClient(Consumer<RuntimeResourcePack> consumer) {
		if (ModMain.IS_CLIENT) {
			if (client == null) {
				client = consumer;
			} else {
				client = client.andThen(consumer);
			}
		}
	}
}
