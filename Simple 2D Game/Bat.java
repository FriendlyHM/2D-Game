import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bat extends canHurtCharacter implements AI
{
    GifImage gifImage = new GifImage("Bat.gif");//when bat facing right
    GifImage gifImageLeft = new GifImage("BatLeft.gif");//when bat facing left
    public Bat()
    {
        super("", 1, 1, 150, 20, 6, 5,true);
    }

    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
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
        switch(facing)
        {
            case 4: //right
            if(!seePlayer())
                setImage(gifImage.getCurrentImage());
            else setImage(gifImage.getCurrentImage());
            break;

            case 3: //left
            if(!seePlayer())
                setImage(gifImageLeft.getCurrentImage());
            else setImage(gifImageLeft.getCurrentImage());
            break;

            case 1: //up
            if(!seePlayer())
                setImage(gifImageLeft.getCurrentImage());
            else setImage(gifImageLeft.getCurrentImage());
            break;

            case 2: //down
            if(!seePlayer())
                setImage(gifImageLeft.getCurrentImage());
            else setImage(gifImageLeft.getCurrentImage());
            break;
        }
    }
}
