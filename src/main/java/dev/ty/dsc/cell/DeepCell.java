package dev.ty.dsc.cell;

import appeng.api.config.FuzzyMode;
import appeng.api.stacks.AEKeyType;
import appeng.api.storage.cells.IBasicCellItem;
import appeng.items.contents.CellConfig;
import appeng.util.ConfigInventory;
import dev.ty.dsc.lib.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DeepCell extends Item implements IBasicCellItem {
    public DeepCell() {
        super(new Properties().tab(CreativeModeTab.TAB_MISC));
        this.setRegistryName(Constants.MOD_ID, "dsc");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltips, TooltipFlag advanced) {
        addCellInformationToTooltip(stack, tooltips);
    }

    @Override
    public void addCellInformationToTooltip(ItemStack is, List<Component> lines) {
        DeepCellHandler.INSTANCE.addCellInformationToTooltip(is, lines);
    }

    @Override
    public AEKeyType getKeyType() {
        return AEKeyType.items();
    }

    @Override
    public int getBytes(ItemStack cellItem) {
        return (Integer.MAX_VALUE/2+1) / 4;
    }

    @Override
    public int getBytesPerType(ItemStack cellItem) {
        return 1;
    }

    @Override
    public int getTotalTypes(ItemStack cellItem) {
        return 1;
    }

    @Override
    public double getIdleDrain() {
        return 0;
    }

    @Override
    public boolean isEditable(ItemStack is) {
        return true;
    }

    @Override
    public ConfigInventory getConfigInventory(ItemStack is) {
        return CellConfig.create(is);
    }

    @Override
    public FuzzyMode getFuzzyMode(ItemStack is) {
        return FuzzyMode.IGNORE_ALL;
    }

    @Override
    public void setFuzzyMode(ItemStack is, FuzzyMode fzMode) {
        // no-op
    }
}
