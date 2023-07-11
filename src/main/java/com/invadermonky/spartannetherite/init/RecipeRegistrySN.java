package com.invadermonky.spartannetherite.init;

import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.util.LogHelper;
import com.invadermonky.spartannetherite.util.ModHelper;
import com.oblivioussp.spartanshields.item.crafting.RecipeShieldBanners;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = SpartanNetherite.MOD_ID)
public class RecipeRegistrySN {
    @SubscribeEvent
    public static void addRecipes(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> registry = event.getRegistry();
        if(ModHelper.isSpartanShieldsLoaded()) {
            registry.register((new RecipeShieldBanners(ItemRegistrySN.shieldTowerNetherite)).setRegistryName(new ResourceLocation(SpartanNetherite.MOD_ID, "shield_banner_netherite")));
        }
        LogHelper.info("Recipes added.");
    }
}
