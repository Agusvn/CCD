import java.util.Date;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {}
}


class Usuario {
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


class Alumno extends Usuario {
    private Adulto_Responsable Adulto;
    
    public void LeerInfo(){}
    
}


class Adulto_Responsable extends Usuario {
    public void CPriv_Docente(){}
    public void CPriv_Preceptor(){}
    public void LeerInfo(){}
    public void Firmar(){}
}


class Preceptor extends Usuario {
    public void TomarLista(){}
    public void CargarBoletin(){}
    public void EditarFaltas(){}
    public void CargarComunicado(){}
    public void CargarFirma(){}
    public void CargarHorario(){}
    public void ModificarHorario(){}
    public void CargarAlumno(){}
    public void ModificarAlumno(){}
    public void CPriv_Docente(){}
    public void CPriv_Adulto(){}
    //public void CPriv_Preceptor(){}
    public void CPriv_Alumno(){}
    public void CPub_Alumno(){}
    public void AdjuntarArchivo(){}
}


abstract class Docente extends Usuario {
    public abstract void CargarNotas();
    //public void CPriv_Docente(){}
    public void CPriv_Preceptor(){}
    public void CPriv_Adulto(){}
    public void CPriv_Alumno(){}
    public void CPub_Alumno(){}
}


class Docente_Secundaria extends Docente {
    @Override
    public void CargarNotas(){}
}


class Docente_Primaria extends Docente {
    @Override
    public void CargarNotas(){}
}


class Docente_Jardin extends Docente {
    @Override
    public void CargarNotas(){}
}


class Cuaderno extends JFrame{
    public void MenuAlumno(){}
    public void MenuAdultoResponsable(){}
    public void MenuDocenteJardin(){}
    public void MenuDocentePrimaria(){}
    public void MenuDocenteSecundaria(){}
    public void MenuPreceptor(){}
}

