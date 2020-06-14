package com.catclients.vh_adapter;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.catclients.R;
import com.catclients.validator.Validator;
import com.catclients.classes.Cat;
import com.catclients.fragments.FragmentShow;
import com.catclients.fragments.FragmentShowSecond;
import com.catclients.interfaces.AddCat;
import com.catclients.interfaces.SendCat;
import com.catclients.main.MainActivity;
import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter<CatViewHolder> implements SendCat, AddCat
{
    private final ArrayList<Cat>cats;
    Validator validator=new Validator();
    private final Context context;

    public CatAdapter(ArrayList<Cat>cats, Context context)
    {
        this.cats=cats;
        this.context=context;
    }

    public void AddCat(Cat cat)
    {
        validator.AddValidator(cat, cats);

        if(validator.AddValidator(cat, cats).equals(""))
        {
            cats.add(cat);
            notifyDataSetChanged();
        }
        else { Toast.makeText(context, validator.AddValidator(cat, cats), Toast.LENGTH_SHORT).show(); }
    }

    @NonNull @Override public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    { return new CatViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cat, parent, false)); }

    @Override public void onBindViewHolder(@NonNull final CatViewHolder holder, final int position)
    {
        final Cat cat=cats.get(position);
        holder.setName(cat.getName());
        holder.itemView.setAlpha(0.8f);

        if(cat.getCondition().equals("Active")) holder.setCardViewColorAndVisibility();
        else holder.setCardViewColorAndVisibilitySecond();

        holder.cardview.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                Bundle bundle=new Bundle();
                bundle.putParcelable("cat", cat);

                if(!holder.getColor())
                {
                    FragmentShow fs=new FragmentShow(CatAdapter.this);
                    fs.setArguments(bundle);
                    fs.show(((MainActivity)context).getSupportFragmentManager(), "Hello there!");
                }
                else
                {
                    FragmentShowSecond fss=new FragmentShowSecond(CatAdapter.this);
                    fss.setArguments(bundle);
                    fss.show(((MainActivity)context).getSupportFragmentManager(), "Hello there!");
                }
            }
        });

        holder.remove.setOnClickListener(new Button.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                cats.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override public int getItemCount() { return cats.size(); }

    @Override public void Send(Cat cat)
    {
        for (Cat cat1:cats)
        {
            if(cat.getName().equals(cat1.getName()))
            {
                if(cat1.getCondition().equals("Active")) cat1.setCondition("Inactive");
                else cat1.setCondition("Active");
                notifyDataSetChanged();
            }
        }
    }

    @Override public void Add(Cat cat)
    {
        AddCat(cat);
        notifyDataSetChanged();
    }
}