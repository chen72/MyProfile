package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    RadioGroup rgGender;
    CheckBox ckbLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.editTextName);
        etGPA = (EditText) findViewById(R.id.editTextGPA);
        rgGender = (RadioGroup) findViewById(R.id.RadioGroupGneder);
        ckbLike = (CheckBox) findViewById(R.id.checkBoxLikeProgeamming);




        ckbLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                if (ckbLike.isChecked()) {
                    ckbLike.setChecked(true);
                } else {
                    ckbLike.setChecked(false);
                }
            }
        });

    }

    protected void onPause() {
        super.onPause();

        //NAME
        String strName=etName.getText().toString();
        //GPA
        String strGPA=etGPA.getText().toString();
        //GENDER
        int select = rgGender.getCheckedRadioButtonId();
        //CHECK BOX
        boolean check= ckbLike.isChecked();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name",strName);
        prefEdit.putString("GPA",strGPA);
        prefEdit.putInt("Gender",select);
        prefEdit.putBoolean("yes",check);
        prefEdit.commit();

    }



    protected void onResume() {
        super.onResume();

        // NAME
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String strName= prefs.getString("name","John");
        String strGPA= prefs.getString("GPA","3.90");
        int intGender= prefs.getInt("Gender",0);

        Boolean checked=prefs.getBoolean("yes",false);

        etName.setText(strName);
        etGPA.setText(strGPA);
        rgGender.check(intGender);
        ckbLike.setChecked(checked);

}
}
