package com.example.aon_attapon.testdao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aon_attapon.testdao.R;
import com.example.aon_attapon.testdao.dao.carPositionCollection;
import com.example.aon_attapon.testdao.dao.carPositions;
import com.example.aon_attapon.testdao.util.Contextor;
import com.example.aon_attapon.testdao.view.carPositionListItem;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class CarPositionListAdapter extends BaseAdapter {

    carPositionCollection dao;

    public void setDao(carPositionCollection dao){
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if(dao == null)
            return 0;
        return dao.getCarPositions().size();
    }

    @Override
    public Object getItem(int position) {
//        return null;
        return dao.getCarPositions().get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        carPositionListItem item;
//        if (convertView != null) {
//            item = (carPositionListItem) convertView;
//        } else {
//            item = new carPositionListItem(parent.getContext());
//        }
//
//        carPositions dao = (carPositions) getItem(position);
//        item.setTvCarPositionId(dao.getCarId());
//        item.setTvPositionId(dao.getPositionId());
//        item.setTvUserId(dao.getUserId());
//        item.setTvTime(dao.getTimeCreated());
//
//        return convertView;
        if (convertView == null){
            convertView = new carPositionListItem(Contextor.getInstance().getContext());
        }
        carPositionListItem view = (carPositionListItem) convertView;
        carPositions positions = (carPositions) getItem(position);
        view.setTvCarPositionId(positions.getCarId());
        view.setTvPositionId(positions.getPositionId());
        view.setTvUserId(positions.getUserId());
        view.setTvTime(positions.getTimeCreated());

        return view;
    }
}
