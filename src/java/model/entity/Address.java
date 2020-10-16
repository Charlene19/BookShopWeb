package model.entity;

import java.io.Serializable;

public class Address  implements Serializable {

    private int id;
    private String companyName;
    private String lastName;
    private String firstName;
    private String street;
    private String streetExtra;
    private String postcode;
    private String city;
    private String phone;
    private String phoneExtra;

    //Constructeur
    public Address() {

    }

    public Address(int id, String companyName, String lastName, String firstName, String street, String streetExtra, String postcode, String city, String phone, String phoneExtra) {
        this.id = id;
        this.companyName = companyName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.streetExtra = streetExtra;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;
        this.phoneExtra = phoneExtra;

    }

    public Address(String companyName, String lastName, String firstName, String street, String streetExtra, String postcode, String city, String phone, String phoneExtra) {
        this.companyName = companyName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.streetExtra = streetExtra;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;
        this.phoneExtra = phoneExtra;
    }

    public Address(int id, String companyName, String lastName, String firstName, String street, String streetExtra, String postcode, String city, String phone) {
        this.id = id;
        this.companyName = companyName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.streetExtra = streetExtra;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;

    }

    //Getter et Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetExtra() {
        return streetExtra;
    }

    public void setStreetExtra(String streetExtra) {
        this.streetExtra = streetExtra;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneExtra() {
        return phoneExtra;
    }

    public void setPhoneExtra(String phoneExtra) {
        this.phoneExtra = phoneExtra;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", companyName=" + companyName + ", lastName=" + lastName + ", firstName=" + firstName + ", street=" + street + ", streetExtra=" + streetExtra + ", postcode=" + postcode + ", city=" + city + ", phone=" + phone + "phoneExtra=" + phoneExtra + '}';
    }

    public String toString1() {
        return "Address{" + "id=" + id + ", companyName=" + companyName + ", lastName=" + lastName + ", firstName=" + firstName + ", street=" + street + ", streetExtra=" + streetExtra + ", postcode=" + postcode + ", city=" + city + ", phone=" + phone + '}';
    }
}
