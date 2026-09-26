package io.github.masyumero.cyberware_integrations.data.client.lang;

import io.github.masyumero.cyberware_integrations.CyberwareIntegrations;
import io.github.masyumero.cyberware_integrations.CyberwareIntegrationsLang;
import io.github.masyumero.cyberware_integrations.common.registry.CIsItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.LanguageProvider;

public class CIsLang extends LanguageProvider {
    public CIsLang(PackOutput output) {
        super(output, CyberwareIntegrations.MODID, "ja_jp");
    }

    @Override
    protected void addTranslations() {
        add(CyberwareIntegrationsLang.TAB.translationKey, "Cyberware:Integrations");
        addCyberware(CIsItems.THERMOREGULATOR.get(), "体温調節器", "体温を調節し適度に保ちます");
        addCyberware(CIsItems.AUTO_INJECTOR.get(), "自動抑制注射器", "自動でインベントリ内のニューロポザインを使用します");
    }

    private void addCyberware(ItemLike item, String name, String tooltip) {
        add(item.asItem(), name);
        add("cyberware.tooltip." + item.asItem(), tooltip);
    }
}
