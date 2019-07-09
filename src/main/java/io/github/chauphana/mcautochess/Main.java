package io.github.chauphana.mcautochess;

import io.github.chauphana.mcautochess.board.Board;
import io.github.chauphana.mcautochess.commands.Registerboard;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Board board;

    public Main() {

    }


    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");

        this.getCommand("registerboard").setExecutor(new Registerboard(this));


    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }



}
