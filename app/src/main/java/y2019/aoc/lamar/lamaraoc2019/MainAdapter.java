package y2019.aoc.lamar.lamaraoc2019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] dayWord;

    public MainAdapter(Context context, String dayWord){
        this.context=context;
        this.dayWord=dayWord;
    }


    @Override
    public int getCount() {
        return dayWord.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null){
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null){
            convertView = inflater.inflate(R.layout.row_item,null);
        }
        TextView textView=convertView.findViewById(R.id.textView);

        textView.setText(dayWord[position]);

        return convertView;
    }
}
