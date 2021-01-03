package com.rph.lessons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AlohaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // I want to test that the output from the program is correct. Need to redirect the IO at the System level
    // This is painful, complex, and fragile.
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void simple() {
        // A mock class is a stub. All of MyScanner's methods will exist and work, but by default they do the simplest thing
        // possible: typically return a 0, a false, or null pointer.

        MyScanner scanner1 = mock(MyScanner.class);
        MyScanner scanner2 = mock(MyScanner.class);

        // So we need to teach the mock class what to do. Here we are telling it: The first time nextLine()
        // is called return "alohoha", and the second time nextLine() is called return "lolola".
        when(scanner1.nextLine())
                .thenReturn("alohoha")
                .thenReturn("lolola");

        // Teach the other mock to return "y" and then "n".

        when(scanner2.next())
                .thenReturn("y")
                .thenReturn("n");

        // run to the test.
        Aloha aloha = new Aloha();
        aloha.execute(scanner1, scanner2);

        String expected = String.join(System.lineSeparator(),
                "Enter a Hawaiian word to pronounce",
                "alohoha is pronounced ah-loh-hoh-hah",
                "Do you want to enter another word? y/Y/n/N",
                "Enter a Hawaiian word to pronounce",
                "lolola is pronounced loh-loh-lah",
                "Do you want to enter another word? y/Y/n/N",
                ""
        );


//        originalOut.println("------------------------------");
//        originalOut.println("Expected: " + expected);
//        originalOut.println("------------------------------");
//
//        String actual = outContent.toString();
//        originalOut.println("Actual: " + actual);
//        originalOut.println("------------------------------");

        assertEquals(expected, outContent.toString());
    }

}
