package utility;

import entity.Dialog;

import java.util.Comparator;


public  class MyComparator implements Comparator<Dialog> {
    @Override
    public int compare(Dialog dialog, Dialog dialog2) {
        return dialog.getDate().compareTo(dialog2.getDate());
    }
}
