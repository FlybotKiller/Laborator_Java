public class DartsPlayers implements Comparable<DartsPlayers>{
    private Integer id;
    private String nume_concurent;
    private String categorie;
    private String data_concursului;
    private Integer scor_total;
    private Integer ratare;
    private Integer premii_castigate;

    public DartsPlayers(Integer id, String nume_concurent, String categorie, String data_concursului, Integer scor_total, Integer ratare, Integer premii_castigate) {
        this.id = id;
        this.nume_concurent = nume_concurent;
        this.categorie = categorie;
        this.data_concursului = data_concursului;
        this.scor_total = scor_total;
        this.ratare = ratare;
        this.premii_castigate = premii_castigate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume_concurent() {
        return nume_concurent;
    }

    public void setNume_concurent(String nume_concurent) {
        this.nume_concurent = nume_concurent;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getData_concursului() {
        return data_concursului;
    }

    public void setData_concursului(String data_concursului) {
        this.data_concursului = data_concursului;
    }

    public Integer getScor_total() {
        return scor_total;
    }

    public void setScor_total(Integer scor_total) {
        this.scor_total = scor_total;
    }

    public Integer getRatare() {
        return ratare;
    }

    public void setRatare(Integer ratare) {
        this.ratare = ratare;
    }

    public Integer getPremii_castigate() {
        return premii_castigate;
    }

    public void setPremii_castigate(Integer premii_castigate) {
        this.premii_castigate = premii_castigate;
    }

    @Override
    public String toString() {
        return "DartsPlayers{" +
                "id=" + id +
                ", nume_concurent='" + nume_concurent + '\'' +
                ", categorie='" + categorie + '\'' +
                ", data_concursului='" + data_concursului + '\'' +
                ", scor_total=" + scor_total +
                ", ratare=" + ratare +
                ", premii_castigate=" + premii_castigate +
                '}';
    }

    @Override
    public int compareTo(DartsPlayers other_player) {
        return other_player.scor_total.compareTo(this.scor_total);
    }
}
