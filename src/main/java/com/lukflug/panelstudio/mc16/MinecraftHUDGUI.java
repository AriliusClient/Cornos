package com.lukflug.panelstudio.mc16;

import com.lukflug.panelstudio.ClickGUI;
import com.lukflug.panelstudio.hud.HUDClickGUI;
import net.minecraft.client.MinecraftClient;

/**
 * Class designed for GUIs with HUDs.
 *
 * @author lukflug
 */
public abstract class MinecraftHUDGUI extends MinecraftGUI {
    protected boolean hudEditor = false;

    @Override
    public void enterGUI() {
        hudEditor = false;
        super.enterGUI();
    }

    @Override
    public void onClose() {
        hudEditor = false;
        super.onClose();
    }

    /**
     * Open the HUD editor.
     */
    public void enterHUDEditor() {
        hudEditor = true;
        if (getHUDGUI().isOn())
            getHUDGUI().toggle();
        MinecraftClient.getInstance().openScreen(this);
    }

    /**
     * Render function to be called when the GUI is closed to render the HUD.
     */
    public void render() {
        if (!getHUDGUI().isOn() && !hudEditor)
            renderGUI();
    }

    /**
     * Key event function to be called when the GUI is closed.
     *
     * @param scancode the key scancode
     */
    public void handleKeyEvent(int scancode) {
        if (scancode != 1 && !getHUDGUI().isOn() && !hudEditor)
            getHUDGUI().handleKey(scancode);
    }

    /**
     * Get the {@link HUDClickGUI} to be rendered.
     *
     * @return current ClickGUI
     */
    protected abstract HUDClickGUI getHUDGUI();

    @Override
    protected ClickGUI getGUI() {
        return getHUDGUI();
    }
}
