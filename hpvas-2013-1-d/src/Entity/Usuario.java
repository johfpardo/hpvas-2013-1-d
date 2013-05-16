package Entity;

import java.util.ArrayList;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.50ABE11B-9383-3702-C7A8-881799D83DA8]
// </editor-fold> 
public class Usuario {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C60B766D-ED1B-55CC-F60F-D36B4683773D]
    // </editor-fold> 
    private String Nombre;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2BB105A1-B474-4D75-F383-0A7D6DDDCE6F]
    // </editor-fold> 
    private String Password;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F82DA187-AC0C-2C3F-FD70-E83E65C7CA6F]
    // </editor-fold> 
    public Usuario () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.77E68824-36D7-822F-2444-91F06FF5004F]
    // </editor-fold> 
    public String getNombre () {
        return Nombre;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.85B27B4B-9BE2-47C1-3D07-90F59100A511]
    // </editor-fold> 
    public void setNombre (String val) {
        this.Nombre = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.58B49086-1DB8-871E-A025-387B4DE34A60]
    // </editor-fold> 
    public String getPassword () {
        return Password;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.42C45438-53F3-1707-011C-974DB5C2E621]
    // </editor-fold> 
    public void setPassword (String val) {
        this.Password = val;
    }

}

