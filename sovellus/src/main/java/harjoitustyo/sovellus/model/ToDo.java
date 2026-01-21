package harjoitustyo.sovellus.model;

public class ToDo {

    private Long id;
    private String title;
    private boolean completed;

    // Tyhjä konstruktori
    public ToDo() {
    }

    // Parametrillinen konstruktori
    public ToDo(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getterit ja setterit
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
