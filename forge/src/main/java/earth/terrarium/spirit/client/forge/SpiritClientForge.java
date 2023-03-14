package earth.terrarium.spirit.client.forge;

import earth.terrarium.spirit.client.SpiritClient;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Supplier;

public class SpiritClientForge {

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(SpiritClientForge::onRegisterLayerDefinitions);
    }

    public static void postInit() {
    }

    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        SpiritClient.registerEntityLayers(new SpiritClient.LayerDefinitionRegistry() {
            @Override
            public void register(ModelLayerLocation location, Supplier<LayerDefinition> definition) {
                event.registerLayerDefinition(location, definition);
            }
        });
    }
}
