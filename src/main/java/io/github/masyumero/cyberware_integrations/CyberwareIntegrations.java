package io.github.masyumero.cyberware_integrations;

import com.mojang.logging.LogUtils;
import io.github.masyumero.cyberware_integrations.common.registry.CIsCreativeTabs;
import io.github.masyumero.cyberware_integrations.common.registry.CIsItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CyberwareIntegrations.MODID)
public class CyberwareIntegrations {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "cyberware_integrations";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation rl(String id) {
        return ResourceLocation.fromNamespaceAndPath(MODID, id);
    }

    @SuppressWarnings("removal")
    public CyberwareIntegrations() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CIsItems.ITEMS.register(modEventBus);
        modEventBus.addListener(CIsCreativeTabs::buildContents);
    }
}
