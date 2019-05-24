package javaapplication2;
public class JavaApplication2 
{
    public static void main( String [] args ) throws CloneNotSupportedException
    {
        AllInclusiveVacation aiv1 = new AllInclusiveVacation( "Bora Bora", 10000.00, "Four Seasons", 5,
                9000.50 );
        System.out.println( "The first all-inclusive vacation is:\n" + aiv1 );
        double money1 = aiv1.overBudget( );
        if ( money1 == 0.0 )
            System.out.println( "It is on budget" );
        else if ( money1 > 0.0 )
            System.out.printf( "It is over budget by %5.2f", money1 );
        else
            System.out.printf( "It is under budget by %5.2f", Math.abs(money1));
        AllInclusiveVacation aiv2 = new AllInclusiveVacation( "Bahamas", 2000.00, "ClubMed", 4, 2049.99 );
        System.out.println( "\nThe second all-inclusive vacation is:\n" + aiv2 );
        double money2 = aiv2.overBudget( );
        if ( money2 == 0.0 )
            System.out.println( "It is on budget" );
        else if ( money2 > 0.0 )
            System.out.printf( "It is over budget by %5.2f", money2 );
        else
            System.out.printf( "It is under budget by %5.2f", Math.abs(money2));
        AllInclusiveVacation aiv3 = (AllInclusiveVacation)aiv1.clone();
        System.out.println( "\nThe third all-inclusive vacation is:\n" + aiv3 );

        if ( aiv1.equals( aiv2 ) )
            System.out.println( "aiv1 and aiv2 are equal" );
        else
            System.out.println( "aiv1 and aiv2 are not equal" );
        if ( aiv1.equals( aiv3 ) )
            System.out.println( "aiv1 and aiv3 are equal" );
        else
            System.out.println( "aiv1 and aiv3 are not equal" );
    }
}

package javaapplication2;
public abstract class Vacation 
{
    protected String destination;
    protected double budget;
    
    Vacation(String d, double b)
    {
        destination = d;
        budget = b;
    }
    
    public String getDest()
    {
        return destination;
    }
    public void setDest(String d)
    {
        destination = d;
    }
    
    public double getBudget()
    {
        return budget;
    }
    public void setBudget(double b)
    {
        budget = b;
    }
    
    public abstract double overBudget();
    
    @Override
    public String toString()
    {
        return "Destination: " + destination + "\nBudget: $" + budget;
    }
    
    public boolean equals(Vacation v1)
    {
        if(budget == v1.budget && destination.equals(v1.destination))
            return true;
        return false;
    }
}

package javaapplication2;
public class AllInclusiveVacation extends Vacation implements Cloneable
{
    private String brand;
    private int rating;
    private double price;
    
    public AllInclusiveVacation(String dest, double budget, String brand, int rating, double price)
    {
        super(dest, budget);
        this.brand = brand;
        this.rating = rating;
        this.price = price;
    }
    
    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String b)
    {
        brand = b;
    }
    
    public int getRating()
    {
        return rating;
    }
    public void setRating(int r)
    {
        rating = r;
    }
    
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double p)
    {
        price = p;
    }
    @Override
    public double overBudget()
    {
        return price - budget;
    }
    @Override
    public String toString()
    {
        return "Destination: " + destination + "\nBudget: $" + budget +
                "\nBrand: " + brand + "\nRating: " + rating + "\nPrice: " + price;
    }
    
    public boolean equals(AllInclusiveVacation a1)
    {
        if(destination.equals(a1.destination) && budget == a1.budget && price == a1.price)
            return true;
        return false;
    }
    @Override 
    public Object clone() throws CloneNotSupportedException
    {
        return (AllInclusiveVacation)super.clone();
    }
}
