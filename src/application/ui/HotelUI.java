/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.ui;

import application.ui.implement.MenuUI;
import application.validate.Validate;
import business_layer.config.CommonConfig;
import business_layer.entities.Hotel;
import business_layer.servicies.IService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class represents the UI for managing hotels. It provides CRUD fuction
 * for hotels.
 *
 * @author phuctrann
 */
public class HotelUI {

    IService<Hotel> service;

    /**
     * This Constructor with service layer
     *
     * @param service
     */
    public HotelUI(IService<Hotel> service) {
        this.service = service;

    }

    public void addingNewHotel() {
        try {
            Hotel hotel = new Hotel();
            hotel.input();

            service.create(hotel);
            System.out.println("Added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkingExistHotel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Update the information of a hotel in the system
     */
    public void updateHotel() {
        String id = Validate.getString("Enter ID you want to update", "Invalid ID! Try again", CommonConfig.REGEX_HOTEL_ID);
        Hotel hotelToUpdate = service.getById(id);

        try {
            if (hotelToUpdate != null) {
                Hotel newHotel = new Hotel();
                newHotel.input();

                service.update(hotelToUpdate, newHotel);
                System.out.println("Updated hotel information!");
                System.out.println(hotelToUpdate);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Delete hotel from the system
     */
    public void deleteHotel() {
        String id = Validate.getString("Enter ID you want to delete", "Invalid ID! Try again", CommonConfig.REGEX_HOTEL_ID);
        Hotel hotel = new Hotel();
        hotel.setId(id);

        try {
            if (MenuUI.confirm("delete this hotel")) {
                service.delete(hotel);
                System.out.println("Delete successful");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void displayAllHotel() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(CommonConfig.FORMAT_STIRNG_HOTEL + "\n",
                "Hotel_id", "Hotel_name", "Available", "Phone", "Rating", "Address");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------");
        service.printAll();
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void searchByHotelId() {
        String id = Validate.getString("Enter ID: ", "Invalid ID!!", CommonConfig.REGEX_HOTEL_ID);
        Hotel hotel = new Hotel();
        hotel.setId(id); //this object contains inputted ID
        List<Hotel> listFoundById = service.search(hotel, "id");

        if (listFoundById.isEmpty()) {
            System.out.println("Not found");

        } else {
            List<Hotel> listSort = new ArrayList<>(listFoundById);

            //sort the list
            Collections.sort(listSort, new Comparator<Hotel>() {
                @Override
                public int compare(Hotel o1, Hotel o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });

            //print the sorted list
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(CommonConfig.FORMAT_STIRNG_HOTEL + "\n",
                    "Hotel_id", "Hotel_name", "Available", "Phone", "Rating", "Address");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Hotel hotel1 : listSort) {
                System.out.println(hotel1);
            }
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    public void searchByHotelName() {
        
        String name = Validate.getString("Enter hotel name ", "Invalid name", CommonConfig.REGEX_STRING);
        Hotel hotel = new Hotel();
        hotel.setName(name);
        
        //create a list of
        List<Hotel> listFoundName = service.search(hotel, "name");
        
        if (listFoundName.isEmpty()){
            System.out.println("Not found");
        } else {
           
             //print the sorted list
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(CommonConfig.FORMAT_STIRNG_HOTEL + "\n",
                    "Hotel_id", "Hotel_name", "Available", "Phone", "Rating", "Address");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------------");
            
            for (Hotel hotel1 : listFoundName) {
                System.out.println(hotel1);
            }
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------------");

     
        }
        
    }

}
