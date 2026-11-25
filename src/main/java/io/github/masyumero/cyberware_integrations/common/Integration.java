package io.github.masyumero.cyberware_integrations.common;

import lombok.AllArgsConstructor;
import net.minecraftforge.fml.loading.LoadingModList;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public enum Integration {
    TOUGH_AS_NAILS("toughasnails");

    @NotNull
    private final String modId;

    public boolean isLoaded() {
        return LoadingModList.get().getModFileById(modId) != null;
    }
}
