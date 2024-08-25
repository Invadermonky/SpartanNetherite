package com.invadermonky.spartannetherite.init;

import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.item.materials.NetheriteMaterial;
import com.invadermonky.spartannetherite.item.shields.ItemShieldSN;
import com.invadermonky.spartannetherite.item.weapons.*;
import com.invadermonky.spartannetherite.util.LogHelper;
import com.invadermonky.spartannetherite.util.ModHelper;
import com.invadermonky.spartannetherite.weaponproperty.WeaponCallbackFireproof;
import com.invadermonky.spartannetherite.weaponproperty.WeaponPropertySN;
import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.util.ConfigHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = SpartanNetherite.MOD_ID)
public class ItemRegistrySN {
    public static ToolMaterialEx materialNetherite;

    public static Item daggerNetherite, longswordNetherite, katanaNetherite, scytheNetherite, saberNetherite, rapierNetherite, greatswordNetherite,
            hammerNetherite, warhammerNetherite, spearNetherite, halberdNetherite, pikeNetherite, lanceNetherite, longbowNetherite,
            crossbowNetherite, throwingKnifeNetherite, throwingAxeNetherite, javelinNetherite, boomerangNetherite, battleaxeNetherite,
            maceNetherite, glaiveNetherite, staffNetherite, parryNetherite;

    public static ItemShield shieldNetherite, shieldTowerNetherite;

    public static ArrayList<Item> weapons = new ArrayList<>();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        materialNetherite = new ToolMaterialEx("netherite", NetheriteMaterial.NETHERITE, "ingotNetherite", SpartanNetherite.MOD_ID, NetheriteMaterial.NETHERITE.getAttackDamage(), WeaponPropertySN.Fireproof);

