package pl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import pl.CommonProxy;
import pl.GuiHandler;
import pl.BlockGablota;
import pl.TileEntityDisplayGablota;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		
		int r = RenderingRegistry.getNextAvailableRenderId();

		r = RenderingRegistry.getNextAvailableRenderId();

		TileEntitySpecialRenderer render = new GablotaRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisplayGablota.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockGablota.instance), new ItemRenderGablota(render, new TileEntityDisplayGablota()));
        
	}
	
}
