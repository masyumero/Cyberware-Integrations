package io.github.masyumero.cyberware_integrations.mixin.cyber_ware_port;

import com.llamalad7.mixinextras.sugar.Local;
import com.maxwell.cyber_ware_port.common.entity.EntitiesItemDropEvents;
import com.maxwell.cyber_ware_port.common.entity.ICyberwareMob;
import io.github.masyumero.cyberware_integrations.common.registry.CIsItems;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(value = EntitiesItemDropEvents.class, remap = false)
public class MixinEntitiesItemDropEvents {

    @Inject(method = "generateMobDropPool", at = @At(value = "INVOKE", target = "Ljava/util/List;addAll(Ljava/util/Collection;)Z", shift = At.Shift.AFTER))
    private static void entryModify(ICyberwareMob cyberMob, CallbackInfoReturnable<List<Item>> cir, @Local(name = "pool") List<Item> pool) {
        pool.add(CIsItems.THERMOREGULATOR.get());
        pool.add(CIsItems.AUTO_INJECTOR.get());
    }
}
