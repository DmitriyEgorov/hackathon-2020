package hackathon.adapter;

import hackathon.db.model.TestDataEntity;
import hackathon.model.TestData;

/**
 * @author egorov
 * @since 03.06.2019
 */
public class TestDataAdapter {

    public static TestData adapt(TestDataEntity testDataEntity) {
        TestData testData = new TestData();
        testData.setData(testDataEntity.getData());
        return testData;
    }

}
