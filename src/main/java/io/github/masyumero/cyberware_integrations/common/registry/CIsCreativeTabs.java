package io.github.masyumero.cyberware_integrations.common.registry;

import com.maxwell.cyber_ware_port.common.CyberwareTabState;
import com.maxwell.cyber_ware_port.common.item.base.CyberwareItem;
import com.maxwell.cyber_ware_port.init.ModItems;
import io.github.masyumero.cyberware_integrations.CyberwareIntegrations;
import io.github.masyumero.cyberware_integrations.CyberwareIntegrationsLang;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public interface CIsCreativeTabs {
    DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CyberwareIntegrations.MODID);

    RegistryObject<CreativeModeTab> CIS_TAB = TABS.register("cyberware_integrations", () -> CreativeModeTab.builder()
            .title(Component.translatable(CyberwareIntegrationsLang.TAB.translationKey))
            .displayItems((pParameters, pOutput) -> {
                for (RegistryObject<Item> entry : CIsItems.ITEMS.getEntries()) {
                    var item = entry.get();

                    if (!(item instanceof CyberwareItem)) {
                        pOutput.accept(item);
                    }
                }
            })
            .build());

    static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModItems.CW_TABS.getKey()) {
            int page = CyberwareTabState.currentPage;

            for (RegistryObject<Item> entry : CIsItems.ITEMS.getEntries()) {
                var item = entry.get();

                if (item instanceof CyberwareItem cw) {
                    var stack = new ItemStack(item);
                    if (page == 1) {
                        cw.setPristine(stack, false);
                        event.accept(stack);
                    } else {
                        event.accept(stack);
                    }
                }
            }
        }
    }
}
