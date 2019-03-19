import greenfoot.*;
public class Animation extends Actor 
{
    public int frame = 0;
    public String name = "";
    public String extension = ".png";
    public int animateSpeed = 3; //lower number = faster animation
    public int speedCounter = 0; 
    
    /**
     * animates method
     */
    public void animate (int first, int last, int animateSpeed)
    {
        if (speedCounter >= animateSpeed)
        {
            speedCounter = 0;
            if (frame < first || frame >= last)
            {
                frame = first;
            } else {
                frame++;
            }
            setImage (name + frame + extension);
        } else {
            speedCounter++;
        }
    }
}
