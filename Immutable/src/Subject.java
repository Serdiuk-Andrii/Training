public class Subject implements Cloneable{

    public String name;

    public Subject(final String name) {
        this.name = name;
    }

    @Override
    public Subject clone() {
        return new Subject(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
