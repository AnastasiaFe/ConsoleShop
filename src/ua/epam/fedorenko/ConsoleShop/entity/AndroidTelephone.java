package ua.epam.fedorenko.ConsoleShop.entity;


public class AndroidTelephone extends Telephone {

    private String androidVersion;
    private boolean isDistanceSensorsExist;

    public AndroidTelephone(double price, double width, double height, int numberOfSimCards, String wayOfInput, String androidVersion, boolean isDistanceSensorsExist) {
        super(price, width, height, numberOfSimCards, wayOfInput);
        this.androidVersion = androidVersion;
        this.isDistanceSensorsExist = isDistanceSensorsExist;
    }

    public AndroidTelephone() {
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public boolean isDistanceSensorsExist() {
        return isDistanceSensorsExist;
    }

    public void setDistanceSensorsExist(boolean distanceSensorsExist) {
        isDistanceSensorsExist = distanceSensorsExist;
    }

    @Override
    public String toString() {
        return super.toString() + " AndroidTelephone{" + "androidVersion='" + androidVersion + '\'' + ", isDistanceSensorsExist=" + isDistanceSensorsExist + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        AndroidTelephone that = (AndroidTelephone) o;

        if (isDistanceSensorsExist != that.isDistanceSensorsExist) {
            return false;
        }
        return androidVersion.equals(that.androidVersion);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + androidVersion.hashCode();
        result = 31 * result + (isDistanceSensorsExist ? 1 : 0);
        return result;
    }
}
