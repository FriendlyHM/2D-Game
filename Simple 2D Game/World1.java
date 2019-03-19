import greenfoot.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends ScrollingWorld implements BoundariesAndAI
{
    

    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {    
        // Create a new world with 880x660 cells with a cell size of 1x1 pixels.
        super(880, 660, 1, 1080, 860); //last 2 parameters indicates the background's real width and height
        
        setStage(1);
        resetLife();//reset life to full health

        createCounters();
        createBoundaries();

        Doors door = new Doors();
        addObject(door, 300,2);

        AnimatedActor actor = new Body(3, "MaleHero");//add the main character's body
        addMainActor(actor, door.getX(), door.getY()+80, 0, 0);

        AnimatedActor head = new Head(3, "");//add the head of  the character
        addObject(head, actor.getX(), actor.getY()-20);         

        GreenfootImage bg = new GreenfootImage("World1800x1350.png");//add the scrolling background
        setScrollingBackground(bg);

        if(!ModeAndValue.hardMode)
        {
            createAI(2,2,0,0);
        }else{
            createAI(3,3,0,0);
        }

        CountDown c1 = new CountDown();
        addObject (c1, 1080/2, 660/2);

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        ArrayList <Objects> obj = new ArrayList<Objects>();

        for (int i = 0; i < 50; i++)
        {
            obj.add(new Rock());//make 50 rocks
        }
        //vertical objs on 2 sides
        //addObject(obj.get(15),360,285-30);
        addObject(obj.get(0),360,285);
        addObject(obj.get(1),360,285+30);
        addObject(obj.get(2),360,285+60);
        addObject(obj.get(3),360,285+90);
        addObject(obj.get(4),360,285+120);
        addObject(obj.get(6),360,285+150);
        addObject(obj.get(7),360,285+180);
        addObject(obj.get(8),360,285+210);
        addObject(obj.get(9),360,285+240);
        addObject(obj.get(5),360,285+270);

        addObject(obj.get(25),760,285-30);
        addObject(obj.get(10),760,285);
        addObject(obj.get(11),760,285+30);
        addObject(obj.get(12),760,285+60);
        addObject(obj.get(13),760,285+90);
        addObject(obj.get(14),760,285+120);
        addObject(obj.get(16),760,285+150);
        addObject(obj.get(17),760,285+180);
        addObject(obj.get(18),760,285+210);
        addObject(obj.get(19),760,285+240);
        //addObject(obj.get(35),760,285+270);

        //horrizontal objs top/bottom

        //addObject(obj.get(20),360+35,255);
        //addObject(obj.get(21),360+70,255);
        addObject(obj.get(22),375+105,255);
        addObject(obj.get(23),375+140,255);
        addObject(obj.get(24),375+175,255);
        addObject(obj.get(26),375+210,255);
        addObject(obj.get(27),375+245,255);
        addObject(obj.get(28),375+280,255);
        addObject(obj.get(29),375+315,255);
        addObject(obj.get(40),375+350,255);

        addObject(obj.get(30),360+35,285+270);
        addObject(obj.get(31),360+70,285+270);
        addObject(obj.get(32),360+105,285+270);
        addObject(obj.get(33),360+140,285+270);
        addObject(obj.get(34),360+175,285+270);
        addObject(obj.get(36),360+210,285+270);
        addObject(obj.get(37),360+245,285+270);
        addObject(obj.get(38),360+280,285+270);
        //addObject(obj.get(39),360+315,285+270);

        obj.add(new BlackZone(100,300));
        addObject(obj.get(50),200,300);
        obj.add(new BlackZone(150,100));
        addObject(obj.get(51),920,400);
        obj.add(new Lamp());
        addObject(obj.get(52),72,65);
        obj.add(new Lamp());
        addObject(obj.get(53),72,797);
        obj.add(new Lamp());
        addObject(obj.get(54),1010,797);
        obj.add(new Lamp());
        addObject(obj.get(55),1010,65);
    }

    /**
     * makes boundaries for each world
     */
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
