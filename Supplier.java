package warehouse_management;
import java.io.Serializable;




public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    private String supplierId;
    private String supplierName;
    private String phoneNumber;
    private String email;
    private String address;

    // Constructor
    public Supplier(String supplierId, String supplierName,
                    String phoneNumber, String email,
                    String address) {

        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    // Getters

    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // Setters

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Display Supplier

    @Override
    public String toString() {

        return "\nSupplier ID : " + supplierId
                + "\nSupplier Name : " + supplierName
                + "\nPhone Number : " + phoneNumber
                + "\nEmail : " + email
                + "\nAddress : " + address;
    }

}