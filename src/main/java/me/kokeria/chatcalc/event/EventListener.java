package me.kokeria.chatcalc.event;

import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class EventListener {

    public static final int KEY_TAB = 258;

    @SubscribeEvent
    public void onGuiInput(GuiScreenEvent.KeyboardKeyPressedEvent event) {
        System.out.println(event.getKeyCode());
        if (event.getGui() instanceof ChatScreen && event.getKeyCode() == KEY_TAB && event.isCancelable()) {

            if (EventHandler.runExpression((ChatScreen) event.getGui())) event.setCanceled(true);

        }
    }

}
