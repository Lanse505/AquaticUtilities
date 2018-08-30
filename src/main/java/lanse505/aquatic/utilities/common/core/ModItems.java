package lanse505.aquatic.utilities.common.core;

import lanse505.aquatic.utilities.common.scuba.ScubaMask;
import lanse505.aquatic.utilities.common.scuba.ScubaRebreather;
import lanse505.aquatic.utilities.common.scuba.ScubaTank;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    @GameRegistry.ObjectHolder("aquaticutilities:scuba_mask")
    public static ScubaMask scubaMask;

    @GameRegistry.ObjectHolder("acquaticutilities:scuba_rebreather")
    public static ScubaRebreather rebreather;

    @GameRegistry.ObjectHolder("acquaticutilities:scuba_tank")
    public static ScubaTank scubaTank;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        scubaMask.initModel();
        rebreather.initModel();
        scubaTank.initModel();
    }
}
