package com.example.irs_hard_drives.UI;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.irs_hard_drives.R;
import com.example.irs_hard_drives.data.database.HDDataBaseHelper;

public class DescriptionItemFragment extends Fragment {
    ImageButton backButton;
    Button deleteButton;

    int id;
    String title;

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
        deleteButton = view.findViewById(R.id.deleteButton);

        Bundle bundle = getArguments();

        if (bundle != null) {
            id = bundle.getInt("HardDisk_Id_Information");
            title = bundle.getString("HardDisk_Name_Information");
            nameItem.setText(bundle.getString("HardDisk_Name_Information"));
            sizeItem.setText(bundle.getString("HardDisk_Size_Information"));
            companyItem.setText(bundle.getString("HardDisk_Company_Information"));
            descriptionItem.setText(bundle.getString("HardDisk_Description_Information"));
        }
        Log.d("ID FOR DELETE", String.valueOf(id));

        // Кнопка назад
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_descriptionItemFragment_to_mainFragment);
            }
        });
        // Кнопка удаления
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog(v);
            }
        });
        return view;
    }

    void confirmDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Удалить " + title + "?");
        builder.setMessage("Вы уверены что хотите удалить " + title + "?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HDDataBaseHelper db = new HDDataBaseHelper(getContext());
                db.deleteOneRow(id);
                Navigation.findNavController(v).navigate(R.id.action_descriptionItemFragment_to_mainFragment);
            }
        });
        builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
