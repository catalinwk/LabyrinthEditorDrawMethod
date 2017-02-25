/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laybyrintheditordrawmethod;
import Labyrinth.*;
import java.util.*;

/**
 * This class helps tracking cell space coordinates (when a labyrinth is drawn on a surface) and matrix position (cell data)
 * @author Catalin Mazilu
 */
public class CellTracker {
    /**
     * keeps cell list
     */
    public ArrayList<SuperCell> cellList = new ArrayList<SuperCell>();
    
    /**
     * Adds a spacial cell to cell list
     * @param x matrix coordinate
     * @param y matrix coordinate
     * @param corner1X X coordinate of the first corner
     * @param corner1Y Y coordinate of the first corner
     * @param corner2X X coordinate of the second corner
     * @param corner2Y Y coordinate of the second corner
     */  
    public void addCell(int x, int y, int corner1X, int corner1Y, int corner2X, int corner2Y){
        cellList.add(new SuperCell(x,y, corner1X, corner1Y, corner2X, corner2Y));
    }
    
    /**
     * Returns the corresponding matrix cell to a space point
     * @param pointX - X coordinate
     * @param pointY - Y coordinate
     * @return corresponding matrix cell
     */
    public Cell getCell(int pointX, int pointY){
        
        for (SuperCell s:cellList){
            if (  pointX > s.getFirstCorner().getX() && pointX < s.getSecondCorner().getX() && pointY > s.getFirstCorner().getY() && pointY< s.getSecondCorner().getY()      )
                return new Cell(s.getX(),s.getY());
        }
        
        return null;
    }
    
    /**
     * Creates a spacial tracking structure for a matrix
     * @param cell_size, the side length of a cell 
     * @param rows number of rows
     * @param columns number of columns
     */
    public void createSpacialStructure(int cell_size, int rows, int columns){
           
        for (int i=0; i<rows; i++) //going by lines, y coodrinate
            for (int j=0; j<columns; j++) //going by columns x coordinate
            {
                    int cornerX1 = cell_size*j;
                    int cornerY1 = cell_size*i;
                    int cornerX2 = cornerX1+cell_size;
                    int cornerY2 = cornerY1+cell_size;
                    
                    this.addCell(i, j, cornerX1, cornerY1, cornerX2, cornerY2);
                   
            }
    }
    
    /**
     * Gets the spacial X coordinate of a matrix cell
     * @param x cell row
     * @param y cell column
     * @return X spacial coordinate of cell
     */
    public int getCellSpatialFirstCornerX(int x, int y){
        for (SuperCell s:cellList){
            if (s.getX()==x && s.getY()==y)
                return s.getFirstCorner().getX();
        }
        return 0;
    }

  /**
     * Gets the spacial y coordinate of a matrix cell
     * @param x cell row
     * @param y cell column
     * @return X spacial coordinate of cell
     */
  public int getCellSpatialFirstCornerY(int x, int y){
        for (SuperCell s:cellList){
            if (s.getX()==x && s.getY()==y)
                return s.getFirstCorner().getY();
        }
        return 0;
    }    

  /**
   * Returns spatial cell first corner
   * @param x matrix cell row
   * @param y matrix cell column
   * @return first corner of the cell
   */
  public Cell getCellSpatialFirstCorner(int x, int y){
          for (SuperCell s:cellList){
            if (s.getX()==x && s.getY()==y)
                return s.getFirstCorner();
        }
        return null;
  }
  /**
   * Returns spatial cell first corner
   * @param x matrix cell row
   * @param y matrix cell column
   * @return first corner of the cell
   */
  public Cell getCellSpatialSecondCorner(int x, int y){
          for (SuperCell s:cellList){
            if (s.getX()==x && s.getY()==y)
                return s.getSecondCorner();
        }
        return null;
  }


}


/**
 * This class adds functionality to Cell class, by adding space coordinates to matrix cell
 * @author Catalin Mazilu
 */
class SuperCell extends Cell {
    /**
     * First corner of the spacial cell
     */
    public Cell firstCorner;
    
    /**
     * Second corner of the spacial cell
     */
    public Cell secondCorner;
    
    /**
     * 
     * @param x - matrix line
     * @param y - matrix column
     * @param corner1X - first
     * @param corner1X X coordinate of the first corner
     * @param corner1Y Y coordinate of the first corner
     * @param corner2X X coordinate of the second corner
     * @param corner2Y Y coordinate of the second corner
     */
    SuperCell(int x, int y, int corner1X, int corner1Y, int corner2X, int corner2Y){
        super(x,y);
        firstCorner = new Cell(corner1X, corner1Y);
        secondCorner = new Cell(corner2X, corner2Y);
    }

    /**
     * 
     * @return First corner of spacial cell
     */
    public Cell getFirstCorner() {
        return firstCorner;
    }

    /**
     * 
     * @return Second corner of spacial cell
     */
    public Cell getSecondCorner() {
        return secondCorner;
    }
    
   public String toString(){
       return super.toString() + " " + firstCorner.toString() + " " + secondCorner.toString()+ " | ";
   }

}