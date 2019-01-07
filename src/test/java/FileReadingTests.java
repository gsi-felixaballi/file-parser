import common.model.PeopleTuple;
import io.factory.ProcessorFactory;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class FileReadingTests {

    private Path getSample() {
        final URL resource = FileReadingTests.class.getResource("data.txt");
        try {
            return new File(resource.toURI()).toPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void checkPeopleId() {
        final String personId1 = "25384390A";
        final String personId2 = "25384390-A";

        final String[] args1 = new String[]{Objects.requireNonNull(getSample()).toString(), "ID", personId1};
        final String[] args2 = new String[]{Objects.requireNonNull(getSample()).toString(), "ID", personId2};
        List output1 = ProcessorFactory.from(args1).create();
        List output2 = ProcessorFactory.from(args2).create();

        assert !output1.isEmpty() && output1.get(0) instanceof PeopleTuple;
        assert ((PeopleTuple) output1.get(0)).getId().equals(personId1);
        assert ((PeopleTuple) output2.get(0)).getId().equals(personId2);

    }

    @Test
    public void checkCity() {
        final String city = "BARCELONA";
        final String[] args = new String[]{Objects.requireNonNull(getSample()).toString(), "CITY", city};
        List output = ProcessorFactory.from(args).create();

        assert output.size() == 9;

        assert output.stream().allMatch(person -> ((PeopleTuple) person).getCity().equalsIgnoreCase(city));
    }
}
