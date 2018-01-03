package fr.weefle.test

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

public class Main(): JavaPlugin() {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(MyListener(), this)
        this.getCommand("test").setExecutor(CommandTest())
        super.onEnable()
    }

    class CommandTest : CommandExecutor{
        override fun onCommand(p0: CommandSender?, p1: Command?, p2: String?, p3: Array<out String>?): Boolean {

            if(p0 is Player){
                var p : Player = p0
                p.sendMessage(ChatColor.AQUA.toString() + "Coucou!")
            }
            else{
                if (p0 != null) {
                    p0.sendMessage(ChatColor.DARK_RED.toString() + "Tu n'es pas un joueur!")
                }
            }

            return true

        }


    }

    class MyListener : Listener {

        @EventHandler
        public fun onJoin(event: PlayerJoinEvent){
            event.player.sendMessage(ChatColor.GOLD.toString() + "Bienvenue " + ChatColor.DARK_RED + event.player.displayName)
        }

    }


}