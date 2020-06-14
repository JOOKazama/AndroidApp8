package com.catclients.classes;
import java.util.ArrayList;

public class ListCats
{
    private ArrayList<Cat>cats=new ArrayList<>();

    public ArrayList<Cat>getCats() { return cats; }
    public void setCats(ArrayList<Cat>cats) { this.cats=cats; }
    public Cat getCat(int position) { return cats.get(position); }
    public void deleteCat(int position) { cats.remove(position); }
    public void addClient(Cat cat) { cats.add(cat); }
}