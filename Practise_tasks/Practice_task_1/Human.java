import java.time.LocalDate;
import java.util.Scanner;
import java.util.GregorianCalendar;


public class Human {

    String name, surname;
    int age, day_birth, month_birth, year_birth;
    Adress adress;

    GregorianCalendar date = new GregorianCalendar(year_birth, month_birth-1, day_birth);

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

        public Adress() {

        }

        public Adress(int flat, int house, String street, String city, String country) {
            this.flat = flat;
            this.house = house;
            this.street = street;
            this.city = city;
            this.country = country;
        }
    }


    static void print_info(Human human) {
        System.out.println(human.name + " " + human.surname + ", date of birth: " + LocalDate.of(human.year_birth, human.month_birth, human.day_birth));
    }

    static void find_by_surname(String surname, Human[] humans) {
        int k = 0;
        for (int i=0; i<4; i++) {
            if (humans[i].surname.equals(surname)) {
                print_info(humans[i]);
                k++;
            }     
        }
        if (k == 0) {
            System.out.println("There is no such person here, you should choose one from this list:");
            for (int i=0; i<4; i++) {
                System.out.println(humans[i].surname);
            }
        }
    }

    static void find_by_adress(String country, String city, String street, int house, int flat , Human[] humans) {
        for (int i=0; i<4; i++) {
            if (humans[i].adress.country.equals(country) && humans[i].adress.city.equals(city) && humans[i].adress.street.equals(street) && humans[i].adress.house == house && humans[i].adress.flat == flat) {
                System.out.println(humans[i].surname);
            } 
        }
    }

    static void find_by_date(GregorianCalendar date1, GregorianCalendar date2, Human[] human) {
        for (int i=0; i<4; i++) {
            
        }
        
    }

    static void find_by_age(String args, Human[] humans) {
        int min = 100;
        int max = 0;
        int index = 0;
        if (args.equals("youngest")) {
            for (int i=0; i<4; i++) {
                if (humans[i].age < min) {
                    min = humans[i].age;
                    index = i;
                }
            }
            System.out.print("The youngest: ");
            print_info(humans[index]);
        } if (args.equals("oldest")) {
            for (int i=0; i<4; i++) {
                if (humans[i].age > max) {
                    max = humans[i].age;
                    index = i;
                }
            }
            System.out.print("The oldest: ");
            print_info(humans[index]);
        }
    }

    static void find_by_street(String street, Human[] humans) {
        for (int i=0; i<4; i++) {
            if (humans[i].adress.street.equals(street)) {
                System.out.println(humans[i].surname);
            } 
        }
    }


    public static void main(String[] args) {

        Human[] humans = new Human[4];

        humans[0] = new Human("Sara", "Har", 22, 12, 1, 1999);
        humans[1] = new Human("Artem", "Atepalikhin", 21, 29, 4, 2000);
        humans[2] = new Human("Alexandrov", "Alexandr", 16, 20, 4, 2005);
        humans[3] = new Human("Diana", "Chikan", 19, 4, 8, 2001);

        humans[0].adress = humans[0].new Adress(7, 30, "Pervomayskaya", "Dolgoprudny", "Russia");
        humans[1].adress = humans[1].new Adress(34, 2, "Pervomayckaya", "Dolgoprudny", "Russia");
        humans[2].adress = humans[2].new Adress(4, 25, "Popova", "Surgut", "Russia");
        humans[3].adress = humans[3].new Adress(14, 20, "Lenina", "Kiknur", "Russia");

        System.out.print("Enter a surname to find: ");
        Scanner in  = new Scanner(System.in);
        String entered_surname = in.next();
        find_by_surname(entered_surname, humans);

        System.out.println("Youngest or oldest human you want to know? ");
        String entered_answer = in.next();
        find_by_age(entered_answer, humans);

        System.out.println("Enter year of date 1: ");
        int year1 = in.nextInt();
        System.out.println("Enter month of date 1: ");
        int month1 = in.nextInt();
        System.out.println("Enter year of date 1: ");
        int day1 = in.nextInt();

        GregorianCalendar date1 = new GregorianCalendar(year1, month1-1, day1);

        System.out.println("Enter year of date 2: ");
        int year2 = in.nextInt();
        System.out.println("Enter month of date 2: ");
        int month2 = in.nextInt();
        System.out.println("Enter year of date 2: ");
        int day2 = in.nextInt();

        GregorianCalendar date2 = new GregorianCalendar(year2, month2-1, day2);

        


        in.close();
    
        

        
    }
}
