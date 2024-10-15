package com.invadermonky.spartannetherite.item.weapons;

import com.invadermonky.futurefireproof.api.IFireproofItem;
import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.item.materials.ToolMaterialsSN;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import com.oblivioussp.spartanweaponry.client.gui.CreativeTabsSW;
import com.oblivioussp.spartanweaponry.item.ItemLongsword;

public class ItemLongswordSN extends ItemLongsword implements IFireproofItem {
    public ItemLongswordSN() {
        super(LibNames.longsword_netherite, SpartanNetherite.MOD_ID, ToolMaterialsSN.materialex_netherite);
        this.setCreativeTab(CreativeTabsSW.TAB_SW_MOD);
    }
}
