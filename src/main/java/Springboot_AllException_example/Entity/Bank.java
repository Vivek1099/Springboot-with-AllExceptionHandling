package Springboot_AllException_example.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity(name = "bankdetails")
public class Bank
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID",unique = true, nullable = false)
    int cid;

    @Column(name = "Customer_AccountNumber", nullable = false, unique = true)
    @NotNull(message = "Enter the Bank account number")
    @Pattern(regexp = "^[0-9]{9,18}$", message = "Please Enter the valid account number")
    String accno;

    @Column(name = "Customer_FirstName", nullable = false)
    @NotEmpty(message = "First Name cannot be blank")
    String fname;

    @Column(name = "Customer_LastName", nullable = false)
    @NotEmpty(message = "Last Name cannot be blank")
    String lname;

    @Column(name = "Customer_Address", nullable = false)
    @NotEmpty(message = "Address cannot be empty")
    String address;

    @Column(name = "Customer_Pincode", nullable = false)
    @NotNull(message = "Pincode cannot be empty")
    @Pattern(regexp = "^[0-9]{6}$", message = "Please enter valid pincode")
    String pincode;

    @Column(name = "Customer_Age",nullable = false)
    @NotNull(message = "Age should not be empty")
    @Min(18)
    int age;

    @Column(name = "Customer_Email",nullable = false)
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Enter valid Email")
    String email;

    @Column(name = "Customer_PhoneNumber", nullable = false, unique = true)
    @NotEmpty(message = "Phone Number should not be empty")
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Please enter valid phone number")
    String phoneno;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public @NotNull(message = "Enter the Bank account number") @Pattern(regexp = "^[0-9]{9,18}$", message = "Please Enter the valid account number") String getAccno() {
        return accno;
    }

    public void setAccno(@NotNull(message = "Enter the Bank account number") @Pattern(regexp = "^[0-9]{9,18}$", message = "Please Enter the valid account number") String accno) {
        this.accno = accno;
    }

    public @NotEmpty(message = "First Name cannot be blank") String getFname() {
        return fname;
    }

    public void setFname(@NotEmpty(message = "First Name cannot be blank") String fname) {
        this.fname = fname;
    }

    public @NotEmpty(message = "Last Name cannot be blank") String getLname() {
        return lname;
    }

    public void setLname(@NotEmpty(message = "Last Name cannot be blank") String lname) {
        this.lname = lname;
    }

    public @NotEmpty(message = "Address cannot be empty") String getAddress() {
        return address;
    }

    public void setAddress(@NotEmpty(message = "Address cannot be empty") String address) {
        this.address = address;
    }

    public @NotNull(message = "Pincode cannot be empty") @Pattern(regexp = "^[0-9]{6}$", message = "Please enter valid pincode") String getPincode() {
        return pincode;
    }

    public void setPincode(@NotNull(message = "Pincode cannot be empty") @Pattern(regexp = "^[0-9]{6}$", message = "Please enter valid pincode") String pincode) {
        this.pincode = pincode;
    }

    @NotNull
    @Min(18)
    public int getAge() {
        return age;
    }

    public void setAge(@NotNull @Min(18) int age) {
        this.age = age;
    }

    public @NotEmpty(message = "Email should not be empty") @Email(message = "Enter valid Email") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Email should not be empty") @Email(message = "Enter valid Email") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "Phone Number should not be empty") @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Please enter valid phone number") String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(@NotEmpty(message = "Phone Number should not be empty") @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Please enter valid phone number") String phoneno) {
        this.phoneno = phoneno;
    }
}
