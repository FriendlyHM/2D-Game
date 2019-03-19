import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class End extends World
{
    GreenfootImage bg = getBackground();
    /**
     * Constructor for objects of class End.
     * 
     */
    public End()
    {    
        super(880, 660, 1);
        prepare();
    }

    public void prepare()
    {
        GreenfootImage end = new GreenfootImage("Congratulation!\nYou've won!", 80, Color.WHITE, new Color (0,0,0,0));
        bg.drawImage(end, 230,200);
        GreenfootImage text = new GreenfootImage("Press 'Backspace' to return", 40, Color.WHITE, new Color (0,0,0,0));
        bg.drawImage(text, 270,400);
        Sound sound = new Sound();
        addObject(sound,840,625);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("Backspace"))
        {
            Greenfoot.setWorld(new Menu());
        }
    }
}
