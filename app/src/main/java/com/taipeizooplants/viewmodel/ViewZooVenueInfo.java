package com.taipeizooplants.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.AppController;

public class ViewZooVenueInfo implements Parcelable {

    private String name;
    private String info;
    private String memo;
    private String category;
    private String picUrl;
    private String webUrl;

    public ViewZooVenueInfo(String name, String info, String memo, String category, String picUrl, String webUrl) {
        this.name = name;
        this.info = info;
        this.memo = memo;
        this.category = category;
        this.picUrl = picUrl;
        this.webUrl = webUrl;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getMemo() {
        return memo;
    }

    public String getCategory() {
        return category;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void openWebWithBrowser() {
        AppController.getInstance().openWebWithNativeBrowser(webUrl);
    }

    private ViewZooVenueInfo(Parcel in) {
        name = in.readString();
        info = in.readString();
        memo = in.readString();
        category = in.readString();
        picUrl = in.readString();
        webUrl = in.readString();
    }

    public static final Creator<ViewZooVenueInfo> CREATOR = new Creator<ViewZooVenueInfo>() {
        @Override
        public ViewZooVenueInfo createFromParcel(Parcel in) {
            return new ViewZooVenueInfo(in);
        }

        @Override
        public ViewZooVenueInfo[] newArray(int size) {
            return new ViewZooVenueInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(info);
        dest.writeString(memo);
        dest.writeString(category);
        dest.writeString(picUrl);
        dest.writeString(webUrl);
    }
}
