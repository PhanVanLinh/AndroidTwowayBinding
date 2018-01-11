package toong.vn.androidtwowaybinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Handler;
import android.util.Log;

/**
 * Created by PhanVanLinh on 11/01/2018.
 * phanvanlinh.94vn@gmail.com
 */

public class MainViewModel extends BaseObservable{
    private String TAG = getClass().getSimpleName();
    private String editTextContent;

    MainViewModel(){
        setADefaultATextAfterATime();
    }

    @Bindable
    public String getEditTextContent() {
        Log.i(TAG,"getEditTextContent "+editTextContent);
        return editTextContent;
    }

    /**
     * Use notifyPropertyChanged(BR.editTextContent);
     *
     MainViewModel: setEditTextContent h
     MainViewModel: getEditTextContent h
     MainViewModel: setEditTextContent hh
     MainViewModel: getEditTextContent hh
     *
     * Don't use notifyPropertyChanged(BR.editTextContent);
     MainViewModel: setEditTextContent h
     MainViewModel: setEditTextContent hh
     */
    public void setEditTextContent(String editTextContent) {
        Log.i(TAG,"setEditTextContent "+editTextContent);
        this.editTextContent = editTextContent;
//        notifyPropertyChanged(BR.editTextContent);
    }

    /**
     * If dont use notifyPropertyChanged(BR.editTextContent); edittext will not update
     MainViewModel: setEditTextContent ABC
     MainViewModel: getEditTextContent ABC
     MainViewModel: setEditTextContent ABC
     */
    private void setADefaultATextAfterATime(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setEditTextContent("ABC");
                notifyPropertyChanged(BR.editTextContent);
            }
        }, 3000);
    }
}
