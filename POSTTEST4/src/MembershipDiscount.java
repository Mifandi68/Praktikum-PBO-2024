public class MembershipDiscount {
    public static double calculateMembershipFee(String membershipType) {
        double fee = 0.0;
        switch (membershipType) {
            case "Bronze":
                fee = 50.0;
                break;
            case "Silver":
                fee = 75.0;
                break;
            case "Gold":
                fee = 100.0;
                break;
            default:
                System.out.println("Invalid membership type.");
        }
        return fee;
    }

    public static double calculateMembershipFee(String membershipType, double discountPercentage) {
        double baseFee = calculateMembershipFee(membershipType);
        double discountedFee = baseFee - (baseFee * discountPercentage / 100);
        return discountedFee;
    }
}
