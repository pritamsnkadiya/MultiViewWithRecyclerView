
package com.example.pritam.meenuapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MultiViewModel {

    @SerializedName("multiView")
    @Expose
    private List<MultiView> multiView = null;

    public List<MultiView> getMultiView() {
        return multiView;
    }

    public void setMultiView(List<MultiView> multiView) {
        this.multiView = multiView;
    }

    @Override
    public String toString() {
        return "MultiViewModel{" +
                "multiView=" + multiView +
                '}';
    }
}
