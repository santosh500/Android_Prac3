package com.example.santo_000.volleydemo2;

/**
 * Created by santo_000 on 7/12/2016.
 */
public class Contact {

    private String ID,UID,Type;

    public Contact(String ID, String UID, String Type)
    {
        this.setID(ID);
        this.setUID(UID);
        this.setType(Type);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
