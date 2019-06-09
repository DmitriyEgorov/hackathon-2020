package stub.db.adapter;

import hackathon.model.TestStubData;
import stub.db.model.TestStubDataEntity;

/**
 * @author Dmitriy
 * @since 09.06.2019
 */
public class TestStubDataAdapter {

    /**
     * adapt test stub data
     *
     * @return test stub data
     */
    public static TestStubData adapt(TestStubDataEntity testStubDataEntity) {
        TestStubData testStubData = new TestStubData();
        testStubData.setStubData(testStubDataEntity.getData());
        return testStubData;

    }
}
