package Beans;

public class beans_cliente {

    private int id_cliente;
    private String usuario_cliente;
    private String password_cliente;
    private String nombre_cliente;
    private String ap_cliente;
    private String am_cliente;
    private String tipo_documento;
    private String numero_documento;
    private String sexo_cliente;
    private String direccion_cliente;
    private String telefono_cliente;
    private String email_cliente;
    private int eliminado_cliente;

    public beans_cliente(int id_cliente, String usuario_cliente, String password_cliente, String nombre_cliente, String ap_cliente, String am_cliente, String tipo_documento, String numero_documento, String sexo_cliente, String direccion_cliente, String telefono_cliente, String email_cliente, int eliminado_cliente) {
        this.id_cliente = id_cliente;
        this.usuario_cliente = usuario_cliente;
        this.password_cliente = password_cliente;
        this.nombre_cliente = nombre_cliente;
        this.ap_cliente = ap_cliente;
        this.am_cliente = am_cliente;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.sexo_cliente = sexo_cliente;
        this.direccion_cliente = direccion_cliente;
        this.telefono_cliente = telefono_cliente;
        this.email_cliente = email_cliente;
        this.eliminado_cliente = eliminado_cliente;
    }

    public beans_cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getUsuario_cliente() {
        return usuario_cliente;
    }

    public void setUsuario_cliente(String usuario_cliente) {
        this.usuario_cliente = usuario_cliente;
    }

    public String getPassword_cliente() {
        return password_cliente;
    }

    public void setPassword_cliente(String password_cliente) {
        this.password_cliente = password_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getAp_cliente() {
        return ap_cliente;
    }

    public void setAp_cliente(String ap_cliente) {
        this.ap_cliente = ap_cliente;
    }

    public String getAm_cliente() {
        return am_cliente;
    }

    public void setAm_cliente(String am_cliente) {
        this.am_cliente = am_cliente;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getSexo_cliente() {
        return sexo_cliente;
    }

    public void setSexo_cliente(String sexo_cliente) {
        this.sexo_cliente = sexo_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public int getEliminado_cliente() {
        return eliminado_cliente;
    }

    public void setEliminado_cliente(int eliminado_cliente) {
        this.eliminado_cliente = eliminado_cliente;
    }
    
    
    
}
