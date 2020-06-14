package com.catclients.vh_adapter;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.catclients.R;

public class CatViewHolder extends RecyclerView.ViewHolder
{
    Boolean color=false;
    CardView cardview;
    TextView name;
    Button remove;

    public void setName(String name) { this.name.setText(name); }
    public Boolean getColor() { return color; }

    public void setCardViewColorAndVisibility()
    {
        cardview.setBackgroundColor(Color.DKGRAY);
        remove.setVisibility(View.VISIBLE);
        color=true;
    }

    public void setCardViewColorAndVisibilitySecond()
    {
        cardview.setBackgroundColor(Color.parseColor("#1F75FE"));
        remove.setVisibility(View.INVISIBLE);
        color=false;
    }

    public CatViewHolder(@NonNull View itemView)
    {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        cardview=itemView.findViewById(R.id.cardview);
        remove=itemView.findViewById(R.id.remove);
        remove.setVisibility(View.INVISIBLE);
    }
}