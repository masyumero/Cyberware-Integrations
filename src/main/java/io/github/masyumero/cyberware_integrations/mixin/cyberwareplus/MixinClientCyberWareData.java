package io.github.masyumero.cyberware_integrations.mixin.cyberwareplus;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.maxwell.cyber_ware_port.common.capability.CyberwareUserData;
import com.msdoggirl.cyberwareplus.ClientCyberwareData;
import cyberspells.registration.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ClientCyberwareData.class, remap = false)
public class MixinClientCyberWareData {

    @ModifyExpressionValue(method = "lambda$getState$0", at = @At(value = "INVOKE", target = "Lcom/maxwell/cyber_ware_port/common/capability/CyberwareUserData;isCyberwareInstalled(Lnet/minecraft/world/item/Item;)Z", ordinal = 2))
    private static boolean cyberHeartModifyExpressionValue(boolean original, @Local(argsOnly = true) CyberwareUserData data) {
        return original || data.isCyberwareInstalled(ModItems.RUNE_HEART.get());
    }
    @ModifyExpressionValue(method = "lambda$getState$0", at = @At(value = "INVOKE", target = "Lcom/maxwell/cyber_ware_port/common/capability/CyberwareUserData;isCyberwareInstalled(Lnet/minecraft/world/item/Item;)Z", ordinal = 7))
    private static boolean cyberRightArmModifyExpressionValue(boolean original, @Local(argsOnly = true) CyberwareUserData data) {
        return original || data.isCyberwareInstalled(ModItems.RUNE_ARM_RIGHT.get());
    }
    @ModifyExpressionValue(method = "lambda$getState$0", at = @At(value = "INVOKE", target = "Lcom/maxwell/cyber_ware_port/common/capability/CyberwareUserData;isCyberwareInstalled(Lnet/minecraft/world/item/Item;)Z", ordinal = 8))
    private static boolean cyberLeftArmModifyExpressionValue(boolean original, @Local(argsOnly = true) CyberwareUserData data) {
        return original || data.isCyberwareInstalled(ModItems.RUNE_ARM_LEFT.get());
    }
    @ModifyExpressionValue(method = "lambda$getState$0", at = @At(value = "INVOKE", target = "Lcom/maxwell/cyber_ware_port/common/capability/CyberwareUserData;isCyberwareInstalled(Lnet/minecraft/world/item/Item;)Z", ordinal = 9))
    private static boolean cyberRightLegModifyExpressionValue(boolean original, @Local(argsOnly = true) CyberwareUserData data) {
        return original || data.isCyberwareInstalled(ModItems.RUNE_LEG_RIGHT.get());
    }
    @ModifyExpressionValue(method = "lambda$getState$0", at = @At(value = "INVOKE", target = "Lcom/maxwell/cyber_ware_port/common/capability/CyberwareUserData;isCyberwareInstalled(Lnet/minecraft/world/item/Item;)Z", ordinal = 10))
    private static boolean cyberLeftLegModifyExpressionValue(boolean original, @Local(argsOnly = true) CyberwareUserData data) {
        return original || data.isCyberwareInstalled(ModItems.RUNE_LEG_LEFT.get());
    }
}
