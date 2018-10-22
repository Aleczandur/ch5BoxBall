import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author alex Floyd
 * @version 10/16/18
 */

public class BallDemo   
{
    private Canvas myCanvas;
    ArrayList<BoxBall> balls = new ArrayList<>();
    
    
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
    
    
    
    /**
     * 
     */
    public void boxBounce()
    {
     int ballCount = 5+((int) (Math.random() * ((30-5)+1)));
     
     
       myCanvas.setVisible(true);
      for(int i = 0; i < ballCount;i++)
      {
        //generate three random color values for ball colors
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b= (int)(Math.random()*256);
        Color color = new Color(r, g, b);
        //create a diameter for the ball
        int d = 10+((int)(Math.random() * ((20 - 10) + 1)));
        int xPos = new Random().nextInt(Math.abs(550));
        int yPos = new Random().nextInt(Math.abs(550));
        //call BoxBall to create an object with given info
        balls.add(new BoxBall(xPos,yPos,d,color, myCanvas));
        balls.get(i).draw();
      }
      
      //for loop to move the balls
             for(int i = 0; i < ballCount; i++)
        {       if(ballCount>5)
                {
                    myCanvas.wait(2);
                    balls.get(i).move();
                }
                if(ballCount<5)
                   myCanvas.wait(7);
                  balls.get(i).move();
         }
      }
     
    

    /**
     * Simulate bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        //get them moving
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
