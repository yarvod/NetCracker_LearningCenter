// package ru.skillbench.tasks.text ;

import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.HashMap;
import java.time.ZoneId;
import java.util.ArrayList;

public class ContactCardImpl implements ContactCard {
    
    String fullName;
    String organization;
    char gender;
    Calendar bday = Calendar.getInstance(TimeZone.getTimeZone("GMT+03:00"));
    HashMap <String, String> telephon = new HashMap<String, String>();

    public ContactCardImpl(){}

    public ContactCard getInstance(Scanner scanner){
        //ContactCardImpl contactcard = new ContactCardImpl();

        ArrayList<String> phrases = new ArrayList<>();
        while (scanner.hasNext() == true ) {
            phrases.add(scanner.nextLine());
        }

        if ((!phrases.get(phrases.size()-1).equals("END:VCARD")) || (!phrases.get(0).equals("BEGIN:VCARD"))) {
            throw new NoSuchElementException();
        }

        int i=1;

        // рассматриваем 1-е обязательное поле - FN
        if (phrases.get(i).startsWith("FN")) {
        if( !phrases.get(i).startsWith("FN:")){
            throw new InputMismatchException();
        }
        this.fullName = phrases.get(i).split("[:]")[1];
        i++;
        } 
        else {
            throw new NoSuchElementException();
        }
        
        //ORG
        if (phrases.get(i).startsWith("ORG")) {
            if( !phrases.get(i).startsWith("ORG:")){
            throw new InputMismatchException();
        }
        this.organization = phrases.get(i).split("[:]")[1];
        i++;
        }
        else {
            throw new NoSuchElementException();
        }

        //GENDER
        if (phrases.get(i).startsWith("GENDER")) {
        if( phrases.get(i).startsWith("GENDER:") && (phrases.get(i).charAt(phrases.get(i).length()-1) == 'F' || phrases.get(i).charAt(phrases.get(i).length()-1) == 'M')){
            this.gender = phrases.get(i).charAt(phrases.get(i).length()-1);
            i++;
        } else {
            throw new InputMismatchException();
        }
        }

        //BDAY
        if( phrases.get(i).startsWith("BDAY")){
        if( phrases.get(i).matches("BDAY:\\d{2}-\\d{2}-\\d{4}")){
            bday.clear();
            bday.set(Calendar.YEAR, Integer.valueOf(phrases.get(i).split("[:-]")[3]));
            bday.set(Calendar.MONTH, Integer.valueOf(phrases.get(i).split("[:-]")[2]) - 1);
            bday.set(Calendar.DAY_OF_MONTH, Integer.valueOf(phrases.get(i).split("[:-]")[1]));
            bday.get(0);
            i++;
        } else {
            throw new InputMismatchException();
        }
        }

        //TEL
        while (phrases.get(i).startsWith("TEL")) {
            if (phrases.get(i).matches("TEL;TYPE=[A-Z]+,VOICE:\\d{10}") ) {
                this.telephon.put(phrases.get(i).split("[,;=:]")[2],phrases.get(i).split("[,;=:]")[4]);
                i++;
            } else {
                throw new InputMismatchException();
            }
        }
        return this;
    };

    public ContactCard getInstance(String data){
        Scanner scanner = new Scanner(data);
        return  getInstance(scanner);
    };

    public String getFullName() {
        return this.fullName;
    }

    public String getOrganization(){
        return this.organization;
    }

    public boolean isWoman() {

        if (this.gender =='F') {
            return true;
        }
        else {
            return false;
        }
    }

    public Calendar getBirthday(){
        if (this.bday == null) {
            throw new NoSuchElementException();
        }
        return bday;
    }

    public Period getAge(){
        if (this.bday == null) {
            throw new NoSuchElementException();
        }
        Date input = this.bday.getTime();
        LocalDate localdate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(localdate, LocalDate.now());
    }



    public int getAgeYears(){
        if (this.bday == null) {
            throw new NoSuchElementException();
        }
        return this.getAge().getYears();
    }

    public String getPhone(String type) {

        if( telephon.get(type) == null) {
            throw new NoSuchElementException();
        }
        else {
            return telephon.get(type).replaceFirst("(\\d{3})(\\d{3})(\\d{4})","($1) $2-$3");
        }   
    }
}