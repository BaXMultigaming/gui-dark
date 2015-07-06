package pl;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

import pl.GuiContGablota;
import pl.TileEntityDisplayGablota;
import pl.ContainerGablota;

public class GuiHandler implements IGuiHandler {
	@Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if(id == 0) {
			TileEntity tileEntity = world.getTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityDisplayGablota){
				return new ContainerGablota(player.inventory, (TileEntityDisplayGablota) tileEntity);
			}
		}
		return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
    	if(id == 0) {
			TileEntity tileEntity = world.getTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityDisplayGablota){
				return new GuiContGablota(player.inventory, (TileEntityDisplayGablota) tileEntity);
			}
    	}
		return null;
    }
}
