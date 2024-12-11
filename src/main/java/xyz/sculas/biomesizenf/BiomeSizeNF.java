package xyz.sculas.biomesizenf;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(BiomeSizeNF.MODID)
public class BiomeSizeNF {
    public static final String MODID = "biomesizenf";

    public BiomeSizeNF(ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
