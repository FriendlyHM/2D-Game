import greenfoot.*;

/**
 * Write a description of class Blade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Weapons
{
    public Ball()
    {
        super ("Ball",5, 40, 1, 15); //(name, speed, range, damage, stuntCounter)
        getImage().scale((getImage().getWidth()-5), (getImage().getHeight()-5));
        
    }

    /**
     * Act - do whatever the Blade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
        attack();
    }

    /**
     * animate for this attack
     */
    public void animate()
    {
        GreenfootImage i = getImage();
        if(getRange() > 30)
        {
            i.scale((i.getWidth()+1), (i.getHeight()+1));
        } else if (getRange() < 15){
            i.scale((i.getWidth()-1), (i.getHeight()-1));
        }
    }
}
