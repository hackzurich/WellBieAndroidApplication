
package social.wellbe.wellbeapplication.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("terms_accepted_at")
    @Expose
    private Boolean termsAcceptedAt;
    @SerializedName("client_id")
    @Expose
    private String clientId;
    @SerializedName("client_secret")
    @Expose
    private String clientSecret;

    public User(String email, String password, Boolean termsAcceptedAt) {
        this.email = email;
        this.password = password;
        this.termsAcceptedAt = termsAcceptedAt;
        this.clientId = "yPomFOwElqDKvSDk82PuKipmo0LScIm4j_5H_zB5_KM";
        this.clientSecret = "MzUuHA6_DnNZme61VY2Zzc3mxqzS53H0iNGuqIcW6aE";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getTermsAcceptedAt() {
        return termsAcceptedAt;
    }

    public void setTermsAcceptedAt(Boolean termsAcceptedAt) {
        this.termsAcceptedAt = termsAcceptedAt;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

}
