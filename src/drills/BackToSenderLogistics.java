package drills;

public class BackToSenderLogistics {
    public static int calculateRidersPayment(int noOfDeliveries){
        Integer noOfDeliveries1 = getCommissionPayment(noOfDeliveries);
        if (noOfDeliveries1 != null) return noOfDeliveries1;
        return 0;
    }

    private static Integer getCommissionPayment(int noOfDeliveries) {
        if (noOfDeliveries < 50) return noOfDeliveries * 160 + 5_000;
        if (noOfDeliveries <= 59) return noOfDeliveries * 200 + 5_000;
        if (noOfDeliveries <= 69) return noOfDeliveries * 250 + 5_000;
        if (noOfDeliveries <=100) return noOfDeliveries * 500 + 5_000;
        return null;
    }
}
