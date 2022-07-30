package me.cagneycarnation.fullbossfight.player;

import me.cagneycarnation.fullbossfight.FullBossFight;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Snow;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlayerShoot implements Listener {

    public static int angle = 0;
    public static int superShotInt = 0;
    public static boolean superShot = false;

    public static Vector getDir(double yaw, double dirY, double angleAdd)
    {
        double dirX = Math.cos(Math.toRadians(yaw + 90 + angleAdd));
        double dirZ = Math.sin(Math.toRadians(yaw + 90 + angleAdd));
        return new Vector(dirX, dirY, dirZ);
    }

    public static Vector getDirTest(double yaw, double dirY, double angleAdd)
    {
        double dirX = Math.cos(Math.toRadians(yaw + 90 + angleAdd));
        double dirZ = Math.sin(Math.toRadians(yaw + 90 + angleAdd));
        return new Vector(dirX, dirY, dirZ);
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {

        Player p = event.getPlayer();
        Action action = event.getAction();

        if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if((p.getInventory().getItemInMainHand().getType() == Material.CARROT_ON_A_STICK && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Cuphead Glove"))) {
                Vector playerDirection = p.getLocation().getDirection();
                Arrow arrow = p.launchProjectile(Arrow.class, playerDirection);
                arrow.setCustomName("bullet");
                arrow.setGravity(false);
                arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
                p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 100, 1);
            }
        }

        if((action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK))) {
            if((p.getInventory().getItemInMainHand().getType() == Material.CARROT_ON_A_STICK && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Cuphead Glove"))) {
                if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Cuphead Glove")) {

                    Arrow arrow = p.launchProjectile(Arrow.class, getDir(p.getLocation().getYaw(), p.getLocation().getDirection().getY() + 0.2, 0));
                    Arrow arrow2 = p.launchProjectile(Arrow.class, getDir(p.getLocation().getYaw(), p.getLocation().getDirection().getY() + 0, 0));
                    Arrow arrow3 = p.launchProjectile(Arrow.class, getDir(p.getLocation().getYaw(), p.getLocation().getDirection().getY() + 0.4, 0));
                    arrow.setCustomName("bullet2");
                    arrow.setFallDistance(7);
                    arrow2.setCustomName("bullet2");
                    arrow2.setFallDistance(5);
                    arrow3.setCustomName("bullet2");
                    arrow3.setFallDistance(4);

                    p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 100, 1);
                }
            }

            if((p.getInventory().getItemInOffHand().getType() == Material.CARROT_ON_A_STICK && p.getInventory().getItemInOffHand().getItemMeta().getDisplayName().equals("Cuphead Glove")) && superShotInt <= 5 && superShotInt > 0 && !superShot) {

                float angleAdd = 0F;

                for(int i = 0; i <= 8; i ++) {
                    Arrow arrow = p.launchProjectile(Arrow.class, getDir(p.getLocation().getYaw(), p.getLocation().getDirection().getY(), angleAdd));
                    arrow.setCustomName("bullet2");
                    arrow.setFallDistance(7);
                    arrow.setDamage(10);

                    angleAdd += 45F;
                }

                superShot = true;
            }
        }
    }

    @EventHandler
    public void onProj(ProjectileLaunchEvent e) {
        Projectile p = e.getEntity();

        if(p instanceof Snowball) {
            ((Snowball) p).getItem();
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent e)
    {
        Projectile p = e.getEntity();

        if(p instanceof Arrow) {
            p.remove();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "particle minecraft:instant_effect " + (int)p.getLocation().getX() + " " + (int)p.getLocation().getY() + " " + (int)p.getLocation().getZ() +" 0 0 0 1 10");
        } else if(p instanceof Snowball) {
            Location loc = p.getLocation();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "particle minecraft:instant_effect " + (int)p.getLocation().getX() + " " + (int)p.getLocation().getY() + " " + (int)p.getLocation().getZ() +" 0 0 0 1 10");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon potion " + (int) loc.getX() + " " + (int)loc.getY()  + " " + (int)loc.getZ() + " {Item:{id:\"minecraft:tnt\",Count:1,tag:{CustomPotionEffects:[{Id:7,Duration:1000,Amplifier:1,ShowParticles:0b}],CustomPotionColor:15879758}}}");
        }
    }

    @EventHandler
    public void onHitEnt(EntityDamageByEntityEvent e)
    {
        if (e.getDamager() instanceof Snowball) {
            e.setDamage(6);
            e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.STEP_SOUND, 80, 1);
        }
    }
}