/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business_layer.servicies;

/**
 *
 * @author phuctrann
 */
public interface IService<T> {

    void create(T object) throws Exception;

    T getById(String id);

    void search();

    void update(T object, T objectInfo) throws Exception;

    void delete(T object) throws Exception;

    void printAll();
}
