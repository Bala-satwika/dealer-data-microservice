package com.tvsmotor.dealerdata.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
@Document(collection = "Dealers") // Use the actual name of your MongoDB collection here
public class Dealer {
    @Id
    private String _id;
    private String dealerId;
    private String name;
    private String address;
    private double lat;
    private double lng;
    private String pincode;
    private double ratings;
    private String timings;
    private String category;
    private String phoneNumber;
    private String website;
    private String businessStatus;
    private String photoUrl;
    private String stateId;
    private String state;
    public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	private List<String> type; // Array field for types (sales, service, spares)
   
    // Constructor
    public Dealer() {}
    public Dealer(String _id,String dealerId, String name, String address, double lat, double lng, String pincode,
                      double ratings, String timings, String category, String phoneNumber, String website,
                      String businessStatus, String photoUrl, String StateId,  List<String> type, String state) {
        this._id = _id;
        this.dealerId=dealerId;
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.pincode = pincode;
        this.ratings = ratings;
        this.timings = timings;
        this.category = category;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.businessStatus = businessStatus;
        this.photoUrl = photoUrl;
        this.stateId=stateId;
        this.type = type;
        this.state = state;
    }
    // Getters and Setters
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String getDealerId() {
    	return dealerId;
    }
    public void setDealerId(String dealerId) {
    	this.dealerId=dealerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }
    public String getPincode() {
        return pincode;
    }
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    public double getRatings() {
        return ratings;
    }
    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
    public String getTimings() {
        return timings;
    }
    public void setTimings(String timings) {
        this.timings = timings;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getBusinessStatus() {
        return businessStatus;
    }
    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }
    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    public List<String> getType() {
        return type;
    }
    public void setType(List<String> type) {
        this.type = type;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}