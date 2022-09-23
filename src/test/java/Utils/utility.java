package Utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

@Slf4j
public final class utility {

    public utility(){}

    public static String generateRandomString(int stringLength) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() <= stringLength) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.toString().toLowerCase();
    }

    public static String generatePassString(int stringLength) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$_&";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() <= stringLength) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.toString().toLowerCase();
    }

    public static String generateRandomNumber(int stringLength) {
        String chars = "1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() <= stringLength) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.toString().toLowerCase();
    }
}
