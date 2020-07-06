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
    CardView card_view;
    TextView name;
    Button button_remove;

    public void setName(String name) { this.name.setText(name); }
    public Boolean getColor() { return color; }

    public void setCardViewColorAndVisibility()
    {
        card_view.setBackgroundColor(Color.DKGRAY);
        button_remove.setVisibility(View.VISIBLE);
        color=true;
    }

    public void setCardViewColorAndVisibilitySecond()
    {
        card_view.setBackgroundColor(Color.parseColor("#1F75FE"));
        button_remove.setVisibility(View.INVISIBLE);
        color=false;
    }

    public CatViewHolder(@NonNull View itemView)
    {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        card_view=itemView.findViewById(R.id.card_view);
        button_remove=itemView.findViewById(R.id.button_remove);
        button_remove.setVisibility(View.INVISIBLE);
    }
}