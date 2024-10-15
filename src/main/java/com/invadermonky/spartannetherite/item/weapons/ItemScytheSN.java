package com.invadermonky.spartannetherite.item.weapons;

import com.invadermonky.futurefireproof.api.IFireproofItem;
import com.invadermonky.spartannetherite.item.materials.ToolMaterialsSN;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import com.oblivioussp.spartanweaponry.client.gui.CreativeTabsSW;
import com.oblivioussp.spartanweaponry.item.ItemScythe;

public class ItemScytheSN extends ItemScythe implements IFireproofItem {
    public ItemScytheSN() {
        super(LibNames.scythe_netherite, ToolMaterialsSN.materialex_netherite);
        this.setCreativeTab(CreativeTabsSW.TAB_SW_MOD);
    }
}
