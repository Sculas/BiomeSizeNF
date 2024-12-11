package xyz.sculas.biomesizenf;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = BiomeSizeNF.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.IntValue BIOME_SIZE_MODIFIER = BUILDER.
            comment(" The modifier to apply to the biome size (- is smaller, + is larger).").
            defineInRange("biomeSizeModifier", 0, -8, 8);

    public static final ModConfigSpec SPEC = BUILDER.build();
    public static int biomeSizeModifier;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        biomeSizeModifier = BIOME_SIZE_MODIFIER.get();
    }
}
