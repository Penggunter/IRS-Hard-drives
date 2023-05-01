package com.example.irs_hard_drives.UI;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.irs_hard_drives.R;
import com.example.irs_hard_drives.data.HardDiskData;
import com.example.irs_hard_drives.data.database.HDDataBaseHelper;

import java.util.List;

public class AddItemFragment extends Fragment {
    ImageView backButton;
    EditText nameInput, companyInput, sizeInput, descriptionInput;
    Button addButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_added_data, container, false);

        backButton = view.findViewById(R.id.backButtonInAddedActivity);
        nameInput = view.findViewById(R.id.editTextName);
        companyInput = view.findViewById(R.id.editTextManufacturer);
        sizeInput = view.findViewById(R.id.editTextSize);
        descriptionInput = view.findViewById(R.id.editTextDescription);
        addButton = view.findViewById(R.id.buttonCreateDisk);

        // Кнопка назад
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_addItemFragment_to_mainFragment);
            }
        });

        // Кнопка добавления данных (диска)
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HDDataBaseHelper hdDB = new HDDataBaseHelper(getContext());
                hdDB.addHardDisk(nameInput.getText().toString().trim(),
                        companyInput.getText().toString().trim(),
                        sizeInput.getText().toString().trim(),
                        descriptionInput.getText().toString().trim());

            }
        });

        return view;
    }


}

