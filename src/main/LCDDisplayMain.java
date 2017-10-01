package main;

import main.creators.DisplayDigitBuilder;
import main.creators.LCDDisplayBuilder;
import main.model.LCDDisplay;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class LCDDisplayMain {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String line;

        bufferedWriter.write("****************************************************\n");
        bufferedWriter.write("*Welcome to the 7 segment LCD display refactor tool*\n");
        bufferedWriter.write("****************************************************\n");
        bufferedWriter.write("\n");
        bufferedWriter.write("Please indicate the length of the segment and the number to transform.\n");
        bufferedWriter.write("Input may consist of several lines, the format for each line is {num1},{num2}.\n");
        bufferedWriter.write("num1 may be any natural number in [1,10], num2 can be any positive whole number.\n");
        bufferedWriter.write("All incorrect inputs will be ignored, and a corresponding error message will be shown.\n");
        bufferedWriter.write("Inut end will be marked by a line containing \"0,0\".\n");
        bufferedWriter.flush();

        while (true) {

            line = bufferedReader.readLine();

            if (validInput(line)) {

                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");

                String s_segmentLength = stringTokenizer.nextToken();
                int segmentLength = Integer.parseInt(s_segmentLength);

                String number = stringTokenizer.nextToken();

                LCDDisplayBuilder lcdDisplayBuilder = new LCDDisplayBuilder();
                lcdDisplayBuilder.createLCDDisplay(number, segmentLength);

                for (char digit : number.toCharArray()) {

                    DisplayDigitBuilder displayDigitBuilder = new DisplayDigitBuilder();
                    displayDigitBuilder.createDigit(Character.getNumericValue(digit), segmentLength);

                    for (char segment : displayDigitBuilder.getDisplayDigit().getSegments()) {

                        displayDigitBuilder.buildSegment(segment);

                    }

                    lcdDisplayBuilder.buildDigit(displayDigitBuilder.getDisplayDigit());

                }

                printLCDScreen(lcdDisplayBuilder.getLcdDisplay());

            } else if (line.equals("0,0")) {
                break;
            } else {
                continue;
            }

            bufferedWriter.write("\n");

        }

        bufferedWriter.close();
        bufferedReader.close();

    }

    private static boolean validInput(String inputLine) throws IOException {

        if (inputLine == null) {
            bufferedWriter.write("Input line must not be null.\n");
            return false;
        }

        if (inputLine.trim().isEmpty()) {
            bufferedWriter.write("Input line must not be empty.\n");
            return false;
        }

        if (!inputLine.contains(",")) {
            bufferedWriter.write("Input line must be a comma separated pair of numbers.\n");
            return false;
        }

        String[] splitInput = inputLine.split(",");

        if (splitInput.length != 2) {
            bufferedWriter.write("Input line must be split by only one comma.\n");
            return false;
        }

        String left = splitInput[0];
        String right = splitInput[1];

        try {
            Integer.parseInt(left);
        } catch (NumberFormatException nfe) {
            bufferedWriter.write("Left number (segment length) must be a number.\n");
            return false;
        }

        try {
            new BigInteger(right, 10);
        } catch (NumberFormatException nfe) {
            bufferedWriter.write("Right number (number to display) must be a number.\n");
            return false;
        }

        int leftNumber = Integer.parseInt(left);
        if (leftNumber > 10 || leftNumber < 1) {
            if (!right.equals("0")) {
                bufferedWriter.write("Left number (segment length) must be a number in [1,10].\n");
            }
            return false;
        }

        BigInteger rightNumber = new BigInteger(right);
        if (rightNumber.compareTo(BigInteger.ZERO) < 0) {
            bufferedWriter.write("Right number (number to display) must be a positive number.\n");
            return false;
        }

        return true;

    }

    private static void printLCDScreen(LCDDisplay lcdDisplay) throws IOException {

        char[][] lcdMatrix = lcdDisplay.getScreenMatrix();

        for (int i = 0; i < lcdMatrix.length; i++) {

            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < lcdMatrix[0].length; j++) {

                stringBuilder.append(lcdMatrix[i][j]);

            }

            bufferedWriter.write(stringBuilder.toString() + "\n");

        }

    }

}
