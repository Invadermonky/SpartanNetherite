package com.invadermonky.spartannetherite.events;

import com.invadermonky.spartannetherite.registry.ModRecipesSN;
import com.invadermonky.spartannetherite.util.libs.LibNames;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Arrays;

public class AnvilEventHandler {
    private static ItemStack setItemDamage(ItemStack oldStack, ItemStack newStack) {
        float oldDamage = Math.min((float) oldStack.getItemDamage() / (float) oldStack.getMaxDamage(), 1.0f);
        newStack.setItemDamage((int) ((float) newStack.getMaxDamage() * oldDamage));
        return newStack;
    }

    @SubscribeEvent
    public void handleAnvilRecipe(AnvilUpdateEvent event) {
        ItemStack leftStack = event.getLeft();
        ItemStack rightStack = event.getRight();
        if (!leftStack.isEmpty() && ModRecipesSN.recipeAssociations.containsKey(leftStack.getItem())) {
            int netheriteOreId = OreDictionary.getOreID(LibNames.netherite_ingot);
            boolean isNetheriteIngot = Arrays.stream(OreDictionary.getOreIDs(rightStack)).anyMatch(n -> (n == netheriteOreId));
            if (isNetheriteIngot) {
                ItemStack outputStack = setItemDamage(leftStack, ModRecipesSN.recipeAssociations.get(leftStack.getItem()));
                event.setCost(8);
                event.setOutput(outputStack);
            }
        }
    }
}
