package com.lappers.view;

/**
 * Created by driftineo on 29/5/17.
 */
public enum UtilString {
    BESTTIMEFOUND     ("**********************\nbest time found for this car  \n**********************"),
    WORSTTIMEFOUND    ("**********************\nworst time found for this car \n**********************"),
    DOSOMETHING       ("**********************\nthis action will do something \n**********************"),
    DONOTHING         ("**********************\nthis action will do nothing   \n**********************"),
    ERROR             ("**********************\nCant do this                  \n**********************"),
    ONLYHAVEONETIME   ("**********************\nonly one time in board        \n**********************"),
    DELETED           ("**********************\n      Deleted                 \n**********************"),
    ONLYACEPTEDVALUES ("**********************\nOnly acepted values           \n**********************"),
    ONLYONEORTWOVALUES("**********************\nOnly '1' or '2'value          \n**********************");


    private final String string;

    UtilString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

}

