/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.ui;

import business_layer.entities.Hotel;
import business_layer.servicies.IService;

/**
 *
 * @author phuctrann
 */
public class HotelUI {
    IService<Hotel> service;

    public HotelUI (IService<Hotel> service){
        this.service  = service;
    }
    
    
    
}
