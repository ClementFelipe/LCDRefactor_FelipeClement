package main;

import main.creators.DigitBuilder;
import main.creators.LCDScreenBuilder;
import java.io.*;
import java.util.StringTokenizer;

public class LCDDisplayMain {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        StringTokenizer stringTokenizer;

        String number;
        int segmentLength;

        LCDScreenBuilder lcdScreenBuilder;

        while (!(line = bufferedReader.readLine()).equals("0,0")) {

            stringTokenizer = new StringTokenizer(line, ",");

            String s_segmentLength = stringTokenizer.nextToken();
            segmentLength = Integer.parseInt(s_segmentLength);

            number = stringTokenizer.nextToken();

            lcdScreenBuilder = new LCDScreenBuilder();

            lcdScreenBuilder.createLCDScreen(number, segmentLength);

            for (char digit : number.toCharArray()) {

                DigitBuilder digitBuilder = new DigitBuilder();

                digitBuilder.createDigit(Character.getNumericValue(digit), segmentLength);

                for (char segment : digitBuilder.getDigit().getSegments()) {

                    digitBuilder.buildSegment(segment);

                }

                lcdScreenBuilder.buildDigit(digitBuilder.getDigit());

            }

            char[][] lcdMatrix = lcdScreenBuilder.getLcdScreen().getScreenMatrix();

            for (int i = 0; i < lcdMatrix.length; i++) {

                StringBuilder stringBuilder = new StringBuilder();

                for (int j = 0; j < lcdMatrix[0].length; j++) {

                    stringBuilder.append(lcdMatrix[i][j]);

                }

                bufferedWriter.write(stringBuilder.toString() + "\n");

            }

        }

        bufferedWriter.close();
        bufferedReader.close();

    }

}
