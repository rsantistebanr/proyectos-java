package Beans;

public class beans_usuario {

    private int id_usuario;
    private int id_cargo;
    private String usuario;
    private String password_u;
    private String nombre;
    private String ap_usuario;
    private String am_usuario;
    private String email_usuario;
    private int eliminado_usuario;

    public beans_usuario() {
    }

    public beans_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public beans_usuario(int id_usuario, int id_cargo, String usuario, String password_u, String nombre, String ap_usuario, String am_usuario, String email_usuario, int eliminado_usuario) {
        this.id_usuario = id_usuario;
        this.id_cargo = id_cargo;
        this.usuario = usuario;
        this.password_u = password_u;
        this.nombre = nombre;
        this.ap_usuario = ap_usuario;
        this.am_usuario = am_usuario;
        this.email_usuario = email_usuario;
        this.eliminado_usuario = eliminado_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword_u() {
        return password_u;
    }

    public void setPassword_u(String password_u) {
        this.password_u = password_u;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_usuario() {
        return ap_usuario;
    }

    public void setAp_usuario(String ap_usuario) {
        this.ap_usuario = ap_usuario;
    }

    public String getAm_usuario() {
        return am_usuario;
    }

    public void setAm_usuario(String am_usuario) {
        this.am_usuario = am_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public int getEliminado_usuario() {
        return eliminado_usuario;
    }

    public void setEliminado_usuario(int eliminado_usuario) {
        this.eliminado_usuario = eliminado_usuario;
    }

    
    

}
