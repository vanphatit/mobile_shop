/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mobileshop.dao;

import java.util.ArrayList;

/**
 *
 * @author phatlee
 */
public interface IDAO<T> {
    public int insert(T t);

    public int update(T t);

    public int delete(T t);

    public ArrayList<T> selectAll();

    public T selectById(String t);
    
    public T selectbyId(String t, String tt);
}
