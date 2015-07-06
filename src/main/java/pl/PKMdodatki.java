package pl; 

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.EnumMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;


@Mod(modid = "test", name = "PKM Dodatki", version = "1.0")
public class PKMdodatki{
	@Instance("test")
    public static PKMdodatki instance;
	public static SimpleNetworkWrapper gablotaNetworkWrapper;
	public static boolean renderNamesIngablotas = true;
    
    @SidedProxy(clientSide = "pl.ClientProxy", serverSide = "pl.CommonProxy")
    public static CommonProxy proxy;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
			config.load();
		    		
			ConfigCategory longNames = config.getCategory("general");
			longNames.setComment("Ustawienia jakie maja byc wyswietlane.");
			Property enchName = config.get("general","Enchantments",true);
			Property matName = config.get("general","Material",true);
			Property adjName = config.get("general","Adjectives",true);
			Property renderNames = config.get("rendering","RenderNames",true);
			renderNames.comment = "Zmien na false aby wylaczyc wyswietlanie nazw.";
			renderNamesIngablotas = renderNames.getBoolean(true);
    		
			String pedID = "gablota";
    		
		config.save();
		     			
		BlockGablota.instance = (BlockGablota) new BlockGablota().setBlockName(pedID);
        GameRegistry.registerBlock(BlockGablota.instance, pedID);
		
	      
        GameRegistry.registerTileEntity(TileEntityDisplayGablota.class, "test.gablota");
	
		proxy.registerRenders();
		
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        
        byte serverMessageID = 1;
        byte clientMessageID = 2;
        
        gablotaNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("test");
   }
	
	@EventHandler
    public void load(FMLInitializationEvent event)
    {
    }
	
}
