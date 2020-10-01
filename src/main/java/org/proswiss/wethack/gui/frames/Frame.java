package org.proswiss.wethack.gui.frames;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.proswiss.wethack.gui.Element;
import org.proswiss.wethack.gui.components.Component;

import java.util.ArrayList;

/**
 * Frame - base class for frames - frames can contain components, and have support for scrolling
 *
 * @Author zyktex
 */
public abstract class Frame extends Element {
    private final ArrayList<Component> components = new ArrayList<>();

    private int scrollY;

    public Frame(String name, float posX, float posY, float width, float height) {
        super(name, posX, posY, width, height);
    }

    public void initialize() {
        this.components.forEach(Component::initialize); // java 8 expression
    }

    public void moved(float posX, float posY) {
        this.components.forEach(component -> component.onMove(posX, posY));
    }

    /**
     *
     * This method is meant to be overwritten. The base method only contains bounds checks and dragging handling
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());

        // Handle dragging
        if (isDragging()) {
            setPosX(mouseX + getLastPosX());
            setPosY(mouseY + getLastPosY());
            getComponents().forEach(component -> component.onMove(getPosX(), getPosY() + getScrollY()));
        }

        // Check if within screen bounds (to make sure gui isn't moved outside of the screen)
        if (getPosX() < 0.0F) {
            setPosX(0.0F);
            getComponents().forEach(component -> component.onMove(getPosX(), getPosY() + getScrollY()));
        }
        if (getPosX() + getWidth() > scaledResolution.getScaledWidth()) {
            setPosX(scaledResolution.getScaledWidth() - getWidth());
            getComponents().forEach(component -> component.onMove(getPosX(), getPosY() + getScrollY()));
        }
        if (getPosY() < 0.0F) {
            setPosY(0.0F);
            getComponents().forEach(component -> component.onMove(getPosX(), getPosY() + getScrollY()));
        }
        if (getPosY() + getHeight() > scaledResolution.getScaledHeight()) {
            setPosY(scaledResolution.getScaledHeight() - getHeight());
            getComponents().forEach(component -> component.onMove(getPosX(), getPosY() + getScrollY()));
        }
    }

    // These methods below handle

    public void keyTyped(char character, int keyCode) {
        if (isExtended())
            getComponents().forEach(component -> component.onKeyTyped(character, keyCode));
    }

    public void onMouseClicked(int mouseX, int mouseY, int mouseButton) {
        boolean hovered = mouseWithinBounds(mouseX, mouseY, getPosX(), getPosY(), getWidth(), getHeight());
        switch (mouseButton) {
            case 0:
                if (hovered) {
                    setDragging(true);
                    setLastPosX(getPosX() - mouseX);
                    setLastPosY(getPosY() - mouseY);
                }
                break;
            case 1:
                if (hovered)
                    setExtended(!isExtended());
                break;
        }
    }

    public void onMouseReleased(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && isDragging())
            setDragging(false);
        if (isExtended())
            getComponents().forEach(component -> component.onMouseReleased(mouseX, mouseY, mouseButton));
    }

    public ArrayList<Component> getComponents() {
        return this.components;
    }

    public int getScrollY() {
        return this.scrollY;
    }

    public void setScrollY(int scrollY) {
        this.scrollY = scrollY;
    }
}
