package com.invadermonky.spartannetherite.item.materials;

import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import com.oblivioussp.spartanweaponry.api.IWeaponCallback;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterialsSN {
    public static Item.ToolMaterial netherite = EnumHelper.addToolMaterial(LibNames.netherite, 4, 2031, 9.0f, 4.0f, 15);
    public static final WeaponProperty fireproof = new WeaponPropertyFireproof(LibNames.fireproof, SpartanNetherite.MOD_ID);
    public static final ToolMaterialEx materialex_netherite = new ToolMaterialEx(LibNames.netherite, netherite, LibNames.netherite_ingot, SpartanNetherite.MOD_ID, netherite.getAttackDamage(), fireproof);
    public static final IWeaponCallback callback_netherite = new WeaponCallbackFireproof();
}
