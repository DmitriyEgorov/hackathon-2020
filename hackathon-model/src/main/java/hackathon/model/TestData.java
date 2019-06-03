package hackathon.model;

/**
 * test data
 *
 * @author egorov
 * @since 03.06.2019
 */
public class TestData {

    private String data;

    public TestData() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestData testData = (TestData) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(data, testData.data)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(data)
                .toHashCode();
    }
}
