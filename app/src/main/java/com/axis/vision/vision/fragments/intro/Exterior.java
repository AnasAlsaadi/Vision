package com.axis.vision.vision.fragments.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axis.vision.vision.R;

import agency.tango.materialintroscreen.SlideFragment;

/**
 * Created by Anas Alsaadi on 10/27/2017.
 */

public class Exterior extends SlideFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_exterior_slide, container, false);

        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.colorGoldenTextDark;
    }

    @Override
    public int buttonsColor() {
        return R.color.colorGoldenTextDark;
    }

    @Override
    public boolean canMoveFurther() {
        return true;
    }

    @Override
    public String cantMoveFurtherErrorMessage() {
        return "eroor";
    }
}

