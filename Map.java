import java.util.HashMap;
//import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
//import java.util.Properties;

public class Map {
  private Tile[][] tiles;
  private int worldWidth;
  private int worldHeight;


  public Map(int xWidth, int yHeight) {
    this.worldWidth = xWidth;
    this.worldHeight = yHeight;
    tiles = new Tile[this.worldWidth][this.worldHeight];
  }

  public int getWorldWidth() {
    return this.worldWidth;
  }

  public int getWorldHeight() {
    return this.worldHeight;
  }

  public void randomizeTiles() {
    for(int x = 0; x  < this.worldWidth; x++) {
      for(int y = 0; y < this.worldHeight; y++) {
        tiles[x][y] = Tile.values()[(int)(Math.random()*Tile.values().length)];
      }
    }
  }

  public Tile tile(int x, int y) {
    if (x < 0 || x >= this.worldWidth || y < 0 || y >= this.worldHeight) {
      // if out of bounds return a WALL
      return Tile.WALL;
    }
    return tiles[x][y];
  }

  public void smooth(int times) {
    HashMap<Tile, Integer> index = new HashMap<Tile, Integer>();
    for(Tile t : Tile.values()) {
      index.put(t, new Integer(0));
    }

    Tile maxTile;
    int max;
    for (int time = 0; time < times; time++) {
      for(int x = 0; x  < this.worldWidth; x++) {
        for(int y = 0; y < this.worldHeight; y++) {
          maxTile = null;
          max = 0;
          for(Tile t : index.keySet()) {
            index.replace(t, new Integer(0));
          }

          for(int ox = -1; ox < 2; ox++) {
            for (int oy = -1; oy < 2; oy++) {
              for(Tile t : index.keySet()) {
                if (t == tile(x+ox, y+oy)) {
                  int temp = index.get(t).intValue();
                  index.replace(t, new Integer(temp+1));
                }
              }
            }
          }

          for (Tile t : index.keySet()) {
            if (max < index.get(t).intValue()) {
              maxTile = t;
              max = index.get(t).intValue();
            }
          }
          tiles[x][y] = maxTile;
        }
      }

    }


  }
  
  public boolean isWall(int x, int y) {
	  if (tiles[x][y] == Tile.WALL) {
		  return true;
	  }
	  return false;
  }
  
  /*public int [][] getNonWall() {
	  
  }*/

}
