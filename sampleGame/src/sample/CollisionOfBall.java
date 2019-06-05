package sample;

import javafx.scene.shape.Circle;
import java.math.*;

public class CollisionOfBall
{

    //Member variables

    float Xboundary;
    float Yboundary;
    Circle ball;
    final float radius = 10;
    double velcity;
    double Vx, Vy, Px, Py;
    double angle, sinTheta, cosTheta;

    CollisionOfBall(float xLimit, float yLimit)
    {
        ball = new Circle();
        ball.setRadius(radius);
        ball.setCenterY(0+radius);
        ball.setCenterX(0+radius);

        Xboundary = xLimit;
        Yboundary = yLimit;

        Vx = 1;
        Vy = 1;
        velcity = Math.sqrt((Vx*Vx + Vy*Vy));

        angle = Math.tanh(Vy/Vx);
        sinTheta = Vy/velcity;
        cosTheta = Vx/velcity;
    }

    public Circle GetBall()
    {
        return ball;
    }

    public void SetSpeed(float speed)
    {
        velcity = speed;
        Vx = cosTheta*velcity;
        Vy = sinTheta*velcity;
    }

    public void update(double elapsedTime)
    {
        Px += Vx;
        Py += Vy;

        velcity = Math.sqrt((Vx*Vx + Vy*Vy));

        DetectCollision();

        ball.setCenterY(Py);
        ball.setCenterX(Px);
    }


    private void DetectCollision()
    {
        if(Px + radius >= Xboundary)
        {
            Px = Xboundary - radius;
            Vx *= -1;
        }
        else if(Px <= radius)
        {
            Px += radius;
            Vx *= -1;
        }

        if(Py + radius >= Yboundary)
        {
            Py = Yboundary - radius;
            Vy *= -1;
        }
        else if(Py <= radius)
        {
            Py += radius;
            Vy *= -1;
        }
    }
}
