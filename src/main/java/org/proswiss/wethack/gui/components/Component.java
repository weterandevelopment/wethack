package org.proswiss.wethack.gui.components;

import org.proswiss.wethack.gui.Element;

/**
 * Frame - base class for components - components are elements that can be contained in a frame
 * Each component has an offset relative to it's parent frame
 *
 * @Author zyktex
 */
public abstract class Component extends Element {
    private float finishedX;

    private float finishedY;

    private float offsetX;

    private float offsetY;

    /**
     *
     * @param label the name of the component
     * @param posX the component's posX
     * @param posY the component's posY
     * @param offsetX the component's X offset relative to it's parent frame
     * @param offsetY the component's Y offset relative to it's parent frame
     * @param width the component's width
     * @param height the component's height
     */
    public Component(String label, float posX, float posY, float offsetX, float offsetY, float width, float height) {
        super(label, posX, posY, width, height);
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.finishedX = posX + offsetX;
        this.finishedY = posY + offsetY;
    }

    public abstract void initialize();

    // Makes setting position cleaner, instead of having to call all 4 methods when handling dragging
    public void onMove(float posX, float posY) {
        setPosX(posX);
        setPosY(posY);
        setFinishedX(getPosX() + getOffsetX());
        setFinishedY(getPosY() + getOffsetY());
    }

    public void drawComponent(int mouseX, int mouseY, float partialTicks) {
    }

    public void onKeyTyped(char character, int keyCode) {
    }

    public void onMouseClicked(int mouseX, int mouseY, int mouseButton) {
    }

    public void onMouseReleased(int mouseX, int mouseY, int mouseButton) {
    }

    // Each compoent has an offset relative to it's frame, this makes math way easier
    // The finished x/y is the x/y plus the offset

    public float getFinishedX() {
        return this.finishedX;
    }

    public void setFinishedX(float finishedX) {
        this.finishedX = finishedX;
    }

    public float getFinishedY() {
        return this.finishedY;
    }

    public void setFinishedY(float finishedY) {
        this.finishedY = finishedY;
    }

    public float getOffsetX() {
        return this.offsetX;
    }

    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }
}
