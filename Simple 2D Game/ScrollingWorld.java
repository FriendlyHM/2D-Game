import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

/**
 * SWorld is a super-class for a scrolling world (horizontal, vertical, or both).<br><br>
 * Author: danpost<br>Version: October 28, 2013 (v2.0)<br><br>
 * To implement this super-class:
 * <l><li>(1) create a sub-class of this class</li>
 * <li>(2) use a <i>super(....)</i> call to one of the constructors in this class</li>
 * <li>(3) create the main actor (one that always stays in view) and call the <i>setMainActor</i> method</li>
 * <li>(4) (optional) set a scrolling background image using a call to <i>setScrollingBackground</i> or <i>fillScrollingBackground</i></li></l><br>
 * NOTE: the order of steps above is very important<br><br>
 * There are two methods to add other objects into the world:
 * <l><li>the standard method <i>addObject(Actor, int, int)</i> can be used to add a scrollable actor into the world</li>
 * <li>a secondary method <i>addObject(Actor, int, int, boolean)</i> which is equivalent to the standard method, except
 * that the boolean will indicate the scrollable state of the object.  When adding scrolling objects into the world,
 * use scrolling coordinates; when adding non-scrolling objects, use world coordinates.</li></l>
 *
 * SPECIAL NOTE: if you decide to override the 'act' method of this class with an 'act' method in your sub-world, you will
 * need to follow the format below to run the scrolling of the scenario:
 * 
 * <pre>        public void act()
 *        {
 *            // possibly some code here      
 *            super.act();
 *            // possibly some more code here
 *        }<pre>
 */
public class ScrollingWorld extends World
{
    /**
     * Huan's methods
     */
    private int healthX = 670; //first hearth health bar X placement
    private int maxLife = 40;
    private int minLife = 0;
    private int life = 40;
    private int stageNum;
    
    /**
     * adds life points to character's health
     */
    public void addLife(int lifePoints)
    {
        life = life + lifePoints;
        minLife();
        maxLife();
        ModeAndValue.health = life;
    }
    
    /**
     * set stage number when construct a stage
     * @stage: set stage number
     */
    public void setStage(int stage)
    {
        stageNum = stage;
    }
    
    /**
     * returns stage number
     */
    public int getStage()
    {
        return stageNum;
    }
    
    /**
     * returns character's current health
     */
    public int getLife()
    {
        return life;
    }

    /**
     * resets character's health to max
     * 10 points for 1 health
     */
    public void resetLife()
    {
        removeObjects(getObjects(Health.class));//set health back to zero
        Health health0 = new Health();
        addObject (health0,healthX,35,false);
        Health health1 = new Health();
        addObject (health1,healthX+50,35,false);
        Health health2 = new Health();
        addObject (health2,healthX+100,35,false);
        Health health3 = new Health();
        addObject (health3,healthX+150,35,false);
        maxLife = 40;
        life = ModeAndValue.health;
    }

    /**
     * makes sure current health does not go over/under intended max/min health
     */
    public void maxLife()
    {
        if(life >= maxLife)
            life = maxLife;        
    }
    public void minLife()
    {
        if(life <=minLife)
            life = minLife;
    }

    /**
     * returns where 1st health X position
     */
    public int getHealthX()
    {
        return healthX;
    }
    
    public void createBoundaries(){}
    
    /**
     * generates random AI across the map
     * change the number in the first for loop for each AI type to change the amount
     */
    public void createAI(int numAI1, int numAI2, int numAI3, int bats)
    {
        ArrayList <canHurtCharacter> ai1 = new ArrayList <canHurtCharacter>(); 
        for(int i = 0; i < numAI1; i++) //makes (numai1) number of AI1
        {
            ai1.add(new Skeletons());
        }
        for(int i = 0; i < ai1.size(); i++)
        {
            addObject(ai1.get(i),Greenfoot.getRandomNumber(900)+80,Greenfoot.getRandomNumber(700)+80);
        }
        
        ArrayList <canHurtCharacter> ai2 = new ArrayList <canHurtCharacter>(); 
        for(int i = 0; i < numAI2; i++) //makes (numai2) number of AI2
        {
            ai2.add(new Orc());
        }
        for(int i = 0; i < ai2.size(); i++)
        {
            addObject(ai2.get(i),Greenfoot.getRandomNumber(900)+80,Greenfoot.getRandomNumber(700)+80);
        }
        
        ArrayList <canHurtCharacter> ai3 = new ArrayList <canHurtCharacter>();
        for(int i = 0; i < numAI3; i++) //makes (numai2) number of AI2
        {
            ai3.add(new Ghost());
        }
        for(int i = 0; i < ai3.size(); i++)
        {
            addObject(ai3.get(i),Greenfoot.getRandomNumber(900)+80,Greenfoot.getRandomNumber(700)+80);
        }
        
        ArrayList <canHurtCharacter> bat = new ArrayList <canHurtCharacter>();
        for(int i = 0; i < bats; i++) //makes (bats) number of bat
        {
            bat.add(new Bat());
        }
        for(int i = 0; i < bat.size(); i++)
        {
            addObject(bat.get(i),Greenfoot.getRandomNumber(900)+80,Greenfoot.getRandomNumber(700)+80);
        }
    }
    
