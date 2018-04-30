package service.app.com.babypinkpoc;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import service.app.com.babypinkpoc.Util.AppUtil;
import service.app.com.babypinkpoc.adapter.CountryListAdapter;
import service.app.com.babypinkpoc.model.ContryModel;
import service.app.com.babypinkpoc.presenter.countryPresenter;
import service.app.com.babypinkpoc.presenter.countryPresenterImpl;
import service.app.com.babypinkpoc.view.CountriesView;

public class CountriesActivity extends AppCompatActivity implements CountriesView {
    public Context mContext;
    private countryPresenter mPresenter;
    private ArrayList<ContryModel> contryModelArrayList = new ArrayList<>();
    private Spinner mcountrySpinner;
    private Spinner mstateSpinner;
    private Button mButtonApply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        mContext = this;
        mPresenter = new countryPresenterImpl(this);
        initView();


    }

     public void initView(){
          mcountrySpinner =(Spinner)findViewById(R.id.country_spinner);
          mstateSpinner =(Spinner)findViewById(R.id.state_spinner);
          mPresenter.setCountryList(mContext);
          mButtonApply = (Button)findViewById(R.id.button_apply);
         mButtonApply.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mPresenter.btnApply(mContext);
             }
         });
  }




    @Override
    public void showSpinner() {

    }

    @Override
    public void hideSpinner() {

    }



    @Override
    public void getCountriesListData(ArrayList<ContryModel> data) {
        contryModelArrayList = data;
        CountryListAdapter countryListAdapter = new CountryListAdapter(this, contryModelArrayList);
        mcountrySpinner.setAdapter(countryListAdapter);
        mcountrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int id = adapterView.getId();
                switch (id) {
                    case R.id.country_spinner:
                        ArrayAdapter arrayAdapter = new ArrayAdapter(mContext, android.R.layout.simple_spinner_dropdown_item,
                                android.R.id.text1, contryModelArrayList.get(i).getStates());
                         mstateSpinner.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }
}
