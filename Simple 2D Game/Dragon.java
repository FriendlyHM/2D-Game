import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends canHurtCharacter
{
    private int fireCounter;
    private int AICounter;
    public Dragon()
    {
        super ("Dragon", 1, 1, 300, 50, 40, 20, true);
    }

    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animation();
        hittingObjects();
        if (CountDown.canPlay)
        {
            fireWave();
            createAI();
            move();
            die();
        }
    }   

    public void animation()
    {
        switch(facing)
        {
            case 3: //left
            if(!seePlayer())
                animate(4,7,10);
            else 
                animate(4,7,10);
            break;

            case 4: //right
            if(!seePlayer())
                animate(8,11,10);
            else
                animate(8,11,10);
            break;

            case 1: //up
            if(!seePlayer())
                animate(12,15,10);
            else
                animate(12,15,10);
            break;

            case 2: //down
            if(!seePlayer())
                animate(0,3,10);
            else
                animate(0,3,10);
            break;
        }
    }

    /**
     * creates a fire circle that will slow down the character
     */
    public void fireWave()
    {
        ScrollingWorld world = (ScrollingWorld)getWorld();
        if(!getAttack())
        {
            if (fireCounter == 0)
            {
                world.addObject(new Fire(), getX()+world.getScrolledX(), getY()+world.getScrolledY());
                fireCounter = 250;
            } else fireCounter --;
        }
    }

    /**
     * creates a wave of AI
     */
    public void createAI()
    {
        ScrollingWorld world = (ScrollingWorld)getWorld();
        if(AICounter==0)
        {
            world.addObject(new Skeletons(),getX(),getY());
            world.addObject(new Orc(),getX(),getY());
            world.addObject(new Ghost(),getX(),getY());
            world.addObject(new Bat(),getX(),getY());
            AICounter = 1100;
        }else{
            AICounter--;
        }
    }
}
