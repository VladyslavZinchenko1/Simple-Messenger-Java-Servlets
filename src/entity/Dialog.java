package entity;



import java.sql.Timestamp;

public class Dialog {
    private String content;
    private Timestamp date;
    private int id_from;
    private int id_to;
    public Dialog(String content, Timestamp date, int id_from, int id_to){
        this.content=content; this.date=date; this.id_from=id_from; this.id_to=id_to;
    }

    public Dialog() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getId_from() {
        return id_from;
    }

    public void setId_from(int id_from) {
        this.id_from = id_from;
    }

    public int getId_to() {
        return id_to;
    }

    public void setId_to(int id_to) {
        this.id_to = id_to;
    }
}
