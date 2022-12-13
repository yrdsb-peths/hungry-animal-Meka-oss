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
            GreenfootSound elephantSound = new GreenfootSound("lebron.mp3");
            GreenfootImage[] idleRight = new GreenfootImage[7];
            GreenfootImage[] idleLeft = new GreenfootImage[7];
            GreenfootImage[] idleDown = new GreenfootImage[7];
            GreenfootImage[] idleUp = new GreenfootImage[7];
            public String facing = "right";
            public Elephant()
            {
                for(int i =0; i < idleRight.length;i++)
                {
                    int j = i + 1;
                    idleRight[i] = new GreenfootImage("images\\lebron\\frame ("+j+").png");
                    idleRight[i].scale(100,100);
                    
                    idleLeft[i] = new GreenfootImage("images\\lebron\\frame ("+j+").png");
                    idleLeft[i].scale(100,100);
                    idleLeft[i].mirrorVertically();
                    
                    idleUp[i] = new GreenfootImage("images\\lebron\\frame ("+j+").png");
                    idleUp[i].scale(100,100);
                    idleUp[i].rotate(90);
                    
                    idleDown[i] = new GreenfootImage("images\\lebron\\frame ("+j+").png");
                    idleDown[i].scale(100,100);
                    idleDown[i].rotate(270);
                }
            }
        
        int imageIndex = 0;
        public void animateElephant()
        {
            MyWorld world = (MyWorld) getWorld();
            if(world.stop==false)
            {
                if(facing.equals("right"))
                {
                    setImage(idleRight[imageIndex]);
                    imageIndex= (imageIndex + 1) % idleRight.length;
                }
                else if(facing.equals("left"))
                {
                    setImage(idleLeft[imageIndex]);
                    imageIndex= (imageIndex + 1) % idleRight.length;
               
                }
                else if(facing.equals("up"))
                {
                    setImage(idleUp[imageIndex]);
                    imageIndex= (imageIndex + 1) % idleRight.length;
                }
                else if(facing.equals("down"))
                {
                    setImage(idleDown[imageIndex]);
                    imageIndex= (imageIndex + 1) % idleRight.length;
                }
        }
    }
    private int timerTime = 3*60;
    public int counter;
    public int speed;
    public int ticker = 1;
    public void act() 
    {
        
        MyWorld world = (MyWorld) getWorld();
        timerTime = timerTime-ticker;
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
                facing = "down";
            }
            else if(Greenfoot.isKeyDown("w")==true)
            {
                setRotation(270);
                speed = 5;
                facing = "up";
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
        
        if(Greenfoot.isKeyDown("space")==true)
        {
            world.pause();
        }
        eat();
        animateElephant();
        stop();
    }    
    
    public void eat()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            world.createApple();
            world.increaseScore();
            timerTime= timerTime + 60;
            elephantSound.play();
        }
        if(world.stop==false)
        {
            world.removeObject(world.gamePauseLabel);
        }
        
    }
    
    public void stop()
    {
        MyWorld world = (MyWorld) getWorld();
        if(world.stop==true)
        {
            speed=0;
            ticker = 0;
        }
        if(world.stop==false)
        {
            ticker = 1;
        }
    }
}
