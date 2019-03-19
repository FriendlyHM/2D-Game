import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{
    GreenfootImage bg = getBackground();
    public Menu()
    {   
        super(880, 660, 1); 
        prepare();
        ModeAndValue.reset();

    }

    public void prepare()
    {
        GreenfootImage text1 = new GreenfootImage("Use W,S,A,D to Move", 40, Color.WHITE,new Color(0,0,0,0));
        bg.drawImage(text1,40, 270);

        GreenfootImage text2 = new GreenfootImage ("Use Arrow Keys to Fire", 40, Color.WHITE, new Color (0,0,0,0));
        bg.drawImage (text2, 525, 270);
        
        GreenfootImage text3 = new GreenfootImage ("Instruction:\nKill all enemies to open the door", 40, Color.WHITE, new Color (0,0,0,0));
        bg.drawImage (text3, 220, 370);

        GreenfootImage title = new GreenfootImage("Title.png");
        bg.drawImage(title, 200,40);
        
        GreenfootImage text4 = new GreenfootImage ("Click to mute music", 20, Color.WHITE, new Color (0,0,0,0));
        bg.drawImage (text4, 670, 615);

        NormalMode normalmode = new NormalMode();
        addObject(normalmode, 295,530);
        HardMode hardmode = new HardMode();
        addObject(hardmode, 592,530);
        Sound sound = new Sound();
        addObject(sound,840,625);
    }

    public void act()
    {

    }
}
