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
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Collections;

@JEIPlugin
public class JeiCompat implements IModPlugin {
    @Override
    public void register(IModRegistry registry) {
        if(CommonProxy.loadAnvilRecipes()) {
            ArrayList<IRecipeWrapper> recipes = new ArrayList<>(ModRecipesSN.recipeAssociations.keySet().size());
            ModRecipesSN.recipeAssociations.forEach((inputItem,outputStack) -> {
                recipes.add(registry.getJeiHelpers().getVanillaRecipeFactory().createAnvilRecipe(new ItemStack(inputItem), OreDictionary.getOres(LibNames.netherite_ingot), Collections.singletonList(outputStack)));
            });
            registry.addRecipes(recipes, VanillaRecipeCategoryUid.ANVIL);
            registry.addIngredientInfo(Lists.newArrayList(ModRecipesSN.recipeAssociations.values()), VanillaTypes.ITEM, "jei." + SpartanNetherite.MOD_ID + ":anvil_craft.info");
        }
    }
}
