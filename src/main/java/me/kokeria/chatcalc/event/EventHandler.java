package me.kokeria.chatcalc.event;

import me.kokeria.chatcalc.util.ChatHelper;
import me.kokeria.chatcalc.util.MathEngine;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;

import java.text.DecimalFormat;

public class EventHandler {

    private static final DecimalFormat df = new DecimalFormat("0.##");

    protected static boolean runExpression(GuiChat chat) {

        GuiTextField field = chat.inputField;
        String originalText = field.getText();
        int cursor = field.getCursorPosition();

        try {
            System.out.println(ChatHelper.getWord(originalText, cursor));
        } catch (Exception e) {
            System.out.println(ChatHelper.getStartOfWord(originalText, cursor) + ", " + ChatHelper.getEndOfWord(originalText, cursor));
        }

        try {
            String word = ChatHelper.getWord(originalText, cursor);
            double solution = MathEngine.eval(word);
            String solStr = df.format(solution);

            return true;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        } catch (RuntimeException e) {
            return false;
        }

    }

}
