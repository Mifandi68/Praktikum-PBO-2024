import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Membership {
    protected int memberID;
    protected String jenisPaket;
    protected String tanggalMulai;
    protected String tanggalBerakhir;

    public static final int BRONZE_DURATION = 1;
    public static final int SILVER_DURATION = 3;
    public static final int GOLD_DURATION = 6;

    public Membership(int memberID, String jenisPaket, String tanggalMulai) {
        this.memberID = memberID;
        this.jenisPaket = jenisPaket;
        this.tanggalMulai = tanggalMulai;
        this.tanggalBerakhir = calculateEndDate();
    }

    protected abstract int getDuration();

    protected String calculateEndDate() {
        LocalDate startDate = LocalDate.parse(tanggalMulai, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = startDate.plusMonths(getDuration());
        return endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getJenisPaket() {
        return jenisPaket;
    }

    public void setJenisPaket(String jenisPaket) {
        this.jenisPaket = jenisPaket;
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
        this.tanggalBerakhir = calculateEndDate();
    }

    public String getTanggalBerakhir() {
        return tanggalBerakhir;
    }
}
