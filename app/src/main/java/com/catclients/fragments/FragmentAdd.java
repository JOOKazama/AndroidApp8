package com.catclients.fragments;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import com.catclients.R;
import com.catclients.classes.Cat;
import com.catclients.interfaces.AddCat;

public class FragmentAdd extends DialogFragment implements View.OnClickListener
{
    EditText add_name, add_breed;
    AddCat addcat;
    Button add1;

    @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    { return inflater.inflate(R.layout.add_fragment, container, false); }

    @RequiresApi(api=Build.VERSION_CODES.KITKAT)
    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        add_name=view.findViewById(R.id.add_name);
        add_breed=view.findViewById(R.id.add_breed);
        add1=view.findViewById(R.id.add1);
        add1.setOnClickListener(this);
    }

    @Override public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        addcat=(AddCat)context;
    }

    @Override public void onClick(View v)
    {
        addcat.Add(new Cat(add_name.getText().toString(), add_breed.getText().toString(), "Inactive"));
        dismiss();
    }
}