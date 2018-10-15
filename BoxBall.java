import java.util.Random;
import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPos;
    private int yPos;
    private final int roof;      // y position of ground
    private final int ground;      // y position of ground
    private final int lWall;      // y position of ground
    private final int rWall;      // y position of ground
    private Canvas canvas;
    private int ySpeed;                // initial downward speed
    private int xSpeed;                // initial downward speed
    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int top, int bottom, int left, int right, Color ballColor, Canvas drawingCanvas)
    {
        Random speed = new Random();
        
        diameter = generateRandom(10,20);
        xPos = generateRandom(60, (540 - diameter));
        yPos = generateRandom(60, (540 - diameter));
        color = ballColor;
        roof = top;
        ground = bottom;
        lWall = left;
        rWall = right;
        canvas = drawingCanvas;
        ySpeed = generateRandom(0,15) - 7;
            if(ySpeed == 0)
            ySpeed = generateRandom(0,15) -7;
        xSpeed = generateRandom(0,15) - 7;
            if(xSpeed == 0)
            xSpeed = generateRandom(0,15) - 7;
    }

    private static int generateRandom(int var1, int var2)
    {
        Random speed = new Random();
        return speed.nextInt((var1-var2) + 1) + var2;
    }
    
        /**
     * Draw this ball at its current position onto the canvas.
     **/
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
    
        public void move()
    {
        // erase at last known position
        erase();
            
        // calculate position
        yPos += ySpeed;
        xPos += xSpeed;
         // checks to see if wall collision was made
        if(yPos >= (ground - diameter)) {
            yPos = (int)(ground - diameter);
            ySpeed = ySpeed * -1;
        }
        if(yPos <= (roof)) {
            yPos = (int)(roof);
            ySpeed = ySpeed * -1;
        }
        if(xPos >= (rWall - diameter)) {
            xPos = (int)(rWall - diameter);
            xSpeed = xSpeed * -1;
        }
        if(xPos <= (lWall)) {
            xPos = (int)(lWall);
            xSpeed = xSpeed * -1;
        }
        
        //redraw at new position
        draw();
    }
    
    public int getXPos()
    {
        return xPos;
    }
    
    public int getDiameter()
    {
        return diameter;
    }
    
    public int getYPos()
    {
        return yPos;
    }
}
