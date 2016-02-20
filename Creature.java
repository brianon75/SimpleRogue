import net.slashie.libjcsi.CSIColor;

public class Creature {

  //public enum CreatureType {GOBLIN, ORC, HUMAN};
  public enum Movement {UP, DOWN, LEFT, RIGHT, HOLD};

  //private CreatureType type;
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
  private boolean isPlayer;

  public Creature () {
  }

  public Creature (Creature player, int x, int y, String glyph, CSIColor color, String name, int health, int strength, int agility, int luck) {
    this.x = x;
    this.y = y;
    this.glyph = glyph;
    this.color = color;

    this.name = name;
    this.health = health;
    this.strength = strength;
    this.agility = agility;
    this.luck = luck;

    this.isAlive = true;

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
          //return "Creature(Name:" + this.name + "|" + type + " Health:" + this.health + ")";
          return "Creature(Name:" + this.name + " Health:" + this.health + ")";
  }


}
