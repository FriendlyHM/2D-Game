import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is to keep all the values of the main character
 * speed, health, damage
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ModeAndValue
{
    public static GreenfootSound bm = new GreenfootSound("PlayingMusic.wav");
    public static boolean hardMode;
    public static int health = 40;
    public static int maxSpeed = 0;
    public static int damage = 0;
    public static int fireLevel = 0;
    public static boolean music = true;
    /**
     * Act - do whatever the Mode wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }

    public static void reset()
    {
        health = 40;
        maxSpeed = 0;
        damage = 0;
        fireLevel = 0;
    }
}
