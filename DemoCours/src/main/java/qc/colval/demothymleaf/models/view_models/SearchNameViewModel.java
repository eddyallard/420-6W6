package qc.colval.demothymleaf.models.view_models;

public class SearchNameViewModel {
    private String firstname;

    public SearchNameViewModel(String firstname) {
        this.firstname = firstname;
    }

    public SearchNameViewModel() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "SearchNamesVM{" +
                "name='" + firstname + '\'' +
                '}';
    }
}
