import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ContactCard card = new ContactCardImpl();
        // card.gender = 'M';
        // System.out.println(card.isWoman());
        // String stri = "GENDER:M";
        // System.out.println(stri.charAt(stri.length()-1) == 'F');
        // card.telephon = new HashMap<String, String>();
        // String fn = "FN:Forrest Gump";
        // card.fullName = fn.split("[:]")[1];
        // System.out.println(card.getFullName());
        // String string = "TEL;TYPE=HOME,VOICE:4991112233";
        // card.telephon.put(string.split("[,;=:]")[2],string.split("[,;=:]")[4]);

        // card.bday = new GregorianCalendar(2020, 11, 1);
        //  System.out.println(card.getAgeYears());
        // // Scanner scanner = new Scanner(System.in);
        // // card = card.getInstance(scanner);
        // // System.out.println(card.getFullName());
        String data = "BEGIN:VCARD\nFN:Андрей Петров\nORG:Фриланс\nGENDER:M\nBDAY:24-11-1991\nTEL;TYPE=HOME,VOICE:4991112663\nTEL;TYPE=CELL,VOICE:4991112233\nEND:VCARD";
        ArrayList<String> phrases = new ArrayList<>();
        Scanner scanner = new Scanner(data);
        while (scanner.hasNext() == true ) {
            phrases.add(scanner.nextLine());
        }
        // System.out.println("ORG:Bubba Gump Shrimp Co.".matches("ORG:[A-Za-z ]\\.?"));
        // System.out.println("ORG:Фриланс".startsWith("ORG:"));

        card = card.getInstance(data);
        System.out.println(card.getBirthday());
        System.out.println(card.getAge());


       // <java.util.GregorianCalendar[time=690930000000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="GMT+03:00",offset=10800000,
    //    dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=1991,MONTH=10,WEEK_OF_YEAR=48,WEEK_OF_MONTH=5,DAY_OF_MONTH=24,
    //    DAY_OF_YEAR=328,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=4,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=0,ZONE_OFFSET=10800000,DST_OFFSET=0]>
        
}
}