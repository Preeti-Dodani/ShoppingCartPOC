package service.app.com.babypinkpoc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import service.app.com.babypinkpoc.R;
import service.app.com.babypinkpoc.model.CategoryData;
import service.app.com.babypinkpoc.model.ContryModel;

/**
 * Created by Gudiya on 28/04/2018.
 */

public class CategoryAdapter  extends BaseAdapter {

    private ArrayList<CategoryData> categoryList;
    private Context mContext;

    public CategoryAdapter(Context mContext, ArrayList list) {
        this.mContext = mContext;
        categoryList = list;
    }


    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int i) {
        return categoryList.get(i);
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
            view = LayoutInflater.from(mContext).inflate(R.layout.category_row_item,viewGroup,false);
        }
        TextView label = (TextView) view.findViewById(R.id.category_data);
        label.setText(categoryList.get(i).getDisplayName());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }
}
