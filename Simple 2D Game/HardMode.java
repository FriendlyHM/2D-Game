import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class HardMode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HardMode extends Buttons
{
    public HardMode()
    {
        GreenfootImage img = getImage();
        img.scale(img.getWidth()*2, img.getHeight()*2);
        GreenfootImage hard = new GreenfootImage("Hard",50,Color.WHITE, new Color(0,0,0,0));
        img.drawImage(hard, img.getWidth()/9, img.getHeight()/4);
    }
    /**
     * Act - do whatever the HardMode wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ModeAndValue.reset();
        if(Greenfoot.mouseClicked(this))
        {
            ModeAndValue.hardMode = true;
            Greenfoot.setWorld(new World1());
        }
    }    
}
