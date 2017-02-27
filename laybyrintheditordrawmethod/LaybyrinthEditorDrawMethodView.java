/*
 * LaybyrinthEditorDrawMethodView.java
 */

package laybyrintheditordrawmethod;

import java.awt.Color;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;

/**
 * used for storing labyrinth image
 */
import java.awt.image.BufferedImage;
/**
 * used for labyrinth data model
 */
import Labyrinth.*;
/**
 * used for labyrinth drawing 
 */
import java.awt.Graphics;

/**
 * author: Catalin Mazilu
 * Creates the GUI for Labyrinth Editor
 */
public class LaybyrinthEditorDrawMethodView extends FrameView {
    /**
     * Labyrinth cell constants
     */
    final int WALL_CELL = 1;
    final int START_CELL = -1;
    final int FREE_CELL = 0;
    final int FINISH_CELL = 2;
    
    /**
     * Selected cell type to be used in the labyrinth
     */
    int selectedCellType=0;
   
    
    /**
     * This is my labyrinth model, which stored the cell structure
     */
    LabyrinthMatrixImplExtended myLabyrinth;
    
    /**
     * Tracker for spacial structure of labyrinth matrix
     */
    CellTracker labyrinthTracker;
    
    /**
     * This objects creates the labyrinth graphical image
     */
     LabyrinthImageCreator myImageCreator;
    
    /**
     * This image stores the graphical representation of the labyrinth
     */
    BufferedImage labyrinthImage;

    
    /**
     * Defining color variables for cell drawing and assigning default values
     */
    protected Color emptyCellStrokeColor = Color.white;
    protected Color emptyCellFillColor = Color.white;
    
    protected Color wallCellStrokeColor = Color.white;
    protected Color wallCellFillColor = Color.red;
    
    protected Color startCellFillColor = Color.green;
    protected Color startCellStrokeColor = Color.white;
    
    protected Color finishCellStrokeColor = Color.white;
    protected Color finishCellFillColor = Color.blue;
    
    
    /**
     * GUI Drawing when constructor is called
     * @param app 
     */
    public LaybyrinthEditorDrawMethodView(SingleFrameApplication app) {
        super(app);
        initComponents();

        /*
         * Creating the labyrinth
         */
        myLabyrinth = new LabyrinthMatrixImplExtended(5,5);
        
        /*
         * creating the labyrinth image
         */
        labyrinthImage = new BufferedImage(262, 262, BufferedImage.TYPE_INT_ARGB);

        /*
         * Creating the labyrinth tracker
         */
        labyrinthTracker = new CellTracker();
        labyrinthTracker.createSpacialStructure(50, myLabyrinth.getRowCount(),myLabyrinth.getColumnCount());
        
        System.out.println(labyrinthTracker.getCell(10, 20));
        System.out.println(labyrinthTracker.cellList);
        labyrinthPanel.setPreferredSize(new Dimension(265,265));
        labyrinthPanel.setBorder(null);
        labyrinthPanel.setLayout(new FlowLayout());

        //drawing borders
        myImageCreator = new LabyrinthImageCreator(labyrinthImage);
        
        labyrinthPanel.add(myImageCreator,0,0);
        
        
        //changing color buttons
        
        wallCellButton.setForeground(Color.red);
        
        freeCellButton.setForeground(Color.white);
        
        startCellButton.setForeground(Color.green);
       
        finishCellButton.setForeground(Color.blue);
       
        //labyrinthPanel.setVisible(false);
        
        //mainPanel.setLayout(new GridLayout());
        
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = LaybyrinthEditorDrawMethodApp.getApplication().getMainFrame();
            aboutBox = new LaybyrinthEditorDrawMethodAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        LaybyrinthEditorDrawMethodApp.getApplication().show(aboutBox);
    }

    @Action
    public void changeWallCellStroke(){
            
        wallCellStrokeColor = JColorChooser.showDialog(labyrinthPanel, "Choose Background Color",Color.white);
            
    }
    
    @Action
    public void changeWallCellFill(){
        
        wallCellFillColor = JColorChooser.showDialog(labyrinthPanel, "Choose Background Color",Color.white);
    }
    
    @Action 
    public void changeEmptyCellStroke(){
        
        emptyCellStrokeColor = JColorChooser.showDialog(labyrinthPanel, "Choose Background Color",Color.white);
        
    }
    
    @Action
    public void changeEmptyCellFill(){
         
        emptyCellFillColor = JColorChooser.showDialog(labyrinthPanel, "Choose Background Color",Color.white);
    }    
    
    
    @Action
    public void changeStartCellFill(){

        startCellFillColor = JColorChooser.showDialog(labyrinthPanel, "Choose Background Color",Color.white);
    }
    
    @Action
    public void changeStartCellStroke(){

        startCellStrokeColor = JColorChooser.showDialog(labyrinthPanel, "Choose Background Color",Color.white);
    }
    
