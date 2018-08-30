package lanse505.aquatic.utilities.common.proxy;

import lanse505.aquatic.utilities.common.core.ItemModArmor;
import lanse505.aquatic.utilities.common.scuba.ScubaTank;
import lanse505.aquatic.utilities.common.scuba.ScubaMask;
import lanse505.aquatic.utilities.common.scuba.ScubaRebreather;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
    public static ItemModArmor REBREATHER = new ScubaRebreather();
    public static ItemModArmor SCUBA_TANK = new ScubaTank();

    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ScubaRebreather());
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ScubaMask(),
                new ScubaTank(),
                new ScubaRebreather()
        );
    }


}
