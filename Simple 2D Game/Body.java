import greenfoot.*;

/**
 * Write a description of class Male here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Body extends AnimatedActor
{
    public Body(int maxCharSpeed, String name)
    {
        super (maxCharSpeed, name);
    }

    /**
     * Act - do whatever the Male wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (CountDown.canPlay)
        {
            hittingObjects();
            checkKeys();
        }
    } 

    /**
     * Overides the AnimatedActor class' checkKeys()
     */
    public void checkKeys()
    {
        super.checkKeys();
        if(Greenfoot.isKeyDown("w"))
        {
            if(Greenfoot.isKeyDown("a")) animate(9,15,4);
            else if(Greenfoot.isKeyDown("d")) animate(27,33,4);
            else animate(0,7,4);
        } else if(Greenfoot.isKeyDown("s"))
        {
            if(Greenfoot.isKeyDown("a")) animate(9,15,4);
            else if(Greenfoot.isKeyDown("d")) animate(27,33,4);
            else animate(18,25,4);
        } else if(Greenfoot.isKeyDown("a"))
        {
            animate(9,15,4);
        } else if(Greenfoot.isKeyDown("d"))
        {
            animate(27,33,4);
        }

        if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("a"))
        {
            setImage ("MaleHero17.png");
        }else if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s"))
        {
            setImage ("MaleHero17.png");
        }

        if(!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("a"))
        {
            setImage("MaleHero17.png");
        }
        return;
    }
}
