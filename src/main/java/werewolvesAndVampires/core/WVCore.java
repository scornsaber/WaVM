package werewolvesAndVampires.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import werewolvesAndVampires.packets.PacketRegister;
import net.minecraftforge.common.*;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Type;

@Mod(modid = WVCore.MODID, name = WVCore.NAME, version = WVCore.VERSION, acceptedMinecraftVersions = "[1.12]")
public class WVCore {

	public static final String MODID = "weresandvamps";
	public static final String NAME = "Werewolves and Vampires";
	public static final String VERSION = "0.0.1";

	@Mod.Instance
	public static WVCore instance;

	@SidedProxy(clientSide = "werewolvesAndVampires.core.ClientProxy", serverSide = "werewolvesAndVampires.core.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public static void corePreInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
		
		PacketRegister.regMessages(MODID);
	}

	@EventHandler
	public static void coreInit(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public static void corePostInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

	public static final CreativeTabs ctab = new CreativeTabs(MODID) {
		@Override
		public ItemStack getTabIconItem() {
			// Placeholder creative tab Item
			return new ItemStack(Items.GOLDEN_SWORD);
		}

	};

	@LangKey("wvconfig")
	@Config(modid = MODID, type = Type.INSTANCE, name = NAME + "Config")
	public static class CONFIG {

	}

}