    /**
     * creates counters of speed, damage, difficulty
     */
    public void createCounters()
    {
        DisplayMode dm = new DisplayMode();
        addObject (dm, 120, 40, false);
        DisplayDamage dd = new DisplayDamage();
        addObject(dd, 120, 100, false);
        DisplaySpeed ds = new DisplaySpeed();
        addObject(ds, 120, 70, false);
        Sound sound = new Sound();
        addObject(sound,840,625, false);
    }
    
    /**
     * 
     */
    public void die()
    {
        if (life == 0)
        {
            Greenfoot.setWorld (new Dead());
            Greenfoot.playSound("Lose.wav");
        }
    }
    
    
    /**
     * ScrollingWorld template made by danpost http://www.greenfoot.org/scenarios/6719
     */
    private int scrollingWidth, scrollingHeight; // limits for main actor within universal coordinates
    private int actorMinX, actorMaxX, actorMinY, actorMaxY; // limits for main actor within world coordinates
    private int scrolledX, scrolledY; // initial scrolled amount
    private int scrollType; // indicates scrolling directions (0=none, 1=horizontal, 2=vertical, 3=both)
    Actor mainActor = null; // the actor that always stays visible
    private List<Actor>genActors=new ArrayList(); // lists all generic scrolling actor objects
    private GreenfootImage background = null;

    /**
     * The constructor for a universal scroller.
     * Creates an unbounded world and sets the size of the scrollable area.
     *
     * @param wide the window width
     * @param high the window height
     * @param cellSize the size of each cell
     * @param scrollWide the scrollable width (minimum value is window width)
     * @param scrollHigh the scrollable height (minimum value is window height)
     */
    public ScrollingWorld(int wide, int high, int cellSize, int scrollWide, int scrollHigh)
    {
        super(cellSize==1?wide:(wide/2)*2+1, cellSize==1?high:(high/2)*2+1, cellSize, false);
        scrollType=(scrollWide>wide?1:0)+(scrollHigh>high?2:0);
        scrollingWidth=scrollType%2==1?scrollWide:wide;
        scrollingHeight=scrollType/2==1?scrollHigh:high;
    }

    /**
     * The constructor for a horizontal (side) scroller.
     * Calls the universal scroller constructor with scrollHigh equal to the window height parameter.
     *
     * @param wide the window width
     * @param high the window height
     * @param cellSize the size of each cell
     * @param scrollWide the scrollable width (minimum value is window width)
     */
    public ScrollingWorld(int wide, int high, int cellSize, int scrollWide)
    {
        this(wide, high, cellSize, scrollWide, high);
    }

    /**
     * Adds the main actor into the world at the center of the window.<br><br>
     * NOTE: this method must be called prior to calling <i>setScrollingBackground</i>.
     * Sets the range in movement within the window for the actor, and determines the range of horizontal
     * and vertical scrollable movement allowable for the actor.<br><br>
     *
     * @param main the actor that is to always stay in view
     * @param xLoc the x-coordinate of the scrolling area to place the main actor
     * @param yLoc the y-coordinate of the scrolling area to place the main actor
     * @param xRange the horizontal range of movement within the window
     * @param yRange the vertical range of movement within the window
     */
    public void addMainActor(Actor main, int xLoc, int yLoc, int xRange, int yRange)
    {
        if (main==null)
        {
            System.out.println("A main actor MUST be supplied.");
            System.out.println("");
            return;
        }
        super.addObject(main, xLoc-scrolledX, yLoc-scrolledY);
        mainActor = main;
        xRange=(int)Math.min(xRange, getWidth());
        yRange=(int)Math.min(yRange, getHeight());
        actorMinX=getWidth()/2-xRange/2;
        actorMaxX=getWidth()/2+xRange/2;
        actorMinY=getHeight()/2-yRange/2;
        actorMaxY=getHeight()/2+yRange/2;
        act();
    }

