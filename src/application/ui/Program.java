/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.ui;

import application.ui.implement.MenuUI;

/**
 *
 * @author phuctrann
 */
public class Program {
    public static void main(String[] args) {
        MenuUI menu = new MenuUI();
        
        //add options
        menu.addOptions();
        
        
        //process menu
        menu.processHotel();
        
        menu.showMenu();
    }
}
