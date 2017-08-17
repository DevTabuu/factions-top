package net.novucs.ftop.replacer;

import net.novucs.ftop.FactionsTopPlugin;
import net.novucs.ftop.entity.FactionWorth;
import net.novucs.ftop.util.SortedSplayTree;

import java.util.function.Supplier;

public class LastReplacer implements Supplier<String> {

    private final FactionsTopPlugin plugin;

    public LastReplacer(FactionsTopPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public String get() {
        SortedSplayTree<FactionWorth> factions = plugin.getWorthManager().getOrderedFactions();

        if (factions.isEmpty()) {
            return plugin.getSettings().getPlaceholdersFactionNotFound();
        }

        return factions.getMax().getName();
    }
}
