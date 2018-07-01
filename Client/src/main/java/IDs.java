

public class IDs extends Model{

    private String userid;
    private String name;
    private String github;

    public IDs(String name, String github) {
        this.name = name;
        this.github = github;
    }

    public String getUserid() { return userid; }

    public void setUserid(String userId) {
        this.userid = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github_Id) {
        this.github = github_Id;
    }

    @Override
    public String toString() {
        return "Name: " + name + " githubId: " + github;
    }
}
