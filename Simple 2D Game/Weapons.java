import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Weapons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapons extends Animation
{
    private int speed = 0;//how fast it will travel
    private int range = 0;//how far it will reach
    private int damage;
    private int stuntCounter;
    private int timer = 0;

    public Weapons(String name, int speed, int range, int damage, int stuntCounter)
    {
        this.speed = speed;
        this.range = range;
        this.damage += damage + ModeAndValue.damage;
        this.stuntCounter = stuntCounter;
        super.name = name;
    }

    /**
     * returns range
     */
    public int getRange()
    {
        return range;
    }

    /**
     * damages the AI
     */
    public void attack()
    {
        if (touch(canNotSeeThrough.class))
        {
            getWorld().removeObject(this);
        } else if (touch(canHurtCharacter.class))
        {
            ScrollingWorld w = (ScrollingWorld)getWorld();
            List <canHurtCharacter> list = getIntersectingObjects(canHurtCharacter.class);
            int size = list.size();
            for (int i = 0; i < size; i++)
            {
                list.get(i).minusHealth(damage);//damage the AI
                list.get(i).stunt(stuntCounter);//stunt the AI for 20frames
            }
            w.removeObject(this);//removes the weapon
            Greenfoot.playSound("Hit.mp3");
        } else {
            switch (getWorld().getObjects(AnimatedActor.class).get(1).facing)//check for where Head is facing
            {
                case 1: //left
                if (range > 0)
                {
                    setLocation (getX() + speed, getY());
                    range--;
                }
                else if (range <= 0)
                {
                    getWorld().removeObject(this);
                }
                break;

                case 2: //right
                if (range > 0)
                {
                    setLocation (getX() - speed, getY());
                    range--;
                }
                else if (range <= 0)
                {
                    getWorld().removeObject(this);
                }
                break;

                case 3: //down
                if (range > 0)
                {
                    setLocation (getX(), getY() + speed);
                    range--;
                }
                else if (range <= 0)
                {
                    getWorld().removeObject(this);
                }
                break;

                case 4: //up
                if (range > 0)
                {
                    setLocation (getX(), getY() - speed);
                    range--;
                }
                else if (range <= 0)
                {
                    getWorld().removeObject(this);
                }
                break;

            }
        }
    }

    /**
     * This class contains two methods for pixel-perfect collision-detection
     * 
     * @author (Busch2207 (Moritz L.)) 
     * @version (09.11.2013)
     */

    /** This method is a pixel perfect collision detection. Return, if it intersects an actor of the given class */
    public boolean touch(Class clss)
    {
        List<Actor> list =
            getWorld().getObjects(clss),
        list2 = new ArrayList();
        for(Actor A : list)
            if(intersects(A)&&touch(A))
                return true;
        return false;
    }

    /** This method is a pixel perfect collision detection. Returns true, if the object touchs the given Actor */
    public boolean touch(Actor a_big)
    {
        Actor a_small;
        if(getImage().getWidth()*getImage().getHeight()>a_big.getImage().getHeight()*a_big.getImage().getWidth())
        {
            a_small=a_big;
            a_big=this;
        }
        else
            a_small=this;

        int i_hypot=(int)Math.hypot(a_small.getImage().getWidth(),a_small.getImage().getHeight());

        GreenfootImage i=new GreenfootImage(i_hypot,i_hypot);
        i.drawImage(a_small.getImage(),i_hypot/2-a_small.getImage().getWidth()/2,i_hypot/2-a_small.getImage().getHeight()/2);
        i.rotate(a_small.getRotation());
        int w=i_hypot;

        GreenfootImage Ai = a_big.getImage(),
        i2=new GreenfootImage(i_hypot=(int)Math.hypot(Ai.getWidth(),Ai.getHeight()),i_hypot);
        i2.drawImage(Ai,i2.getWidth()/2-Ai.getWidth()/2,i2.getHeight()/2-Ai.getHeight()/2);
        i2.rotate(a_big.getRotation());
        Ai=i2;

        int
        x_Offset=a_big.getX()-a_small.getX()-(Ai.getWidth()/2-w/2),
        y_Offset=a_big.getY()-a_small.getY()-(Ai.getHeight()/2-w/2);

        boolean b = true;
        for(int yi =Math.max(0,y_Offset); yi<w && yi<i_hypot+y_Offset && b; yi++)
            for(int xi =Math.max(0,x_Offset); xi<w && xi<i_hypot+x_Offset && b; xi++)
                if(Ai.getColorAt(xi-x_Offset,yi-y_Offset).getAlpha()>0 && i.getColorAt(xi,yi).getAlpha()>0)
                    b=false;
        return !b;
    }
}
