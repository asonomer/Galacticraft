package micdoodle8.mods.galacticraft.core;

import micdoodle8.mods.galacticraft.API.IPlanetSlotRenderer;
import micdoodle8.mods.galacticraft.API.IRocketType;
import micdoodle8.mods.galacticraft.API.ISchematicPage;
import micdoodle8.mods.galacticraft.core.entities.EntitySpaceshipBase;
import micdoodle8.mods.galacticraft.core.entities.GCCorePlayerMP;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerAirCollector;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerAirCompressor;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerAirDistributor;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerAirSealer;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerCargoLoader;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerFuelLoader;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerParachest;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerRefinery;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerRocketRefill;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityFuelLoader;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityOxygenCollector;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityOxygenCompressor;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityOxygenDistributor;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityOxygenSealer;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityRefinery;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.stats.StatBase;
import net.minecraft.world.World;
import basiccomponents.common.BCGuiHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * Copyright 2012-2013, micdoodle8
 * 
 * All rights reserved.
 * 
 */
public class CommonProxyCore extends BCGuiHandler implements IGuiHandler
{
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

    public void registerRenderInformation()
    {

    }

    public void addStat(EntityPlayer player, StatBase stat, int i)
    {

    }

    public int getGCUnlitTorchRenderID()
    {
        return -1;
    }

    public int getGCBreathableAirRenderID()
    {
        return -1;
    }

    public int getGCOxygenPipeRenderID()
    {
        return -1;
    }

    public int getGCTreasureChestRenderID()
    {
        return -1;
    }

    public int getGCMeteorRenderID()
    {
        return -1;
    }

    public int getGCCraftingTableRenderID()
    {
        return -1;
    }

    public int getGCCrudeOilRenderID()
    {
        return -1;
    }

    public int getGCFullLandingPadRenderID()
    {
        return -1;
    }

    public World getClientWorld()
    {
        return null;
    }

    public void addSlotRenderer(IPlanetSlotRenderer slotRenderer)
    {
        ;
    }

    public void spawnParticle(String var1, double var2, double var4, double var6, double var8, double var10, double var12, boolean b)
    {
        ;
    }

    public void spawnParticle(String var1, double var2, double var4, double var6, double var8, double var10, double var12, double var13, double var14, double var15, boolean b)
    {
        ;
    }

    public void displayParachestGui(EntityPlayer player, IInventory lander)
    {
        ;
    }

    // IGUIHANDLER IMPLEMENTATION:

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        final GCCorePlayerMP playerBase = PlayerUtil.getPlayerBaseServerFromPlayer(player);

        if (ID == GCCoreConfigManager.idGuiSpaceshipInventory && player.ridingEntity != null && player.ridingEntity instanceof EntitySpaceshipBase && player.ridingEntity instanceof IRocketType)
        {
            return new GCCoreContainerRocketRefill(player.inventory, (EntitySpaceshipBase) player.ridingEntity, ((IRocketType) player.ridingEntity).getType());
        }
        else if (ID == GCCoreConfigManager.idGuiRefinery)
        {
            return new GCCoreContainerRefinery(player.inventory, (GCCoreTileEntityRefinery) world.getBlockTileEntity(x, y, z));
        }
        else if (ID == GCCoreConfigManager.idGuiAirCompressor)
        {
            return new GCCoreContainerAirCompressor(player.inventory, (GCCoreTileEntityOxygenCompressor) world.getBlockTileEntity(x, y, z));
        }
        else if (ID == GCCoreConfigManager.idGuiAirCollector)
        {
            return new GCCoreContainerAirCollector(player.inventory, (GCCoreTileEntityOxygenCollector) world.getBlockTileEntity(x, y, z));
        }
        else if (ID == GCCoreConfigManager.idGuiAirDistributor)
        {
            return new GCCoreContainerAirDistributor(player.inventory, (GCCoreTileEntityOxygenDistributor) world.getBlockTileEntity(x, y, z));
        }
        else if (ID == GCCoreConfigManager.idGuiFuelLoader)
        {
            return new GCCoreContainerFuelLoader(player.inventory, (GCCoreTileEntityFuelLoader) world.getBlockTileEntity(x, y, z));
        }
        else if (ID == GCCoreConfigManager.idGuiAirSealer)
        {
            return new GCCoreContainerAirSealer(player.inventory, (GCCoreTileEntityOxygenSealer) world.getBlockTileEntity(x, y, z));
        }
        else if (ID == GCCoreConfigManager.idGuiCargoLoader)
        {
            return new GCCoreContainerCargoLoader(player.inventory, (IInventory) world.getBlockTileEntity(x, y, z));
        }
        else if (ID == GCCoreConfigManager.idGuiParachest)
        {
            return new GCCoreContainerParachest(player.inventory, (IInventory) world.getBlockTileEntity(x, y, z));
        }
        else
        {
            for (final ISchematicPage page : playerBase.unlockedSchematics)
            {
                if (ID == page.getGuiID())
                {
                    final Container container = page.getResultContainer(playerBase, x, y, z);

                    return container;
                }
            }
        }

        return super.getServerGuiElement(ID, playerBase, world, x, y, z);
    }
}
