import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound extends Buttons
{
    /**
     * Act - do whatever the Sound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (ModeAndValue.music)
        {
            ModeAndValue.bm.playLoop();
            setImage("Sound.png");
        } else {
            ModeAndValue.bm.pause();
            setImage("SoundMute.png");
        }
        if(Greenfoot.mouseClicked(this))
        {
            if(ModeAndValue.music)
            {
                ModeAndValue.music = false;
            } else {
                ModeAndValue.music = true;
            }
        }
    }    
}
