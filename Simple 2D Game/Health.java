import greenfoot.*;

/**
 * Write a description of class Healt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    private int points = 0; //current life points
    private int count = 0; //time to next refresh
    
    /**
     * Act - do whatever the Healt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (count == 0)
        {
            int value = getX() - (((ScrollingWorld)getWorld()).getHealthX()-50); //find the position of the heart
            value = value / 5; //calculate its value
            ScrollingWorld world = (ScrollingWorld)getWorld();
            points = world.getLife();
            GreenfootImage heart = getImage();
            if(points >= value) // compare points to value
            {
                heart = new GreenfootImage ("heartFull.png");
            } else if (points >= (value - 5))
            {
                heart = new GreenfootImage ("heartHalf.png");
            } else {
                heart = new GreenfootImage ("heartEmpty.png");
            }
            setImage (heart); //display appropriate image
        }

        if (count == 10)
        {
            count = 0;
        }
        else {
            count++;
        }

        if (points <= 0)
        {
            //GameOver gameOver = new GameOver();
            //getWorld().addObject(gameOver, 400, 300);
            //Greenfoot.stop();
        }
    }    
}    
