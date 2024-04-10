/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_layer;

/**
 *
 * @author phuctrann
 */
public interface IHotelDAO<Hotel> {

    //read data from file method
    void loadDataFromFile() throws Exception;

    //write data to file method
    void writeToFile() throws Exception;
}
