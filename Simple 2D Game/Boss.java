import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends ScrollingWorld implements BoundariesAndAI
{

    /**
     * Constructor for objects of class Boss.
     * 
     */
    public Boss()
    {
        super(880, 660, 1, 880, 660); //last 2 parameters indicates the background's real width and height

        setStage(5);
        resetLife();//reset life to full health

        createCounters();
        createBoundaries();

        canHurtCharacter dragon = new Dragon();
        addObject(dragon, 400,400);

        Doors door = new Doors();
        addObject(door, 400,-5);

        AnimatedActor actor = new Body(3, "MaleHero");//add the main character's body
        addMainActor(actor, door.getX(), door.getY()+80, 0, 0);

        AnimatedActor head = new Head(3, "");//add the head of  the character
        addObject(head, actor.getX()+getScrolledX(), actor.getY()+getScrolledY()-20);         

        GreenfootImage bg = new GreenfootImage("World1800x1350.png");//add the scrolling background
        setScrollingBackground(bg);

        createAI(0,0,0,0);

        CountDown c1 = new CountDown();
        addObject (c1, 1080/2, 660/2);
        prepare();
    }

    /**
     * makes boundaries for each world
     */
    public void createBoundaries()
    {
        Objects topB = new Bound(820, 5);
        addObject(topB, 440, 27);
        Objects bottomB = new Bound(820, 5);
        addObject(bottomB, 440, 633);
        Objects leftB = new Bound(5, 600);
        addObject(leftB, 35, 330);
        Objects rightB = new Bound(5, 600);
        addObject(rightB, 880-35, 330);

        // Objects topB = new Bound(1400, 5);
        // addObject(topB, 750, 63);
        // Objects bottomB = new Bound(1400, 5);
        // addObject(bottomB, 750, 1500 - 63);
        // Objects leftB = new Bound(5, 1400);
        // addObject(leftB, 60, 750);
        // Objects rightB = new Bound(5, 1400);
        // addObject(rightB, 1500-60, 750);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Rock rock = new Rock();
        addObject(rock,192,144);
        Rock rock2 = new Rock();
        addObject(rock2,400,242);
        Rock rock3 = new Rock();
        addObject(rock3,668,143);
        Rock rock4 = new Rock();
        addObject(rock4,670,394);
        Rock rock5 = new Rock();
        addObject(rock5,582,299);
        Rock rock6 = new Rock();
        addObject(rock6,200,451);
        Rock rock7 = new Rock();
        addObject(rock7,199,323);
        Rock rock8 = new Rock();
        addObject(rock8,338,418);
        Rock rock9 = new Rock();
        addObject(rock9,106,378);
        Rock rock10 = new Rock();
        addObject(rock10,105,218);
        Rock rock11 = new Rock();
        addObject(rock11,615,199);
        Rock rock12 = new Rock();
        addObject(rock12,781,320);
        Rock rock13 = new Rock();
        addObject(rock13,508,528);
        Rock rock14 = new Rock();
        addObject(rock14,267,583);
        Rock rock15 = new Rock();
        addObject(rock15,509,409);
        Rock rock16 = new Rock();
        addObject(rock16,442,117);
        Rock rock17 = new Rock();
        addObject(rock17,293,183);
        Rock rock18 = new Rock();
        addObject(rock18,784,94);
        Rock rock19 = new Rock();
        addObject(rock19,762,220);
        Rock rock20 = new Rock();
        addObject(rock20,764,543);
        Rock rock21 = new Rock();
        addObject(rock21,632,574);
        Rock rock22 = new Rock();
        addObject(rock22,541,132);
        Rock rock23 = new Rock();
        addObject(rock23,270,86);
        Rock rock24 = new Rock();
        addObject(rock24,116,119);
        Rock rock25 = new Rock();
        addObject(rock25,643,494);
        Rock rock26 = new Rock();
        addObject(rock26,766,450);
        Rock rock27 = new Rock();
        addObject(rock27,688,294);
        Rock rock28 = new Rock();
        addObject(rock28,625,76);
        Rock rock29 = new Rock();
        addObject(rock29,489,235);
        Rock rock30 = new Rock();
        addObject(rock30,384,168);
        Rock rock31 = new Rock();
        addObject(rock31,294,294);
        Rock rock32 = new Rock();
        addObject(rock32,210,241);
        Rock rock33 = new Rock();
        addObject(rock33,307,505);
        Rock rock34 = new Rock();
        addObject(rock34,119,545);
        Rock rock35 = new Rock();
        addObject(rock35,416,579);
        Rock rock36 = new Rock();
        addObject(rock36,583,387);
        Rock rock37 = new Rock();
        addObject(rock37,410,333);
        Rock rock38 = new Rock();
        addObject(rock38,257,374);
        Rock rock39 = new Rock();
        addObject(rock39,203,537);
    }
    
    public void act()
    {
        super.act();
        die();
    }
}
