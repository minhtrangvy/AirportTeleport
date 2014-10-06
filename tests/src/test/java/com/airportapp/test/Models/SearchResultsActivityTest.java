package com.airportapp.test.Models;

import android.app.Activity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.Robolectric;

import com.airportapp.SearchActivity;
import com.airportapp.test.MyRobolectricTestRunner;
import com.airportapp.SearchResultsActivity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MyRobolectricTestRunner.class)

public class SearchResultsActivityTest {
    @Before
    public void setup() {
        //do whatever is necessary before every test
    }

    @Test
    public void testActivityFound() {
        Activity activity = Robolectric.buildActivity(SearchResultsActivity.class).create().get();

        Assert.assertNotNull(activity);
    }
}
