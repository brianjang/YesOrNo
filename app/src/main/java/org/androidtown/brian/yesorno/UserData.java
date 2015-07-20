package org.androidtown.brian.yesorno;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by brian on 15. 7. 20..
 */
public class UserData implements Parcelable {
    private String mUsername;

    public UserData(String msg) {
        this.mUsername = msg;
    }

    public String getUsername() {
        return mUsername;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mUsername);
    }

    protected UserData(Parcel in) {
        this.mUsername = in.readString();
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        public UserData createFromParcel(Parcel source) {
            return new UserData(source);
        }

        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };
}
