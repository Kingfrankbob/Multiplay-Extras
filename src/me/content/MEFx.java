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
  public static final Effect 
    
  enhanceTrail = new Effect(50, e -> { color(Color.gray); Fill.circle(e.x, e.y, (e.fout() * 4f)); }),
  
  enhanceHit = new Effect(80, e -> { color(Pal.lightOrange); stroke(e.fout() * 2f); Lines.circle(e.x, e.y, (e.fout() + (e.fout() * 0.5f)) * 20f); Fill.circle(e.x, e.y, (e.fout() * 4f)); }),

  instaCraftEffect = new Effect(50, e -> { 
    color(Color.valueOf("44FCFF"));
    stroke(e.fout() * 2f); 
    Lines.circle(e.x, e.y, e.fslope() * 20f);
  }),
  
  lightningHitEffectOne = new Effect(200, e -> {
    Draw.rect("me-satelliteCrash", e.x, e.y, (e.fout(20f) * 800f), (e.fout(20f) * 800f), e.fin() + 90);
    color(b.color, 0.7f);
        for(int i = 0; i < 4; i++){
            rand.setSeed(b.id*2 + i);
            float lenScl = rand.random(0.5f, 1f);
            int fi = i;
            b.scaled(b.lifetime * lenScl, e -> {
                randLenVectors(e.id + fi - 1, e.fin(Interp.pow10Out), (int)(2.9f * intensity), 22f * intensity, (x, y, in, out) -> {
                    float fout = e.fout(Interp.pow5Out) * rand.random(0.5f, 1f);
                    float rad = fout * ((2f + intensity) * 2.35f);

                    Fill.circle(e.x + x, e.y + y, rad);
                    Drawf.light(e.x + x, e.y + y, rad * 2.5f, b.color, 0.5f);
                });
            });
        }
  });
                                     
}