    @Action
    public void changeFinishCellStroke(){
            
           wallCellStrokeColor = JColorChooser.showDialog(labyrinthPanel, "Choose Background Color",Color.white);
    }
    
    @Action
    public void changeFinishCellFill(){
            
            finishCellFillColor = JColorChooser.showDialog(labyrinthPanel, "Choose Background Color",Color.red);
    }
    
    
    
    /** 
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        labyrinthPanel = new javax.swing.JPanel();
        wallCellButton = new javax.swing.JButton();
        startCellButton = new javax.swing.JButton();
        freeCellButton = new javax.swing.JButton();
        finishCellButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        colorsMenu = new javax.swing.JMenu();
        wallStrokeColor = new javax.swing.JMenuItem();
        wallFillColor = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        mainPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setOpaque(false);
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        labyrinthPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labyrinthPanel.setMaximumSize(new java.awt.Dimension(270, 270));
        labyrinthPanel.setMinimumSize(new java.awt.Dimension(270, 270));
        labyrinthPanel.setName("labyrinthPanel"); // NOI18N
        labyrinthPanel.setPreferredSize(new java.awt.Dimension(405, 405));
        labyrinthPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labyrinthPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout labyrinthPanelLayout = new javax.swing.GroupLayout(labyrinthPanel);
        labyrinthPanel.setLayout(labyrinthPanelLayout);
        labyrinthPanelLayout.setHorizontalGroup(
            labyrinthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );
        labyrinthPanelLayout.setVerticalGroup(
            labyrinthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(laybyrintheditordrawmethod.LaybyrinthEditorDrawMethodApp.class).getContext().getResourceMap(LaybyrinthEditorDrawMethodView.class);
        wallCellButton.setBackground(resourceMap.getColor("wallCellButton.background")); // NOI18N
        wallCellButton.setText(resourceMap.getString("wallCellButton.text")); // NOI18N
        wallCellButton.setBorder(null);
        wallCellButton.setName("wallCellButton"); // NOI18N
        wallCellButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wallCell(evt);
            }
        });

        startCellButton.setText(resourceMap.getString("startCellButton.text")); // NOI18N
        startCellButton.setToolTipText(resourceMap.getString("startCellButton.toolTipText")); // NOI18N
        startCellButton.setName("startCellButton"); // NOI18N
        startCellButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startCellButtonMouseClicked(evt);
            }
        });

        freeCellButton.setText(resourceMap.getString("freeCellButton.text")); // NOI18N
        freeCellButton.setName("freeCellButton"); // NOI18N
        freeCellButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                freeCellButtonMouseClicked(evt);
            }
        });

        finishCellButton.setText(resourceMap.getString("finishCellButton.text")); // NOI18N
        finishCellButton.setToolTipText(resourceMap.getString("finishCellButton.toolTipText")); // NOI18N
        finishCellButton.setName("finishCellButton"); // NOI18N
        finishCellButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finishCellButtonMouseClicked(evt);
            }
        });

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(labyrinthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(finishCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(freeCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(wallCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)))
                .addContainerGap(506, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(labyrinthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(wallCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(freeCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finishCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(laybyrintheditordrawmethod.LaybyrinthEditorDrawMethodApp.class).getContext().getActionMap(LaybyrinthEditorDrawMethodView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        colorsMenu.setText(resourceMap.getString("colorsMenu.text")); // NOI18N
        colorsMenu.setToolTipText(resourceMap.getString("colorsMenu.toolTipText")); // NOI18N
        colorsMenu.setName("colorsMenu"); // NOI18N

        wallStrokeColor.setAction(actionMap.get("changeWallCellStroke")); // NOI18N
        wallStrokeColor.setText(resourceMap.getString("wallStrokeColor.text")); // NOI18N
        wallStrokeColor.setActionCommand(resourceMap.getString("wallStrokeColor.actionCommand")); // NOI18N
        wallStrokeColor.setName("wallStrokeColor"); // NOI18N
        colorsMenu.add(wallStrokeColor);

        wallFillColor.setAction(actionMap.get("changeWallCellFill")); // NOI18N
        wallFillColor.setText(resourceMap.getString("wallFillColor.text")); // NOI18N
        wallFillColor.setName("wallFillColor"); // NOI18N
        colorsMenu.add(wallFillColor);

        jSeparator1.setName("jSeparator1"); // NOI18N
        colorsMenu.add(jSeparator1);

        jMenuItem1.setAction(actionMap.get("changeEmptyCellStroke")); // NOI18N
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        colorsMenu.add(jMenuItem1);

        jMenuItem2.setAction(actionMap.get("changeEmptyCellFill")); // NOI18N
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        colorsMenu.add(jMenuItem2);

        jSeparator2.setName("jSeparator2"); // NOI18N
        colorsMenu.add(jSeparator2);

        jMenuItem3.setAction(actionMap.get("changeStartCellStroke")); // NOI18N
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        colorsMenu.add(jMenuItem3);

        jMenuItem4.setAction(actionMap.get("changeStartCellFill")); // NOI18N
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        colorsMenu.add(jMenuItem4);

        jSeparator3.setName("jSeparator3"); // NOI18N
        colorsMenu.add(jSeparator3);

        jMenuItem5.setAction(actionMap.get("changeStartCellStroke")); // NOI18N
        jMenuItem5.setText(resourceMap.getString("jMenuItem5.text")); // NOI18N
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        colorsMenu.add(jMenuItem5);

        jMenuItem6.setAction(actionMap.get("changeFinishCellFill")); // NOI18N
        jMenuItem6.setText(resourceMap.getString("jMenuItem6.text")); // NOI18N
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        colorsMenu.add(jMenuItem6);

        menuBar.add(colorsMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Selection of wall cell
     * @param evt mouse click event
     */
private void wallCell(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wallCell
    // TODO add your handling code here:
    resetSelectionCell();
    this.wallCellButton.setBackground(Color.red);
    this.selectedCellType=this.WALL_CELL;
    
}//GEN-LAST:event_wallCell

/**
 * Selecting free cell type
 * @param evt mouse click event
 */
private void freeCellButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_freeCellButtonMouseClicked
    // TODO add your handling code here:
    resetSelectionCell();
    this.freeCellButton.setBackground(Color.red);
    
