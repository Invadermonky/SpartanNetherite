package com.invadermonky.spartannetherite.item.materials;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class NetheriteMaterial {
    public static Item.ToolMaterial NETHERITE = EnumHelper.addToolMaterial(
            "NETHERITE",
            4,
            2031,
            9.0f,
            4.0f,
            15
    );
}
