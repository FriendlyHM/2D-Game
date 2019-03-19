import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shooter extends canHurtCharacter
{
    private boolean facingLeft = true;
    private int shootCounter;
    /**
     * Constructor
     * @mirrored: facing(true = left, false = right)
     */
    public Shooter(boolean mirrored)
    {
        //String name, int speed, int chaseSpeed, int viewDistance, int attackDelayCounter, int health, int damage,boolean flying
        super("", 0, 0, 150, 50, 2, 5, false);
        facingLeft = mirrored;
        if (!facingLeft)
        {
            getImage().mirrorHorizontally();
        }

    }

    /**
     * Act - do whatever the Shooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (CountDown.canPlay)
        {
            shootPlayer();
            touchPlayer();
            die();
        }
    } 

    public void shootPlayer()
    {
        ScrollingWorld world = (ScrollingWorld)getWorld();
        if (shootCounter == 0)
        {
            world.addObject(new AIbullet(facingLeft), getX()+world.getScrolledX(), getY()+world.getScrolledY());
            shootCounter = 150;
        } else shootCounter --;
    }
}
