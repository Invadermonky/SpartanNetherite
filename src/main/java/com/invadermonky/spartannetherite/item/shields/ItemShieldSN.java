package com.invadermonky.spartannetherite.item.shields;

import com.invadermonky.futurefireproof.api.IFireproofItem;
import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.item.materials.ToolMaterialsSN;
import com.invadermonky.spartannetherite.registry.ModItemsSN;
import com.invadermonky.spartannetherite.registry.ModRecipesSN;
import com.invadermonky.spartannetherite.util.StringHelper;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import com.oblivioussp.spartanshields.init.ItemRegistrySS;
import com.oblivioussp.spartanshields.item.ItemShieldExtraMaterial;
import com.oblivioussp.spartanshields.item.crafting.RecipeShieldBanners;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ItemShieldSN {
    private static ItemShieldSN instance;

    public static ItemShieldSN getInstance() {
        return instance == null ? instance = new ItemShieldSN() : instance;
    }

    public ItemShield create(String unlocName) {
        class ItemShieldExtraMaterialSN extends ItemShieldExtraMaterial implements IFireproofItem {
            protected final String unlocalizedName;

            public ItemShieldExtraMaterialSN() {
                super(unlocName, 3554, ToolMaterialsSN.netherite, LibNames.netherite_ingot);
                this.unlocalizedName = unlocName;
            }

            @Override
            public @NotNull String getTranslationKey() {
                return StringHelper.getItemUnlocalizedName(unlocalizedName, SpartanNetherite.MOD_ID);
            }

            @Override
            public @NotNull String getTranslationKey(ItemStack itemStack) {
                return StringHelper.getItemUnlocalizedName(unlocalizedName, SpartanNetherite.MOD_ID);
            }

            @Override
            public void addEffectsTooltip(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
                tooltip.add(TextFormatting.AQUA + StringHelper.translateString("materialbonus", "tooltip", SpartanNetherite.MOD_ID) + ":");
                tooltip.add(TextFormatting.GREEN + "- " + StringHelper.translateString(LibNames.fireproof, "tooltip", SpartanNetherite.MOD_ID));
                if (GuiScreen.isShiftKeyDown()) {
                    tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString(LibNames.fireproof + ".desc", "tooltip", SpartanNetherite.MOD_ID));
                }
            }
        }

        return new ItemShieldExtraMaterialSN();
    }

    public void addRecipes(IForgeRegistry<IRecipe> registry) {
        registry.register((new RecipeShieldBanners(ModItemsSN.shield_tower_netherite)).setRegistryName(new ResourceLocation(SpartanNetherite.MOD_ID, "shield_banner_netherite")));

        ModRecipesSN.addRecipeAssociation(ItemRegistrySS.shieldDiamond, ModItemsSN.shield_netherite);
        ModRecipesSN.addRecipeAssociation(ItemRegistrySS.shieldTowerDiamond, ModItemsSN.shield_tower_netherite);
    }
}
