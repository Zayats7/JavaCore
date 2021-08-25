package Lesson1;

public class Water implements Let
{
    private int length;

    public Water(int length)
    {
        this.length = length;
    }

    @Override
    public boolean doIt(Animal animal)
    {
        if (animal instanceof Swim)
            return ((Swim) animal).swim(length);
        else
            return false;
    }

    public int getLength()
    {
        return length;
    }
}
