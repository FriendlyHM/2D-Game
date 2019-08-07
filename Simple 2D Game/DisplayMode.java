import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class DisplayMode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayMode extends Display
{
    public DisplayMode()
    {
        GreenfootImage image = new GreenfootImage(200,200);
        image.setColor (Color.WHITE); //sets color black
        image.setFont(new Font ("Helvetica", false, false, 20));//sets font
        image.drawString ("Difficulty", 5, 100);//draw words
        setImage (image);//draw the actual image
    }

    /**
     * Act - do whatever the DisplayMode wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        display();
    }    

    public void display()
    {
        if (!ModeAndValue.hardMode)
        {
            GreenfootImage image = getImage();
            image.clear();//clear image
            image.setColor (Color.WHITE); //sets color black
            image.setFont(new Font ("Helvetica", false, false, 20));//sets font
            image.drawString ("Difficulty: Normal", 5, 100);//draw words
            setImage (image);//draw the actual image
        }
        else{
            GreenfootImage image = getImage();
            image.clear();//clear image
            image.setColor (Color.WHITE); //sets color black
            image.setFont(new Font ("Helvetica", false, false, 20));//sets font
            image.drawString ("Difficulty: Hard", 5, 100);//draw words
            setImage (image);//draw the actual image
        }
    }
}