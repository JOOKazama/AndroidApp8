package com.catclients.main;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.catclients.fragments.FragmentAdd;
import com.catclients.interfaces.AddCat;
import com.catclients.vh_adapter.CatAdapter;
import com.catclients.R;
import com.catclients.classes.Cat;
import com.catclients.classes.ListCats;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AddCat
{
    ListCats list=new ListCats();
    CatAdapter adapter;
    RecyclerView view;
    Button add;

    @RequiresApi(api=Build.VERSION_CODES.KITKAT)
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(this.getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        view=findViewById(R.id.view);
        add=findViewById(R.id.add);

        list.addClient(new Cat("asd", "asd", "asd"));

        adapter=new CatAdapter(list.getCats(), this);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                FragmentAdd fa=new FragmentAdd();
                fa.show(getSupportFragmentManager(), "Hello there!");
            }
        });
    }

    @Override public void Add(Cat cat) { adapter.AddCat(cat); }
}