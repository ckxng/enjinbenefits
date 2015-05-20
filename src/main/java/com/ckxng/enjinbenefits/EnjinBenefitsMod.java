/**
 * Provide benefits to Enjin points holders
 */
package com.ckxng.enjinbenefits;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = EnjinBenefitsMod.MODID, version = EnjinBenefitsMod.VERSION, name = EnjinBenefitsMod.NAME)

/**
 * Enjin Benefits Mod loader class
 * @author Cameron King <cking@ckxng.com>
 */
public class EnjinBenefitsMod {
    public static final String MODID = "enjinbenefits";
    public static final String NAME = "Enjin Benefits";
    public static final String VERSION = "1.0";

    /** The key provided by the Enjin admin panel - SECRET! */
    public static String enjinKey = "";
    
    /**
     * 
     * @param event
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
            Configuration config = new Configuration(event.getSuggestedConfigurationFile());
            config.load();
            
            enjinKey = config.getString("enjinKey", "api", enjinKey, 
            		"The key provided by the Enjin admin panel - SECRET!");
            
            config.save();
            
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Let's have fun with: " + this.NAME);
    }
}