    this.selectedCellType=this.FREE_CELL;

}//GEN-LAST:event_freeCellButtonMouseClicked

/**
 * Selecting start cell type
 * @param evt mouse click event
 */
private void startCellButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startCellButtonMouseClicked
    // TODO add your handling code here:
    resetSelectionCell();
    this.startCellButton.setBackground(Color.red);
    this.selectedCellType=this.START_CELL;
    System.out.println("Start cell selected " + this.selectedCellType);
}//GEN-LAST:event_startCellButtonMouseClicked

/**
 * Selecting finish cell type
 * @param evt mouse click event
 */
private void finishCellButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishCellButtonMouseClicked
    // TODO add your handling code here:
    resetSelectionCell();
    this.finishCellButton.setBackground(Color.red);
    this.selectedCellType=this.FINISH_CELL;
}//GEN-LAST:event_finishCellButtonMouseClicked

/**
 * Handling mouse click on labyrinth construction site
 * @param evt mouse click event
 */
private void labyrinthPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labyrinthPanelMouseClicked
      Point p = evt.getPoint();
      
      JOptionPane opPane = new JOptionPane(0);
      //opPane.showMessageDialog(labyrinthPanel,"X: "+p.x+ " Y: "+p.y);
      //opPane.showMessageDialog(labyrinthPanel,"Cell  "+labyrinthTracker.getCell(p.x, p.y).getX()+", "+labyrinthTracker.getCell(p.x, p.y).getY());
      
      
      Cell currentCell = labyrinthTracker.getCell(p.x, p.y);
      
      int cellX = labyrinthTracker.getCell(p.x, p.y).getX();
      int cellY = labyrinthTracker.getCell(p.x, p.y).getY();
      
      System.out.println("Empty " + this.FREE_CELL);
      System.out.println("Wall " + this.WALL_CELL);
      System.out.println("Start  " + this.START_CELL);
      System.out.println("Finish " + this.FINISH_CELL);
      System.out.println("Selected cell type is "+ this.selectedCellType);
      
      
      //Empty cell drawing
      if (selectedCellType==this.FREE_CELL){
          //changing labyrinth data model
          myLabyrinth.setCellAt(currentCell,this.FREE_CELL);
          
          //drwawing the labyrinth
          myImageCreator.drawEmptyCell(labyrinthTracker.getCellSpatialFirstCorner(cellX, cellY),labyrinthTracker.getCellSpatialSecondCorner(cellX, cellY), emptyCellFillColor, emptyCellStrokeColor);
          
      }
    
        //Wall cell drawing
      if (selectedCellType==this.WALL_CELL){
          //changing labyrinth data model
          myLabyrinth.setCellAt(currentCell,this.WALL_CELL);
          
          //drawing the cell
          myImageCreator.drawWallCell(labyrinthTracker.getCellSpatialFirstCorner(cellX, cellY),labyrinthTracker.getCellSpatialSecondCorner(cellX, cellY), wallCellFillColor, wallCellStrokeColor);
      }
      
        //START cell drawing
      if (selectedCellType==this.START_CELL){
           System.out.print("Has value " +myLabyrinth.startCellHasValue());
           
               System.out.println("Start cell has no value");
                //changing labyrinth data model
                if (myLabyrinth.setStartCell(cellX, cellY))
                    //drawing the cell
                    myImageCreator.drawStartCell(labyrinthTracker.getCellSpatialFirstCorner(cellX, cellY),labyrinthTracker.getCellSpatialSecondCorner(cellX, cellY), startCellFillColor, startCellStrokeColor);
           
      }
      
        //FINISH cell drawing
      if (selectedCellType==this.FINISH_CELL){
          System.out.print("Has value " +myLabyrinth.startCellHasValue());
            //changing labyrinth data model
            if (myLabyrinth.setFinishCell(cellX, cellY))
                //drawing the cell
                myImageCreator.drawFinishCell(labyrinthTracker.getCellSpatialFirstCorner(cellX, cellY),labyrinthTracker.getCellSpatialSecondCorner(cellX, cellY), finishCellFillColor, finishCellStrokeColor);
      
           
      }
    
      System.out.println(myLabyrinth);
      myImageCreator.updateUI();
    
    
      
}//GEN-LAST:event_labyrinthPanelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu colorsMenu;
    private javax.swing.JButton finishCellButton;
    private javax.swing.JButton freeCellButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPanel labyrinthPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton startCellButton;
    private javax.swing.JButton wallCellButton;
    private javax.swing.JMenuItem wallFillColor;
    private javax.swing.JMenuItem wallStrokeColor;
    // End of variables declaration//GEN-END:variables


    private JDialog aboutBox;
    
    
    
    /**
    * used to reset selected buttons
    */
    public void resetSelectionCell(){
            freeCellButton.setBackground(Color.gray);
            startCellButton.setBackground(Color.gray);
            finishCellButton.setBackground(Color.gray);
            wallCellButton.setBackground(Color.gray);
    }
    
    
    
}//end of public class

