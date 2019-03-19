import greenfoot.*;

/**
 * Write a description of class testAi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skeletons extends canHurtCharacter implements AI
{
    public Skeletons()
    {
        //String name, int speed, int ChaseSpeed, int viewDistance, int attackDelayCounter, int health, int damage,flying type
        super("Skeleton", 1, 1, 150, 20, 3, 5,false);
    }

    /**
     * Act - do whatever the testAi wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        hittingObjects();
        if (CountDown.canPlay)
        {
            move();
            animation();
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
                    animate(41,49,8);
                else 
                    animate(41,49,6);
                break;

                case 4: //right
                if(!seePlayer())
                    animate(59,67,8);
                else
                    animate(59,67,6);
                break;

                case 1: //up
                if(!seePlayer())
                    animate(32,40,8);
                else
                    animate(32,40,6);
                break;

                case 2: //down
                if(!seePlayer())
                    animate(51,58,8);
                else
                    animate(51,58,6);
                break;
            }
        }else
        {
            if(getAttackDelay() == 0)
                Greenfoot.playSound("Stab.mp3");

            switch (facing)
            {
                case 3: //left
                if(getAttackDelay() < 40)
                {
                    animate(8,15,5);
                }
                else setImage("Skeleton8.png");
                break;

                case 4: //right
                if(getAttackDelay() < 40)
                {
                    animate(24,31,5);
                }
                else setImage("Skeleton24.png");
                break;

                case 1: //up
                if(getAttackDelay() < 40)
                {
                    animate(0,7,5);
                }
                else setImage("Skeleton0.png");
                break;

                case 2: //down
                if(getAttackDelay() < 40)
                {
                    animate(16,23,5); 
                }
                else setImage("Skeleton16.png");
                break;
            }
        }
    }
}
