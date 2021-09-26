package social.wellbe.wellbeapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserData {

    @SerializedName("user")
    @Expose
    private User user;

    public UserData(User u){
        user=u;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
