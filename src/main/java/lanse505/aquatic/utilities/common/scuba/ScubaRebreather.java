package lanse505.aquatic.utilities.common.scuba;

import lanse505.aquatic.utilities.AquaticUtilities;
import lanse505.aquatic.utilities.common.core.ItemModArmor;
import lanse505.aquatic.utilities.utility.AQMaterials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class ScubaRebreather extends ItemModArmor {

    public ScubaRebreather() {
        super(AQMaterials.scubaMaterial, EntityEquipmentSlot.HEAD, "scuba_rebreather");
        setCreativeTab(AquaticUtilities.TAB);
    }

    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }


    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            ItemStack stack = new ItemStack(this);

            NBTTagCompound empty = new NBTTagCompound();
            empty.setInteger("filter", 0);

            NBTTagCompound full = new NBTTagCompound();
            full.setInteger("filter", 6000);

            stack.setTagCompound(empty);
            items.add(stack);

            stack.setTagCompound(full);
            items.add(stack);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.isInWater() && player.getAir() >= 1) {
            if (itemStack.hasTagCompound()) {
                if (Objects.requireNonNull(itemStack.getTagCompound()).hasKey("filter")) {
                    NBTTagCompound nbt = itemStack.getTagCompound();
                    int filterCap = nbt.getInteger("filter");
                    if (filterCap > 0) {
                        filterCap--;
                        player.setAir(300);
                    }
                    nbt.setInteger("filter", filterCap);
                    itemStack.setTagCompound(nbt);
                }
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        NBTTagCompound nbt = stack.getTagCompound();
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        if (nbt.hasKey("filter")) {
            tooltip.add(TextFormatting.GOLD + "Filter: " + TextFormatting.GRAY + nbt.getInteger("filter"));
        }
    }
}
