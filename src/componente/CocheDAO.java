/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;

/**
 *
 * @author josegomez
 */
public class CocheDAO {

    private Vector<Coche> coches = new Vector<>();

    public CocheDAO() throws ClassNotFoundException {
        recargarFilas();
    }

    private void recargarFilas() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coches", "root", "1234");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from coches");
            while (rs.next()) {
                Coche c = new Coche(rs.getString("matricula"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("kilometros"),
                        rs.getInt("anoMatriculacion"));

                coches.add(c);
            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CocheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addCoche(Coche coche) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coches", "root", "1234");
            PreparedStatement s = con.prepareStatement("insert into coches values (?,?,?,?,?)");

            s.setString(1, coche.getMatricula());
            s.setString(2, coche.getMarca());
            s.setString(3, coche.getModelo());
            s.setInt(4, coche.getKilometros());
            s.setInt(5, coche.getAnoMatriculacion());

            s.executeUpdate();
            recargarFilas();
        } catch (SQLException ex) {
            Logger.getLogger(CocheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delCoche(String matricula) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coches", "root", "1234");
            PreparedStatement s = con.prepareStatement("delete from coches where matricula = ?");
            s.setString(1, matricula);
            System.out.println("Deleting car with matricula: " + matricula);
            int rowsAffected = s.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            recargarFilas();
        } catch (SQLException ex) {
            Logger.getLogger(CocheDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    // Getters y Setters
    public Vector<Coche> getCoches() {
        return coches;
    }

    public void setCoches(Vector<Coche> coches) {
        this.coches = coches;
    }

}
