package com.invadermonky.spartannetherite.config;

import com.invadermonky.spartannetherite.SpartanNetherite;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = SpartanNetherite.MOD_ID)
public class ConfigHandlerSN {
    @Config.RequiresMcRestart
    @Config.Name("Enable Anvil Recipes")
    @Config.Comment("Registers anvil recipes if Future MC is not installed.")
    public static boolean anvilRecipes = true;

    @Config.RequiresMcRestart
    @Config.Name("Enable Future MC Smithing")
    @Config.Comment("If Future MC is loaded, register Smithing Table netherite tool recipes.")
    public static boolean enableSmithingTableRecipes = true;

    @Config.RequiresMcRestart
    @Config.Name("Force Load Anvil Recipes")
    @Config.Comment("Force loads anvil crafting recipes even if Smithing Table Recipes are enabled.")
    public static boolean forceLoadAnvilRecipes = false;

    @Config.RequiresMcRestart
    @Config.Name("Netherite Material")
    public static NetheriteMaterialCategory netheriteMaterial = new NetheriteMaterialCategory();

    public static class NetheriteMaterialCategory {
        public int harvestLevel = 4;
        public int durability = 2031;
        public float efficiency = 9.0f;
        public float damage = 4.0f;
        public int enchantability = 15;
    }

    @Mod.EventBusSubscriber(modid = SpartanNetherite.MOD_ID)
    public static class ConfigChangeListener {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(SpartanNetherite.MOD_ID)) {
                ConfigManager.sync(SpartanNetherite.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}
