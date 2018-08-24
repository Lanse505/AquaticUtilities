package lanse505.aquatic.utilities.common.scuba;

import lanse505.aquatic.utilities.common.core.ItemModArmor;
import lanse505.aquatic.utilities.utility.AQCreativeTab;
import lanse505.aquatic.utilities.utility.AQMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

public class ScubaChest extends ItemModArmor {

    public ScubaChest() {
        super(AQMaterials.scubaMaterial, EntityEquipmentSlot.CHEST, "scuba_tank");
        setCreativeTab(AQCreativeTab.AQ_CREATIVE_TAB);
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

    @Override
    public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tabs)) {
            ItemStack stack = new ItemStack(this);

            NBTTagCompound empty = new NBTTagCompound();
            NBTTagCompound full = new NBTTagCompound();

            empty.setInteger("oxygen", 0);
            full.setInteger("oxygen", 6000);

            stack.setTagCompound(empty);
            items.add(stack);

            stack.setTagCompound(full);
            items.add(stack);
        }
    }

}
