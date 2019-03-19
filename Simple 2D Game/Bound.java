import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bound extends canNotSeeThrough
{
    public Bound(int width, int height)
    {
        GreenfootImage img = getImage();
        img.scale(width,height);
        setImage(img);
    }
    /**
     * Act - do whatever the Bound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
