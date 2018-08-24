package lanse505.aquatic.utilities.common.core;

import lanse505.aquatic.utilities.AquaticUtilities;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ItemModArmor extends ItemArmor {
    private String name;

    public ItemModArmor(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, String name) {
        super(materialIn, 0, equipmentSlotIn);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
    }

    public void registerItemModel(Item item) {
        AquaticUtilities.proxy.registerItemRenderer(this, 0, name);
    }

}
