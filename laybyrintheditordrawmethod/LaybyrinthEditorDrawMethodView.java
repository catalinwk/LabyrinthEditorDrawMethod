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
    final int START_CELL = 3;
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
        
        labyrinthPanel.setLayout(new FlowLayout());

        //drawing borders
        myImageCreator = new LabyrinthImageCreator(labyrinthImage);
        labyrinthPanel.add(myImageCreator,0,0);
        
        
    
        
        
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

    /** This method is called from within the constructor to
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
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        labyrinthPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labyrinthPanel.setMaximumSize(new java.awt.Dimension(405, 405));
        labyrinthPanel.setMinimumSize(new java.awt.Dimension(405, 405));
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

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labyrinthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(freeCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wallCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finishCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labyrinthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(wallCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(freeCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finishCellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
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
      
      int cellX = labyrinthTracker.getCell(p.x, p.y).getX();
      int cellY = labyrinthTracker.getCell(p.x, p.y).getY();
      
      System.out.println("Empty " + this.FREE_CELL);
      System.out.println("Wall " + this.WALL_CELL);
      System.out.println("Start  " + this.START_CELL);
      System.out.println("Finish " + this.FINISH_CELL);
      System.out.println("Selected cell type is "+ this.selectedCellType);
      
      
      //cell drawing
      if (selectedCellType==this.FREE_CELL){
          myImageCreator.drawEmptyCell(labyrinthTracker.getCellSpatialFirstCorner(cellX, cellY),labyrinthTracker.getCellSpatialSecondCorner(cellX, cellY));
      }
    
        //cell drawing
      if (selectedCellType==this.WALL_CELL){
          myImageCreator.drawWallCell(labyrinthTracker.getCellSpatialFirstCorner(cellX, cellY),labyrinthTracker.getCellSpatialSecondCorner(cellX, cellY));
      }
      
        //cell drawing
      if (selectedCellType==this.START_CELL){
          myImageCreator.drawStartCell(labyrinthTracker.getCellSpatialFirstCorner(cellX, cellY),labyrinthTracker.getCellSpatialSecondCorner(cellX, cellY));
      }
      
        //cell drawing
      if (selectedCellType==this.FINISH_CELL){
          myImageCreator.drawFinishCell(labyrinthTracker.getCellSpatialFirstCorner(cellX, cellY),labyrinthTracker.getCellSpatialSecondCorner(cellX, cellY));
      }
    
      myImageCreator.updateUI();
    
    
      
}//GEN-LAST:event_labyrinthPanelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton finishCellButton;
    private javax.swing.JButton freeCellButton;
    private javax.swing.JPanel labyrinthPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton startCellButton;
    private javax.swing.JButton wallCellButton;
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
              super.setPreferredSize(new Dimension(420,420));
              
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
        g2.setColor(Color.white);
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
    public void drawStartCell(Cell firstCorner, Cell secondCorner){
        System.out.println("Draw start Cell");
        Graphics g2 = myImage.getGraphics();
        g2.setColor(Color.GREEN);
        g2.setPaintMode();
        g2.fillRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
    
    }
    
    /**
     * Draws a FINISH cell at specified location
     * @param firstCorner first corner of the cell
     * @param secondCorner second corner of the cell
     */
    public void drawFinishCell(Cell firstCorner, Cell secondCorner){
        System.out.println("Draw Finish Cell");
        Graphics g2 = myImage.getGraphics();
        g2.setColor(Color.blue);
        g2.setPaintMode();
        g2.fillRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
    
    }
    
     /**
     * Draws an EMPTY cell at specified location
     * @param firstCorner first corner of the cell
     * @param secondCorner second corner of the cell
     */
    public void drawEmptyCell(Cell firstCorner, Cell secondCorner){
        System.out.println("Draw Empty Cell");
        Graphics g2 = myImage.getGraphics();
        g2.setColor(Color.white);
        g2.setPaintMode();
        g2.fillRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
    
    }
    
     /**
     * Draws a WALL cell at specified location
     * @param firstCorner first corner of the cell
     * @param secondCorner second corner of the cell
     */
    public void drawWallCell(Cell firstCorner, Cell secondCorner){
        System.out.println("Draw Wall Cell");
        Graphics g2 = myImage.getGraphics();
        g2.setColor(Color.red);
        g2.setPaintMode();
        g2.fillRect(firstCorner.getX(), firstCorner.getY(), secondCorner.getX()-firstCorner.getX(), secondCorner.getY()-firstCorner.getY());
    
    }

}

