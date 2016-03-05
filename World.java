import java.util.HashMap;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.ConsoleSystemInterface;
import java.util.Properties;
import java.util.ArrayList;
import java.lang.Character;
import java.lang.Math;
import net.slashie.libjcsi.CSIColor;



public class World {
  private Map map;
  private ConsoleSystemInterface csi;
  private Player player;
  private ArrayList<Creature> creatures = new ArrayList<Creature>();
  private boolean isLargeMap = false;

  public static final int DISPLAY_WIDTH = 80;
  public static final int DISPLAY_HEIGHT = 25;
  
  private int numMonsters = 0;


  public World(ConsoleSystemInterface csi, int x, int y) {
    this.map = map;
    this.csi = csi;
	
	numMonsters = (int)(Math.random()*20)+1; // 1 to 20 monsters


    // generate the terrain
    map = new Map(x, y);
    map.randomizeTiles();
    map.smooth(8);

    // just do one check to determine if this map is larger than the display area
    if (map.getWorldWidth() > DISPLAY_WIDTH && map.getWorldHeight() > DISPLAY_HEIGHT) {
      isLargeMap = true;
    }

    // create our player
    player = new Player(x/2,y/2, "@", CSIColor.WHITE, "Baz", 100, 55, 44, 80);
	
	System.out.println(numMonsters);
	
	// get some(numCreatures) x and y coordinates that are not in the walls
	int [][] coordinates = new int[numMonsters][2];
	int testX =0;
	int testY = 0;
	
	for (int i = 0; i < numMonsters; i++) {
		
		do {
			testX = (int)(Math.random()*map.getWorldWidth());
			testY = (int)(Math.random()*map.getWorldHeight());
			coordinates[i][0] = testX;
			coordinates[i][1] = testY;
		} while (map.isWall(testX, testY));
	}
	
	
	// initialise our arraylist of creatures
	for (int i = 0; i < numMonsters; i++) {

		creatures.add(new Goblin(player, coordinates[i][0],coordinates[i][1], CSIColor.GREEN, (int)(Math.random()*100),
			(int)(Math.random()*100), (int)(Math.random()*100), (int)(Math.random()*100)));

	}
  }

  public void startGame() {
  
	  do {
			renderFit();
			player.move(this.csi, map);
		} while (true);
		
    //renderFit();

    //play();
  }

  /* this is essentially our bottom layer */
  //public void render(int x, int y, WIDTH, HEIGHT) {
  public void renderFit() {
    int px = player.getX() - (DISPLAY_WIDTH/2);
    int py = player.getY() - (DISPLAY_HEIGHT/2);

    /*if (isLargeMap) {
      // first pass - asssume we are inside bounds - player.x/player.y
      // the player x.y should determine center of display
      System.out.printf("Player start @ x(%d)y(%d)\n", player.getX(),player.getY());
      System.out.printf("Display start @ x(%d)y(%d)\n", px,py);
    }*/
	System.out.println("DISPLAY MAP");
    // run through our tiles and display the caves/map
    for(int x = 0; x  < DISPLAY_WIDTH; x++) {
      for(int y = 0; y < DISPLAY_HEIGHT; y++) {
        if ((x+px) < 0 || (x+px) > map.getWorldWidth() || (y+py) < 0 || (y+py) > map.getWorldHeight()) {
          csi.print(x, y, " ", CSIColor.GRAY);
        } else {
          csi.print(x, y, Character.toString(map.tile((x+px),(y+py)).glyph()), map.tile(x+px,y+py).color());
        }

      }
    }
    //csi.refresh();
	System.out.println("DISPLAY MAP DONE");
    
	System.out.println("DISPLAY MONSTERS");
    // run through our monsters
	// 1. Does each monster fit on screen.
	// 2. Where on he screen should it be
	for (Creature cEle : creatures) {
		//System.out.printf("%s VS %d %d\n", cEle.toString(), px, py);
		
		if (cEle.getX() >= px && cEle.getX() < (px + DISPLAY_WIDTH)
			&& cEle.getY() >= py && cEle.getY() < (py + DISPLAY_HEIGHT)) {
				System.out.println("Show creature : @ " + (cEle.getX()-px) + "x" + (cEle.getY()-py) + " " + cEle.getGlyph() + " COL " + cEle.getColor());
				csi.print(cEle.getX()-px, cEle.getY()-py, cEle.getGlyph(), cEle.getColor());
				
			}
	}
	System.out.println("DISPLAY MONSTERS DONE");
	System.out.println("DISPLAY PLAYER");
	// display our player ALWAYS in the center !!!!
    csi.print((DISPLAY_WIDTH/2), (DISPLAY_HEIGHT/2), player.getGlyph(), player.getColor());
	System.out.println("DISPLAY PLAYER DONE");
    /// run through our items
    csi.refresh();
  }

  public boolean getIsLargeMap() {
    return this.isLargeMap;
  }

/*
  private void displayTiles(int left, int top) {
    //fov.update(player.x, player.y, player.z, player.visionRadius());

		for (int x = 0; x < DISPLAY_WIDTH; x++){
			for (int y = 0; y < DISPLAY_HEIGHT; y++){
				int wx = x + left;
				int wy = y + top;

				if (player.canSee(wx, wy, player.z))
					csi.write(world.glyph(wx, wy, player.z), x, y, world.color(wx, wy, player.z));
				else
					csi.write(fov.tile(wx, wy, player.z).glyph(), x, y, Color.darkGray);

          //csi.print(world.glyph(wx, wy, player.z), x, y, world.color(wx, wy, player.z));
          csi.print(x, y, Character.toString(map.tile(wx,wy).glyph()), map.tile(wx,wy).color());

			}
		}
	}

  public int getScrollX() { return Math.max(0, Math.min(player.getX() - DISPLAY_WIDTH / 2, map.getWorldWidth() - DISPLAY_WIDTH)); }

	public int getScrollY() { return Math.max(0, Math.min(player.getY() - DISPLAY_HEIGHT / 2, map.getWorldHeight() - DISPLAY_HEIGHT)); }


	public void displayOutput() {

		displayTiles(getScrollX(), getScrollY());

	}
*/
  /** generate our monsters and our player and our items */

  private void play() {

	do {
		renderFit();
		player.move(this.csi, map);
	} while (true);
  

    
  }




}
