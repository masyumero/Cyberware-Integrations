package io.github.masyumero.cyberware_integrations.data;

import io.github.masyumero.cyberware_integrations.CyberwareIntegrations;
import io.github.masyumero.cyberware_integrations.data.client.lang.CIsLang;
import io.github.masyumero.cyberware_integrations.data.client.model.CIsModel;
import io.github.masyumero.cyberware_integrations.data.data.recipe.CIsRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = CyberwareIntegrations.MODID , bus = Mod.EventBusSubscriber.Bus.MOD)
public class CIsDataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeClient(), new CIsLang(output));
        generator.addProvider(event.includeClient(), new CIsModel(output, existingFileHelper));
        generator.addProvider(event.includeServer(), new CIsRecipe(output));
    }
}
