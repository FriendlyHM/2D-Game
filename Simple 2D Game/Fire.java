import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Actor
{
    private int duration = 200;
    private int speed = 5;
    GreenfootImage i = getImage();
    /**
     * Act - do whatever the Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {  
        if(CountDown.canPlay)
        {
            slowDownCharacter();
            chasePlayer();
            rotate();

            duration = duration + 10;
            if (duration > 1500)
            {
                getWorld().getObjects(AnimatedActor.class).get(0).changeSpeed(3);
                getWorld().removeObject(this);
            }return;
        }
    }    
    
    /**
     * spins
     */
    public void rotate()
    {
        GreenfootImage image = getImage();
        image.rotate (duration);
        setImage(image);
    }

    public void slowDownCharacter()
    {
        Actor actor = getOneObjectAtOffset(0,0,Body.class);
        if (actor !=null)
        {
            getWorld().getObjects(AnimatedActor.class).get(0).changeSpeed(1);
        }
    }
    
    /**
     * chases the player when in range
     */
    private void chasePlayer()
    {
        if (getWorld().getObjects(AnimatedActor.class).isEmpty()) return;//returns everything under AnimatedActor class

        Actor actor = (Actor)getWorld().getObjects(AnimatedActor.class).get(0);//returns the character's body

        int distanceY = getY() - actor.getY();// calculates how far is the character from AI by X
        int distanceX = getX() - actor.getX();// calculates how far is the character from AI by Y

        //if either of the distance is greater than 0 then the AI will move
        if (distanceY > 0)
        {
            setLocation(getX(), getY() - speed);
            distanceY -= speed;
        } else if (distanceY < 0)
        {
            setLocation(getX(), getY() + speed);
            distanceY += speed;
        }

        if (distanceX > 0)
        {
            setLocation(getX() - speed, getY());
            distanceY -= speed;
        } else if (distanceX < 0)
        {
            setLocation(getX() + speed, getY());
            distanceY += speed;
        }
    }
}
