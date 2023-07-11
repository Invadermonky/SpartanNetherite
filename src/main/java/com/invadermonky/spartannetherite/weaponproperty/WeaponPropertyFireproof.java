package com.invadermonky.spartannetherite.weaponproperty;

import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.util.StringHelper;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class WeaponPropertyFireproof extends WeaponPropertyWithCallback {
    public WeaponPropertyFireproof(String propType, String propModId) {
        super(propType, propModId);
    }

    @Override
    protected void addTooltipDescription(ItemStack stack, List<String> tooltip) {
        if(GuiScreen.isShiftKeyDown()) {
            tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString(WeaponPropertySN.TYPE_FIREPROOF + ".desc", "tooltip", SpartanNetherite.MOD_ID));
        }
    }
}
