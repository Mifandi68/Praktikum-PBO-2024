public final class Member {
    private int memberID;
    private String nama;
    private int umur;
    private String alamat;
    private String jenisKelamin;
    private String nomorTelepon;

    // Konstruktor
    public Member(int memberID, String nama, int umur, String alamat, String jenisKelamin, String nomorTelepon) {
        this.memberID = memberID;
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.nomorTelepon = nomorTelepon;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
}
