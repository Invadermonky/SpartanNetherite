package com.invadermonky.spartannetherite.compat;

import com.google.common.collect.Lists;
import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.proxy.CommonProxy;
import com.invadermonky.spartannetherite.registry.ModRecipesSN;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

@JEIPlugin
public class JeiCompat implements IModPlugin {
    @Override
    public void register(@NotNull IModRegistry registry) {
        if (CommonProxy.loadAnvilRecipes()) {
            ArrayList<IRecipeWrapper> recipes = new ArrayList<>(ModRecipesSN.recipeAssociations.size());
            if (OreDictionary.doesOreNameExist(LibNames.netherite_ingot)) {
                for (Map.Entry<Item, ItemStack> entry : ModRecipesSN.recipeAssociations.entrySet()) {
                    recipes.add(registry.getJeiHelpers().getVanillaRecipeFactory().createAnvilRecipe(
                            new ItemStack(entry.getKey()),
                            OreDictionary.getOres(LibNames.netherite_ingot),
                            Collections.singletonList(entry.getValue()))
                    );
                }
                registry.addRecipes(recipes, VanillaRecipeCategoryUid.ANVIL);
                registry.addIngredientInfo(Lists.newArrayList(ModRecipesSN.recipeAssociations.values()), VanillaTypes.ITEM, "jei." + SpartanNetherite.MOD_ID + ":anvil_craft.info");
            }
        }
    }
}
