import com.luban.App;
import com.luban.properties.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest(classes = App.class)
public class SpringBootTest {
	@Autowired
	Student student;

	@Test
	public void test(){
		System.out.println(student);
	}


}
