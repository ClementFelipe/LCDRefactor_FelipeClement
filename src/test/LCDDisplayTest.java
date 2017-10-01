package test;

import main.LCDDisplayMain;
import main.model.LCDDisplay;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LCDDisplayTest {

    public String[] inidividualDigitsScenario_Size1() {

        String inputLine = "1,1234567890";
        String correctOutput =
                "     -   -       -   -   -   -   -   - \n" +
                        "  |   |   | | | |   |     | | | | | | |\n" +
                        "     -   -   -   -   -       -   -     \n" +
                        "  | |     |   |   | | |   | | |   | | |\n" +
                        "     -   -       -   -       -       - \n";

        String[] scenario = new String[2];
        scenario[0] = inputLine;
        scenario[1] = correctOutput;

        return scenario;

    }

    public String[] inidividualDigitsScenario_Size10() {

        String inputLine = "10,1234567890";
        String correctOutput =
                "              ----------   ----------                ----------   ----------   ----------   ----------   ----------   ---------- \n" +
                        "           |            |            | |          | |            |                       | |          | |          | |          |\n" +
                        "           |            |            | |          | |            |                       | |          | |          | |          |\n" +
                        "           |            |            | |          | |            |                       | |          | |          | |          |\n" +
                        "           |            |            | |          | |            |                       | |          | |          | |          |\n" +
                        "           |            |            | |          | |            |                       | |          | |          | |          |\n" +
                        "           |            |            | |          | |            |                       | |          | |          | |          |\n" +
                        "           |            |            | |          | |            |                       | |          | |          | |          |\n" +
                        "           |            |            | |          | |            |                       | |          | |          | |          |\n" +
                        "           |            |            | |          | |            |                       | |          | |          | |          |\n" +
                        "           |            |            | |          | |            |                       | |          | |          | |          |\n" +
                        "              ----------   ----------   ----------   ----------   ----------                ----------   ----------              \n" +
                        "           | |                       |            |            | |          |            | |          |            | |          |\n" +
                        "           | |                       |            |            | |          |            | |          |            | |          |\n" +
                        "           | |                       |            |            | |          |            | |          |            | |          |\n" +
                        "           | |                       |            |            | |          |            | |          |            | |          |\n" +
                        "           | |                       |            |            | |          |            | |          |            | |          |\n" +
                        "           | |                       |            |            | |          |            | |          |            | |          |\n" +
                        "           | |                       |            |            | |          |            | |          |            | |          |\n" +
                        "           | |                       |            |            | |          |            | |          |            | |          |\n" +
                        "           | |                       |            |            | |          |            | |          |            | |          |\n" +
                        "           | |                       |            |            | |          |            | |          |            | |          |\n" +
                        "              ----------   ----------                ----------   ----------                ----------                ---------- \n";

        String[] scenario = new String[2];
        scenario[0] = inputLine;
        scenario[1] = correctOutput;

        return scenario;

    }

    @Test
    public void testDigits_Size1() {

        String[] scenario = inidividualDigitsScenario_Size1();

        String inputLine = scenario[0];
        String correctOutput = scenario[1];

        LCDDisplay lcdDisplay = LCDDisplayMain.createLCDDisplay(inputLine);

        StringBuilder output = new StringBuilder();

        char[][] screenMatrix = lcdDisplay.getScreenMatrix();

        for (int i = 0; i < screenMatrix.length; i++) {

            for (int j = 0; j < screenMatrix[0].length; j++) {

                output.append(screenMatrix[i][j]);

            }

            output.append("\n");

        }

        boolean equal = output.toString().equals(correctOutput);

        assertTrue("Output does not coincide with correct output.", equal);

    }

    @Test
    public void testDigits_Size10() {

        String[] scenario = inidividualDigitsScenario_Size10();

        String inputLine = scenario[0];
        String correctOutput = scenario[1];

        LCDDisplay lcdDisplay = LCDDisplayMain.createLCDDisplay(inputLine);

        StringBuilder output = new StringBuilder();

        char[][] screenMatrix = lcdDisplay.getScreenMatrix();

        for (int i = 0; i < screenMatrix.length; i++) {

            for (int j = 0; j < screenMatrix[0].length; j++) {

                output.append(screenMatrix[i][j]);

            }

            output.append("\n");

        }

        String outputString = output.toString();

        boolean equal = outputString.equals(correctOutput);

        assertTrue("Output does not coincide with correct output.", equal);

    }

}