//this class creates a labyrinth representation
class LabyrinthImageCreator extends javax.swing.JPanel {
 
    
    private  BufferedImage myImage; 
    int phase=0; //for testing pursposes
    
      LabyrinthImageCreator(BufferedImage Img) {
            //set a preferred size for the custom panel.
          //super.setPreferredSize(new Dimension(420,420));    //original size
          super.setPreferredSize(new Dimension(270,270));
              
              this.myImage = Img;
        }
   
    
    /**
     * This method is called to draw the object
     * @param g graphic context
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics g2 = myImage.getGraphics();
        
        g2.setColor(new Color(210,210,210));
        g2.setPaintMode();
        
        
        //drawing vertical lines
        for (int i=0; i<=5; i++)
            g2.drawRect(i*50, 0, 1, 250);
        //drawing horizontal lines
        for (int j=0; j<=5; j++)
            g2.drawRect(0, j*50, 250, 1);
               

        g.drawImage(myImage, 10, 0, this);
        
        g2.dispose();
    
    }
    
    /**
     * Draws a START cell at specified location
     * @param firstCorner first corner of the cell
     * @param secondCorner second corner of the cell
     */
    public void drawStartCell(Cell firstCorner, Cell secondCorner, Color fillColor, Color strokeColor){
        System.out.println("Draw start Cell");
        Graphics g2 = myImage.getGraphics();
        
        g2.setColor(fillColor);
        g2.setPaintMode();
        g2.fillRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
        g2.setColor(strokeColor);
        g2.drawRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
    
    }
    
    /**
     * Draws a FINISH cell at specified location
     * @param firstCorner first corner of the cell
     * @param secondCorner second corner of the cell
     */
    public void drawFinishCell(Cell firstCorner, Cell secondCorner, Color fillColor, Color strokeColor) {
        System.out.println("Draw Finish Cell");
        Graphics g2 = myImage.getGraphics();
        g2.setColor(fillColor);
        g2.setPaintMode();
        g2.fillRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
        g2.setColor(strokeColor);
        g2.drawRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
    
    }
    
     /**
     * Draws an EMPTY cell at specified location
     * @param firstCorner first corner of the cell
     * @param secondCorner second corner of the cell
     */
    public void drawEmptyCell(Cell firstCorner, Cell secondCorner, Color fillColor, Color strokeColor){
        System.out.println("Draw Empty Cell");
        Graphics g2 = myImage.getGraphics();
        
        g2.setColor(fillColor);
        g2.setPaintMode();
        g2.fillRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
        g2.setColor(strokeColor);
        g2.drawRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
    }
    
     /**
     * Draws a WALL cell at specified location
     * @param firstCorner first corner of the cell
     * @param secondCorner second corner of the cell
     */
    public void drawWallCell(Cell firstCorner, Cell secondCorner, Color fillColor, Color strokeColor){
        System.out.println("Draw Wall Cell");
        Graphics g2 = myImage.getGraphics();
        g2.setPaintMode();
        g2.setColor(fillColor);
        g2.fillRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
        g2.setColor(strokeColor);
        g2.drawRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
    }

}

