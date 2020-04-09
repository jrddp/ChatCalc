package me.kokeria.chatcalc.event;

import me.kokeria.chatcalc.util.MathEngine;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.text.DecimalFormat;

public class EventListener {

    @SubscribeEvent
    public void onGuiInput(GuiScreenEvent.KeyboardInputEvent event) {
        if (event.gui instanceof GuiChat && Keyboard.getEventKey() == Keyboard.KEY_TAB && Keyboard.getEventKeyState() && event.isCancelable()) {

            if (EventHandler.runExpression((GuiChat) event.gui)) event.setCanceled(true);

        }
    }

}
