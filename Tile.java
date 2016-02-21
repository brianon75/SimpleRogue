import java.awt.Color;

import net.slashie.libjcsi.CSIColor;

public enum Tile {
    /*GRASS('"', CSIColor.GREEN),
    WALL('#', CSIColor.BROWN),
    DIRT('.', CSIColor.BRONZE),
    WATER('o', CSIColor.BLUE);*/

    WALL('#', CSIColor.BROWN, CSIColor.DARK_BROWN),
    DIRT('.', CSIColor.BRONZE, CSIColor.GREEN);

    private char glyph;
    private CSIColor color;
    private CSIColor altColor;


    Tile(char glyph, CSIColor color, CSIColor alt){
      this.glyph = glyph;
      this.color = color;
      this.altColor = alt;
    }

    public char glyph() {
      return glyph;
    }
    public CSIColor color() {
      return color;
    }
    public CSIColor altColor() {
      return color;
    }

    /*public void print(Window window, int x, int y) {
      window.print(x, y, this.glyph, this.color);
    }*/



}
