import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Damage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Damage extends Items
{
    private int DMG_AMOUNT = 1;//how much speed this item will give the character
    /**
     * Act - do whatever the Damage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor  actor = getOneIntersectingObject (AnimatedActor.class);
        if (actor !=null && ModeAndValue.damage < 4)
        {
            ScrollingWorld world = (ScrollingWorld)getWorld();
            ModeAndValue.damage++;
            Greenfoot.playSound("BowFire.wav");
            world.removeObject(this);
        }
    }    
}
