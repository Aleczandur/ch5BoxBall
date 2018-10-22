import java.util.Random;
import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 *
 * @author Alex Floyd
 * @version 10/18/2018
 */

/**
 * @param diameter - diameter of ball
 * @param xPos - position of X coords for ball
 * @param yPos - position of Y coords for ball
 * @param boundaryX - boundaries set for position X
 * @param boundaryY - boundaries set for position Y
 * @param xSpeed - speed of x position
 * @param ySpeed - speed of y position
 */



public class BoxBall
{
    // instance variables - replace the example below with your own
    
    private Ellipse2D.Double circle;
    private Color color;               // circle color
    private int diameter;              // circle diameter
    private int xPos;                  // position X
    private int yPos;                  // position Y
    private Canvas canvas;
    private int boundaryX;             //boundaries set for position X
    private int boundaryY;             //boundaries set for position Y
    private int ySpeed;                // initial downward speed
    private int xSpeed;                // initial downward speed
    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int x, int y, int bD, Color colors, Canvas drawingCanvas)
  {
    x = xPos;
    y = yPos;
    color = colors;
    bD = diameter;
    canvas = drawingCanvas;
  }
  
  /**
   * Constructor to draw the ball(s)
   */
   public void draw()
  {
      canvas.setForegroundColor(color);
      canvas.fillCircle(xPos, yPos, diameter);
  }
  
   /**
   * Erase this ball at its current position.
   **/
  public void erase()
  {
      canvas.eraseCircle(xPos, yPos, diameter);
  }
  
  /**
   * Constructor to check the boundaries of position X
   * Also used to determine the speed of the ball on position X
   */
   private void checkBoundaryY()
  {
      if(yPos < (boundaryY - diameter))
      {
        ySpeed = 5;
      }
      if(yPos >= (boundaryY - diameter))
      {
        ySpeed = ySpeed * -1;
      }
      
  }
  
  /**
   * Constructor to check the boundaries of position X
   * Also used to determine the speed of the ball on position X
   * 
   * in case sources should be cited I used a Youtube video to help me out with determining speed (the speed * 1 equation)
   */
  
  private void checkBoundaryX()
  {
    if(xPos < (boundaryX - diameter))
      {
        xSpeed = 5;
      }
      if( xPos >= (boundaryX - diameter))
      {
        xSpeed = xSpeed * -1;
      }
  }
  public void move()
  {
    boundaryX = 550-diameter;
    boundaryY = 550-diameter;
      // erase at current position
      erase();
       // account for new position
       
       //account new speed
      xPos += xSpeed;
      yPos += ySpeed;
      
      //check to make sure boundaries were not passed.
       if(xPos >= boundaryX)
           checkBoundaryX();
      
      if(xPos <=0)
          checkBoundaryX();
          
      if(yPos >= boundaryY)
          checkBoundaryY();
      
      if(yPos <= 0)
          checkBoundaryY();
      // draw again at new position
      draw();
  }
   /**
   * return the horizontal position of this ball
   */
  public int getXPosition()
  {
      return xPos;
  }
   /**
   * return the vertical position of this ball
   */
  public int getYPosition()
  {
      return yPos;
  }
}