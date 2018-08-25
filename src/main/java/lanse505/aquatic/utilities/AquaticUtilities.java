package lanse505.aquatic.utilities;

import lanse505.aquatic.utilities.common.proxy.CommonProxy;
import lanse505.aquatic.utilities.utility.AQConstants;
import lanse505.aquatic.utilities.utility.AQCreativeTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = AQConstants.MOD_ID, name = AQConstants.MOD_NAME, version = AQConstants.VERSION, acceptedMinecraftVersions = AQConstants.MCVER)
public class AquaticUtilities {
    public static AQCreativeTab aqCreativeTab = new AQCreativeTab();

    @SidedProxy(serverSide = AQConstants.PROXY_COMMON, clientSide = AQConstants.PROXY_CLIENT, modId = AQConstants.MOD_ID)
    public static CommonProxy proxy;
    public static Logger logger;

    @Mod.Instance
    public static AquaticUtilities aqUtils;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
