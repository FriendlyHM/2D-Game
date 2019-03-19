import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
/**
 * Write a description of class AnimatedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedActor extends Animation
{
    public int facing = 3; //check where the player is facing (1 left, 2 right, 3 down, 4 up)
    private String direction = ""; // check direction of character when hitting an object

    private int maxCharSpeed = 0; //character's maximum speed
    private double charVSpeed = 0; //how fast character walks vertically
    private double charHSpeed = 0; //how fast character walks Horizontally
    private double accel =.3; //speed of acceleration
    private double decel =.3; //speed of deceleration

    private boolean hittingWall = false;
    private int attackDelay = 0;//give some delay to specific attack

    public AnimatedActor(int maxCharSpeed, String name)
    {
        this.maxCharSpeed += maxCharSpeed + ModeAndValue.maxSpeed;
        this.accel = (double)this.maxCharSpeed/10;
        this.decel = (double)this.maxCharSpeed/10;
        super.name = name;
    }

    /**
     * Act - do whatever the AnimatedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    /**
     * Moves character depend on which key is pressed
     * accel is how fast the character accelerates from 0 speed
     * decel is how fast the character deccelerates from current speed
     */
    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("w"))//w is pressed
        {
            charVSpeed += accel; //speed accelerates up
            if(charVSpeed > maxCharSpeed) charVSpeed = maxCharSpeed;//make sure that current speed is never going over max speed
            setLocation(getX(), getY() - (int)charVSpeed);//moves the character up
        }

        if(Greenfoot.isKeyDown("s"))//s is pressed
        {
            charVSpeed -= accel;//speed accelerates down
            if(charVSpeed < -maxCharSpeed) charVSpeed = -maxCharSpeed;//make sure that current speed is never going under max speed
            setLocation(getX(), getY() - (int)charVSpeed);//moves the character down
        }

        if(Greenfoot.isKeyDown("a"))//a is pressed
        {
            charHSpeed -= accel;//speed accelerates left
            if(charHSpeed < -maxCharSpeed) charHSpeed = -maxCharSpeed;//make sure that current speed is never going under negative maxspeed
            setLocation(getX() + (int)charHSpeed, getY());//moves the character left
        }

        if(Greenfoot.isKeyDown("d"))//a is pressed
        {
            charHSpeed += accel;//speed accelerates right
            if(charHSpeed > maxCharSpeed) charHSpeed = maxCharSpeed;//make sure that current speed is never going under maxspeed
            setLocation(getX() + (int)charHSpeed, getY());//moves the character right
        }
        decel();
        passStage();
    }

    /**
     * Increase character's speed
     * @increment: how much speed will the characer gain from this
     */
    public void speedIncrement(int increment)
    {
        maxCharSpeed += increment;
    }

    /**
     * Decelerates the character at some particular circumstances
     */
    public void decel()
    {
        //When neither of the corresponding moving keys are pressed the charater will delerate and stop
        if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s"))
        {
            if (charVSpeed > 0)
            {
                charVSpeed = charVSpeed - decel;
                setLocation (getX(), getY() - (int)charVSpeed);
            } else if (charVSpeed < 0)
            {
                charVSpeed = charVSpeed + decel;
                setLocation (getX(), getY() - (int)charVSpeed);
            }
        }
        if (!Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            if (charHSpeed>0)
            {
                charHSpeed = charHSpeed - decel;
                setLocation (getX() + (int)charHSpeed, getY());
            } else if (charHSpeed<0)
            {
                charHSpeed = charHSpeed + decel;
                setLocation (getX() +(int)charHSpeed, getY());
            }
        }

        // When both keys W&S or A&D are pressed the character will stop preventing the moving glitch
        if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("a"))
        {
            if (charHSpeed>0)//when the character is moving to the right it'll stop
            {
                charHSpeed = charHSpeed - decel;
            } else if (charHSpeed<0)//when the character is moving to the left it'll stop
            {
                charHSpeed = charHSpeed + decel;
            }
        }
        if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s"))
        {
            if (charVSpeed>0)//when the character is moving down it'll stop
            {
                charVSpeed = charVSpeed - decel;
            } else if (charVSpeed<0)//when the character is moving up it'll stop
            {
                charVSpeed = charVSpeed + decel;
            }
        }
    }

    /**
     * Character's attack method
     */
    public void attack()
    {
        if(attackDelay <= 0)
        {
            Weapons weapon = new Ball();
            ((ScrollingWorld)getWorld()).addObject(weapon, getX()+ ((ScrollingWorld)getWorld()).getScrolledX(), getY()+ ((ScrollingWorld)getWorld()).getScrolledY());//create a weapon
            attackDelay = 40;//refill the delay for next attack
        } else {
            attackDelay--;//decrease delay time to zero so the character can attack
        }
    }

    /**
     * returns amount of delay in each attack
     */
    public int getAttackDelay()
    {
        return attackDelay;
    }

    /**
     * Detects objects and AI in world and prevents the character from moving through
     */
    public void hittingObjects()
    {
        checkCollisionDirection();
        Actor actor = getOneIntersectingObject(Objects.class);
        if(touch(Objects.class) || touch(AI.class))//when the character collides with the objects,
        //it pushes the character back "maxCharSpeed" value.
        {
            if(direction.equals("east"))
                setLocation(getX()-maxCharSpeed, getY());
            else if(direction.equals("north"))
                setLocation(getX(), getY()+maxCharSpeed);
            else if(direction.equals("west"))
                setLocation(getX()+maxCharSpeed, getY());
            else if(direction.equals("south"))
                setLocation(getX(), getY()-maxCharSpeed);
        }
    }

    /**
     * Check to see which side the character collide with the object
     */
    public void checkCollisionDirection()
    {
        Actor rightCollide = getOneObjectAtOffset(10, 0, Objects.class);
        Actor rightCollide2 = getOneObjectAtOffset(4, 0, AI.class);

        Actor leftCollide = getOneObjectAtOffset(-10, 0, Objects.class);
        Actor leftCollide2 = getOneObjectAtOffset(-1, 0, AI.class);

        Actor bottomCollide = getOneObjectAtOffset(0, 21, Objects.class);
        Actor bottomCollide2 = getOneObjectAtOffset(0, 3, AI.class);

        Actor topCollide = getOneObjectAtOffset(0, -21, Objects.class);
        Actor topCollide2 = getOneObjectAtOffset(0, 3, AI.class);

        if (rightCollide !=null || rightCollide2!=null) direction = "east";
        else if (leftCollide !=null || leftCollide2!=null) direction = "west";
        else if (topCollide !=null || topCollide2 !=null) direction = "north";
        else if (bottomCollide !=null || bottomCollide2!=null) direction = "south";
        else direction = "";
    }

    /**
     * returns direction character is facing
     */
    public String getDirection()
    {
        return direction;
    }

    /**
     * checks to see when stage is passed
     */
    public void passStage()
    {
        ScrollingWorld w = (ScrollingWorld)getWorld();
        Actor touchDoor = getOneObjectAtOffset(0, 0, Doors.class);

        if (getWorld().getObjects(Doors.class).get(0).checkDoor() && touchDoor!=null)
        {
            if (w.getStage() == 1)//if current stage is one, jump to stage 2
            {
                Greenfoot.setWorld(new World2());
            }
            if (w.getStage() == 2)
            {
                Greenfoot.setWorld(new World3());
            }
            if (w.getStage() == 3)
            {
                Greenfoot.setWorld(new World4());
            }
            if (w.getStage() == 4)
            {
                Greenfoot.setWorld(new Boss());
            }
            if (w.getStage() == 5)
            {
                Greenfoot.setWorld(new End());
                Greenfoot.playSound("Win.wav");
            }
        }
    }

    /**
     * changes speed of character
     * @value: new value for max speed
     */
    public void changeSpeed(int value)
    {
        maxCharSpeed = value;
    }
    
    public void plusSpeed(int value)
    {
        this.maxCharSpeed += value;
        this.accel = (double)this.maxCharSpeed/10;
        this.decel = (double)this.maxCharSpeed/10;
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