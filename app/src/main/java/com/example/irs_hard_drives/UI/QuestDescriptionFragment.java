package com.example.irs_hard_drives.UI;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.irs_hard_drives.R;


public class QuestDescriptionFragment extends Fragment {
    ImageButton backButton;

    String title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_guest_description_item, container, false);

        TextView nameItem = view.findViewById(R.id.guest_descriptionName_item);
        TextView sizeItem = view.findViewById(R.id.guest_descriptionSize_item);
        TextView companyItem = view.findViewById(R.id.guest_descriptionCompany_item);
        TextView descriptionItem = view.findViewById(R.id.guest_description_item);

        backButton = view.findViewById(R.id.guest_backButtonFromDescriptionInActivity);

        Bundle bundle = getArguments();

        if (bundle != null) {
            title = bundle.getString("guest_HardDisk_Name_Information");
            nameItem.setText(bundle.getString("guest_HardDisk_Name_Information"));
            sizeItem.setText(bundle.getString("guest_HardDisk_Size_Information"));
            companyItem.setText(bundle.getString("guest_HardDisk_Company_Information"));
            descriptionItem.setText(bundle.getString("guest_HardDisk_Description_Information"));
        }

        // Кнопка назад
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_questDescriptionFragment_to_questFragment);
            }
        });

        return view;
    }

}
