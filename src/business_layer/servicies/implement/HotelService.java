/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business_layer.servicies.implement;

import business_layer.entities.Hotel;
import business_layer.servicies.IService;
import data_layer.implement.HotelDAO;
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
    public void delete(Hotel object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void printAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void search() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Hotel object, Hotel objectInfo) throws Exception {
        
    }

}
