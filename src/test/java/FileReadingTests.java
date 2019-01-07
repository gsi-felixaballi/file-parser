import common.model.PeopleTuple;
import io.factory.ProcessorFactory;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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
    public void stress() {
        final String city = "BARCELONA";
        final String[] args = new String[]{getSample().toString(), "CITY", city};
        List output = ProcessorFactory.from(args).create();

        assert output.size() == 9;

        assert output.stream().allMatch(person -> ((ArrayList<PeopleTuple>) person).get(0).getCity().equalsIgnoreCase(city));
    }
}
