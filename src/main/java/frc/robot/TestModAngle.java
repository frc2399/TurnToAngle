package frc.robot;
public class TestModAngle {
    public static void main(String... args) {
        System.out.println("mod angle " + modAngle(360));
        System.out.println("mod angle " + modAngle(400));
        System.out.println("mod angle " + modAngle(200));
        System.out.println("mod angle " + modAngle(-100));
        System.out.println("mod angle " + modAngle(180));
        System.out.println("mod angle " + modAngle(-180));
    }

    public static double modAngle(double value) {
        return ((value + 180) % 360) - 180;
    }
}
