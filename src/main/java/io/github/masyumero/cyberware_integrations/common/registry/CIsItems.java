package io.github.masyumero.cyberware_integrations.common.registry;

import io.github.masyumero.cyberware_integrations.CyberwareIntegrations;
import io.github.masyumero.cyberware_integrations.common.item.cyberware.heart.ThermoregulatorItem;
import io.github.masyumero.cyberware_integrations.common.item.cyberware.muscle.AutoInjectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public interface CIsItems {

    DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CyberwareIntegrations.MODID);

    RegistryObject<Item> THERMOREGULATOR = ITEMS.register("heart_upgrades_thermoregulator", ThermoregulatorItem::new);
    RegistryObject<Item> AUTO_INJECTOR = ITEMS.register("limbs_upgrades_auto_injector", AutoInjectorItem::new);
}
