import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class Player {

  public enum Movement {UP, DOWN, LEFT, RIGHT, HOLD};

  private String name;
  private int health;
  private int strength;
  private int agility;
  private int luck;

  private int x;
  private int y;
  private String glyph;
  private CSIColor color;
  private int fovRadius;

  // TODO
  private int kills;
  private int damageDone;
  private int encounters;
  private int xp;


  private boolean isAlive;
  private boolean isuserInput;
  private boolean isBot;



  public Player () {
  }

  public Player (int x, int y, String glyph, CSIColor color, String name, int health, int strength, int agility, int luck) {
    this.x = x;
    this.y = y;
    this.glyph = glyph;
    this.color = color;

    this.name = name;
    this.health = health;
    this.strength = strength;
    this.agility = agility;
    this.luck = luck;
  }



  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public int getHealth() {
    return this.health;
  }
  public void setHealth(int health) {
    this.health = health;
  }

  public int getStrength() {
    return this.strength;
  }
  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getAgility() {
    return this.agility;
  }
  public void setAgility(int agility) {
    this.agility = agility;
  }

  public int getLuck() {
    return this.luck;
  }
  public void setLuck(int luck) {
    this.luck = luck;
  }

  public boolean getIsBot() {
    return this.isBot;
  }
  public void setIsBot(boolean isBot) {
    this.isBot = isBot;
  }

  public boolean getIsAlive() {
    return this.isAlive;
  }
  public void setIsAlive(boolean isAlive) {
    this.isAlive = isAlive;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public String getGlyph() {
    return this.glyph;
  }

  public CSIColor getColor() {
    return this.color;
  }



  public String toString() {
          //return "Player(Name:" + this.name + "|" + type + " Health:" + this.health + ")";
          return "Player(Name:" + this.name + " Health:" + this.health + ")";
  }

  public boolean move(ConsoleSystemInterface csi, Map map) {
    CharKey userInput;
    //do { // discover a valid move for this cell
        System.out.printf("Player(%d,%d)\n", this.getX(), this.getY());
        userInput = csi.inkey();
        //csi.cls();
        if(userInput.isUpArrow()){
          if (this.getY() > 0) {
            this.setY(this.getY()-1);
          }
          else {
            System.out.println("Invalid move");
          }

        }
        if(userInput.isDownArrow()){
          if (this.getY() < map.getWorldHeight()) {
            this.setY(this.getY()+1);
          } else {
            System.out.println("Invalid move");
          }

        }
        if(userInput.isLeftArrow()){
          if (this.getX() > 0) {
            this.setX(this.getX()-1);
          } else {
            System.out.println("Invalid move");
          }

        }
        if(userInput.isRightArrow()){
          if (this.getX() < map.getWorldWidth()) {
            this.setX(this.getX()+1);
          } else {
            System.out.println("Invalid move");
          }
        }
        if(userInput.code == CharKey.H || userInput.isSelfArrow()){
          this.setX(this.getX());
        }
        System.out.printf("Player(%d,%d) - %s\n", this.getX(), this.getY(),this.getGlyph());
          //Creature.toString(map.tile(this.getX(), this.getY()).glyph())) ;
        //renderFit();
      //} while (userInput.code != CharKey.ESC);
	return true;
  }


}
