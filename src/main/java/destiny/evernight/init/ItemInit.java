package destiny.evernight.init;

import destiny.evernight.EvernightMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EvernightMod.MODID);

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
