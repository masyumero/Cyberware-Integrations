package io.github.masyumero.cyberware_integrations.data.data.recipe;

import com.maxwell.cyber_ware_port.datagen.ModRecipeProvider;
import com.maxwell.cyber_ware_port.init.ModItems;
import io.github.masyumero.cyberware_integrations.common.registry.CIsItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
public class CIsRecipe extends RecipeProvider {
    public CIsRecipe(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        new ModRecipeProvider.AssemblyRecipeBuilder(CIsItems.THERMOREGULATOR.get())
                .requires(ModItems.COMPONENT_SYNTHNERVES.get(), 2)
                .requires(ModItems.COMPONENT_ACTUATOR.get(), 2)
                .requires(ModItems.COMPONENT_SSC.get(), 2)
                .requires(ModItems.COMPONENT_MICROELECTRIC.get() ,2)
                .save(consumer);
        new ModRecipeProvider.EngineeringRecipeBuilder(CIsItems.THERMOREGULATOR.get())
                .addOutput(ModItems.COMPONENT_SYNTHNERVES.get(), 2, 1.0f)
                .addOutput(ModItems.COMPONENT_ACTUATOR.get(), 2, 1.0f)
                .addOutput(ModItems.COMPONENT_SSC.get(), 2, 1.0f)
                .addOutput(ModItems.COMPONENT_MICROELECTRIC.get() ,2, 1.0f)
                .setBlueprintChance(0.15f)
                .save(consumer);

        new ModRecipeProvider.AssemblyRecipeBuilder(CIsItems.AUTO_INJECTOR.get())
                .requires(ModItems.COMPONENT_SYNTHNERVES.get(), 1)
                .requires(ModItems.COMPONENT_ACTUATOR.get(), 2)
                .requires(ModItems.COMPONENT_SSC.get(), 2)
                .save(consumer);
        new ModRecipeProvider.EngineeringRecipeBuilder(CIsItems.AUTO_INJECTOR.get())
                .addOutput(ModItems.COMPONENT_SYNTHNERVES.get(), 1, 1.0f)
                .addOutput(ModItems.COMPONENT_ACTUATOR.get(), 2, 1.0f)
                .addOutput(ModItems.COMPONENT_PLATING.get(), 2, 1.0f)
                .setBlueprintChance(0.15f)
                .save(consumer);
    }
}
