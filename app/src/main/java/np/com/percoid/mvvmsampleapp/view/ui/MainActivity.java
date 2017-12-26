package np.com.percoid.mvvmsampleapp.view.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import np.com.percoid.mvvmsampleapp.R;
import np.com.percoid.mvvmsampleapp.service.model.Project;

public class MainActivity extends LifecycleActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add project list fragment if this is first creation
        if (savedInstanceState == null) {
            ProjectListFragment fragment = new ProjectListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, ProjectListFragment.TAG).commit();
        }
    }

    /** Shows the project detail fragment */
    public void show(Project project) {
        ProjectFragment projectFragment = ProjectFragment.forProject(project.name);

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("project")
                .replace(R.id.fragment_container,
                        projectFragment, null).commit();
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
