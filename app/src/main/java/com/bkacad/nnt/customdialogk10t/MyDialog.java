package com.bkacad.nnt.customdialogk10t;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

public abstract class MyDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private TextView tvLater, tvSubmit;
    private EditText edt;
    private RatingBar ratingBar;

    public MyDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public abstract void sendData(Rating item);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);

        tvLater = findViewById(R.id.tvLater);
        tvSubmit = findViewById(R.id.tvSubmit);
        edt = findViewById(R.id.edt);
        ratingBar = findViewById(R.id.ratingBar);

        tvSubmit.setOnClickListener(this);
        tvLater.setOnClickListener(this);

    }

    @Override
    public void show() {
        // Reset lại cac trường thông tin -> rỗng
        super.show();
        edt.setText("");
        ratingBar.setRating(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvSubmit:
                // Gửi dữ liệu xuống Main Activity
                String comment = edt.getText().toString();
                float rating = ratingBar.getRating();
                // Tạo đối tượng
                Rating item = new Rating(rating, comment);
                // Gửi về MainActivity để xử lý
                sendData(item);
                dismiss();
                break;
            case R.id.tvLater:
                dismiss();
                break;
        }
    }
}
