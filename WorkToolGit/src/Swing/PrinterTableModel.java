/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Swing;


import Logic.ControllerPrinter;
import com.sun.org.apache.xml.internal.serialize.Printer;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maximo
 */
public class PrinterTableModel extends AbstractTableModel{
    ControllerPrinter cp = new ControllerPrinter();
    Printer p = newPrinter();
    private ArrayList<Printer> pDatos = new ArrayList<Printer>();
    private final String[] aHeaders = {"(Impresora", "Puerto","Driver","Agregar"};

    public PrinterTableModel() {
        
    }

    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }
      
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Printer p = pDatos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                ca.setId(a,(int) value);
                break;
            case 1:
                ca.setCICliente(a,(String) value);
                break;
            case 2:
                ca.setMatriculaVehiculo(a,(String)value);
                break;
            case 3:
                ca.setFechaEntrega(a, (Date)value);
                break;
            case 4:
                ca.setFechaEstimada(a, (Date)value);
                break;
            case 5:
                ca.setFechaRetorno(a, (Date)value);
                break;
            case 6:
                ca.setKilometrajeInicial(a, (String)value);
                break;
            case 7:
                ca.setKilometrajeFinal(a, (String)value);
                break;
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
       if ((i1==0) || (i1==1) || (i1==2)){
          return false; 
       }else{
        return true;
       }
    }

    @Override
    public int getRowCount() {
        if (aDatos == null) {
            return 0;
        }

        return aDatos.size();
    }

    @Override
    public int getColumnCount() {
        return aHeaders.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alquiler a= aDatos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Integer.toString(ca.getId(a));
            case 1:
                return ca.getCICliente(a);
            case 2:
                return ca.getMatriculaVehiculo(a);
            case 3:
                return ca.getFechaEntrega(a);
            case 4:
                return ca.getFechaEstimadaRetorno(a);
            case 5:
                return ca.getFechaRetorno(a);
            case 6:
                return ca.getKilometrajeInicial(a);
            case 7:
                return ca.getKilometrajeFinal(a);
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return aHeaders[i];
    }

    public void addRow(Alquiler a) {
        aDatos.add(a);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void deleteRow(int i) {
        aDatos.remove(aDatos.get(i));
        fireTableDataChanged();
    }
    
    public void clearTable() {
        boolean removeAll = aDatos.removeAll(aDatos);
         fireTableDataChanged();
    }

    private Printer newPrinter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
