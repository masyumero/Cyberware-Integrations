package io.github.masyumero.cyberware_integrations.common.registry;

import io.github.masyumero.cyberware_integrations.CyberwareIntegrations;
import io.github.masyumero.cyberware_integrations.common.Integration;
import io.github.masyumero.cyberware_integrations.common.item.cyberware.heart.ThermoregulatorItem;
import io.github.masyumero.cyberware_integrations.common.item.cyberware.arm.AutoInjectorItem;
import io.github.masyumero.cyberware_integrations.common.item.cyberware.lower_organs.DehydrationSuppressorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class CIsItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CyberwareIntegrations.MODID);

    public static final RegistryObject<Item> THERMOREGULATOR = ITEMS.register("heart_upgrades_thermoregulator", ThermoregulatorItem::new);
    public static final RegistryObject<Item> AUTO_INJECTOR = ITEMS.register("limbs_upgrades_auto_injector", AutoInjectorItem::new);
    public static final RegistryObject<Item> DEHYDRATION_SUPPRESSOR = ITEMS.register("lower_organs_dehydration_suppresor", DehydrationSuppressorItem::new);
}
