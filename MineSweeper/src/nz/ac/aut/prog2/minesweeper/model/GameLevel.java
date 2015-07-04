package nz.ac.aut.prog2.minesweeper.model;

/**
 * Enumeration for the difficulty levels (and their mine probabilities) of Minesweeper.
 * 
 * @author Anne Philpott and Stefan Marks
 * @version v1.0 - 2012.06: Created
 */
public enum GameLevel
{
    BEGINNER(0.125), INTERMEDIATE(0.16), EXPERT(0.207);
        
    // the probability of mines in this difficulty
    private double mineProbability;

    /**
     * Creates a difficulty level enumeration
     * with the probability of mines associated.
     * 
     * @param mineProbability the probability of mines
     */
    private GameLevel(double mineProbability)
    {
        this.mineProbability = mineProbability;
    }
    
    /**
     * Gets the probability of mines for this difficulty level.
     * 
     * @return the mine probability
     */
    public double getProbability()
    {
        return mineProbability;
    }
}
