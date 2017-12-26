package np.com.percoid.mvvmsampleapp.view.ui;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import np.com.percoid.mvvmsampleapp.R;
import np.com.percoid.mvvmsampleapp.databinding.FragmentProjectDetailsBinding;
import np.com.percoid.mvvmsampleapp.di.Injectable;
import np.com.percoid.mvvmsampleapp.service.model.Project;
import np.com.percoid.mvvmsampleapp.viewmodel.ProjectViewModel;

/**
 * Created by Subrat on 12/26/2017.
 */

public class ProjectFragment extends LifecycleFragment implements Injectable {
    private static final String KEY_PROJECT_ID = "project_id";
    private FragmentProjectDetailsBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate this data binding layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_details, container, false);

        // Create and set the adapter for the RecyclerView.
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ProjectViewModel viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(ProjectViewModel.class);

        viewModel.setProjectID(getArguments().getString(KEY_PROJECT_ID));

        binding.setProjectViewModel(viewModel);
        binding.setIsLoading(true);

        observeViewModel(viewModel);
    }

    private void observeViewModel(final ProjectViewModel viewModel) {
        // Observe project data
        viewModel.getObservableProject().observe(this, new Observer<Project>() {
            @Override
            public void onChanged(@Nullable Project project) {
                if (project != null) {
                    binding.setIsLoading(false);
                    viewModel.setProject(project);
                }
            }
        });
    }

    /** Creates project fragment for specific project ID */
    public static ProjectFragment forProject(String projectID) {
        ProjectFragment fragment = new ProjectFragment();
        Bundle args = new Bundle();

        args.putString(KEY_PROJECT_ID, projectID);
        fragment.setArguments(args);

        return fragment;
    }
}