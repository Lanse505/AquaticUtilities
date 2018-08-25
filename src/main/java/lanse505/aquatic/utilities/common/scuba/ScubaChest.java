package lanse505.aquatic.utilities.common.scuba;

import lanse505.aquatic.utilities.AquaticUtilities;
import lanse505.aquatic.utilities.common.core.ItemModArmor;
import lanse505.aquatic.utilities.utility.AQMaterials;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class ScubaChest extends ItemModArmor {

    public ScubaChest() {
        super(AQMaterials.scubaMaterial, EntityEquipmentSlot.CHEST, "scuba_tank");
        setCreativeTab(AquaticUtilities.aqCreativeTab);
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
            full.setInteger("oxygen", 24000);

            stack.setTagCompound(empty);
            items.add(stack);

            stack.setTagCompound(full);
            items.add(stack);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        NBTTagCompound nbt = stack.getTagCompound();
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        if (Objects.requireNonNull(nbt).hasKey("oxygen")) {
            tooltip.add(TextFormatting.GOLD + "Oxygen: " + TextFormatting.GRAY + nbt.getInteger("oxygen"));
        }
    }
}
