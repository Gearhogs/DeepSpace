package frc.robot.swerve;

public class SwingCalculations {
    double length;
    double width;
    Double[] SwerveModuleDimensions = new Double[8];

    public void SetDimensions(double length, double width){
        this.length = length;
        this.width = width;
        SwerveModuleDimensions[0] = -length/2;
        SwerveModuleDimensions[1] = width/2;
        SwerveModuleDimensions[2] = length/2;
        SwerveModuleDimensions[3] = width/2;
        SwerveModuleDimensions[4] = -length/2;
        SwerveModuleDimensions[5] = -width/2;
        SwerveModuleDimensions[6] = length/2;
        SwerveModuleDimensions[7] = -width/2;
    }
	public double CalculateSwerveAngles(double x, double y, SwervePosition position) {
        double a;
        double b;
        double A;
        double B;
        switch(position) {
            case FRONTLEFT:
                a = SwerveModuleDimensions[0];
                b = SwerveModuleDimensions[1];
                break;
            case FRONTRIGHT:
                a = SwerveModuleDimensions[2];
                b = SwerveModuleDimensions[3];
                break;
            case BACKLEFT:
                a = SwerveModuleDimensions[4];
                b = SwerveModuleDimensions[5];
                break;
            case BACKRIGHT:
                a = SwerveModuleDimensions[6];
                b = SwerveModuleDimensions[7];
                break;
            default:
                a = 0;
                b = 0;
                break;
        }
        A = x + a;
        B = y + b;
        double angle = Math.atan2(B,A);
		return 90 - angle;
    }

    public Double[] SwerveAngles(double x, double y) {
        Double[] finalAngles = new Double[4];
        finalAngles[0] = CalculateSwerveAngles(x, y, SwervePosition.FRONTLEFT);
        finalAngles[1] = CalculateSwerveAngles(x, y, SwervePosition.FRONTRIGHT);
        finalAngles[2] = CalculateSwerveAngles(x, y, SwervePosition.BACKLEFT);
        finalAngles[3] = CalculateSwerveAngles(x, y, SwervePosition.BACKRIGHT);
        return finalAngles;
    }
    public Double[] SwerveAngles(double r) {
        Double[] finalAngles = new Double[4];
        finalAngles[0] = CalculateSwerveAngles(r, 0, SwervePosition.FRONTLEFT);
        finalAngles[1] = CalculateSwerveAngles(r, 0, SwervePosition.FRONTRIGHT);
        finalAngles[2] = CalculateSwerveAngles(r, 0, SwervePosition.BACKLEFT);
        finalAngles[3] = CalculateSwerveAngles(r, 0, SwervePosition.BACKRIGHT);
        return finalAngles;
    }
    
    
}
