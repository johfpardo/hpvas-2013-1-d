package Entity;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.CADF64BE-F7A0-4D21-C8DC-6A80F15DF914]
// </editor-fold> 
public class Sistema {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7D550F88-C1A0-2AB5-D6EE-0ECD9B6769CC]
    // </editor-fold> 
    private ArrayList<Usuario> Usuarios;
    public static Sistema sistema = new Sistema();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.71C0D3BC-8F95-8E6A-F341-A02E93822F6F]
    // </editor-fold> 
    public Sistema () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0A45F797-CF5C-E3F7-FDC1-7FEBC73EF97B]
    // </editor-fold> 
    public ArrayList<Usuario> getUsuarios () {
        return Usuarios;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.75ECF594-A9B1-EE96-8615-B245AA43E401]
    // </editor-fold> 
    public void setUsuarios (ArrayList<Usuario> val) {
        this.Usuarios = val;
    }

    public void addUsuarios (ArrayList<Usuario> val){
        Usuarios.addAll(val);
    }

}

