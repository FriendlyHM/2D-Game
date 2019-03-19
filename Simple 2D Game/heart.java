import greenfoot.*;

/**
 * Write a description of class heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class heart extends Items
{
    private int HEALTH_AMOUNT = 10;//how much health this item will give the character
    /**
     * Act - do whatever the heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor  actor = getOneIntersectingObject (AnimatedActor.class);
        if (actor !=null)
        {
            ScrollingWorld world = (ScrollingWorld)getWorld();
            world.addLife(HEALTH_AMOUNT);
            Greenfoot.playSound("HealthClicked.wav");
            world.removeObject(this);

        }
    }    
}
