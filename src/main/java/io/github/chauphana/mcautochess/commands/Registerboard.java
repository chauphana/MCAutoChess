package io.github.chauphana.mcautochess.commands;

import io.github.chauphana.mcautochess.board.Board;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import io.github.chauphana.mcautochess.Main;

public class Registerboard implements CommandExecutor {

    public final Main main;



    public Registerboard(Main main) {
        this.main = main;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.getFacing().toString().equals("NORTH")) {
                Location playerLocation = player.getLocation();
                Location cornerA = playerLocation;
                cornerA.setY(playerLocation.getY() - 0.5);
                //player.chat(cornerA.getX() + ", " + cornerA.getY());
                Block currentBlock = cornerA.getBlock();
                //player.chat(currentBlock.toString());
                if (currentBlock.getType().equals(Material.RED_WOOL)) {
                    Location cornerB = new Location(player.getWorld(), cornerA.getX() + 17.0, cornerA.getY(),cornerA.getZ() - 17.0);
                    player.sendMessage(cornerB.toString());
                    if (cornerB.getBlock().getType().equals(Material.BLUE_WOOL)) {
                        main.board = new Board(cornerA, cornerB);
                        player.sendMessage("Board corners found.");
                    } else {
                        player.sendMessage("Error: Found starting corner, but cannot find opposite corner.");
                    }

                } else {
                    player.sendMessage("Error: Player must be standing on red wool.");
                }

            } else {
                sender.sendMessage("Player must be facing north.");
            }







        } else {
            sender.sendMessage("Command must be made from a player!");
        }

        return true;
    }
}
