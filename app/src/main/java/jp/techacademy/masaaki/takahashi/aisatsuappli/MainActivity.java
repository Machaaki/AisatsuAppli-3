package jp.techacademy.masaaki.takahashi.aisatsuappli;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {showTimePickerDialog();
        }

    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                        if (hourOfDay >= 2 && hourOfDay < 10) {
                            mTextView = (TextView) findViewById(R.id.textView);
                            mTextView.setText("おはよう");

                        } else if (hourOfDay >= 10 &&  hourOfDay < 18) {
                            mTextView = (TextView) findViewById(R.id.textView);
                            mTextView.setText("こんにちは");

                        } else { /*18:00-1:59*/
                            mTextView = (TextView) findViewById(R.id.textView);
                            mTextView.setText("こんばんは");
                        }
                                            }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();


    }

}