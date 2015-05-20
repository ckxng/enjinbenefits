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
import java.net.*;
import java.io.*;
import org.json.*;

@Mod(modid = EnjinBenefitsMod.MODID, version = EnjinBenefitsMod.VERSION, name = EnjinBenefitsMod.NAME)

/**
 * Enjin Benefits Mod loader class
 * @author Cameron King <cking@ckxng.com>
 */
public class EnjinBenefitsMod {
    public static final String MODID = "enjinbenefits";
    public static final String NAME = "Enjin Benefits";
    public static final String VERSION = "0.1.0";

    /** The key provided by the Enjin admin panel - SECRET! */
    public static String enjinApiKey = "";
    
    /** The API URL provided by the Enjin admin panel */
    public static String enjinApiUrl = "https://example.enjin.com/api/v1/api.php";
    
    /**
     * 
     * @param event
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
            Configuration config = new Configuration(event.getSuggestedConfigurationFile());
            config.load();

            enjinApiKey = config.getString("key", "api", enjinApiKey, 
            		"The key provided by the Enjin admin panel - SECRET!");

            enjinApiUrl = config.getString("url", "api", enjinApiUrl, 
            		"The API URL provided by the Enjin admin panel");
            
            config.save();
            
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Let's have fun with: " + this.NAME);
        
        try {
        	// generate stats API payload
        	JSONObject enjinStatsPayload = new JSONObject()
        			.put("jsonrpc","2.0")
        			.put("id", (int)(Math.random()*1000))
        			.put("params", new JSONObject().put("api_key",enjinApiKey))
        			.put("method", "Stats.get");
        	
	        // connect to collect stats
	        URL enjinStatsUrl = new URL(enjinApiUrl);
	        HttpURLConnection enjinStatsConn = (HttpURLConnection)enjinStatsUrl.openConnection();
	        enjinStatsConn.setRequestMethod("POST");
	        enjinStatsConn.setDoOutput(true);
	        enjinStatsConn.setRequestProperty("Content-Type", "application/json");
	        
	        // send stats payload
	        System.out.println("Sending request: "+enjinStatsPayload.toString());
	        OutputStreamWriter out = new OutputStreamWriter(
	        		enjinStatsConn.getOutputStream());
	        out.write(enjinStatsPayload.toString());
	        out.flush();
	        
	        // read stats
	        BufferedReader in = new BufferedReader(
	        		new InputStreamReader(
	        				enjinStatsConn.getInputStream()));
	        String lineIn;
	        while((lineIn = in.readLine()) != null) {
	        	System.out.println(lineIn);
	        }
	        in.close();
        } catch(Exception ex) {
        		System.err.println("Unable to fetch Enjin Stats from "+enjinApiUrl);
        }
        
    }
}

