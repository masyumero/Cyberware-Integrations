package io.github.masyumero.cyberware_integrations.common.item.cyberware.muscle;

import com.maxwell.cyber_ware_port.common.block.robosurgeon.RobosurgeonBlockEntity;
import com.maxwell.cyber_ware_port.common.capability.CyberwareCapabilityProvider;
import com.maxwell.cyber_ware_port.common.item.base.CyberwareItem;
import com.maxwell.cyber_ware_port.init.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class AutoInjectorItem extends CyberwareItem {

    public AutoInjectorItem() {
        super(new Builder(2, RobosurgeonBlockEntity.SLOT_ARMS)
                .energy(0, 0, 0, StackingRule.STATIC)
                .eventCost(50)
        );
    }

    @Override
    public void onSystemTick(LivingEntity wearer, ItemStack stack) {
        if (wearer instanceof Player player) {
            wearer.getCapability(CyberwareCapabilityProvider.CYBERWARE_CAPABILITY).ifPresent(data -> {
                if (data.getImmunityTime() == 0 && player.getInventory().hasAnyMatching(i -> i.is(ModItems.NEUROPOZYNE.get()))) {
                    if (this.tryConsumeEventEnergy(data, stack)) {
                        ModItems.NEUROPOZYNE.get().finishUsingItem(stack, player.level(), wearer);
                    }
                }
            });
        }
    }
}
