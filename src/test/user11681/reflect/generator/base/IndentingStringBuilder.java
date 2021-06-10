package user11681.reflect.generator.base;

public class IndentingStringBuilder {
    protected final StringBuilder builder = new StringBuilder();

    protected String indentation = "";

    public IndentingStringBuilder(String string) {
        this.builder.append(string);
    }

    public IndentingStringBuilder() {}

    public IndentingStringBuilder append(String string) {
        this.builder.append(string);

        return this;
    }

    public IndentingStringBuilder append(char character) {
        this.builder.append(character);

        return this;
    }

    public IndentingStringBuilder descend() {
        this.indentation += "    ";

        return this;
    }

    public IndentingStringBuilder ascend() {
        this.indentation = this.indentation.substring(4);

        return this;
    }

    public IndentingStringBuilder newline() {
        this.builder.append(this.newlineString());

        return this;
    }

    public String newlineString() {
        return '\n' + this.indentation;
    }

    @Override
    public String toString() {
        return this.builder.toString();
    }
}
