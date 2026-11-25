package io.github.masyumero.cyberware_integrations.common.item.cyberware.lower_organs;

import com.maxwell.cyber_ware_port.common.block.robosurgeon.RobosurgeonBlockEntity;
import com.maxwell.cyber_ware_port.common.capability.CyberwareCapabilityProvider;
import io.github.masyumero.cyberware_integrations.common.Integration;
import io.github.masyumero.cyberware_integrations.common.item.cyberware.CyberwareIntegrationItem;
import lombok.Setter;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import toughasnails.api.player.ITANPlayer;
import toughasnails.api.potion.TANEffects;
import toughasnails.init.ModConfig;

public class DehydrationSuppressorItem extends CyberwareIntegrationItem {

    @Setter
    private int cooldown = 0;

    public DehydrationSuppressorItem() {
        super(new Builder(10, RobosurgeonBlockEntity.SLOT_STOMACH)
                .energy(0, 0, 0, StackingRule.STATIC)
                .eventCost(50)
        );
    }

    @Override
    public void onSystemTick(LivingEntity wearer, ItemStack stack) {
        if (isLoaded() && isActive(stack) && wearer instanceof Player player && ModConfig.thirst.enableThirst) {
            if (cooldown == 0) {
                wearer.getCapability(CyberwareCapabilityProvider.CYBERWARE_CAPABILITY).ifPresent(data -> {
                    if (((ITANPlayer) player).getThirstData().getThirst() <= 8) {
                        if (this.tryConsumeEventEnergy(data, stack)) {
                            ((ITANPlayer) player).getThirstData().addThirst(20);
                            player.addEffect(new MobEffectInstance(TANEffects.THIRST, 400));
                            cooldown = 1200;
                        }
                    }
                });
            } else {
                cooldown = Math.max(cooldown - 1, 0);
            }
        }
    }

    @Override
    public boolean canToggle(ItemStack stack) {
        return true;
    }

    @Override
    public Integration getIntegration() {
        return Integration.TOUGH_AS_NAILS;
    }
}
