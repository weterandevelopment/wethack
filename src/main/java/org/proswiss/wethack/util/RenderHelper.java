package org.proswiss.wethack.util;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

/**
 * Contains static methods to renders shapes.
 * Using Minecraft's methods is also possible, but they require 4 values instead of width/height
 *
 * @author zyktex
 */
public class RenderHelper {

    /**
     *
     * @param x starting x
     * @param y starting y
     * @param w width of rectangle
     * @param h height of rectangle
     * @param color (fill) color of rectangle
     */
    public static void drawRect(float x, float y, float w, float h, int color) {
        // Get finished x/y (x/y + width/height)
        float finishedX = x + w;
        float finishedY = y + h;

        // Bit shift color
        float alpha = (color >> 24 & 0xFF) / 255.0F;
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;

        // Get tessellator/bufferBuilder instance
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();

        // Here we call certain methods, and set GL's color
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(red, green, blue, alpha);

        // We build rectangle in buffer, then draw
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(x, finishedY, 0.0D).endVertex(); // top left
        bufferBuilder.pos(finishedX, finishedY, 0.0D).endVertex(); // top right
        bufferBuilder.pos(finishedX, y, 0.0D).endVertex(); // bottom right
        bufferBuilder.pos(x, y, 0.0D).endVertex(); // bottom left
        tessellator.draw();

        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
}
