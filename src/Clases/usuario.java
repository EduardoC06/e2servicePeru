
package Clases;

public class usuario {
   private int UCdusuario;
   private String Uusuario;
   private String Unombres;
   private String UApellidos;
   private String password;
   private String Uemail;
   private String Urol;
   private int nivel;

    public usuario() {
    }

    public String getUusuario() {
        return Uusuario;
    }

    public void setUusuario(String Uusuario) {
        this.Uusuario = Uusuario;
    }

    public int getUCdusuario() {
        return UCdusuario;
    }

    public void setUCdusuario(int UCdusuario) {
        this.UCdusuario = UCdusuario;
    }

    public String getUnombres() {
        return Unombres;
    }

    public void setUnombres(String Unombres) {
        this.Unombres = Unombres;
    }

    public String getUApellidos() {
        return UApellidos;
    }

    public void setUApellidos(String UApellidos) {
        this.UApellidos = UApellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String Uemail) {
        this.Uemail = Uemail;
    }

    public String getUrol() {
        return Urol;
    }

    public void setUrol(String Urol) {
        this.Urol = Urol;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
   
    @Override
    public String toString() {
        return "usuario{" + "UCdusuario=" + UCdusuario + ", Uusuario=" + Uusuario + ", Unombres=" + Unombres + ", UApellidos=" + UApellidos + ", password=" + password + ", Uemail=" + Uemail + ", Urol=" + Urol + ", nivel=" + nivel + '}';
    }
    
}
