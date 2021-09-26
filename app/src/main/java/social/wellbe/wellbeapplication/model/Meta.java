
package social.wellbe.wellbeapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("max_stress_level")
    @Expose
    private Object maxStressLevel;
    @SerializedName("average_stress_level")
    @Expose
    private Integer averageStressLevel;
    @SerializedName("min_stress_level")
    @Expose
    private Object minStressLevel;

    public Object getMaxStressLevel() {
        return maxStressLevel;
    }

    public void setMaxStressLevel(Object maxStressLevel) {
        this.maxStressLevel = maxStressLevel;
    }

    public Integer getAverageStressLevel() {
        return averageStressLevel;
    }

    public void setAverageStressLevel(Integer averageStressLevel) {
        this.averageStressLevel = averageStressLevel;
    }

    public Object getMinStressLevel() {
        return minStressLevel;
    }

    public void setMinStressLevel(Object minStressLevel) {
        this.minStressLevel = minStressLevel;
    }

}
