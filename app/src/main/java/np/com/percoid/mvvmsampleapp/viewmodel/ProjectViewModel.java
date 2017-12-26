package np.com.percoid.mvvmsampleapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import np.com.percoid.mvvmsampleapp.service.model.Project;
import np.com.percoid.mvvmsampleapp.service.repository.ProjectRepository;

/**
 * Created by Subrat on 12/26/2017.
 */

public class ProjectViewModel extends AndroidViewModel {

    private static final String TAG = ProjectViewModel.class.getName();
    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        ABSENT.setValue(null);
    }

    private final LiveData<Project> projectObservable;
    private final MutableLiveData<String> projectID;

    public ObservableField<Project> project = new ObservableField<>();

    @Inject
    public ProjectViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super(application);
        this.projectID = new MutableLiveData<>();

        projectObservable = Transformations.switchMap(projectID,input -> {
            if (input.isEmpty()){
                Log.i(TAG, "ProjectViewModel projectID is absent!!!");
                return ABSENT;
            }

            Log.i(TAG, "ProjectViewModel projectID is " + projectID.getValue());
            return projectRepository.getProjectDetails("Google", projectID.getValue());
        });
    }
    public LiveData<Project> getObservableProject() {
        return projectObservable;
    }

    public void setProject(Project project) {
        this.project.set(project);
    }

    public void setProjectID(String projectID) {
        this.projectID.setValue(projectID);
    }
}
