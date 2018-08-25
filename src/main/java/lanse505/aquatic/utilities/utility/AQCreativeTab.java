package lanse505.aquatic.utilities.utility;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class AQCreativeTab extends CreativeTabs {
    private static final ItemStack icon = new ItemStack(AQConstants.SCUBA_TANK, 1, 0);

    public AQCreativeTab() {
        super(AQConstants.MOD_ID);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

    @Override
    public ItemStack getTabIconItem() {
        return icon;
    }

}
