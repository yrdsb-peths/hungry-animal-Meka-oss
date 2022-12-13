 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Mekaeel
 * @version 24/11/22
 */
public class MyWorld extends World
{
    Label scoreLabel;
    Label timer;
    Label gamePauseLabel;
    public int score = 0;
    public boolean stop = false;
    public int counter = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 376, 1);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        scoreLabel = new Label(0,100);
        addObject(scoreLabel,50,65);
        
        timer = new Label(5,100);
        addObject(timer,550,65);
        
        gamePauseLabel = new Label("Game Paused", 100);
        
        createApple();
        createApple();
        createApple();
        createApple();
        createApple();
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,300, 200);
        stop = true;
    }
    
    public void pause()
    {
        if(stop==false)
        {
            addObject(gamePauseLabel,300, 200);
            stop = true;
        }
        else
        {
            removeObject(gamePauseLabel);
            stop = false;
        }
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    public void setTimer(int t)
    {
        timer.setValue(t);
        if(t <= 0)
        {
            gameOver();
        }
    }
    
    public void createApple()
    {
        Apple apple = new Apple();
        addObject(apple,Greenfoot.getRandomNumber(400),Greenfoot.getRandomNumber(600));
        apple.turn(10);
        counter++;
        counter = counter % 6;
    }
}
