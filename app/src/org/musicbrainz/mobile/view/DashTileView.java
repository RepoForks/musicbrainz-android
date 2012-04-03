package org.musicbrainz.mobile.view;

import org.musicbrainz.mobile.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DashTileView extends RelativeLayout {
    
    private ImageView icon;
    private TextView text;
    
    public DashTileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_dash_tile, this);
    }
    
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundResource(R.drawable.dash_grid);
        setOnTouchListener(touchListener);
        icon = (ImageView) findViewById(R.id.dash_tile_icon);
        text = (TextView) findViewById(R.id.dash_tile_text);
    }
    
    public void setIcon(int drawableId) {
        icon.setImageResource(drawableId);
    }
    
    public void setText(int stringId) {
        text.setText(stringId);
    }
    
    OnTouchListener touchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                icon.setPressed(true);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                icon.setPressed(false);
            }
            return false;
        }
    };
    
}
