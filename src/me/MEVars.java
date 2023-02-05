package me;

import me.content.*;
// import me.entities.SWEntityMapping;

public class MEVars {

    /**This is where you initialize your content lists. But do not forget about correct order.
     *  correct order:
     *  ModItems.load()
     *  ModStatusEffects.load()
     *  ModLiquids.load()
     *  ModBullets.load()
     *  ModUnitTypes.load()
     *  ModBlocks.load()
     *  ModPlanets.load()
     *  ModSectorPresets.load()
     *  ModTechTree.load()
     * */
    public static void loadContent() {
//         MEItems.load();
//         MELiquids.load();
//         MEEntityMapping.load();
//         MEUnitTypes.load();
        MEBlocks.load();
//        SWPlanets.load();
//         METechTree.load();
    }
}
