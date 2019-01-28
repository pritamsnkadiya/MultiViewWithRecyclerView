
package com.example.pritam.meenuapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("Total_Users_Count")
    @Expose
    private Integer totalUsersCount;
    @SerializedName("users")
    @Expose
    private List<User> users = null;

    public Integer getTotalUsersCount() {
        return totalUsersCount;
    }

    public void setTotalUsersCount(Integer totalUsersCount) {
        this.totalUsersCount = totalUsersCount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Result{" +
                "totalUsersCount=" + totalUsersCount +
                ", users=" + users +
                '}';
    }
}
