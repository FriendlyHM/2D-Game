import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends ScrollingWorld implements BoundariesAndAI
{

    /**
     * Constructor for objects of class World4.
     * 
     */
    public World2()
    {
        // Create a new world with 880x660 cells with a cell size of 1x1 pixels.
        super(880, 660, 1, 1080, 860); //last 2 parameters indicates the background's real width and height

        setStage(2);
        resetLife();//reset life to full health

        createCounters();
        createBoundaries();

        Doors door = new Doors();
        addObject(door, 700,2);

        AnimatedActor actor = new Body(3, "MaleHero");//add the main character's body
        addMainActor(actor, door.getX(), door.getY()+80, 0, 0);

        AnimatedActor head = new Head(3, "");//add the head of  the character
        addObject(head, actor.getX()+getScrolledX(), actor.getY()+getScrolledY()-20);         

        GreenfootImage bg = new GreenfootImage("World1800x1350.png");//add the scrolling background
        setScrollingBackground(bg);

        if(!ModeAndValue.hardMode)
        {
            createAI(4,2,2,0);
        }else{
            createAI(5,4,3,0);
        }

        CountDown c1 = new CountDown();
        addObject (c1, 1500/2, 660/2);

        prepare();
    }

    public void prepare()
    {

        BlackZone blackzone = new BlackZone(400, 100);
        addObject(blackzone,750,208);
        BlackZone blackzone2 = new BlackZone(300, 100);
        addObject(blackzone2,300,208);
        BlackZone blackzone3 = new BlackZone(100, 400);
        addObject(blackzone3,654,456);
        blackzone3.setLocation(754,565);
        BlackZone blackzone4 = new BlackZone(300, 300);
        addObject(blackzone4,370,488);
        blackzone4.setLocation(316,560);
        Rock rock = new Rock();
        addObject(rock,582,476);
        rock.setLocation(588,447);
        Rock rock2 = new Rock();
        addObject(rock2,526,602);
        rock2.setLocation(518,563);
        Rock rock3 = new Rock();
        addObject(rock3,661,620);
        rock3.setLocation(663,603);
        rock.setLocation(589,452);
        Rock rock4 = new Rock();
        addObject(rock4,635,549);
        rock4.setLocation(663,635);
        Rock rock5 = new Rock();
        addObject(rock5,512,604);
        rock2.setLocation(503,512);
        rock5.setLocation(502,549);
        rock.setLocation(594,431);
        BlackZone blackzone5 = new BlackZone(200, 30);
        addObject(blackzone5,230,605);
        Rock rock6 = new Rock();
        addObject(rock6,100,565);
        Rock rock7 = new Rock();
        addObject(rock7,135,565);
        Rock rock8 = new Rock();
        addObject(rock8,170,565);
        Rock rock9 = new Rock();
        addObject(rock9,205,565);
        Rock rock10 = new Rock();
        addObject(rock10,72,643);
        Rock rock11 = new Rock();
        addObject(rock11,136,643);
        Rock rock12 = new Rock();
        addObject(rock12,172,643);
        Rock rock13 = new Rock();
        addObject(rock13,237,644);
        Rock rock14 = new Rock();

        Rock rock17 = new Rock();
        addObject(rock17,735,750);
        Rock rock18 = new Rock();
        addObject(rock18,770,750);
        Rock rock19 = new Rock();
        addObject(rock19,805,750);
        Rock rock20 = new Rock();
        addObject(rock20,840,750);

        Lamp lamp = new Lamp();
        addObject(lamp,72,65);
        Lamp lamp2 = new Lamp();
        addObject(lamp2,72,797);
        Lamp lamp3 = new Lamp();
        addObject(lamp3,1010,797);
        Lamp lamp4 = new Lamp();
        addObject(lamp4,1010,65);
    }

    public void createBoundaries()
    {
        Objects topB = new Bound(1000, 5);
        addObject(topB, 540, 35);
        Objects bottomB = new Bound(1000, 5);
        addObject(bottomB, 540, 860 - 35);
        Objects leftB = new Bound(5, 780);
        addObject(leftB, 40, 430);
        Objects rightB = new Bound(5, 780);
        addObject(rightB, 1080-45, 430);
    }

    public void act()
    {
        super.act();
        die();
    }
}
