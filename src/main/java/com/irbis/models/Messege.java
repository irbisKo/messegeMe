package com.irbis.models;

import javax.persistence.*;


/**
 * Created by meta on 07.06.2015.
 *
 * 267/06 names have a difference between message and  head className  is MessEge.
 */

// TODO match false writen  names  messEge

@Entity
@Table(name ="message")
public class Messege  implements IModel{
    private int idmessage;
    private String title;
    private String text;
    @Id
    @Column(name ="iduser", nullable = false, insertable = true, updatable = true)
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    private int iduser;

    @Id
    @Column(name = "idmessage", nullable = false, insertable = true, updatable = true)
    public int getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(int idmessage) {
        this.idmessage = idmessage;
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

        Messege message = (Messege) o;

        if (idmessage != message.idmessage) return false;
        if (title != null ? !title.equals(message.title) : message.title != null) return false;
        if (text != null ? !text.equals(message.text) : message.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmessage;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
