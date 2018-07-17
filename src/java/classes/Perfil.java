package classes;

public class Perfil {

    private int idPerfil;
    private String prefil;
    private Menu menu;

    public Perfil(int idPerfil, String prefil, Menu menu) {
        this.idPerfil = idPerfil;
        this.prefil = prefil;
        this.menu = menu;
    }

    public Perfil() {
    }

    public void setPrefil(String prefil) {
        this.prefil = prefil;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getPrefil() {
        return prefil;
    }
}
