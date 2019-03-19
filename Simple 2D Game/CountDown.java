import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class CountDown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountDown extends Display
{
    private int seconds = 3;
    private int milliSecs = 0;
    
    private SimpleTimer time = new SimpleTimer();

    public static boolean stop = false;
    public static boolean canPlay = false;
    
    /**
     * Constructor for CountDown
     */
    public CountDown()
    {
        canPlay = false;
        GreenfootImage image = new GreenfootImage (200, 200);
        image.setColor (Color.RED);
        image.setFont(new Font ("Helvetica", false, false, 72));
        image.drawString ("" + seconds, 5, 100);
        setImage (image);

        //starts the timer
        time.mark();
    }

    /**
     * Act - do whatever the CountDown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        display();
    }    

    /**
     *Display the count down
     */
    public void display()
    {
        if (time.millisElapsed()/1000 > 0)//if millisecond is still > 0
        {
            seconds --; //-1 second
            time.mark(); //marks millisecond
        }

        if (seconds == 0)
        {
            canPlay=true;
            getWorld().removeObject (this);
        }

        GreenfootImage image = getImage();
        image.clear();//clear image
        image.setColor (Color.RED); //sets color black
        image.setFont(new Font ("Helvetica", false, false, 72));//sets font
        image.drawString ("" + seconds, 5, 100);//draw words
        setImage (image);//draw the actual image
    }
}
