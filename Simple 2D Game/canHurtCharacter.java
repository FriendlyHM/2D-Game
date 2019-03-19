import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
/**
 * Write a description of class AI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class canHurtCharacter extends Animation
{
    private boolean flying = false; //check if AI is  a flying type
    private int speed = 1; //movement speed
    private int chaseSpeed; //speed when AI is chasing player
    private boolean seePlayer = false; //check if player is in the area 
    private int viewDistance = 150; //view distance of the AI (default = 150)
    public int facing = 0; //1 up, 2 down, 3 left, 4 right (for animation purposes)
    private String direction = ""; //which direction the character is to an object
    private int distance = 3;//distance of the character to the object
    private int health = 3;//AI's health
    private int stuntCounter;//stunt character when it's attacked

    private int attackDelay = 0; //delay attack when AI attacks player
    private int attackDelayCounter = 10;
    private int damage = 5;//damge deal to the mainCharacter
    private boolean attack = false; //attack or not
    private int touchCounter = 50;

    private int turningCounter = Greenfoot.getRandomNumber(100)+50;//counter to change direction when moving randomly
    private int randomDirection = Greenfoot.getRandomNumber(3)+1;//return random directions

    /**
     * Constructor for canHurtCharacter class
     * 
     * @name: name of the the character, leave "" if do not know
     * @anySpeed: regular speed of the AI
     * @chaseSpeed: increment of speed when the AI is chasing the character
     * @viewDistance: the AI's view range
     * @attackDelayCounter: how long the AI can re-attack and damage the player
     * @health: amount of health
     * @damage: how much damage the AI deals (5 is 1/2 heart)
     * @flying: Flying type or ground type
     */
    public canHurtCharacter(String name, int anySpeed, int chaseSpeed, int viewDistance, int attackDelayCounter, int health, int damage, boolean flying)
    {
        this.flying = flying;
        this.chaseSpeed = chaseSpeed;
        speed = anySpeed;
        this.viewDistance = viewDistance;
        this.attackDelay = attackDelay;
        super.name = name;
        this.attackDelayCounter = attackDelayCounter;
        this.damage = damage;

        //If hard mode is enable all AI will have +15 health
        if(!ModeAndValue.hardMode)
            this.health = health;
        else this.health = health+15;
    }

    /**
     * moves character base on situations
     * moves randomly when not seeing mainCharacter
     * moves toward the mainCharater when in range
     * 
     * @stuntCounter: stunts the AI when it is attacked
     */
    public void move() 
    {
        if (stuntCounter <= 0)
        {
            if (!attack)
            {
                if(lookForPlayer()) chasePlayer();
                else moveRandomly();
            }
            attackPlayer();
        } else {
            stuntCounter--;
        }
    } 

    /**
     * chases the player when in range
     */
    private void chasePlayer()
    {
        if (getWorld().getObjects(AnimatedActor.class).isEmpty()) return;//returns everything under AnimatedActor class

        Actor actor = (Actor)getWorld().getObjects(AnimatedActor.class).get(0);//returns the character as actor

        int distanceY = getY() - actor.getY();// calculates how far is the character from AI by X
        int distanceX = getX() - actor.getX();// calculates how far is the character from AI by Y

        //if either of the distance is greater than 0 then the AI will move
        if (distanceY > 0)
        {
            setLocation(getX(), getY() - (speed+chaseSpeed));
            distanceY -= speed;
            facing = 1;
        } else if (distanceY < 0)
        {
            setLocation(getX(), getY() + (speed+chaseSpeed));
            distanceY += speed;
            facing = 2;
        }

        if (distanceX > 0)
        {
            setLocation(getX() - (speed+chaseSpeed), getY());
            distanceY -= speed;
            facing = 3;
        } else if (distanceX < 0)
        {
            setLocation(getX() + (speed+chaseSpeed), getY());
            distanceY += speed;
            facing = 4;
        }
    }

    /**
     * return if the mainCharacter is in range
     */
    private boolean lookForPlayer()
    {
        Actor actor = (Actor)getWorld().getObjects(AnimatedActor.class).get(0);

        int distanceY = getY() - actor.getY();
        int distanceX = getX() - actor.getX();

        if ( Math.abs(distanceX) < viewDistance && Math.abs(distanceY) < viewDistance)  seePlayer = true;
        else seePlayer = false; //return true if viewDistance is greater than AI's distance from character

        return seePlayer;
    }

    /**
     * move randomly when the mainCharacter is not in range
     */
    public void moveRandomly()
    {
        if (turningCounter <= 0)
        {
            randomDirection = Greenfoot.getRandomNumber(4)+1;
            turningCounter = Greenfoot.getRandomNumber(100)+50;
        } else 
        {
            switch(randomDirection)
            {
                case 1:
                setLocation (getX(), getY() - speed);
                facing = 1;
                break;

                case 2:
                setLocation (getX(), getY() + speed);
                facing = 2;
                break;

                case 3:
                setLocation (getX() - speed, getY());
                facing = 3;
                break;

                case 4:
                setLocation (getX() + speed, getY());
                facing = 4;
                break;
            }
            turningCounter--;
        }
    }

    /**
     * set the AI's current viewDistance to other variables
     */
    public void setViewDistance (int newViewDistance)
    {
        viewDistance = newViewDistance;
    }

    /**
     * push back the character when it touches an object
     */
    public void hittingObjects()
    {
        checkDirection();
        if (!flying) //if not a flying type it will be blocked by ground objects
        {
            if(touch(Objects.class))
            {
                if(direction.equals("east"))
                {
                    setLocation(getX()-distance, getY());
                    randomDirection = 3; //switch random direction to left
                }
                else if(direction.equals("north"))
                {
                    setLocation(getX(), getY()-distance);
                    randomDirection = 1; //switch random direction to down
                }
                else if(direction.equals("west"))
                {
                    setLocation(getX()+distance, getY());
                    randomDirection = 4; //switch random direction to right
                }
                else if(direction.equals("south"))
                {
                    setLocation(getX(), getY()+distance);
                    randomDirection = 2; //switch random direction to up
                }
            }
        } else { //if it is a flying type it will only be block by boundaries
            if(touch(Bound.class))
            {
                if(direction.equals("east"))
                {
                    setLocation(getX()-distance, getY());
                    randomDirection = 3; //switch random direction to left
                }
                else if(direction.equals("north"))
                {
                    setLocation(getX(), getY()-distance);
                    randomDirection = 1; //switch random direction to down
                }
                else if(direction.equals("west"))
                {
                    setLocation(getX()+distance, getY());
                    randomDirection = 4; //switch random direction to right
                }
                else if(direction.equals("south"))
                {
                    setLocation(getX(), getY()+distance);
                    randomDirection = 2; //switch random direction to up
                }
            }
        }
    }

    /**
     * check which direction is the AI touching the object
     * this will be implemented in the hittingObject() method
     */
    public void checkDirection()
    {
        Actor rightCollide = getOneObjectAtOffset(25, 0, Objects.class);
        Actor leftCollide = getOneObjectAtOffset(-25, 0, Objects.class);
        Actor bottomCollide = getOneObjectAtOffset(0, -25, Objects.class);
        Actor topCollide = getOneObjectAtOffset(0, 25, Objects.class);

        if (rightCollide !=null) direction = "east";
        else if (leftCollide !=null) direction = "west";
        else if (topCollide !=null) direction = "north";
        else if (bottomCollide !=null) direction = "south";
    }

    /**
     * starts attacking the mainCharacter when they make contact
     */
    public void attackPlayer()
    {
        ScrollingWorld world = (ScrollingWorld)getWorld();
        Actor actor = getOneIntersectingObject(AnimatedActor.class);//return if touching mainCharacter
        if (touch(Body.class))
        {
            attack = true;
            if (attackDelay == 0)
            {
                world.addLife(-damage);
                attackDelay = attackDelayCounter;
            } else attackDelay --;
        } else {
            attack = false;
            attackDelay = attackDelayCounter;
        }
    }   

    /**
     * returns if AI is touching player and damage the player
     */
    public void touchPlayer()
    {
        ScrollingWorld world = (ScrollingWorld)getWorld();
        Actor actor = getOneIntersectingObject(AnimatedActor.class);//return if touching mainCharacter
        if (actor !=null)//damage player if touched
        {
            if (touchCounter == 0) 
            {
                world.addLife(-5);
                touchCounter = 100;
            } else touchCounter --;
        } else {
            touchCounter = 10;
        }
    }

    /**
     * returns attacking (attacking or not)
     */
    public boolean getAttack()
    {
        return attack;
    }

    /**
     * returns attackDelay (how long before the AI can attack again)
     */
    public int getAttackDelay()
    {
        return attackDelay;
    }

    /**
     * returns if seeing the player
     */
    public boolean seePlayer()
    {
        return seePlayer;
    }

    /**
     * reduces health when getting acctacked by the player
     * @amount is the amount of damage given to the character
     */
    public void minusHealth(int amount)
    {
        health = health - amount;
    }

    /**
     * stunts the AI when it gets hit bit weapons.class
     * @counter: how long it will get stunt
     */
    public void stunt(int counter)
    {
        stuntCounter = counter;
    }

    /**
     * removes this from the world when health is = 0
     * @chancesOfHealth: chances that the death of AI will drop a health pack
     */
    public void die()
    {
        ScrollingWorld w = (ScrollingWorld)getWorld();

        int chancesOfItems = Greenfoot.getRandomNumber(7)+1; //generates random number from 1 to 5
        if (health <= 0)
        {
            if (chancesOfItems == 1) //chance of dropping health
            {
                Items heart = new heart();
                w.addObject(heart, getX()+w.getScrolledX(),getY()+w.getScrolledY());
                w.removeObject(this);
            } else if (chancesOfItems == 2) //chance of dropping speed-increased item
            {
                Speed s = new Speed();
                w.addObject(s, getX()+w.getScrolledX(),getY()+w.getScrolledY());
                w.removeObject(this);
            } else if (chancesOfItems == 3) //chance of dropping damage-increased item
            {
                Damage d = new Damage();
                w.addObject(d, getX()+w.getScrolledX(),getY()+w.getScrolledY());
                w.removeObject(this);
            } else {
                w.removeObject(this);
            }
        } else if(getX()+w.getScrolledX()<0)//false safe when the AI glitches out of the world, it will die
        {
            w.removeObject(this);
        } else if(getX()+w.getScrolledX()>w.getScrollingWidth())
        {
            w.removeObject(this);
        } else if(getY()+w.getScrolledY()<0)
        {
            w.removeObject(this);
        } else if (getY()+w.getScrolledY()>w.getScrollingHeight())
        {
            w.removeObject(this);
        }
    }

    /**
     * returns health
     */
    public int getHealth()
    {
        return health;
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
