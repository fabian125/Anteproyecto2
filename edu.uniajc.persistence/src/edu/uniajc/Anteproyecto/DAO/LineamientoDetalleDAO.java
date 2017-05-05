/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.Anteproyecto.DAO;

import edu.uniajc.anteproyecto.interfaces.model.LineamientoDetalle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leon
 */
public class LineamientoDetalleDAO {

    private Connection DBConnection = null;

    public LineamientoDetalleDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }

    public LineamientoDetalle createLineamientoDetalle(int id, int idLineamiento, String descripcion, Double porcentaje, int corte, String creadoPor, Date creadoEn, String modificadoPor, Date modificadoEn) {
        try {
            LineamientoDetalle lineamientoDetalle = new LineamientoDetalle();
            lineamientoDetalle.setId(id);
            lineamientoDetalle.setIdLineamiento(idLineamiento);
            lineamientoDetalle.setDescripcion(descripcion);
            lineamientoDetalle.setPorcentaje(porcentaje);
            lineamientoDetalle.setCorte(corte);
            lineamientoDetalle.setCreadoPor(creadoPor);
            lineamientoDetalle.setCreadoEn(creadoEn);
            lineamientoDetalle.setModificadoPor(modificadoPor);
            lineamientoDetalle.setModificadoEn(modificadoEn);

            PreparedStatement ps = null;

            String SQL = "select SQ_TB_ROL.nextval ID from dual";
            ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            SQL = "insert into TB_MetodologiaDetalle( ID,ID_T_Metodologia,descripcion,porcentaje,corte,creadoPor,creadoEn,modificadoPor,modificadoEn) values(?,?,?,?,?,?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
            ps.setInt(1, lineamientoDetalle.getId());
            ps.setInt(2, lineamientoDetalle.getIdLineamiento());
            ps.setString(3, lineamientoDetalle.getDescripcion());
            ps.setDouble(4, lineamientoDetalle.getPorcentaje());
            ps.setInt(5, lineamientoDetalle.getCorte());
            ps.setString(6, lineamientoDetalle.getCreadoPor());
            ps.setDate(7, lineamientoDetalle.getCreadoEn());
            ps.setString(8, lineamientoDetalle.getModificadoPor());
            ps.setDate(9, lineamientoDetalle.getModificadoEn());
            ps.execute();

            //combo.setCodigo(id);            
            return lineamientoDetalle;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }

    public List<LineamientoDetalle> getLineamientoDetalleByLineamiento(int lineamiento) throws SQLException {
        ArrayList<LineamientoDetalle> list = new ArrayList<LineamientoDetalle>();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_MetodologiaDetalle where ID_T_Metodologia =" + lineamiento + " ";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LineamientoDetalle lineamientoDetalle = new LineamientoDetalle();

                lineamientoDetalle.setId(rs.getInt("ID"));
                lineamientoDetalle.setIdLineamiento(rs.getInt("ID_T_Metodologia"));
                lineamientoDetalle.setDescripcion(rs.getString("descripcion"));
                lineamientoDetalle.setPorcentaje(rs.getDouble("porcentaje"));
                lineamientoDetalle.setCorte(rs.getInt("corte"));
                lineamientoDetalle.setCreadoPor(rs.getString("creadoPor"));
                lineamientoDetalle.setCreadoEn(rs.getDate("creadoEn"));
                lineamientoDetalle.setModificadoPor(rs.getString("modificadoPor"));
                lineamientoDetalle.setModificadoEn(rs.getDate("modificadoEn"));

                list.add(lineamientoDetalle);
            }

            return list;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }

    public LineamientoDetalle getLineamientoDetalleById(int id) throws SQLException {

        LineamientoDetalle lineamientoDetalle = new LineamientoDetalle();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_MetodologiaDetalle where ID =" + id + " ";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                rs.first();

                lineamientoDetalle.setId(rs.getInt("ID"));
                lineamientoDetalle.setIdLineamiento(rs.getInt("ID_T_Metodologia"));
                lineamientoDetalle.setDescripcion(rs.getString("descripcion"));
                lineamientoDetalle.setPorcentaje(rs.getDouble("porcentaje"));
                lineamientoDetalle.setCorte(rs.getInt("corte"));
                lineamientoDetalle.setCreadoPor(rs.getString("creadoPor"));
                lineamientoDetalle.setCreadoEn(rs.getDate("creadoEn"));
                lineamientoDetalle.setModificadoPor(rs.getString("modificadoPor"));
                lineamientoDetalle.setModificadoEn(rs.getDate("modificadoEn"));

            }

            return lineamientoDetalle;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }

    public ArrayList<LineamientoDetalle> getLineamientosDetalle() {

        ArrayList<LineamientoDetalle> list = new ArrayList<LineamientoDetalle>();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_MetodologiaDetalle";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LineamientoDetalle lineamientoDetalle = new LineamientoDetalle();
                lineamientoDetalle.setId(rs.getInt("ID"));
                lineamientoDetalle.setIdLineamiento(rs.getInt("ID_T_Metodologia"));
                lineamientoDetalle.setDescripcion(rs.getString("descripcion"));
                lineamientoDetalle.setPorcentaje(rs.getDouble("porcentaje"));
                lineamientoDetalle.setCorte(rs.getInt("corte"));
                lineamientoDetalle.setCreadoPor(rs.getString("creadoPor"));
                lineamientoDetalle.setCreadoEn(rs.getDate("creadoEn"));
                lineamientoDetalle.setModificadoPor(rs.getString("modificadoPor"));
                lineamientoDetalle.setModificadoEn(rs.getDate("modificadoEn"));
                list.add(lineamientoDetalle);
            }

            return list;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }

    public boolean deleteLineamientoDetalle(int ID){
         try {
           

            PreparedStatement ps = null;

            String SQL = "delete * from TB_MetodologiaDetalle where ID =" +ID+" ";
            ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            ps = this.DBConnection.prepareStatement(SQL);

            return ps.execute();

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }
    }
    public boolean updateLineamientoDetalle(LineamientoDetalle lineamientoDetalle){
        try {
           

            PreparedStatement ps = null;
            
            String SQL = "update TB_MetodologiaDetalle set  ID_T_Metodologia = ?,descripcion=?,porcentaje=?,corte =?,creadoPor =?,creadoEn =?,modificadoPor=?,modificadoEn=? where ID = ?";
            ps = this.DBConnection.prepareStatement(SQL);
          
            ps.setInt(1, lineamientoDetalle.getIdLineamiento());
            ps.setString(2, lineamientoDetalle.getDescripcion());
            ps.setDouble(3, lineamientoDetalle.getPorcentaje());
            ps.setInt(4, lineamientoDetalle.getCorte());
            ps.setString(5, lineamientoDetalle.getCreadoPor());
            ps.setDate(6, lineamientoDetalle.getCreadoEn());
            ps.setString(7, lineamientoDetalle.getModificadoPor());
            ps.setDate(8, lineamientoDetalle.getModificadoEn());
             ps.setInt(9, lineamientoDetalle.getId());
            ps.execute();

            ps = this.DBConnection.prepareStatement(SQL);

            return ps.execute();

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
}