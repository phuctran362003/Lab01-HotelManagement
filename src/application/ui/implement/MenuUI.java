/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.ui.implement;

import application.ui.HotelUI;
import application.ui.IMenu;
import application.validate.Validate;
import business_layer.config.CommonConfig;
import business_layer.entities.Hotel;
import business_layer.servicies.IService;
import business_layer.servicies.implement.HotelService;
import java.util.ArrayList;

/**
 *
 * @author phuctrann
 */
public class MenuUI extends ArrayList<String> implements IMenu {

    IService<Hotel> service;

    /**
     * Constructs a Menu object and initializes the service with a new instance
     * of HotelService.
     */
    public MenuUI() {
        this.service = new HotelService();
    }

    /**
     * Adds a menu item to the menu.
     *
     * @param item the menu item to be added
     */
    @Override
    public void addItem(String item) {
        this.add(item);
    }

    /**
     * Gets the user's choice by prompting for input.
     *
     * @return the user's choice as an integer
     */
    @Override
    public int getChoice() {
        return Validate.getInteger("Enter your choice: ", "Choice must be digits", 1, 10);
    }

    /**
     * Displays the menu to the user.
     */
    @Override
    public void showMenu() {
        System.out.println("------------------- MENU -------------------");

        for (String item : this) {
            System.out.println(item);
        }
        System.out.println("--------------------------------------------");
    }

    /**
     * Adds the options to the menu.
     */
    public void addOptions() {
        addItem("1) Adding new Hotel");
        addItem("2) Checking exits Hotel");
        addItem("3) Updating Hotel information");
        addItem("4) Deleting Hotel");
        addItem("5) Searching Hotel");
        addItem("   5.1) Searching by Hotel_id");
        addItem("   5.2) Searching by Hotel_name");
        addItem("6) Displaying a hotel list (descending by Hotel_Name)");
        addItem("7) Others Quit");
    }

    /**
     * Processes the hotel management operations based on the user's choice.
     */
    public void processHotel() {
        HotelUI hotelUI = new HotelUI(service);
        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    // Code for adding new Hotel
                    hotelUI.addingNewHotel();
                    break;
                case 2:
                    // Code for checking existing Hotel
                    hotelUI.checkingExistHotel();
                    break;
                case 3:
                    // Code for updating Hotel information
                    hotelUI.updateHotel();
                    break;
                case 4:
                    // Code for deleting Hotel
                    hotelUI.deleteHotel();
                    break;
                case 5:
                    // Code for searching Hotel
                    int searchChoice = getChoice();

                    switch (searchChoice) {
                        case 1:
                            // Code for searching by Hotel_id
                            hotelUI.searchByHotelId();
                            break;
                        case 2:
                            // Code for searching by Hotel_name
                            hotelUI.searchByHotelName();

                            break;
                        default:
                            System.out.println("Invalid search choice");
                            break;
                    }
                    break;
                case 6:
                    // Code for displaying a hotel list
                    hotelUI.displayAllHotel();
                    break;
                case 7:
                    // Code for other options
                    if (confirm("exit")) {
                        System.out.println("THANK YOU FOR USING OUR APP!!");
                        System.exit(0);
                    } else {
                        break;
                    }

            }
        }
    }

    /**
     * Confirms the user's action by prompting for input.
     *
     * @param message the confirmation message
     * @return true if the user confirms, false otherwise
     */
    public static boolean confirm(String message) {
        message = String.format("Do you really want to %s? (Y/N): ", message);
        String confirm = Validate.getString(message, "Invalid input. Please enter Y or N.", CommonConfig.REGEX_YN);

        if (confirm.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }
}
