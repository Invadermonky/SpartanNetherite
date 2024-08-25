package com.invadermonky.spartannetherite;

import com.invadermonky.spartannetherite.proxy.CommonProxy;
import com.invadermonky.spartannetherite.util.LogHelper;
import com.invadermonky.spartannetherite.util.ModHelper;
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
    public static final String MOD_VERSION = "1.12.2-1.1.0";
    public static final String DEPENDENCIES =
            "required-after:spartanweaponry@[1.6.0,)" +
            ";required-after:futuremc" +
            ";after:spartanshields" +
            ";after:baubles";
    public static final String MC_VERSION = "[1.12.2]";

    public static final String ProxyClientClass = "com.invadermonky.spartannetherite.proxy.ClientProxy";
    public static final String ProxyServerClass = "com.invadermonky.spartannetherite.proxy.CommonProxy";

    @Mod.Instance(MOD_ID)
    public static SpartanNetherite INSTANCE;

    @SidedProxy(clientSide = ProxyClientClass, serverSide = ProxyServerClass)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.info("Starting Spartan Netherite.");
        ModHelper.preInit();
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
