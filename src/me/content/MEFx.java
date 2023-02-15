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

import java.util.*;

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
  
  satelliteComingDown = new Effect(200f, e -> {
    float randomAng = rand.random(360);
    Draw.rect("me-satelliteCrash", e.x, e.y, (e.fout() * 200f) + 50f, (e.fout() * 400f) + 100f, (e.fin() * 360));
    Draw.z(99);
    Draw.color(0, 0, 0, 0.4f * 1f);
    Draw.rect("circle-shadow", e.x, e.y, (e.fout() * 500f) + 100f, (e.fout() * 500f) + 100f);
    Draw.color();
  }),
  
   nextExplosion = new Effect(70f, 160f, e -> {
     
        color(Color.valueOf("ffffff"));
        stroke(e.fout() * 3f);
        color(Color.valueOf("ffffff"));
        float circleRad = 6f + e.finpow() * 250f;
        color(Color.valueOf("ffffff"));
        Lines.circle(e.x, e.y, circleRad);
        rand.setSeed(e.id);
     
        color(Color.valueOf("ffb361"));     
        for(int i = 0; i < 16; i++){
            float angle = rand.random(360f);
            float lenRand = rand.random(0.5f, 1f);
            Lines.lineAngle(e.x, e.y, angle, e.foutpow() * 70f * rand.random(1f, 0.6f) + 2f, e.finpow() * 90f * lenRand + 6f);
        }
     
        float intensity = 8f;
        float baseLifetime = 25f + intensity * 15f;
        color(Color.valueOf("737373"));     
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
  
  
  firstShadow = new Effect(100f, e -> {
//     Drawf.shadow(e.x, e.y, 10f, 4f);
    Draw.z(99);
    Draw.color(0, 0, 0, 0.4f * (1f * e.fin()));
    Draw.rect("circle-shadow", e.x, e.y, 500f, 500f);
    Draw.color();    
  }),
    fadeInView = new Effect(100f, e -> {
    Draw.z(99);
    Draw.color(0, 0, 0, 0.4f * 1f);
    Draw.rect("circle-shadow", e.x, e.y, 600f, 600f);
    Draw.color();
    Draw.z(110);
    Draw.alpha(e.fin());
    Draw.rect("me-satelliteCrash", e.x, e.y, (e.fout() * 50f) + 250f, (e.fout() * 100f) + 500f, (e.fin() * 180) + 180);
    Draw.color();
  }),

  finalEffect = new SeqEffect(firstShadow, fadeInView, satelliteComingDown, nextExplosion);
                                     
}

