import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lamp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lamp extends canNotSeeThrough
{
    GifImage gifImage = new GifImage("FireLamp.gif");
    public Lamp()
    {
        gifImage.getCurrentImage();
    }
    
    /**
     * Act - do whatever the Lamp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(gifImage.getCurrentImage());
    }    
}
