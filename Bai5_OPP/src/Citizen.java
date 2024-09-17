public class Citizen {
    private String id;
    private String name;
    private Short year;
    private String gender;
    private String nation;
    // Constructor
    public Citizen(String id, String name, Short year, String gender, String nation) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.nation = nation;
    }
    // Getter and Setter
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    // Override'

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Citizen{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", year=").append(year);
        sb.append(", gender=").append(gender);
        sb.append(", nation=").append(nation);
        sb.append('}');
        return sb.toString();
    }
}
