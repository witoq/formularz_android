package com.example.przed_kartkowka_formularz;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextNazwa;
    EditText editTextOpis;
    ImageButton imageButtonPoprzednieMaleZdj;
    ImageView imageViewDuze;
    ImageButton imageButtonNastepneMaleZdj;
    Button buttonDodaj;
    ImageView imageViewMale;
    TextView textViewNazwa;
    TextView textViewOpis;
    Button buttonPoprzedniElement;
    Button buttonNastepnyElement;
    Spinner spinnerElement;
    EditText editTextElement;
    SeekBar seekBarElement;
    CheckBox checkBoxWidoczne;
    ArrayList<Integer> images;
    ArrayList<Cars> cars;
    RadioGroup radioGroupZdjecie;
    ArrayAdapter<String> arrayAdapter;
    int id_male = 0;
    int id_duze = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        images = new ArrayList<>();
        images.add(R.drawable.m4);
        images.add(R.drawable.rs6);
        images.add(R.drawable.mustang_gt500);
        images.add(R.drawable.yaris_gr);
        cars = new ArrayList<>();
        cars.add(new Cars(R.drawable.m4,"BMW M4 G82","najlepsze auto na swiecie"));
        cars.add(new Cars(R.drawable.rs6,"Audi RS6","półosie z gówna"));
        cars.add(new Cars(R.drawable.mustang_gt500,"Ford mustang GT500","w rowie"));
        cars.add(new Cars(R.drawable.yaris_gr,"Toyota yaris GR","małe gówno"));



        editTextNazwa = findViewById(R.id.editTextNazwa);
        editTextOpis = findViewById(R.id.editTextOpis);
        imageButtonPoprzednieMaleZdj = findViewById(R.id.imageButtonPoprzednieMale);
        imageViewMale = findViewById(R.id.imageViewMale);
        imageButtonNastepneMaleZdj = findViewById(R.id.imageButtonNastepneMale);
        buttonDodaj = findViewById(R.id.buttonDodaj);
        imageViewDuze = findViewById(R.id.imageViewDuze);
        textViewNazwa = findViewById(R.id.textViewNazwa);
        textViewOpis = findViewById(R.id.textViewOpis);
        buttonNastepnyElement = findViewById(R.id.buttonNastepnyElement);
        buttonPoprzedniElement = findViewById(R.id.buttonaPoprzedniElement);
        editTextElement = findViewById(R.id.editTextKtoryElement);
        spinnerElement = findViewById(R.id.spinnerElement);
        seekBarElement = findViewById(R.id.seekBarElement);
        checkBoxWidoczne = findViewById(R.id.checkBoxWidoczne);
        radioGroupZdjecie = findViewById(R.id.radioGroup);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cars);
        spinnerElement.setAdapter(arrayAdapter);


       imageButtonNastepneMaleZdj.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(id_male < images.size()-1){
                   id_male++;
                   wyswietl_male_zdjecie(id_male);
               }
               else{
                   id_male=0;
                   wyswietl_male_zdjecie(id_male);
               }
           }
       });
       imageButtonPoprzednieMaleZdj.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(id_male > 0){
                   id_male--;
                   wyswietl_male_zdjecie(id_male);
               }
               else{
                   id_male = images.size()-1;
                   wyswietl_male_zdjecie(id_male);
               }
           }
       });
        seekBarElement.setMax(0);
        seekBarElement.setMax(cars.size()-1);
        seekBarElement.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                wyswietl_duze_zdj(i);
                spinnerElement.setSelection(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//       radioGroupZdjecie.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//           @Override
//           public void onCheckedChanged(RadioGroup radioGroup, int i) {
//               id_male = i;
//               wyswietl_male_zdjecie(id_male);
//           }
//       });
        buttonDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nazwa = editTextNazwa.getText().toString();
                String opis = editTextOpis.getText().toString();
                cars.add(new Cars(images.get(id_male),nazwa,opis));
                seekBarElement.setMax(cars.size()-1);
            }
        });
        buttonNastepnyElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id_duze < cars.size()-1){
                    id_duze++;
                    wyswietl_duze_zdj(id_duze);
                }
                else{
                    id_duze=0;
                    wyswietl_duze_zdj(id_duze);
                }
            }
        });
        buttonPoprzedniElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id_duze > 0){
                    id_duze--;
                    wyswietl_duze_zdj(id_duze);

                }
                else{
                    id_duze=cars.size()-1;
                    wyswietl_duze_zdj(id_duze);
                }
            }
        });
        checkBoxWidoczne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBoxWidoczne.isChecked()==true){
                    imageViewDuze.setVisibility(View.VISIBLE);
                }
                else{
                    imageViewDuze.setVisibility(View.INVISIBLE);
                }
            }
        });
//        spinnerElement.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });
//        editTextElement.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if(!editTextElement.equals("")){
//                    int id = Integer.valueOf(editTextElement.getText().toString());
//                    if(id>0 && id< cars.size()-1){
//                        wyswietl_duze_zdj(id);
//                    }
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
        spinnerElement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                wyswietl_duze_zdj(i);
                seekBarElement.setProgress(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        wyswietl_duze_zdj(id_duze);
    }
    private void wyswietl_male_zdjecie(int i){
        imageViewMale.setImageResource(images.get(i));
    }
    private void wyswietl_duze_zdj(int i){
        String cos = String.valueOf(i);
        imageViewDuze.setImageResource(cars.get(i).getZdjecie());
        textViewNazwa.setText(cars.get(i).getNazwa());
        textViewOpis.setText(cars.get(i).getOpis());
        spinnerElement.setSelection(i);
        seekBarElement.setProgress(i);
        editTextElement.setText(cos);
    }
}