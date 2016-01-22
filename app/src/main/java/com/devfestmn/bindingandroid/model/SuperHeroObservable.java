package com.devfestmn.bindingandroid.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.devfestmn.bindingandroid.BR;


public class SuperHeroObservable extends BaseObservable {
    String name;
    String alias;
    boolean avenger;
    String firstAppearance;
    String imageUrl;

    @Bindable
    public String getAlias() {
        return alias;
    }

    @Bindable
    public boolean isAvenger() {
        return avenger;
    }

    @Bindable
    public String getFirstAppearance() {
        return firstAppearance;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setAlias(String alias) {
        this.alias = alias;
        notifyPropertyChanged(BR.alias);
    }

    public void setAvenger(boolean avenger) {
        this.avenger = avenger;
        notifyPropertyChanged(BR.avenger);
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
        notifyPropertyChanged(BR.firstAppearance);
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
