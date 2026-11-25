package io.github.masyumero.cyberware_integrations.data.data.recipe;

import com.maxwell.cyber_ware_port.datagen.ModRecipeProvider;
import com.maxwell.cyber_ware_port.init.ModItems;
import io.github.masyumero.cyberware_integrations.common.registry.CIsItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
public class CIsRecipe extends RecipeProvider {
    public CIsRecipe(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        simpleCyberwareRecipe(CIsItems.THERMOREGULATOR.get(), consumer, 0.15f,
                component(ModItems.COMPONENT_SYNTHNERVES.get(), 2, 1.0f),
                component(ModItems.COMPONENT_ACTUATOR.get(), 2, 1.0f),
                component(ModItems.COMPONENT_SSC.get(), 2, 1.0f),
                component(ModItems.COMPONENT_MICROELECTRIC.get(), 2, 1.0f)
        );

        simpleCyberwareRecipe(CIsItems.AUTO_INJECTOR.get(), consumer, 0.15f,
                component(ModItems.COMPONENT_SYNTHNERVES.get(), 1, 1.0f),
                component(ModItems.COMPONENT_ACTUATOR.get(), 2, 1.0f),
                component(ModItems.COMPONENT_SSC.get(), 2, 1.0f)
        );

        simpleCyberwareRecipe(CIsItems.DEHYDRATION_SUPPRESSOR.get(), consumer, 0.15f,
                component(ModItems.COMPONENT_TITANIUM.get(), 2, 1.0f),
                component(ModItems.COMPONENT_PLATING.get(), 1, 1.0f),
                component(ModItems.COMPONENT_SYNTHNERVES.get(), 2, 1.0f),
                component(ModItems.COMPONENT_MICROELECTRIC.get(), 1, 1.0f),
                component(Items.GLASS_BOTTLE, 1, 0.5f)
        );
    }

    private static void simpleCyberwareRecipe(Item cyberware, Consumer<FinishedRecipe> consumer, float bpChance, Component... components) {
        var assemblyRecipe = new ModRecipeProvider.AssemblyRecipeBuilder(cyberware);
        var engineeringRecipe = new ModRecipeProvider.EngineeringRecipeBuilder(cyberware);
        for (Component component : components) {
            assemblyRecipe.requires(component.item, component.count);
            engineeringRecipe.addOutput(component.item, component.count, component.chance);
        }
        assemblyRecipe.save(consumer);
        engineeringRecipe.setBlueprintChance(bpChance);
        engineeringRecipe.save(consumer);
    }

    private static Component component(Item item, int count, float chance) {
        return new Component(item, count, chance);
    }

    private record Component(Item item, int count, float chance) {}
}
