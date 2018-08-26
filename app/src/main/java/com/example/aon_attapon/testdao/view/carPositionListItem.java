package com.example.aon_attapon.testdao.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.aon_attapon.testdao.R;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class carPositionListItem extends BaseCustomViewGroup {

    TextView tvCarPositionId, tvPositionId, tvUserId, tvTime;

    public carPositionListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public carPositionListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public carPositionListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public carPositionListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.list_item_user, this);
    }

    private void initInstances() {
        // findViewById here
        tvCarPositionId = (TextView) findViewById(R.id.tvCarPositionId);
        tvPositionId = (TextView) findViewById(R.id.tvPositionId);
        tvUserId = (TextView) findViewById(R.id.tvUserId);
        tvTime = (TextView) findViewById(R.id.tvTime);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    public void setTvCarPositionId(int id){
        tvCarPositionId.setText(""+id);
    }

    public void setTvPositionId(int id){
        tvPositionId.setText(""+id);
    }

    public void setTvUserId(int id){
        tvUserId.setText(""+id);
    }

    public void setTvTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        tvTime.setText(sdf.format(date));
    }

//    public void setDate (TextView view){
//        String str = String.format("%tc", new Date());
//        view.setText(str);
//    }
}
