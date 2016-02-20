import java.util.HashMap;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.ConsoleSystemInterface;
import java.util.Properties;
import java.lang.Character;

public class World {
  private Map map;
  private ConsoleSystemInterface csi;

  public World(ConsoleSystemInterface csi, int x, int y) {
    this.map = map;
    this.csi = csi;


    map = new Map(x, y);
    map.randomizeTiles();
    map.smooth(4);
  }

  public void render() {
    // run through our tiles and display the caves/map
    for(int x = 0; x  < map.getWorldWidth(); x++) {
      for(int y = 0; y < map.getWorldHeight(); y++) {
        csi.print(x, y, Character.toString(map.tile(x,y).glyph()), map.tile(x,y).color());
      }
    }
    csi.refresh();
  }

  /** generate our monsters and our player and our items */






}
