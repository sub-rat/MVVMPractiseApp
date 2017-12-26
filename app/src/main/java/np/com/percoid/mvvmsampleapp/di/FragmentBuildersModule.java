package np.com.percoid.mvvmsampleapp.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import np.com.percoid.mvvmsampleapp.view.ui.ProjectFragment;
import np.com.percoid.mvvmsampleapp.view.ui.ProjectListFragment;

/**
 * Created by Subrat on 12/26/2017.
 */

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract ProjectFragment contributeProjectFragment();

    @ContributesAndroidInjector
    abstract ProjectListFragment contributeProjectListFragment();
}
