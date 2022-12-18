package net.phantom_client.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.client.MinecraftClient;
import net.phantom_client.client.event.KeyInputHandler;

@Environment(EnvType.CLIENT)
public class PhantomClient implements ClientModInitializer {
    public static final String MOD_ID = "Phantom_client";

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
