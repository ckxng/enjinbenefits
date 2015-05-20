/**
 * 
 */
package com.ckxng.enjinbenefits;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = EnjinBenefitsMod.MODID, version = EnjinBenefitsMod.VERSION, name = EnjinBenefitsMod.NAME)

/**
 * @author Cameron King <cking@ckxng.com>
 *
 */
public class EnjinBenefitsMod {
    public static final String MODID = "enjinbenefits";
    public static final String NAME = "Enjin Benefits";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}

