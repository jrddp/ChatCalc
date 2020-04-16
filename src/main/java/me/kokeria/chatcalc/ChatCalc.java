package me.kokeria.chatcalc;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class ChatCalc implements ClientModInitializer {

    public static final String MODID = "chatcalc";

    public static Configuration config;

    @Override
    public void onInitializeClient() {

        AutoConfig.register(Configuration.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(Configuration.class).getConfig();

    }
}
