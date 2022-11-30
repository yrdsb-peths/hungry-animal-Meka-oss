import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Mekaeel
 * @version 24/11/22
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        Label scoreLabel = new Label(0,200);
        addObject(scoreLabel,50,65);
        
        createApple();
    }
    
    public void createApple()
    {
        Apple apple = new Apple();
        addObject(apple,Greenfoot.getRandomNumber(400),Greenfoot.getRandomNumber(600));
        apple.turn(10);
    }
}
