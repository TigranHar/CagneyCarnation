package me.cagneycarnation.fullbossfight;

import me.cagneycarnation.fullbossfight.player.PlayerShoot;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Objects;

public final class FullBossFight extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerShoot(), this);
        getCommand("cuphead").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void announcment(String message, String color ,Player p) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"title @a title {\"text\":\""+ message +"\", \"color\":\"" + color + "\"} ");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kill @e[type=minecraft:arrow]");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kill @e[type=minecraft:snowball]");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stopsound @a");

        p.playSound(p.getLocation(), Sound.MUSIC_DISC_13, 70, 1);
    }

    public static BlockFace getYaw(Entity en) {
        BlockFace yaw = en.getFacing();

        return yaw;
    }

    public void logOutput(boolean log) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule logAdminCommands " + log);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule sendCommandFeedback " + log);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule commandBlockOutput " + log);
    }

    public void onSp(Snowball sb, BlockFace blockFace, String name) {
        sb.setGravity(false);
        ItemStack snowball = sb.getItem();
        ItemMeta meta = snowball.getItemMeta();
        meta.setDisplayName(name);
        snowball.setItemMeta(meta);
        sb.setItem(snowball);

        if(blockFace == BlockFace.NORTH) {
            sb.setVelocity(new Vector(0, 0, -1.2));
        }

        if(blockFace == BlockFace.SOUTH) {
            sb.setVelocity(new Vector(0, 0, 1.2));
        }

        if(blockFace == BlockFace.WEST) {
            sb.setVelocity(new Vector(-1.2, 0, 0));
        }

        if(blockFace == BlockFace.EAST) {
            sb.setVelocity(new Vector(1.2, 0, 0));
        }
    }

    String message = "§6";
    boolean superFaze = false;
    boolean superFazeGrow = false;
    boolean done = false;
    boolean boolHit = false;
    boolean done2 = false;
    boolean done3 = false;
    boolean done4 = false;
    boolean boolHit2 = false;
    boolean boolHit3 = false;
    boolean boolHit4 = false;
    int hitTick = 0;
    int hitTick2 = 0;
    int hitTick3 = 0;
    int faceHit = 0;
    int grow = 0;
    int throwStuff = 0;
    int tick = 0;
    int won = 0;
    int lost = 0;
    int otherGrow = 0;

    public void setBlocks(Giant giant, Location block1, BlockFace blockFace, int Y, Material block, boolean retract) {

        if(!done) {
            hitTick++;
        }

        if(blockFace == BlockFace.NORTH) {
            if(hitTick == 0) {
                Block block2 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 1);
                block2.setType(block);
            }

            if(hitTick == 1) {
                Block block3 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 2);
                block3.setType(block);
            }

            if(hitTick == 2) {
                Block block4 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 3);
                block4.setType(block);
            }

            if(hitTick == 3) {
                Block block5 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 4);
                block5.setType(block);
            }

            if(hitTick == 4) {
                Block block6 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 5);
                block6.setType(block);
            }

            if(hitTick == 5) {
                Block block7 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 6);
                block7.setType(block);
            }

            if(hitTick == 6) {
                Block block8 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 7);
                block8.setType(block);
                Location loc = new Location(block8.getWorld(), block8.getLocation().getX(), block8.getLocation().getY(), block8.getLocation().getZ());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon potion " + (int) loc.getX() + " " + (int)loc.getY()  + " " + (int)loc.getZ() + " {Item:{id:\"minecraft:tnt\",Count:1,tag:{CustomPotionEffects:[{Id:7,Duration:1000,Amplifier:1,ShowParticles:0b}],CustomPotionColor:15879758}}}");
            }

            if(hitTick == 7 && retract) {
                Block block9 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 7);
                block9.setType(Material.AIR);
            }

            if(hitTick == 8 && retract) {
                Block block10 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 6);
                block10.setType(Material.AIR);
            }

            if(hitTick == 9 && retract) {
                Block block11 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 5);
                block11.setType(Material.AIR);
            }

            if(hitTick == 10 && retract) {
                Block block12 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 4);
                block12.setType(Material.AIR);
            }

            if(hitTick == 11 && retract) {
                Block block14 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 3);
                block14.setType(Material.AIR);
            }

            if(hitTick == 12 && retract) {
                Block block15 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 2);
                block15.setType(Material.AIR);
            }

            if(hitTick == 13 && retract) {
                Block block16 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() - 1);
                block16.setType(Material.AIR);
            }
        }
        if(blockFace == BlockFace.SOUTH) {
            if(hitTick == 0) {
                Block block2 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 1);
                block2.setType(block);
            }

            if(hitTick == 1) {
                Block block3 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 2);
                block3.setType(block);
            }

            if(hitTick == 2) {
                Block block4 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 3);
                block4.setType(block);
            }

            if(hitTick == 3) {
                Block block5 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 4);
                block5.setType(block);
            }

            if(hitTick == 4) {
                Block block6 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 5);
                block6.setType(block);
            }

            if(hitTick == 5) {
                Block block7 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 6);
                block7.setType(block);
            }

            if(hitTick == 6) {
                Block block8 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 7);
                block8.setType(block);
                Location loc = new Location(block8.getWorld(), block8.getLocation().getX(), block8.getLocation().getY(), block8.getLocation().getZ());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon potion " + (int) loc.getX() + " " + (int)loc.getY()  + " " + (int)loc.getZ() + " {Item:{id:\"minecraft:tnt\",Count:1,tag:{CustomPotionEffects:[{Id:7,Duration:1000,Amplifier:1,ShowParticles:0b}],CustomPotionColor:15879758}}}");
            }

            if(hitTick == 7 && retract) {
                Block block9 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 7);
                block9.setType(Material.AIR);
            }

            if(hitTick == 8 && retract) {
                Block block10 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 6);
                block10.setType(Material.AIR);
            }

            if(hitTick == 9&& retract) {
                Block block11 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 5);
                block11.setType(Material.AIR);
            }

            if(hitTick == 10 && retract) {
                Block block12 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 4);
                block12.setType(Material.AIR);
            }

            if(hitTick == 11 && retract) {
                Block block14 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 3);
                block14.setType(Material.AIR);
            }

            if(hitTick == 12 && retract) {
                Block block15 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 2);
                block15.setType(Material.AIR);
            }

            if(hitTick == 13 && retract) {
                Block block16 = giant.getWorld().getBlockAt((int) block1.getX(), (int) block1.getY() + Y, (int) block1.getZ() + 1);
                block16.setType(Material.AIR);
            }
        }
        if(blockFace == BlockFace.WEST) {
            if(hitTick == 0) {
                Block block2 = giant.getWorld().getBlockAt((int) block1.getX() - 1, (int) block1.getY() + Y, (int) block1.getZ());
                block2.setType(block);
            }

            if(hitTick == 1) {
                Block block3 = giant.getWorld().getBlockAt((int) block1.getX() - 2, (int) block1.getY() + Y, (int) block1.getZ());
                block3.setType(block);
            }

            if(hitTick == 2) {
                Block block4 = giant.getWorld().getBlockAt((int) block1.getX() - 3, (int) block1.getY() + Y, (int) block1.getZ());
                block4.setType(block);
            }

            if(hitTick == 3) {
                Block block5 = giant.getWorld().getBlockAt((int) block1.getX() - 4, (int) block1.getY() + Y, (int) block1.getZ());
                block5.setType(block);
            }

            if(hitTick == 4) {
                Block block6 = giant.getWorld().getBlockAt((int) block1.getX() - 5, (int) block1.getY() + Y, (int) block1.getZ());
                block6.setType(block);
            }

            if(hitTick == 5) {
                Block block7 = giant.getWorld().getBlockAt((int) block1.getX() - 6, (int) block1.getY() + Y, (int) block1.getZ());
                block7.setType(block);
            }

            if(hitTick == 6) {
                Block block8 = giant.getWorld().getBlockAt((int) block1.getX() - 7, (int) block1.getY() + Y, (int) block1.getZ());
                block8.setType(block);
                Location loc = new Location(block8.getWorld(), block8.getLocation().getX(), block8.getLocation().getY(), block8.getLocation().getZ());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon potion " + (int) loc.getX() + " " + (int)loc.getY()  + " " + (int)loc.getZ() + " {Item:{id:\"minecraft:tnt\",Count:1,tag:{CustomPotionEffects:[{Id:7,Duration:1000,Amplifier:1,ShowParticles:0b}],CustomPotionColor:15879758}}}");
            }

            if(hitTick == 7 && retract) {
                Block block9 = giant.getWorld().getBlockAt((int) block1.getX() - 7, (int) block1.getY() + Y, (int) block1.getZ());
                block9.setType(Material.AIR);
            }

            if(hitTick == 8 && retract) {
                Block block10 = giant.getWorld().getBlockAt((int) block1.getX() - 6, (int) block1.getY() + Y, (int) block1.getZ());
                block10.setType(Material.AIR);
            }

            if(hitTick == 9 && retract) {
                Block block11 = giant.getWorld().getBlockAt((int) block1.getX() - 5, (int) block1.getY() + Y, (int) block1.getZ());
                block11.setType(Material.AIR);
            }

            if(hitTick == 10 && retract) {
                Block block12 = giant.getWorld().getBlockAt((int) block1.getX() - 4, (int) block1.getY() + Y, (int) block1.getZ());
                block12.setType(Material.AIR);
            }

            if(hitTick == 11 && retract) {
                Block block14 = giant.getWorld().getBlockAt((int) block1.getX() - 3, (int) block1.getY() + Y, (int) block1.getZ());
                block14.setType(Material.AIR);
            }

            if(hitTick == 12 && retract) {
                Block block15 = giant.getWorld().getBlockAt((int) block1.getX() - 2, (int) block1.getY() + Y, (int) block1.getZ());
                block15.setType(Material.AIR);
            }

            if(hitTick == 13 && retract) {
                Block block16 = giant.getWorld().getBlockAt((int) block1.getX() - 1, (int) block1.getY() + Y, (int) block1.getZ());
                block16.setType(Material.AIR);
            }
        }
        if(blockFace == BlockFace.EAST) {
            if(hitTick == 0) {
                Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + 1, (int) block1.getY() + Y, (int) block1.getZ());
                block2.setType(block);
            }

            if(hitTick == 1) {
                Block block3 = giant.getWorld().getBlockAt((int) block1.getX() + 2, (int) block1.getY() + Y, (int) block1.getZ());
                block3.setType(block);
            }

            if(hitTick == 2) {
                Block block4 = giant.getWorld().getBlockAt((int) block1.getX() + 3, (int) block1.getY() + Y, (int) block1.getZ());
                block4.setType(block);
            }

            if(hitTick == 3) {
                Block block5 = giant.getWorld().getBlockAt((int) block1.getX() + 4, (int) block1.getY() + Y, (int) block1.getZ());
                block5.setType(block);
            }

            if(hitTick == 4) {
                Block block6 = giant.getWorld().getBlockAt((int) block1.getX() + 5, (int) block1.getY() + Y, (int) block1.getZ());
                block6.setType(block);
            }

            if(hitTick == 5) {
                Block block7 = giant.getWorld().getBlockAt((int) block1.getX() + 6, (int) block1.getY() + Y, (int) block1.getZ());
                block7.setType(block);
            }

            if(hitTick == 6) {
                Block block8 = giant.getWorld().getBlockAt((int) block1.getX() + 7, (int) block1.getY() + Y, (int) block1.getZ());
                block8.setType(block);
                Location loc = new Location(block8.getWorld(), block8.getLocation().getX(), block8.getLocation().getY(), block8.getLocation().getZ());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon potion " + (int) loc.getX() + " " + (int)loc.getY()  + " " + (int)loc.getZ() + " {Item:{id:\"minecraft:tnt\",Count:1,tag:{CustomPotionEffects:[{Id:7,Duration:1000,Amplifier:1,ShowParticles:0b}],CustomPotionColor:15879758}}}");
            }

            if(hitTick == 7 && retract) {
                Block block9 = giant.getWorld().getBlockAt((int) block1.getX() + 7, (int) block1.getY() + Y, (int) block1.getZ());
                block9.setType(Material.AIR);
            }

            if(hitTick == 8 && retract) {
                Block block10 = giant.getWorld().getBlockAt((int) block1.getX() + 6, (int) block1.getY() + Y, (int) block1.getZ());
                block10.setType(Material.AIR);
            }

            if(hitTick == 9 && retract) {
                Block block11 = giant.getWorld().getBlockAt((int) block1.getX() + 5, (int) block1.getY() + Y, (int) block1.getZ());
                block11.setType(Material.AIR);
            }

            if(hitTick == 10 && retract) {
                Block block12 = giant.getWorld().getBlockAt((int) block1.getX() + 4, (int) block1.getY() + Y, (int) block1.getZ());
                block12.setType(Material.AIR);
            }

            if(hitTick == 11 && retract) {
                Block block14 = giant.getWorld().getBlockAt((int) block1.getX() + 3, (int) block1.getY() + Y, (int) block1.getZ());
                block14.setType(Material.AIR);
            }

            if(hitTick == 12 && retract) {
                Block block15 = giant.getWorld().getBlockAt((int) block1.getX() + 2, (int) block1.getY() + Y, (int) block1.getZ());
                block15.setType(Material.AIR);
            }

            if(hitTick == 13 && retract) {
                Block block16 = giant.getWorld().getBlockAt((int) block1.getX() + 1, (int) block1.getY() + Y, (int) block1.getZ());
                block16.setType(Material.AIR);
            }
        }

       if(hitTick == 13) {
           hitTick = 0;
           done = true;
           boolHit = false;
       }
    }
    public void growBlocks(Giant giant, Location block1, Material block, int Z, int X) {

        if(hitTick == 0) {
            Block block3 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 1, (int) block1.getZ() + Z);
            block3.setType(block);
        }

        if(hitTick == 1) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 2, (int) block1.getZ() + Z);
            block2.setType(block);
        }

        if(hitTick == 3) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 4, (int) block1.getZ() + Z);
            block2.setType(block);

            Location loc = new Location(block2.getWorld(), block2.getLocation().getX() + X, block2.getLocation().getY(), block2.getLocation().getZ());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon potion " + (int) loc.getX() + " " + (int)loc.getY()  + " " + (int)loc.getZ() + " {Item:{id:\"minecraft:tnt\",Count:1,tag:{CustomPotionEffects:[{Id:7,Duration:1000,Amplifier:1,ShowParticles:0b}],CustomPotionColor:15879758}}}");
        }

        if(hitTick == 4) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 4, (int) block1.getZ() + Z);
            block2.setType(Material.AIR);
        }

        if(hitTick == 6) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 2, (int) block1.getZ() + Z);
            block2.setType(Material.AIR);
        }

        if(hitTick == 7) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 1, (int) block1.getZ() + Z);
            block2.setType(Material.AIR);
        }

        if(!done2) {
            hitTick++;
        }

        if(hitTick == 8) {
            hitTick = 0;
            done2 = true;
            boolHit2 = false;
        }
    }
    public void growBlocks2(Giant giant, Location block1, Material block, int Z, int X) {

        if(hitTick2 == 0) {
            Block block3 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 1, (int) block1.getZ() + Z);
            block3.setType(block);
        }

        if(hitTick2 == 1) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 2, (int) block1.getZ() + Z);
            block2.setType(block);
        }

        if(hitTick2 == 3) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 4, (int) block1.getZ() + Z);
            block2.setType(block);

            Location loc = new Location(block2.getWorld(), block2.getLocation().getX() + X, block2.getLocation().getY(), block2.getLocation().getZ());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon potion " + (int) loc.getX() + " " + (int)loc.getY()  + " " + (int)loc.getZ() + " {Item:{id:\"minecraft:tnt\",Count:1,tag:{CustomPotionEffects:[{Id:7,Duration:1000,Amplifier:1,ShowParticles:0b}],CustomPotionColor:15879758}}}");
        }

        if(hitTick2 == 4) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 4, (int) block1.getZ() + Z);
            block2.setType(Material.AIR);
        }

        if(hitTick2 == 6) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 2, (int) block1.getZ() + Z);
            block2.setType(Material.AIR);
        }

        if(hitTick2 == 7) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 1, (int) block1.getZ() + Z);
            block2.setType(Material.AIR);
        }

        if(!done3) {
            hitTick2++;
        }

        if(hitTick2 == 8) {
            hitTick2 = 0;
            done3 = true;
            boolHit3 = false;
        }
    }
    public void growBlocks3(Giant giant, Location block1, Material block, int Z, int X) {

        if(hitTick3 == 0) {
            Block block3 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 1, (int) block1.getZ() + Z);
            block3.setType(block);
        }

        if(hitTick3 == 1) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 2, (int) block1.getZ() + Z);
            block2.setType(block);
        }

        if(hitTick3 == 3) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 4, (int) block1.getZ() + Z);
            block2.setType(block);

            Location loc = new Location(block2.getWorld(), block2.getLocation().getX() + X, block2.getLocation().getY(), block2.getLocation().getZ());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon potion " + (int) loc.getX() + " " + (int)loc.getY()  + " " + (int)loc.getZ() + " {Item:{id:\"minecraft:tnt\",Count:1,tag:{CustomPotionEffects:[{Id:7,Duration:1000,Amplifier:1,ShowParticles:0b}],CustomPotionColor:15879758}}}");
        }

        if(hitTick3 == 4) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 4, (int) block1.getZ() + Z);
            block2.setType(Material.AIR);
        }

        if(hitTick3 == 6) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 2, (int) block1.getZ() + Z);
            block2.setType(Material.AIR);
        }

        if(hitTick3 == 7) {
            Block block2 = giant.getWorld().getBlockAt((int) block1.getX() + X, (int) block1.getY() + 1, (int) block1.getZ() + Z);
            block2.setType(Material.AIR);
        }

        if(!done4) {
            hitTick3++;
        }

        if(hitTick3 == 8) {
            hitTick3 = 0;
            done4 = true;
            boolHit4 = false;
        }
    }
    public void resetVars() {
        message = "§6";
        faceHit = 0;
        grow = 0;
        throwStuff = 0;
        tick = 0;
        won = 0;
        lost = 0;
        otherGrow = 0;
        done = false;
        boolHit = false;
        done2 = false;
        done3 = false;
        done4 = false;
        boolHit2 = false;
        boolHit3 = false;
        boolHit4 = false;
        superFaze = false;
        superFazeGrow = false;
        PlayerShoot.superShotInt = 0;
        PlayerShoot.superShot = false;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cuphead")) {
            if (args.length > 0) {
                if (Objects.equals(args[0], "glove") && sender instanceof Player) {
                    Player p = (Player) sender;
                    ItemStack glove = new ItemStack(Material.CARROT_ON_A_STICK);
                    ItemMeta meta = (ItemMeta) glove.getItemMeta();
                    meta.setDisplayName(ChatColor.AQUA + "Cuphead Glove");
                    glove.setItemMeta(meta);
                    p.getInventory().addItem(glove);
                } else if (Objects.equals(args[0], "reload")) {
                    getServer().getPluginManager().disablePlugin(this);
                    getServer().getPluginManager().enablePlugin(this);
                } else if (Objects.equals(args[0], "cabBoss") && sender instanceof Player) {
                    Player p = (Player) sender;
                    Location pLoc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
                    org.bukkit.entity.Giant giant = (org.bukkit.entity.Giant) Bukkit.getServer().getWorld("world").spawn(p.getLocation(), org.bukkit.entity.Giant.class);
                    giant.setCustomName("Cagney Carnation");
                    giant.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(200);
                    giant.setHealth(giant.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                    giant.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 3));
                    p.playSound(p.getLocation(), Sound.MUSIC_DISC_11, 60, 1);
                    p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_THROW, 60, 1);

                    logOutput(false);

                    BossBar bossBar = Bukkit.createBossBar(
                            ChatColor.RED + "Cagney Carnation",
                            BarColor.GREEN,
                            BarStyle.SOLID);
                    bossBar.addPlayer(p);

                    int taskID;

                    taskID = this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

                        @Override
                        public void run() {
                            if (!giant.isDead()) {
                                bossBar.setProgress(giant.getHealth() / giant.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                                faceHit++; grow++; throwStuff++; tick++;

                                if(tick % 2 == 0) {
                                    if(tick % 32 == 0 && PlayerShoot.superShotInt < 5 && message.length() < 7 && !PlayerShoot.superShot) {
                                        message += "♦";
                                        PlayerShoot.superShotInt++;
                                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
                                    }

                                    if(PlayerShoot.superShot && message.contains("§6") && !(message.length() <= 2)) {
                                        message = message.substring(0, message.length()-1);
                                        PlayerShoot.superShot = false;
                                        PlayerShoot.superShotInt--;
                                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
                                    }

                                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
                                }

                                if(grow == 26 || grow == 52 && !superFaze) {
                                    boolHit = true;
                                    done = false;
                                }

                                if(boolHit) {
                                    Location block1 = giant.getLocation().getBlock().getLocation();
                                    BlockFace blockFace = getYaw(giant);
                                    setBlocks(giant, block1, blockFace, 5, Material.YELLOW_CONCRETE, true);
                                }

                                if(grow == 64) {
                                    superFaze = true;
                                }

                                if(superFaze && grow % 32 == 0) {
                                    boolHit2 = true;
                                    done2 = false;
                                }

                                if(superFaze && grow % 47 == 0) {
                                    boolHit3 = true;
                                    done3 = false;
                                }

                                if(superFaze && grow % 56 == 0) {
                                    boolHit4 = true;
                                    done4 = false;
                                }

                                if(superFaze) {
                                    Location block1 = giant.getLocation().getBlock().getLocation();
                                    BlockFace blockFace = getYaw(giant);
                                    setBlocks(giant, block1, blockFace, 0,Material.GREEN_CONCRETE, false);
                                }

                                if(boolHit2) {
                                    Location block1 = giant.getLocation().getBlock().getLocation();
                                    BlockFace blockFace = getYaw(giant);

                                    if(blockFace == BlockFace.NORTH) {
                                        growBlocks(giant, block1, Material.GREEN_CONCRETE, -3, 0);
                                    }

                                    if(blockFace == BlockFace.SOUTH) {
                                        growBlocks(giant, block1, Material.GREEN_CONCRETE, 3, 0);
                                    }

                                    if(blockFace == BlockFace.EAST) {
                                        growBlocks(giant, block1, Material.GREEN_CONCRETE, 0, 3);
                                    }

                                    if(blockFace == BlockFace.WEST) {
                                        growBlocks(giant, block1, Material.GREEN_CONCRETE, 0, -3);
                                    }
                                }

                                if(boolHit3) {
                                    Location block1 = giant.getLocation().getBlock().getLocation();
                                    BlockFace blockFace = getYaw(giant);

                                    if(blockFace == BlockFace.NORTH) {
                                        growBlocks2(giant, block1, Material.GREEN_CONCRETE, -5, 0);
                                    }

                                    if(blockFace == BlockFace.SOUTH) {
                                        growBlocks2(giant, block1, Material.GREEN_CONCRETE, 5, 0);
                                    }

                                    if(blockFace == BlockFace.EAST) {
                                        growBlocks2(giant, block1, Material.GREEN_CONCRETE, 0, 5);
                                    }

                                    if(blockFace == BlockFace.WEST) {
                                        growBlocks2(giant, block1, Material.GREEN_CONCRETE, 0, -5);
                                    }
                                }

                                if(boolHit4) {
                                    Location block1 = giant.getLocation().getBlock().getLocation();
                                    BlockFace blockFace = getYaw(giant);

                                    if(blockFace == BlockFace.NORTH) {
                                        growBlocks3(giant, block1, Material.GREEN_CONCRETE, -7, 0);
                                    }

                                    if(blockFace == BlockFace.SOUTH) {
                                        growBlocks3(giant, block1, Material.GREEN_CONCRETE, 7, 0);
                                    }

                                    if(blockFace == BlockFace.EAST) {
                                        growBlocks3(giant, block1, Material.GREEN_CONCRETE, 0, 7);
                                    }

                                    if(blockFace == BlockFace.WEST) {
                                        growBlocks3(giant, block1, Material.GREEN_CONCRETE, 0, -7);
                                    }
                                }

                                if(throwStuff % 16 == 0) {
                                    double giantX = giant.getLocation().getDirection().getX();
                                    double giantY = giant.getLocation().getDirection().getY();
                                    double giantZ = giant.getLocation().getDirection().getZ();

                                    org.bukkit.util.Vector dir = new org.bukkit.util.Vector(giantX, giantY, giantZ);

                                    float angle = -1F;

                                    for(int i = 0; i <= 3; i++) {
                                        BlockFace blockFace = getYaw(giant);
                                        Snowball sb;

                                        if(blockFace == BlockFace.NORTH || blockFace == BlockFace.SOUTH) {
                                            sb = giant.getWorld().spawn(new Location(giant.getWorld(),giant.getLocation().getX() + angle, giant.getLocation().getY() + 5, giant.getLocation().getZ()), Snowball.class);

                                            if(!superFaze) {
                                                onSp(sb, blockFace, "carrotpro");
                                            } else {
                                                onSp(sb, blockFace, "eyes");
                                            }
                                        }

                                        if(blockFace == BlockFace.WEST || blockFace == BlockFace.EAST) {
                                            sb = giant.getWorld().spawn(new Location(giant.getWorld(),giant.getLocation().getX(), giant.getLocation().getY() + 5, giant.getLocation().getZ() + angle), Snowball.class);

                                            if(!superFaze) {
                                                onSp(sb, blockFace, "carrotpro");
                                            } else {
                                                onSp(sb, blockFace, "eyes");
                                            }
                                        }

                                        angle += 1F;
                                    }
                                 }

                                if(p.isDead()) {
                                    lost++;
                                }

                                if(lost == 4) {
                                    announcment("YOU LOSE", "red",p);
                                    bossBar.removePlayer(p);
                                    bossBar.setVisible(false);
                                    Bukkit.getScheduler().cancelTasks(FullBossFight.this);
                                    resetVars();
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kill @e[type=minecraft:giant]");
                                }

                            } else {
                                List<Player> players = bossBar.getPlayers();
                                for (Player player : players) {
                                    bossBar.removePlayer(player);
                                }
                                bossBar.setVisible(false);

                                if(giant.isDead()) {
                                    won++;
                                }

                                if(won == 4) {
                                    announcment("YOU WIN!!!", "green" , p);
                                    Bukkit.getScheduler().cancelTasks(FullBossFight.this);
                                    resetVars();
                                }
                            }
                        }
                    }, 0L, 5L);


                }
            } else {
                sender.sendMessage(ChatColor.AQUA + "[Cuphead Boss Remake] To start use " + ChatColor.YELLOW + "/cuphead glove" + ChatColor.AQUA + " or " + ChatColor.YELLOW + "/cuphead cabBoss");
            }
        }
        return false;
    }
}

