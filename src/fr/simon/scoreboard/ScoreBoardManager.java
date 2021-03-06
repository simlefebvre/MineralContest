package fr.simon.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.simon.main.MainClass;

public class ScoreBoardManager {
	
	private MainClass mc;
	private ScoreboardManager manager;
	private Scoreboard board;
	private Objective obj;
	
	public ScoreBoardManager(MainClass mc) {
		this.mc = mc;
		
		manager = Bukkit.getScoreboardManager();
		board = manager.getNewScoreboard();
		
		obj = board.registerNewObjective("test", "dummy",ChatColor.BLUE + "Mineral"+ChatColor.GOLD+"Conquest");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		this.addLine("0 : 0", 0);
		this.addLine("=-=-=-=-=-=", -1);
		
		this.PrintSb();
	}
	
	public void PrintSb() {
		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			p.setScoreboard(board);
		}
	}
	
	public void PrintSb(Player p) {
			p.setScoreboard(board);
	}
	
	public void addLine(String name, int score) {
		obj.getScore(name).setScore(score);
	}
	
	public void removeLine(String name) {
		board.resetScores(name);
	}
}
