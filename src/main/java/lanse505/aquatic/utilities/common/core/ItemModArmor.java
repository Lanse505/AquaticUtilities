package lanse505.aquatic.utilities.common.core;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemModArmor extends ItemArmor {
    private String name;

    public ItemModArmor(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, String name) {
        super(materialIn, 0, equipmentSlotIn);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
    }
}
