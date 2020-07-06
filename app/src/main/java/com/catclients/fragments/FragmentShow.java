package com.catclients.fragments;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import com.catclients.classes.Cat;
import com.catclients.R;
import com.catclients.interfaces.SendCat;

public class FragmentShow extends DialogFragment
{
    TextView show_name, show_breed, show_condition;
    Button button_start, button_back;
    SendCat send_cat;
    Cat cat;

    public FragmentShow(SendCat sendcat) { this.send_cat=sendcat; }

    @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    { return inflater.inflate(R.layout.show_fragment, container, false); }

    @RequiresApi(api=Build.VERSION_CODES.KITKAT)
    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        show_name=view.findViewById(R.id.show_name);
        show_breed=view.findViewById(R.id.show_breed);
        show_condition=view.findViewById(R.id.show_condition);
        button_start=view.findViewById(R.id.button_start);
        button_back=view.findViewById(R.id.button_back);

        button_start.setText("Start!");
        assert getArguments()!=null;
        cat=getArguments().getParcelable("cat");

        assert cat!=null;
        show_name.setText(cat.getName());
        show_breed.setText(cat.getBreed());
        show_condition.setText(cat.getCondition());

        button_start.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                send_cat.Send(cat);
                dismiss();
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { dismiss(); } });
    }

    @Override public void onAttach(@NonNull Context context) { super.onAttach(context); }
}