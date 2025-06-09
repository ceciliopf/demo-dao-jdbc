/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import db.DB;
import db.DbException;
import java.sql.*;
import java.util.List;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/**
 *
 * @author Felipe
 */
public class SellerDaoJDBC implements SellerDao{
    
    private Connection conn;
    
    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Seller obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT seller.*,department.Name as DepName " +
                                       "FROM seller INNER JOIN department " +
                                       "ON seller.DepartmentId = department.Id " +
                                       "where seller.Id = ?");     
            
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()){
                Department dep = new Department();
               dep.setId(rs.getInt("DepartmentId"));
               dep.setName(rs.getString("DepName"));
               
               Seller seller = new Seller();
               seller.setId(rs.getInt("Id"));
               seller.setName( rs.getString("Name"));
               seller.setEmail(rs.getString("Email"));
               seller.setBaseSalary(rs.getDouble("BaseSalary"));
               seller.setBirthDate(rs.getDate("BirthDate"));
               seller.setDepartment(dep);
               
               return seller;
            }
            return null;   
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        
        
    }

    @Override
    public List<Seller> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
