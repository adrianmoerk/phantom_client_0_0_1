package net.phantom_client.client.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY = "key.categories.phantom_client";
    public static final String KEY_TOGGLE_GUI = "key.phantom_client.toggle_gui";
    public static final String KEY_TOGGLE_FLIGHT = "key.phantom_client.toggle_flight";
    public static KeyBinding toggleGui;
    public static KeyBinding flightKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                if (flightKey.wasPressed()) {
                    client.player.getAbilities().flying = !client.player.getAbilities().flying;

                }
                if (toggleGui.wasPressed()) {
                    if (client.player != null) {
                        client.player.sendMessage(Text.of("Hello World!"));
                    }
                }
            }
        });
    }

    public static void register() {
        flightKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_TOGGLE_FLIGHT, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F, KEY_CATEGORY));
        toggleGui = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_TOGGLE_GUI, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, KEY_CATEGORY));
        registerKeyInputs();
    }
}
