/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package componente;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.EventListener;

/**
 *
 * @author josegomez
 */
public class CocheBean implements Serializable {

    private PropertyChangeSupport propertySupport;
    private CocheDAO cocheDAO;

    public CocheBean() {
        propertySupport = new PropertyChangeSupport(this);
        try {
            cocheDAO = new CocheDAO();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CocheBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class BDModificadaEvent extends java.util.EventObject {

        public BDModificadaEvent(Object source) {
            super(source);
        }
    }

    public interface BDModificadaListener extends EventListener {

        public void capturarBDModificada(BDModificadaEvent ev);
    }

    private BDModificadaListener receptor;

    public void addBDModificadaListener(BDModificadaListener receptor) {
        this.receptor = receptor;
    }

    public void removeBDModificadaListener(BDModificadaListener receptor) {
        this.receptor = null;
    }

    public void addCoche(Coche coche) throws ClassNotFoundException {
        cocheDAO.addCoche(coche);
        receptor.capturarBDModificada(new BDModificadaEvent(this));
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    // Getters y Setters
    public PropertyChangeSupport getPropertySupport() {
        return propertySupport;
    }

    public void setPropertySupport(PropertyChangeSupport propertySupport) {
        this.propertySupport = propertySupport;
    }

    public CocheDAO getCocheDAO() {
        return cocheDAO;
    }

    public void setCocheDAO(CocheDAO cocheDAO) {
        this.cocheDAO = cocheDAO;
    }

    public BDModificadaListener getReceptor() {
        return receptor;
    }

    public void setReceptor(BDModificadaListener receptor) {
        this.receptor = receptor;
    }

}
