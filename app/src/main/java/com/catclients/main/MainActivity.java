package com.catclients.main;
import android.os.Build;
import android.view.View;
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
    ListCats list_cats=new ListCats();
    CatAdapter cat_adapter;
    RecyclerView recycler_view;
    Button button_add;

    @RequiresApi(api=Build.VERSION_CODES.KITKAT)
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(this.getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        recycler_view=findViewById(R.id.recycler_view);
        button_add=findViewById(R.id.button_add);

        list_cats.addClient(new Cat("Albert Whiskers", "Bombay", "Inactive"));

        cat_adapter=new CatAdapter(list_cats.getCats(), this);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(cat_adapter);

        button_add.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                FragmentAdd fragment_add=new FragmentAdd();
                fragment_add.show(getSupportFragmentManager(), "Hello there!");
            }
        });
    }

    @Override public void Add(Cat cat) { cat_adapter.AddCat(cat); }
}