    /**
     * Adds a scrolling background to the world; see method description for notes on unwanted results.<br><br>
     * NOTE: for this method to work, the main actor must have previously been set with <i>setMainActor</i>.  The image will then
     * be scaled to the appropriate size and is centered in the scrollable world.
     *
     * @param scrollingBackground the image to be used for the scrolling background of the world
     */
    public void setScrollingBackground(GreenfootImage scrollingBackground)    
    {
        if(mainActor==null)
        {
            System.out.println("'setMainActor' MUST be called prior to calling 'setScrollingBackground'.");
            System.out.println("");
            return;
        }
        background = new GreenfootImage(scrollingBackground);
        background.scale(scrollingWidth*getCellSize(), scrollingHeight*getCellSize());
        scrollBackground();
    }

    /**
     * Fills the background of the scrolling area with the <i>fillImage</i>.<br><br>
     * NOTE: for this method to work, the main actor must have previously been set with <i>setMainActor</i>.  The image will then
     * be used to fill the background of the scrolling area and is centered in the scrollable world.
     * 
     * @param fillImage the image to fill the background of the scrolling area with
     */
    public void fillScrollingBackground(GreenfootImage fillImage)
    {
        if(mainActor==null)
        {
            System.out.println("'setMainActor' MUST be called prior to calling 'fillScrollingBackground'.");
            System.out.println("");
            return;
        }
        if (fillImage.getWidth()<getWidth() && fillImage.getHeight()<getHeight())
        {
            setBackground(new GreenfootImage(fillImage));
            fillImage = getBackground();
        }
        World world = new World(scrollingWidth*getCellSize(), scrollingHeight*getCellSize(), 1){};
        world.setBackground(fillImage);
        background = new GreenfootImage(world.getBackground());
        scrollBackground();
    }

    /**
     * Adds an object into the world, listing it in the Actor array if it is a scrollable object; 
     * the coordinates are of the scrolling area for scrolling objects and of the world if not.
     *
     * @param obj the object to add to the world
     * @param xLoc the x-coordinate to place the object
     * @param yLoc the y-coordinate to place the object
     * @param scroller a flag indicating whether this object is of scrollable type or not
     */
    public void addObject(Actor obj, int xLoc, int yLoc, boolean scroller)
    {
        if (!scroller)
        {
            super.addObject(obj, xLoc, yLoc);
            if (obj == mainActor) act();
            return;
        }
        super.addObject(obj, xLoc-scrolledX, yLoc-scrolledY);
        genActors.add(obj);
    }

    /**
     * Adds a scrollable object into the world, listing them in the Actor array.
     *
     * @param obj the scrollable object to add to the world
     * @param xLoc the x-coordinate of the scrolling area to place the object
     * @param yLoc the y-coordinate of the scrolling area to place the object
     */
    public void addObject(Actor obj, int xLoc, int yLoc)
    {
        addObject(obj, xLoc, yLoc, true);
    }

    /**
     * Removes an object from the world, re-defining fields as neccessary
     *
     * @param obj the object to be removed from the world
     */
    public void removeObject(Actor obj)
    {
        if(obj==null)return;
        if(obj.equals(mainActor))mainActor=null;
        else genActors.remove(obj);
        super.removeObject(obj);
    }

    /**
     * Removes a collection of objects from the world, calling <i>removeObject(Actor)</i> for each one in the list
     *
     * @param objs the collection or list of objects to be removed from the world
     */
    public void removeObjects(List<Actor>objs)
    {
        for(Actor obj:objs)removeObject(obj);
    }

    /**
     * Runs the scrolling.
     */
    public void act()
    {
        scrollObjects();
        scrollBackground();
        setPaintOrder (Buttons.class, Display.class, CountDown.class, Health.class, Items.class, Dragon.class, Fire.class, Weapons.class, AIbullet.class, AnimatedActor.class, canHurtCharacter.class, Objects.class);//order of painting
    }

