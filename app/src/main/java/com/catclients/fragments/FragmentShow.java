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
    Button start, back;
    SendCat sendcat;
    Cat cat;

    public FragmentShow(SendCat sendcat) { this.sendcat=sendcat; }

    @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    { return inflater.inflate(R.layout.show_fragment, container, false); }

    @RequiresApi(api=Build.VERSION_CODES.KITKAT)
    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        show_name=view.findViewById(R.id.show_name);
        show_breed=view.findViewById(R.id.show_breed);
        show_condition=view.findViewById(R.id.show_condition);
        start=view.findViewById(R.id.start);
        back=view.findViewById(R.id.back);

        start.setText("Start!");
        assert getArguments()!=null;
        cat=getArguments().getParcelable("cat");

        assert cat!=null;
        show_name.setText(cat.getName());
        show_breed.setText(cat.getBreed());
        show_condition.setText(cat.getCondition());

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                sendcat.Send(cat);
                dismiss();
            }
        });

        back.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { dismiss(); } });
    }

    @Override public void onAttach(@NonNull Context context) { super.onAttach(context); }
}