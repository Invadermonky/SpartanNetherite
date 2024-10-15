package com.invadermonky.spartannetherite.item.shields;

import com.invadermonky.futurefireproof.api.IFireproofItem;
import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.item.materials.ToolMaterialsSN;
import com.invadermonky.spartannetherite.util.StringHelper;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import com.oblivioussp.spartanshields.item.ItemShieldExtraMaterial;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
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

    public ItemShieldSN(String unlocName) {
        this.unlocalizedName = unlocName;
        this.durability = 3554;
        this.material = ToolMaterialsSN.netherite;
        this.repairMaterial = LibNames.netherite_ingot;
    }

    public ItemShield create() {
        class ItemShieldExtraMaterialSN extends ItemShieldExtraMaterial implements IFireproofItem {
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
                tooltip.add(TextFormatting.GREEN + "- " + StringHelper.translateString(LibNames.fireproof, "tooltip", SpartanNetherite.MOD_ID));
                if(GuiScreen.isShiftKeyDown()) {
                    tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString(LibNames.fireproof + ".desc", "tooltip", SpartanNetherite.MOD_ID));
                }
            }
        }

        return new ItemShieldExtraMaterialSN(this.unlocalizedName, this.durability, this.material, this.repairMaterial);
    }
}
