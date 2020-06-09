package com.vulp.druidcraft.client.renders;

import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.datafixers.util.Pair;
import com.vulp.druidcraft.Druidcraft;
import com.vulp.druidcraft.DruidcraftRegistry;
import com.vulp.druidcraft.client.models.BoneShieldModel;
import com.vulp.druidcraft.client.models.ChitinShieldModel;
import com.vulp.druidcraft.client.models.MoonstoneShieldModel;
import com.vulp.druidcraft.items.BasicShieldItem;
import com.vulp.druidcraft.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Material;
import net.minecraft.client.renderer.model.ModelBakery;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.BannerTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.SkullTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.tileentity.SkullTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public class ItemTileEntityRenderer extends ItemStackTileEntityRenderer {

    private final BoneShieldModel bone_shield = new BoneShieldModel();
    private final ChitinShieldModel chitin_shield = new ChitinShieldModel();
    private final MoonstoneShieldModel moonstone_shield = new MoonstoneShieldModel();

    public static final ResourceLocation bone_shield_tex = DruidcraftRegistry.location("entity/shields/bone");
    public static final ResourceLocation chitin_shield_tex = DruidcraftRegistry.location("entity/shields/chitin");
    public static final ResourceLocation moonstone_shield_tex = DruidcraftRegistry.location("entity/shields/moonstone");

    public void render(ItemStack itemStack, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int packedLight, int packedOverlay) {
        Item item = itemStack.getItem();
        if (item instanceof BasicShieldItem) {
            matrixStack.push();
            matrixStack.scale(1.0F, -1.0F, -1.0F);
            if (item == ItemRegistry.bone_shield) {
                Material material = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, bone_shield_tex);
                IVertexBuilder vertexBuilder = material.getSprite().wrapBuffer(ItemRenderer.getBuffer(renderTypeBuffer, this.bone_shield.getRenderType(material.getAtlasLocation()), false, itemStack.hasEffect()));
                this.bone_shield.render(matrixStack, vertexBuilder, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            } else if (item == ItemRegistry.chitin_shield) {
                Material material = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, chitin_shield_tex);
                IVertexBuilder vertexBuilder = material.getSprite().wrapBuffer(ItemRenderer.getBuffer(renderTypeBuffer, this.chitin_shield.getRenderType(material.getAtlasLocation()), false, itemStack.hasEffect()));
                this.chitin_shield.render(matrixStack, vertexBuilder, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            } else { // item == ItemRegistry.moonstone_shield
                Material material = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, moonstone_shield_tex);
                IVertexBuilder vertexBuilder = material.getSprite().wrapBuffer(ItemRenderer.getBuffer(renderTypeBuffer, this.moonstone_shield.getRenderType(material.getAtlasLocation()), false, itemStack.hasEffect()));
                this.moonstone_shield.render(matrixStack, vertexBuilder, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            }
            matrixStack.pop();
        }
    }

}
