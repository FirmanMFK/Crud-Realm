package com.firman.realmtest.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Firman on 9/23/2016.
 */

public class Data extends RealmObject {

    @PrimaryKey
    private int id;
    private String title;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
