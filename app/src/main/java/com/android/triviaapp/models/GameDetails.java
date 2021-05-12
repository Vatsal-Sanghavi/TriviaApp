package com.android.triviaapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class GameDetails implements Parcelable {

    @Id(autoincrement = true)
    private Long gameId;

    @Property
    private String name;

    @Property
    private String question1;

    @Property
    private String answer1;

    @Property
    private String question2;

    @Property
    private String answer2;

    @Property
    private String attendDate;

    @Generated(hash = 1937816035)
    public GameDetails(Long gameId, String name, String question1, String answer1,
            String question2, String answer2, String attendDate) {
        this.gameId = gameId;
        this.name = name;
        this.question1 = question1;
        this.answer1 = answer1;
        this.question2 = question2;
        this.answer2 = answer2;
        this.attendDate = attendDate;
    }

    @Generated(hash = 6628684)
    public GameDetails() {
    }

    protected GameDetails(Parcel in) {
        if (in.readByte() == 0) {
            gameId = null;
        } else {
            gameId = in.readLong();
        }
        name = in.readString();
        question1 = in.readString();
        answer1 = in.readString();
        question2 = in.readString();
        answer2 = in.readString();
        attendDate = in.readString();
    }

    public static final Creator<GameDetails> CREATOR = new Creator<GameDetails>() {
        @Override
        public GameDetails createFromParcel(Parcel in) {
            return new GameDetails(in);
        }

        @Override
        public GameDetails[] newArray(int size) {
            return new GameDetails[size];
        }
    };

    public Long getGameId() {
        return this.gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion1() {
        return this.question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getAnswer1() {
        return this.answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getQuestion2() {
        return this.question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getAnswer2() {
        return this.answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAttendDate() {
        return this.attendDate;
    }

    public void setAttendDate(String attendDate) {
        this.attendDate = attendDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (gameId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(gameId);
        }
        dest.writeString(name);
        dest.writeString(question1);
        dest.writeString(answer1);
        dest.writeString(question2);
        dest.writeString(answer2);
        dest.writeString(attendDate);
    }
}
