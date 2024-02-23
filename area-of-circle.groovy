class Circle {
    double radius

    Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return radius * radius * Math.PI
    }

    String toString() {
        return "RADIUIS IS: " + this.radius + " AREA IS: " + calculateArea() + "\n"
    }
}
// print(this.args[0] + "\n")
// print(this.args[0].getClass())
Circle c = new Circle(this.args[0] as double)
print(c)