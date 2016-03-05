import java.lang.Math;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class Orc extends Creature {


  String orcNames [] = {"Gobby", "Glack", "Glub", "Gork", "Gazba", "Glick"};
  
  public Goblin (Player player, int x, int y, String glyph, CSIColor color, int health, int strength, int agility, int luck) {
    super(player, x, y, glyph, color, health, strength, agility, luck);
	this.setName(orcNames[(int)(Math.random()*orcNames.length)]);
  }

  public String toString() {
          return "Orc(Name:" + this.name + "| Health:" + this.health + ")";
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
