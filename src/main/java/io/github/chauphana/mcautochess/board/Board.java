package io.github.chauphana.mcautochess.board;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Board {

    public Location cornerA; //starting corner when using /registerboard
    public Location cornerB; //diagonal opposite corner when using /registerboard
    public Tile[][] tileArray = new Tile[8][8];
    public Board(Location cornerA, Location cornerB) {
        this.cornerA = cornerA;
        this.cornerB = cornerB;



        boolean flag = false;
        Location tilePos = new Location(cornerA.getWorld(), cornerA.getX() + 1, cornerA.getY(), cornerA.getZ() - 1);
        for (int row = 0; row < tileArray.length; row ++) {



            if (flag) {
                tilePos.setX(tilePos.getX() - 14);
                tilePos.setZ(tilePos.getZ() - 2 );
            }

            for (int col = 0; col < tileArray[0].length; col++) {
                flag = true;
                tileArray[row][col] = new Tile(tilePos);
                Location tempPos = new Location(tilePos.getWorld(), tilePos.getX(), tilePos.getY() + 1, tilePos.getZ());
                tempPos.getBlock().setType(Material.ACACIA_LOG);
                tilePos.setX(tilePos.getX() + 2);
            }

        }

    }

}
