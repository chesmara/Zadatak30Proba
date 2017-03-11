package com.example.androiddevelopment.zadatak30proba.db1.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by SNinkovic_ns on 11.3.2017.
 */
@DatabaseTable(tableName = Filmovi.TABLE_NAME_FILMOVI)
public class Filmovi {

    public static final String TABLE_NAME_FILMOVI = "filmovi";

    public static final String FIELD_NAME_ID  =  "id";
    public static final String FIELD_NAME_NAME = "name";
    public static final String FIELD_NAME_ZANR  =  "zanr";

    public static final String FIELD_NAME_GLUMAC = "imeGlumca";

    @DatabaseField(columnName = FIELD_NAME_ID , generatedId = true)
    private int fId;

    @DatabaseField(columnName = FIELD_NAME_NAME)
    private String fName;

    @DatabaseField(columnName = FIELD_NAME_ZANR)
    private String fZanr;

    @DatabaseField(columnName = FIELD_NAME_GLUMAC)
    private String fGlumac;

    public Filmovi(){}

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfZanr() {
        return fZanr;
    }

    public void setfZanr(String fZanr) {
        this.fZanr = fZanr;
    }

    public String getfGlumac() {
        return fGlumac;
    }

    public void setfGlumac(String fGlumac) {
        this.fGlumac = fGlumac;
    }

    @Override
    public String toString() {
        return fName ;
    }
}
