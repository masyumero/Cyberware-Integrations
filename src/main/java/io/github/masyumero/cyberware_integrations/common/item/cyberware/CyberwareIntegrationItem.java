package io.github.masyumero.cyberware_integrations.common.item.cyberware;

import com.maxwell.cyber_ware_port.common.item.base.CyberwareItem;
import io.github.masyumero.cyberware_integrations.api.item.IIntegrationItem;

public abstract class CyberwareIntegrationItem extends CyberwareItem implements IIntegrationItem {

    public CyberwareIntegrationItem(Builder builder) {
        super(builder);
    }
}
