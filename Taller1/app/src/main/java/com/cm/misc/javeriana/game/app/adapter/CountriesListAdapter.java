package com.cm.misc.javeriana.game.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cm.misc.javeriana.game.app.R;
import com.cm.misc.javeriana.game.app.model.Country;

import java.util.ArrayList;

/**
 *
 */
public class CountriesListAdapter extends BaseAdapter {

    private ArrayList<Country> listData;
    private LayoutInflater layoutInflater;

    /**
     *
     * @param context
     * @param listData
     */
    public CountriesListAdapter(Context context, ArrayList<Country> listData) {
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     *
     * @return
     */
    @Override
    public int getCount() {
        return listData.size();
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public Object getItem(int index) {
        return listData.get(index);
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public long getItemId(int index) {
        return index;
    }

    /**
     *
     * @param index
     * @param convertView
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int index, View convertView, ViewGroup viewGroup) {
        CountriesListAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.simple_country_list_item, null);
            viewHolder = new CountriesListAdapter.ViewHolder();
            viewHolder.countryName = (TextView) convertView.findViewById(R.id.txvSCLICountryName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CountriesListAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.countryName.setText(listData.get(index).getCountryName());
        return convertView;
    }

    /**
     * Static class that defines the {@link TextView} components to add to the
     * {@link android.widget.ListView}
     */
    static class ViewHolder {
        TextView countryName;
    }
}
