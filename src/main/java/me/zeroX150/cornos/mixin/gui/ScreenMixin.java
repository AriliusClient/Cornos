/*
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# Project: Cornos
# File: ScreenMixin
# Created by constantin at 09:56, Mär 12 2021
PLEASE READ THE COPYRIGHT NOTICE IN THE PROJECT ROOT, IF EXISTENT
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
*/
package me.zeroX150.cornos.mixin.gui;

import me.zeroX150.cornos.Cornos;
import me.zeroX150.cornos.etc.config.Colors;
import me.zeroX150.cornos.gui.screen.MainScreen;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "renderBackgroundTexture", at = @At("HEAD"), cancellable = true)
    public void renderBG(int vOffset, CallbackInfo ci) {
        Cornos.minecraft.getTextureManager().bindTexture(new Identifier("ccl", "bg.jpg"));
        int width = Cornos.minecraft.getWindow().getScaledWidth();
        int height = Cornos.minecraft.getWindow().getScaledHeight();
        DrawableHelper.drawTexture(new MatrixStack(), 0, 0, 0, 0, 0, width, height, height, width);
        if (!(Cornos.minecraft.currentScreen instanceof MainScreen)) {

            DrawableHelper.fill(new MatrixStack(), 0, 0, width, height, Colors.GUIBACKGROUND.get().getRGB());
        }
        ci.cancel();
    }
}
