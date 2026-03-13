package com.example.hideexamine;

import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.inject.Inject;

@PluginDescriptor(
        name = "Hide Ground Item Examine",
        description = "Removes the Examine option from ground items",
        tags = {"ground", "items", "examine", "menu"}
)
public class HideGroundItemExaminePlugin extends Plugin
{
    @Inject
    private Client client;

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event)
    {
        if (event.getType() == MenuAction.EXAMINE_ITEM_GROUND.getId())
        {
            MenuEntry[] entries = client.getMenuEntries();
            MenuEntry[] newEntries = new MenuEntry[entries.length - 1];
            System.arraycopy(entries, 0, newEntries, 0, entries.length - 1);
            client.setMenuEntries(newEntries);
        }
    }
}