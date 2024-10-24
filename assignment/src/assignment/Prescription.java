package assignment;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Prescription {
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private float axis;
    private Date examinationDate;
    private String optometrist;
    private ArrayList<String> remarks = new ArrayList<>();

    // Constructor Names
    public Prescription(String firstName, String lastName, String address, float sphere, float cylinder, float axis, Date examinationDate, String optometrist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
    }

    // Function to add a prescription information into a file if it satisfies the necessary criteria.
    public boolean addPrescription() {
        // Condition 1: First and last name validation
        if (firstName.length() < 4 || firstName.length() > 15 || lastName.length() < 4 || lastName.length() > 15) {
            return false;
        }

        // Condition 2: Address validation
        if (address.length() < 20) {
            return false;
        }

        // Condition 3: Validate sphere, axis, and cylinder ranges
        if (sphere < -20.00 || sphere > 20.00 || axis < 0 || axis > 180 || cylinder < -4.00 || cylinder > 4.00) {
            return false;
        }

        // Condition 4: Check on optometrist name (8 to 25 characters)
        if (optometrist.length() < 8 || optometrist.length() > 25) {
            return false;
        }

        // If all conditions are met, write the prescription to a file
        try (FileWriter writer = new FileWriter("presc.txt", true)) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
            String fDate = format.format(examinationDate);
            writer.write("First Name: " + firstName + "\n");
            writer.write("Last Name: " + lastName + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Sphere: " + sphere + "\n");
            writer.write("Cylinder: " + cylinder + "\n");
            writer.write("Axis: " + axis + "\n");
            writer.write("Optometrist: " + optometrist + "\n");
            writer.write("Examination Date: " + fDate + "\n");
            writer.write("--------------\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }




// Method to add a remark
public boolean addRemark(String remark, String category) {  
    // Condition 1: Remark should have 6 to 20 words
    String[] words = remark.split("\\s+");
    if (words.length < 6 || words.length > 20 || !Character.isUpperCase(remark.charAt(0))) {
        return false;
    }

    // Condition 2: The remark category has to be "Client" or "Optometrist"
    if (!category.equalsIgnoreCase("Client") && !category.equalsIgnoreCase("Optometrist")) {
        return false;
    }

    // Ensure that a prescription does not have more than 2 remarks
    if (remarks.size() >= 2) {
        return false; 
    }

    // Writing the remark to a file
    try (FileWriter writer = new FileWriter("remark.txt", true)) {
        writer.write("Category: " + category + "\n");
        writer.write("Remark: " + remark + "\n");
        writer.write("---------------------------------\n");
        remarks.add(remark);
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
}

