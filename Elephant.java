import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author Mekaeel
 * @version 24/11/22
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound elephantSound = new GreenfootSound("nut_ZKo5FA9.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[10];
    public String facing = "right";
    public Elephant()
    {
        for(int i =0; i < idleRight.length;i++)
        {
            int j = i + 1;
            idleRight[i] = new GreenfootImage("images\\lebron\\frame ("+j+").png");
            idleRight[i].scale(100,100);
        }
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex= (imageIndex + 1) % idleRight.length;
        }
        else
        {
            idleRight[imageIndex].mirrorVertically();
            setImage(idleRight[imageIndex]);
            imageIndex= (imageIndex + 1) % idleRight.length;
        }
    }
    private int timerTime = 3*60;
    public int counter;
    public int speed;
    public int ticker = 1;
    public void act() 
    {
        
        
        timerTime = timerTime-ticker;
        MyWorld world = (MyWorld) getWorld();
        world.setTimer(timerTime/55);
        
        if(world.stop == false)
        {
            speed = 0;
            if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d"))
            {
                setRotation(315);
                speed = 5;
                facing = "right";
            }
            else if(Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("d"))
            {
                setRotation(45);
                speed = 5;
                facing = "right";
            }
            else if(Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a"))
            {
                setRotation(135);
                speed = 5;
                facing = "left";
            }
            else if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a"))
            {
                setRotation(225);
                speed = 5;
                facing = "left";
            }
            else if(Greenfoot.isKeyDown("s")==true)
            {
                setRotation(90);
                speed = 5;
            }
            else if(Greenfoot.isKeyDown("w")==true)
            {
                setRotation(270);
                speed = 5;
            }
            else if(Greenfoot.isKeyDown("d")==true)
            {
                setRotation(0);
                speed = 5;
                facing = "right";
            }
            else if(Greenfoot.isKeyDown("a")==true)
            {
                setRotation(180);
                speed = 5;
                facing = "left";
            }
            move(speed);
        }
        if(isAtEdge())
        {
            turn(Greenfoot.getRandomNumber(360));
            move(5);
        }
        eat();
        animateElephant();
        stop();
    }    
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            timerTime= timerTime + 60;
            elephantSound.play();
        }
        
    }
    
    public void stop()
    {
        MyWorld world = (MyWorld) getWorld();
        if(world.stop==true)
        {
            speed=0;
            ticker=0;
        }
    }
}
