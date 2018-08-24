package lanse505.aquatic.utilities.utility;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class AQMaterials {
    public static final ItemArmor.ArmorMaterial scubaMaterial = EnumHelper.addArmorMaterial("scuba", AQConstants.MOD_ID + ":scuba", 256, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
}
