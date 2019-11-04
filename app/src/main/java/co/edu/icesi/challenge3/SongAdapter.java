package co.edu.icesi.challenge3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.icesi.challenge3.model.Item;
import co.edu.icesi.challenge3.model.ItemComplete;
import co.edu.icesi.challenge3.model.Song;

public class SongAdapter extends BaseAdapter {

    private ArrayList<Song> objects;

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
        ImageView rowPhoto = v.findViewById(R.id.list_iv);
        TextView listName = v.findViewById(R.id.list_name_tv);
        TextView artist = v.findViewById(R.id.creator_name_tv);
        TextView date = v.findViewById(R.id.tracks_number_tv);



        listName.setText(objects.get(position).getTitle());
        artist.setText(objects.get(position).getArtist().getName());
        long miliseconds = objects.get(position).getTime_add()*1000;
        Date addDate  = new Date(miliseconds);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date.setText(""+sdf.format(addDate));
        Picasso.get().load(objects.get(position).getAlbum().getCover_small()).into(rowPhoto);
        return v;
    }

    public void setList(List<Song> songs){
        objects = (ArrayList)songs;
        notifyDataSetChanged();
    }
}
