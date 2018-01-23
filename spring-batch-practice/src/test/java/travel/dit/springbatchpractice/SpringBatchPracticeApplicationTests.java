package travel.dit.springbatchpractice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBatchPracticeApplicationTests {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	private Person mockPerson;

	@InjectMocks
	private ItemProcessor personItemProcessor = new PersonItemProcessor();

	@Before
	public void setUp() {
		mockPerson = mockPersonObject();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMockCreation() {
		assertNotNull(personItemProcessor);
		assertNotNull(mockPerson);
	}

	@Test
	public void
			Given_Person_When_FirstNameAndLastNameHasLowerCaseLetters_Then_LettersAreCapitalized()

			throws Exception {
		String expectedFirstName = "JONATHAN";
		String expectedLastName = "PARK";
		Person processedPerson = (Person) personItemProcessor.process
				(mockPerson);
		assertNotNull("Processor returns null", processedPerson);
		assertEquals("First Name is not capitalized!", expectedFirstName,
		             processedPerson.getFirstName()
		             );
		assertEquals("Last name is not capitalized!", expectedLastName,
		             processedPerson.getLastName());
	}

	private Person mockPersonObject() {
		return new Person("Jonathan", "Park");
	}

}
