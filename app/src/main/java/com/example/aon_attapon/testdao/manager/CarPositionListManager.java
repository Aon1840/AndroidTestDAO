package com.example.aon_attapon.testdao.manager;

import android.content.Context;

import com.example.aon_attapon.testdao.dao.carPositionCollection;

public class CarPositionListManager {
    private Context mContext;
    private carPositionCollection dao;

    public CarPositionListManager(){
        mContext = Contextor.getInstance().getContext();
    }

    public carPositionCollection getDao() {
        return dao;
    }

    public void setDao(carPositionCollection dao) {
        this.dao = dao;
    }

    public int getCount(){
        if (dao == null)
            return 0;
        if (dao.getCarPositions() == null)
            return 0;
        return dao.getCarPositions().size();
    }
}
