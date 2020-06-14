package com.catclients.classes;
import android.os.Parcel;
import android.os.Parcelable;

public class Cat implements Parcelable
{
    private String name;
    private String breed;
    private String condition;

    public Cat(String name, String breed, String condition)
    {
        this.name=name;
        this.breed=breed;
        this.condition=condition;
    }

    protected Cat(Parcel in)
    {
        name=in.readString();
        breed=in.readString();
        condition=in.readString();
    }

    public static final Creator<Cat>CREATOR=new Creator<Cat>()
    {
        @Override public Cat createFromParcel(Parcel in) { return new Cat(in); }
        @Override public Cat[] newArray(int size) { return new Cat[size]; }
    };

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    @Override public int describeContents() { return 0; }

    @Override public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(name);
        dest.writeString(breed);
        dest.writeString(condition);
    }
}