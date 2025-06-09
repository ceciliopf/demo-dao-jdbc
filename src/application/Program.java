/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

/**
 *
 * @author Felipe
 */
public class Program {
    public static void main(String[] args) {

        
        SellerDao sellerDao = DaoFactory.createSellerDao();
   
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        
        
    }
}