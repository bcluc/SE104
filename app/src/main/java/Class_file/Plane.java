package Class_file;

public class Plane {
    private String Plane_Name;
    private String Plane_ID;
    private String Phone;
    private String Email;

    public void setPlane_Name(String plane_Name) {
        Plane_Name = plane_Name;
    }

    public void setPlane_ID(String plane_ID) {
        Plane_ID = plane_ID;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPlane_ID() {
        return Plane_ID;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getPlane_Name() {
        return Plane_Name;
    }


    public Plane(String plane_Name, String plane_id, String phone, String email) {
        Plane_Name = plane_Name;
        Plane_ID = plane_id;
        this.Phone = phone;
        Email = email;
    }
}
