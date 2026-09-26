package io.github.masyumero.cyberware_integrations.data.client.model;

import io.github.masyumero.cyberware_integrations.CyberwareIntegrations;
import io.github.masyumero.cyberware_integrations.common.registry.CIsItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class CIsModel extends ItemModelProvider {

    public CIsModel(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CyberwareIntegrations.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        CIsItems.ITEMS.getEntries().forEach(item -> this.item(item.get()));
    }

    public void item(Item item) {
        item(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)));
    }

    public void item(ResourceLocation item) {
        getBuilder(item.toString() + "_scavenged")
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath() + "_scavenged"));
        getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
}
