package com.taipeizooplants.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class ViewPlantsInfo implements Parcelable {

    private String nameCh;
    private String nameEn;
    private String alsoKnow;
    private String brief;
    private String feature;
    private String function;
    private String lastUpdate;
    private String picUrl;

    public ViewPlantsInfo(String nameCh, String nameEn, String alsoKnow, String brief, String feature, String function, String lastUpdate, String picUrl) {
        this.nameCh = nameCh;
        this.nameEn = nameEn;
        this.alsoKnow = alsoKnow;
        this.brief = brief;
        this.feature = feature;
        this.function = function;
        this.lastUpdate = lastUpdate;
        this.picUrl = picUrl;
    }

    public String getNameCh() {
        return nameCh;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getAlsoKnow() {
        return alsoKnow;
    }

    public String getBrief() {
        return brief;
    }

    public String getFeature() {
        return feature;
    }

    public String getFunction() {
        return function;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public int getLastUpdateVisibility() {
        return lastUpdate.isEmpty() ? View.GONE : View.VISIBLE;
    }

    private ViewPlantsInfo(Parcel in) {
        nameCh = in.readString();
        nameEn = in.readString();
        alsoKnow = in.readString();
        brief = in.readString();
        feature = in.readString();
        function = in.readString();
        lastUpdate = in.readString();
        picUrl = in.readString();
    }

    public static final Creator<ViewPlantsInfo> CREATOR = new Creator<ViewPlantsInfo>() {
        @Override
        public ViewPlantsInfo createFromParcel(Parcel in) {
            return new ViewPlantsInfo(in);
        }

        @Override
        public ViewPlantsInfo[] newArray(int size) {
            return new ViewPlantsInfo[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameCh);
        dest.writeString(nameEn);
        dest.writeString(alsoKnow);
        dest.writeString(brief);
        dest.writeString(feature);
        dest.writeString(function);
        dest.writeString(lastUpdate);
        dest.writeString(picUrl);
    }
}
