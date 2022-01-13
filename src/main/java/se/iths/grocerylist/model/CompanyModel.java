package se.iths.grocerylist.model;

public class CompanyModel {


    private String companyName;

    public CompanyModel() {
    }

    public CompanyModel( String companyName) {

        this.companyName = companyName;
    }



    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "CompanyModel{" +

                ", companyName='" + companyName + '\'' +
                '}';
    }
}
