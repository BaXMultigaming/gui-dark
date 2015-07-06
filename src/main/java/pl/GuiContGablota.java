package pl;

import org.lwjgl.opengl.GL11;

import pl.TileEntityDisplayGablota;
import pl.ContainerGablota;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiContGablota extends GuiContainer {

	public GuiContGablota(Container par1Container) {
		super(par1Container);
	}

	public GuiContGablota (InventoryPlayer inventoryPlayer, TileEntityDisplayGablota tileEntity) {
		super(new ContainerGablota(inventoryPlayer, tileEntity));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		String s = I18n.format("container.gablota");
		fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		ResourceLocation texture = new ResourceLocation("dodatki:textures/gui/gablota.png");
		this.mc.renderEngine.bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}
