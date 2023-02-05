package me.content;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Sounds;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.type.Category;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.*;

public class MEBlocks {
	public static Block

		lightningEnhancer;

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
							Items.silicon, 120,
							Items.copper, 70,
							SWItems.compound, 95
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

                fragBullet = intervalBullet = new PointBulletType(){{
                    shootEffect = Fx.instShoot;
                    hitEffect = Fx.instHit;
                    smokeEffect = Fx.smokeCloud;
                    trailEffect = Fx.instTrail;
                    despawnEffect = Fx.instBomb;
                    trailSpacing = 20f;
                    damage = 60;
                    buildingDamageMultiplier = 0.2f;
                    speed = 60;
                    hitShake = 6f;
                }};

                bulletInterval = 3f;
                intervalRandomSpread = 20f;
                intervalBullets = 2;
                intervalAngle = 180f;
                intervalSpread = 300f;

                fragBullets = 20;
                fragVelocityMin = 0.5f;
                fragVelocityMax = 1.5f;
                fragLifeMin = 0.5f;
            }};

		}};

	}
}
