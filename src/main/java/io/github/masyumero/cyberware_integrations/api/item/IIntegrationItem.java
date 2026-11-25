package io.github.masyumero.cyberware_integrations.api.item;

import io.github.masyumero.cyberware_integrations.common.Integration;

public interface IIntegrationItem {

    Integration getIntegration();

    default boolean isLoaded() {
        return getIntegration().isLoaded();
    }
}
