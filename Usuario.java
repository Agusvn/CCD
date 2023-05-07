import java.util.Date;

public class Usuario {
    private String NomUsuario;
    private String Contrasena;
    private String Colegio;
    private int Dni;
    private String Nombre;
    private String Apellido;
    private Date FechaNac;
    private String Domicilio;

    public void SetNomUsuario(String _NomUsuario){
        this.NomUsuario = _NomUsuario;
    }

    public void SetContraseña(String _Contrasena){
        this.Contrasena = _Contrasena;
    }

    public void SetDni(int _Dni){
        this.Dni = _Dni;
    }

    public void SetNombre(String _Nombre){
        this.Nombre = _Nombre;
    }

    public void SetApellido(String _Apellido){
        this.Apellido = _Apellido;
    }

    public void SetFechaNac(Date _FechaNac){
        this.FechaNac = _FechaNac;
    }

    public void SetDomiciio(String _Domicilio){
        this.Domicilio = _Domicilio;
    }

    public void SetColegio(String _Colegio){
        this.Colegio = _Colegio;
    }

    public void Registrarse(){}

    public void Iniciar_Sesion(){}

    public void Cerrar_Sesion(){}
}