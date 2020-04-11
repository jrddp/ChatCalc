package me.kokeria.chatcalc;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class Config {

    public static final ForgeConfigSpec CLIENT_SPEC;
    static final ClientConfig CLIENT;
    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT = specPair.getLeft();
        CLIENT_SPEC = specPair.getRight();
    }

            final static class ClientConfig {

                final ForgeConfigSpec.ConfigValue<String> DECIMAL_FORMAT;

                ClientConfig(final ForgeConfigSpec.Builder builder) {
                    builder.push("general");

                    String configComment = "This pattern determines the format in which calculated answers are presented" +
                            "\nBy default, one thousand will be represented as \"1,000\" with up to 2 decimal places" +
                            "\nYou may change this to remove or change the decimal separator (,) and the amount of decimal places" +
                            "\nWARNING: Be cautious when changing this or it may have unruly consequences." +
                            "\n\nExamples -" +
                            "\n0.## -> Will no longer include the decimal separator (,)" +
                            "\n#,##0.#### -> Will display up to 4 decimal places of accuracy" +
                            "\n0.00 -> Will always display 2 decimal places, even if they are 0" +
                            "\n\nMore information may be found here: https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html";

                    DECIMAL_FORMAT = builder.comment(configComment).define("DecimalFormat", "#,##0.##");

                }
            }

}
