package net.spell_damage.mixin;

import net.minecraft.util.registry.Registry;
import net.spell_damage.Platform;
import net.spell_damage.SpellDamageMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Registry.class)
public class RegistryMixin {
    @Inject(method = "freezeRegistries", at = @At("HEAD"))
    private static void freezeRegistries_HEAD_SpellDamage(CallbackInfo ci) {
        if (Platform.Forge) {
            SpellDamageMod.loadConfig(); // Nice...
            SpellDamageMod.registerAttributes();
            SpellDamageMod.registerEnchantments();
        }
    }
}