package common.model;

public class Expression {

    private String expression;
    private int group;

    public Expression(String expression, int group) {
        this.expression = expression;
        this.group = group;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
