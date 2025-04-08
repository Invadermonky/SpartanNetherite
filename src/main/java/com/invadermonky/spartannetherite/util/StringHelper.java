package com.invadermonky.spartannetherite.util;

import com.invadermonky.spartannetherite.SpartanNetherite;
import net.minecraft.util.text.TextComponentTranslation;

public class StringHelper {
    public static String getItemUnlocalizedName(String locName) {
        return getItemUnlocalizedName(locName, SpartanNetherite.MOD_ID);
    }

    public static String getItemUnlocalizedName(String locName, String modId) {
        return String.format("item.%s:%s", modId.toLowerCase(), stripUnlocalizedName(locName));
    }

    public static String stripUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public static String translateString(String unlocalizedStr, String type) {
        return translateString(unlocalizedStr, type, SpartanNetherite.MOD_ID);
    }

    public static String translateString(String unlocalizedStr, String type, String modIdStr) {
        String modId = modIdStr;
        if (modId == null || modId.isEmpty())
            modId = SpartanNetherite.MOD_ID;
        if (type == null || type.isEmpty())
            return new TextComponentTranslation(modId.toLowerCase() + ":" + unlocalizedStr).getFormattedText();
        return new TextComponentTranslation(String.format("%s.%s:%s", type, modId.toLowerCase(), unlocalizedStr)).getFormattedText();
    }

    public static String translateFormattedSTring(String unlocalizedStr, String type, Object... parameters) {
        return translateFormattedString(unlocalizedStr, type, SpartanNetherite.MOD_ID, parameters);
    }

    public static String translateFormattedString(String unlocalizedStr, String type, String modIdStr, Object... parameters) {
        String modId = modIdStr;
        if (modId == null || modId.isEmpty())
            modId = SpartanNetherite.MOD_ID;
        if (type == null || type.isEmpty())
            return new TextComponentTranslation(String.format(modId.toLowerCase() + ":" + unlocalizedStr, parameters)).getFormattedText();
        return new TextComponentTranslation(String.format(String.format("%s.%s:%s", type, modId.toLowerCase(), unlocalizedStr), parameters)).getFormattedText();
    }
}
