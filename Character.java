import java.lang.Character;

public class Creature {
  // x and y coordinates
  private int x;
  private int y;
  private char c;

  private String name;

  private int agiliy;
  private int strength;

  private int fovRadius;

  public Creature() {
  }

  public Creature(int x, int y, char c) {
    this.x = x;
    this.y = y;
    this.glyph = glyph;
  }

  public int getX() {
    return this.x
  };

  public int getY() {
    return this.y;
  }

  public Character getGlyph() {
    return this.c;
  }

  public String getGlyph() {
    return Character.asString(this.c);
  }

}
