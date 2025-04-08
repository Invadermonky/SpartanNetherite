package com.invadermonky.spartannetherite.proxy;

import com.invadermonky.spartannetherite.config.ConfigHandlerSN;
import com.invadermonky.spartannetherite.events.AnvilEventHandler;
import com.invadermonky.spartannetherite.util.libs.ModIds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thedarkcolour.futuremc.config.FConfig;

public class CommonProxy {
    public static boolean loadAnvilRecipes() {
        if (ModIds.futuremc.isLoaded) {
            return !FConfig.INSTANCE.getVillageAndPillage().smithingTable.enabled || ConfigHandlerSN.forceLoadAnvilRecipes;
        } else {
            return ConfigHandlerSN.anvilRecipes;
        }
    }

    public void preInit(FMLPreInitializationEvent event) {
        if (loadAnvilRecipes()) {
            MinecraftForge.EVENT_BUS.register(new AnvilEventHandler());
        }
    }

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {}
}
