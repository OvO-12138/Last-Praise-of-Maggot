package com.ovo.lastpraiseofmaggot.registry;
import com.ovo.lastpraiseofmaggot.LastPraiseOfMaggot;
import com.ovo.lastpraiseofmaggot.block.YellowPurpleLittleBedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.*;
public final class ModBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LastPraiseOfMaggot.MODID);
    public static final RegistryObject<Block> YELLOW_PURPLE_LITTLE_BED =
            BLOCKS.register(
                    "yellow_purple_little_bed",
                    YellowPurpleLittleBedBlock::new
            );
    public static final RegistryObject<Block> YELLOW_PURPLE_WOOL =
            BLOCKS.register(
                    "yellow_purple_wool",
                    () -> new Block(
                            BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)
                                    .mapColor(MapColor.COLOR_PURPLE)
                    )
            );
}
