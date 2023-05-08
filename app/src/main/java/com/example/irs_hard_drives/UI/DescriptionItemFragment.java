package com.example.irs_hard_drives.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.irs_hard_drives.R;

public class DescriptionItemFragment extends Fragment {
    ImageButton backButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_description_item, container, false);

        TextView nameItem = (TextView) view.findViewById(R.id.descriptionName_item);
        TextView sizeItem = (TextView) view.findViewById(R.id.descriptionSize_item);
        TextView companyItem = (TextView) view.findViewById(R.id.descriptionCompany_item);
        TextView descriptionItem = (TextView) view.findViewById(R.id.description_item);

        backButton = view.findViewById(R.id.backButtonFromDescriptionInActivity);

        Bundle bundle = getArguments();
        if (bundle != null) {
            nameItem.setText(bundle.getString("HardDisk_Name_Information"));
            sizeItem.setText(bundle.getString("HardDisk_Size_Information"));
            companyItem.setText(bundle.getString("HardDisk_Company_Information"));
            descriptionItem.setText(bundle.getString("HardDisk_Description_Information"));
        }

        // Кнопка назад
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_descriptionItemFragment_to_mainFragment);
            }
        });

        return view;
    }
}
