package javaapplication1;

public class JavaApplication1 
{
    public static void main(String[] args) 
    {
        GeometricObject[] objects = {new Square(2), new Square()};
        for (int i = 0; i < objects.length; i++) 
        {
            System.out.println("Area is " + objects[i].getArea());
            if (objects[i] instanceof Colorable)
                ((Colorable)objects[i]).howToColor();
        }
    }
}

package javaapplication1;

public interface Colorable 
{
    public abstract void howToColor();
}

package javaapplication1;

abstract class GeometricObject 
{
    abstract double getArea();
}

class Square extends GeometricObject implements Colorable
{
    private double side;
    
    Square()
    {
        side = 0;
    }
    Square(double s)
    {
        side = s;
    }
    
    public double getSide()
    {
        return side;
    }
    public void setSide(double s)
    {
        side = s;
    }
    
    @Override
    public double getArea()
    {
        return side * side;
    }
    
    @Override
    public void howToColor()
    {
        System.out.println("Color all four sides");
    }
}
