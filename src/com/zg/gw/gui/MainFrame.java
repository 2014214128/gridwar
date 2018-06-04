package com.zg.gw.gui;

import com.zg.gw.entity.Location;
import com.zg.gw.entity.Node;
import com.zg.gw.entity.RankScore;
import com.zg.gw.entity.impl.HumanPlayer;
import com.zg.gw.environment.Environment;
import com.zg.gw.function.impl.TournamentFunc;
import com.zg.gw.game.GridGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private HumanPlayer humanPlayer;
	private List<Location> location;
	private int[] lastmove;
	private List<Node> p;
	List<RankScore> winner;
	public HumanPlayer getHumanPlayer() {
		return humanPlayer;
	}

	public MainFrame(List<Location> location, int[] lastmove, List<Node> p, HumanPlayer humanPlayer1, List<RankScore> winner) {
		super("grid war 1.0");
		this.location = location;
		this.p = p;
		this.humanPlayer = humanPlayer1;
		this.lastmove = lastmove;
		this.winner = winner;
		this.setResizable(false);
		this.setSize(Config.SWIDTH+5, Config.SHEIGHT+35);

		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim= tool.getScreenSize();
		int width =(int)dim.getWidth();
		int height = (int)dim.getHeight();
		this.setLocation((width-Config.SWIDTH-5)/2,(height-Config.SHEIGHT-35)/2);
		GamePanel game = new GamePanel();
		this.add(game);
		Location me = location.get(0);
		Location others = location.get(1);


		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						humanPlayer.setMove(Config.LEFT);
						game.playgame();
						break;
					case KeyEvent.VK_RIGHT:
						humanPlayer.setMove(Config.RIGHT);
						game.playgame();
						break;
					case KeyEvent.VK_UP:
						humanPlayer.setMove(Config.UP);
						game.playgame();
						break;
					case KeyEvent.VK_DOWN:
						humanPlayer.setMove(Config.DOWN);
						game.playgame();
						break;
					default:
						break;
				}
			}

		});

	}
	class GamePanel extends JPanel {
		private BufferedImage wall;
		private BufferedImage human;


		private int count=0;
		private int result = -1;

		public GamePanel() {
			super();
			this.setSize(Config.SWIDTH, Config.SHEIGHT);
			this.setVisible(true);
			this.initImag();
		}

		public void playgame() {
			if (count < 10) {
				count++;
				result = GridGame.gridGame(location, lastmove, p);
				this.repaint();
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "哈哈，你输了！");
					int re = JOptionPane.showConfirmDialog(null, "是否继续游戏");
					if (re == JOptionPane.YES_OPTION) {
						MainFrame.this.dispose();
						lastmove = new	int[]{-1,-1};
						new MainFrame(location, lastmove, p,humanPlayer, winner);
					}else if(re == JOptionPane.NO_OPTION){
						System.exit(0);
					}
				} else if (result == 1) {
					JOptionPane.showMessageDialog(null, "你赢了！");
					List<Node> population = new ArrayList<>();
					for (int i=0; i<winner.size(); i++) {
						population.add(winner.get(i).getT());
					}
					winner = Environment.evolve(population, 5, 100, new TournamentFunc(), 100);
					humanPlayer = new HumanPlayer();
					p = new ArrayList<>();
					p.add(winner.get(0).getT());
					p.add(humanPlayer);
					lastmove = new	int[]{-1,-1};
					new MainFrame(location, lastmove, p,humanPlayer, winner);
					int re = JOptionPane.showConfirmDialog(null, "我已经变强了，有本事再来一局！");
					if (re == JOptionPane.YES_OPTION) {
						MainFrame.this.dispose();
					}else if(re == JOptionPane.NO_OPTION){
						System.exit(0);
					}
				}
			} else{
				JOptionPane.showMessageDialog(null, "平局！");
				int re = JOptionPane.showConfirmDialog(null, "是否继续游戏");
				if (re == JOptionPane.YES_OPTION) {
					MainFrame.this.dispose();
					lastmove = new	int[]{-1,-1};
					new MainFrame(location, lastmove, p,humanPlayer, winner);
				}else if(re == JOptionPane.NO_OPTION){
					System.exit(0);
				}
			}
		}

		/**
		 * 初始化游戏中的图片
		 */
		public void initImag() {
			try {
				wall = ImageIO.read(this.getClass().getResource("../res/wall.png"));
				human = ImageIO.read(this.getClass().getResource("../res/human.png"));
			} catch (IOException e) {
				System.out.println("ERROE_001_加载图片出错!");
				e.printStackTrace();
			}
		}

		/**
		 * 画地图
		 *
		 * @param g
		 */
		public void initmap(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, Config.SWIDTH, Config.SHEIGHT);
			for (int i = 0; i < Config.map.length; i++) {
				for (int j = 0; j < Config.map[i].length; j++) {
					if (Config.map[i][j] == Config.Computer) {
						g.drawImage(wall, Config.WIDTH * j, Config.WIDTH * i, null);
					} else if (Config.map[i][j] == Config.Player) {
						g.drawImage(human, Config.WIDTH * j, Config.WIDTH * i, null);
					}
				}
			}
		}

		@Override
		public void paint(Graphics g) {
			// super.print(g);
			this.initmap(g);

		}
	}


	public static void main(String[] args) {
		int [] max = {3, 3};
		int [] lastmove = {-1, -1};
		List<Location> location = new ArrayList<>();
		location.add(new Location(((int)(Math.random()*(max[0]))%4),((int)(Math.random()*(max[0]))%4)));
		location.add(new Location((location.get(0).getX()+2)%4, (location.get(0).getY()+2)%4));

		List<RankScore> winner = Environment.evolve(null, 5, 100, new TournamentFunc(), 100);
		List<Node> p = new ArrayList<>();
		p.add(winner.get(0).getT());
		HumanPlayer humanPlayer = new HumanPlayer();
		p.add(humanPlayer);
		new MainFrame(location, lastmove, p,humanPlayer, winner);
	}
}
