package tests;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

import businessModels.CollectionsModel;

public class CollectionsTesting {
	@Test
	public <T> void checkForDuplicates() {
		CollectionsModel test = new CollectionsModel();
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("1", "1", "3", "4"));
		Assert.assertFalse(test.hasDuplicate(list), "Array contain duplicates:");
	}
}
