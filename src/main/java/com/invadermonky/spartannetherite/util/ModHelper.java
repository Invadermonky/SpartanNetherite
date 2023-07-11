package com.invadermonky.spartannetherite.util;

import net.minecraftforge.fml.common.Loader;

public class ModHelper {
    public static final String MOD_ID_SPARTANSHIELDS = "spartanshields";

    protected static boolean loadedSpartanShields = false;

    public static void preInit() {
        loadedSpartanShields = Loader.isModLoaded(MOD_ID_SPARTANSHIELDS);
    }

    public static boolean isSpartanShieldsLoaded() {
        return loadedSpartanShields;
    }
}
