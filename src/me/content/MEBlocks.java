package me.content;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.content.*;
import mindustry.content.Fx;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import me.content.MEFx;

import static mindustry.type.ItemStack.*;
import static mindustry.type.ItemStack.with;
import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;

public class MEBlocks {
	public static Block

		lightningEnhancer, arcaicReleaser;

	public static void load() {

// 		burner = new HeatGenericCrafter("burner") {{
// 			requirements(Category.power, with(Items.silicon, 20, Items.graphite, 30, Items.lead, 25));
// 			size = 2;
// 			health = 160;
// 			consume(new ConsumeItemFlammable());
// 			drawer = new DrawMulti(new DrawDefault(), new DrawFlame() {{
// 				flameRadius = 1.5f;
// 				flameRadiusIn = 0.75f;
// 				flameRadiusMag = 1f;
// 			}});
// 			craftTime = 120f;
// 			outputHeat = 250f;
// 			acceptsHeat = false;
// 			maxHeat = 500f;
// 		}};

    lightningEnhancer = new PowerTurret("lightEnhance") {{
			requirements(Category.turret, with(
							Items.lead, 120,
							Items.copper, 70
			));
			size = 2;
			health = 200;
			reload = 30f;
			range = 200f;
	    rotateSpeed = 4f;
			consumePower(4f);
			shootSound = Sounds.blaster;
	    localizedName = "Lightning Enhancer";
      
      
      shootType = new BasicBulletType(){{
        
                smokeEffect = Fx.shootSmokeTitan;
                hitColor = Color.valueOf("b33d0b");
                sprite = "enhanceBullet";
                trailEffect = Fx.missileTrail;
                fragOnHit = true;
                speed = 5f;
                damage = 180f;
                lifetime = 20f;
                width = height = 16f;
                backColor = Pal.surge;
                frontColor = Color.white;
                shrinkX = shrinkY = 0f;
                trailLength = 12;
                trailWidth = 2.2f;

                fragBullet = new PointBulletType(){{
                    shootEffect = Fx.none;
                    hitEffect = MEFx.enhanceHit;
                    smokeEffect = Fx.none;
                    trailEffect = MEFx.enhanceTrail;
                    despawnEffect = MEFx.enhanceHit;
                    damage = 60;
		    lifetime = 10f;
                    speed = 10;
			trailInterval = 6f;
                }};

                fragBullets = 4;
                fragVelocityMin = 0.5f;
                fragVelocityMax = 1.0f;
                fragLifeMin = 0.5f;
            }};

	}};
		
		
	    arcaicReleaser = new PowerTurret("arcaicRelease"){{
            requirements(Category.turret, with(Items.copper, 75, Items.lead, 25, Items.coal, 50, Items.sand, 50));
            shootType = new LightningBulletType(){{
                damage = 20;
                lightningLength = 25;
                collidesAir = false;
                ammoMultiplier = 10f;
		shoot.shots = 16; // YES IT FIANLLY WORKS
		localizedName = "Arcaic Release";

                lightningType = new BulletType(0.0001f, 0f){{
                    lifetime = Fx.lightning.lifetime;
                    hitEffect = Fx.hitLancer;
                    despawnEffect = Fx.none;
                    status = StatusEffects.shocked;
                    statusDuration = 10f;
                    hittable = false;
                    lightColor = Color.white;
                    collidesAir = false;
                    buildingDamageMultiplier = 0.25f;
                }};
            }};
            reload = 30f;
            shootCone = 60f;
            rotateSpeed = 6f;
            targetAir = false;
            range = 150f;
//             shootEffect = Fx.lightningShoot;
            heatColor = Color.black;
            recoil = 1.7f;
            size = 2;
            health = 450;
            shootSound = Sounds.spark;
            consumePower(3.3f);
            coolant = consumeCoolant(0.1f);
        }};

	}
}
