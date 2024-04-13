/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business_layer.servicies.implement;

import business_layer.entities.Hotel;
import business_layer.servicies.IService;
import data_layer.implement.HotelDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phuctrann
 */
public class HotelService implements IService<Hotel> {

    HotelDAO hotelDAO;

    public HotelService() {
        hotelDAO = new HotelDAO();
    }

    /**
     * Create new hotel
     *
     * @param hotel the hotel will be created
     * @throws Exception if hotel exist
     */
    @Override
    public void create(Hotel hotel) throws Exception {
        //find hotel by iD, if hotel exist, assign hotel to existHotel
        Hotel exsistHotel = getById(hotel.getId());

        //if hotel not existed -> add
        //if hotel exsited -> exception
        if (exsistHotel == null) {
            hotelDAO.addHotel(hotel);
        } else {
            throw new Exception("Hotel is already existed!");
        }
    }

    /**
     * Return a hotel by ID
     *
     * @param id The ID of the hotel to return
     * @return the hotel with inputted ID, or null if not found
     */
    @Override
    public Hotel getById(String id) {
        List<Hotel> hotels = hotelDAO.getHotelList();
        for (Hotel hotel : hotels) {
            if (hotel.getId().equalsIgnoreCase(id)) {
                return hotel;
            }
        }
        return null;
    }

    @Override
    public void delete(Hotel hotel) throws Exception {
        //check if hotel exits
        Hotel listHotel = getById(hotel.getId());
        if (listHotel != null) {
            hotelDAO.delete(listHotel);

        } else {
            throw new Exception("Not found");
        }

    }

    @Override
    public void printAll() {
        hotelDAO.loadDataFromFile();

        List<Hotel> hotels = hotelDAO.getHotelList();
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }
    }

    @Override
    public void update(Hotel hotelToUpdate, Hotel hotelInformation) throws Exception {
        //update hotel information

        //update hotelName
        //if user enter information, then update. If leave it blank, do nothing.
        if (!hotelInformation.getName().isEmpty()) {
            hotelToUpdate.setName(hotelInformation.getName());
        }

        //update hotelRoomAvailable
        if (!Integer.toString(hotelInformation.getRoom_available()).isEmpty()) {
            hotelToUpdate.setRoom_available(hotelInformation.getRoom_available());
        }

        //update hotelPhoneNumber
        if (hotelInformation.getPhone().isEmpty()) {
            hotelToUpdate.setPhone(hotelInformation.getPhone());

        }

        //update hotelAddress
        if (hotelInformation.getAddress().isEmpty()) {
            hotelToUpdate.setAddress(hotelInformation.getAddress());

        }

        hotelDAO.writeToFile();
    }

    @Override
    public List<Hotel> search(Hotel hotel, String attribute) {
        List<Hotel> listFound;
        //tùy theo thuộc tính muốn search là gì mà chuyển tới trường hợp đó
        switch (attribute) {
            case "id":
                listFound = hotelDAO.findById(hotel.getId());
                break;
            case "name":
                listFound = hotelDAO.findByName(hotel.getName());
                break;
            default:
                listFound = new ArrayList<>();
                break;
        }
        return listFound;
    }

}
