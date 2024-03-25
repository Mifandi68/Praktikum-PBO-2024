import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Membership {
    int memberID;
    String jenisPaket;
    String tanggalMulai;
    String tanggalBerakhir;
    
    public static final String GOLD = "Gold";
    public static final String SILVER = "Silver";
    public static final String BRONZE = "Bronze";
    
    public static final int BRONZE_DURATION = 1;
    public static final int SILVER_DURATION = 3;
    public static final int GOLD_DURATION = 6;
    
    public Membership(int memberID, String jenisPaket, String tanggalMulai) {
        this.memberID = memberID;
        this.jenisPaket = jenisPaket;
        this.tanggalMulai = tanggalMulai;
        this.tanggalBerakhir = calculateEndDate(tanggalMulai, jenisPaket);
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
    }

    public String getTanggalBerakhir() {
        return tanggalBerakhir;
    }

    public void setTanggalBerakhir(String tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
    }

    private String calculateEndDate(String tanggalMulai, String jenisPaket) {
        LocalDate startDate = LocalDate.parse(tanggalMulai, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = startDate.plusMonths(getDuration(jenisPaket));
        return endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    
    private int getDuration(String jenisPaket) {
        switch (jenisPaket) {
            case GOLD:
                return GOLD_DURATION;
            case SILVER:
                return SILVER_DURATION;
            case BRONZE:
            default:
                return BRONZE_DURATION;
        }
    }
    
    public static String[] getAvailablePaket() {
        return new String[]{GOLD, SILVER, BRONZE};
    }
}
