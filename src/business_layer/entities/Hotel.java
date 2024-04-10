/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business_layer.entities;

import application.validate.Validate;
import business_layer.config.CommonConfig;

/**
 *
 * @author phuctrann
 */
public class Hotel {

    private String id;
    private String name;
    private int room_available;
    private String address;
    private String phone;
    private int rating;

    public Hotel() {
    }

    public Hotel(String id, String name, int room_available, String address, String phone, int rating) {
        this.id = id;
        this.name = name;
        this.room_available = room_available;
        this.address = address;
        this.phone = phone;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoom_available() {
        return room_available;
    }

    public void setRoom_available(int room_available) {
        this.room_available = room_available;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void input() {
        //input ID
        String id = Validate.getString("Enter hotel ID", "Invalid ID! Please try again", CommonConfig.REGEX_HOTEL_ID);
        setId(id);

        //input hotel Name
        String name = Validate.getString("Enter hotel name: ",
                "Invalid name! Please try again", ".*");
        setName(name);

        //input availabel room
        int roomAvailable = Validate.getInteger("Enter number of available room: ",
                "Invalid number. Please enter a positive integer", 1, Integer.MAX_VALUE);
        setRoom_available(room_available);

        //input address
        String address = Validate.getString("Enter hotel address: ",
                "Invalid address! Please try again", ".*");
        setAddress(address);

        //input phone
        String phone = Validate.getString("Enter hotel phone number",
                "Invalid phone number. Please try again! ", CommonConfig.REGEX_PHONE);
        setPhone(phone);

        //input rating
        int rating = Validate.getInteger("Enter hotel rating", "Invalid rating. Please a number between 1 and 5", 1, 5);
        setRating(rating);
    }

    @Override
    public String toString() {
        return String.format(CommonConfig.FORMAT_STIRNG_HOTEL, id, name, room_available, address, phone, rating);
    }

}
