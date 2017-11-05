package com.axis.vision.vision.fragments.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axis.vision.vision.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import agency.tango.materialintroscreen.SlideFragment;

/**
 * Created by Anas Alsaadi on 10/27/2017.
 */

public class Commercial extends SlideFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_commercial_slide, container, false);

        getActivity().findViewById(R.id.welcome_icon).setVisibility(view.INVISIBLE);
        getActivity().findViewById(R.id.welcomett).setVisibility(view.INVISIBLE);
        getActivity().findViewById(R.id.welcome_span).setVisibility(view.INVISIBLE);
        getActivity().findViewById(R.id.get_started).setVisibility(view.INVISIBLE);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        getActivity().findViewById(R.id.welcome_icon).setVisibility(view.VISIBLE);
                        YoYo.with(Techniques.Landing)
                                .duration(300)
                                .repeat(0)
                                .playOn(getActivity().findViewById(R.id.welcome_icon));
                    }
                },
                300);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        getActivity().findViewById(R.id.welcomett).setVisibility(view.VISIBLE);

                        YoYo.with(Techniques.Landing)
                                .duration(400)
                                .repeat(0)
                                .playOn(getActivity().findViewById(R.id.welcomett));
                    }
                },
                200);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        getActivity().findViewById(R.id.welcome_span).setVisibility(view.VISIBLE);

                        YoYo.with(Techniques.SlideInDown)
                                .duration(400)
                                .repeat(0)
                                .playOn(getActivity().findViewById(R.id.welcome_span));
                    }
                },
                400);


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        getActivity().findViewById(R.id.get_started).setVisibility(view.VISIBLE);
                        YoYo.with(Techniques.FadeIn)
                                .duration(1000)
                                .repeat(20)
                                .playOn(getActivity().findViewById(R.id.get_started));
                    }
                },
                600);
        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.colorBlack;
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

