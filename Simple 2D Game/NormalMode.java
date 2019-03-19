import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class NormaMode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalMode extends Buttons
{
    public NormalMode()
    {
        GreenfootImage img = getImage();
        img.scale(img.getWidth()*3, img.getHeight()*2);
        GreenfootImage norm = new GreenfootImage("Normal" , 50, Color.WHITE, new Color(0,0,0,0));
        img.drawImage(norm, img.getWidth()/9, img.getHeight()/4);
    }
    /**
     * Act - do whatever the NormaMode wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ModeAndValue.reset();
        if(Greenfoot.mouseClicked(this))
        {
            ModeAndValue.hardMode = false;
            Greenfoot.setWorld(new World1());
        }
    }    
}