        if(!ConfigHandler.disableDagger) {
            daggerNetherite = new ItemDaggerSN("dagger_netherite", materialNetherite);
            addWeaponsToRegister(daggerNetherite);
        }
        if(!ConfigHandler.disableLongsword) {
            longswordNetherite = new ItemLongswordSN("longsword_netherite", materialNetherite);
            addWeaponsToRegister(longswordNetherite);
        }
        if(!ConfigHandler.disableKatana) {
            katanaNetherite = new ItemKatanaSN("katana_netherite", materialNetherite);
            addWeaponsToRegister(katanaNetherite);
        }
        if(!ConfigHandler.disableScythe) {
            scytheNetherite = new ItemScytheSN("scythe_netherite", materialNetherite);
            addWeaponsToRegister(scytheNetherite);
        }
        if(!ConfigHandler.disableSaber) {
            saberNetherite = new ItemSaberSN("saber_netherite", materialNetherite);
            addWeaponsToRegister(saberNetherite);
        }
        if(!ConfigHandler.disableRapier) {
            rapierNetherite = new ItemRapierSN("rapier_netherite", materialNetherite);
            addWeaponsToRegister(rapierNetherite);
        }
        if(!ConfigHandler.disableGreatsword) {
            greatswordNetherite = new ItemGreatswordSN("greatsword_netherite", materialNetherite);
            addWeaponsToRegister(greatswordNetherite);
        }
        if(!ConfigHandler.disableHammer) {
            hammerNetherite = new ItemHammerSN("hammer_netherite", materialNetherite);
            addWeaponsToRegister(hammerNetherite);
        }
        if(!ConfigHandler.disableWarhammer) {
            warhammerNetherite = new ItemWarhammerSN("warhammer_netherite", materialNetherite);
            addWeaponsToRegister(warhammerNetherite);
        }
        if(!ConfigHandler.disableSpear) {
            spearNetherite = new ItemSpearSN("spear_netherite", materialNetherite);
            addWeaponsToRegister(spearNetherite);
        }
        if(!ConfigHandler.disableHalberd) {
            halberdNetherite = new ItemHalberdSN("halberd_netherite", materialNetherite);
            addWeaponsToRegister(halberdNetherite);
        }
        if(!ConfigHandler.disablePike) {
            pikeNetherite = new ItemPikeSN("pike_netherite", materialNetherite);
            addWeaponsToRegister(pikeNetherite);
        }
        if(!ConfigHandler.disableLance) {
            lanceNetherite = new ItemLanceSN("lance_netherite", materialNetherite);
            addWeaponsToRegister(lanceNetherite);
        }
        if(!ConfigHandler.disableLongbow) {
            longbowNetherite =new ItemLongbowSN("longbow_netherite", materialNetherite, new WeaponCallbackFireproof());
            addWeaponsToRegister(longbowNetherite);
        }
        if(!ConfigHandler.disableCrossbow) {
            crossbowNetherite = new ItemCrossbowSN("crossbow_netherite", materialNetherite, new WeaponCallbackFireproof());
            addWeaponsToRegister(crossbowNetherite);
        }
        if(!ConfigHandler.disableThrowingKnife) {
            throwingKnifeNetherite = new ItemThrowingKnifeSN("throwing_knife_netherite", materialNetherite);
            addWeaponsToRegister(throwingKnifeNetherite);
        }
        if(!ConfigHandler.disableThrowingAxe) {
            throwingAxeNetherite = new ItemThrowingAxeSN("throwing_axe_netherite", materialNetherite);
            addWeaponsToRegister(throwingAxeNetherite);
        }
        if(!ConfigHandler.disableJavelin) {
            javelinNetherite = new ItemJavelinSN("javelin_netherite", materialNetherite);
            addWeaponsToRegister(javelinNetherite);
        }
        if(!ConfigHandler.disableBoomerang && !ConfigHandler.woodenBoomerangOnly) {
            boomerangNetherite = new ItemBoomerangSN("boomerang_netherite", materialNetherite);
            addWeaponsToRegister(boomerangNetherite);
        }
        if(!ConfigHandler.disableBattleaxe) {
            battleaxeNetherite = new ItemBattleaxeSN("battleaxe_netherite", materialNetherite);
            addWeaponsToRegister(battleaxeNetherite);
        }
        if(!ConfigHandler.disableMace) {
            maceNetherite = new ItemMaceSN("mace_netherite", materialNetherite);
            addWeaponsToRegister(maceNetherite);
        }
        if(!ConfigHandler.disableGlaive) {
            glaiveNetherite = new ItemGlaiveSN("glaive_netherite", materialNetherite);
            addWeaponsToRegister(glaiveNetherite);
        }
        if(!ConfigHandler.disableQuarterstaff) {
            staffNetherite = new ItemQuarterstaffSN("staff_netherite", materialNetherite);
            addWeaponsToRegister(staffNetherite);
        }
        if(!ConfigHandler.disableParryingDagger) {
            parryNetherite = new ItemParryingDaggerSN("parrying_dagger_netherite", materialNetherite);
            addWeaponsToRegister(parryNetherite);
        }

        if (ModHelper.isSpartanShieldsLoaded()) {
            if(!com.oblivioussp.spartanshields.util.ConfigHandler.disableStandardShields) {
                shieldNetherite = new ItemShieldSN("shield_basic_netherite", 3554, NetheriteMaterial.NETHERITE, "ingotNetherite").create();
                registry.register(shieldNetherite);
            }

            if(!com.oblivioussp.spartanshields.util.ConfigHandler.disableTowerShields) {
                shieldTowerNetherite = new ItemShieldSN("shield_tower_netherite", 3554, NetheriteMaterial.NETHERITE, "ingotNetherite").create();
                registry.register(shieldTowerNetherite);

            }
            LogHelper.info("Shields Registered.");
        }
        else {
            LogHelper.info("Spartan Shields not loaded, shields not registered.");
        }

        for(Item weapon : weapons) {
            registry.register(weapon);
            SpartanWeaponryAPI.addItemModelToRegistry(weapon);
        }
        LogHelper.info("Weapons registered.");
    }

    protected static void addWeaponsToRegister(Item... weaponsToAdd) {
        for(Item weapon : weaponsToAdd) {
            if(weapon != null) {
                weapons.add(weapon);
            }
        }
    }
}
