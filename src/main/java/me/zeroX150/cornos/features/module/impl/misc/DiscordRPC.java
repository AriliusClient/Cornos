/*
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# Project: Cornos
# File: DiscordRPC
# Created by constantin at 08:47, Mär 02 2021
PLEASE READ THE COPYRIGHT NOTICE IN THE PROJECT ROOT, IF EXISTENT
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
*/
package me.zeroX150.cornos.features.module.impl.misc;

import me.zeroX150.cornos.etc.DiscordRPCMan;
import me.zeroX150.cornos.features.module.Module;

public class DiscordRPC extends Module {
    DiscordRPCMan instance = null;

    public DiscordRPC() {
        super("DiscordRPC", "Flex on others on discord");
    }

    @Override
    public void onEnable() {
        instance = new DiscordRPCMan();
        super.onEnable();
    }

    @Override
    public String getContext() {
        return instance == null ? "" : instance.contextPasser;
    }

    @Override
    public void onExecute() {
        if (instance == null)
            onEnable();
        super.onExecute();
    }

    @Override
    public void onDisable() {
        if (instance != null)
            instance.shutdown();
        super.onDisable();
    }
}
