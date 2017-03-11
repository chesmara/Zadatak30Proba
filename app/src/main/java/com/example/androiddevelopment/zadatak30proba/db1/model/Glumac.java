package com.example.androiddevelopment.zadatak30proba.db1.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

/**
 *
 * Created by SNinkovic_ns on 4.3.2017.
 */
@DatabaseTable(tableName = Glumac.TABLE_NAME_GLUMAC)
public class Glumac {

    public static final String TABLE_NAME_GLUMAC = "glumci";

    public static final String FIELD_NAME_ID  =  "id";
    public static final String FIELD_NAME_NAME = "name";
    public static final String FIELD_NAME_DESCRIBE = "describe";
    public static final String FIELD_NAME_RATING = "rating";
    public static final String FIELD_NAME_BIRTHDAY ="birthday";
    public static final String FIELD_NAME_IMAGE = "image";
    public static final String FIELD_NAME_FILMOVI = "filmovi";


    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_NAME)
    private String name;

    @DatabaseField(columnName = FIELD_NAME_DESCRIBE)
    private String describe;

    @DatabaseField(columnName = FIELD_NAME_RATING)
    private String rating;

    @DatabaseField(columnName = FIELD_NAME_BIRTHDAY)
    private String birthday;

  /*  @DatabaseField(columnName = FIELD_NAME_IMAGE)
    private String image;

*/
    @ForeignCollectionField(columnName = FIELD_NAME_FILMOVI, eager=true)
    private ForeignCollection<Filmovi> filmovi;


    public Glumac(){
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getRating() {
        return rating;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public ForeignCollection<Filmovi> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(ForeignCollection<Filmovi> filmovi) {
        this.filmovi = filmovi;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }



   /* public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

*/

    @Override
    public String toString() {
        return name;
    }
}
