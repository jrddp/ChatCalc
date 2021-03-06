package me.kokeria.chatcalc.event;

import me.kokeria.chatcalc.util.ChatHelper;
import me.kokeria.chatcalc.util.MathEngine;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;

import java.text.DecimalFormat;

public class EventHandler {

    private static final DecimalFormat df = new DecimalFormat("#,##0.##");

    public static void changeDecimalFormat(String format) {
        df.applyPattern(format);
    }

    protected static boolean runExpression(GuiChat chat) {

        return runExprReplace(chat) || runExprAdd(chat);

    }

    private static boolean runExprReplace(GuiChat chat) {

        GuiTextField field = chat.inputField;
        String originalText = field.getText();
        int cursor = field.getCursorPosition();

        try {
            String word = ChatHelper.getWord(originalText, cursor);
            double solution = MathEngine.eval(word);
            String solStr = df.format(solution);
            return ChatHelper.replaceWord(field, solStr);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        } catch (RuntimeException e) {
            return false;
        }

    }

    private static boolean runExprAdd(GuiChat chat) {

        GuiTextField field = chat.inputField;
        String originalText = field.getText();
        int cursor = field.getCursorPosition();

        try {
            String word = ChatHelper.getWord(originalText, cursor);
            if (!word.endsWith("=")) return false;
            word = word.substring(0, word.length() - 1);
            double solution = MathEngine.eval(word);
            String solStr = df.format(solution);
            return ChatHelper.addWordAfterIndex(field, ChatHelper.getEndOfWord(originalText, cursor), solStr);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        } catch (RuntimeException e) {
            return false;
        }

    }

}
