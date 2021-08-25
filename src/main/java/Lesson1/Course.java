package Lesson1;

import java.util.*;

public class Course
{
    Let[] let = new Let[3];
    Random random = new Random();

    public Course()
    {
        Track track = new Track(random.nextInt(100));
        Wall wall = new Wall(random.nextFloat() * 10);
        Water water = new Water(random.nextInt(25));
        let[0] = (Let) track;
        let[1] = (Let) wall;
        let[2] = (Let) water;
    }

    public void printInformationAboutTheObstacle()
    {
        System.out.println("Длинна трассы: " + ((Track) let[0]).getLength());
        System.out.println("Высота стены: " + ((Wall) let[1]).getHeight());
        System.out.println("Длинна бассейна: " + ((Water) let[2]).getLength());
        System.out.println();
    }

    public void passObstacles(Team team)
    {
        for(Animal animal : team.teamAnimal)
        {
            for(Let l : let)
            {
                if(!l.doIt(animal))
                {
                    animal.setPassing(l.doIt(animal));
                    break;
                }
                animal.setPassing(true);
            }
        }
    }
}
