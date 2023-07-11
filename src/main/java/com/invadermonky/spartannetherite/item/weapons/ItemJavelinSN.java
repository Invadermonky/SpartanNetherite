package com.invadermonky.spartannetherite.item.weapons;

import com.invadermonky.spartannetherite.SpartanNetherite;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.client.gui.CreativeTabsSW;
import com.oblivioussp.spartanweaponry.item.ItemJavelin;
import net.minecraft.entity.FireproofItemLogic;
import net.minecraft.entity.item.EntityItem;

public class ItemJavelinSN extends ItemJavelin {
    public ItemJavelinSN(String unlocName, ToolMaterialEx material) {
        super(unlocName, SpartanNetherite.MOD_ID, material);
        this.setCreativeTab(CreativeTabsSW.TAB_SW_MOD);
    }

    @Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {
        FireproofItemLogic.INSTANCE.update(entityItem);
        return true;
    }
}
