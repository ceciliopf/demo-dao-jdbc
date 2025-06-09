/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author Felipe
 */
public class DbException extends RuntimeException {
    
    private static final long serialVersionUID=1l;
    
    public DbException(String msg){
        super(msg);
    }
    
    
}
