/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business_layer.config;

/**
 *
 * @author phuctrann
 */
public class CommonConfig {

    /**
     * file name format
     */
    public static final String FILE_NAME = "Hotel.dat";

    /**
     * REgex for Hotel_id
     */
    public static final String REGEX_HOTEL_ID = "H\\d+";

    /**
     * regex pattern for available room number
     */
    public static final String REGEX_AVAILABLE_ROOM = "[1-9]\\d";

    /**
     * regex pattern for phone number
     */
    public static final String REGEX_PHONE = "\\d{10}";

    
    /**
     * regex pattern for yes/no inputs
     */
    public static final String REGEX_YN = "[YyNn]";
    
    /**
     * 
     */
    public static final String FORMAT_STIRNG_HOTEL ="%-10S | %-20S | %-10S | %-10S | %-10s | %s";

}
