package io.github.masyumero.cyberware_integrations.common.item.cyberware.heart;

import com.maxwell.cyber_ware_port.common.block.robosurgeon.RobosurgeonBlockEntity;
import com.maxwell.cyber_ware_port.common.capability.CyberwareCapabilityProvider;
import com.maxwell.cyber_ware_port.common.item.base.CyberwareItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import toughasnails.api.player.ITANPlayer;
import toughasnails.api.temperature.TemperatureLevel;

public class ThermoregulatorItem extends CyberwareItem {

    public ThermoregulatorItem() {
        super(new Builder(2, RobosurgeonBlockEntity.SLOT_HEART)
                .energy(0, 0, 0, StackingRule.STATIC)
                .eventCost(100)
        );
    }

    @Override
    public void onSystemTick(LivingEntity wearer, ItemStack stack) {
        if (wearer instanceof Player player) {
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