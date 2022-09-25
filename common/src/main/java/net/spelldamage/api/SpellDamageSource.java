package net.spelldamage.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;

import static net.spelldamage.api.MagicSchool.FIRE;

public class SpellDamageSource extends EntityDamageSource {
    public static DamageSource mob(MagicSchool school, LivingEntity attacker) {
        return SpellDamageSource.create(school, "mob", attacker);
    }

    public static DamageSource player(MagicSchool school, PlayerEntity attacker) {
        return SpellDamageSource.create(school, "player", attacker);
    }

    public static SpellDamageSource create(MagicSchool school, String name, Entity source) {
        var damageSource = new SpellDamageSource(name, source);
        damageSource.setUsesMagic();
        if (school == FIRE) {
            damageSource.setFire();
        }
        damageSource.setBypassesArmor();
        damageSource.setUnblockable();
        return damageSource;
    }

    public SpellDamageSource(String name, Entity source) {
        super(name, source);
    }

    @Override
    public DamageSource setFire() {
        return super.setFire();
    }

    @Override
    public DamageSource setBypassesArmor() {
        return super.setBypassesArmor();
    }

    @Override
    public DamageSource setUnblockable() {
        return super.setUnblockable();
    }
}