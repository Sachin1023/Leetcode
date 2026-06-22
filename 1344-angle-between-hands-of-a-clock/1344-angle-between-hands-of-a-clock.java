class Solution {
    public double angleClock(int hour, int minutes) {
       //movement caused by minute hand on hour hand
        double deltaExtraMovement= (double)minutes/60;
        int degreeBetweenEachHour=30;
        double extraMovement= deltaExtraMovement*degreeBetweenEachHour;
        // System.out.print(extraMovement);
        if(hour==12) hour=0;
        double movementbyHourHand= (hour*degreeBetweenEachHour) +extraMovement;
        double eachMinuteDegree = (double)360/60;
        double movementbyMinuteHand= minutes*eachMinuteDegree;
        // System.out.print("hour "+movementbyHourHand);
        // System.out.print("minute "+movementbyMinuteHand);
        // need to calculate angle from move 12 and 6 to find the minimum
        double anglefrom12=Math.abs(movementbyMinuteHand -movementbyHourHand);

        double otherAngle =Math.abs
        (angleFrom6(movementbyMinuteHand)-angleFrom6(movementbyHourHand));
        return Math.min(anglefrom12,otherAngle);
    }

    public double angleFrom6(double angle)
    {
        if(angle < 180)
            return 180+angle;
        else
            return angle-180;
    }
}