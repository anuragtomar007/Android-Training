package com.railsfactory.anurag.androidlibrarytutorials;

/**
 * Created by anurag on 29/3/18.
 */

public class Events {
    public static class FragmentActivityMessage {

        private String message;

        public FragmentActivityMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static class ActivityFragmentMessage {

        private String message;

        public ActivityFragmentMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}