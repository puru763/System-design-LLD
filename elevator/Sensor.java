public class Sensor {
    private boolean isdetectProblem;

    public Sensor() {
        this.isdetectProblem = false;
    }

    public void detectProblem() {
        // from sensor    get  all    the  details   and  we need to make   chnages  asa per  sendor  here
        if (isdetectProblem) {
            System.out.println("Obstruction detected! Cannot close doors.");
        } else {
            System.out.println("No obstruction detected. Doors can close.");
        }
    }

    public boolean isdetectProblem() {
        return isdetectProblem;
    }

    public void setdetectProblem(boolean problem) {
        this.isdetectProblem = problem;
    }
}
