package np.com.percoid.mvvmsampleapp.di;

import dagger.Subcomponent;
import np.com.percoid.mvvmsampleapp.viewmodel.ProjectListViewModel;
import np.com.percoid.mvvmsampleapp.viewmodel.ProjectViewModel;

/**
 * Created by Subrat on 12/26/2017.
 */

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder{
        ViewModelSubComponent build();
    }

    ProjectListViewModel projectListViewModel();
    ProjectViewModel projectViewModel();
}
