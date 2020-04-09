package me.kokeria.chatcalc.event;

import me.kokeria.chatcalc.MathEngine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class EventListener {

    @SubscribeEvent
    public void onGuiInput(GuiScreenEvent.KeyboardInputEvent event) {
        if (event.gui instanceof GuiChat && Keyboard.getEventKey() == Keyboard.KEY_TAB && Keyboard.getEventKeyState() && event.isCancelable()) {

            GuiChat chat = (GuiChat) event.gui;

            try {
                MathEngine.eval(chat.inputField.getText());
                System.out.println("Successful - " + event.isCancelable());
            } catch (RuntimeException e) {
                System.out.println("Not successful");
            }
        }
    }

}
