package y2019.aoc.lamar.lamaraoc2019;

import java.util.Date;

public class HomeWork {
    private String subject;
    private String description;
    private Date date;
    private boolean isDone;

    public HomeWork() {
    }

    public HomeWork(String subject, String description, Date date, boolean isDone) {
        this.subject = subject;
        this.description = description;
        this.date = date;
        this.isDone = isDone;
    }

    public String getSubject() {

        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
