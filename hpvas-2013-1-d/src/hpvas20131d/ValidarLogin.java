package hpvas20131d;

import Entity.Sistema; 
import Entity.Usuario;
 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.D42D42A5-512A-C868-B654-32627A3A22E4]
// </editor-fold> 
public class ValidarLogin {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.233758F1-9522-D520-8535-FF2C99F7B7A3]
    // </editor-fold> 
    private Sistema sistema = Sistema.sistema;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.65388E97-05E0-935D-A9BA-FE51B86865CC]
    // </editor-fold> 
    public ValidarLogin () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4CE6692C-3762-5E5D-F16C-797236EE230C]
    // </editor-fold> 
    public Sistema getSistema () {
        return sistema;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1EE64915-44D8-7CCC-C74F-5FA427F69896]
    // </editor-fold> 
    public void setSistema (Sistema val) {
        this.sistema = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BFB1D20D-C5FB-0813-C1A7-9AF024906EB1]
    // </editor-fold> 
    public String VerificarLogin (Usuario usuario) {
        if (!VerificarLongitudNombre(usuario.getNombre()))
            return ("Longitud de nombre incorrecta");

        if (!VerificarLongitudPassword(usuario.getPassword()))
            return ("Longitud de contraseña incorrecta");

        for(Usuario u:Sistema.sistema.getUsuarios()){
            if(u.getNombre().equals(usuario.getNombre())&& u.getPassword().equals(usuario.getPassword()))
                return "Bienvenido";
        }
        return "Incorrecto";
    }

    public boolean VerificarRegistro (Usuario usuario){
        if (!VerificarLongitudNombre(usuario.getNombre())){
            System.out.print("Longitud de nombre incorrecta");
            return false;
        }
        if (!VerificarLongitudPassword(usuario.getPassword())){
            System.out.print("Longitud de contraseña incorrecta");
            return false;
        }
        return true;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.53467B74-7E43-E9AB-6B78-E70B74AB55EE]
    // </editor-fold> 
    public boolean VerificarLongitudNombre (String nombre) {
        return (nombre.length() >= 1 && nombre.length() <= 6);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.90C3C8AC-7BE7-4685-B6FB-717E3E57E68D]
    // </editor-fold> 
    public boolean VerificarLongitudPassword (String password) {
        return (password.length() > 3 && password.length() < 6);
    }

}

