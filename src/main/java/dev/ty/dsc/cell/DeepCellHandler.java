package dev.ty.dsc.cell;

import appeng.api.stacks.AEItemKey;
import appeng.core.localization.Tooltips;
import appeng.me.cells.BasicCellHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class DeepCellHandler extends BasicCellHandler {
    public static final DeepCellHandler INSTANCE = new DeepCellHandler();

    @Override
    public void addCellInformationToTooltip(ItemStack is, List<Component> lines) {
        var handler = getCellInventory(is, null);
        if (handler == null)
            return;

        if (handler.getStoredItemTypes() == 1) {
            lines.add(Tooltips.bytesUsed(handler.getUsedBytes(), handler.getTotalBytes()));
            if (handler.getAvailableStacks().getFirstKey() instanceof AEItemKey firstKey) {
                // trying to get item names is hell
                lines.add(new TextComponent("Stored: " + firstKey.toStack().getItem()).withStyle(Style.EMPTY.withColor(0xccccff)));
            }
        } else {
            lines.add(new TextComponent("Stores an effectively infinite amount of one item type.").setStyle(Style.EMPTY.withColor(0xccccff)));
        }
    }
}
