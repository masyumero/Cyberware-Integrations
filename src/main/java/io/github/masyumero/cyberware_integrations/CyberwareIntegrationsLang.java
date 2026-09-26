package io.github.masyumero.cyberware_integrations;

public enum CyberwareIntegrationsLang {
    TAB("constants", "mod_name");

    public final String translationKey;

    CyberwareIntegrationsLang(String type, String path) {
        this.translationKey = type + "." + CyberwareIntegrations.MODID + "." + path;
    }
}
