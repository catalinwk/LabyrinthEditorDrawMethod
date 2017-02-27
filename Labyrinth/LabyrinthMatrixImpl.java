/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;
import Labyrinth.interfaces.*;
import java.io.*;
import java.util.*;

/**
 * This class implements Labyrinth interface, using a matrix as data storage
 * @author Catalin Mazilu
 */
public class LabyrinthMatrixImpl 

implements Labyrinth {
    /**
     * CELL TYPES
     */
    public final int WALL_CELL = 1;
    public final int EMPTY_CELL = 0;
    public final int START_CELL = -1;
    public final int FINISH_CELL = 2;
    
    /**
     * cells storage
     */
    protected int[][] matrix = new int[100][100];
    
    /**
     * row count
     */
    protected int rows = 0;

    /**
     * column count
     */
    protected int columns = 0;
    
    /**
     * Gets number of rows
     * @return number of rows
     */
    public int getRowCount(){
        return rows;
    };
    
    /**
     * Setter for rows
     * @param rows number of labyrinth rows
     */
    public void setRowCount(int rows){
        this.rows = rows;
    }
    
    protected Cell startCell = new Cell(0,0);
    protected Cell finishCell = new Cell(0,0);
    

    LabyrinthMatrixImpl(String fileName){
        fileImport(fileName);
    }
   
     LabyrinthMatrixImpl( ){
      
    }
   
    
    /**
     * Gets the number of columns
     * @return number of columns
     */
    public int getColumnCount(){
        return columns;
    }

    /**
     * Setter for columns
     * @param columns number the of columns
     */
    public void setColumnCount(int columns){
        this.columns=columns;
    }
    
    /**
     * Checks if a labyrinth cell is free or not
     * @return true or false
     */
    public boolean isFreeAt(int x, int y){
        if (matrix[x][y]!=1) //is not a wall (can be start or finish)
            return true;
        else
            return false;
    }
    
    /**
     * Checks if  the cell is a wall or not
     * @return true or false 
     */
    public boolean isWallAt(int x, int y){
        if (matrix[x][y]==1)
            return true;
        
        return false;
    }
    
         /**
     *  Gets cell content
     * @param x row
     * @param y column
     * @return cell content
     */
    public int getCellAt(int x, int y){
        return matrix[x][y];
    }
    
    
    
    
    /**
     * Returns start cell
     * @return start cell
     */
    public Cell getStartCell(){
        
        return startCell;
    }
    
    /**
     * Returns finish cell
     * @return finish cell
     */
    public Cell finishCell(){
        return finishCell;
    }
    
    /**
     * Imports Labyrinth data form file
     * @param fileName - name of the file
     * @return true or false based on import result
     */
    public boolean fileImport(String fileName){
    
        try {
            
           Scanner f = new Scanner(new FileReader(fileName));
    
            
            this.rows = f.nextInt();
            this.columns = f.nextInt();
            
            for (int i=0; i<rows; i++)
                for (int j=0; j<columns; j++)
                {
                    matrix[i][j]=f.nextInt();
                    
                    //setting start and finish cell
                    if (matrix[i][j]==this.START_CELL)
                        startCell.setCell(i, j);
                    if (matrix[i][j]==this.FINISH_CELL)
                        finishCell.setCell(i,j);
                }
            
        } catch (IOException e) {
            System.out.println("Error on importing labyrinth file!");
            return false;
        } 
            
        
        return true;
    }
    
    /**
     * Gets a string representation of Labyrinth for testing
     * @return labyrinth as a string
     */
    public String toString(){
        String view = "";
        
        for (int i=0; i<rows; i++){
           
            for (int j=0; j<columns; j++)
                    view += matrix[i][j] + " ";
           
            view += "\n";
        }
        return  view;
    }
      
    /**
     * Sets the value of the specified cell
     * @param row cell row
     * @param column cell column
     * @param value cell value
     */
    public void setCellAt(int row, int column, int value){
           matrix[row][column]=value;
    }
    
    /**
     * Sets the value of the specified cell
     * @param c Cell 
     * @param value cell value
     */
    public void setCellAt(Cell c, int value){
      matrix[c.x][c.y]=value;  
    }
}