package nz.ac.aut.prog2.minesweeper.model;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test framework for the Occupant class.
 *
 * @author  Anne Philpott and Stefan Marks
 * @version v1.0 - 2012.06: Created
 */
public class OccupantTest 
{
    private MineWorld world;
    private Position  position;
    private Occupant  occupant;
    
    /**
     * Inner class that only serves to create a basic dummy instance of an occupant.
     */
    public class TestOccupant extends Occupant
    {
        /**
         * Creates a dummy occupant.
        * 
        * @param initialPosition the initial position of this occupant
        */
        public TestOccupant(Position initialPosition)
        {
            super(initialPosition);
        }

        @Override
        public String getStringRepresentation()
        {
            return ""; // this isn't going to be tested anyway
        }
    }


    /**
     * Default constructor for test class.
     */
    public OccupantTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        world    = new MineWorld(5, 5);
        position = new Position(world, 1, 2); 
        occupant = new TestOccupant(position);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        occupant = null;
        world = null;
        position = null;       
    }
    
    /**
     * Test of getPosition method, of class Occupant.
     */
    @Test
    public void testGetPosition()
    {
        assertEquals(position, occupant.getPosition());
    }

    /**
     * Test of updateAddress method, of class Occupant.
     */
    @Test
    public void testSetPosition() 
    {
        Position newPosition = new Position(world,1,2);
        occupant.setPosition(newPosition);
        assertEquals(newPosition, occupant.getPosition());
    }
}
