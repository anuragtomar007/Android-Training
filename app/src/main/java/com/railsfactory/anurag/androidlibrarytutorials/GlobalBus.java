package com.railsfactory.anurag.androidlibrarytutorials;

import com.squareup.otto.Bus;

/**
 * Created by anurag on 29/3/18.
 */

public class GlobalBus {
    private static Bus sBus;

    public static Bus getBus() {
        if (sBus == null)
            sBus = new Bus();
        return sBus;
    }
}
