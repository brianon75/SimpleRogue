import java.util.Properties;
import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

import java.lang.Character;


public class AppMain {
//public class AppMain implements KeyListener {
  /*public class AppMain extends JFrame implements KeyListener {

  	private static final long serialVersionUID = 1060623638149583738L;


    @Override
  	public void keyPressed(KeyEvent e) {
  		//screen = screen.respondToUserInput(e);
  		//repaint();
  	}

  	@Override
  	public void keyReleased(KeyEvent e) { }

  	@Override
  	public void keyTyped(KeyEvent e) { }
*/
  public static void main(String[] args) {

    Properties text = new Properties();
  	text.setProperty("fontSize","12");
    text.setProperty("font", "Ariel");

    ConsoleSystemInterface csi = null;
    try{
      csi = new WSwingConsoleInterface("Simple Game", text);
    } catch (ExceptionInInitializerError eiie) {
      System.out.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
      eiie.printStackTrace();
      System.exit(-1);
    }

    //Map ourWorldMap = new Map(int xSize, int ySize);
    //Map ourWorldMap = new Map(1000, 1000);

/*
    for(int x = 0; x  < map.getWorldWidth(); x++) {
      for(int y = 0; y < map.getWorldHeight(); y++) {
        csi.print(x, y, Character.toString(map.tile(x,y).glyph()));
      }
    }
*/

    // create our main window
    World world = new World(csi, 240, 80);

    /* we need to be able to scroll */
    //World world = new World(csi, 80, 25);
    //World world = new World(csi, 160, 56);

    /* Do we want to display the world already ? */
    /* probably not until we have our character and are ready to place all our monsteers and items */
    world.startGame();



  }

}
