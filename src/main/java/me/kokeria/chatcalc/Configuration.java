package me.kokeria.chatcalc;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = ChatCalc.MODID)
public class Configuration implements ConfigData, ModMenuApi {

    @ConfigEntry.Gui.PrefixText
    String decimalFormat = "#,##0.##";

    @Override
    public String getModId() {
        return ChatCalc.MODID;
    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return screen -> AutoConfig.getConfigScreen(Configuration.class, screen).get();
    }

}
