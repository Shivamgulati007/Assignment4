package assignment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class addPrescriptionTest {

    private Prescription prescription;

    @Test
    public void testValidPrescription() {
        // Test Data 1
        prescription = new Prescription("John", "Cena", "123 Bourke St, Melbourne, Australia", -1.5f, -2.0f, 90, new Date(), "Mark Henry");
        assertTrue(prescription.addPrescription());

        // Test Data 2
        prescription = new Prescription("Jane", "William", "456 Flinders St, Sydney, Australia", +1.5f, +2.0f, 100, new Date(), "Mary Jane");
        assertTrue(prescription.addPrescription());
    }

    @Test
    public void testInvalidFirstName() {
        // Test Data 1: First name too short
        prescription = new Prescription("Ho", "Doe", "123 Little St, Melbourne, Australia", -1.5f, -2.0f, 90, new Date(), "Glenn Maxwell");
        assertFalse(prescription.addPrescription());

        // Test Data 2: First name too long
        prescription = new Prescription("AliceAlice", "Doe", "456 Bigger St, Sydney, Australia", +1.5f, +2.0f, 100, new Date(), "Opto Jane");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testInvalidAddress() {
        // Test Data 1: Address too short
        prescription = new Prescription("John", "Doe", "This St", -1.5f, -2.0f, 90, new Date(), "Opto Shiv");
        assertFalse(prescription.addPrescription());

        // Test Data 2: Another address too short
        prescription = new Prescription("Jane", "Smith", "Another Street", +1.5f, +2.0f, 100, new Date(), "Opto Jane");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testInvalidSphere() {
        // Test Data 1: Sphere too low
        prescription = new Prescription("John", "Doel", "123 Lonsdale St, Melbourne, Australia", -25.0f, -2.0f, 90, new Date(), "Opto John");
        assertFalse(prescription.addPrescription());

        // Test Data 2: Sphere too high
        prescription = new Prescription("Jane", "Alice", "456 City St, Sydney, Australia", +25.0f, +2.0f, 100, new Date(), "Opto Jane");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testInvalidCylinder() {
        // Test Data 1: Cylinder too low
        prescription = new Prescription("John", "Wright", "123 Swanston St, Melbourne, Australia", -1.5f, -5.0f, 90, new Date(), "Opto Kane");
        assertFalse(prescription.addPrescription());

        // Test Data 2: Cylinder too high
        prescription = new Prescription("Jane", "Thompson", "456 Particular St, Sydney, Australia", +1.5f, +5.0f, 100, new Date(), "Opto Jane");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testInvalidAxis() {
        // Test Data 1: Axis- high
        prescription = new Prescription("Johnny", "Deo", "123 Mcdonalds St, Melbourne, Australia", -1.5f, -2.0f, 200, new Date(), "Opto Kaby");
        assertFalse(prescription.addPrescription());

        // Test Data 2: Axis- high
        prescription = new Prescription("Jane", "Kevin", "456 Example St, Sydney, Australia", +1.5f, +2.0f, 190, new Date(), "Opto Davis");
        assertFalse(prescription.addPrescription());
    }
}
