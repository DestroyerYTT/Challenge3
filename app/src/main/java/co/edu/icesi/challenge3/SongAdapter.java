package co.edu.icesi.challenge3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.challenge3.model.Item;
import co.edu.icesi.challenge3.model.ItemComplete;
import co.edu.icesi.challenge3.model.Song;

public class SongAdapter extends BaseAdapter {

    private ArrayList<ItemComplete> objects;

    public SongAdapter(){
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

        return v;
    }

    public void setList(List<Song> songs){

        notifyDataSetChanged();
    }
}
