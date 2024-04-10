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
import java.util.ArrayList;

/**
 *
 * @author phuctrann
 */
public class Menu extends ArrayList<String> implements IMenu {

    IService<Hotel> service;

    @Override
    public void addItem(String item) {
        this.add(item);
    }

    @Override
    public int getChoice() {
        return Validate.getInteger("Enter your choice", "Choice must be digits", 1, 10);
    }

    /**
     * Display the menu to user
     */
    @Override
    public void showMenu() {
        System.out.println("-----------MENU---------");
        for (String item : this) {
            System.out.println(item);
        }
        System.out.println("------------------------");

    }

    /**
     * Add the option to the menu
     */
    public void addOptions() {
        addItem("--1. Adding new Hotel");
        addItem("--2. Checking exsisting Hotel");
        addItem("--3. Updating Hotel information");
        addItem("--4. Deleting Hotel");

        addItem("--5. Searching Hotel");
        addItem("--  5.1. Searching by Hotel_id");
        addItem("--  5.2. Searching by Hotel_name");

        addItem("--6. Displaying a hotel list (desc name)");
        addItem("--7. Others Quit");
    }

    /**
     * run hotel management when user choose options
     */
    public void processHotel() {
        HotelUI hotelUI = new HotelUI(service);
        do {
            int choice = getChoice();

            switch (choice) {

                case 1:
                   
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    int searchChoice = getChoice();

                    switch (searchChoice) {
                        case 1:
                            //search by id method
                            break;

                        case 2:
                            //search by name
                            break;
                        default:
                            System.out.println("Invalid search choice");
                            break;
                    }
                    break;
                case 6:

                    break;
                case 7:

                    break;

                default:
                    throw new AssertionError();
            }
        } while (true);

    }

    public static boolean confirm(String message) {
        message = String.format("Do you really want to %s (Y/N)", message);
        String confirm = Validate.getString(message, "Invalid input! Please try again", CommonConfig.REGEX_YN);

        if (confirm.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }

    }

}
