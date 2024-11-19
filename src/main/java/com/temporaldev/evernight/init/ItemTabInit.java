package com.temporaldev.evernight.init;

import com.temporaldev.evernight.EvernightMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ItemTabInit
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EvernightMod.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockInit.GLOOMGRASS.get()))
                    .title(Component.translatable("evernight.main"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(BlockInit.GLOOMGRASS.get());
                        pOutput.accept(BlockInit.DIREDIRT.get());
                        pOutput.accept(BlockInit.NIGHTSTONE.get());
                        pOutput.accept(BlockInit.COBBLED_NIGHTSTONE.get());
                        pOutput.accept(BlockInit.SOULBLOOM.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
