import java.awt.Color;

import net.slashie.libjcsi.CSIColor;

public enum Tile {
    /*GRASS('"', CSIColor.GREEN),
    WALL('#', CSIColor.BROWN),
    DIRT('.', CSIColor.BRONZE),
    WATER('o', CSIColor.BLUE);*/

    WALL('#', CSIColor.BROWN),
    DIRT('.', CSIColor.BRONZE);

    private char glyph;
    private CSIColor color;


    Tile(char glyph, CSIColor color){
      this.glyph = glyph;
      this.color = color;
    }

    public char glyph() { return glyph; }
    public CSIColor color() { return color; }

    /*public void print(Window window, int x, int y) {
      window.print(x, y, this.glyph, this.color);
    }*/



}
