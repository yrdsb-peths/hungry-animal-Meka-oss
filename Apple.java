import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Actor
{
    
    GreenfootImage[] people = new GreenfootImage[5];
    public int count;
    public void act()
    {
        for(int i=1;i<6;i++)
        {
            people[i] = new GreenfootImage("images\\people\\person ("+i+").png");
            people[i].scale(100,100);
        }
        MyWorld world = (MyWorld) getWorld();
        count = world.counter;
    }
    public Apple()
    {
        setImage(people[count]);
    }
    
    
}
