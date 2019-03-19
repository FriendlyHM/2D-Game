import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Doors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Doors extends Actor
{
    private boolean openDoor = false;
    /**
     * Act - do whatever the Doors wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        clearStage();
    }   
    
    public void clearStage()
    {
        List <canHurtCharacter> getAllAI = getWorld().getObjects(canHurtCharacter.class);
        List <Skeletons> getAllSkeletons = getWorld().getObjects(Skeletons.class);
        List <Orc> getAllOrc = getWorld().getObjects(Orc.class);
        List <Ghost> getAllGhost = getWorld().getObjects(Ghost.class);
        List <Shooter> Shooters = getWorld().getObjects(Shooter.class);
        List <Bat> bats = getWorld().getObjects(Bat.class);
        if (getAllAI.size()==0 && getAllSkeletons.size()==0 && getAllOrc.size()==0 && getAllGhost.size()==0 && Shooters.size()==0 && bats.size()==0)
        {
            openDoor=true;
            setImage("lift-open.png");
        }
    }
    
    public boolean checkDoor()
    {
        return openDoor;
    }
}
