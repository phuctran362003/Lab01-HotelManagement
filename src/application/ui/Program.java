/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.ui;

import application.ui.implement.Menu;

/**
 *
 * @author phuctrann
 */
public class Program {
    public static void main(String[] args) {
        Menu menu = new Menu();
        
        //add options
        menu.addOptions();
        
        
        //process menu
        menu.processHotel();
    }
}
