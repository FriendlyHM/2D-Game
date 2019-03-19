import greenfoot.*;
public class Orc extends canHurtCharacter implements AI
{
    private int animationSpeed = 6;
    public Orc()
    {
        super("Orc", 1, 0, 200, 30, 5, 10,false);//String name, int speed, int viewDistance, int attackDelayCounter, int health, int damage

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

    public void animation()
    {
        if (!getAttack())
        {
            switch(facing)
            {
                case 3: //left
                animate(33,40,animationSpeed);
                break;

                case 4: //right
                animate(51,58,animationSpeed);
                break;

                case 1: //up
                animate(25,32,animationSpeed);
                break;

                case 2: //down
                animate(43,50,animationSpeed);
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
                    animate(6,11,5);
                else setImage("Orc6.png");
                break;

                case 4: //right
                if(getAttackDelay() < 40)
                    animate(18,23,5);
                else setImage("Orc18.png");
                break;

                case 1: //up
                if(getAttackDelay() < 40)
                    animate(0,5,5);
                else setImage("Orc0.png");
                break;

                case 2: //down
                if(getAttackDelay() < 40)
                    animate(12,17,5); 
                else setImage("Orc12.png");
                break;
            }
        }
    }
}