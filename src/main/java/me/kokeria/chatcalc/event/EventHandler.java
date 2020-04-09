package me.kokeria.chatcalc.event;

import me.kokeria.chatcalc.util.MathEngine;
import net.minecraft.client.gui.GuiChat;

import java.text.DecimalFormat;

public class EventHandler {

    private static final DecimalFormat format = new DecimalFormat("0.##");

    protected static boolean runExpression(GuiChat chat) {

        try {
            double solution = MathEngine.eval(chat.inputField.getText());
            String solutionStr = format.format(solution);
            chat.inputField.setText(solutionStr);
            return true;
        } catch (RuntimeException e) {
            return false;
        }

    }

}
