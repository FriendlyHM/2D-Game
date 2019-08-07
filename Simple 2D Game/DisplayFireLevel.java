import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class DisplayDamage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayFireLevel extends Display
{
    public DisplayFireLevel()
    {
        GreenfootImage image = new GreenfootImage(200,200);
        image.setColor (Color.WHITE); //sets color black
        image.setFont(new Font ("Helvetica", false, false, 20));//sets font
        image.drawString ("FireLevel: " + (ModeAndValue.fireLevel), 5, 100);//draw words
        setImage (image);//draw the actual image
    }
    
    /**s
     * Act - do whatever the DisplayDamage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        display();
    }    
    
    public void display()
    {
        GreenfootImage image = getImage();
        image.clear();//clear image
        image.setColor (Color.WHITE); //sets color black
        image.setFont(new Font ("Helvetica", false, false, 20));//sets font
        image.drawString ("FireLevel: " + (ModeAndValue.fireLevel), 5, 100);//draw words
        setImage (image);//draw the actual image
    }
}

