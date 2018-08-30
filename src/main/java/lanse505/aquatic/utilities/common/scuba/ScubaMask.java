package lanse505.aquatic.utilities.common.scuba;

import lanse505.aquatic.utilities.AquaticUtilities;
import lanse505.aquatic.utilities.common.core.ItemModArmor;
import lanse505.aquatic.utilities.utility.AQMaterials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class ScubaMask extends ItemModArmor {

    public ScubaMask() {
        super(AQMaterials.scubaMaterial, EntityEquipmentSlot.HEAD, "scuba_mask");
        setCreativeTab(AquaticUtilities.TAB);
    }

    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.isInWater() && player.getAir() >= 1) {
            if (player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ScubaTank) {
                ItemStack scuba_tank = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                NBTTagCompound tagCompound = scuba_tank.getTagCompound();
                int oxygen = Objects.requireNonNull(tagCompound).getInteger("oxygen");
                if (oxygen > 0) {
                    oxygen--;
                    tagCompound.setInteger("oxygen", oxygen);
                    player.setAir(300);
                }
                scuba_tank.setTagCompound(tagCompound);
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.GOLD + "Requires a Scuba Tank to Work!");
    }
}
