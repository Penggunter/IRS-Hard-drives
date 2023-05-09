package com.example.irs_hard_drives.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.irs_hard_drives.R;
import com.example.irs_hard_drives.data.HardDiskData;
import com.example.irs_hard_drives.data.database.HDDataBaseHelper;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    public int status;

    private Context context;
    private final LayoutInflater inflater;
    private final List<HardDiskData> hardDiskList;

    AdapterRecyclerView(Context context, List<HardDiskData> hardDiskList) {
        this.context = context;
        this.hardDiskList = hardDiskList;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycleview_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(AdapterRecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        HardDiskData hardDisk = hardDiskList.get(position);
        holder.titleName.setText(hardDisk.getName());
        holder.companyName.setText(hardDisk.getCompany());
        holder.sizeHD.setText(String.valueOf(hardDisk.getSize()));

        holder.headerView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(status == 1) {
                    Log.d("Id item recycleView", String.valueOf(hardDisk.getId()));

                    Bundle bundle = new Bundle();
                    bundle.putInt("HardDisk_Id_Information", hardDisk.getId());
                    bundle.putString("HardDisk_Name_Information", hardDisk.getName());
                    bundle.putString("HardDisk_Size_Information", hardDisk.getSize());
                    bundle.putString("HardDisk_Company_Information", hardDisk.getCompany());
                    bundle.putString("HardDisk_Description_Information", hardDisk.getDescription());

                    Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_descriptionItemFragment, bundle);
                } else if(status == 2) {
                    Log.d("Id item recycleView", String.valueOf(hardDisk.getId()));

                    Bundle bundle = new Bundle();
                    bundle.putInt("guest_HardDisk_Id_Information", hardDisk.getId());
                    bundle.putString("guest_HardDisk_Name_Information", hardDisk.getName());
                    bundle.putString("guest_HardDisk_Size_Information", hardDisk.getSize());
                    bundle.putString("guest_HardDisk_Company_Information", hardDisk.getCompany());
                    bundle.putString("guest_HardDisk_Description_Information", hardDisk.getDescription());

                    Navigation.findNavController(v).navigate(R.id.action_questFragment_to_questDescriptionFragment, bundle);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return hardDiskList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final View headerView;
        final TextView titleName;
        final TextView companyName;
        final TextView sizeHD;

        ViewHolder(View view){
            super(view);
            headerView = view.findViewById(R.id.recyclerViewItem);
            titleName = view.findViewById(R.id.TitleNameRV);
            companyName = view.findViewById(R.id.CompanyRV);
            sizeHD = view.findViewById(R.id.SizeRV);
        }
    }

    private void action(AdapterRecyclerView.ViewHolder holder) {

    }
}
