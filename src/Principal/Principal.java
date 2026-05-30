/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author hitim
 */

import GUI.FrmCliente;
import Controlador.ControladorCliente;


public class Principal {

    public static void main(String[] args) {

        FrmCliente vista = new FrmCliente();

        ControladorCliente controlador =
                new ControladorCliente(vista);

        vista.setVisible(true);

    }

}