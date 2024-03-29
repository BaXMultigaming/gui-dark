package pl;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderGablota implements IItemRenderer {
	TileEntitySpecialRenderer render;
	private TileEntity dummytile;
	  
	public ItemRenderGablota(TileEntitySpecialRenderer render, TileEntity dummy) {
	    this.render = render;
	    this.dummytile = dummy;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if (type == IItemRenderer.ItemRenderType.ENTITY)
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
		this.render.renderTileEntityAt(this.dummytile, 0.0D, 0.0D, 0.0D, 0.0F);
	}
}
