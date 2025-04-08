package com.invadermonky.spartannetherite.registry;

import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.item.shields.ItemShieldSN;
import com.invadermonky.spartannetherite.item.weapons.*;
import com.invadermonky.spartannetherite.util.StringHelper;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import com.invadermonky.spartannetherite.util.libs.ModIds;
import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.util.ConfigHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = SpartanNetherite.MOD_ID)
public class ModItemsSN {
    public static Item dagger_netherite;
    public static Item longsword_netherite;
    public static Item katana_netherite;
    public static Item scythe_netherite;
    public static Item saber_netherite;
    public static Item rapier_netherite;
    public static Item greatsword_netherite;
    public static Item hammer_netherite;
    public static Item warhammer_netherite;
    public static Item spear_netherite;
    public static Item halberd_netherite;
    public static Item pike_netherite;
    public static Item lance_netherite;
    public static Item longbow_netherite;
    public static Item crossbow_netherite;
    public static Item throwing_knife_netherite;
    public static Item throwing_axe_netherite;
    public static Item javelin_netherite;
    public static Item boomerang_netherite;
    public static Item battleaxe_netherite;
    public static Item mace_netherite;
    public static Item glaive_netherite;
    public static Item staff_netherite;
    public static Item parry_netherite;

    public static ItemShield shield_netherite;
    public static ItemShield shield_tower_netherite;

    public static ArrayList<Item> weapons = new ArrayList<>();

    public static void addItemToRegister(Item item, boolean enabled) {
        if (item != null && enabled) {
            weapons.add(item);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Item weapon : weapons) {
            event.getRegistry().register(weapon);
            SpartanWeaponryAPI.addItemModelToRegistry(weapon);
        }
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        if (ModIds.spartan_shields.isLoaded) {
            registerItemRender(ModItemsSN.shield_netherite);
            registerItemRender(ModItemsSN.shield_tower_netherite);
        }
    }

    private static void registerItemRender(Item item) {
        if (item != null) {
            ModelResourceLocation modelLoc = new ModelResourceLocation(StringHelper.stripUnlocalizedName(item.getTranslationKey()), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelLoc);
        }
    }

    static {
        addItemToRegister(dagger_netherite = new ItemDaggerSN(), !ConfigHandler.disableDagger);
        addItemToRegister(parry_netherite = new ItemParryingDaggerSN(), !ConfigHandler.disableParryingDagger);
        addItemToRegister(longsword_netherite = new ItemLongswordSN(), !ConfigHandler.disableLongsword);
        addItemToRegister(katana_netherite = new ItemKatanaSN(), !ConfigHandler.disableKatana);
        addItemToRegister(scythe_netherite = new ItemScytheSN(), !ConfigHandler.disableScythe);
        addItemToRegister(saber_netherite = new ItemSaberSN(), !ConfigHandler.disableSaber);
        addItemToRegister(rapier_netherite = new ItemRapierSN(), !ConfigHandler.disableRapier);
        addItemToRegister(greatsword_netherite = new ItemGreatswordSN(), !ConfigHandler.disableGreatsword);
        addItemToRegister(hammer_netherite = new ItemHammerSN(), !ConfigHandler.disableHammer);
        addItemToRegister(warhammer_netherite = new ItemWarhammerSN(), !ConfigHandler.disableWarhammer);
        addItemToRegister(spear_netherite = new ItemSpearSN(), !ConfigHandler.disableSpear);
        addItemToRegister(halberd_netherite = new ItemHalberdSN(), !ConfigHandler.disableHalberd);
        addItemToRegister(pike_netherite = new ItemPikeSN(), !ConfigHandler.disablePike);
        addItemToRegister(lance_netherite = new ItemLanceSN(), !ConfigHandler.disableLance);
        addItemToRegister(longbow_netherite = new ItemLongbowSN(), !ConfigHandler.disableLongbow && !ConfigHandler.woodenLongbowOnly);
        addItemToRegister(crossbow_netherite = new ItemCrossbowSN(), !ConfigHandler.disableCrossbow && !ConfigHandler.woodenCrossbowOnly);
        addItemToRegister(throwing_knife_netherite = new ItemThrowingKnifeSN(), !ConfigHandler.disableThrowingKnife);
        addItemToRegister(throwing_axe_netherite = new ItemThrowingAxeSN(), !ConfigHandler.disableThrowingAxe);
        addItemToRegister(javelin_netherite = new ItemJavelinSN(), !ConfigHandler.disableBoomerang && !ConfigHandler.woodenBoomerangOnly);
        addItemToRegister(boomerang_netherite = new ItemBoomerangSN(), !ConfigHandler.disableBattleaxe);
        addItemToRegister(battleaxe_netherite = new ItemBattleaxeSN(), !ConfigHandler.disableJavelin);
        addItemToRegister(mace_netherite = new ItemMaceSN(), !ConfigHandler.disableMace);
        addItemToRegister(glaive_netherite = new ItemGlaiveSN(), !ConfigHandler.disableGlaive);
        addItemToRegister(staff_netherite = new ItemQuarterstaffSN(), !ConfigHandler.disableQuarterstaff);


        if (ModIds.spartan_shields.isLoaded) {
            addItemToRegister(shield_netherite = ItemShieldSN.getInstance().create(LibNames.shield_netherite), !com.oblivioussp.spartanshields.util.ConfigHandler.disableStandardShields);
            addItemToRegister(shield_tower_netherite = ItemShieldSN.getInstance().create(LibNames.shield_tower_netherite), !com.oblivioussp.spartanshields.util.ConfigHandler.disableTowerShields);
        }
    }
}
