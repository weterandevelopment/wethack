package org.proswiss.wethack.gui.components;

import net.minecraft.client.Minecraft;
import org.proswiss.wethack.setting.BooleanSetting;
import org.proswiss.wethack.util.RenderHelper;

/**
 * Boolean setting component for GUI
 *
 * @author zyktex
 */
public class BooleanSettingComponent extends Component {
    private final BooleanSetting booleanSetting;

    // Check Component for details on params
    public BooleanSettingComponent(BooleanSetting booleanSetting, float posX, float posY, float offsetX, float offsetY, float width, float height) {
        super(booleanSetting.getName(), posX, posY, offsetX, offsetY, width, height);
        this.booleanSetting = booleanSetting;
    }

    // We need to implement this but we don't have to do anything here
    public void initialize() {}


    public void drawComponent(int mouseX, int mouseY, float partialTicks) {
        super.drawComponent(mouseX, mouseY, partialTicks);
        RenderHelper.drawRect(getFinishedX(), getFinishedY(), getWidth(), getHeight(), 0x3F303030);

        // Depending on if it's enabled or not, we either draw white/grey text (with the setting's name)
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(getName(), (getFinishedX() + 5.0F), (getFinishedY() + getHeight() / 2.0F - (Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT / 2)), (getBooleanSetting().getValue()) ? 0xFFFFFFFF : 0xFFAAAAAA);
    }

    // This method toggles the boolean setting when we click our mouse (within the component's bounds)
    public void onMouseClicked(int mouseX, int mouseY, int mouseButton) {
        super.onMouseClicked(mouseX, mouseY, mouseButton);
        boolean hovered = mouseWithinBounds(mouseX, mouseY, getFinishedX(), getFinishedY(), getWidth(), getHeight());
        if (hovered && mouseButton == 0)
            getBooleanSetting().setValue(!(getBooleanSetting().getValue()).booleanValue());
    }

    public BooleanSetting getBooleanSetting() {
        return this.booleanSetting;
    }
}
