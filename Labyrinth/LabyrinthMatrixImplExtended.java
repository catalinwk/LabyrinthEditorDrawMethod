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
        
        
        Cell sc = this.getStartCell();
        /*
         * Second step is to reset an existing startCell
         * UNUSED code variant
        
        this.setCellAt(sc,this.EMPTY_CELL);
         */
         
        //our code makes posibile just 1 setting of start CELL
        if (matrix[sc.getX()][sc.getY()]==this.START_CELL)
            return false;
        
        /*
         * Third step is to set the new start cell in the matrix and the variable startCell
         */
        this.setCellAt(row, column, this.START_CELL);
        this.startCell.setCell(row, column);
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
        
        Cell sc = this.finishCell();
        /*
         * SKIP Second step is to reset an existing startCell - we're allowing just 1 finish cell to by manually setted
         this.setCellAt(sc,this.EMPTY_CELL);
         */
        //our code makes posibile just 1 setting of start CELL
        if (matrix[sc.getX()][sc.getY()]==this.FINISH_CELL)
            return false;
        
        
         /* 
         * Third step is to set the new start cell and finishCell variable
         */
        this.setCellAt(row, column, this.FINISH_CELL);
        this.finishCell.setCell(row, column);
        return true;
    }

    /**
     * Checks if start cell has a valid value in the labyrinth
     * @return true or false
     */
    public boolean startCellHasValue(){
        if (this.getCellAt(this.getStartCell().getX(),this.getStartCell().getY())==this.START_CELL)
        
            return true;
        
        return false;
    }
    
    /**
     * Checks if FINISH cell has a valid value in the labyrinth
     * @return true or false
     */
    public boolean finishCellHasValue(){
          if (this.getCellAt(this.finishCell().getX(),this.finishCell().getY())==this.FINISH_CELL)
            return true;
        
        return false;
    }
   
  
}
