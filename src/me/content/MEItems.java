package ME.content;

import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.entities.units.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import arc.*;
import arc.graphics.*;
import arc.math.*;
import arc.util.*;

public class MEItems implements ContentList {
  public static Item istantium;
  
  public void load(){

  istantium = new Item("me-istantium", Color.valueOf("00EAFF")){{
    localizedName = "Instantium";
    description = "A Super Conductive, Relatively Radioactive, Hard Metal. Can be used to build electricity based structures. "
    hardness = 2;
    radioactivity = -1f;
    charge = 3.5f;
  }};

 }
}