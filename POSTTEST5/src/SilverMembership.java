import java.time.LocalDate;

public class SilverMembership extends Membership {
    public static final int DURATION = 3;

    public SilverMembership(int memberID, String tanggalMulai) {
        super(memberID, "Silver", tanggalMulai);
    }

    protected int getDuration() {
        return DURATION;
    }

    @Override
    protected final String calculateEndDate() {
        LocalDate startDate = LocalDate.parse(tanggalMulai);
        LocalDate endDate = startDate.plusMonths(getDuration());
        return endDate.toString();
    }
}
