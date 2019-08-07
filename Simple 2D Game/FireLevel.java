import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireLevel extends Items
{
    private int FIRE_AMOUNT = 2;//how much fire speed this item will give the character
    /**
     * Act - do whatever the Damage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor  actor = getOneIntersectingObject (AnimatedActor.class);
        if (actor !=null && ModeAndValue.fireLevel < 10)
        {
            ScrollingWorld world = (ScrollingWorld)getWorld();
            ModeAndValue.fireLevel += FIRE_AMOUNT;
            Greenfoot.playSound("BowFire.wav");
            world.removeObject(this);
        }
    }    
}
