package com.example.irs_hard_drives.UI;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.irs_hard_drives.R;
import com.example.irs_hard_drives.data.HardDiskData;
import com.example.irs_hard_drives.data.database.HDDataBaseHelper;

import java.util.ArrayList;

public class DeleteItemFragment extends Fragment {
    private ImageView backButton;

    private RecyclerView recyclerView;
    private HDDataBaseHelper hardDiskDB;
    private ArrayList<HardDiskData> hardDiskList;
    private AdapterRecyclerView adapterRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_delete_data, container, false);

        hardDiskList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerViewInDeletePage);

        storeDataInArray();

        adapterRecyclerView = new AdapterRecyclerView(getContext(), hardDiskList);
        adapterRecyclerView.status = 1;
        recyclerView.setAdapter(adapterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        backButton = view.findViewById(R.id.backButtonInDeleteActivity);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_deleteItemFragment_to_mainFragment);
            }
        });

        return view;
    }

    private void storeDataInArray() {
        hardDiskDB = new HDDataBaseHelper(getContext());
        Cursor cursor = hardDiskDB.readAllData();
        if(cursor.getCount() == 0)
            return;
        while (cursor.moveToNext()){
            HardDiskData hardDisk = new HardDiskData(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            hardDiskList.add(hardDisk);
        }
    }
}
