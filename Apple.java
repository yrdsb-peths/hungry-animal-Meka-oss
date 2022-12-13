import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Actor
{
    GreenfootImage[] people = new GreenfootImage[5];
    static int num = 0;
    public Apple()
    {
        for(int i = 1; i<6; i++)
        {
            people[i-1] = new GreenfootImage("\\images\\people\\person ("+i+").png");
            people[i-1].scale(100,100);
        }
        setImage(people[num]);
        num++;
        num = num % 5;
    }
}

