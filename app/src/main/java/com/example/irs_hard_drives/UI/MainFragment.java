package com.example.irs_hard_drives.UI;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.irs_hard_drives.R;
import com.example.irs_hard_drives.data.HardDiskData;
import com.example.irs_hard_drives.data.database.HDDataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    ImageView addButton;
    ImageView deleteButton;

    RecyclerView recyclerView;
    HDDataBaseHelper hardDiskDB;
    List<HardDiskData> hardDiskList;
    AdapterRecyclerView adapterRecyclerView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        hardDiskList = new ArrayList<>();

        addButton = view.findViewById(R.id.buttonAddedDataInMainActivity);
        recyclerView = view.findViewById(R.id.recyclerViewInMainPage);

        storeDataInArray();

        adapterRecyclerView = new AdapterRecyclerView(getContext(), hardDiskList);
        recyclerView.setAdapter(adapterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        /* Переход*/
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_addItemFragment);
            }
        });

        deleteButton = view.findViewById(R.id.buttonDeleteDataInMainActivity);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_deleteItemFragment);
            }
        });

        return view;
    }

    void storeDataInArray() {
        hardDiskDB = new HDDataBaseHelper(getContext());
        Cursor cursor = hardDiskDB.readAllData();
        if(cursor.getCount() == 0) {
            return;
        } else {
            while (cursor.moveToNext()){
                HardDiskData hardDisk = new HardDiskData(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                hardDiskList.add(hardDisk);
            }
        }
    }
}
