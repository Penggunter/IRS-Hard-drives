package com.example.irs_hard_drives.UI;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.irs_hard_drives.R;
import com.example.irs_hard_drives.data.HardDiskData;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

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
    public void onBindViewHolder(AdapterRecyclerView.ViewHolder holder, int position) {
        HardDiskData hardDisk = hardDiskList.get(position);
        holder.titleName.setText(hardDisk.getName());
        holder.companyName.setText(hardDisk.getCompany());
        holder.sizeHD.setText(String.valueOf(hardDisk.getSize()));

        holder.headerView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Item recycleView", (String)holder.titleName.getText());

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
}
