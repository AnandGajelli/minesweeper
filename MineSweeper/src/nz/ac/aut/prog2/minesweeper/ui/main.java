/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.prog2.minesweeper.ui;

import nz.ac.aut.prog2.minesweeper.model.MineWorld;

/**
 *
 * @author User
 */
public class main {
   public static void main (String[] args)
   {
         MineWorld world = new MineWorld(10, 10);
    final MineSweeperUI ui = new MineSweeperUI(world);
    
    java.awt.EventQueue.invokeLater(new Runnable(){
        @Override
        public void run()
        {
            ui.setVisible(true);
    }
    
});
     
}
}
