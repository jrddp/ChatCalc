package me.kokeria.chatcalc;

import me.kokeria.chatcalc.util.ChatHelper;
import me.kokeria.chatcalc.util.MathEngine;
import net.minecraft.client.gui.widget.TextFieldWidget;

import java.text.DecimalFormat;

public class EventHandler {

    private static DecimalFormat getDecimalFormat() {
        return new DecimalFormat(ChatCalc.config.decimalFormat);
    }

    public static boolean runExpression(TextFieldWidget field) {

        return runExprReplace(field) || runExprAdd(field);

    }

    private static boolean runExprReplace(TextFieldWidget field) {

        String originalText = field.getText();
        int cursor = field.getCursor();

        try {
            String word = ChatHelper.getWord(originalText, cursor);
            double solution = MathEngine.eval(word);
            String solStr = getDecimalFormat().format(solution);
            return ChatHelper.replaceWord(field, solStr);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        } catch (RuntimeException e) {
            return false;
        }

    }

    private static boolean runExprAdd(TextFieldWidget field) {

        String originalText = field.getText();
        int cursor = field.getCursor();

        try {
            String word = ChatHelper.getWord(originalText, cursor);
            if (!word.endsWith("=")) return false;
            word = word.substring(0, word.length() - 1);
            double solution = MathEngine.eval(word);
            String solStr = getDecimalFormat().format(solution);
            return ChatHelper.addWordAfterIndex(field, ChatHelper.getEndOfWord(originalText, cursor), solStr);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        } catch (RuntimeException e) {
            return false;
        }

    }

}
