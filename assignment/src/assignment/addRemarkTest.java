package assignment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class addRemarkTest {

    private Prescription prescription;



    @Test
    public void testValidRemark() {
        // Test Data 1
        assertTrue(prescription.addRemark("The client is satisfied with the Eye wear", "Client"));

        // Test Data 2
        assertTrue(prescription.addRemark("Everything is looking good", "Optometrist"));
    }

    @Test
    public void testRemarkTooShort() {
        // Test Data 1: Remark too short
        assertFalse(prescription.addRemark("Too short", "Optometrist"));

        // Test Data 2: Another short remark
        assertFalse(prescription.addRemark("Overall good", "Client"));
    }

    @Test
    public void testInvalidRemarkType() {
        // Test Data 1: Invalid category
        assertFalse(prescription.addRemark("Prescription needs an adjustment", "Guest"));

        // Test Data 2: Another invalid category
        assertFalse(prescription.addRemark("Needs adjustment", "Physician"));
    }

    @Test
    public void testInvalidFirstLetter() {
        // Test Data 1: First letter not uppercase
        assertFalse(prescription.addRemark("this is invalid", "Client"));

        // Test Data 2: Another invalid first letter
        assertFalse(prescription.addRemark("this needs checking", "Optometrist"));
    }

    @Test
    public void testExceedsRemarkCount() {
        // Add two valid remarks
        assertTrue(prescription.addRemark("This is the first remark", "Client"));
        assertTrue(prescription.addRemark("This is the second remark", "Optometrist"));

        // Test Data 1: Adding a third remark should fail
        assertFalse(prescription.addRemark("This is a third remark", "Client"));

        // Test Data 2: Another attempt to add a third remark
        assertFalse(prescription.addRemark("Trying another third remark", "Optometrist"));
    }

    @Test
    public void testValidRemarkAgain() {
        // Test Data 1: Valid remark for Client
        assertTrue(prescription.addRemark("Remark is valid for this entry", "Client"));

        // Test Data 2: Valid remark for Optometrist
        assertTrue(prescription.addRemark("All results are satisfactory", "Optometrist"));
    }
}


