import java.lang.Math;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class Goblin extends Creature {

   

  String goblinNames [] = {"Gobby", "Glack", "Glub", "Gork", "Gazba", "Glick"};
  
  public Goblin (Player player, int x, int y, CSIColor color, int health, int strength, int agility, int luck) {
    super(player, x, y, color, health, strength, agility, luck);
	this.setName(goblinNames[(int)(Math.random()*goblinNames.length)]);
	this.glyph = "G";
  }

  public String toString() {
          //return "Goblin(Name:" + this.name + "|" + type + " Health:" + this.health + ")";
          return "Goblin";
  }

  public void lookAround() {
	  
  }
  
  public void update() {
	  // thjs could be move
	  
	  // this could be attack
	  
	  // this could be fire weapon
	  
	  // this could be pick up weapon
	  
	  // this could be .... ?
  }

}
