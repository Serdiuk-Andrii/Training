public final class Student {

    private final String name;
    private final String group;
    private final int age;
    private final Subject favouriteSubject;

    public Student(final String name, final String group, final int age, final Subject favouriteSubject) {

        this.name = name;
        this.group = group;
        this.age = age;
        this.favouriteSubject = favouriteSubject;
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public Subject getFavouriteSubject() {
        return favouriteSubject.clone();
    }

    @Override
    public int hashCode() {
        return ((31 * name.hashCode() + group.hashCode()) * 31 + age) * 31 + favouriteSubject.hashCode();
    }


    @Override
    public String toString() {
        return "Name: " + name + "\nGroup: " + group + "\nAge: " + age;
    }
}