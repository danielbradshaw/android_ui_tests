package com.dnsmobile.expandcategories;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ImageView.ScaleType;
import android.widget.TableLayout.LayoutParams;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * sections. We use a {@link android.support.v4.app.FragmentPagerAdapter} derivative, which will
     * keep every loaded fragment in memory. If this becomes too memory intensive, it may be best
     * to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding tab.
        // We can also use ActionBar.Tab#select() to do this if we have a reference to the
        // Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by the adapter.
            // Also specify this Activity object, which implements the TabListener interface, as the
            // listener for when this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new DummySectionFragment();
            Bundle args = new Bundle();
            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return getString(R.string.title_section1).toUpperCase();
                case 1: return getString(R.string.title_section2).toUpperCase();
                case 2: return getString(R.string.title_section3).toUpperCase();
            }
            return null;
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {
        public DummySectionFragment() {
        }

        public static final String ARG_SECTION_NUMBER = "section_number";
        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
//            TextView textView = new TextView(getActivity());
//            textView.setGravity(Gravity.CENTER);
//            Bundle args = getArguments();
//            textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
            
            final LinearLayout categoriesLayout = (LinearLayout)inflater.inflate(R.layout.categories, container,false);
//            categoriesLayout.addView(createImageButton());
//            categoriesLayout.addView(createImageButton());
//            categoriesLayout.addView(createImageButton());
//            categoriesLayout.addView(createImageButton());
            final ImageButton imgButton = (ImageButton)categoriesLayout.findViewById(R.id.imageButton1);
            imgButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					((ImageButton)categoriesLayout.findViewById(R.id.imageButton2)).setVisibility(ImageButton.GONE);
					((ImageButton)categoriesLayout.findViewById(R.id.imageButton3)).setVisibility(ImageButton.GONE);
					((ImageButton)categoriesLayout.findViewById(R.id.imageButton4)).setVisibility(ImageButton.GONE);
//					imgButton.animate().scaleXBy(200.0f);
//					imgButton.invalidate();
					
//					PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("weightSum", .5f);
////					PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", 100f);
//					ObjectAnimator.ofPropertyValuesHolder(imgButton, pvhX).start();
					
//					float weight = categoriesLayout.getWeightSum();
//					ObjectAnimator anim = ObjectAnimator.ofFloat(categoriesLayout, "weightSum", weight, 3.5f);
//					anim.addUpdateListener(new AnimatorUpdateListener() {
//						@Override
//						public void onAnimationUpdate(ValueAnimator animation) {
////							categoriesLayout.requestLayout();
//						}
//					});
//					anim.start();
				}
			});
            
            return categoriesLayout;
        }
        
        
        
        private ImageButton createImageButton() {
        	ImageButton imageButton = new ImageButton(this.getActivity());
            imageButton.setBackgroundResource(R.drawable.ic_launcher);
            LayoutParams layoutParams = new LayoutParams(
            		LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            imageButton.setLayoutParams(layoutParams);
            imageButton.setScaleType(ImageButton.ScaleType.CENTER);
            return imageButton;
        }
    }
}
