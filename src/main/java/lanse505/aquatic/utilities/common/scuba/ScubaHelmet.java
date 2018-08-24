package lanse505.aquatic.utilities.common.scuba;

import lanse505.aquatic.utilities.common.core.ItemModArmor;
import lanse505.aquatic.utilities.utility.AQCreativeTab;
import lanse505.aquatic.utilities.utility.AQMaterials;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ScubaHelmet extends ItemModArmor {

    public ScubaHelmet() {
        super(AQMaterials.scubaMaterial, EntityEquipmentSlot.HEAD, "scuba_rebreather");
        setCreativeTab(AQCreativeTab.AQ_CREATIVE_TAB);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.isInWater() && player.getAir() <= 1) {
            if (player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ScubaChest) {

            }
        }
    }

}
