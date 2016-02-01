package com.devfestmn.bindingandroid.model;


import android.databinding.ObservableField;

public class SuperHeroPlain {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> alias = new ObservableField<>();
    public final ObservableField<Boolean> avenger = new ObservableField<>();
    public final ObservableField<String> firstAppearance = new ObservableField<>();
    public final ObservableField<String> imageUrl = new ObservableField<>();
}
