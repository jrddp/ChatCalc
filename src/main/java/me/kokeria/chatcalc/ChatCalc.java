package me.kokeria.chatcalc;

import me.kokeria.chatcalc.event.EventListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(ChatCalc.MODID)
public class ChatCalc
{
    public static final String MODID = "chatcalc";
    public static final String VERSION = "2.1";

    public ChatCalc() {

        MinecraftForge.EVENT_BUS.register(new EventListener());
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC, "chatcalc.toml");

    }

}

