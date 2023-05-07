package com.example.irs_hard_drives.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.irs_hard_drives.R;

public class LoginMenuFragment extends Fragment {
    private View enterGuestButton;
    private View forgotPasswordButton;
    private EditText usernameInput;
    private EditText passwordInput;
    private Button toLoginButton;

    private String loginData = "admin";
    private String passwordData = "123456";

    // Число для подсчета попыток залогиниться:
    int tryToLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tryToLogin = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, container, false);

        // Иницилизация View компонентов
        enterGuestButton = view.findViewById(R.id.enterGuestTextView);
        forgotPasswordButton = view.findViewById(R.id.forgotPasswordTextView);
        usernameInput = view.findViewById(R.id.enterUsername);
        passwordInput = view.findViewById(R.id.enterPassword);
        toLoginButton = view.findViewById(R.id.buttonToLogin);


        // Кнопка-текст для входа под логином
        toLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkLogin(v))
                    Navigation.findNavController(view).navigate(R.id.action_loginMenuFragment_to_mainFragment);
            }
        });

        // Кнопка-текст для входа как гостя
        enterGuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_loginMenuFragment_to_questFragment);
            }
        });

        return view;
    }

    public boolean checkLogin(View view) {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (username.equals(loginData) && password.equals(passwordData)) {
            Log.d("Login", "Всё верно");
            return true;
        }

        Log.d("Login", "Данные не верны");
        Toast.makeText(getActivity().getApplicationContext(), "Неправильные данные!", Toast.LENGTH_SHORT).show();
        tryToLogin++;

        return false;
    }
}