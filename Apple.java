import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Actor
{
    public void act() 
    {
        move(5);
        if(isAtEdge()== true)
        {
            turn(Greenfoot.getRandomNumber(360));
            move(5);
        }
    }
    
}
