package com.airpool.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.airpool.Model.Group;
import com.airpool.R;

import java.util.ArrayList;

/**
 * Created by Maury on 11/9/14.
 */
public class UserGroupsAdapter extends ArrayAdapter<Group> {
    public UserGroupsAdapter(Context context, int resource, ArrayList<Group> objects) {
        super(context, resource, objects);
    }

    static class ViewHolder {
        TextView dateAndTime;
        TextView airport;
        ImageView transportationPreference;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Group item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.item_user_groups, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.dateAndTime = (TextView) convertView.findViewById(R.id.group_date_and_time);
            viewHolder.airport = (TextView) convertView.findViewById(R.id.group_airport);
            convertView.setTag(viewHolder);
        }

        // Fill the data.
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.dateAndTime.setText(item.getTimeOfDepartureString());

        String airportText;
        if (item.getIsToAirport()) {
            airportText = String.format(
                    getContext().getResources().getString(R.string.going_to_airport),
                    item.getAirport().getAirportName());
        } else {
            airportText = String.format(
                    getContext().getResources().getString(R.string.leaving_from_airport),
                    item.getAirport().getAirportName());
        }
        viewHolder.airport.setText(airportText);

        return convertView;
    }
}
