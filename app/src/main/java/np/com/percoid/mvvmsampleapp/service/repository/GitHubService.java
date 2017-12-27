package np.com.percoid.mvvmsampleapp.service.repository;

import java.util.List;

import io.reactivex.Observable;
import np.com.percoid.mvvmsampleapp.service.model.Project;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Subrat on 12/26/2017.
 */

public interface GitHubService {
    String HTTPS_API_GITHUB_URL = "https://api.github.com/";

    @GET("users/{user}/repos")
    Observable<List<Project>> getProjectList(@Path("user") String user);

    @GET("/repos/{user}/{reponame}")
    Observable<Project> getProjectDetails(@Path("user") String user, @Path("reponame") String projectName);
}
