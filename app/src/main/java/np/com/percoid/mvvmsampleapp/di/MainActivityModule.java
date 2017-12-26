package np.com.percoid.mvvmsampleapp.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import np.com.percoid.mvvmsampleapp.view.ui.MainActivity;

/**
 * Created by Subrat on 12/26/2017.
 */

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
