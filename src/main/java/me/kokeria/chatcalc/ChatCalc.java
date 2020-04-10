package me.kokeria.chatcalc;

import me.kokeria.chatcalc.event.EventListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ChatCalc.MODID, version = ChatCalc.VERSION, clientSideOnly = true)
public class ChatCalc
{
    public static final String MODID = "chatcalc";
    public static final String VERSION = "2.1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        String configComment = "This pattern determines the format in which calculated answers are presented" +
                "\nBy default, one thousand will be represented as \"1,000\" with up to 2 decimal places" +
                "\nYou may change this to remove or change the decimal separator (,) and the amount of decimal places" +
                "\nWARNING: Be cautious when changing this or it may have unruly consequences." +
                "\n\nExamples -" +
                "\n0.## -> Will no longer include the decimal separator (,)" +
                "\n#,##0.#### -> Will display up to 4 decimal places of accuracy" +
                "\n0.00 -> Will always display 2 decimal places, even if they are 0" +
                "\n\nMore information may be found here: https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html";

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        String format = config.getString("DecimalFormat", Configuration.CATEGORY_GENERAL, "#,##0.##", configComment);
        if (config.hasChanged()) config.save();
        me.kokeria.chatcalc.event.EventHandler.changeDecimalFormat(format);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new EventListener());
    }
}
