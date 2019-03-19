import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Head here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Head extends AnimatedActor
{
    private int headY = 20;//how far the head is from the body (Y coordinate)
    public Head(int maxCharSpeed, String name)
    {
        super (maxCharSpeed, name);
    }

    public void act() 
    {
        if (CountDown.canPlay)
        {
            checkKeys();
        }
        checkBody();
    } 

    /**
     * Overides the AnimatedActor class' checkKeys()
     */
    public void checkKeys()
    {
        super.checkKeys();//moving keys
        if(getAttackDelay() <= 0)//returns delay
        {
            if(Greenfoot.isKeyDown("up"))
            {
                super.facing = 4;//returns which direction is the character is facing
                super.attack();//creates weapons
                Greenfoot.playSound("ShootWater.mp3");//plays sound
            } else if(Greenfoot.isKeyDown("down"))
            {
                super.facing = 3;
                super.attack();
                Greenfoot.playSound("ShootWater.mp3");
            } else if(Greenfoot.isKeyDown("left"))
            {
                super.facing = 2;
                super.attack();
                Greenfoot.playSound("ShootWater.mp3");
            } else if(Greenfoot.isKeyDown("right"))
            {
                super.facing = 1;
                super.attack();
                Greenfoot.playSound("ShootWater.mp3");
            }
        }else {
            super.attack();
        }

        if(Greenfoot.isKeyDown("up"))
        {
            setImage("Head4.png");
        } else if(Greenfoot.isKeyDown("down"))
        {
            setImage("Head0.png");
        } else if(Greenfoot.isKeyDown("left"))
        {
            setImage("Head3.png");
        } else if(Greenfoot.isKeyDown("right"))
        {
            setImage("Head2.png");
        } else {
            setImage("Head0.png");
        }
    }

    /**
     * for the head to never leave the body and wander somewhere else on the map
     */
    public void checkBody()
    {
        Actor character = getWorld().getObjects(AnimatedActor.class).get(0); //return the character's body
        Actor actor = getOneIntersectingObject(Body.class);
        if (actor!=null)
        {
            setLocation (character.getX(), character.getY()-headY);
        } else {
            setLocation (character.getX(), character.getY()+headY);
        }
    }
}

