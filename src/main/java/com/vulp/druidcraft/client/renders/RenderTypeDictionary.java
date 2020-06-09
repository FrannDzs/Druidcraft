package com.vulp.druidcraft.client.renders;

import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTypeDictionary extends RenderState{

    public RenderTypeDictionary(String p_i225973_1_, Runnable p_i225973_2_, Runnable p_i225973_3_) {
        super(p_i225973_1_, p_i225973_2_, p_i225973_3_);
    }

    public static RenderType getEntityGlow(ResourceLocation resourceLocation) {
        RenderState.TextureState textureState = new RenderState.TextureState(resourceLocation, false, false);
        return RenderType.makeType("glow", DefaultVertexFormats.ENTITY, 7, 256, false, true, RenderType.State.getBuilder().texture(textureState).transparency(ADDITIVE_TRANSPARENCY).writeMask(COLOR_WRITE).fog(BLACK_FOG).build(false));
    }

}
