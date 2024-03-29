package co.edu.icesi.challenge3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.challenge3.model.Item;

public class ListAdapter extends BaseAdapter {

    private ArrayList<Item> objects;

    public ListAdapter(){
        objects = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View converView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.row, null, false);

        ImageView rowPhoto = v.findViewById(R.id.list_iv);
        TextView listName = v.findViewById(R.id.list_name_tv);
        TextView creatorList = v.findViewById(R.id.creator_name_tv);
        TextView tracksNumber = v.findViewById(R.id.tracks_number_tv);



        listName.setText(objects.get(position).getTitle());
        creatorList.setText(objects.get(position).getUser().getName());
        tracksNumber.setText(""+objects.get(position).getNb_tracks());
        Picasso.get().load(objects.get(position).getPicture_small()).into(rowPhoto);
        return v;
    }

    public void setList(List<Item> list){
        objects = (ArrayList<Item>) list;
        notifyDataSetChanged();
    }
}
