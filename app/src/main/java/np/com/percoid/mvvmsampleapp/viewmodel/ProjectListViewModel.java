package np.com.percoid.mvvmsampleapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import np.com.percoid.mvvmsampleapp.service.model.Project;
import np.com.percoid.mvvmsampleapp.service.repository.ProjectRepository;

/**
 * Created by Subrat on 12/26/2017.
 */

public class ProjectListViewModel extends AndroidViewModel {

    private final LiveData<List<Project>> projectListObservable;

    @Inject
    public ProjectListViewModel(@NonNull Application application,ProjectRepository projectRepository) {
        super(application);
        this.projectListObservable = projectRepository.getProjectList("Google");
    }

    public LiveData<List<Project>> getProjectListObservable(){
        return projectListObservable;
    }
}
