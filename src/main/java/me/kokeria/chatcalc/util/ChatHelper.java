package me.kokeria.chatcalc.util;

import net.minecraft.client.gui.widget.TextFieldWidget;

public class ChatHelper {

    public static String getWord(String input, int cursor) {

        return input.substring(getStartOfWord(input, cursor), getEndOfWord(input, cursor));

    }

    public static boolean replaceWord(TextFieldWidget field, String replacement) {
        String input = field.getText();
        int cursor = field.getCursorPosition();
        int start = getStartOfWord(input, cursor);
        int end = getEndOfWord(input, cursor);

        String output = input.substring(0, start) + replacement + input.substring(end);
        if (output.length() > field.maxStringLength) return false;
        field.setText(output);
        return true;
    }

    public static boolean addWordAfterIndex(TextFieldWidget field, int index, String word) {
        String input = field.getText();
        String output = input.substring(0, index) + word + input.substring(index);
        if (output.length() > field.maxStringLength) return false;
        field.setText(output);
        return true;
    }

    public static int getStartOfWord(String input, int cursor) {
        if (cursor == 0) return 0;
        if (input.charAt(cursor - 1) == ' ') return cursor;
        for (int i = cursor - 1; i > 0; i--) {
            if (input.charAt(i - 1) == ' ') return i;
        }
        return 0;
    }

    public static int getEndOfWord(String input, int cursor) {
        if (cursor == input.length() - 1) return cursor;
        for (int i = cursor; i < input.length(); i++) {
            if (input.charAt(i) == ' ') return i;
        }
        return input.length();
    }

}
