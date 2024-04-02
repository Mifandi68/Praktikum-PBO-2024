import java.time.LocalDate;

public class GoldMembership extends Membership {
    public static final int DURATION = 6;

    public GoldMembership(int memberID, String tanggalMulai) {
        super(memberID, "Gold", tanggalMulai);
    }

    protected int getDuration() {
        return DURATION;
    }

    @Override
    protected String calculateEndDate() {
        LocalDate startDate = LocalDate.parse(tanggalMulai);
        LocalDate endDate = startDate.plusMonths(getDuration());
        return endDate.toString();
    }
}
