import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World4 extends ScrollingWorld implements BoundariesAndAI
{
    /**
     * Constructor for objects of class World2.
     */
    public World4()
    {
        // Create a new world with 880x660 cells with a cell size of 1x1 pixels.
        super(880, 660, 1, 1500, 1300); //last 2 parameters indicates the background's real width and height

        setStage(4);

        createCounters();
        createBoundaries();

        resetLife();

        Doors door = new Doors();
        addObject(door, 300, 20);

        AnimatedActor actor = new Body(3, "MaleHero");//add the main character's body
        addMainActor(actor, door.getX(), door.getY()+90, 0, 0);

        AnimatedActor head = new Head(3, "");//add the head of  the character
        addObject(head, actor.getX(), actor.getY()-20); 

        GreenfootImage bg = new GreenfootImage("World1800x1350.png");//add the scrolling background
        setScrollingBackground(bg);

        if(!ModeAndValue.hardMode)
        {
            createAI(3,2,5,6);
        }else{
            createAI(4,1,7,7);
        }

        CountDown c1 = new CountDown();
        addObject (c1, 1080/2, 660/2);

        prepare();
    }

    public void prepare()
    {
        ArrayList <Objects> obj = new ArrayList<Objects>();
        for (int i=0; i < 100; i++)
        {
            obj.add(new Rock()); //make 100 rocks
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

        //vertical objs on 2 sides
        //addObject(obj.get(15),360,285-30);
        addObject(obj.get(50),1000,285);
        addObject(obj.get(51),1000,285+30);
        addObject(obj.get(52),1000,285+60);
        addObject(obj.get(53),1000,285+90);
        addObject(obj.get(54),1000,285+120);
        addObject(obj.get(56),1000,285+150);
        addObject(obj.get(57),1000,285+180);
        addObject(obj.get(58),1000,285+210);
        addObject(obj.get(59),1000,285+240);
        addObject(obj.get(60),1000,285+270);

        addObject(obj.get(61),1400,285-30);
        addObject(obj.get(62),1400,285);
        addObject(obj.get(63),1400,285+30);
        addObject(obj.get(64),1400,285+60);
        addObject(obj.get(65),1400,285+90);
        addObject(obj.get(66),1400,285+120);
        addObject(obj.get(67),1400,285+150);
        addObject(obj.get(68),1400,285+180);
        addObject(obj.get(69),1400,285+210);
        addObject(obj.get(70),1400,285+240);
        //addObject(obj.get(35),760,285+270);

        //horrizontal objs top/bottom

        //addObject(obj.get(20),360+35,255);
        //addObject(obj.get(21),360+70,255);
        addObject(obj.get(71),600+105,650);
        addObject(obj.get(72),600+140,650);
        addObject(obj.get(73),600+175,650);
        addObject(obj.get(74),600+210,650);
        addObject(obj.get(75),600+245,650);
        addObject(obj.get(76),600+280,650);
        addObject(obj.get(77),600+315,650);
        addObject(obj.get(78),600+350,650);

        addObject(obj.get(79),360+35,800);
        addObject(obj.get(80),360+70,800);
        addObject(obj.get(81),360+105,800);
        addObject(obj.get(82),360+140,800);
        addObject(obj.get(83),360+175,800);
        addObject(obj.get(84),360+210,800);
        addObject(obj.get(85),360+245,800);
        addObject(obj.get(86),360+280,800);
        //addObject(obj.get(39),360+315,285+270);

        BlackZone bz1 = new BlackZone(100,130);
        addObject(bz1, 1000, 1000);
        BlackZone bz2 = new BlackZone(100,130);
        addObject(bz2, 500, 400);
        BlackZone bz3 = new BlackZone(100,400);
        addObject(bz3, 1200, 400);
        BlackZone bz4 = new BlackZone(400,100);
        addObject(bz4, 400, 1000);
        Lamp lamp = new Lamp();
        addObject(lamp,110,104);
        Shooter shooter = new Shooter(false);
        addObject (shooter,150, 104);
        Lamp lamp2 = new Lamp();
        addObject(lamp2,110,1200);
        Shooter shooter2 = new Shooter(false);
        addObject (shooter2,150, 1200);
        Lamp lamp3 = new Lamp();
        addObject(lamp3,1390,104);
        Shooter shooter3 = new Shooter(true);
        addObject (shooter3,1330, 104);
        Lamp lamp4 = new Lamp();
        addObject(lamp4,1390,1200);
        Shooter shooter4 = new Shooter(true);
        addObject (shooter4,1330, 1200);

        Shooter shooter5 = new Shooter(false);
        addObject (shooter5,150, 500);
        Shooter shooter6 = new Shooter(false);
        addObject (shooter6,150, 900);
        Shooter shooter7 = new Shooter(true);
        addObject (shooter7,1330, 500);
        Shooter shooter8 = new Shooter(true);
        addObject (shooter8,1330, 900);

        Rock rock73 = new Rock();
        addObject(rock73,149,477);
        Rock rock74 = new Rock();
        addObject(rock74,149,549);
        Rock rock75 = new Rock();
        addObject(rock75,120,513);

        Rock rock76 = new Rock();
        addObject(rock76,149,477+400);
        Rock rock77 = new Rock();
        addObject(rock77,149,549+400);
        Rock rock78 = new Rock();
        addObject(rock78,120,513+400);

        Rock rock79 = new Rock();
        addObject(rock79,149+1190,477+400);
        Rock rock80 = new Rock();
        addObject(rock80,149+1190,549+400);
        Rock rock81 = new Rock();
        addObject(rock81,120+1240,513+400);

        Rock rock82 = new Rock();
        addObject(rock82,149+1190,477);
        Rock rock83 = new Rock();
        addObject(rock83,149+1190,549);
        Rock rock84 = new Rock();
        addObject(rock84,120+1240,513);
    }

    public void createBoundaries()
    {
        Objects topB = new Bound(1400, 5);
        addObject(topB, 750, 55);
        Objects bottomB = new Bound(1400, 5);
        addObject(bottomB, 750, 1300 - 55);
        Objects leftB = new Bound(5, 1210);
        addObject(leftB, 60, 650);
        Objects rightB = new Bound(5, 1210);
        addObject(rightB, 1500-60, 650);
    }

    public void act()
    {
        super.act();
        die();
    }
}
