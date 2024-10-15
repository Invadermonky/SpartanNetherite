package com.invadermonky.spartannetherite.item.weapons;

import com.invadermonky.futurefireproof.api.IFireproofItem;
import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.item.materials.ToolMaterialsSN;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import com.oblivioussp.spartanweaponry.client.gui.CreativeTabsSW;
import com.oblivioussp.spartanweaponry.item.ItemRapier;

public class ItemRapierSN extends ItemRapier implements IFireproofItem {
    public ItemRapierSN() {
        super(LibNames.rapier_netherite, SpartanNetherite.MOD_ID, ToolMaterialsSN.materialex_netherite);
        this.setCreativeTab(CreativeTabsSW.TAB_SW_MOD);
    }
}
