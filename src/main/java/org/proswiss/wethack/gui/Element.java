package org.proswiss.wethack.gui;

/**
 * Element - base abstract class for any gui element.
 *
 * @Author zyktex
 */
public abstract class Element {
    protected final String name;

    protected float posX;
    protected float posY;

    protected float lastPosX;
    protected float lastPosY;

    protected final float width;
    protected final float height;

    protected boolean dragging;
    protected boolean extended;

    /**
     *
     * @param name Name of the element
     * @param posX Starting X position of the element
     * @param posY Starting Y position of the element
     * @param width Width of the element
     * @param height Height of element
     */
    public Element(String name, float posX, float posY, float width, float height) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    /**
     * Called every time screen is rendered
     * Mouse variables are used if the element is in dragging mode to set it's new position
     *
     * @param mouseX where the mouse X is
     * @param mouseY where the mouse Y is
     */
    public void render(int mouseX, int mouseY) {
    }

    public void onMouseClicked(int mouseX, int mouseY, int mouseButton) {
    }

    public void onMouseReleased(int mouseX, int mouseY, int mouseButton) {
    }

    public String getName() {
        return this.name;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getPosX() {
        return this.posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return this.posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getLastPosX() {
        return this.lastPosX;
    }

    public void setLastPosX(float lastPosX) {
        this.lastPosX = lastPosX;
    }

    public float getLastPosY() {
        return this.lastPosY;
    }

    public void setLastPosY(float lastPosY) {
        this.lastPosY = lastPosY;
    }

    /**
     * @return boolean if element in dragging mode
     */
    public boolean isDragging() {
        return this.dragging;
    }

    /**
     * Allows dragging gui elements to enter dragging mode
     * When in dragging mode, they will follow the mouse
     *
     * @param dragging if the element is being dragged
     */
    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    /**
     * @return boolean if element is extended
     */
    public boolean isExtended() {
        return this.extended;
    }

    /**
     * This sets the element to extended mode
     * If the element is a frame, it shows it's components
     * And if it's a component, it shows it's sub-components
     *
     * @param extended if the element is extended
     */
    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    /**
     * This checks if the mouse is within the element's bounds
     *
     * @param mouseX current X position of mouse
     * @param mouseY current Y position of mouse
     * @param x starting X of element
     * @param y starting Y of element
     * @param width width of element
     * @param height height of element
     *
     * @return boolean if the mouse is inside specified bounds or not
     */
    public boolean mouseWithinBounds(int mouseX, int mouseY, double x, double y, double width, double height) {
        return (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height);
    }
}
