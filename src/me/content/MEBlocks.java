package me.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
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

import static mindustry.type.ItemStack.*;
import static mindustry.type.ItemStack.with;
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

    lightningEnhancer = new PowerTurret("enhancerL") {{
			requirements(Category.turret, with(
							Items.lead, 120,
							Items.copper, 70
			));
			size = 2;
			health = 200;
			reload = 30f;
			range = 120f;
			consumePower(4f);
			shootSound = Sounds.blaster;
      
      
      shootType = new BasicBulletType(){{
        
                smokeEffect = Fx.shootSmokeTitan;
                hitColor = Pal.surge;

                sprite = "large-orb";
                trailEffect = Fx.missileTrail;
                trailInterval = 3f;
                trailParam = 4f;
//                 pierceCap = 2;
                fragOnHit = true;
                speed = 5f;
                damage = 180f;
                lifetime = 20f;
                width = height = 16f;
                backColor = Pal.surge;
                frontColor = Color.white;
                shrinkX = shrinkY = 0f;
//                 trailColor = Pal.surge;
                trailLength = 12;
                trailWidth = 2.2f;
//                 despawnSound = Sounds.dullExplosion;
//                 shootSound = Sounds.cannon;

                fragBullet = new PointBulletType(){{
                    shootEffect = Fx.magmasmoke;
                    hitEffect = Fx.hitLancer;
                    smokeEffect = Fx.smokeCloud;
                    trailEffect = Fx.flakExplosion;
                    despawnEffect = Fx.instBomb;
                    trailSpacing = 20f;
                    damage = 60;
		    lifetime = 10f;
                    speed = 20;
                    hitShake = 6f;
                }};

//                 bulletInterval = 3f;
//                 intervalRandomSpread = 20f;
//                 intervalBullets = 2;
//                 intervalAngle = 180f;
//                 intervalSpread = 300f;

                fragBullets = 4;
                fragVelocityMin = 0.5f;
                fragVelocityMax = 1.5f;
                fragLifeMin = 0.5f;
            }};

		}};
		
		
	    arcaicReleaser = new PowerTurret("arcRel"){{
            requirements(Category.turret, with(Items.copper, 75, Items.lead, 25, Items.coal, 50, Items.sand, 50));
            shootType = new LightningBulletType(){{
                damage = 20;
                lightningLength = 50;
                collidesAir = false;
                ammoMultiplier = 10f;
// 		name = "Arcaic Release";
                //for visual stats only.
                buildingDamageMultiplier = 0.25f;

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
            range = 100f;
            shootEffect = Fx.lightningShoot;
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
