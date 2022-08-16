package sg.edu.rp.c346.id21011122.demoexport;

public class Export {
    public Export(String area, String domestic_exports, String year) {
        this.area = area;
        this.domestic_exports = domestic_exports;
        this.year = year;
    }

    String area;
    String domestic_exports;
    String year;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDomestic_exports() {
        return domestic_exports;
    }

    public void setDomestic_exports(String domestic_exports) {
        this.domestic_exports = domestic_exports;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Export{" +
                "area='" + area + '\'' +
                ", domestic_exports='" + domestic_exports + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}