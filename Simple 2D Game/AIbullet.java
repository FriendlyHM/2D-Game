import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AIbullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AIbullet extends Actor
{
    private boolean left;
    public AIbullet(boolean left)
    {
        this.left = left;
    }

    /**
     * Act - do whatever the AIbullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ScrollingWorld w = (ScrollingWorld)getWorld();
        if(getOneObjectAtOffset(0,0, AnimatedActor.class)!=null)
        {
            Greenfoot.playSound("Hit.mp3");
            w.removeObject(this);
            w.addLife(-5);
        } else if(getOneObjectAtOffset(0,0, canNotSeeThrough.class)!=null)
            w.removeObject(this);
        else move();
    }    

    /**
     * moves method
     */
    public void move()
    {
        if (this.left)
        {
            setLocation (getX() - 5, getY());
        } else
        {
            setLocation (getX() + 5, getY());
        }
    }
}
