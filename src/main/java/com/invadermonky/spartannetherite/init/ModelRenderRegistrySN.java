package com.invadermonky.spartannetherite.init;

import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.util.LogHelper;
import com.invadermonky.spartannetherite.util.ModHelper;
import com.invadermonky.spartannetherite.util.StringHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = SpartanNetherite.MOD_ID)
public class ModelRenderRegistrySN {
    @SubscribeEvent
    public static void registerItemRenders(ModelRegistryEvent event) {
        if(ModHelper.isSpartanShieldsLoaded()) {
            registerItemRender(ItemRegistrySN.shieldNetherite);
            registerItemRender(ItemRegistrySN.shieldTowerNetherite);
        }
    }

    public static void registerItemRender(Item item) {
        if(item == null)
            return;
        LogHelper.debug("Registering model of item: " + StringHelper.stripUnlocalizedName(item.getTranslationKey()));
        ModelResourceLocation modelLoc = new ModelResourceLocation(StringHelper.stripUnlocalizedName(item.getTranslationKey()), "inventory");
        LogHelper.debug("Model Location: " + modelLoc);
        ModelLoader.setCustomModelResourceLocation(item, 0, modelLoc);
    }
}
