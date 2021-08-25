package Lesson1;

import java.util.*;

public class Team
{
        private String nameTeam = "unknown";
        Animal[] zoo = {new Cat("Барсик "), new Turtle("Наташка "), new Wolf("Волк ")};

        public Animal[] teamAnimal = new Animal[4];
        Random random = new Random();

        public Team(String nameTeam)
        {
            this.nameTeam = nameTeam;
            for(int i = 0; i < 4; i++){
                int ran = random.nextInt(3);
                teamAnimal[i] = zoo[ran];
            }
        }

        public void printInformationAboutTheTeam()
        {
            System.out.println("Команда: " + nameTeam);
            for(Animal a : teamAnimal) {
                System.out.println(a);
                System.out.println("Ограничение по бегу: " + a.run_limit);
                if (a instanceof Swim)
                    System.out.println("Ограничение по плаванию: " + ((Swim) a).getSwimLimit());
                if (a instanceof Jump)
                    System.out.println("Ограничение по прыжку: " + ((Jump) a).getJumpLimit());
            }
            System.out.println();
        }

        public void passedTheDistance()
        {
            System.out.println(nameTeam + "\n");
            for (Animal a : teamAnimal)
            {
                if(a.passing)
                {
                    System.out.println(a + ": трасса пройдена успешно.\n");
                }
                else
                {
                    System.out.println(a + ": к сожалению трасса не пройдена.\n");
                }
            }
            System.out.println();
        }
}
