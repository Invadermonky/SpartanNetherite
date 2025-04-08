package com.invadermonky.spartannetherite.util.libs;

import com.invadermonky.spartannetherite.util.ModHelper;
import com.oblivioussp.spartanshields.util.Reference;
import com.oblivioussp.spartanweaponry.ModSpartanWeaponry;
import mezz.jei.config.Constants;
import thedarkcolour.futuremc.FutureMC;

import javax.annotation.Nullable;

public enum ModIds {
    futuremc(ConstIds.futuremc),
    jei(ConstIds.jei),
    nether_backport(ConstIds.nether_backport),
    spartan_shields(ConstIds.spartan_shields),
    spartan_weaponry(ConstIds.spartan_weaponry, ConstVersions.spartan_weaponry, true, false);

    public final String modId;
    public final boolean isLoaded;

    ModIds(String modId, @Nullable String version, boolean minVersion, boolean maxVersion) {
        this.modId = modId;
        this.isLoaded = ModHelper.isModLoaded(modId, version, minVersion, maxVersion);
    }

    ModIds(String modId, @Nullable String version) {
        this.modId = modId;
        this.isLoaded = ModHelper.isModLoaded(modId, version);
    }

    ModIds(String modId) {
        this(modId, null);
    }

    public static class ConstIds {
        public static final String futuremc = FutureMC.ID;
        public static final String jei = Constants.MOD_ID;
        public static final String nether_backport = "nb";//TODO: Figure out why this isn't loading.
        public static final String spartan_shields = Reference.ModID;
        public static final String spartan_weaponry = ModSpartanWeaponry.ID;
    }

    public static class ConstVersions {
        public static final String spartan_weaponry = "1.6.0";
    }
}
