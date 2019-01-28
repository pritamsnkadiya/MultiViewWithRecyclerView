package com.example.pritam.meenuapp.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pritam.meenuapp.R;
import com.example.pritam.meenuapp.models.User;

import java.util.List;

public class AllUsersDetailsDataAdapter extends RecyclerView.Adapter<AllUsersDetailsDataAdapter.ViewHolder> {

    private static final String TAG = AllUsersDetailsDataAdapter.class.getSimpleName ();
    private Context context;
    private List<User> modelList;

    public AllUsersDetailsDataAdapter(Context context, List<User> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public AllUsersDetailsDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from (viewGroup.getContext ()).inflate (R.layout.layout_all_users_list,
                viewGroup, false);
        return new AllUsersDetailsDataAdapter.ViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        viewHolder.first_name.setText (modelList.get (position).getFirstName ().toString ());
        viewHolder.last_name.setText (modelList.get (position).getLastName ().toString ());
        viewHolder.email.setText (modelList.get (position).getEmail ().toString ());
        viewHolder.address.setText (modelList.get (position).getAddress ().toString ());
        viewHolder.phone.setText (modelList.get (position).getMobile ().toString ());
        viewHolder.description.setText (modelList.get (position).getDescription ().toString ());
    }

    @Override
    public int getItemCount() {
        try {
            return modelList.size ();
        } catch (Exception e) {
            Log.d (TAG, "Exception " + e.getMessage ());
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView first_name;
        TextView last_name;
        TextView email;
        TextView address;
        TextView phone,description;

        public ViewHolder(View itemView) {
            super (itemView);

            first_name = itemView.findViewById (R.id.first_name);
            last_name = itemView.findViewById (R.id.last_name);
            email = itemView.findViewById (R.id.email);
            address = itemView.findViewById (R.id.address);
            phone = itemView.findViewById (R.id.phone);
            description= itemView.findViewById (R.id.description);
        }
    }
}