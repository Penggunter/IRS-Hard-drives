package com.example.irs_hard_drives.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.irs_hard_drives.R;
import com.example.irs_hard_drives.data.database.HDDataBaseHelper;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

    }
}