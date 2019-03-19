import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AI3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends canHurtCharacter implements AI
{
    public Ghost()
    {
        super("", 1, 1, 200, 20, 6, 5,true);//String name, int speed, int viewDistance, int attackDelayCounter, int health, int damage
    }

    /**
     * Act - do whatever the AI3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (CountDown.canPlay)
        {
            move();
            animation();
            hittingObjects();
            die();
        }
    }    

    /**
     * animates this character base on its name
     * @facing: check which direction the character is moving toward
     * @getAttack(): traverses to super class attack variable to see if attack is enabled
     */
    public void animation()
    {
        if (!getAttack())
        {
            switch(facing)
            {
                case 3: //left
                if(!seePlayer())
                    setImage("Ghost0.png");
                else 
                    setImage("Ghost4.png");
                break;

                case 4: //right
                if(!seePlayer())
                    setImage("Ghost2.png");
                else
                    setImage("Ghost6.png");
                break;

                case 1: //up
                if(!seePlayer())
                    setImage("Ghost3.png");
                else
                    setImage("Ghost4.png");
                break;

                case 2: //down
                if(!seePlayer())
                    setImage("Ghost1.png");
                else
                    setImage("Ghost4.png");
                break;
            }
        }
    }
}
