package io.github.chauphana.mcautochess.board;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class Tile {

    Block firstBlock;
    Block secondBlock;
    Block thirdBlock;
    Block fourthBlock;

    public Tile(Location quadrant1) {
        Location blockPos = quadrant1;
        this.firstBlock = blockPos.getBlock();
        blockPos.setX(blockPos.getX() + 1);
        this.secondBlock = blockPos.getBlock();
        blockPos.setZ(blockPos.getZ() - 1);
        this.thirdBlock = blockPos.getBlock();
        blockPos.setX(blockPos.getX() - 1);
        this.fourthBlock = blockPos.getBlock();


    }

}
