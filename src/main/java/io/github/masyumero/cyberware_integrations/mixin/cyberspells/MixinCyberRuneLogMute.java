package io.github.masyumero.cyberware_integrations.mixin.cyberspells;

import cyberspells.items.CyberRuneArmItem;
import cyberspells.items.CyberRuneHeartItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.PrintStream;

@Mixin(value = {CyberRuneArmItem.class, CyberRuneHeartItem.class}, remap = false)
public class MixinCyberRuneLogMute {

    @Redirect(method = "getSlot", at = @At(value = "INVOKE", target = "Ljava/io/PrintStream;println(Ljava/lang/String;)V"))
    private void getSlotRedirect(PrintStream instance, String x)  {
    }
}
