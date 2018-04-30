package service.app.com.babypinkpoc.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import service.app.com.babypinkpoc.CountriesActivity;
import service.app.com.babypinkpoc.R;
import service.app.com.babypinkpoc.model.ContryModel;

/**
 * Created by Gudiya on 24/04/2018.
 */

public class CountryListAdapter extends BaseAdapter {

    private ArrayList<ContryModel> countryList;
    private Context mContext;

    public CountryListAdapter(Context mContext, ArrayList<ContryModel> list) {
        this.mContext = mContext;
        countryList = list;
    }


    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int i) {
        return countryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean isEnabled(int position) {
        if(position==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.countries_spinner,viewGroup,false);
        }
        TextView label = (TextView) view.findViewById(R.id.contries_textView);
        label.setText(countryList.get(i).getName());
          return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    public void updateData(ArrayList<ContryModel> viewModels) {
        countryList.clear();
        countryList.addAll(viewModels);
        notifyDataSetChanged();
    }
}
