package com.invadermonky.spartannetherite.item.shields;

import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.util.StringHelper;
import com.invadermonky.spartannetherite.weaponproperty.WeaponPropertySN;
import com.oblivioussp.spartanshields.item.ItemShieldExtraMaterial;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.FireproofItemLogic;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemShieldSN {
    protected final String unlocalizedName;
    protected final int durability;
    protected final ToolMaterial material;
    protected final String repairMaterial;

    public ItemShieldSN(String unlocName, int maxDamage, ToolMaterial toolMaterial, String materialOreDictName) {
        this.unlocalizedName = unlocName;
        this.durability = maxDamage;
        this.material = toolMaterial;
        this.repairMaterial = materialOreDictName;
    }

    public ItemShield create() {
        class ItemShieldExtraMaterialSN extends ItemShieldExtraMaterial {
            protected final String unlocalizedName;

            public ItemShieldExtraMaterialSN(String unlocName, int maxDamage, ToolMaterial toolMaterial, String materialOreDictName) {
                super(unlocName, maxDamage, toolMaterial, materialOreDictName);
                this.unlocalizedName = unlocName;
            }

            @Override
            public String getTranslationKey() {
                return StringHelper.getItemUnlocalizedName(unlocalizedName, SpartanNetherite.MOD_ID);
            }

            @Override
            public String getTranslationKey(ItemStack itemStack) {
                return StringHelper.getItemUnlocalizedName(unlocalizedName, SpartanNetherite.MOD_ID);
            }

            @Override
            public void addEffectsTooltip(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
                tooltip.add(TextFormatting.AQUA + StringHelper.translateString("materialbonus", "tooltip", SpartanNetherite.MOD_ID) + ":");
                tooltip.add(TextFormatting.GREEN + "- " + StringHelper.translateString(WeaponPropertySN.TYPE_FIREPROOF, "tooltip", SpartanNetherite.MOD_ID));
                if(GuiScreen.isShiftKeyDown()) {
                    tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString(WeaponPropertySN.TYPE_FIREPROOF + ".desc", "tooltip", SpartanNetherite.MOD_ID));
                }
            }

            @Override
            public boolean onEntityItemUpdate(EntityItem entityItem) {
                FireproofItemLogic.INSTANCE.update(entityItem);
                return true;
            }
        }

        return new ItemShieldExtraMaterialSN(this.unlocalizedName, this.durability, this.material, this.repairMaterial);
    }
}
