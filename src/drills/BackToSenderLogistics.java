package drills;

public class BackToSenderLogistics {
    public static int calculateRidersPayment(int noOfDeliveries){
        if (noOfDeliveries < 50) return noOfDeliveries * 160 + 5_000;
        if (noOfDeliveries <= 59) return noOfDeliveries * 200 + 5_000;
        if (noOfDeliveries <= 69) return noOfDeliveries * 250 + 5_000;
        if (noOfDeliveries <=100) return noOfDeliveries * 500 + 5_000;
        return 0;
    }


    public static int calculateRidersPaymentTakeTwo(int noOfDeliveries) {
        int basePayment = 5000;
        int perDeliveryPayment;

        if (noOfDeliveries < 50) perDeliveryPayment = 160;
        else if (noOfDeliveries <= 59) perDeliveryPayment = 200;
        else if (noOfDeliveries <= 69) perDeliveryPayment = 250;
        else if (noOfDeliveries <= 100) perDeliveryPayment = 500;
        else return 0;

        return noOfDeliveries * perDeliveryPayment + basePayment;
    }

}
