import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class World3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World3 extends ScrollingWorld
{
    /**
     * Constructor for objects of class World3.
     * 
     */
    public World3()
    {
        // Create a new world with 880x660 cells with a cell size of 1x1 pixels.
        super(880, 660, 1, 1080, 860); //last 2 parameters indicates the background's real width and height

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
            createAI(3,1,3,2);
        }else{
            createAI(4,4,4,4);
        }

        setStage(3);

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
        addObject(obj.get(21),375+350,255);

        addObject(obj.get(30),360+35,285+270);
        addObject(obj.get(31),360+70,285+270);
        addObject(obj.get(32),360+105,285+270);
        addObject(obj.get(33),360+140,285+270);
        addObject(obj.get(34),360+175,285+270);
        addObject(obj.get(36),360+210,285+270);
        addObject(obj.get(37),360+245,285+270);
        addObject(obj.get(38),360+280,285+270);
        //addObject(obj.get(39),360+315,285+270);

        addObject(obj.get(40),500+35,400+270);
        addObject(obj.get(41),500+70,400+270);
        addObject(obj.get(42),500+105,400+270);
        addObject(obj.get(43),500+140,400+270);
        addObject(obj.get(44),500+175,400+270);
        addObject(obj.get(46),500+210,400+270);
        addObject(obj.get(47),500+245,400+270);
        addObject(obj.get(48),500+280,400+270);
        addObject(obj.get(49),500+315,400+270);
        Rock rock91 = new Rock();
        addObject(rock91,330,166);
        Rock rock92 = new Rock();
        addObject(rock92,300,165);
        Rock rock93 = new Rock();
        addObject(rock93,271,169);
        Rock rock94 = new Rock();
        addObject(rock94,239,170);
        Rock rock95 = new Rock();
        addObject(rock95,206,169);
        Rock rock96 = new Rock();
        addObject(rock96,166,169);
        Rock rock97 = new Rock();
        addObject(rock97,137,200);
        Rock rock98 = new Rock();
        addObject(rock98,138,237);
        Rock rock99 = new Rock();
        addObject(rock99,133,266);
        Rock rock100 = new Rock();
        addObject(rock100,137,298);
        Rock rock101 = new Rock();
        addObject(rock101,135,331);
        Rock rock102 = new Rock();
        addObject(rock102,136,368);
        rock95.setLocation(202,169);
        rock94.setLocation(237,170);
        rock92.setLocation(300,169);
        rock91.setLocation(337,168);
        rock92.setLocation(304,169);
        rock91.setLocation(340,168);
        rock94.setLocation(237,169);
        rock98.setLocation(137,234);
        rock97.setLocation(137,197);
        rock98.setLocation(137,232);
        rock99.setLocation(137,264);
        rock100.setLocation(137,297);
        rock101.setLocation(137,329);
        rock102.setLocation(137,366);
        BlackZone blackzone = new BlackZone(100, 50);
        addObject(blackzone,256,430);
        blackzone.setLocation(247,255);
        rock102.setLocation(137,363);
        Rock rock103 = new Rock();
        addObject(rock103,330,410);
        Rock rock104 = new Rock();
        addObject(rock104,306,442);
        Rock rock105 = new Rock();
        addObject(rock105,283,478);
        Rock rock106 = new Rock();
        addObject(rock106,256,515);
        Rock rock107 = new Rock();
        addObject(rock107,231,554);
        Rock rock108 = new Rock();
        addObject(rock108,207,601);
        Lamp lamp = new Lamp();
        addObject(lamp,704,302);
        Lamp lamp2 = new Lamp();
        addObject(lamp2,421,502);
        rock108.setLocation(204,592);
        rock105.setLocation(284,474);
        rock106.setLocation(259,505);
        rock107.setLocation(235,535);
        rock108.setLocation(211,562);
        rock108.setLocation(210,566);
        rock104.setLocation(306,441);
        rock105.setLocation(284,471);
        rock106.setLocation(261,502);
        rock107.setLocation(238,532);
        rock108.setLocation(214,563);
        Rock rock109 = new Rock();
        addObject(rock109,183,571);
        Rock rock110 = new Rock();
        addObject(rock110,150,574);
        Rock rock111 = new Rock();
        addObject(rock111,116,577);
        rock110.setLocation(148,571);
        rock111.setLocation(111,572);
        rock109.setLocation(182,570);
        rock110.setLocation(144,564);
        rock109.setLocation(180,563);
        rock111.setLocation(107,565);
        removeObject(rock111);
        Rock rock112 = new Rock();
        addObject(rock112,836,127);
        Rock rock113 = new Rock();
        addObject(rock113,676,87);
        Rock rock114 = new Rock();
        addObject(rock114,744,171);
        Rock rock115 = new Rock();
        addObject(rock115,647,596);
        Rock rock116 = new Rock();
        addObject(rock116,648,639);
        rock115.setLocation(640,590);
        rock116.setLocation(640,632);
        rock115.setLocation(640,593);
        BlackZone blackzone2 = new BlackZone(200, 60);
        addObject(blackzone2,561,408);
        blackzone2.setLocation(560,399);
        blackzone2.setLocation(560,400);
        BlackZone blackzone3 = new BlackZone(130, 350);
        addObject(blackzone3,910,390);

        Shooter shooter = new Shooter(false);
        addObject(shooter,186,217);
        shooter.setLocation(177,207);
        Shooter shooter2 = new Shooter(false);
        addObject(shooter2,89,93);
        shooter2.setLocation(81,78);
        Shooter shooter3 = new Shooter(false);
        addObject(shooter3,599,611);
        removeObject(shooter3);
        Shooter shooter4 = new Shooter(true);
        addObject(shooter4,599,606);
        Shooter shooter5 = new Shooter(true);
        addObject(shooter5, 990, 78);
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
