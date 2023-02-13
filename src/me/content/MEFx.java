package me.content;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.Draw;
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

public class MEFx
{
  public static final Rand rand = new Rand();

  public static final Effect 
    
  enhanceTrail = new Effect(50, e -> { color(Color.gray); Fill.circle(e.x, e.y, (e.fout() * 4f)); }),
  
  enhanceHit = new Effect(80, e -> { color(Pal.lightOrange); stroke(e.fout() * 2f); Lines.circle(e.x, e.y, (e.fout() + (e.fout() * 0.5f)) * 20f); Fill.circle(e.x, e.y, (e.fout() * 4f)); }),

  instaCraftEffect = new Effect(50, e -> { 
    color(Color.valueOf("44FCFF"));
    stroke(e.fout() * 2f); 
    Lines.circle(e.x, e.y, e.fslope() * 20f);
  }),
  
  lightningHitEffectOne = new Effect(200f, e -> {
    Draw.rect("me-satelliteCrash", e.x, e.y, (e.fout() * 2000f) + 1f, (e.fout() * 4000f) + 1f, (e.fin() * 90) + 120);
    color(Color.valueOf("ffffff"));
//     for(int i = 0; i < 16; i++){
//             float angle = rand.random(360f);
//             float lenRand = rand.random(0.5f, 1f);
//             Lines.lineAngle(e.x, e.y, angle, e.fin() * 70f * lenRand + 6f, e.fout() * 50f * rand.random(1f, 0.6f) + 2f);
//     }
    
  }),
   nextExplosion = new Effect(70f, 160f, e -> {
        color(Color.valueOf("ffffff"));
        stroke(e.fout() * 3f);
        float circleRad = 6f + e.finpow() * 60f;
        Lines.circle(e.x, e.y, circleRad);
        rand.setSeed(e.id);
     
        for(int i = 0; i < 16; i++){
            float angle = rand.random(360f);
            float lenRand = rand.random(0.5f, 1f);
            Lines.lineAngle(e.x, e.y, angle, e.foutpow() * 50f * rand.random(1f, 0.6f) + 2f, e.finpow() * 70f * lenRand + 6f);

        }
        float intensity = 8f;
        float baseLifetime = 25f + intensity * 15f;

        alpha(0.8f);
        for(int i = 0; i < 5; i++){
          
            rand.setSeed(e.id*2 + i);
            float lenScl = rand.random(0.25f, 1f);
            int fi = i;
            e.scaled(e.lifetime * lenScl, r -> {
                randLenVectors(r.id + fi - 1, r.fin(Interp.pow10Out), (int)(2.8f * intensity), 25f * intensity, (x, y, in, out) -> {
                    float fout = r.fout(Interp.pow5Out) * rand.random(0.5f, 1f);
                    float rad = fout * ((2f + intensity) * 1.1f);

                    Fill.circle(r.x + x, r.y + y, rad);
                });
            });
        }
    }),
  finalEffect = new SeqEffect(lightningHitEffectOne, nextExplosion);
                                     
}

