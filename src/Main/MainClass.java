package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Андрей on 19.09.2014.
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
        String inString = inputStream.readLine();
        System.out.println(AlgoWithString.getStringPosFromSequence(inString));
    }
}
