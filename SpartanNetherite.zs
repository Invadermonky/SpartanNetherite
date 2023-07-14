import mods.futuremc.SmithingTable;

static weapons as string[] = [
    "battleaxe",
    "boomerang",
    "crossbow",
    "dagger",
    "glaive",
    "greatsword",
    "halberd",
    "hammer",
    "javelin",
    "katana",
    "lance",
    "longbow",
    "mace",
    "parrying_dagger",
    "pike",
    "rapier",
    "saber",
    "spear",
    "staff",
    "throwing_axe",
    "throwing_knife",
    "warhammer",
    "shield_basic",
    "shield_tower"
];
for weapon in weapons {
    val input = itemUtils.getItem("spartanweaponry:" ~ weapon ~ "_diamond");
    val output = itemUtils.getItem("spartannetherite:" ~ weapon ~ "_netherite");
    if(!isNull(input) && !isNull(output)) {
        recipes.remove(output);
        SmithingTable.addRecipe(input, <ore:ingotNetherite>, output);
    }
}