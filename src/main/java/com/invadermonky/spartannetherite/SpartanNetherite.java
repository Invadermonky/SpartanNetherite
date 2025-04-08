package com.invadermonky.spartannetherite;

import com.invadermonky.spartannetherite.proxy.CommonProxy;
import com.invadermonky.spartannetherite.util.LogHelper;
import com.invadermonky.spartannetherite.util.libs.ModIds;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = SpartanNetherite.MOD_ID,
        name = SpartanNetherite.MOD_NAME,
        version = SpartanNetherite.MOD_VERSION,
        dependencies = SpartanNetherite.DEPENDENCIES,
        acceptedMinecraftVersions = SpartanNetherite.MC_VERSION
)
public class SpartanNetherite {

    public static final String MOD_ID = "spartannetherite";
    public static final String MOD_NAME = "Spartan Netherite";
    public static final String MOD_VERSION = "1.2.1";
    public static final String MC_VERSION = "[1.12.2]";
    public static final String DEPENDENCIES =
            "required-after:" + ModIds.ConstIds.spartan_weaponry + "@[" + ModIds.ConstVersions.spartan_weaponry + ",)" +
                    ";required-after:futurefireproof" +
                    ";after:" + ModIds.ConstIds.futuremc +
                    ";after:" + ModIds.ConstIds.jei +
                    ";after:" + ModIds.ConstIds.nether_backport +
                    ";after:" + ModIds.ConstIds.spartan_shields;

    public static final String ProxyClientClass = "com.invadermonky." + MOD_ID + ".proxy.ClientProxy";
    public static final String ProxyServerClass = "com.invadermonky." + MOD_ID + ".proxy.CommonProxy";

    @Mod.Instance(MOD_ID)
    public static SpartanNetherite INSTANCE;

    @SidedProxy(clientSide = ProxyClientClass, serverSide = ProxyServerClass)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.info("Starting Spartan Netherite.");
        proxy.preInit(event);
        LogHelper.debug("Finished preInit phase.");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        LogHelper.debug("Finished init phase.");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
        LogHelper.debug("Finished postInit phase.");
    }
}
