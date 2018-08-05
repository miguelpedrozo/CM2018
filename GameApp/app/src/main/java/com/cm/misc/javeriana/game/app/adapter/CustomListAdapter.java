package com.cm.misc.javeriana.game.app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cm.misc.javeriana.game.app.R;
import com.cm.misc.javeriana.game.app.model.GameHistoryDetail;
import com.cm.misc.javeriana.game.app.utils.DateUtils;

import java.util.ArrayList;

/**
 * Custom list adapter to use with {@link android.widget.ListView}
 */
public class CustomListAdapter extends BaseAdapter {

    private ArrayList<GameHistoryDetail> listData;
    private LayoutInflater layoutInflater;

    /**
     * Constructor. Creates a new instance of {@link CustomListAdapter}
     *
     * @param context  the {@link View} context
     * @param listData an {@link ArrayList} with {@link GameHistoryDetail} objects
     */
    public CustomListAdapter(Context context, ArrayList<GameHistoryDetail> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    /**
     * Returns the element count on the adapter's data set
     * @return int
     */
    @Override
    public int getCount() {
        return listData.size();
    }

    /**
     * Returns the item in the specified <code>index</code> position
     * @param index
     * @return
     */
    @Override
    public Object getItem(int index) {
        return listData.get(index);
    }

    /**
     * Returns the item's position
     * @param index
     * @return int
     */
    @Override
    public long getItemId(int index) {
        return index;
    }

    /**
     * Returns the view
     *
     * @param index       the current element's position in the adapter's data set
     * @param convertView the {@link View} to show the element in the {@link android.widget.ListView}
     * @param viewGroup   The parent that this view will eventually be attached to
     * @return
     */
    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int index, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.game_history_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.numberType = (TextView) convertView.findViewById(R.id.txvGHLNumberType);
            viewHolder.attempts = (TextView) convertView.findViewById(R.id.txvGHLQtyAttempt);
            viewHolder.lastAttemptDate = (TextView) convertView.findViewById(R.id.txvGHLDate);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.numberType.setText(
                String.format("Tu numero es: %s", listData.get(index).getNumberType().getType()));
        viewHolder.attempts.setText(
                String.format("Numero de intentos: %d", listData.get(index).getAttempts()));
        viewHolder.lastAttemptDate.setText(
                String.format("Ultimo intento: %s",
                        DateUtils.formatDate(
                                listData.get(index).getLastAttemptDate(),
                                DateUtils.DATE_FORMAT_1)));
        return convertView;
    }

    /**
     * Static class that defines the {@link TextView} components to add to the
     * {@link android.widget.ListView}
     */
    static class ViewHolder {
        TextView numberType;
        TextView attempts;
        TextView lastAttemptDate;
    }
}
