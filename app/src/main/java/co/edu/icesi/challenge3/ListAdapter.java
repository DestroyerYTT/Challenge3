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

import java.net.URL;
import java.util.ArrayList;

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
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View converView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.row, null, false);
        final Item item = objects.get(position);

        ImageView rowPhoto = v.findViewById(R.id.list_iv);
        TextView listName = v.findViewById(R.id.list_name_tv);
        TextView creatorList = v.findViewById(R.id.creator_name_tv);
        TextView tracksNumber = v.findViewById(R.id.tracks_number_tv);

        try{
            URL url = new URL(item.getPicture_small());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            rowPhoto.setImageBitmap(bmp);
        }catch (Exception e){
            Log.e("Image Error", e.getStackTrace().toString());
        }

        listName.setText(item.getTitle());
        creatorList.setText(item.getCreatorName());

        return null;
    }
}
