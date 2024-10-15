package com.invadermonky.spartannetherite.registry;

import com.invadermonky.spartannetherite.SpartanNetherite;
import com.invadermonky.spartannetherite.config.ConfigHandlerSN;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import com.invadermonky.spartannetherite.util.libs.ModIds;
import com.oblivioussp.spartanshields.init.ItemRegistrySS;
import com.oblivioussp.spartanshields.item.crafting.RecipeShieldBanners;
import com.oblivioussp.spartanweaponry.init.ItemRegistrySW;
import gnu.trove.map.hash.THashMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import thedarkcolour.futuremc.config.FConfig;
import thedarkcolour.futuremc.recipe.smithing.SmithingRecipe;
import thedarkcolour.futuremc.recipe.smithing.SmithingRecipes;

@Mod.EventBusSubscriber(modid = SpartanNetherite.MOD_ID)
public class ModRecipesSN {
    public static final THashMap<Item,ItemStack> recipeAssociations = new THashMap<>();

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> registry = event.getRegistry();
        if(ModIds.spartan_shields.isLoaded) {
            registry.register((new RecipeShieldBanners(ModItemsSN.shield_tower_netherite)).setRegistryName(new ResourceLocation(SpartanNetherite.MOD_ID, "shield_banner_netherite")));
        }

        if(ModIds.futuremc.isLoaded && ConfigHandlerSN.enableSmithingTableRecipes) {
            if(FConfig.INSTANCE.getVillageAndPillage().smithingTable.enabled) {
                recipeAssociations.forEach((input, output) -> {
                    if (input != null && output != null) {
                        SmithingRecipes.INSTANCE.getRecipes().add(new SmithingRecipe(Ingredient.fromItem(input), Ingredient.fromStacks(OreDictionary.getOres(LibNames.netherite_ingot).toArray(new ItemStack[0])), output));
                    }
                });
            }
        }
    }

    public static void addRecipeAssociation(Item inputItem, Item outputItem) {
        addRecipeAssociation(inputItem, new ItemStack(outputItem));
    }

    public static void addRecipeAssociation(Item inputItem, ItemStack outputStack) {
        if(inputItem != null && !outputStack.isEmpty()) {
            recipeAssociations.put(inputItem, outputStack);
        }
    }

    static {
		addRecipeAssociation(ItemRegistrySW.daggerDiamond, ModItemsSN.dagger_netherite);
		addRecipeAssociation(ItemRegistrySW.longswordDiamond, ModItemsSN.longsword_netherite);
		addRecipeAssociation(ItemRegistrySW.katanaDiamond, ModItemsSN.katana_netherite);
		addRecipeAssociation(ItemRegistrySW.scytheDiamond, ModItemsSN.scythe_netherite);
		addRecipeAssociation(ItemRegistrySW.saberDiamond, ModItemsSN.saber_netherite);
		addRecipeAssociation(ItemRegistrySW.rapierDiamond, ModItemsSN.rapier_netherite);
		addRecipeAssociation(ItemRegistrySW.greatswordDiamond, ModItemsSN.greatsword_netherite);
		addRecipeAssociation(ItemRegistrySW.hammerDiamond, ModItemsSN.hammer_netherite);
		addRecipeAssociation(ItemRegistrySW.warhammerDiamond, ModItemsSN.warhammer_netherite);
		addRecipeAssociation(ItemRegistrySW.spearDiamond, ModItemsSN.spear_netherite);
		addRecipeAssociation(ItemRegistrySW.halberdDiamond, ModItemsSN.halberd_netherite);
		addRecipeAssociation(ItemRegistrySW.pikeDiamond, ModItemsSN.pike_netherite);
		addRecipeAssociation(ItemRegistrySW.lanceDiamond, ModItemsSN.lance_netherite);
		addRecipeAssociation(ItemRegistrySW.longbowDiamond, ModItemsSN.longbow_netherite);
		addRecipeAssociation(ItemRegistrySW.crossbowDiamond, ModItemsSN.crossbow_netherite);
		addRecipeAssociation(ItemRegistrySW.throwingKnifeDiamond, ModItemsSN.throwing_knife_netherite);
		addRecipeAssociation(ItemRegistrySW.throwingAxeDiamond, ModItemsSN.throwing_axe_netherite);
		addRecipeAssociation(ItemRegistrySW.javelinDiamond, ModItemsSN.javelin_netherite);
		addRecipeAssociation(ItemRegistrySW.boomerangDiamond, ModItemsSN.boomerang_netherite);
		addRecipeAssociation(ItemRegistrySW.battleaxeDiamond, ModItemsSN.battleaxe_netherite);
		addRecipeAssociation(ItemRegistrySW.maceDiamond, ModItemsSN.mace_netherite);
		addRecipeAssociation(ItemRegistrySW.glaiveDiamond, ModItemsSN.glaive_netherite);
		addRecipeAssociation(ItemRegistrySW.quarterstaffDiamond, ModItemsSN.staff_netherite);
		addRecipeAssociation(ItemRegistrySW.parryingDaggerDiamond, ModItemsSN.parry_netherite);

        if(ModIds.spartan_shields.isLoaded) {
            addRecipeAssociation(ItemRegistrySS.shieldDiamond, ModItemsSN.shield_netherite);
            addRecipeAssociation(ItemRegistrySS.shieldTowerDiamond, ModItemsSN.shield_tower_netherite);
        }
    }
}
