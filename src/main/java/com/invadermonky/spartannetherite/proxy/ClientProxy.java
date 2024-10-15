package com.invadermonky.spartannetherite.proxy;

import com.invadermonky.spartannetherite.client.model.ModelShieldTowerSN;
import com.invadermonky.spartannetherite.client.render.item.TileEntityItemStackRendererSN;
import com.invadermonky.spartannetherite.registry.ModItemsSN;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import net.minecraft.client.model.ModelShield;
import net.minecraft.item.ItemShield;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void init(FMLInitializationEvent event) {
        setShieldTEISR(ModItemsSN.shield_tower_netherite, LibNames.shield_tower_netherite, "S_NETHERITE", new ModelShieldTowerSN());
    }

    private static void setShieldTEISR(ItemShield shield, String textureName, String bannerID, ModelShield model) {
        if(shield == null){
            return;
        }
        shield.setTileEntityItemStackRenderer(new TileEntityItemStackRendererSN(shield, String.format("textures/entity/%s_nopattern.png", textureName),
                String.format("textures/entity/%s_pattern.png",  textureName), bannerID, model));
    }
}
