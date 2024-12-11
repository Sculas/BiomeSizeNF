package xyz.sculas.biomesizenf.mixin;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.serialization.Decoder;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.sculas.biomesizenf.Config;

import java.util.Set;

@Mixin(RegistryDataLoader.class)
public class RegistryDataLoaderMixin {
    @Unique
    private static final Set<ResourceLocation> KEYS_TO_FIX = ImmutableSet.of(
            ResourceLocation.withDefaultNamespace("temperature"),
            ResourceLocation.withDefaultNamespace("vegetation")
    );

    @Inject(method = "loadElementFromResource", at = @At(value = "INVOKE", target = "Lcom/mojang/serialization/Decoder;parse(Lcom/mojang/serialization/DynamicOps;Ljava/lang/Object;)Lcom/mojang/serialization/DataResult;", remap = false))
    private static <E> void onElementLoadFromResource(
            WritableRegistry<E> registry, Decoder<E> codec, RegistryOps<JsonElement> ops,
            ResourceKey<E> resourceKey, Resource resource, RegistrationInfo registrationInfo,
            CallbackInfo ci, @Local JsonElement element) {
        if (!KEYS_TO_FIX.contains(resourceKey.location())) return;
        if (!(element instanceof JsonObject object)) return;
        var biomeSizeModifier = object.get("firstOctave").getAsInt() - Config.biomeSizeModifier;
        object.addProperty("firstOctave", Math.clamp(biomeSizeModifier, -14, -2));
    }
}
