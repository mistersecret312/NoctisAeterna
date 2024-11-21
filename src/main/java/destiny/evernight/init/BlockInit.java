package destiny.evernight.init;

import destiny.evernight.EvernightMod;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EvernightMod.MODID);

    public static final RegistryObject<Block> SOULBLOOM = registerWithItem("soulbloom", () ->
            new FlowerBlock(
                    MobEffects.CONFUSION,
                    1,
                    BlockBehaviour.
                            Properties.copy(
                                    Blocks.GRASS)
                            .lightLevel(state -> 5)));
    public static final RegistryObject<Block> GLOOMGRASS = registerWithItem("gloomgrass", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<Block> DIREDIRT = registerWithItem("diredirt", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> NIGHTSTONE = registerWithItem("nightstone", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> COBBLED_NIGHTSTONE = registerWithItem("cobbled_nightstone", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static <T extends Block> RegistryObject<T> registerWithItem(String name, final Supplier<T> block, Function<Item.Properties, Item.Properties> properties){
        final RegistryObject<T> reg = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(reg.get(), properties.apply(new Item.Properties())));
        return reg;
    }

    public static <T extends Block> RegistryObject<T> registerWithItem(String name, final Supplier<T> block){
        return registerWithItem(name, block, p -> p);
    }

    public static void register(IEventBus bus)
    {
        BLOCKS.register(bus);
    }
}
