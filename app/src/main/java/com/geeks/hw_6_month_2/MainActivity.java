package com.geeks.hw_6_month_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private TextView tvSignInto;
    private TextView tvForgot;
    private TextView tvClickHere;
    private TextView tvInto;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnToComeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etEmail = findViewById(R.id.et_email);
        EditText etPassword = findViewById(R.id.et_password);
        TextView tvWelcome = findViewById(R.id.tv_welcome);
        TextView tvSignInto = findViewById(R.id.tv_sign_into);
        TextView tvForgot = findViewById(R.id.tv_forgot);
        TextView tvClickHere = findViewById(R.id.tv_click_here);
        TextView tvInto = findViewById(R.id.tv_into);
        TextView btnToComeIn = findViewById(R.id.btn_to_come_in);

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etEmail.getText().toString().isEmpty()) {
                    btnToComeIn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                } else {
                    btnToComeIn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.yellow));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etPassword.getText().toString().isEmpty()) {
                    btnToComeIn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                } else {
                    btnToComeIn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.yellow));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        btnToComeIn.setOnClickListener(v -> {
            if (etEmail.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")) {
                etEmail.setVisibility(View.GONE);
                etPassword.setVisibility(View.GONE);
                tvClickHere.setVisibility(View.GONE);
                tvForgot.setVisibility(View.GONE);
                tvInto.setVisibility(View.GONE);
                tvSignInto.setVisibility(View.GONE);
                btnToComeIn.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }
}