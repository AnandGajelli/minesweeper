
package nz.ac.aut.prog2.minesweeper;

import nz.ac.aut.prog2.minesweeper.model.GameLevel;
import nz.ac.aut.prog2.minesweeper.model.MineWorld;
/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args)
    {
        MineWorld world = new MineWorld(10, 10);
        world.startGame(GameLevel.BEGINNER);
        world.draw();
    }
}
