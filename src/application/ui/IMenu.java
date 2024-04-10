/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.ui;

/**
 *
 * @author phuctrann
 */
public interface IMenu {

    
    /**
     * add a menu item --> add text to menu
     * @param item 
     */
    void addItem( String item);

    /**
     * get user choice
     * @return user choice
     */
    int getChoice();

    
    
    /**
     * Show menu for user choice
     */
    void showMenu();
}
