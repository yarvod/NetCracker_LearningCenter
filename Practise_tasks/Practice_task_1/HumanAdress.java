import java.time.LocalDate;
import java.util.Scanner;

public class HumanAdress {

    class Human {
        String name, surname;
        int age, day_birth, month_birth, year_birth;

        public Human(String name, String surname, int age, int day_birth, int month_birth, int year_birth) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.day_birth = day_birth;
            this.month_birth = month_birth;
            this.year_birth = year_birth;
        }

        class Adress {
            int flat, house;
            String street, city, country;
    
            public Adress(int flat, int house, String street, String city, String country) {
                this.flat = flat;
                this.house = house;
                this.street = street;
                this.city = city;
                this.country = country;
            }
        }
    }

    static void print_human(Human human) {
        System.out.println("Human name/surname: " + human.name + " " + human.surname + ", date of birth: " + LocalDate.of(human.year_birth, human.month_birth, human.day_birth));
    }

    static void find_by_surname(String surname, Human[] humans) {
        int k = 0;
        for (int i=0; i<4; i++) {
            if (humans[i].surname == surname) {
                print_human(humans[i]);
                k++;
            }     
        }
        if (k == 0) {
            System.out.println("There is no such person here");
        }
    }

    static void find_age(String args, Human[] humans) {
        int min = 100;
        int max = 0;
        int index = 0;
        if (args == "youngest") {
            for (int i=0; i<4; i++) {
                if (humans[i].age < min) {
                    min = humans[i].age;
                    index = i;
                }
            }
            System.out.print("The youngest: ");
            print_human(humans[index]);
        } if (args == "oldest") {
            for (int i=0; i<4; i++) {
                if (humans[i].age > max) {
                    max = humans[i].age;
                    index = i;
                }
            }
            System.out.print("The oldest: ");
            print_human(humans[index]);
        }
    }


    public static void main(String[] args) {

        HumanAdress human_adress = new HumanAdress();
        Human[] humans = new Human[4];

        humans[0] = human_adress.new Human("Yulya", "Prokhorova", 20, 11, 7, 2001);
        humans[1] = human_adress.new Human("Artem", "Atepalikhin", 21, 29, 4, 2000);
        humans[2] = human_adress.new Human("Alexandrov", "Alexandr", 16, 20, 4, 2005);
        humans[3] = human_adress.new Human("Diana", "Chikan", 19, 4, 8, 2001);

        System.out.print("Enter a surname to find: ");
        Scanner in  = new Scanner(System.in);
        String entered_surname = in.next();
 
        find_by_surname(entered_surname, humans);

        System.out.println("youngest or oldest human you want to know? ");
        String entered_answer = in.next();
        find_age(entered_answer, humans);

        in.close();
    }
}
