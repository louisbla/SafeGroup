package dataBase.model;

import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class Member {

    // --- FIELDS ---

    private String user_id;
    private String group_id;
    private String member_Id;
    private String nameId;
    private String nameModifier;
    private Date last_Update;
    private int state;
    @Nullable
    private int state_Precision;
    private DatabaseReference mDatabase;

    // --- CONSTRUCTORS ---

    public Member(){
        this.member_Id=FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.nameModifier=FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        this.last_Update =new Date();
        this.state=0;
    }
    public Member(Member member,DatabaseReference mDatabase){
        this.user_id = member.getUser_Id();
        this.group_id = member.getGroup_Id();
        this.member_Id = member.getMember_Id();
        this.nameModifier=FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        this.last_Update = member.getLast_Update();
        this.state = member.getState();
        this.state_Precision = member.getState_Precision();
        this.mDatabase = mDatabase;
    }
    public Member(String member_Id,String user_Id,String nameId, String group_id, Date last_Update, int state, int state_Precision, double latitude, double longitude, DatabaseReference mDatabase) {
        this.user_id = user_Id;
        this.group_id = group_id;
        this.nameModifier=nameId ;
        this.member_Id=member_Id;
        this.last_Update = last_Update;
        this.state = state;
        this.state_Precision = state_Precision;
        this.mDatabase =mDatabase ;
    }


    // --- GETTERS ---

    public String getUser_Id() {        return user_id;    }
    public String getGroup_Id() {        return group_id;    }
    public String getMember_Id() {        return member_Id;    }
    public String getNameModifier()  {        return nameModifier;    }
    public Date getLast_Update() {        return last_Update;    }
    public int getState() {        return state;    }
    public int getState_Precision() {        return state_Precision;    }



    // --- SETTERS ---

    public void setMember_Id(String member_Id) {        this.member_Id = member_Id;    }
    public void setNameModifier(String nameModifier)  {        this.nameModifier=nameModifier;    }
    public void setUser_Id(String user_Id) {        this.user_id = user_Id;    }
    public void setGroup_Id(String group_id) {        this.group_id = group_id;    }
    public void setLast_Update(Date last_Update) {        this.last_Update = last_Update;    }
    public void setState(int state) {        this.state = state;    }
    public void setState_Precision(int state_Precision) {        this.state_Precision = state_Precision;    }


    // ---METHODS---


    // ---TO PUSH DATA in the DATABASE---

    public void pushMember_toDataBase(){
        mDatabase.child("members").child(this.group_id).setValue(this);
    }


}


