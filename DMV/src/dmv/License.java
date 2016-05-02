package dmv;

public class License {
    private String number;
    private String type;
    private String expiration;
    private String issued;
    private String status;
    private int points;
    private int whenTO;
    private Person p;

    public License(Person p, String number, String type, String expiration, String issued, int points) {
        this.p = p;
        this.number = number;
        this.type = type;
        this.expiration = expiration;
        this.issued = issued;
        this.status = points >= 8 ? "Revoked" : (points >= 4 ? "Suspended" : "Good");
        this.points = points;
        this.whenTO = 21 - (2016 - Integer.valueOf(p.getDob().substring(p.getDob().length() - 4, p.getDob().length())));
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiration() {
        return this.expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getIssued() {
        return this.issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public int getWhenTO() {
        return this.whenTO;
    }

    public void setWhenTO(int whenTO) {
        this.whenTO = whenTO;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Person getPerson() {
        return this.p;
    }

    public void setPerson(Person p) {
        this.p = p;
    }

    public String toString() {
        return this.p + "\nNumber = " + this.number + ",   Type = " + this.type + ",   Status = " + this.status + ",   Points = " + this.points + ",\nYears Till 21 = " + this.whenTO + ",   Issued = " + this.issued + ",   Expiration = " + this.expiration;
    }
}