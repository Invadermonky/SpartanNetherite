package com.invadermonky.spartannetherite.weaponproperty;

import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.util.StringHelper;
import com.oblivioussp.spartanweaponry.api.IWeaponCallback;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class WeaponCallbackFireproof implements IWeaponCallback {

    @Override
    public void onTooltip(ToolMaterialEx material, ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        tooltip.add(TextFormatting.AQUA + StringHelper.translateString("materialbonus", "tooltip", SpartanNetherite.MOD_ID) + ":");
        tooltip.add(TextFormatting.GREEN + "- " + StringHelper.translateString(WeaponPropertySN.TYPE_FIREPROOF, "tooltip", SpartanNetherite.MOD_ID));
        if(GuiScreen.isShiftKeyDown()) {
            tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString(WeaponPropertySN.TYPE_FIREPROOF + ".desc", "tooltip", SpartanNetherite.MOD_ID));
        }
    }
}
