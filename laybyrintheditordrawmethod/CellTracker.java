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
    ArrayList<SuperCell> cellList = new ArrayList<SuperCell>();
    
    /**
     * Adds a cell to cell list
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
            if (  pointX > s.getFirstCorner().getX() && pointX < s.getSecondCorner().getX() && pointY > s.getSecondCorner().getY() && pointY< s.getSecondCorner().getY()      )
                return new Cell(s.getX(),s.getY());
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
    
   

}