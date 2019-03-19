import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Speed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speed extends Items
{
    private int SPEED_AMOUNT = 1;//how much speed this item will give the character
    /**
     * Act - do whatever the Speed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor  actor = getOneIntersectingObject (AnimatedActor.class);
        if (actor !=null && ModeAndValue.maxSpeed < 3)
        {
            ScrollingWorld world = (ScrollingWorld)getWorld();
            world.getObjects(AnimatedActor.class).get(0).plusSpeed(SPEED_AMOUNT);
            ModeAndValue.maxSpeed ++;
            Greenfoot.playSound("Electric.wav");
            world.removeObject(this);

        }
    }    
}
