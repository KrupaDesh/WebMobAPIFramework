package com.rezolve;


import engine.constants.RandomDataTypes;
import net.datafaker.Faker;
import java.util.Random;

public class RandomGenerator {

    public static Faker faker = new Faker();
    static String alphaNumericWithFewSymbols= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
            +"lmnopqrstuvwxyz#,";
    static String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
            +"lmnopqrstuvwxyz";
    static String numbers= "0123456789";

    public static String getRandomAddress(int len){
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(alphaNumericWithFewSymbols.charAt(rnd.nextInt(alphaNumericWithFewSymbols.length())));
        return sb.toString();
    }

    public static String getRandomMobileNumberStartsWith98(){
        Random rnd = new Random();
        String mobileNumber= "98";
        for(int i=0;i<8;i++) {
            mobileNumber =mobileNumber+String.valueOf(rnd.nextInt(10));
        }
        return mobileNumber;
    }

    public static String getRandomText(int len){
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(alphabet.charAt(rnd.nextInt(alphabet.length())));
        return sb.toString();
    }

    public static String getRandomNumber(int len){
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(numbers.charAt(rnd.nextInt(numbers.length())));
        return sb.toString();
    }

    public static String getRandomDataFor(RandomDataTypes dataType)
    {
        switch (dataType){
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
            case FULLNAME:
                return faker.name().fullName();
            case COUNTRY:
                return faker.address().country();
            case CITYNAME:
                return faker.address().cityName();
            case EMAIL:
                return getRandomText(5) +"@mail.com";
            default:
                return "This data type is not available";

        }
    }
   public static String getRandomNumberfromFaker(int size)
    {
        return faker.number().digits(size);
    }

}
