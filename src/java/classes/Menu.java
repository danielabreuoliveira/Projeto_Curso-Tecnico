package classes;

public class Menu {
    private int idMenu; 
    private String nome;
    private String link;

    public Menu(int idMenu, String nome) {
        this.idMenu = idMenu;
        this.nome = nome;
    }

    public Menu() {
    }
    
    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