    /**
     * Scrolls the background image.
     */
    private void scrollBackground()
    {
        if (background==null) return;
        int c = getCellSize();
        getBackground().drawImage(background, -scrolledX*c, -scrolledY*c);
    }

    /**
     * Scrolls all scrollable object.  Determines how far outside boundary limits the main actor is, and moves all neccessary
     * objects in the same direction, moving the main actor back within boundary limits.  A background can be
     * made up of scrollable actor object(s) to produce a scrolling background; however, determining intersectors with object
     * will have to include the background object as being one or more of them when using <i>null</i> for the class of intersector.
     */
    private void scrollObjects()
    {
        if (mainActor==null) return;
        // determine how far the main actor is outside its standard window limits
        int dx=0, dy=0;
        if(mainActor.getX()<actorMinX) dx=actorMinX-mainActor.getX();
        if(mainActor.getX()>actorMaxX) dx=actorMaxX-mainActor.getX();
        if(mainActor.getY()<actorMinY) dy=actorMinY-mainActor.getY();
        if(mainActor.getY()>actorMaxY) dy=actorMaxY-mainActor.getY();
        if(dx==0 && dy==0) return; // not outside window limits
        // ** outside standard window limits **
        int dxSum = dx, dySum = dy; // hold changes in scroll amount
        scrolledX-=dx; scrolledY-=dy;// track scroll amount
        // move main actor back within standard window limits
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        // determine how far the background is inside the world limits
        dx=0; dy=0;
        if(scrolledX > scrollingWidth-getWidth()) dx=scrolledX-(scrollingWidth-getWidth());
        if(scrolledX < 0) dx=scrolledX;
        if(scrolledY > scrollingHeight-getHeight()) dy=scrolledY-(scrollingHeight-getHeight());
        if(scrolledY < 0) dy=scrolledY;
        // ** background does not completely cover world limits
        dxSum+=dx; dySum+=dy; // keep running sum of changes in scroll amount
        scrolledX-=dx; scrolledY-=dy; // adjust scroll amount
        // move all objects so background covers the world
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        for(Object obj : genActors)
        {
            Actor actor=(Actor)obj;
            actor.setLocation(actor.getX()+dxSum, actor.getY()+dySum);
        }
        // determine how far main actor is outside universal limits
        dx=0; dy=0;
        if(mainActor.getX() < 0) dx=0-mainActor.getX();
        if(mainActor.getX() > getWidth()-1) dx=(getWidth()-1)-mainActor.getX();
        if(mainActor.getY() < 0) dy=0-mainActor.getY();
        if(mainActor.getY() > getHeight()-1) dy=(getHeight()-1)-mainActor.getY();
        if(dx==0 && dy==0) return;
        // ** outside universal limits
        // move main actor back within world limits
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
    }

    /**
     * Returns the horizonal offset from the top-left corner of the scrolling world of the 'x' value given,
     * where 'x' is the horizontal offset from the top-left corner of the view window.
     *
     * @param worldX a horizontal offset from the top-left corner of the visible world
     * @return the absolute horizontal offset from the top-left corner of the scrolling world
     */
    public int getUnivX(int worldX)
    {
        return (scrollingWidth-getWidth())/2+worldX+scrolledX;
    }

    /**
     * Returns the vertical offset from the top-left corner of the scrolling world of the 'y' value given,
     * where 'y' is the vertical offset from the top-left corner of the view window.
     *
     * @param worldX a vertical offset from the top-left corner of the visible world
     * @return the absolute vertical offset from the top-left corner of the scrolling world
     */
    public int getUnivY(int worldY)
    {
        return (scrollingHeight-getHeight())/2+worldY+scrolledY;
    }

    /**
     * Returns the width of the scrolling area of the universe
     *
     * @return the width of the visible scrolling area
     */
    public int getScrollingWidth()
    {
        return scrollingWidth;
    }

    /**
     * Returns the height of the scrolling area of the universe
     *
     * @return the height of the visible scrolling area
     */
    public int getScrollingHeight()
    {
        return scrollingHeight;
    }// end of danpost's codes
    
    public int getScrolledX()
    {
        return scrolledX;
    }
    public int getScrolledY()
    {
        return scrolledY;
    }
}
