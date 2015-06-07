package com.irbis.models;

import javax.persistence.*;


/**
 * Created by meta on 07.06.2015.
 */
@Entity
@Table(name ="messege")
public class Messege {
    private int idmessege;
    private String title;
    private String text;

    @Id
    @Column(name = "idmessege", nullable = false, insertable = true, updatable = true)
    public int getIdmessege() {
        return idmessege;
    }

    public void setIdmessege(int idmessege) {
        this.idmessege = idmessege;
    }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "text", nullable = false, insertable = true, updatable = true, length = 45)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messege messege = (Messege) o;

        if (idmessege != messege.idmessege) return false;
        if (title != null ? !title.equals(messege.title) : messege.title != null) return false;
        if (text != null ? !text.equals(messege.text) : messege.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmessege;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
