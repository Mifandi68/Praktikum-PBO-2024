import java.time.LocalDate;

public class BronzeMembership extends Membership {
    public static final int DURATION = 1;

    public BronzeMembership(int memberID, String tanggalMulai) {
        super(memberID, "Bronze", tanggalMulai);
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
