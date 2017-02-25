/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;


/**
 * This class adds new methods to Labyrinth Class by adding new methods
 * @author Catalin Mazilu
 */
public class LabyrinthMatrixImplExtended extends LabyrinthMatrixImpl{
    
    /**
     * This is the default constructor
     */
    LabyrinthMatrixImplExtended(){
        super();
    }
    
    /**
     *  Loads labyrinth data from file
     * @param fileName name of text file containing the labyrinth data
     */
    LabyrinthMatrixImplExtended(String fileName){
        super(fileName);
    }
    /**
     * This constructor creates an empty labyrinth by sent number of rows and columns
     * @param columns number of columns
     * @param rows number of rows
     */
    public LabyrinthMatrixImplExtended(int rows, int columns){
        this.setColumnCount(columns);
        this.setRowCount(rows);
    }
    
    /**
     * This class verifies if a labyrinth cell is on border
     * @param row  cell row 
     * @param column cell column
     * @return true or false
     */
    public boolean isBorderCell(int row , int column){
        
        if ( row==0 || column==0 || row==this.getRowCount()-1 || column==this.getRowCount()-1)
            return true;
        
        return false;
    }

    /**
     * sets the Start Cell
     * @param row cell row
     * @param column cell column
     * @return true or false depending on cell location
     */
    public boolean setStartCell(int row, int column){
        
        /*
         * First step is to see if the cell is on border
         */
        if ( !isBorderCell(row,column))
            return false;
        
        /*
         * Second step is to reset an existing startCell
         */
        Cell sc = this.getStartCell();
        this.setCellAt(sc,this.EMPTY_CELL);
         /*
         * Third step is to set the new start cell
         */
        this.setCellAt(row, column, this.START_CELL);
        
        return true;
    }

    
       /**
     * sets the Finish Cell
     * @param row cell row
     * @param column cell column
     * @return true or false depending on cell location
     */
    public boolean setFinishCell(int row, int column){
        
        /*
         * First step is to see if the cell is on border
         */
        if ( !isBorderCell(row,column))
            return false;
        
        /*
         * Second step is to reset an existing startCell
         */
        Cell sc = this.finishCell();
        this.setCellAt(sc,this.EMPTY_CELL);
         /*
         * Third step is to set the new start cell
         */
        this.setCellAt(row, column, this.FINISH_CELL);
        
        return true;
    }

    
   
  
}
