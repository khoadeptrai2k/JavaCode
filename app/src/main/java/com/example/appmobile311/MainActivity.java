package com.example.appmobile311;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {
    EditText appProperty,appBedroom,appDatetime,appPrice,appFurniture,appNote,appReporter;
    Button appSubmit;

     AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appProperty = findViewById(R.id.app_PropertyType);
        appBedroom  = findViewById(R.id.app_Bedroom);
        appDatetime = findViewById(R.id.app_Datetime);
        appPrice    = findViewById(R.id.app_Price);
        appFurniture= findViewById(R.id.app_Furniture);
        appNote     = findViewById(R.id.app_Note);
        appReporter = findViewById(R.id.app_Reporter);
        appSubmit   = findViewById(R.id.app_Submit);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.app_PropertyType,
                RegexTemplate.NOT_EMPTY,R.string.invalid_property);
        awesomeValidation.addValidation(this,R.id.app_Bedroom,
                RegexTemplate.NOT_EMPTY,R.string.invalid_bedroom);
        awesomeValidation.addValidation(this,R.id.app_Datetime,
                RegexTemplate.NOT_EMPTY,R.string.invalid_datetime);
        awesomeValidation.addValidation(this,R.id.app_Price,
                RegexTemplate.NOT_EMPTY,R.string.invalid_price);
        awesomeValidation.addValidation(this,R.id.app_Furniture,
                RegexTemplate.NOT_EMPTY,R.string.invalid_furniture);
        awesomeValidation.addValidation(this,R.id.app_Note,
                RegexTemplate.NOT_EMPTY,R.string.invalid_note);
        awesomeValidation.addValidation(this,R.id.app_Reporter,
                RegexTemplate.NOT_EMPTY,R.string.invalid_reporter);

        appSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //validation check submit form
                if (awesomeValidation.validate()){
                    //success
                    Toast.makeText(getApplicationContext()
                    , "Successfully..", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext()
                    , "Fail.", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}