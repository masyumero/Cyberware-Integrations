package io.github.masyumero.cyberware_integrations.common.item.cyberware.heart;

import com.maxwell.cyber_ware_port.common.block.robosurgeon.RobosurgeonBlockEntity;
import com.maxwell.cyber_ware_port.common.capability.CyberwareCapabilityProvider;
import com.maxwell.cyber_ware_port.common.item.base.CyberwareItem;
import io.github.masyumero.cyberware_integrations.api.item.IIntegrationItem;
import io.github.masyumero.cyberware_integrations.common.Integration;
import io.github.masyumero.cyberware_integrations.common.item.cyberware.CyberwareIntegrationItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import toughasnails.api.player.ITANPlayer;
import toughasnails.api.temperature.TemperatureLevel;
import toughasnails.init.ModConfig;

public class ThermoregulatorItem extends CyberwareIntegrationItem {

    public ThermoregulatorItem() {
        super(new Builder(2, RobosurgeonBlockEntity.SLOT_HEART)
                .energy(0, 0, 0, StackingRule.STATIC)
                .eventCost(100)
        );
    }

    @Override
    public void onSystemTick(LivingEntity wearer, ItemStack stack) {
        if (wearer instanceof Player player) {
            if (isLoaded() && ModConfig.temperature.enableTemperature) {
                wearer.getCapability(CyberwareCapabilityProvider.CYBERWARE_CAPABILITY).ifPresent(data -> {
                    if (((ITANPlayer) player).getTemperatureData().getLevel() != TemperatureLevel.NEUTRAL) {
                        if (this.tryConsumeEventEnergy(data, stack)) {
                            ((ITANPlayer) player).getTemperatureData().setLevel(TemperatureLevel.NEUTRAL);
                        }
                    }
                });
            }
        }
    }

    @Override
    public Integration getIntegration() {
        return Integration.TOUGH_AS_NAILS;
    }
}