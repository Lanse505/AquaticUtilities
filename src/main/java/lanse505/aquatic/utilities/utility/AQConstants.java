package lanse505.aquatic.utilities.utility;

import lanse505.aquatic.utilities.common.scuba.ScubaChest;
import lanse505.aquatic.utilities.common.scuba.ScubaRebreather;
import net.minecraft.item.Item;

public class AQConstants {
    public static final String MOD_ID = "aquaticutilities";
    public static final String MOD_NAME = "Aquatic Utilities";
    public static final String VERSION = "1.12.2-1.0.0";
    public static final String MCVER = "1.12,";

    //Proxy Constants
    public static final String PROXY_COMMON = "lanse505.aquatic.utilities.common.proxy.CommonProxy";
    public static final String PROXY_CLIENT = "lanse505.aquatic.utilities.client.ClientProxy";

    // Item
    public static Item SCUBA_TANK = new ScubaChest();
    public static Item REBREATHER = new ScubaRebreather();

}
